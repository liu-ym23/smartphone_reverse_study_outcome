package com.facebook.soloader;

import android.content.Context;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class NativeDeps {
    private static final float HASHMAP_LOAD_FACTOR = 1.0f;
    private static final int INITIAL_HASH = 5381;
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_PREFIX_SUFFIX_LEN = 0;
    private static final int LIB_SUFFIX_LEN = 3;
    private static final String LOG_TAG = "NativeDeps";
    private static final int WAITING_THREADS_WARNING_THRESHOLD = 3;

    @Nullable
    private static byte[] sEncodedDeps;
    private static volatile boolean sInitialized;
    private static Map<Integer, List<Integer>> sPrecomputedDeps;
    private static List<Integer> sPrecomputedLibs;
    private static volatile boolean sUseDepsFileAsync;
    private static final ReentrantReadWriteLock sWaitForDepsFileLock = null;

    static {
        LIB_PREFIX_SUFFIX_LEN = 3 + 3;
        sWaitForDepsFileLock = new ReentrantReadWriteLock();
    }

    public NativeDeps() {
    }

    private static void verifyUninitialized() {
        if (sInitialized == true) goto L6;
        return;
    L6:
        monitor-enter(NativeDeps.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (sInitialized == true) goto L12;
        monitor-exit(NativeDeps.class);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");     // Catch: Throwable -> L13
    }

    public static /* synthetic */ ReentrantReadWriteLock access$000() {
        return sWaitForDepsFileLock;
    }

    public static /* synthetic */ boolean access$102(boolean r100) {
        sUseDepsFileAsync = r100;
        return r100;
    }

    @Nullable
    private static String[] awaitGetDepsFromPrecomputedDeps(String r100) {
        if (sInitialized == false) goto L7;
        return tryGetDepsFromPrecomputedDeps(r100);
    L7:
        if (sUseDepsFileAsync == false) goto L15;
        ReentrantReadWriteLock r101 = sWaitForDepsFileLock;
        r101.readLock().lock();
        String[] r102 = tryGetDepsFromPrecomputedDeps(r100);     // Catch: Throwable -> L12
        r101.readLock().unlock();
        return r102;
    L12:
        th = move-exception;
        sWaitForDepsFileLock.readLock().unlock();
        throw th;
    L15:
        return null;
    }

    @Nullable
    private static String getLibString(int r100) {
        if (r100 < sPrecomputedLibs.size()) goto L6;
        return null;
    L6:
        int r101 = sPrecomputedLibs.get(r100).intValue();
        int r102 = r101;
    L7:
        byte[] r103 = sEncodedDeps;
        if (r102 >= r103.length) goto L12;
        if (r103[r102] <= 32) goto L12;
        r102 = r102 + 1;
    L12:
        int r104 = (r102 - r101) + LIB_PREFIX_SUFFIX_LEN;
        char[] r105 = new char[r104];
        int r106 = 0;
        r105[0] = Symlink.UNIX_ID;
        r105[1] = 'i';
        r105[2] = BlockDevice.UNIX_ID;
    L14:
        if (r106 >= (r104 - LIB_PREFIX_SUFFIX_LEN)) goto L16;
        r105[LIB_PREFIX_LEN + r106] = (char) sEncodedDeps[r101 + r106];
        r106 = r106 + 1;
        goto L14
    L16:
        r105[r104 - 3] = '.';
        r105[r104 - 2] = 's';
        r105[r104 - 1] = 'o';
        return new String(r105);
    }

    private static int getOffsetForLib(String r100) {
        int r101 = hashLib(r100);
        List<Integer> r102 = sPrecomputedDeps.get(Integer.valueOf(r101));
        if (r102 != null) goto L5;
        return -1;
    L5:
        Iterator<Integer> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        int r104 = r103.next().intValue();
        if (libIsAtOffset(r100, r104) == false) goto L7;
        return r104;
    L11:
        return -1;
    }

    private static int hashLib(String r100) {
        int r101 = LIB_PREFIX_LEN;
        int r102 = INITIAL_HASH;
    L4:
        if (r101 >= (r100.length() - LIB_SUFFIX_LEN)) goto L6;
        int r103 = (r102 << 5) + r102;
        r102 = r100.codePointAt(r101) + r103;
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    @Nullable
    public static String[] tryGetDepsFromPrecomputedDeps(String r100) {
        if (sInitialized == true) goto L6;
        return null;
    L6:
        if (r100.length() > LIB_PREFIX_SUFFIX_LEN) goto L8;
        return null;
    L8:
        int r101 = getOffsetForLib(r100);
        if (r101 != (-1)) goto L12;
        return null;
    L12:
        return getDepsForLibAtOffset(r101, r100.length());
    }

    public static /* synthetic */ boolean access$200(Context r100, boolean r101) {
        return useDepsFileFromApkSync(r100, r101);
    }

    private static int findNextLine(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L8;
        if (r100[r101] == 10) goto L8;
        r101 = r101 + 1;
    L8:
        if (r101 < r100.length) goto L10;
        return r101;
    L10:
        return r101 + 1;
    }

    public static String[] getDependencies(String r100, ElfByteChannel r101) throws IOException {
        String[] r102 = awaitGetDepsFromPrecomputedDeps(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return MinElf.extract_DT_NEEDED(r101);
    }

    @Nullable
    private static String[] getDepsForLibAtOffset(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = (r100 + r101) - LIB_PREFIX_SUFFIX_LEN;
        int r104 = 0;
        boolean r105 = false;
    L3:
        byte[] r106 = sEncodedDeps;
        if (r103 >= r106.length) goto L22;
        byte r107 = r106[r103];
        if (r107 == 10) goto L22;
        if (r107 != 32) goto L15;
        if (r105 == false) goto L20;
        String r108 = getLibString(r104);
        if (r108 == null) goto L12;
        r102.add(r108);
        r104 = 0;
        r105 = false;
        goto L20
    L12:
        return null;
    L20:
        r103 = r103 + 1;
        goto L3
    L15:
        if (r107 < 48) goto L21;
        if (r107 > 57) goto L21;
        r104 = (r104 * 10) + (r107 - 48);
        r105 = true;
    L21:
        return null;
    L22:
        if (r105 == false) goto L28;
        String r109 = getLibString(r104);
        if (r109 != null) goto L26;
        return null;
    L26:
        r102.add(r109);
    L28:
        if (r102.size() != 0) goto L31;
        return null;
    L31:
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    private static void indexDepsBytes(byte[] r100, int r101) {
        boolean r102 = true;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r102 == false) goto L27;
        r103 = INITIAL_HASH;
        int r105 = r101;
    L25:
        byte r106 = r100[r105];     // Catch: IndexOutOfBoundsException -> L12
        if (r106 <= 32) goto L8;
        r103 = ((r103 << 5) + r103) + r106;     // Catch: IndexOutOfBoundsException -> L12
        r105 = r105 + 1;     // Catch: IndexOutOfBoundsException -> L12
        goto L25
    L8:
        indexLib(r103, r101);     // Catch: IndexOutOfBoundsException -> L12
        if (r106 == 32) goto L11;
        r102 = true;
    L18:
        int r107 = r105 + 1;
        r104 = r101;
        r101 = r107;
        goto L3
    L11:
        r102 = false;
    L20:
        if (r102 == true) goto L22;
        return;
    L22:
        if (r101 == r100.length) goto L35;
        indexLib(r103, r101);
        return;
    L35:
        return;
    L27:
        if (r100[r101] == 10) goto L17;
        r101 = r101 + 1;
        goto L27
    L17:
        r102 = true;
        int r108 = r104;
        r105 = r101;
        r101 = r108;
    L19:
        r101 = r104;
        goto L20
    }

    private static void indexLib(int r100, int r101) {
        sPrecomputedLibs.add(Integer.valueOf(r101));
        List<Integer> r102 = sPrecomputedDeps.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        r102 = new ArrayList();
        sPrecomputedDeps.put(Integer.valueOf(r100), r102);
    L5:
        r102.add(Integer.valueOf(r101));
    }

    private static boolean initDeps(Context r100, boolean r101) throws IOException {
        verifyUninitialized();
        if (r101 == false) goto L5;
        byte[] r102 = SysUtil.makeApkDepBlock(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir), r100);
        byte[] r103 = NativeDepsUnpacker.readNativeDepsFromDisk(r100);
    L7:
        return processDepsBytes(r102, r103);
    L5:
        r103 = NativeDepsUnpacker.readNativeDepsFromApk(r100);
        r102 = null;
        goto L7
    }

    private static boolean libIsAtOffset(String r100, int r101) {
        int r102 = LIB_PREFIX_LEN;
    L3:
        int r103 = r100.length();
        int r104 = LIB_SUFFIX_LEN;
        if (r102 >= (r103 - r104)) goto L12;
        if (r101 >= sEncodedDeps.length) goto L12;
        if ((r100.codePointAt(r102) & 255) != sEncodedDeps[r101]) goto L12;
        r102 = r102 + 1;
        r101 = r101 + 1;
    L12:
        if (r102 != (r100.length() - r104)) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean processDepsBytes(byte[] r100, byte[] r101) throws IOException {
        if (r100 == null) goto L7;
        int r102 = verifyBytesAndGetOffset(r100, r101);
        if (r102 != (-1)) goto L8;
        return false;
    L8:
        int r103 = findNextLine(r101, r102);
        if (r103 < r101.length) goto L11;
        return false;
    L11:
        int r104 = parseLibCount(r101, r102, (r103 - r102) - 1);
        if (r104 > 0) goto L14;
        return false;
    L14:
        sPrecomputedDeps = new HashMap(((int) (r104 / 1.0f)) + 1, 1.0f);
        sPrecomputedLibs = new ArrayList(r104);
        indexDepsBytes(r101, r103);
        if (sPrecomputedLibs.size() == r104) goto L17;
        return false;
    L17:
        sEncodedDeps = r101;
        sInitialized = true;
        return true;
    L7:
        r102 = 0;
        goto L8
    }

    private static boolean useDepsFileFromApkSync(Context r100, boolean r101) {
        boolean r102 = initDeps(r100, r101);     // Catch: IOException -> L4
    L5:
        if (r102 == true) goto L14;
        if (r101 == false) goto L15;
        NativeDepsUnpacker.ensureNativeDepsAvailable(r100);     // Catch: IOException -> L9
        return initDeps(r100, r101);
    L16:
        return r102;
    L15:
        return r102;
    L14:
        return r102;
    L4:
        r102 = false;
        goto L5
    }

    private static int verifyBytesAndGetOffset(@Nullable byte[] r100, @Nullable byte[] r101) {
        if (r100 != null) goto L5;
    L22:
        return -1;
    L5:
        if (r100.length == 0) goto L22;
        if (r101.length >= (r100.length + 4)) goto L10;
        return -1;
    L10:
        int r102 = ByteBuffer.wrap(r101, r100.length, 4).getInt();
        if (r101.length == ((r100.length + 4) + r102)) goto L13;
        return -1;
    L13:
        int r103 = 0;
    L15:
        if (r103 >= r100.length) goto L21;
        if (r100[r103] != r101[r103]) goto L18;
        r103 = r103 + 1;
        goto L15
    L18:
        return -1;
    L21:
        return r100.length + 4;
    }

    public static String[] getDependencies(String r100, File r101) throws IOException {
        String[] r102 = awaitGetDepsFromPrecomputedDeps(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return MinElf.extract_DT_NEEDED(r101);
    }

    private static int parseLibCount(byte[] r100, int r101, int r102) {
        return Integer.parseInt(new String(r100, r101, r102));
    L4:
        return -1;
    }

    public static boolean useDepsFile(final Context r100, boolean r101, final boolean r102) {
        if (r101 == false) goto L4;
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(r100, r102), "soloader-nativedeps-init"));
        return true;
    L4:
        return useDepsFileFromApkSync(r100, r102);
    }
}
