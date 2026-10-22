package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b36.k;
import c26.d;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import ia.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BizWebViewClient extends d implements ICJTag, com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m16.b f202517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBizExtension f202518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f202519d;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "WebViewClient_" + this.f202518c.getBizName();
    }

    public final WebViewClient f() {
        return (WebViewClient) this.f202519d.getValue();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(t36.d r100) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r100, "cj_biz");
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public BizWebViewClient(m16.b r100, IBizExtension r101) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Intrinsics.checkNotNullParameter(r101, "bizExtension");
        this.f202517b = r100;
        this.f202518c = r101;
        this.f202519d = LazyKt.lazy(new BizWebViewClient$bizWebViewClient$2(this));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final t36.d U6(m16.b r100, c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // b36.q
    public final WebResourceResponse b(WebView r100, k r101) {
        if (f() == null) goto L11;
        WebViewClient r102 = f();
        if (r102 == null) goto L9;
        WebResourceResponse r103 = r102.shouldInterceptRequest(r100, new b(r101));
        if (r103 == null) goto L9;
        return r103;
    L9:
        super.b(r100, r101);
        throw null;
    L11:
        ICJTag.DefaultImpls.e$default(this, "[shouldInterceptRequest] bizWebViewClient is null", null, 2, null);
        super.b(r100, r101);
        throw null;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        WebViewClient r102 = f();
        if (r102 == null) goto L6;
        r102.onPageFinished(r100, r101);
        return;
    }

    @Override // b36.q, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        if (f() != null) goto L6;
        ICJTag.DefaultImpls.e$default(this, "[shouldOverrideUrlLoading] bizWebViewClient is null", null, 2, null);
        return super.shouldOverrideUrlLoading(r100, r101);
    L6:
        WebViewClient r102 = f();
        if (r102 == null) goto L10;
        return r102.shouldOverrideUrlLoading(r100, r101);
    L10:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        WebViewClient r103 = f();
        if (r103 == null) goto L6;
        r103.onPageStarted(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        ICJTag.DefaultImpls.e$default(this, "[onReceivedError] errorCode: " + r101 + ", description: " + r102 + ", failingUrl: " + r103, null, 2, null);
        WebViewClient r104 = f();
        if (r104 == null) goto L6;
        r104.onReceivedError(r100, r101, r102, r103);
        return;
    }
}
