package zz2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.util.f;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f574058a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f574059b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f574060c = "";

    public static String b(Context r100, String r101, boolean r102) {
        byte[] r103 = new byte[1024];
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        InputStream r105 = null;
        if (r102 == false) goto L5;
        InputStream r106 = r100.getAssets().open(r101);     // Catch: Throwable -> L13 Exception -> L15
    L6:
        r105 = r106;
    L7:
        int r107 = r105.read(r103);     // Catch: Throwable -> L13 Exception -> L15
        if (r107 == (-1)) goto L11;
        r104.write(r103, 0, r107);     // Catch: Throwable -> L13 Exception -> L15
        goto L7
    L11:
        r105.close();     // Catch: Exception -> L20
    L23:
        return r104.toString();
    L5:
        r106 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L13 Exception -> L15
    L15:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L13
        if (r105 == null) goto L23;
        r105.close();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        f.b(e);
    L13:
        th = move-exception;
        if (r105 != null) goto L32;
    L29:
        throw th;
    L32:
        r105.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        f.b(e);
        goto L29
    }

    public static String a(Context r100, String r101, String r102, boolean r103) {
        if (TextUtils.isEmpty(f574058a) == false) goto L9;
        if (TextUtils.isEmpty(r101) == false) goto L7;
        f574058a = b(r100, "webview_monitor_js_file_v2/slardar_sdk.js", true);
        goto L9
    L7:
        f574058a = b(r100, r101, false);
    L9:
        if (TextUtils.isEmpty(f574059b) == false) goto L11;
        f574059b = b(r100, "webview_monitor_js_file_v2/slardar_bridge.js", true);
    L11:
        f574060c = r102;
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        f574060c = r102;
        if (r103 == true) goto L18;
        f574058a = "";
        f574060c = "";
        f574059b = "";
    L18:
        return " javascript:(  function(){ " + f574058a + f574059b + f574060c + " }  )() ";
    }
}
