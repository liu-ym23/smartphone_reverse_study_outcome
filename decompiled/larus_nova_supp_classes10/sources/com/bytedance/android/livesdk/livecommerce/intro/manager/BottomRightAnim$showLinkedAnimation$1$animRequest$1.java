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
public final class BottomRightAnim$showLinkedAnimation$1$animRequest$1 implements com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g {
    public boolean a;
    public final Function0<Integer> b;
    public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1 c;
    public final /* synthetic */ int d;

    public static final class a extends qh2.a {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1$animRequest$1 d;

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.d.c.$onAnimEnd.invoke();
        }

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            BottomRightAnim$showLinkedAnimation$1$animRequest$1 r3 = this.d;
            if (r3.a == true) goto L6;
            r3.a = true;
            r3.c.$onAnimStart.invoke();
            return;
        }

        public a(Function3 r1, Function0 r2, BottomRightAnim$showLinkedAnimation$1$animRequest$1 r3) {
            this.d = r3;
            super(r1, r2, 1);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1$animRequest$1 a;

        public b(BottomRightAnim$showLinkedAnimation$1$animRequest$1 r1) {
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
            Function3 r3 = this.a.c.$animatorCallback;
            if (r3 == null) goto L12;
            Unit r6 = (Unit) r3.invoke(Integer.valueOf(z0.TYPE_APPLY_PERMIT), Integer.valueOf((int) (r2 * this.a.c.$view.getHeight())), Float.valueOf(r5.getAnimatedFraction()));
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void c(int r1) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void a() {
        View r0 = this.c.$view;
        PathInterpolator r1 = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.c.$view, View.SCALE_X, new float[]{0.05f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.c.$view, View.SCALE_Y, new float[]{0.05f, 1.0f});
        r2.setDuration(450);
        r4.setDuration(450);
        r2.setInterpolator(r1);
        r4.setInterpolator(r1);
        r4.addListener(new a(this.c.$animatorCallback, this.b, this));
        r4.addUpdateListener(new b(this));
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.c.$view, View.ALPHA, new float[]{0.0f, 1.0f});
        r3.setDuration(50);
        r3.setInterpolator(new LinearInterpolator());
        r3.setStartDelay(17);
        AnimatorSet r6 = new AnimatorSet();
        r0.setScaleX(0.05f);
        r0.setScaleY(0.05f);
        r0.setAlpha(0.0f);
        r0.setPivotX(BottomRightAnim.b(BottomRightAnim.a, this.c.$contextController, r0.getWidth()));
        r0.setPivotY(this.d);
        r6.playTogether(new Animator[]{r2, r4, r3});
        r6.start();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void b() {
        if (this.a == true) goto L6;
        this.a = true;
        this.c.$onAnimStart.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void onCanceled() {
        a();
    }

    public BottomRightAnim$showLinkedAnimation$1$animRequest$1(BottomRightAnim$showLinkedAnimation$1 r1, int r2) {
        this.c = r1;
        this.d = r2;
        this.b = new BottomRightAnim$showLinkedAnimation$1$animRequest$1$getViewHeight$1(this);
    }
}
