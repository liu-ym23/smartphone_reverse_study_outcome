package com.bytedance.ee.bear.drive.view.preview.wps;

import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z0 extends com.bytedance.ee.bear.drive.view.widget.j {
    public final /* synthetic */ WpsView a;

    public z0(WpsView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void a(WebView r1, String r2) {
        tt5.a.h("WpsWebView", "preload webview page finish");
        this.a.getInitData();
        this.a.u = true;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void b(int r2, String r3, String r4) {
        tt5.a.h("WpsWebView", "preload webview onReceivedError errorcode is " + r2 + " description is " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        boolean r5 = false;
    L6:
        if (r5 == true) goto L8;
        return;
    L8:
        if (this.a.w == true) goto L12;
        tt5.a.h("WpsWebView", "preload webview onReceivedError reload");
        this.a.a.reload();
        this.a.w = true;
        return;
    L12:
        return;
    L5:
        r5 = r3.contains("ERR_FILE_NOT_FOUND");
        goto L6
    }
}
