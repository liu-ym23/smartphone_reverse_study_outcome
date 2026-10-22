package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f1 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermApplyFragment f233018a;

    public f1(PermApplyFragment r100) {
        this.f233018a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233018a.f232968p;
        if (r101 == null) goto L5;
        r101.a(true);
    L5:
        tt5.a.h("PermApplyFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233018a.f232968p;
        if (r101 == null) goto L5;
        r101.a(false);
    L5:
        BaseTitleBar r102 = this.f233018a.X90();
        if (r102 == null) goto L8;
        r102.removeOnAttachStateChangeListener(this);
    L8:
        tt5.a.h("PermApplyFragment", "onViewDetachedFromWindow false");
    }
}
