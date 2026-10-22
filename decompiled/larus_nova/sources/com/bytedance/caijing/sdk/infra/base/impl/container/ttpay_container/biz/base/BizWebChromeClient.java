package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import c26.c;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class BizWebChromeClient extends c implements ICJTag, com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m16.b f202514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBizExtension f202515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f202516d;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "WebChromeClient_" + this.f202515c.getBizName();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(d r100) {
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

    @Override // b36.j, android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        StringBuilder r101 = new StringBuilder("[onPermissionRequest], bizWebChromeClient is null: ");
        if (((WebChromeClient) this.f202516d.getValue()) != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        ICJTag.DefaultImpls.i(this, r101.toString());
        WebChromeClient r103 = (WebChromeClient) this.f202516d.getValue();
        if (r103 == null) goto L9;
        r103.onPermissionRequest(r100);
        Unit r104 = Unit.INSTANCE;
    L10:
        if (r104 != null) goto L13;
        super.onPermissionRequest(r100);
        return;
    L13:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public BizWebChromeClient(m16.b r100, IBizExtension r101) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Intrinsics.checkNotNullParameter(r101, "bizExtension");
        this.f202514b = r100;
        this.f202515c = r101;
        this.f202516d = LazyKt.lazy(new BizWebChromeClient$bizWebChromeClient$2(this));
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
