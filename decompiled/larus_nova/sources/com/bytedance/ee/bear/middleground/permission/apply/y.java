package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class y implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuditControlApplyFragment f233090a;

    public y(AuditControlApplyFragment r100) {
        this.f233090a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233090a.f232905o;
        if (r101 == null) goto L5;
        r101.a(true);
    L5:
        tt5.a.h("AuditControlApplyFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233090a.f232905o;
        if (r101 == null) goto L5;
        r101.a(false);
    L5:
        this.f233090a.X90().removeOnAttachStateChangeListener(this);
        tt5.a.h("AuditControlApplyFragment", "onViewDetachedFromWindow false");
    }
}
