package com.bytedance.ies.web.jsbridge2;

import android.webkit.WebView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f249394a;

    public /* synthetic */ n(WebView r100) {
        this.f249394a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f249394a.getContext(), "【Security】\nThe current JSB authentication has security risks!\nPlease implement the ISafeWebView interface of JsBridge2\n", 1).show();
    }
}
