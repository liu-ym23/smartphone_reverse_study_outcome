package rsa;

import android.content.Context;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.downloadlib.constants.MimeType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f539154a;

        public a(String r100) {
            this.f539154a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            if (r101.startsWith(this.f539154a) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.endsWith(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) == false) goto L7;
            return true;
        }
    }

    public static void f(File r100) {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L24;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L12;
        f(r104);
        r104.delete();     // Catch: Exception -> L17
    L15:
        r103 = r103 + 1;
        goto L5
    L12:
        if (r104.exists() == false) goto L15;
        f(r104);
        r104.delete();     // Catch: Exception -> L17
        goto L15
    L24:
        return;
    }

    public static void g(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L6;
        r101.delete();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    public static byte[] i(PolarisFileWrapper r100) {
        ?? r101 = r100.exists();
        ?? r102 = 0;
        if (r101 != 0) goto L55;
        CertLog.e("FileUtils", "File doesn't exist!");
        return null;
    L55:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L29
    L19:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L15
        if (r103 != null) goto L47;
    L34:
        return null;
    L47:
        r103.close();     // Catch: IOException -> L42
    L17:
        e = e;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L15
        if (r103 != null) goto L50;
    L28:
        return null;
    L50:
        r103.close();     // Catch: IOException -> L41
        goto L28
    L8:
        if (r103.getChannel().size() != 0) goto L12;
        CertLog.d("FileUtils", "The FileInputStream has no content!");     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
        r103.close();     // Catch: IOException -> L38
    L11:
        return null;
    L12:
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
        r103.read(r104);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
        r103.close();     // Catch: IOException -> L39
    L14:
        return r104;
    L29:
        e = e;
        r103 = null;
    L23:
        e = e;
        r103 = null;
    L21:
        th = th;
    L35:
        if (r102 != 0) goto L52;
    L37:
        throw th;
    L52:
        r102.close();     // Catch: IOException -> L40
    L15:
        th = th;
        r102 = r101;
        goto L35
    }

    public static boolean k(PolarisFileWrapper r100) {
        boolean r101 = false;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L33 IOException -> L37
        goto L38
    L55:
        byte[] r104 = new byte[12];     // Catch: Throwable -> L30 IOException -> L32
        if (r103.read(r104) >= 12) goto L10;
        r103.close();     // Catch: Exception -> L42
    L8:
        return false;
    L10:
        byte r105 = r104[4];     // Catch: Throwable -> L30 IOException -> L32
        if (r105 != 102) goto L19;
        if (r104[5] != 116) goto L19;
        if (r104[6] != 121) goto L19;
        if (r104[7] != 112) goto L19;
    L27:
        r101 = true;
    L47:
        r103.close();     // Catch: Exception -> L41
    L29:
        return r101;
    L19:
        if (r105 != 109) goto L47;
        if (r104[5] != 111) goto L47;
        if (r104[6] != 111) goto L47;
    L26:
        if (r104[7] != 118) goto L47;
    L32:
        r102 = r103;
    L30:
        th = th;
        r102 = r103;
    L34:
        if (r102 != null) goto L49;
    L36:
        throw th;
    L49:
        r102.close();     // Catch: Exception -> L43
    L33:
        th = th;
    L38:
        if (r102 != null) goto L45;
    L40:
        return false;
    L45:
        r102.close();     // Catch: Exception -> L44
        goto L40
    }

    public static Pair<Boolean, String> l(String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L5;
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        if (r100.exists() == true) goto L11;
        return new Pair(Boolean.FALSE, "file not exists");
    L11:
        if (r100.isFile() == false) goto L13;
        long r101 = r100.length();
        if (r101 > 0) goto L19;
        return new Pair(Boolean.FALSE, "file is empty (size: " + r101 + " bytes)");
    L19:
        if (r110.toLowerCase().endsWith(".mp4") == false) goto L21;
        MediaMetadataRetriever r102 = null;
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();     // Catch: Throwable -> L80 Exception -> L82
        r103.setDataSource(r110);     // Catch: Throwable -> L31 Exception -> L78
        String r111 = b(r103, 12);     // Catch: Throwable -> L31 Exception -> L78
        if (TextUtils.isEmpty(r111) == false) goto L34;
        if (k(r100) == true) goto L43;
        Pair<Boolean, String> r112 = new Pair(Boolean.FALSE, "MIME type is null and file header is not MP4");     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L91
    L30:
        return r112;
    L43:
        String r113 = b(r103, 18);     // Catch: Throwable -> L31 Exception -> L78
        String r104 = b(r103, 19);     // Catch: Throwable -> L31 Exception -> L78
        if (TextUtils.isEmpty(r113) == false) goto L46;
    L75:
        Pair<Boolean, String> r114 = new Pair(Boolean.FALSE, "failed to get video resolution");     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L98
    L77:
        return r114;
    L46:
        if (TextUtils.isEmpty(r104) == true) goto L75;
        int r105 = Integer.parseInt(r113);     // Catch: Throwable -> L31 NumberFormatException -> L72 Exception -> L78
        int r106 = Integer.parseInt(r104);     // Catch: Throwable -> L31 NumberFormatException -> L72 Exception -> L78
        if (r105 <= 0) goto L69;
        if (r106 <= 0) goto L69;
        String r115 = b(r103, 9);     // Catch: Throwable -> L31 Exception -> L78
        if (TextUtils.isEmpty(r115) == false) goto L118;
        Pair<Boolean, String> r116 = new Pair(Boolean.FALSE, "failed to get video duration");     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L92
    L57:
        return r116;
    L118:
        long r107 = Long.parseLong(r115);     // Catch: Throwable -> L31 NumberFormatException -> L66 Exception -> L78
        if (r107 > 0) goto L63;
        Pair<Boolean, String> r108 = new Pair(Boolean.FALSE, "invalid video duration: " + r107 + "ms");     // Catch: Throwable -> L31 NumberFormatException -> L66 Exception -> L78
        r103.release();     // Catch: Exception -> L93
    L62:
        return r108;
    L63:
        Pair<Boolean, String> r109 = new Pair(Boolean.TRUE, r115);     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L94
    L65:
        return r109;
    L66:
        Pair<Boolean, String> r117 = new Pair(Boolean.FALSE, "invalid duration format: " + r115);     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L95
    L68:
        return r117;
    L69:
        Pair<Boolean, String> r118 = new Pair(Boolean.FALSE, "invalid video resolution: " + r105 + "x" + r106);     // Catch: Throwable -> L31 NumberFormatException -> L72 Exception -> L78
        r103.release();     // Catch: Exception -> L96
    L71:
        return r118;
    L72:
        Pair<Boolean, String> r119 = new Pair(Boolean.FALSE, "invalid resolution format: " + r113 + "x" + r104);     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L97
    L74:
        return r119;
    L34:
        if (MimeType.MP4.equals(r111) == true) goto L43;
        Boolean r120 = Boolean.FALSE;     // Catch: Throwable -> L31 Exception -> L78
        if (r111 != null) goto L39;
        r111 = "null";
    L39:
        Pair<Boolean, String> r121 = new Pair(r120, "invalid MP4 MIME type: ".concat(r111));     // Catch: Throwable -> L31 Exception -> L78
        r103.release();     // Catch: Exception -> L99
    L41:
        return r121;
    L78:
        e = e;
        r102 = r103;
    L83:
        e.printStackTrace();     // Catch: Throwable -> L80
        Pair<Boolean, String> r122 = new Pair(Boolean.FALSE, "exception:" + e.getMessage());     // Catch: Throwable -> L80
        if (r102 != null) goto L120;
    L86:
        return r122;
    L120:
        r102.release();     // Catch: Exception -> L101
    L31:
        th = th;
    L88:
        if (r103 != null) goto L129;
    L90:
        throw th;
    L129:
        r103.release();     // Catch: Exception -> L100
    L82:
        e = e;
    L80:
        th = th;
        r103 = r102;
        goto L88
    L21:
        return new Pair(Boolean.FALSE, "not an MP4 file (extension mismatch)");
    L13:
        return new Pair(Boolean.FALSE, "path is not a file");
    L5:
        return new Pair(Boolean.FALSE, "empty video path");
    }

    public static byte[] m(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L12 Exception -> L14
        byte[] r103 = new byte[(int) r101.length()];     // Catch: Exception -> L10 Throwable -> L23
        r102.read(r103);     // Catch: Exception -> L10 Throwable -> L23
        r102.close();     // Catch: Exception -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = e;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L23
        if (r102 != null) goto L30;
    L22:
        return null;
    L30:
        r102.close();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        Throwable th10 = th;
    L24:
        if (r102 != null) goto L35;
    L29:
        throw th10;
    L35:
        r102.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L14:
        e = e;
        r102 = null;
    L12:
        th = move-exception;
        r102 = null;
        th10 = th;
        goto L24
    }

    public static String a(ExifInterface r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100020, "android/media/ExifInterface", "getAttribute", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.getAttribute(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String b(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void c(Context r100, String r101) {
        String r102 = j(r100, r101);
        if (r102 == null) goto L26;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == true) goto L27;
    L21:
        r103.delete();
        return;
    L7:
        if (r103.exists() == false) goto L9;
        r103.delete();     // Catch: IOException -> L21
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.getParentFile().getAbsolutePath());     // Catch: IOException -> L21
        if (r104.exists() == true) goto L12;
        r104.mkdirs();     // Catch: IOException -> L21
    L12:
        r103.createNewFile();     // Catch: IOException -> L21
        InputStream r105 = r100.getApplicationContext().getAssets().open(r101);     // Catch: IOException -> L21
        if (r105 != null) goto L15;
        return;
    L15:
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r103);     // Catch: IOException -> L21
        byte[] r107 = new byte[4096];     // Catch: IOException -> L21
    L16:
        int r108 = r105.read(r107);     // Catch: IOException -> L21
        if (r108 <= 0) goto L19;
        r106.write(r107, 0, r108);     // Catch: IOException -> L21
        goto L16
    L19:
        r105.close();     // Catch: IOException -> L21
        r106.close();     // Catch: IOException -> L21
        return;
    L27:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static String d(Context r100, Uri r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getCacheDir(), "image_cache");
        ?? r103 = 0;
        if (r102.exists() == false) goto L5;
    L7:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, "cert-temp-" + System.currentTimeMillis());
        r100 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: Throwable -> L25 Exception -> L27
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L21 Exception -> L23
    L59:
        byte[] r106 = new byte[1024];     // Catch: Exception -> L19 Throwable -> L37
    L12:
        int r107 = r100.read(r106);     // Catch: Exception -> L19 Throwable -> L37
        if (r107 <= 0) goto L15;
        r105.write(r106, 0, r107);     // Catch: Exception -> L19 Throwable -> L37
        goto L12
    L15:
        String r108 = r104.getAbsolutePath();     // Catch: Exception -> L19 Throwable -> L37
        r100.close();     // Catch: IOException -> L46
    L50:
        r105.close();     // Catch: IOException -> L47
    L18:
        return r108;
    L19:
        e = e;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L37
        if (r100 != 0) goto L63;
    L34:
        if (r105 != null) goto L57;
    L36:
        return null;
    L57:
        r105.close();     // Catch: IOException -> L48
        goto L36
    L63:
        r100.close();     // Catch: IOException -> L33
    L23:
        e = e;
        r105 = null;
    L21:
        th = th;
        r101 = null;
    L38:
        r103 = r100;
        ?? r109 = r101;
    L39:
        if (r103 != 0) goto L61;
    L43:
        if (r109 == 0) goto L69;
        r109.close();     // Catch: IOException -> L49
        throw th;
    L70:
        throw th;
    L69:
        throw th;
    L61:
        r103.close();     // Catch: IOException -> L42
        goto L43
    L37:
        th = th;
    L27:
        e = e;
        r100 = 0;
        r105 = null;
    L25:
        th = th;
        r109 = 0;
        goto L39
    L5:
        if (r102.mkdirs() == true) goto L7;
        return null;
    }

    public static void e(ExifInterface r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L30;
        ExifInterface r102 = new ExifInterface(r101);     // Catch: Exception -> L19
        Field[] r103 = ExifInterface.class.getFields();     // Catch: Exception -> L19
        int r104 = 0;
    L6:
        if (r104 >= r103.length) goto L17;
        String r105 = r103[r104].getName();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r105) == true) goto L16;
        if (r105.startsWith("TAG") == false) goto L16;
        if (r105.startsWith("TAG_GPS") == true) goto L16;
        String r106 = r103[r104].get(ExifInterface.class).toString();     // Catch: Exception -> L19
        String r107 = a(r100, r106);     // Catch: Exception -> L19
        if (r107 == null) goto L16;
        r102.setAttribute(r106, r107);     // Catch: Exception -> L19
    L16:
        r104 = r104 + 1;     // Catch: Exception -> L19
        goto L6
    L17:
        r102.saveAttributes();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String h(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
    L13:
        return "";
    L5:
        if (r102.isDirectory() == false) goto L13;
        String[] r103 = r102.list(new a(r101));
        if (r103 == null) goto L13;
        if (r103.length <= 0) goto L13;
        return r100 + HTTP.URL_DEFAULT + r103[0];
    }

    public static String j(Context r100, String r101) {
        File r102 = r100.getApplicationContext().getFilesDir();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getAbsolutePath() + File.separator + r101;
    }

    public static String n(Context r100, byte[] r101, String r102) {
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getFilesDir() + "/img_cert/");     // Catch: Throwable -> L17 Exception -> L19
        if (r104.exists() == true) goto L6;
        r104.mkdirs();     // Catch: Throwable -> L17 Exception -> L19
    L6:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, r102);     // Catch: Throwable -> L17 Exception -> L19
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L17 Exception -> L19
        r106.write(r101);     // Catch: Throwable -> L13 Exception -> L15
        String r107 = r105.getAbsolutePath();     // Catch: Throwable -> L13 Exception -> L15
        r106.close();     // Catch: Exception -> L10
    L12:
        return r107;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L15:
        e = e;
        r103 = r106;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L17
        if (r103 == null) goto L44;
        r103.close();     // Catch: Exception -> L24
        return "";
    L24:
        e = move-exception;
        e.printStackTrace();
        return "";
    L44:
        return "";
    L13:
        th = th;
        r103 = r106;
    L28:
        if (r103 != null) goto L36;
    L33:
        throw th;
    L36:
        r103.close();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L19:
        e = e;
        goto L20
    }
}
