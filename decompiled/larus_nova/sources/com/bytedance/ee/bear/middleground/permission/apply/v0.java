package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f233083b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233082a.f232950q;
        if (r101 == null) goto L6;
        r101.a(true);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        au5.b r101 = this.f233082a.f232950q;
        if (r101 == null) goto L5;
        r101.a(false);
    L5:
        this.f233083b.removeOnAttachStateChangeListener(this);
    }

    public v0(OfficeBitableApplyPermissionFragment r100, BaseTitleBar r101) {
        this.f233082a = r100;
        this.f233083b = r101;
    }
}
