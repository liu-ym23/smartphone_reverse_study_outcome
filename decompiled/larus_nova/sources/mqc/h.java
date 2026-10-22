package mqc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes41.dex */
public final class h {
    public static String a(File r100) {
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L18
        ZipEntry r102 = r101.getEntry("assets/zeus_plugin_info");     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        InputStream r103 = r101.getInputStream(r102);     // Catch: Throwable -> L16
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L16
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r103));     // Catch: Throwable -> L26
        String r106 = r105.readLine();     // Catch: Throwable -> L26
    L8:
        if (r106 == null) goto L11;
        r104.append(r106);     // Catch: Throwable -> L26
        r104.append("\n");     // Catch: Throwable -> L26
        r106 = r105.readLine();     // Catch: Throwable -> L26
    L11:
        i.a(r103);     // Catch: Throwable -> L16
        String r107 = r104.toString();     // Catch: Throwable -> L16
        i.b(r101);
        return r107;
    L14:
        i.b(r101);
        return "";
    L16:
        th = th;
    L31:
        ZeusLogger.w("ExtraInfoUtils", "getExtraInfo failed: " + th.getMessage(), th);     // Catch: Throwable -> L23
        i.b(r101);
        return "";
    L23:
        th = move-exception;
        i.b(r101);
        throw th;
    L18:
        th = th;
        r101 = null;
        goto L31
    }

    public static void b(String r100, int r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        SharedPreferences.Editor r103 = t.c().f514970a.edit();
        r103.putString("extra_info_" + r100 + "_" + r101, r102);
        r103.apply();
        return;
    }
}
