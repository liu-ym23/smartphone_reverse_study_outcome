package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements View.OnAttachStateChangeListener {
    public final /* synthetic */ AuditControlApplyFragment a;

    public y(AuditControlApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.o;
        if (r3 == null) goto L5;
        r3.a(true);
    L5:
        tt5.a.h("AuditControlApplyFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.o;
        if (r3 == null) goto L5;
        r3.a(false);
    L5:
        this.a.X90().removeOnAttachStateChangeListener(this);
        tt5.a.h("AuditControlApplyFragment", "onViewDetachedFromWindow false");
    }
}
