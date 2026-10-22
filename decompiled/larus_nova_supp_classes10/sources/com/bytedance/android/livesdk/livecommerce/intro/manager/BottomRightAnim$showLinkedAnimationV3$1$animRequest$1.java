package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 implements com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g {
    public boolean a;
    public boolean b;
    public final Function0<Integer> c;
    public final AnimatorSet d;
    public final /* synthetic */ BottomRightAnim$showLinkedAnimationV3$1 e;

    public static final class a extends qh2.a {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 d;

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
            this.d.d();
        }

        public a(Function3 r1, Function0 r2, BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 r3) {
            this.d = r3;
            super(r1, r2, 1);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 a;

        public b(BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 r1) {
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

    public static final class c implements Runnable {
        public final /* synthetic */ BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 a;

        public c(BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomRightAnim$showLinkedAnimationV3$1$animRequest$1 r0 = this.a;     // Catch: Throwable -> L7
            if (r0.b == true) goto L10;
            r0.b = true;     // Catch: Throwable -> L7
            r0.d.start();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void a() {
        if (this.b == true) goto L7;
        this.b = true;
        this.d.start();
        return;
    }

    public final void d() {
        if (this.a == true) goto L6;
        this.a = true;
        this.e.$onAnimStart.invoke();
        this.e.$view.postDelayed(new c(this), 884);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void b() {
        d();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void onCanceled() {
        a();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void c(int r2) {
        if (r2 >= 11) goto L5;
        return;
    L5:
        if (this.b == true) goto L10;
        this.b = true;
        this.d.start();
        return;
    }

    public BottomRightAnim$showLinkedAnimationV3$1$animRequest$1(BottomRightAnim$showLinkedAnimationV3$1 r12, int r13) {
        this.e = r12;
        Function0<Integer> r0 = new BottomRightAnim$showLinkedAnimationV3$1$animRequest$1$getViewHeight$1(this);
        this.c = r0;
        View r1 = r12.$view;
        PathInterpolator r2 = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r12.$view, View.SCALE_X, new float[]{0.0f, 1.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r12.$view, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r3.setDuration(450);
        r5.setDuration(450);
        r3.setInterpolator(r2);
        r5.setInterpolator(r2);
        r5.addListener(new a(r12.$animatorCallback, r0, this));
        r5.addUpdateListener(new b(this));
        AnimatorSet r4 = new AnimatorSet();
        r1.setScaleX(0.0f);
        r1.setScaleY(0.0f);
        r1.setAlpha(1.0f);
        BottomRightAnim r6 = BottomRightAnim.a;
        RoomContextController r7 = r12.$contextController;
        View r8 = r12.$view;
        float[] r9 = BottomRightAnim.a(r6, r7, r8, new float[]{r8.getWidth(), r12.$view.getHeight()});
        float r10 = r9[0];
        float r11 = r9[1];
        r12.$view.setPivotX(r10);
        r12.$view.setPivotY(RangesKt.coerceAtLeast(r11, r13 + UtilityKotlinExtentionsKt.c(14)));
        r4.playTogether(new Animator[]{r3, r5});
        this.d = r4;
    }
}
