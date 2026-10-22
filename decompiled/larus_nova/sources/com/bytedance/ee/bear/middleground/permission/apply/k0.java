package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeApplyPermissionFragment f233038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f233039b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233038a.f232936k;
        if (r101 == null) goto L5;
        r101.a(true);
    L5:
        tt5.a.h("OfficeApplyPermissionFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233038a.f232936k;
        if (r101 == null) goto L5;
        r101.a(false);
    L5:
        this.f233039b.removeOnAttachStateChangeListener(this);
        tt5.a.h("OfficeApplyPermissionFragment", "onViewDetachedFromWindow false");
    }

    public k0(OfficeApplyPermissionFragment r100, View r101) {
        this.f233038a = r100;
        this.f233039b = r101;
    }
}
