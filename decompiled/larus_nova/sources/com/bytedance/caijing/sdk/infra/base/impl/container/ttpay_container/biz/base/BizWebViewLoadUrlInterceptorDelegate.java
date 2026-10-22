package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import android.webkit.WebView;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import com.bytedance.ies.bullet.kit.web.e;
import ia.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class BizWebViewLoadUrlInterceptorDelegate implements e, com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a, ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f202520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBizExtension f202521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f202522c;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "WebViewLoadUrlInterceptor_" + this.f202521b.getBizName();
    }

    @Override // com.bytedance.ies.bullet.kit.web.e
    public final Function4<WebView, String, Map<String, String>, Function2<? super String, ? super Map<String, String>, Unit>, Unit> a() {
        return new BizWebViewLoadUrlInterceptorDelegate$provideWebViewLoadUrlInterceptor$1(this);
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

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public BizWebViewLoadUrlInterceptorDelegate(m16.b r100, IBizExtension r101) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Intrinsics.checkNotNullParameter(r101, "bizExtension");
        this.f202520a = r100;
        this.f202521b = r101;
        this.f202522c = LazyKt.lazy(new BizWebViewLoadUrlInterceptorDelegate$bizWebViewLoadUrlInterceptor$2(this));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(m16.b r100, c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
