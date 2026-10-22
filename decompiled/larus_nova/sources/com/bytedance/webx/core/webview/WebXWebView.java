package com.bytedance.webx.core.webview;

import android.content.Context;
import android.util.AttributeSet;
import iq7.f;
import iq7.g;
import qq7.a;
import qq7.b;
import qq7.c;

/* JADX INFO: loaded from: classes22.dex */
public class WebXWebView extends WebViewContainer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f272590e;

    public WebXWebView(Context r100) {
        F0(r100);
        super(r100);
        E0(r100);
    }

    public static void F0(Context r100) {
        if (g.a("", c.class) != null) goto L11;
        f272590e = true;
        if (g.a("WebXWebViewBackup", c.class) != null) goto L13;
        Context r101 = r100.getApplicationContext();
        if (g.f495391g != null) goto L10;
        g.f495391g = r101.getApplicationContext();
        g.f495392h = new g.b();
    L10:
        g.b("WebXWebViewBackup", c.class, new b());
        return;
    L13:
        return;
    L11:
        f272590e = false;
    }

    public final void E0(Context r100) {
        iq7.b r101 = new iq7.b();
        if (f272590e == false) goto L5;
        String r102 = "WebXWebViewBackup";
    L6:
        a r103 = (a) f.a(r102, c.class);
        r101.f495389b = this;
        r103.a(r100, r101);
        return;
    L5:
        r102 = "";
        goto L6
    }

    public WebXWebView(Context r100, AttributeSet r101) {
        F0(r100);
        super(r100, r101);
        E0(r100);
    }

    public WebXWebView(Context r100, AttributeSet r101, int r102) {
        F0(r100);
        super(r100, r101, r102);
        E0(r100);
    }
}
