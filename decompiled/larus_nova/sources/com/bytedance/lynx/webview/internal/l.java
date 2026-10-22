package com.bytedance.lynx.webview.internal;

import android.webkit.WebViewFactoryProvider;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements TTWebProviderWrapper.ProviderCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LibraryLoader f265333a;

    @Override // com.bytedance.lynx.webview.glue.TTWebProviderWrapper.ProviderCallback
    public final WebViewFactoryProvider getTTGlueProvider() {
        return this.f265333a.f265145h;
    }

    public l(LibraryLoader r100) {
        this.f265333a = r100;
    }
}
