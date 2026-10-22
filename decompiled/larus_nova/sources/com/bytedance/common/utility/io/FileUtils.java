package com.bytedance.common.utility.io;

import android.content.Context;
import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final class FileUtils {
    private static final byte[] GIF87A = null;
    private static final byte[] GIF89A = null;
    private static final byte[] JPEG = null;
    private static final byte[] PNG = null;
    private static final String TAG = "FileUtils";

    /* JADX INFO: loaded from: classes15.dex */
    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r100 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r100;
            ImageType r101 = new ImageType("JPG", 1);
            JPG = r101;
            ImageType r102 = new ImageType("PNG", 2);
            PNG = r102;
            ImageType r103 = new ImageType("GIF", 3);
            GIF = r103;
            $VALUES = new ImageType[]{r100, r101, r102, r103};
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) a.a(ImageType.class, r100);
        }

        private ImageType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        GIF87A = new byte[]{71, 73, 70, 56, 55, 97};
        GIF89A = new byte[]{71, 73, 70, 56, 57, 97};
        JPEG = new byte[]{-1, -40, -1};
        PNG = new byte[]{-119, 80, 78, 71, HTTP.CR, 10, 26, 10};
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isExternalStorageReadable() {
        String r100 = Environment.getExternalStorageState();
        if ("mounted".equals(r100) == false) goto L5;
        return true;
    L5:
        if ("mounted_ro".equals(r100) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isExternalStorageWritable() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private FileUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_io_FileUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void clearDir(String r100) throws Exception {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        File[] r102 = r101.listFiles();
        int r103 = 0;
        if (r102 == null) goto L8;
        int r104 = r102.length;
    L9:
        if (r103 >= r104) goto L17;
        if (r102[r103].isDirectory() == false) goto L14;
        removeDir(r102[r103].getAbsolutePath());
    L16:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r102[r103].isFile() == false) goto L16;
        r102[r103].delete();
        goto L16
    L17:
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public static boolean exists(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        return new PolarisFileWrapper(r100).exists();
    }

    public static byte[] getByteArray(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L18;
        return null;
    L18:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);     // Catch: Exception -> L10
        int r103 = (int) r101.length();     // Catch: Exception -> L10
        byte[] r104 = new byte[r103];     // Catch: Exception -> L10
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L8;
        r104[r105] = (byte) r102.read();     // Catch: Exception -> L10
        r105 = r105 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        r102.close();     // Catch: Exception -> L10
        return r104;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getCacheDirPath(Context r100) throws NullPointerException {
        if (r100 == null) goto L20;
        String r101 = null;
        if (r100.getCacheDir() == null) goto L9;
        String r102 = r100.getCacheDir().getPath();     // Catch: Throwable -> L13
    L8:
        r101 = r102;
        goto L15
    L9:
        File r103 = r100.getDir("/data/data/" + r100.getPackageName() + "/cache/", 0);     // Catch: Throwable -> L13
        if (r103 == null) goto L15;
        r102 = r103.getPath();     // Catch: Throwable -> L13
    L15:
        if (StringUtils.isEmpty(r101) == true) goto L18;
        return r101;
    L18:
        throw new NullPointerException("Cannot Create Cache Dir");
    L20:
        throw new NullPointerException("Context is NUll");
    }

    public static String getExtension(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.lastIndexOf(".");
        if (r101 != (-1)) goto L10;
        return "";
    L10:
        return r100.substring(r101 + 1);
    }

    public static String getFileNameWithoutExtension(String r100) {
        String r101 = new PolarisFileWrapper(r100).getName();
        if (StringUtils.isEmpty(r101) == true) goto L8;
        int r102 = r101.lastIndexOf(".");
        if ((-1) != r102) goto L7;
        return "";
    L7:
        return r101.substring(0, r102);
    L8:
        return "";
    }

    public static String getFilesDirPath(Context r100) throws NullPointerException {
        if (r100 == null) goto L20;
        String r101 = null;
        if (r100.getFilesDir() == null) goto L9;
        String r102 = r100.getFilesDir().getPath();     // Catch: Throwable -> L13
    L8:
        r101 = r102;
        goto L15
    L9:
        File r103 = r100.getDir("/data/data/" + r100.getPackageName() + "/files/", 0);     // Catch: Throwable -> L13
        if (r103 == null) goto L15;
        r102 = r103.getPath();     // Catch: Throwable -> L13
    L15:
        if (StringUtils.isEmpty(r101) == true) goto L18;
        return r101;
    L18:
        throw new NullPointerException("Cannot Create Files Dir");
    L20:
        throw new NullPointerException("Context is NUll");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0072 -> B:64:0x0075). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File r100) {
        if (r100 == null) goto L59;
        if (r100.exists() == false) goto L59;
        ImageType r101 = ImageType.UNKNOWN;
        ?? r102 = 0;
        PolarisFileInputStreamWrapper r103 = null;
        r102 = 0;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L42 Exception -> L44
        byte[] r105 = new byte[8];     // Catch: Throwable -> L38 Exception -> L40
        r104.read(r105);     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r105, GIF89A) == false) goto L12;
    L32:
        ImageType r106 = ImageType.GIF;     // Catch: Throwable -> L38 Exception -> L40
        r104.close();     // Catch: Exception -> L35
    L37:
        return r106;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L12:
        if (checkSignature(r105, GIF87A) == true) goto L32;
        if (checkSignature(r105, JPEG) == false) goto L22;
        ImageType r107 = ImageType.JPG;     // Catch: Throwable -> L38 Exception -> L40
        r104.close();     // Catch: Exception -> L19
    L21:
        return r107;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L22:
        byte[] r108 = PNG;     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r105, r108) == false) goto L30;
        ImageType r109 = ImageType.PNG;     // Catch: Throwable -> L38 Exception -> L40
        r104.close();     // Catch: Exception -> L27
    L29:
        return r109;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L30:
        r104.close();     // Catch: Exception -> L49
        r102 = r108;
    L64:
        return r101;
    L40:
        e = e;
        r103 = r104;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L42
        r102 = r103;
        if (r103 == null) goto L64;
        r103.close();     // Catch: Exception -> L49
        r102 = r103;
    L38:
        th = th;
        r102 = r104;
    L52:
        if (r102 != 0) goto L60;
    L57:
        throw th;
    L60:
        r102.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L42:
        th = th;
    L44:
        e = e;
    L49:
        e = move-exception;
        e.printStackTrace();
        r102 = r102;
    L59:
        return ImageType.UNKNOWN;
    }

    public static InputStream getInputStream(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L15;
        return null;
    L15:
        return new PolarisFileInputStreamWrapper(r101);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isGif(File r100) {
        if (getImageType(r100) != ImageType.GIF) goto L5;
        return true;
    L5:
        return false;
    }

    public static void removeDir(String r100) throws Exception {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.isDirectory() == false) goto L23;
        File[] r102 = r101.listFiles();
        int r103 = 0;
        if (r102 == null) goto L9;
        int r104 = r102.length;
    L10:
        if (r103 >= r104) goto L16;
        if (r102[r103].isDirectory() == false) goto L14;
        removeDir(r102[r103].getAbsolutePath());
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r102[r103].delete();
        goto L15
    L16:
        r101.delete();
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public static ImageType getImageType(String r100) {
        if (StringUtils.isEmpty(r100) == true) goto L7;
        return getImageType(new PolarisFileWrapper(r100));
    L7:
        return ImageType.UNKNOWN;
    }

    private static boolean checkSignature(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L18;
        int r102 = 0;
    L8:
        if (r102 >= r101.length) goto L13;
        if (r100[r102] != r101[r102]) goto L19;
        r102 = r102 + 1;
        goto L8
    L19:
        return false;
    L13:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static void chmod(String r110, int r111) {
        Class r100 = INVOKESTATIC_com_bytedance_common_utility_io_FileUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.FileUtils");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r100 != null) goto L6;
        return;
    L6:
        Class<?> r101 = Integer.TYPE;     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        Method r102 = r100.getMethod("setPermissions", new Class[]{String.class, r101, r101, r101});     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r102 != null) goto L9;
        return;
    L9:
        int r112 = ((Integer) r102.invoke(null, new Object[]{r110, Integer.valueOf(r111), -1, -1})).intValue();     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r112 == 0) goto L21;
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + r112 + " for '" + r110 + "', probably didn't work.");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        goto L26
    L25:
        return;
    L21:
        return;
    L16:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        return;
    L15:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        return;
    L13:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        return;
    L14:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        return;
    }

    public static void clearDir(String r100, Set<String> r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
        return;
    L5:
        File[] r103 = r102.listFiles();
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.length;
    L9:
        if (r104 >= r105) goto L21;
        if (r103[r104].isDirectory() == false) goto L14;
        removeDir(r103[r104].getAbsolutePath(), r101);
    L20:
        r104 = r104 + 1;
        goto L9
    L14:
        if (r103[r104].isFile() == false) goto L20;
        String r106 = r103[r104].getName();
        if (r101 != null) goto L18;
    L19:
        r103[r104].delete();
        goto L20
    L18:
        if (r101.contains(r106) == true) goto L20;
    L21:
        return;
    L8:
        r105 = 0;
        goto L9
    }

    public static long getDirectorySize(File r100, boolean r101) {
        long r102 = 0;
        if (r100.exists() == false) goto L6;
    L8:
        File[] r103 = r100.listFiles();     // Catch: Throwable -> L23
        int r104 = 0;
        if (r103 == null) goto L11;
        int r105 = r103.length;     // Catch: Throwable -> L23
    L12:
        if (r104 >= r105) goto L22;
        File r106 = r103[r104];     // Catch: Throwable -> L23
        if (r106.isDirectory() == false) goto L18;
        long r107 = getDirectorySize(r106, r101);     // Catch: Throwable -> L23
    L16:
        r102 = r102 + r107;     // Catch: Throwable -> L23
    L21:
        r104 = r104 + 1;
        goto L12
    L18:
        if (r106.isFile() == false) goto L21;
        r107 = r106.length();     // Catch: Throwable -> L23
        goto L16
    L11:
        r105 = 0;
        goto L12
    L6:
        if (r100.isDirectory() == false) goto L8;
        return 0;
    L22:
        return r102;
    }

    public static void removeDir(String r100, Set<String> r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
        return;
    L5:
        if (r102.isDirectory() == false) goto L26;
        File[] r103 = r102.listFiles();
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.length;
    L10:
        if (r104 >= r105) goto L27;
        if (r103[r104].isDirectory() == false) goto L14;
        removeDir(r103[r104].getAbsolutePath(), r101);
    L19:
        r104 = r104 + 1;
        goto L10
    L14:
        String r106 = r103[r104].getName();
        if (r101 != null) goto L17;
    L18:
        r103[r104].delete();
        goto L19
    L17:
        if (r101.contains(r106) == true) goto L19;
    L27:
        return;
    L9:
        r105 = 0;
        goto L10
    }

    public static boolean copyFile(String r100, String r101, String r102) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
    L37:
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L37;
        if (StringUtils.isEmpty(r102) == true) goto L37;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L21 Exception -> L23
        boolean r105 = saveInputStream(r104, r101, r102);     // Catch: Throwable -> L17 Exception -> L19
        r104.close();     // Catch: Exception -> L14
    L16:
        return r105;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r103 = r104;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r103 != null) goto L40;
    L30:
        return false;
    L40:
        r103.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r103 = r104;
    L31:
        if (r103 != null) goto L42;
    L36:
        throw th;
    L42:
        r103.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean saveInputStream(InputStream r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L33 Exception -> L35
        if (r104.exists() == false) goto L9;
    L15:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r104, r102));     // Catch: Throwable -> L33 Exception -> L35
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L29 Exception -> L31
    L18:
        int r107 = r100.read(r106);     // Catch: Throwable -> L29 Exception -> L31
        if (r107 == (-1)) goto L21;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L29 Exception -> L31
        goto L18
    L21:
        r105.flush();     // Catch: Throwable -> L29 Exception -> L31
        r105.close();     // Catch: Throwable -> L29 Exception -> L31
        r100.close();     // Catch: Throwable -> L33 Exception -> L35
        r100.close();     // Catch: Exception -> L25
        return true;
    L25:
        e = move-exception;
        e.printStackTrace();
        return true;
    L31:
        e = e;
        r103 = r105;
    L36:
        Logger.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L33
        if (r103 == null) goto L62;
        r103.close();     // Catch: Exception -> L52
    L62:
        r100.close();     // Catch: Exception -> L41
    L43:
        return false;
    L41:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
        r103 = r105;
    L44:
        if (r103 == null) goto L65;
        r103.close();     // Catch: Exception -> L51
    L65:
        r100.close();     // Catch: Exception -> L48
        throw th;
    L48:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L9:
        if (r104.mkdirs() == true) goto L15;
        r100.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
    L33:
        th = th;
    L35:
        e = e;
        goto L36
    }
}
