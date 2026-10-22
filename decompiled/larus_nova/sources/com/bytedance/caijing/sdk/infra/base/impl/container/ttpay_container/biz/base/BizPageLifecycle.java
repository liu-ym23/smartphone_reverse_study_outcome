package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import android.os.Bundle;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.android.anniex.base.service.c;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class BizPageLifecycle extends c implements com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a, ICJTag {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m16.b f202510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ia.c f202511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBizExtension f202512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f202513e;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "PageLifecycle_" + this.f202512d.getBizName();
    }

    public final fe4.a M0() {
        return (fe4.a) this.f202513e.getValue();
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

    @Override // com.bytedance.android.anniex.base.service.c
    public final boolean G0(m16.b r100, ia.c r101) {
        ICJTag.DefaultImpls.i(this, "[isInterceptorBackPress ｜ onBackPressClick]");
        fe4.a r102 = M0();
        if (r102 == null) goto L5;
        r102.onBackPressClick();
    L5:
        fe4.a r103 = M0();
        if (r103 == null) goto L8;
        Boolean r104 = Boolean.valueOf(r103.isInterceptorBackPress());
    L9:
        if (r104 != null) goto L13;
        return false;
    L13:
        return r104.booleanValue();
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.anniex.base.service.c
    public final void H0(m16.b r100, ia.c r101) {
        ICJTag.DefaultImpls.i(this, "[onInterceptorBackPress]");
        fe4.a r102 = M0();
        if (r102 == null) goto L6;
        r102.onInterceptorBackPress();
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.c
    public final void J0(m16.b r100, ia.c r101) {
        ICJTag.DefaultImpls.i(this, "[onPageDestroy]");
        fe4.a r102 = M0();
        if (r102 == null) goto L6;
        r102.onPageDestroy();
        return;
    }

    @Override // com.bytedance.android.anniex.base.service.c
    public final void K0(m16.b r100, ia.c r101) {
        ICJTag.DefaultImpls.i(this, "[onPageResume]");
        fe4.a r102 = M0();
        if (r102 == null) goto L6;
        r102.onPageResume();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(m16.b r100, ia.c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public BizPageLifecycle(m16.b r100, ia.c r101, IBizExtension r102) {
        Intrinsics.checkNotNullParameter(r102, "bizExtension");
        this.f202510b = r100;
        this.f202511c = r101;
        this.f202512d = r102;
        this.f202513e = LazyKt.lazy(new BizPageLifecycle$bizLifecycle$2(this));
    }

    @Override // com.bytedance.android.anniex.base.service.c
    public final void I0(m16.b r100, ia.c r101, Bundle r102) {
        ICJTag.DefaultImpls.i(this, "[onPageCreate]");
        fe4.a r103 = M0();
        if (r103 == null) goto L6;
        r103.onPageCreate();
        return;
    }
}
