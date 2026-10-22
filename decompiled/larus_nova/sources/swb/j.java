package swb;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f543775a = 0;

    static {
        new HashSet(Arrays.asList(new String[]{".tar.gz", ".tar.xz", ".tar.bz2"}));
    }

    public static void b(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == false) goto L23;
        if (r100.toFile().isDirectory() == false) goto L21;
        VFSFile[] r101 = r100.toFile().listFiles();
        if (r101 == null) goto L19;
        int r102 = r101.length;
        IOException e100 = null;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        h(r101[r103].getVfsPath());     // Catch: IOException -> L13
    L14:
        r103 = r103 + 1;
    L13:
        e100 = e;
        goto L14
    L15:
        if (e100 != null) goto L17;
        return;
    L17:
        throw e100;
    L19:
        throw new IOException("Failed to list contents of " + r100.getRealPath());
    L21:
        throw new IllegalArgumentException(r100.getRealPath() + " is not a directory");
    L23:
        throw new IllegalArgumentException(r100.getRealPath() + " does not exist");
    }

    public static void c(Closeable... r100) {
        if (r100.length <= 0) goto L15;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L22;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L14;
        r103.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", th.toString());
    L14:
        r102 = r102 + 1;
        goto L6
    L22:
        return;
    }

    public static void f(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L5;
        return;
    L5:
        b(r100);
        if (r100.toFile().delete() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to delete directory " + r100.getRealPath() + ".");
    }

    public static void g(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r100.toFile().isDirectory() == false) goto L9;
        f(r100);
        return;
    L9:
        if (r100.toFile().isFile() == false) goto L13;
        h(r100);
        return;
    }

    public static void h(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r100.toFile().isDirectory() == false) goto L8;
        f(r100);
        return;
    L8:
        boolean r101 = r100.toFile().exists();
        if (r100.toFile().delete() == true) goto L16;
        if (r101 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r100.getRealPath());
    L14:
        throw new IOException("Unable to delete file: " + r100.getRealPath());
    }

    public static String i(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "*/*";
    L6:
        if (r100.lastIndexOf(".") <= 0) goto L8;
        String r101 = r100.substring(r100.lastIndexOf(".") + 1, r100.length()).toLowerCase();
    L9:
        String r102 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r101);
        if (r102 != null) goto L13;
        r102 = "*/*";
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L16;
        return "*/*";
    L16:
        return r102;
    L8:
        r101 = "";
        goto L9
    }

    public static void a(VFSPath r100, VFSPath r101) throws FileNotFoundException {
        if (r100 == null) goto L12;
        if (r101 == null) goto L10;
        if (r100.toFile().exists() == false) goto L8;
        return;
    L8:
        throw new FileNotFoundException("Source '" + r100.getRealPath() + "' does not exist");
    L10:
        throw new NullPointerException("Destination must not be null");
    L12:
        throw new NullPointerException("Source must not be null");
    }

    public static void e(VFSPath r310, VFSPath r311) throws IOException {
        a(r310, r311);
        if (r310.toFile().isDirectory() == false) goto L115;
        if (r310.toFile().getCanonicalPath().equals(r311.toFile().getCanonicalPath()) == true) goto L113;
        String r100 = "' exists but is read-only";
        String r101 = "Destination '";
        if (r311.toFile().exists() == true) goto L9;
    L13:
        String[] r102 = r310.toFile().list();
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.length <= 0) goto L140;
        int r103 = r102.length;
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L141;
        String r105 = r102[r104];
        VFSPath r110 = r310.subPath(r105);
        VFSPath r111 = r311.subPath(r105);
        if (r110.toFile().isDirectory() == false) goto L22;
        r111.toFile().mkdirs();
        e(r110, r111);
        String r210 = r100;
        r101 = r101;
        r102 = r102;
        r103 = r103;
    L94:
        r104 = r104 + 1;
        r100 = r210;
        r101 = r101;
        r102 = r102;
        r103 = r103;
        goto L18
    L22:
        a(r110, r111);
        if (r110.toFile().isDirectory() == true) goto L110;
        if (r110.toFile().getCanonicalPath().equals(r111.toFile().getCanonicalPath()) == true) goto L108;
        File r106 = r111.toFile().getParentFile();
        if (r106 == null) goto L36;
        if (r106.mkdirs() == true) goto L36;
        if (r106.isDirectory() == true) goto L36;
        throw new IOException(r101 + r106 + "' directory cannot be created");
    L36:
        if (r111.toFile().exists() == true) goto L38;
    L42:
        VFSFile r112 = r110.toFile();
        VFSFile r107 = r111.toFile();
        if (r107.exists() == true) goto L45;
    L49:
        FileChannel r113 = null;
        PolarisFileInputStreamWrapper r114 = new PolarisFileInputStreamWrapper(r112);     // Catch: Throwable -> L80 IOException -> L84
        r210 = r100;
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L75 IOException -> L77
    L125:
        FileChannel r211 = r114.getChannel();     // Catch: Throwable -> L71 IOException -> L73
        r113 = r108.getChannel();     // Catch: Throwable -> L67 IOException -> L69
        long r212 = r211.size();     // Catch: Throwable -> L67 IOException -> L69
        long r312 = 0;
    L56:
        if (r312 >= r212) goto L66;
        long r213 = r212 - r312;     // Catch: Throwable -> L67 IOException -> L69
        if (r213 <= 31457280) goto L60;
        long r214 = 31457280;
    L61:
        long r215 = r113.transferFrom(r211, r312, r214);     // Catch: Throwable -> L67 IOException -> L69
    L63:
        if (r215 == 0) goto L66;
        r312 = r312 + r215;
        goto L56
    L60:
        r214 = r213;
    L66:
        r101 = r101;
        c(new Closeable[]{r113, r108, r211, r114});
        r102 = r102;
        boolean r115 = true;
    L90:
        long r109 = r112.length();
        long r116 = r107.length();
        if (r109 != r116) goto L98;
        r107.setLastModified(r112.lastModified());
        if (r115 == true) goto L94;
        throw new IOException("copyFile Error " + r110.getRealPath() + " " + r111.getRealPath());
    L98:
        throw new IOException("Failed to copy full contents from '" + r112 + "' to '" + r107 + "' Expected length: " + r109 + " Actual: " + r116);
    L69:
        e = e;
        r101 = r101;
        PolarisFileOutputStreamWrapper r117 = r108;
        FileChannel r118 = r113;
        r113 = r211;
    L116:
    L102:
        e = move-exception;
        throw e;     // Catch: Throwable -> L100
    L100:
        th = th;
        r211 = r113;
        int r119 = 4;
        r113 = r118;
        r108 = r117;
    L105:
        Closeable[] r120 = new Closeable[r119];
        r120[0] = r113;
        r120[1] = r108;
        r120[2] = r211;
        r120[3] = r114;
        c(r120);
        throw th;
    L87:
        if (Build.VERSION.SDK_INT < 26) goto L99;
        com.ss.android.lark.officesdk.utils.di.j.e("FileUtil", "Use Files copy method");     // Catch: Throwable -> L100 IOException -> L102
        Files.copy(r112.toPath(), r107.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L100 IOException -> L102
        c(new Closeable[]{r118, r117, r113, r114});
        r115 = false;
        goto L90
    L99:
        throw e;     // Catch: Throwable -> L100 IOException -> L102
    L67:
        th = th;
    L83:
        r119 = 4;
        goto L105
    L73:
        e = e;
    L79:
        r117 = r108;
        r118 = null;
    L71:
        th = th;
        r211 = null;
    L77:
        e = e;
        r108 = null;
    L75:
        th = th;
    L82:
        r108 = null;
        r211 = null;
        goto L83
    L84:
        e = e;
        r210 = r100;
        r101 = r101;
        r118 = null;
        r117 = null;
        r114 = null;
    L80:
        th = th;
        r114 = null;
        goto L82
    L45:
        if (r107.isDirectory() == false) goto L49;
        throw new IOException(r101 + r107 + "' exists but is a directory");
    L38:
        if (r111.toFile().canWrite() == true) goto L42;
        throw new IOException(r101 + r111.getRealPath() + r100);
    L108:
        throw new IOException("Source '" + r110.getRealPath() + "' and destination '" + r111.getRealPath() + "' are the same");
    L110:
        throw new IOException("Source '" + r110.getRealPath() + "' exists but is a directory");
    L141:
        return;
    L140:
        return;
    L9:
        if (r311.toFile().canWrite() == true) goto L13;
        throw new IOException("Destination '" + r311.getRealPath() + "' exists but is read-only");
    L113:
        throw new IOException("Source '" + r310.getRealPath() + "' and destination '" + r311.getRealPath() + "' are the same");
    L115:
        throw new IOException("Source '" + r310.getRealPath() + "' exists but is not a directory");
    }

    public static boolean d(Context r110, String r111, String r112) {
        InputStream r100 = null;
        String[] r101 = r110.getAssets().list(r111);     // Catch: Throwable -> L30 Exception -> L32
        if (r101 != null) goto L6;
    L11:
        InputStream r113 = r110.getAssets().open(r111);     // Catch: Throwable -> L30 Exception -> L32
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r112));     // Catch: Throwable -> L26 Exception -> L28
    L44:
        byte[] r115 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L15:
        int r102 = r113.read(r115);     // Catch: Throwable -> L22 Exception -> L24
        if (r102 == (-1)) goto L18;
        r114.write(r115, 0, r102);     // Catch: Throwable -> L22 Exception -> L24
        goto L15
    L18:
        r114.flush();     // Catch: Throwable -> L22 Exception -> L24
        r113.close();     // Catch: Throwable -> L22 Exception -> L24
        r114.close();     // Catch: Throwable -> L22 Exception -> L24
        r100 = r113;
    L20:
        c(new Closeable[]{r100, r114});
        return true;
    L24:
        e = move-exception;
        r100 = r113;
        e = e;
    L40:
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());     // Catch: Throwable -> L37
        c(new Closeable[]{r100, r114});
        return false;
    L37:
        th = th;
    L38:
        c(new Closeable[]{r100, r114});
        throw th;
    L22:
        th = move-exception;
        r100 = r113;
        th = th;
    L28:
        e = move-exception;
        r100 = r113;
        e = e;
        r114 = null;
    L26:
        th = move-exception;
        r100 = r113;
        th = th;
        r114 = null;
        goto L38
    L6:
        if (r101.length <= 0) goto L11;
        new PolarisFileWrapper(r112).mkdirs();     // Catch: Throwable -> L30 Exception -> L32
        int r103 = r101.length;     // Catch: Throwable -> L30 Exception -> L32
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        String r105 = r101[r104];     // Catch: Throwable -> L30 Exception -> L32
        d(r110, r111 + HTTP.URL_DEFAULT + r105, r112 + HTTP.URL_DEFAULT + r105);     // Catch: Throwable -> L30 Exception -> L32
        r104 = r104 + 1;     // Catch: Throwable -> L30 Exception -> L32
        goto L8
    L10:
        r114 = null;
    L32:
        e = e;
        r114 = null;
    L30:
        th = th;
        r114 = null;
        goto L38
    }
}
