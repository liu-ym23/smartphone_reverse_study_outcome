package n56;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    public static class a {
        public a() {
        }
    }

    public static class b extends a {
        public b() {
        }
    }

    static {
        new b();
    }

    public static void a(WebView r100, String r101) {
        if (r101 != null) goto L4;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L19;
        r100.loadUrl(r101);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L19:
        return;
    L4:
        if (r101.startsWith("javascript:") == false) goto L10;
        r100.evaluateJavascript(r101, null);     // Catch: Throwable -> L8
        r102 = true;
    L8:
        th = move-exception;
        boolean r103 = th instanceof IllegalStateException;
        goto L10
    }
}
