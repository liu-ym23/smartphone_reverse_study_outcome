package com.bytedance.android.window.shop.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ AbsWindowFloatPresenter a;

    public d(AbsWindowFloatPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Integer r7 = (Integer) r6;
        if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == false) goto L5;
        return;
    L5:
        if (this.a.y().getVisibility() != 0) goto L20;
        Animator r0 = this.a.i;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        AbsWindowFloatPresenter r1 = this.a;
        float[] r2 = new float[2];
        r2[0] = r1.y().getAlpha();
        if (r7 != null) goto L14;
    L16:
        float r8 = 0.5f;
    L17:
        r2[1] = r8;
        ValueAnimator r9 = ValueAnimator.ofFloat(r2);
        r9.setDuration(300);
        r9.addUpdateListener(new c(this));
        r9.start();
        Unit r3 = Unit.INSTANCE;
        r1.i = r9;
        return;
    L14:
        if (r7.intValue() != 0) goto L16;
        r8 = 1.0f;
        goto L17
    }
}
