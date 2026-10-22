package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public class SoLoader {
    static final boolean DEBUG = false;
    private static final String[] DEFAULT_DENY_LIST = null;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_DIRECT_SOSOURCE = 64;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_EXPLICITLY_ENABLE_BACKUP_SOSOURCE = 128;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING = false;
    static final String TAG = "SoLoader";
    private static int sAppType;

    @Nullable
    private static ApplicationSoSource sApplicationSoSource;

    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = null;
    private static final HashSet<String> sLoadedLibraries = null;
    private static final Map<String, Object> sLoadingLibraries = null;

    @Nullable
    static SoFileLoader sSoFileLoader;

    @Nullable
    private static volatile SoSource[] sSoSources;
    private static final ReentrantReadWriteLock sSoSourcesLock = null;
    private static final AtomicInteger sSoSourcesVersion = null;

    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;

    public interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    public static class TestOnlyUtils {
        public TestOnlyUtils() {
        }

        public static void resetStatus() {
            monitor-enter(SoLoader.class);
            SoLoader.access$300().clear();     // Catch: Throwable -> L8
            SoLoader.access$400().clear();     // Catch: Throwable -> L8
            SoLoader.sSoFileLoader = null;     // Catch: Throwable -> L8
            monitor-exit(SoLoader.class);     // Catch: Throwable -> L8
            setSoSources(null);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public static void setSoFileLoader(SoFileLoader r100) {
            SoLoader.sSoFileLoader = r100;
        }

        public static void setSoSources(SoSource[] r100) {
            SoLoader.access$000().writeLock().lock();
            SoLoader.access$102(r100);     // Catch: Throwable -> L6
            SoLoader.access$200().getAndIncrement();     // Catch: Throwable -> L6
            SoLoader.access$000().writeLock().unlock();
            return;
        L6:
            th = move-exception;
            SoLoader.access$000().writeLock().unlock();
            throw th;
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        public WrongAbiError(Throwable r100, String r101) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + r101);
            initCause(r100);
        }
    }

    public SoLoader() {
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources(null);
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    static {
        sSoSourcesLock = new ReentrantReadWriteLock();
        sSoSources = null;
        sSoSourcesVersion = new AtomicInteger(0);
        sLoadedLibraries = new HashSet();
        sLoadingLibraries = new HashMap();
        sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
        sSystemLoadLibraryWrapper = null;
        DEFAULT_DENY_LIST = new String[]{System.mapLibraryName("breakpad")};
        sAppType = 0;
        SYSTRACE_LIBRARY_LOADING = true;
    }

    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock r100 = sSoSourcesLock;
        r100.readLock().lock();
    L24:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    L5:
        if (sSoSources != null) goto L8;
    L6:
        r100.readLock().unlock();
        return false;
    L8:
        String[] r101 = SysUtil.getSupportedAbis();     // Catch: Throwable -> L24
        SoSource[] r102 = sSoSources;     // Catch: Throwable -> L24
        int r103 = r102.length;     // Catch: Throwable -> L24
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L22;
        String[] r105 = r102[r104].getSoSourceAbis();     // Catch: Throwable -> L24
        int r106 = r105.length;     // Catch: Throwable -> L24
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L21;
        String r108 = r105[r107];     // Catch: Throwable -> L24
        int r109 = 0;
        boolean r110 = false;
    L14:
        if (r109 >= r101.length) goto L17;
        if (r110 == true) goto L17;
        r110 = r108.equals(r101[r109]);     // Catch: Throwable -> L24
        r109 = r109 + 1;     // Catch: Throwable -> L24
    L17:
        if (r110 == false) goto L18;
        r107 = r107 + 1;
        goto L11
    L18:
        r100 = sSoSourcesLock;
        goto L6
    L21:
        r104 = r104 + 1;
        goto L9
    L22:
        sSoSourcesLock.readLock().unlock();
        return true;
    }

    private static int getApplicationSoSourceFlags() {
        int r100 = sAppType;
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
    L11:
        return 1;
    L7:
        if (r100 == 3) goto L11;
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    public static int getLoadedLibrariesCount() {
        return sLoadedLibraries.size();
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 23) goto L5;
    L9:
        return null;
    L5:
        if (r100 > 27) goto L9;
        Method r101 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});     // Catch: Throwable -> L10
        r101.setAccessible(true);     // Catch: Throwable -> L10
        return r101;
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static boolean isInitialized() {
        boolean r100 = true;
        if (sSoSources == null) goto L5;
        return true;
    L5:
        ReentrantReadWriteLock r101 = sSoSourcesLock;
        r101.readLock().lock();
        if (sSoSources != null) goto L10;
        r100 = false;
    L10:
        r101.readLock().unlock();
        return r100;
    L12:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        assertInitialized();     // Catch: Throwable -> L13
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L13
        SoSource[] r101 = sSoSources;     // Catch: Throwable -> L13
        if (r101 == null) goto L8;
        int r102 = r101.length;     // Catch: Throwable -> L13
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101[r103].addToLdLibraryPath(r100);     // Catch: Throwable -> L13
        r103 = r103 + 1;     // Catch: Throwable -> L13
    L8:
        String r104 = TextUtils.join(":", r100);     // Catch: Throwable -> L13
        if (Log.isLoggable("SoLoader", 3) == false) goto L11;
    L11:
        sSoSourcesLock.readLock().unlock();
        return r104;
    L13:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    }

    private static int makePrepareFlags() {
        ReentrantReadWriteLock r100 = sSoSourcesLock;
        r100.writeLock().lock();
        if ((sFlags & 2) == 0) goto L7;
        int r101 = 1;
    L8:
        r100.writeLock().unlock();
        return r101;
    L7:
        r101 = 0;
    L10:
        th = move-exception;
        sSoSourcesLock.writeLock().unlock();
        throw th;
    }

    private static void assertInitialized() {
        if (isInitialized() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    public static /* synthetic */ ReentrantReadWriteLock access$000() {
        return sSoSourcesLock;
    }

    public static /* synthetic */ AtomicInteger access$200() {
        return sSoSourcesVersion;
    }

    public static /* synthetic */ HashSet access$300() {
        return sLoadedLibraries;
    }

    public static /* synthetic */ Map access$400() {
        return sLoadingLibraries;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_facebook_soloader_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ SoSource[] access$102(SoSource[] r100) {
        sSoSources = r100;
        return r100;
    }

    @Nullable
    public static String[] getLibraryDependencies(String r100) throws IOException {
        sSoSourcesLock.readLock().lock();
        String[] r101 = null;
        if (sSoSources == null) goto L11;
        int r102 = 0;
    L6:
        if (r101 != null) goto L11;
        if (r102 >= sSoSources.length) goto L11;
        r101 = sSoSources[r102].getLibraryDependencies(r100);     // Catch: Throwable -> L13
        r102 = r102 + 1;
    L11:
        sSoSourcesLock.readLock().unlock();
        return r101;
    L13:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    }

    @Nullable
    public static String getLibraryPath(String r100) throws IOException {
        sSoSourcesLock.readLock().lock();
        String r101 = null;
        if (sSoSources == null) goto L11;
        int r102 = 0;
    L6:
        if (r101 != null) goto L11;
        if (r102 >= sSoSources.length) goto L11;
        r101 = sSoSources[r102].getLibraryPath(r100);     // Catch: Throwable -> L13
        r102 = r102 + 1;
    L11:
        sSoSourcesLock.readLock().unlock();
        return r101;
    L13:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    }

    @Nullable
    public static File getSoFile(String r100) {
        String r101 = MergedSoMapping.mapLibName(r100);
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        String r102 = System.mapLibraryName(r100);
        sSoSourcesLock.readLock().lock();
    L19:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    L7:
        if (sSoSources == null) goto L17;
        int r103 = 0;
    L10:
        if (r103 >= sSoSources.length) goto L17;
        File r104 = sSoSources[r103].getSoFileByName(r102);     // Catch: IOException -> L22 Throwable -> L19
        if (r104 == null) goto L16;
        sSoSourcesLock.readLock().unlock();
        return r104;
    L16:
        r103 = r103 + 1;
    L17:
        sSoSourcesLock.readLock().unlock();
        return null;
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader r100) {
        monitor-enter(SoLoader.class);
        if (r100 == null) goto L27;
    L11:
        if (r100 == null) goto L15;
        sSoFileLoader = r100;     // Catch: Throwable -> L9
        monitor-exit(SoLoader.class);
        return;
    L15:
        final Runtime r101 = Runtime.getRuntime();     // Catch: Throwable -> L9
        final Method r102 = getNativeLoadRuntimeMethod();     // Catch: Throwable -> L9
        if (r102 == null) goto L18;
        final boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        String r104 = SysUtil.Api14Utils.getClassLoaderLdLoadLibrary();     // Catch: Throwable -> L9
    L22:
        final String r105 = r104;
        final String r106 = makeNonZipPath(r105);     // Catch: Throwable -> L9
        sSoFileLoader = new AnonymousClass1(r103, r105, r106, r101, r102);     // Catch: Throwable -> L9
        monitor-exit(SoLoader.class);
        return;
    L21:
        r104 = null;
        goto L22
    L18:
        r103 = false;
        goto L19
    L27:
    L9:
        th = move-exception;
        throw th;
    L6:
        if (sSoFileLoader == null) goto L11;
        monitor-exit(SoLoader.class);
    }

    public static boolean loadLibrary(String r100) {
        return loadLibrary(r100, 0);
    }

    @Nullable
    private static Boolean loadLibraryOnNonAndroid(String r100) {
        if (sSoSources != null) goto L29;
        ReentrantReadWriteLock r101 = sSoSourcesLock;
        r101.readLock().lock();
    L26:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    L6:
        if (sSoSources == null) goto L8;
    L25:
        r101.readLock().unlock();
        return null;
    L8:
        if ("http://www.android.com/".equals(System.getProperty("java.vendor.url")) == false) goto L11;
        assertInitialized();     // Catch: Throwable -> L26
        goto L25
    L11:
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L26
        boolean r102 = !sLoadedLibraries.contains(r100);     // Catch: Throwable -> L22
        if (r102 == false) goto L18;
        SystemLoadLibraryWrapper r103 = sSystemLoadLibraryWrapper;     // Catch: Throwable -> L22
        if (r103 == null) goto L17;
        r103.loadLibrary(r100);     // Catch: Throwable -> L22
        goto L18
    L17:
        INVOKESTATIC_com_facebook_soloader_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L22
    L18:
        Boolean r104 = Boolean.valueOf(r102);     // Catch: Throwable -> L22
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L22
        r101.readLock().unlock();
        return r104;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L29:
        return null;
    }

    @Nullable
    public static String makeNonZipPath(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r101 = r100.split(":");
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L13;
        String r105 = r101[r104];
        if (r105.contains("!") == true) goto L11;
        r102.add(r105);
    L11:
        r104 = r104 + 1;
        goto L6
    L13:
        return TextUtils.join(":", r102);
    }

    public static void prependSoSource(SoSource r100) throws IOException {
        ReentrantReadWriteLock r101 = sSoSourcesLock;
        r101.writeLock().lock();
        assertInitialized();     // Catch: Throwable -> L8
        r100.prepare(makePrepareFlags());     // Catch: Throwable -> L8
        SoSource[] r102 = new SoSource[sSoSources.length + 1];     // Catch: Throwable -> L8
        r102[0] = r100;     // Catch: Throwable -> L8
        System.arraycopy(sSoSources, 0, r102, 1, sSoSources.length);     // Catch: Throwable -> L8
        sSoSources = r102;     // Catch: Throwable -> L8
        sSoSourcesVersion.getAndIncrement();     // Catch: Throwable -> L8
        if (Log.isLoggable("SoLoader", 3) == false) goto L6;
        r100.toString();     // Catch: Throwable -> L8
    L6:
        r101.writeLock().unlock();
        return;
    L8:
        th = move-exception;
        sSoSourcesLock.writeLock().unlock();
        throw th;
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper r100) {
        sSystemLoadLibraryWrapper = r100;
    }

    public static File unpackLibraryAndDependencies(String r100) throws UnsatisfiedLinkError {
        assertInitialized();
        return unpackLibraryBySoName(System.mapLibraryName(r100));
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static File unpackLibraryBySoName(String r100) throws IOException {
        sSoSourcesLock.readLock().lock();
        SoSource[] r101 = sSoSources;     // Catch: Throwable -> L12
        int r102 = r101.length;     // Catch: Throwable -> L12
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L10;
        File r104 = r101[r103].unpackLibrary(r100);     // Catch: Throwable -> L12
        if (r104 != null) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        sSoSourcesLock.readLock().unlock();
        return r104;
    L10:
        sSoSourcesLock.readLock().unlock();
        throw new FileNotFoundException(r100);
    L12:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    }

    private static void AddSystemLibSoSource(ArrayList<SoSource> r100, String[] r101) {
        if (SysUtil.is64Bit() == false) goto L5;
        String r102 = "/system/lib64:/vendor/lib64";
    L6:
        String r103 = System.getenv("LD_LIBRARY_PATH");
        if (r103 != null) goto L9;
    L11:
        Iterator r104 = new HashSet(Arrays.asList(r102.split(":"))).iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        String r105 = (String) r104.next();
        if (Log.isLoggable("SoLoader", 3) == true) goto L17;
    L17:
        r100.add(new DirectorySoSource(new PolarisFileWrapper(r105), 2, r101));
        goto L13
    L18:
        return;
    L9:
        if (r103.equals("") == true) goto L11;
        r102 = r102 + ":" + r103;
        goto L11
    L5:
        r102 = "/system/lib:/vendor/lib";
        goto L6
    }

    private static void addDirectApkSoSource(Context r100, ArrayList<SoSource> r110) {
        if (r100.getApplicationInfo().splitSourceDirs == null) goto L10;
        String[] r101 = r100.getApplicationInfo().splitSourceDirs;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        DirectApkSoSource r104 = new DirectApkSoSource(new PolarisFileWrapper(r101[r103]));
        if (Log.isLoggable("SoLoader", 3) == false) goto L9;
        r104.toString();
    L9:
        r110.add(0, r104);
        r103 = r103 + 1;
    L10:
        DirectApkSoSource r105 = new DirectApkSoSource(r100);
        if (Log.isLoggable("SoLoader", 3) == false) goto L13;
        r105.toString();
    L13:
        r110.add(0, r105);
    }

    private static int getAppType(Context r100, int r101) {
        int r102 = sAppType;
        if (r102 == 0) goto L5;
        return r102;
    L5:
        int r103 = 1;
        if ((r101 & 32) != 0) goto L19;
        if (r100 == null) goto L19;
        int r104 = r100.getApplicationInfo().flags;
        if ((r104 & 1) == 0) goto L17;
        if ((r104 & 128) == 0) goto L15;
        r103 = 3;
        goto L17
    L15:
        r103 = 2;
    L17:
        if (Log.isLoggable("SoLoader", 3) == true) goto L19;
    L19:
        return r103;
    }

    public static void init(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 1;
    L10:
        init(r100, r102, null, DEFAULT_DENY_LIST);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        r102 = 0;
        goto L10
    }

    public static boolean loadLibrary(String r100, int r101) throws UnsatisfiedLinkError {
        Boolean r102 = loadLibraryOnNonAndroid(r100);
        if (r102 != null) goto L5;
        int r103 = sAppType;
        if (r103 != 2) goto L9;
    L10:
        SystemLoadLibraryWrapper r104 = sSystemLoadLibraryWrapper;
        if (r104 == null) goto L14;
        r104.loadLibrary(r100);
        return true;
    L14:
        String r105 = MergedSoMapping.mapLibName(r100);
        if (r105 == null) goto L17;
        String r106 = r105;
    L19:
        return loadLibraryBySoName(System.mapLibraryName(r106), r100, r105, r101, null);
    L17:
        r106 = r100;
        goto L19
    L9:
        if (r103 != 3) goto L14;
    L5:
        return r102.booleanValue();
    }

    public static void init(Context r100, int r101) throws IOException {
        init(r100, r101, null, DEFAULT_DENY_LIST);
    }

    private static void AddBackupSoSource(Context r100, ArrayList<SoSource> r101, int r102) throws IOException {
        if ((sFlags & 8) == 0) goto L9;
        sBackupSoSources = null;
        File r103 = UnpackingSoSource.getSoStorePath(r100, SO_STORE_NAME_MAIN);
        SysUtil.dumbDeleteRecursive(r103);     // Catch: IOException -> L7
        return;
    L7:
        r103.getCanonicalPath();
        return;
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getApplicationInfo().sourceDir);
        ArrayList r105 = new ArrayList();
        ApkSoSource r106 = new ApkSoSource(r100, r104, SO_STORE_NAME_MAIN, r102);
        r105.add(r106);
        if (Log.isLoggable("SoLoader", 3) == false) goto L12;
        r106.toString();
    L12:
        addBackupSoSourceFromSplitApk(r100, r102, r105);
        sBackupSoSources = (UnpackingSoSource[]) r105.toArray(new UnpackingSoSource[r105.size()]);
        r101.addAll(0, r105);
    }

    private static void addApplicationSoSource(Context r100, ArrayList<SoSource> r101, int r102) {
        sApplicationSoSource = new ApplicationSoSource(r100, r102);
        if (Log.isLoggable("SoLoader", 3) == false) goto L5;
        sApplicationSoSource.toString();
    L5:
        r101.add(0, sApplicationSoSource);
    }

    private static void addBackupSoSourceFromSplitApk(Context r100, int r101, ArrayList<UnpackingSoSource> r110) {
        if (r100.getApplicationInfo().splitSourceDirs == null) goto L10;
        String[] r102 = r100.getApplicationInfo().splitSourceDirs;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r103) goto L14;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r102[r104]);
        StringBuilder r107 = new StringBuilder(SO_STORE_NAME_SPLIT);
        int r108 = r105 + 1;
        r107.append(r105);
        ApkSoSource r109 = new ApkSoSource(r100, r106, r107.toString(), r101);
        if (Log.isLoggable("SoLoader", 3) == false) goto L9;
        r109.toString();
    L9:
        r110.add(r109);
        r104 = r104 + 1;
        r105 = r108;
        goto L5
    L14:
        return;
    }

    private static void doLoadLibraryBySoName(String r110, int r111, @Nullable StrictMode.ThreadPolicy r112) throws UnsatisfiedLinkError {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    public static void init(Context r100, int r101, @Nullable SoFileLoader r102) throws IOException {
        init(r100, r101, r102, DEFAULT_DENY_LIST);
    }

    private static void initSoSources(Context r100, int r101, String[] r102) throws IOException {
        if (sSoSources == null) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r103 = sSoSourcesLock;
        r103.writeLock().lock();
        if (sSoSources == null) goto L41;
        r103.writeLock().unlock();
        return;
    L41:
        sFlags = r101;     // Catch: Throwable -> L38
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L38
        AddSystemLibSoSource(r104, r102);     // Catch: Throwable -> L38
        if (r100 != null) goto L13;
    L20:
        SoSource[] r105 = (SoSource[]) r104.toArray(new SoSource[r104.size()]);     // Catch: Throwable -> L38
        int r106 = makePrepareFlags();     // Catch: Throwable -> L38
        int r107 = r105.length;     // Catch: Throwable -> L38
    L21:
        int r108 = r107 - 1;     // Catch: Throwable -> L38
        if (r107 <= 0) goto L33;
        if (Log.isLoggable("SoLoader", 3) == false) goto L26;
        Objects.toString(r105[r108]);     // Catch: Throwable -> L38
    L26:
        boolean r109 = SYSTRACE_LIBRARY_LOADING;     // Catch: Throwable -> L38
        if (r109 == false) goto L29;
        Api18TraceUtils.beginTraceSection("SoLoader", "_", r105[r108].getClass().getSimpleName());     // Catch: Throwable -> L38
    L29:
        r105[r108].prepare(r106);     // Catch: Throwable -> L38
        if (r109 == false) goto L32;
        Api18TraceUtils.endSection();     // Catch: Throwable -> L38
    L32:
        r107 = r108;
        goto L21
    L33:
        sSoSources = r105;     // Catch: Throwable -> L38
        sSoSourcesVersion.getAndIncrement();     // Catch: Throwable -> L38
        if (Log.isLoggable("SoLoader", 3) == false) goto L36;
        int r110 = sSoSources.length;     // Catch: Throwable -> L38
    L36:
        sSoSourcesLock.writeLock().unlock();
        return;
    L13:
        if ((r101 & 1) == 0) goto L17;
        sBackupSoSources = null;     // Catch: Throwable -> L38
        Log.isLoggable("SoLoader", 3);     // Catch: Throwable -> L38
        r104.add(0, new ExoSoSource(r100, SO_STORE_NAME_MAIN));     // Catch: Throwable -> L38
        goto L20
    L17:
        if ((r101 & 64) == 0) goto L19;
        addDirectApkSoSource(r100, r104);     // Catch: Throwable -> L38
    L19:
        addApplicationSoSource(r100, r104, getApplicationSoSourceFlags());     // Catch: Throwable -> L38
        AddBackupSoSource(r100, r104, 1);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        sSoSourcesLock.writeLock().unlock();
        throw th;
    }

    public static void loadLibraryBySoName(String r100, int r101, StrictMode.ThreadPolicy r102) {
        loadLibraryBySoNameImpl(r100, null, null, r101, r102);
    }

    public static boolean useDepsFile(Context r100, boolean r101, boolean r102) {
        return NativeDeps.useDepsFile(r100, r101, r102);
    }

    public static void init(Context r100, int r101, @Nullable SoFileLoader r102, String[] r103) throws IOException {
        if (isInitialized() == false) goto L5;
        return;
    L5:
        StrictMode.ThreadPolicy r104 = StrictMode.allowThreadDiskWrites();
        int r105 = getAppType(r100, r101);     // Catch: Throwable -> L14
        sAppType = r105;     // Catch: Throwable -> L14
        if ((r101 & 128) == 0) goto L9;
    L11:
        initSoLoader(r102);     // Catch: Throwable -> L14
        initSoSources(r100, r101, r103);     // Catch: Throwable -> L14
        NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());     // Catch: Throwable -> L14
        StrictMode.setThreadPolicy(r104);
        return;
    L9:
        if (SysUtil.isSupportedDirectLoad(r100, r105) == false) goto L11;
        r101 = r101 | 72;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        StrictMode.setThreadPolicy(r104);
        throw th;
    }

    private static boolean loadLibraryBySoName(String r100, @Nullable String r101, @Nullable String r102, int r103, @Nullable StrictMode.ThreadPolicy r110) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r0 = 0
            r1 = 0
        L2:
            boolean r1 = loadLibraryBySoNameImpl(r6, r7, r8, r9, r10)     // Catch: java.lang.UnsatisfiedLinkError -> L8
            r4 = 0
            goto L3f
        L8:
            r2 = move-exception
            java.util.concurrent.atomic.AtomicInteger r3 = com.facebook.soloader.SoLoader.sSoSourcesVersion
            int r3 = r3.get()
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = com.facebook.soloader.SoLoader.sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.lock()
            com.facebook.soloader.ApplicationSoSource r4 = com.facebook.soloader.SoLoader.sApplicationSoSource     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            if (r4 == 0) goto L2d
            com.facebook.soloader.ApplicationSoSource r4 = com.facebook.soloader.SoLoader.sApplicationSoSource     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            boolean r4 = r4.checkAndMaybeUpdate()     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            if (r4 == 0) goto L2d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            java.util.concurrent.atomic.AtomicInteger r4 = com.facebook.soloader.SoLoader.sSoSourcesVersion     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r4.getAndIncrement()     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r4 = 1
            goto L2e
        L2d:
            r4 = 0
        L2e:
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = com.facebook.soloader.SoLoader.sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r5 = r5.writeLock()
            r5.unlock()
            java.util.concurrent.atomic.AtomicInteger r5 = com.facebook.soloader.SoLoader.sSoSourcesVersion
            int r5 = r5.get()
            if (r5 == r3) goto L42
        L3f:
            if (r4 != 0) goto L2
            return r1
        L42:
            throw r2
        L43:
            r6 = move-exception
            goto L4c
        L45:
            r6 = move-exception
            java.lang.RuntimeException r7 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L43
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L43
            throw r7     // Catch: java.lang.Throwable -> L43
        L4c:
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = com.facebook.soloader.SoLoader.sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoName(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    private static boolean loadLibraryBySoNameImpl(String r110, @Nullable String r111, @Nullable String r112, int r113, @Nullable StrictMode.ThreadPolicy r114) {
        boolean r100 = false;
        if (TextUtils.isEmpty(r111) == true) goto L8;
        if (sLoadedAndMergedLibraries.contains(r111) == false) goto L8;
        return false;
    L8:
        monitor-enter(SoLoader.class);
        HashSet<String> r101 = sLoadedLibraries;     // Catch: Throwable -> L101
        if (r101.contains(r110) == false) goto L15;
        if (r112 != null) goto L14;
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L101
        return false;
    L14:
        boolean r102 = true;
    L16:
        Map<String, Object> r103 = sLoadingLibraries;     // Catch: Throwable -> L101
        if (r103.containsKey(r110) == false) goto L19;
        Object r104 = r103.get(r110);     // Catch: Throwable -> L101
    L20:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L101
        ReentrantReadWriteLock r105 = sSoSourcesLock;
        r105.readLock().lock();
        monitor-enter(r104);     // Catch: Throwable -> L98
        if (r102 == true) goto L66;
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L63
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L28:
        if (r101.contains(r110) == false) goto L35;
        if (r112 != null) goto L34;
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L60
        monitor-exit(r104);     // Catch: Throwable -> L63
        r105.readLock().unlock();
        return false;
    L34:
        r102 = true;
    L35:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L60
        if (r102 == true) goto L66;
    L52:
        e = move-exception;
        String r115 = e.getMessage();     // Catch: Throwable -> L63
        if (r115 != null) goto L56;
    L59:
        throw e;     // Catch: Throwable -> L63
    L56:
        if (r115.contains("unexpected e_machine:") == false) goto L59;
        throw new WrongAbiError(e, r115.substring(r115.lastIndexOf("unexpected e_machine:")));     // Catch: Throwable -> L63
    L38:
        if (Log.isLoggable("SoLoader", 3) == true) goto L40;
    L40:
        doLoadLibraryBySoName(r110, r113, r114);     // Catch: UnsatisfiedLinkError -> L52 Throwable -> L63
    L42:
        if (Log.isLoggable("SoLoader", 3) == true) goto L45;
    L45:
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L63
        r101.add(r110);     // Catch: Throwable -> L49
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L98
    L66:
        if ((r113 & 16) == 0) goto L68;
    L93:
        monitor-exit(r104);     // Catch: Throwable -> L63
        r105.readLock().unlock();
        return !r102;
    L68:
        if (TextUtils.isEmpty(r111) == false) goto L70;
    L72:
        if (r112 == null) goto L93;
        if (r100 == true) goto L93;
        boolean r116 = SYSTRACE_LIBRARY_LOADING;     // Catch: Throwable -> L63
        if (r116 == false) goto L106;
        Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r111, "]");     // Catch: Throwable -> L63
    L106:
    L84:
        th = move-exception;
        if (SYSTRACE_LIBRARY_LOADING == false) goto L92;
        Api18TraceUtils.endSection();     // Catch: Throwable -> L63
    L92:
        throw th;     // Catch: Throwable -> L63
    L86:
        e = move-exception;
        throw new RuntimeException("Failed to call JNI_OnLoad from '" + r111 + "', which has been merged into '" + r110 + "'.  See comment for details.", e);     // Catch: Throwable -> L84
    L78:
        if (Log.isLoggable("SoLoader", 3) == true) goto L80;
    L80:
        MergedSoMapping.invokeJniOnload(r111);     // Catch: Throwable -> L84 UnsatisfiedLinkError -> L86
        sLoadedAndMergedLibraries.add(r111);     // Catch: Throwable -> L84 UnsatisfiedLinkError -> L86
        if (r116 == false) goto L93;
        Api18TraceUtils.endSection();     // Catch: Throwable -> L63
        goto L93
    L70:
        if (sLoadedAndMergedLibraries.contains(r111) == false) goto L72;
        r100 = true;
    L98:
        th = move-exception;
        sSoSourcesLock.readLock().unlock();
        throw th;
    L19:
        Object r106 = new Object();     // Catch: Throwable -> L101
        r103.put(r110, r106);     // Catch: Throwable -> L101
        r104 = r106;
        goto L20
    L15:
        r102 = false;
    L101:
        th = move-exception;
        throw th;
    }
}
