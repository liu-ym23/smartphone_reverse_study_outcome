package com.bytedance.ee.bear.bitable.websubpage;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends WebChromeClient {
    public final /* synthetic */ FullScreenWebSubPage a;

    public b(FullScreenWebSubPage r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r1) {
        super.onCloseWindow(r1);
        FullScreenWebSubPage.a r2 = this.a.i;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r1, String r2) {
        super.onReceivedTitle(r1, r2);
        if (r2 == null) goto L8;
        BaseTitleBar r3 = this.a.e;
        if (r3 == null) goto L9;
        r3.setTitle(r2);
        return;
    L9:
        return;
    }
}
