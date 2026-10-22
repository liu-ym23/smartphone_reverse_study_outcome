package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements View.OnAttachStateChangeListener {
    public final /* synthetic */ w a;

    public p(w r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.getHeadAbility().eh().x(this.a);
        if (PdpAB.c != 1) goto L6;
        w r3 = this.a;
        r3.y(r3.getHeadAbility().rR().R());
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.getHeadAbility().eh().z(this.a);
    }
}
