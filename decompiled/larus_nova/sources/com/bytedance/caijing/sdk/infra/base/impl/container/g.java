package com.bytedance.caijing.sdk.infra.base.impl.container;

import android.webkit.WebView;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements nd4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f202508a;

    @Override // nd4.a
    public final boolean canGoBack() {
        WebView r100 = this.f202508a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.canGoBack());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    @Override // nd4.a
    public final void goBack() {
        WebView r100 = this.f202508a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.canGoBack());
    L6:
        if (r101 == null) goto L8;
        boolean r102 = r101.booleanValue();
    L9:
        if (r102 == false) goto L14;
        WebView r103 = this.f202508a;
        if (r103 == null) goto L15;
        r103.goBack();
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r102 = false;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public g(BulletServiceImpl.b r100) {
        XCoreBridgeMethod r101 = (XCoreBridgeMethod) r100.g(XCoreBridgeMethod.class);
        if (r101 == null) goto L7;
        m16.b r102 = (m16.b) r101.provideContext(m16.b.class);
        if (r102 == null) goto L7;
        WebView r103 = (WebView) r102.c(WebView.class);
    L8:
        this.f202508a = r103;
        return;
    L7:
        r103 = null;
        goto L8
    }
}
