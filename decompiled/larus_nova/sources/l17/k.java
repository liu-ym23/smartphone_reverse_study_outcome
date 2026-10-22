package l17;

import android.util.Log;
import com.bytedance.lynx.webview.internal.p;
import com.bytedance.lynx.webview.internal.q;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements Thread.UncaughtExceptionHandler {
    public static void a(String... r100) {
        String r101 = e(r100);
        if (p.b() == false) goto L5;
        Object r102 = p.f265346a;
        return;
    L5:
        p.a(2, r101);
    }

    public static void b(String... r100) {
        String r101 = e(r100);
        if (p.b() == false) goto L8;
        q r102 = p.f265347b;
        if (r102 == null) goto L7;
        r102.a("LYNX_TT_WEBVIEW", r101);
    L7:
        Object r103 = p.f265346a;
        return;
    L8:
        p.a(4, r101);
    }

    public static void c(Throwable r100) {
        d(new String[]{Log.getStackTraceString(r100)});
    }

    public static void d(String... r100) {
        String r101 = e(r100);
        if (p.b() == false) goto L8;
        q r102 = p.f265347b;
        if (r102 == null) goto L7;
        r102.c("LYNX_TT_WEBVIEW", r101);
    L7:
        Object r103 = p.f265346a;
        return;
    L8:
        p.a(3, r101);
    }

    public static String e(String... r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append(r100[r103] + " ");
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }
}
