package oo7;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f524619a;

    static {
        f524619a = -1;
    }

    public static void a() {
        k.a("ClipboardCompat", "clipboard clear");
        SharedPreferences r100 = m.a().f524630a;     // Catch: Exception -> L11
        if (r100 == null) goto L7;
        SharedPreferences.Editor r101 = r100.edit();     // Catch: Exception -> L11
        r101.remove("user_copy_content");     // Catch: Exception -> L11
        r101.commit();     // Catch: Exception -> L11
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        ho7.a.a(com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a);     // Catch: Exception -> L11
        return;
    L9:
        d(com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a, "");     // Catch: Exception -> L11
        return;
    L11:
        d(com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a, "");
    }

    public static String b(Context r100) {
        eo7.a r101 = eo7.a.b.f473353a;
        if (((Boolean) r101.c("use_host_clipboard", Boolean.TRUE)).booleanValue() == false) goto L8;
        jn7.b r102 = r101.f473331e;
        if (r102 == null) goto L8;
        r102.c(r100);
        return "";
    L8:
        ClipboardManager r103 = ho7.a.f(r100);
        if (r103 != null) goto L39;
        return "";
    L39:
    L28:
        ClipData r104 = ho7.a.b(r103);
        if (r104 == null) goto L48;
        ClipData.Item r105 = r104.getItemAt(0);
        if (r105 == null) goto L49;
        CharSequence r106 = r105.getText();
        if (r106 != null) goto L38;
        return "";
    L38:
        return r106.toString();
    L49:
        return "";
    L48:
        return "";
    L26:
        th = move-exception;
        k.b(th.toString());
        return "";
    L13:
        if (ho7.a.d(r103) == true) goto L15;
        return "";
    L15:
        if (ho7.a.c(r103).hasMimeType("text/plain") == false) goto L17;
    L18:
        ClipData.Item r107 = ho7.a.b(r103).getItemAt(0);     // Catch: Throwable -> L26 NullPointerException -> L28
        if (r107.getText() == null) goto L43;
        CharSequence r108 = r107.getText();     // Catch: Throwable -> L26 NullPointerException -> L28
        if (r108 == null) goto L44;
    L47:
        return r108.toString();
    L44:
        return "";
    L43:
        return "";
    L17:
        if (ho7.a.c(r103).hasMimeType("text/html") == true) goto L18;
        return "";
    }

    public static void c(int r100, String r101) {
        eo7.a r102 = eo7.a.b.f473353a;
        if (((Boolean) r102.c("use_host_clipboard", Boolean.TRUE)).booleanValue() == false) goto L8;
        jn7.b r103 = r102.f473331e;
        if (r103 == null) goto L9;
        r103.a();
        return;
    L9:
        return;
    }

    public static void d(Context r100, String r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L19;
        eo7.a r102 = eo7.a.b.f473353a;     // Catch: Throwable -> L14
        if (((Boolean) r102.c("use_host_clipboard", Boolean.TRUE)).booleanValue() == false) goto L11;
        jn7.b r103 = r102.f473331e;     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        r103.b(r100, r101);     // Catch: Throwable -> L14
    L12:
        k.a("ClipboardCompat", "clipboard set text success".concat(r101));     // Catch: Throwable -> L14
        return;
    L11:
        ho7.a.g(r100, r101);     // Catch: Throwable -> L14
    L14:
        k.a("ClipboardCompat", "clipboard set text failed".concat(r101));
        return;
    L19:
        return;
    }
}
