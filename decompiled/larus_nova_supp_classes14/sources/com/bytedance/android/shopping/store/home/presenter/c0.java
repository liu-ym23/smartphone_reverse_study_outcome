package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;
    public final /* synthetic */ CartCtrlInfo b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c0 a;

        public a(c0 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L7;
            float r6 = ((Float) r5).floatValue();
            ViewGroup.LayoutParams r0 = ECShopFloatCartEntryPresenterV2.T(this.a.a).getLayoutParams();
            ECShopFloatCartEntryPresenterV2 r1 = this.a.a;
            r0.width = (int) (r1.v * r6);
            ECShopFloatCartEntryPresenterV2.T(r1).setLayoutParams(r0);
            ECShopFloatCartEntryPresenterV2.T(this.a.a).setAlpha(r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c0 a;

        public b(c0 r1) {
            this.a = r1;
        }

        public final void a() {
            ECShopFloatCartEntryPresenterV2 r0 = this.a.a;
            r0.getClass();
            ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r1.setDuration(r0.l);
            r1.addUpdateListener(new x(r0));
            r1.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.83f, 0.83f));
            r1.start();
            r1.addListener(new y(r0));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c0(ECShopFloatCartEntryPresenterV2 r1, CartCtrlInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ECShopFloatCartEntryPresenterV2.T(this.a).setVisibility(0);
        ECShopFloatCartEntryPresenterV2.T(this.a).setPivotX(ECShopFloatCartEntryPresenterV2.T(this.a).getWidth());
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(this.a.l);
        r0.addUpdateListener(new a(this));
        r0.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.83f, 0.83f));
        r0.start();
        View r1 = this.a.y();
        b r2 = new b(this);
        CartCtrlInfo r3 = this.b;
        if (r3 == null) goto L5;
        Integer r4 = r3.getRemainMilliseconds();
    L6:
        r1.postDelayed(r2, com.bytedance.android.shopping.extensions.c.a(r4, 1000));
        this.a.u = AnimationStatus.FINISHED;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
