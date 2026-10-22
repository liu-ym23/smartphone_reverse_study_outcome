package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes21.dex */
public class WebViewExtApi21Impl extends WebViewExtImpl {
    private String mWebViewPath;

    @Override // com.bytedance.mira.core.opt.res.ext.IWebViewExt
    public String[] getWebViewPath() {
        return new String[]{this.mWebViewPath};
    }

    public WebViewExtApi21Impl() {
    }

    private String initWebViewPath(Context r100) {
        Resources r101 = r100.getResources();     // Catch: Throwable -> L4
        return r100.createPackageContext(r101.getString(r101.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;
    L4:
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.WebViewExtImpl, com.bytedance.mira.core.opt.res.ext.IWebViewExt
    public void init(Context r100) {
        super.init(r100);
        this.mWebViewPath = initWebViewPath(r100);
    }
}
