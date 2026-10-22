package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends FrameLayout {
    public final /* synthetic */ i a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        OptCardUtil.b(null, "call onAttachedToWindow of card");
        OptCardUtil.e = true;
        if (IntroCardLoadOpt.k == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(IntroCardLoadOpt.o, Boolean.TRUE) == false) goto L9;
        OptCardUtil.b(null, "call forceDoFrame");
        ForceDoFrameMessage.a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r5 = this.a.d;
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.keyAt(r1);
        r5.valueAt(r1).o();
        r1 = r1 + 1;
        goto L3
    }

    public h(i r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        boolean r3 = OptCardUtil.a;
        if (OptCardUtil.e == false) goto L6;
        OptCardUtil.e = false;
        OptCardUtil.b(null, "call onMeasure of card");
        return;
    }
}
