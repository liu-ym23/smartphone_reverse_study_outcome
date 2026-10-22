package l17;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.ZipEntry;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f507007a;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashSet f507008a;

        public a(HashSet r100) {
            this.f507008a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            if (TextUtils.isEmpty(r101) == false) goto L5;
            return false;
        L5:
            if (r101.endsWith("_md5") == true) goto L7;
            return false;
        L7:
            if (this.f507008a.size() > 0) goto L10;
            return true;
        L10:
            return !this.f507008a.contains(r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public static JSONObject e() {
        JSONObject r100 = f507007a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        AssetManager r101 = TTWebContext.h().getContext().getAssets();
        StringBuilder r102 = new StringBuilder();
        ?? r103 = 0;
        BufferedReader r104 = null;
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r101.open("ttwebview.json")));     // Catch: Throwable -> L19 Exception -> L21
    L45:
        String r106 = r105.readLine();     // Catch: Throwable -> L15 Exception -> L17
        if (r106 == null) goto L10;
        r102.append(r106);     // Catch: Throwable -> L15 Exception -> L17
        goto L45
    L10:
        f507007a = new JSONObject(r102.toString());     // Catch: Throwable -> L15 Exception -> L17
        String r107 = "com\\.bytedance\\.shell";
        f507007a.putOpt("process_feature", f507007a.optString("process_feature", "").replaceAll("com\\.bytedance\\.shell", TTWebContext.h().getContext().getPackageName()));     // Catch: Throwable -> L15 Exception -> L17
        k.d(new String[]{"getJsonFromAssetsFile ret: " + f507007a});     // Catch: Throwable -> L15 Exception -> L17
        r105.close();     // Catch: IOException -> L13
        r103 = r107;
    L28:
        return f507007a;
    L13:
        e = move-exception;
        k.b(new String[]{e.toString()});
        r103 = r107;
        goto L28
    L17:
        e = e;
        r104 = r105;
    L22:
        k.b(new String[]{"getJsonFromAssetsFile error:" + e.toString()});     // Catch: Throwable -> L19
        f507007a = new JSONObject();     // Catch: Throwable -> L19
        r103 = r104;
        if (r104 == null) goto L28;
        r104.close();     // Catch: IOException -> L26
        r103 = r104;
    L26:
        e = move-exception;
        k.b(new String[]{e.toString()});
        r103 = r104;
    L15:
        th = th;
        r103 = r105;
    L30:
        if (r103 != 0) goto L38;
    L35:
        throw th;
    L38:
        r103.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        k.b(new String[]{e.toString()});
    L19:
        th = th;
    L21:
        e = e;
        goto L22
    }

    public static void c() {
        File[] r100 = TTWebContext.h().getContext().getCacheDir().listFiles(new h());
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length == 0) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        File r103 = r100[r102];
        r.d("[Delete] Delete ttwebview cache dir: " + r103.getName());
        b(r103, true);
        r102 = r102 + 1;
        goto L8
    L13:
        return;
    }

    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101.append(Integer.toString((r100[r102] & UByte.MAX_VALUE) + 256, 16).substring(1));
        r102 = r102 + 1;
        goto L4
    L7:
        return r101.toString().toLowerCase(Locale.getDefault());
    }

    public static boolean d(HashSet<String> r100) {
        HashSet r101 = new HashSet();
        if (r100 == null) goto L10;
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r101.add(r103 + "_md5");
    L10:
        PolarisFileWrapper r104 = new PolarisFileWrapper(m.a());
        if (r104.isDirectory() == true) goto L13;
        return false;
    L13:
        File[] r105 = r104.listFiles(new a(r101));
        if (r105 == null) goto L37;
        int r106 = 0;
    L18:
        if (r106 >= r105.length) goto L31;
        if (r105[r106].isDirectory() == true) goto L23;
        k.b(new String[]{r105[r106].getName() + " is not a directory"});
    L29:
        r106 = r106 + 1;
        goto L18
    L23:
        if (r105[r106].getName().startsWith("deleted_") == true) goto L29;
        r.d("[Delete] Delete fileDir: " + r105[r106].getName() + " stack:" + Log.getStackTraceString(new Throwable()));
        StringBuilder r107 = new StringBuilder("deleted_");
        r107.append(r105[r106].getName());
        PolarisFileWrapper r108 = new PolarisFileWrapper(r105[r106].getParent() + HTTP.URL_DEFAULT + r107.toString());
        if (r105[r106].renameTo(r108) == true) goto L28;
        k.d(new String[]{"rename folder " + r105[r106].getName() + " failed"});
        goto L29
    L28:
        r105[r106] = r108;
        goto L29
    L31:
        if (r105.length > 0) goto L33;
        k.d(new String[]{"no need to delete files"});
        goto L37
    L33:
        int r109 = r105.length - 0;
        int r110 = 0;
    L34:
        if (r110 >= r109) goto L37;
        k.d(new String[]{"delete files=" + r105[r110]});
        b(r105[r110], true);
        r110 = r110 + 1;
    L37:
        if (r105.length == 0) goto L51;
        return true;
    L51:
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777316), block:B:29:0x0064 */
    public static String g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        InputStream r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L19 Exception -> L21
    L39:
        byte[] r103 = new byte[1024];     // Catch: Exception -> L17 Throwable -> L28
        MessageDigest r104 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L17 Throwable -> L28
        int r105 = 0;
    L10:
        if (r105 == (-1)) goto L14;
        r105 = r102.read(r103);     // Catch: Exception -> L17 Throwable -> L28
        if (r105 <= 0) goto L10;
        r104.update(r103, 0, r105);     // Catch: Exception -> L17 Throwable -> L28
        goto L10
    L14:
        String r106 = a(r104.digest());     // Catch: Exception -> L17 Throwable -> L28
        r102.close();     // Catch: Exception -> L33
    L16:
        return r106;
    L17:
        Exception e100 = e;
    L24:
        k.d(new String[]{"calculate md5 error: " + e100 + " path: " + r100});     // Catch: Throwable -> L28
        if (r102 != null) goto L43;
    L27:
        return "";
    L43:
        r102.close();     // Catch: Exception -> L34
    L28:
        th = th;
        r101 = r3;
    L30:
        if (r101 != null) goto L37;
    L32:
        throw th;
    L37:
        r101.close();     // Catch: Exception -> L35
    L21:
        e = move-exception;
        r102 = null;
        e100 = e;
    L19:
        th = th;
        goto L30
    }

    public static void b(File r100, boolean r101) {
        if (r100 != null) goto L16;
        return;
    L16:
    L13:
        e = move-exception;
        k.b(new String[]{"deleteRecursive File list error", e.toString()});
        return;
    L6:
        if (r100.isDirectory() == false) goto L10;
        File[] r102 = r100.listFiles();     // Catch: Exception -> L13
        int r103 = r102.length;     // Catch: Exception -> L13
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        b(r102[r104], true);     // Catch: Exception -> L13
        r104 = r104 + 1;     // Catch: Exception -> L13
    L10:
        if (r101 == false) goto L19;
        r100.delete();     // Catch: Exception -> L13
        return;
    }

    public static boolean f(Context r100, String r101) {
        InputStream r102 = r100.getAssets().open(r101);     // Catch: IOException -> L8
        if (r102 == null) goto L12;
        r102.close();     // Catch: IOException -> L8
        return true;
    L12:
        return true;
    L8:
        return false;
    }

    public static void i(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
        return;
    L5:
        byte[] r103 = new byte[4096];
        PolarisZipFileWrapper r104 = null;
        InputStream r105 = null;
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileOutputStreamWrapper r107 = null;
        r104 = null;
        PolarisZipFileWrapper r108 = new PolarisZipFileWrapper(r102);     // Catch: Throwable -> L47 Exception -> L49
        Enumeration<? extends ZipEntry> r109 = r108.entries();     // Catch: Throwable -> L39 Exception -> L43
        PolarisFileOutputStreamWrapper r110 = null;
    L107:
        if (r109.hasMoreElements() == false) goto L85;
        ZipEntry r111 = r109.nextElement();     // Catch: Throwable -> L35 Exception -> L37
        if (r111.getName().contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L13;
        r105 = r108.getInputStream(r111);     // Catch: Throwable -> L35 Exception -> L37
        PolarisFileWrapper r112 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L35 Exception -> L37
        if (r112.exists() == true) goto L17;
        r112.mkdirs();     // Catch: Throwable -> L35 Exception -> L37
    L17:
        String r113 = r111.getName();     // Catch: Throwable -> L35 Exception -> L37
        if (r113.contains(HTTP.URL_DEFAULT) == false) goto L20;
        r113 = r113.substring(r113.lastIndexOf(47) + 1, r113.length());     // Catch: Throwable -> L35 Exception -> L37
    L20:
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r101, r113));     // Catch: Throwable -> L35 Exception -> L37
    L105:
        int r115 = r105.read(r103);     // Catch: Throwable -> L26 Exception -> L28
        if (r115 == (-1)) goto L24;
        r114.write(r103, 0, r115);     // Catch: Throwable -> L26 Exception -> L28
        goto L105
    L24:
        r105.close();     // Catch: Throwable -> L26 Exception -> L28
        r114.close();     // Catch: Throwable -> L26 Exception -> L28
        r110 = r114;
        goto L107
    L28:
        e = e;
        InputStream r116 = r105;
    L46:
        r104 = r108;
    L95:
        e.printStackTrace();     // Catch: Throwable -> L68
        e.toString();     // Catch: Throwable -> L68
        if (r104 != null) goto L97;
    L57:
        if (r116 != null) goto L91;
    L62:
        if (r114 == null) goto L116;
        r114.close();     // Catch: IOException -> L65
        return;
    L65:
        e = move-exception;
        e.printStackTrace();
        return;
    L116:
        return;
    L91:
        r116.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L97:
        r104.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L68:
        th = th;
    L69:
        if (r104 != null) goto L99;
    L74:
        if (r116 != null) goto L93;
    L79:
        if (r114 == null) goto L118;
        r114.close();     // Catch: IOException -> L82
        throw th;
    L82:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L118:
        throw th;
    L93:
        r116.close();     // Catch: IOException -> L77
    L77:
        e = move-exception;
        e.printStackTrace();
        goto L79
    L99:
        r104.close();     // Catch: IOException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
    L26:
        th = th;
        r116 = r105;
    L42:
        r104 = r108;
        goto L69
    L13:
        k.b(new String[]{"Exists parent path [../] override risk."});     // Catch: Throwable -> L35 Exception -> L37
        goto L107
    L85:
        r108.close();     // Catch: IOException -> L32
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
        return;
    L37:
        e = e;
        r116 = r105;
        r106 = r110;
    L45:
        r114 = r106;
    L35:
        th = th;
        r116 = r105;
        r107 = r110;
    L41:
        r114 = r107;
        goto L42
    L43:
        e = e;
        r116 = null;
    L39:
        th = th;
        r116 = null;
        goto L41
    L49:
        e = e;
        r116 = null;
        r114 = null;
    L47:
        th = th;
        r116 = null;
        r114 = null;
        goto L69
    }

    public static boolean h(String r100, String r101, String r102, String r103, String r110) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);
        if (r104.exists() == true) goto L5;
        return false;
    L5:
        PolarisZipFileWrapper r105 = null;
        PolarisZipFileWrapper r106 = new PolarisZipFileWrapper(r104);     // Catch: Throwable -> L62 Exception -> L64
    L130:
        ZipEntry r107 = r106.getEntry(r102 + r103);     // Catch: Throwable -> L56 Exception -> L59
        if (r107 != null) goto L16;
        r.b("[Unzip] can't find " + r102 + r103 + " in " + r100);     // Catch: Throwable -> L56 Exception -> L59
        r106.close();     // Catch: IOException -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L16:
        if (r107.getName().contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L23;
        r.b("[Unzip] Exists parent path [../] override risk." + r103);     // Catch: Throwable -> L56 Exception -> L59
        r106.close();     // Catch: IOException -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L23:
        InputStream r108 = r106.getInputStream(r107);     // Catch: Throwable -> L56 Exception -> L59
        if (r110 != null) goto L128;
        r110 = r103;
    L128:
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r101, r110));     // Catch: Throwable -> L52 Exception -> L54
    L124:
        byte[] r111 = new byte[4096];     // Catch: Throwable -> L48 Exception -> L50
    L30:
        int r112 = r108.read(r111);     // Catch: Throwable -> L48 Exception -> L50
        if (r112 == (-1)) goto L104;
        r109.write(r111, 0, r112);     // Catch: Throwable -> L48 Exception -> L50
    L104:
        r106.close();     // Catch: IOException -> L36
    L122:
        r108.close();     // Catch: IOException -> L40
    L116:
        r109.close();     // Catch: IOException -> L44
        return true;
    L44:
        e = move-exception;
        e.printStackTrace();
        return true;
    L40:
        e = move-exception;
        e.printStackTrace();
    L36:
        e = move-exception;
        e.printStackTrace();
    L50:
        Exception e100 = e;
    L61:
        r105 = r106;
    L106:
        r.c("[Unzip] unzip failed!" + r103, e100);     // Catch: Throwable -> L83
        e100.toString();     // Catch: Throwable -> L83
        if (r105 != null) goto L108;
    L72:
        if (r108 != null) goto L100;
    L77:
        if (r109 != null) goto L118;
    L82:
        return false;
    L118:
        r109.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
        goto L82
    L100:
        r108.close();     // Catch: IOException -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L108:
        r105.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L83:
        Throwable th10 = th;
    L84:
        if (r105 != null) goto L110;
    L89:
        if (r108 != null) goto L102;
    L94:
        if (r109 == null) goto L132;
        r109.close();     // Catch: IOException -> L97
        throw th10;
    L97:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L132:
        throw th10;
    L102:
        r108.close();     // Catch: IOException -> L92
    L92:
        e = move-exception;
        e.printStackTrace();
        goto L94
    L110:
        r105.close();     // Catch: IOException -> L87
    L87:
        e = move-exception;
        e.printStackTrace();
    L48:
        th10 = th;
    L58:
        r105 = r106;
    L54:
        e = move-exception;
        e100 = e;
        r109 = null;
    L52:
        th = move-exception;
        th10 = th;
        r109 = null;
    L59:
        e = move-exception;
        e100 = e;
        r108 = null;
        r109 = null;
    L56:
        th = move-exception;
        th10 = th;
        r108 = null;
        r109 = null;
    L64:
        e = move-exception;
        e100 = e;
        r108 = null;
        r109 = null;
    L62:
        th = move-exception;
        th10 = th;
        r108 = null;
        r109 = null;
        goto L84
    }
}
