package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 implements com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g {
    public boolean a;
    public boolean b;
    public final Function0<Integer> c;
    public final AnimatorSet d;
    public final /* synthetic */ BottomRightAnim$showLinkedAnimationV2$1 e;

    public static final class a extends qh2.a {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 d;

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.d.e.$onAnimEnd.invoke();
        }

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 r3 = this.d;
            if (r3.a == true) goto L6;
            r3.a = true;
            r3.e.$onAnimStart.invoke();
            return;
        }

        public a(Function3 r1, Function0 r2, BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 r3) {
            this.d = r3;
            super(r1, r2, 1);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 a;

        public b(BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Object r0 = r5.getAnimatedValue();
            if ((r0 instanceof Float) == true) goto L5;
            r0 = null;
        L5:
            Float r1 = (Float) r0;
            if (r1 == null) goto L11;
            float r2 = r1.floatValue();
            Function3 r3 = this.a.e.$animatorCallback;
            if (r3 == null) goto L12;
            Unit r6 = (Unit) r3.invoke(Integer.valueOf(z0.TYPE_APPLY_PERMIT), Integer.valueOf((int) (r2 * this.a.e.$view.getHeight())), Float.valueOf(r5.getAnimatedFraction()));
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void a() {
        if (this.b == true) goto L7;
        this.b = true;
        this.d.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void b() {
        if (this.a == true) goto L6;
        this.a = true;
        this.e.$onAnimStart.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void onCanceled() {
        a();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void c(int r2) {
        if (r2 >= 15) goto L5;
        return;
    L5:
        if (this.b == true) goto L10;
        this.b = true;
        this.d.start();
        return;
    }

    public BottomRightAnim$showLinkedAnimationV2$1$animRequest$1(BottomRightAnim$showLinkedAnimationV2$1 r10, int r11) {
        this.e = r10;
        Function0<Integer> r0 = new BottomRightAnim$showLinkedAnimationV2$1$animRequest$1$getViewHeight$1(this);
        this.c = r0;
        View r1 = r10.$view;
        PathInterpolator r2 = new PathInterpolator(0.33f, 0.0f, 0.21f, 1.0f);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r10.$view, View.SCALE_X, new float[]{0.0f, 1.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r10.$view, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r3.setDuration(167);
        r5.setDuration(167);
        r3.setInterpolator(r2);
        r5.setInterpolator(r2);
        r5.addListener(new a(r10.$animatorCallback, r0, this));
        r5.addUpdateListener(new b(this));
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r10.$view, View.ALPHA, new float[]{0.0f, 1.0f});
        r4.setDuration(50);
        r4.setInterpolator(new LinearInterpolator());
        AnimatorSet r6 = new AnimatorSet();
        r1.setScaleX(0.0f);
        r1.setScaleY(0.0f);
        r1.setAlpha(0.0f);
        r1.setPivotX(BottomRightAnim.b(BottomRightAnim.a, r10.$contextController, r1.getWidth()));
        r1.setPivotY(r11);
        r6.playTogether(new Animator[]{r3, r5, r4});
        this.d = r6;
    }
}
