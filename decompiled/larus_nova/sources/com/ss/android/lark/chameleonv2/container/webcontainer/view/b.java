package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements IChameleonLoader.LoadingCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yv4.e f411348a;

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccess() {
        this.f411348a.i();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final boolean getKeepOnRelease() {
        return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadStart() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadStart(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccessByJS() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadSuccessByJS(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    @Deprecated(message = "已废弃，使用IRenderGoneListener")
    public final void onRenderProcessGone() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
    }

    public b(yv4.e r100) {
        this.f411348a = r100;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onPageStarted(String r100) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onPageStarted(this, r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFail(int r100, Throwable r101) {
        this.f411348a.i();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFailByJS(String r100, int r101) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFailByJS(this, r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onReceivedTitle(WebView r100, String r101) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onReceivedTitle(this, r100, r101);
    }
}
