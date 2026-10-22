package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.DataOutput;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class SysUtil {
    private static final long APK_DEP_BLOCK_METADATA_LENGTH = 20;
    private static final byte APK_SIGNATURE_VERSION = 1;
    private static final String TAG = "SysUtil";

    public static class Api14Utils {
        public Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader r100 = SoLoader.class.getClassLoader();
            if (r100 != null) goto L5;
        L14:
            return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) r100, new Object[0]);
        L11:
            e = move-exception;
            throw new RuntimeException("Cannot call getLdLibraryPath", e);
        L5:
            if ((r100 instanceof BaseDexClassLoader) == true) goto L14;
            throw new IllegalStateException("ClassLoader " + r100.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    public static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] r100 = Build.SUPPORTED_ABIS;
            TreeSet r101 = new TreeSet();
            int r102 = 0;
        L15:
            e = move-exception;
            String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[]{Arrays.toString(r100), Integer.valueOf(e.errno), e.getMessage()});
            return Build.SUPPORTED_ABIS;
        L4:
            if (is64Bit() == false) goto L6;
            r101.add(MinElf.ISA.AARCH64.toString());     // Catch: ErrnoException -> L15
            r101.add(MinElf.ISA.X86_64.toString());     // Catch: ErrnoException -> L15
        L7:
            ArrayList r103 = new ArrayList();
            int r104 = r100.length;
        L8:
            if (r102 >= r104) goto L14;
            String r105 = r100[r102];
            if (r101.contains(r105) == false) goto L12;
            r103.add(r105);
        L12:
            r102 = r102 + 1;
            goto L8
        L14:
            return (String[]) r103.toArray(new String[r103.size()]);
        L6:
            r101.add(MinElf.ISA.ARM.toString());     // Catch: ErrnoException -> L15
            r101.add(MinElf.ISA.X86.toString());     // Catch: ErrnoException -> L15
            goto L7
        }

        public static boolean is64Bit() throws ErrnoException {
            return Os.readlink("/proc/self/exe").contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
        }

        public static void fallocateIfSupported(FileDescriptor r100, long r101) throws IOException {
            Os.posix_fallocate(r100, 0, r101);     // Catch: ErrnoException -> L5
            return;
        L5:
            e = move-exception;
            if (e.errno == OsConstants.EOPNOTSUPP) goto L15;
            int r102 = e.errno;
            if (r102 != OsConstants.ENOSYS) goto L11;
            return;
        L11:
            if (r102 != OsConstants.EINVAL) goto L14;
            return;
        L14:
            throw new IOException(e.toString(), e);
        }
    }

    public static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] r100 = Build.SUPPORTED_ABIS;
            TreeSet r101 = new TreeSet();
            if (is64Bit() == false) goto L5;
            r101.add(MinElf.ISA.AARCH64.toString());
            r101.add(MinElf.ISA.X86_64.toString());
        L6:
            ArrayList r102 = new ArrayList();
            int r103 = r100.length;
            int r104 = 0;
        L7:
            if (r104 >= r103) goto L13;
            String r105 = r100[r104];
            if (r101.contains(r105) == false) goto L11;
            r102.add(r105);
        L11:
            r104 = r104 + 1;
            goto L7
        L13:
            return (String[]) r102.toArray(new String[r102.size()]);
        L5:
            r101.add(MinElf.ISA.ARM.toString());
            r101.add(MinElf.ISA.X86.toString());
            goto L6
        }

        public static boolean is64Bit() {
            return Process.is64Bit();
        }

        private static boolean isApkUncompressedDso(Context r100) throws IOException {
            PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir));
            Enumeration<? extends ZipEntry> r102 = r101.entries();     // Catch: Throwable -> L19
        L4:
            boolean r103 = false;
            if (r102.hasMoreElements() == false) goto L17;
            ZipEntry r104 = r102.nextElement();     // Catch: Throwable -> L19
            if (r104 == null) goto L4;
            if (r104.getName().endsWith(".so") == false) goto L4;
            if (r104.getName().contains("/lib") == false) goto L4;
            if (r104.getMethod() != 0) goto L15;
            r103 = true;
        L15:
            r101.close();
            return r103;
        L17:
            r101.close();
            return false;
        L19:
            th = move-exception;
            r101.close();     // Catch: Throwable -> L22
        L24:
            throw th;
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        }

        public static boolean isDisabledExtractNativeLibs(Context r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if ((r100.getApplicationInfo().flags & 268435456) != 0) goto L6;
            return true;
        }

        public static boolean isSupportedDirectLoad(Context r100, int r101) throws IOException {
            if (r101 != 2) goto L7;
            return isApkUncompressedDso(r100);
        L7:
            return isDisabledExtractNativeLibs(r100);
        }
    }

    public SysUtil() {
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return MarshmallowSysdeps.getSupportedAbis();
    L7:
        return LollipopSysdeps.getSupportedAbis();
    }

    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return LollipopSysdeps.is64Bit();
    L7:
        e = move-exception;
        String.format("Could not read /proc/self/exe. Err msg: %s", new Object[]{e.getMessage()});
        return false;
    L12:
        return MarshmallowSysdeps.is64Bit();
    }

    public static void deleteOrThrow(File r100) throws IOException {
        File r101 = r100.getParentFile();
        if (r101 == null) goto L10;
        if (r101.canWrite() == true) goto L10;
        if (r101.setWritable(true) == true) goto L10;
        r101.toString();
    L10:
        if (r100.delete() == false) goto L12;
        return;
    L12:
        if (r100.exists() == true) goto L15;
        return;
    L15:
        throw new IOException("Could not delete file " + r100);
    }

    public static void dumbDeleteRecursive(File r100) throws IOException {
        if (r100.isDirectory() == false) goto L10;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        dumbDeleteRecursive(r101[r103]);
        r103 = r103 + 1;
    L10:
        deleteOrThrow(r100);
    }

    public static void fsyncRecursive(File r100) throws IOException {
        if (r100.isDirectory() == false) goto L13;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L11;
        int r102 = 0;
    L8:
        if (r102 >= r101.length) goto L31;
        fsyncRecursive(r101[r102]);
        r102 = r102 + 1;
        goto L8
    L31:
        return;
    L11:
        throw new IOException("cannot list directory " + r100);
    L13:
        if (r100.getPath().endsWith("_lock") == true) goto L30;
        RandomAccessFile r103 = new RandomAccessFile(r100, "r");
        r103.getFD().sync();     // Catch: Throwable -> L19
        r103.close();
        return;
    L19:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L22
    L24:
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    public static long getApkDepBlockLength(File r100) throws IOException {
        return getParcelPadSize((r100.getCanonicalFile().getPath().length() + 1) * 2) + 20;
    }

    public static int getAppVersionCode(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L8;
    L6:
        return 0;
    L8:
        return r101.getPackageInfo(r100.getPackageName(), 0).versionCode;
    }

    public static String getBaseName(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r100.substring(0, r101);
    }

    private static long getParcelPadSize(long r100) {
        return r100 + ((4 - (r100 % 4)) % 4);
    }

    public static boolean isDisabledExtractNativeLibs(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return MarshmallowSysdeps.isDisabledExtractNativeLibs(r100);
    }

    public static void mkdirOrThrow(File r100) throws IOException {
        if (r100.mkdirs() == false) goto L5;
        return;
    L5:
        if (r100.isDirectory() == false) goto L8;
        return;
    L8:
        throw new IOException("cannot mkdir: " + r100);
    }

    public static void fallocateIfSupported(FileDescriptor r100, long r101) throws IOException {
        LollipopSysdeps.fallocateIfSupported(r100, r101);
    }

    public static int findAbiScore(String[] r100, String r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L11;
        String r103 = r100[r102];
        if (r103 == null) goto L10;
        if (r101.equals(r103) == false) goto L10;
        return r102;
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        return -1;
    }

    public static boolean isSupportedDirectLoad(Context r100, int r101) throws IOException {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return MarshmallowSysdeps.isSupportedDirectLoad(r100, r101);
    }

    public static byte[] makeApkDepBlock(File r100, Context r101) throws IOException {
        File r102 = r100.getCanonicalFile();
        Parcel r103 = Parcel.obtain();
        r103.writeByte((byte) 1);     // Catch: Throwable -> L6
        r103.writeString(r102.getPath());     // Catch: Throwable -> L6
        r103.writeLong(r102.lastModified());     // Catch: Throwable -> L6
        r103.writeInt(getAppVersionCode(r101));     // Catch: Throwable -> L6
        byte[] r104 = r103.marshall();     // Catch: Throwable -> L6
        r103.recycle();
        return r104;
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    @Nullable
    public static FileLocker getOrCreateLockOnDir(File r100, File r101, boolean r102) throws IOException {
        if (r102 == false) goto L7;
        return FileLocker.lock(r101);
    L7:
        return FileLocker.tryLock(r101);
    L10:
        e = move-exception;
        boolean r103 = true;
    L26:
        th = th;
    L27:
        if (r103 == true) goto L29;
    L31:
        throw th;
    L29:
        if (r100.setWritable(false) == true) goto L31;
        r100.getCanonicalPath();
        goto L31
    L13:
        if (r100.setWritable(true) == false) goto L25;
        if (r102 == false) goto L20;
        FileLocker r104 = FileLocker.lock(r101);     // Catch: Throwable -> L26
        if (r100.setWritable(false) == true) goto L19;
        r100.getCanonicalPath();
    L19:
        return r104;
    L20:
        FileLocker r105 = FileLocker.tryLock(r101);     // Catch: Throwable -> L26
        if (r100.setWritable(false) == true) goto L24;
        r100.getCanonicalPath();
    L24:
        return r105;
    L25:
        throw e;     // Catch: Throwable -> L26
    L8:
        th = th;
        r103 = false;
        goto L27
    }

    public static int copyBytes(DataOutput r100, InputStream r101, int r102, byte[] r103) throws IOException {
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L7;
        int r105 = r101.read(r103, 0, Math.min(r103.length, r102 - r104));
        if (r105 == (-1)) goto L7;
        r100.write(r103, 0, r105);
        r104 = r104 + r105;
    L7:
        return r104;
    }
}
