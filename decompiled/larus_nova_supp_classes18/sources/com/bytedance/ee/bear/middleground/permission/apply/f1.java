package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ PermApplyFragment a;

    public f1(PermApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.p;
        if (r3 == null) goto L5;
        r3.a(true);
    L5:
        tt5.a.h("PermApplyFragment", "onViewAttachedToWindow true");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.p;
        if (r3 == null) goto L5;
        r3.a(false);
    L5:
        BaseTitleBar r4 = this.a.X90();
        if (r4 == null) goto L8;
        r4.removeOnAttachStateChangeListener(this);
    L8:
        tt5.a.h("PermApplyFragment", "onViewDetachedFromWindow false");
    }
}
