package com.bytedance.ee.bear.bitable.websubpage;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenWebSubPage f216299a;

    public b(FullScreenWebSubPage r100) {
        this.f216299a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        super.onCloseWindow(r100);
        FullScreenWebSubPage.a r101 = this.f216299a.f216282i;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        if (r101 == null) goto L8;
        BaseTitleBar r102 = this.f216299a.f216278e;
        if (r102 == null) goto L9;
        r102.setTitle(r101);
        return;
    L9:
        return;
    }
}
