package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ OfficeApplyPermissionFragment a;
    public final /* synthetic */ View b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.k;
        if (r3 == null) goto L5;
        r3.a(true);
    L5:
        tt5.a.h("OfficeApplyPermissionFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.k;
        if (r3 == null) goto L5;
        r3.a(false);
    L5:
        this.b.removeOnAttachStateChangeListener(this);
        tt5.a.h("OfficeApplyPermissionFragment", "onViewDetachedFromWindow false");
    }

    public k0(OfficeApplyPermissionFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
