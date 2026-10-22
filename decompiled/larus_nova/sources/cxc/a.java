package cxc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FileOutputStream f465749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FileInputStream f465750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Properties f465751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f465752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f465753e = null;

    static {
        f465753e = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.FileInputStream] */
    public static String a(Context r110) {
        int r100 = 0;
        if (f465753e.compareAndSet(false, true) == false) goto L84;
        monitor-enter(a.class);
        FileOutputStream r101 = null;
        FileInputStream r102 = null;
        r102 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        Properties r103 = new Properties();     // Catch: Throwable -> L47 FileNotFoundException -> L56
        if (new PolarisFileWrapper(r110.getFilesDir().getPath() + "/settings.properties").exists() == true) goto L11;
        FileOutputStream r104 = r110.openFileOutput("settings.properties", 0);     // Catch: Throwable -> L47 FileNotFoundException -> L56
    L106:
        r102 = r110.openFileInput("settings.properties");     // Catch: Throwable -> L45 FileNotFoundException -> L46
        if (r102 == null) goto L15;
        r103.load(r102);     // Catch: Throwable -> L45 FileNotFoundException -> L46
    L16:
        String r105 = r103.getProperty("encryptversion");     // Catch: Throwable -> L45 FileNotFoundException -> L46
        if (TextUtils.isEmpty(r105) == false) goto L28;
        if (r104 != null) goto L99;
    L22:
        if (r102 != null) goto L86;
    L26:
        monitor-exit(a.class);
    L68:
        f465752d = r105;
        goto L84
    L86:
        r102.close();     // Catch: IOException -> L25 Throwable -> L73
    L25:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        goto L26
    L99:
        r104.close();     // Catch: IOException -> L21 Throwable -> L73
    L21:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        goto L22
    L28:
        String[] r106 = fw7.a.f479008a;     // Catch: Throwable -> L45 FileNotFoundException -> L46
        int r107 = r106.length;     // Catch: Throwable -> L45 FileNotFoundException -> L46
        String[] r108 = new String[r107];     // Catch: Throwable -> L45 FileNotFoundException -> L46
        System.arraycopy(r106, 0, r108, 0, r106.length);     // Catch: Throwable -> L45 FileNotFoundException -> L46
    L29:
        if (r100 >= r107) goto L35;
        if ("encryptversion".equals(r108[r100]) == true) goto L32;
        r100 = r100 + 1;
        goto L29
    L32:
        r105 = nw7.a.a(r110, r105);     // Catch: Throwable -> L45 FileNotFoundException -> L46
        goto L35
    L35:
        if (r104 != null) goto L104;
    L39:
        if (r102 != null) goto L93;
    L43:
        monitor-exit(a.class);
        goto L68
    L93:
        r102.close();     // Catch: IOException -> L42 Throwable -> L73
    L42:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        goto L43
    L104:
        r104.close();     // Catch: IOException -> L38 Throwable -> L73
    L38:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        goto L39
    L15:
        exc.e.c("FileUtil", "getProperties inStream is null");     // Catch: Throwable -> L45 FileNotFoundException -> L46
    L46:
        r110 = r102;
        r101 = r104;
    L57:
        exc.e.b("FileUtil", "Can not find the file settings.properties");     // Catch: Throwable -> L69
        if (r101 != null) goto L101;
    L62:
        if (r110 == 0) goto L66;
        r110.close();     // Catch: IOException -> L65 Throwable -> L73
        r110 = r110;
    L90:
    L66:
        r105 = "";
        monitor-exit(a.class);
        goto L68
    L101:
        r101.close();     // Catch: IOException -> L61 Throwable -> L73
    L61:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
    L45:
        r110 = r102;
        r101 = r104;
    L48:
        exc.e.b("FileUtil", "Throwable / ");     // Catch: Throwable -> L69
        if (r101 != null) goto L95;
    L53:
        if (r110 == 0) goto L66;
        r110.close();     // Catch: IOException -> L65 Throwable -> L73
        r110 = r110;
        goto L90
    L95:
        r101.close();     // Catch: IOException -> L52 Throwable -> L73
    L52:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        goto L53
    L11:
        r104 = null;
    L69:
        th = move-exception;
        if (r101 != null) goto L97;
    L76:
        if (r110 == 0) goto L111;
        r110.close();     // Catch: Throwable -> L73 IOException -> L79
    L112:
        throw th;     // Catch: Throwable -> L73
    L79:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L111:
        throw th;     // Catch: Throwable -> L73
    L97:
        r101.close();     // Catch: Throwable -> L73 IOException -> L75
    L75:
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
    L56:
        r110 = 0;
    L47:
        r110 = 0;
    L65:
        r110 = "FileUtil";
        exc.e.b("FileUtil", "getProperties IOException / ");     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        throw th;
    L84:
        return f465752d;
    }

    public static boolean d(File r100) {
        exc.e.c("FileUtil", "deleteFile : file.getName");
        if (r100.exists() == true) goto L7;
        return true;
    L7:
        if (r100.isDirectory() == false) goto L14;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L14;
        d(r101[r103]);
        r103 = r103 + 1;
    L14:
        return r100.delete();
    }

    public static void b(Context r100, String r110) {
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getPath() != null) goto L7;
        return;
    L7:
        if (new PolarisFileWrapper(r101.getPath() + "/settings.properties").exists() == false) goto L12;
        FileInputStream r102 = r100.openFileInput("settings.properties");
        f465750b = r102;
        if (r102 == null) goto L11;
        f465751c.load(r102);
        goto L12
    L11:
        exc.e.c("FileUtil", "inStream is null");
    L12:
        f465749a = r100.openFileOutput("settings.properties", 0);
        String[] r103 = fw7.a.f479008a;
        int r104 = r103.length;
        String[] r105 = new String[r104];
        System.arraycopy(r103, 0, r105, 0, r103.length);
        int r106 = 0;
    L14:
        if (r106 >= r104) goto L19;
        if ("encryptversion".equals(r105[r106]) == true) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        String r107 = nw7.a.b(r100, r110);
    L20:
        int r108 = 0;
    L22:
        if (r107.length() <= 8388588) goto L32;
        if (r108 >= 3) goto L32;
        r108 = r108 + 1;
        exc.e.c("FileUtil", r108 + " mValue.length() is " + r107.length());
        int r109 = 0;
    L26:
        if (r109 >= r104) goto L22;
        if ("encryptversion".equals(r105[r109]) == true) goto L29;
        r109 = r109 + 1;
        goto L26
    L29:
        r107 = nw7.a.b(r100, r110);
    L32:
        if (r107.length() <= 8388588) goto L35;
        exc.e.b("FileUtil", "final mValue.length() is " + r107.length());
        return;
    L35:
        f465751c.setProperty("encryptversion", r107);
        FileOutputStream r111 = f465749a;
        if (r111 == null) goto L38;
        f465751c.store(r111, "accountagent");
        return;
    L38:
        exc.e.c("FileUtil", "outStream is null");
        return;
    L19:
        r107 = r110;
        goto L20
    }

    public static boolean e(String r100, byte[] r101) {
        if (r100 != null) goto L5;
    L57:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L57;
        if (TextUtils.isEmpty("accounts.xml") == true) goto L57;
        if (r101 == null) goto L57;
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L26 Exception -> L58 RuntimeException -> L59 IOException -> L60 FileNotFoundException -> L61
        if (r103.exists() == false) goto L14;
    L16:
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100.concat("accounts.xml")));     // Catch: Throwable -> L26 Exception -> L58 RuntimeException -> L59 IOException -> L60 FileNotFoundException -> L61
    L73:
        r104.write(r101);     // Catch: Throwable -> L20 Exception -> L22 RuntimeException -> L23 IOException -> L24 FileNotFoundException -> L25
        r104.close();     // Catch: IOException -> L36
    L67:
        return true;
    L25:
        r102 = r104;
    L24:
        r102 = r104;
    L23:
        r102 = r104;
    L22:
        r102 = r104;
    L20:
        Throwable th10 = th;
    L52:
        if (r104 != null) goto L64;
    L56:
        throw th10;
    L64:
        r104.close();     // Catch: IOException -> L55
    L55:
        exc.e.b("FileUtil", "IOException ");
        goto L56
    L14:
        if (r103.mkdirs() == true) goto L16;
        return false;
    L26:
        th = move-exception;
        th10 = th;
        r104 = null;
    L45:
        exc.e.b("FileUtil", "writeAgreement FileNotFoundException");     // Catch: Throwable -> L26
        if (r102 != null) goto L70;
    L50:
        return false;
    L70:
        r102.close();     // Catch: IOException -> L49
    L49:
        exc.e.b("FileUtil", "IOException ");
    L39:
        exc.e.b("FileUtil", "writeAgreement IOException");     // Catch: Throwable -> L26
        if (r102 != null) goto L62;
    L44:
        return false;
    L62:
        r102.close();     // Catch: IOException -> L43
    L43:
        exc.e.b("FileUtil", "IOException ");
    L32:
        exc.e.b("FileUtil", "RuntimeException ");     // Catch: Throwable -> L26
        if (r102 == null) goto L77;
        r102.close();     // Catch: IOException -> L36
        goto L67
    L77:
        return true;
    L28:
        exc.e.b("FileUtil", "Exception ");     // Catch: Throwable -> L26
        if (r102 == null) goto L76;
        r102.close();     // Catch: IOException -> L36
        goto L67
    L76:
        return true;
    L36:
        exc.e.b("FileUtil", "IOException ");
        return true;
    }

    public static void f(Context r100, String r101) {
        f465752d = r101;
        monitor-enter(a.class);
        if (r100 == null) goto L58;
        if (r101 == null) goto L58;
        f465749a = null;     // Catch: Throwable -> L61
        f465750b = null;     // Catch: Throwable -> L61
        f465751c = new Properties();     // Catch: Throwable -> L61
        b(r100, r101);     // Catch: Throwable -> L18 OutOfMemoryError -> L20 Exception -> L32
    L71:
        FileOutputStream r102 = f465749a;     // Catch: IOException -> L13 Throwable -> L61
        if (r102 == null) goto L14;
        r102.close();     // Catch: IOException -> L13 Throwable -> L61
    L14:
        FileInputStream r103 = f465750b;     // Catch: IOException -> L44 Throwable -> L61
        if (r103 == null) goto L75;
        r103.close();     // Catch: IOException -> L44 Throwable -> L61
    L75:
    L45:
        monitor-exit(a.class);
    L83:
        return;
    L13:
        exc.e.b("FileUtil", "setProperties IOException");     // Catch: Throwable -> L61
    L20:
        e = move-exception;
        exc.e.b("FileUtil", "OOMError : ".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L18
    L27:
        exc.e.b("FileUtil", "setProperties IOException");     // Catch: Throwable -> L61
    L28:
        FileInputStream r104 = f465750b;     // Catch: IOException -> L44 Throwable -> L61
        if (r104 == null) goto L75;
        r104.close();     // Catch: IOException -> L44 Throwable -> L61
        goto L75
    L24:
        if (f465749a == null) goto L28;
        f465749a.close();     // Catch: IOException -> L27 Throwable -> L61
    L32:
        e = move-exception;
        exc.e.b("FileUtil", "Exception : ".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L18
    L39:
        exc.e.b("FileUtil", "setProperties IOException");     // Catch: Throwable -> L61
    L40:
        FileInputStream r105 = f465750b;     // Catch: IOException -> L44 Throwable -> L61
        if (r105 == null) goto L75;
        r105.close();     // Catch: IOException -> L44 Throwable -> L61
        goto L75
    L36:
        if (f465749a == null) goto L40;
        f465749a.close();     // Catch: IOException -> L39 Throwable -> L61
    L18:
        th = move-exception;
        FileOutputStream r106 = f465749a;     // Catch: IOException -> L51 Throwable -> L61
        if (r106 == null) goto L73;
        r106.close();     // Catch: IOException -> L51 Throwable -> L61
    L73:
        FileInputStream r107 = f465750b;     // Catch: IOException -> L56 Throwable -> L61
        if (r107 == null) goto L81;
        r107.close();     // Catch: IOException -> L56 Throwable -> L61
    L82:
        throw th;     // Catch: Throwable -> L61
    L81:
        throw th;     // Catch: Throwable -> L61
    L56:
        exc.e.b("FileUtil", "IOException");     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L51:
        exc.e.b("FileUtil", "setProperties IOException");     // Catch: Throwable -> L61
    L44:
        exc.e.b("FileUtil", "IOException");     // Catch: Throwable -> L61
    L58:
        exc.e.c("FileUtil", "at least 1 param is null");     // Catch: Throwable -> L61
        monitor-exit(a.class);
        return;
    L61:
        th = move-exception;
        throw th;
    }

    public static void c(XmlSerializer r100, String r101, String r102) {
        r100.startTag("", r101);     // Catch: Exception -> L5 IOException -> L6 IllegalStateException -> L7 IllegalArgumentException -> L8
        r100.text(r102);     // Catch: Exception -> L5 IOException -> L6 IllegalStateException -> L7 IllegalArgumentException -> L8
        r100.endTag("", r101);     // Catch: Exception -> L5 IOException -> L6 IllegalStateException -> L7 IllegalArgumentException -> L8
    L15:
        return;
    L6:
        exc.e.b("FileUtil", "IOException ");
        return;
    L8:
        exc.e.b("FileUtil", "IllegalArgumentException  ");
        return;
    L7:
        exc.e.b("FileUtil", "IllegalStateException ");
        return;
    L5:
        exc.e.b("FileUtil", "Exception ");
    }
}
