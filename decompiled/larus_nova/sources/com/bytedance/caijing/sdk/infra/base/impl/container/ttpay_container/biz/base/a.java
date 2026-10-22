package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import c26.c;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import com.bytedance.ies.bullet.kit.web.e;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends e26.a implements ICJTag, com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBizExtension f202523b;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "BizWebGlobalConfigService_" + this.f202523b.getBizName();
    }

    public a(IBizExtension r100) {
        Intrinsics.checkNotNullParameter(r100, "bizExtension");
        this.f202523b = r100;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(d r100) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r100, "cj_biz");
    }

    @Override // e26.a, e26.b
    public final c26.d X(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ContainerContext r101 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.a(this, r100, null);
        fe4.b r102 = this.f202523b.getWebGlobalConfigService(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.getWebViewClient(r101) == null) goto L9;
        ICJTag.DefaultImpls.i(this, "[createWebViewClientDelegate]");
        return new BizWebViewClient(r100, this.f202523b);
    L9:
        return null;
    }

    @Override // e26.a, e26.b
    public final e Z(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ContainerContext r101 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.a(this, r100, null);
        fe4.b r102 = this.f202523b.getWebGlobalConfigService(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.getWebViewLoadUrlInterceptor(r101) == null) goto L9;
        ICJTag.DefaultImpls.i(this, "[createWebViewLoadUrlInterceptorDelegate]");
        return new BizWebViewLoadUrlInterceptorDelegate(r100, this.f202523b);
    L9:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // e26.a, e26.b
    public final c e0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ContainerContext r101 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.a(this, r100, null);
        fe4.b r102 = this.f202523b.getWebGlobalConfigService(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.getWebChromeClient(r101) == null) goto L9;
        ICJTag.DefaultImpls.i(this, "[createWebChromeClientDelegate]");
        return new BizWebChromeClient(r100, this.f202523b);
    L9:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(m16.b r100, ia.c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
