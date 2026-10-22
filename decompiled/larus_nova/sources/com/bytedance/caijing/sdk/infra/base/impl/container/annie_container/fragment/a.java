package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.fragment;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view.CJBankTitleBar;
import com.bytedance.ies.bullet.ui.common.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f202428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f202429b;

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultTitle");
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void b(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void d() {
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void setBackListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
    }

    public a(b r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        Intrinsics.checkNotNullParameter(r101, "closeAction");
        this.f202428a = r100;
        this.f202429b = r101;
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final View c(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        CJBankTitleBar r102 = new CJBankTitleBar(r100);
        r102.setPopUpStyle(r101);
        r102.f(r101, null, this.f202428a);
        r102.setCloseAction(new CJTitleBarProvider$initWithParams$1$1(this));
        return r102;
    }
}
