package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightAnim {
    public static final BottomRightAnim a = null;

    public static final class a extends qh2.a {
        public final /* synthetic */ Function0 d;
        public final /* synthetic */ Function3 e;
        public final /* synthetic */ Function0 f;
        public final /* synthetic */ View g;

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.d.invoke();
        }

        public a(Function3 r1, Function0 r2, Function0 r3, Function3 r4, Function0 r5, View r6) {
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            super(r1, r2, 2);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function3 b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ View d;

        public b(Function0 r1, Function3 r2, Function0 r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
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
            Function3 r3 = this.b;
            if (r3 == null) goto L12;
            Unit r6 = (Unit) r3.invoke(210, Integer.valueOf((int) (r2 * this.d.getHeight())), Float.valueOf(1.0f - r5.getAnimatedFraction()));
            return;
        L12:
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function1 b;

        public c(View r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.removeOnLayoutChangeListener(this);
            Function1 r10 = this.b;
            if (r1 == null) goto L5;
            int r11 = r1.getMeasuredHeight();
        L6:
            r10.invoke(Integer.valueOf(r11));
            return;
        L5:
            r11 = 0;
            goto L6
        }
    }

    public BottomRightAnim() {
    }

    static {
        a = new BottomRightAnim();
    }

    public static void i(View r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Integer r0 = Integer.valueOf(r4.getMeasuredHeight());
        boolean r2 = false;
        if (r0.intValue() <= 0) goto L10;
        a.getClass();
        int[] r1 = new int[2];
        r4.getLocationOnScreen(r1);
        if (r1[0] <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r2 = true;
        goto L10
    L7:
        r3 = false;
    L10:
        if (r2 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        r5.invoke(Integer.valueOf(r0.intValue()));
        return;
    L15:
        r4.addOnLayoutChangeListener(new c(r4, r5));
        r4.requestLayout();
    }

    public static final float b(BottomRightAnim r2, RoomContextController r3, int r4) {
        r2.getClass();
        ECContext r5 = r3.r();
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r6 = r5.getLinkedAnimController();
        if (r6 == null) goto L20;
        CartCardLinkedAnimController r7 = (CartCardLinkedAnimController) r6.getValue();
        if (r7 == null) goto L20;
        yk2.c r8 = r7.d;
        if (r8 == null) goto L20;
        View r9 = r8.getView();
        if (r9 == null) goto L20;
        Intrinsics.checkNotNullParameter(r9, "view");
        int[] r0 = new int[2];
        r9.getLocationOnScreen(r0);
        int r1 = 0;
        int r10 = r0[0];
        if (r10 <= 0) goto L16;
        r1 = r10;
    L16:
        if (r1 <= 0) goto L20;
        return (r1 - UtilityKotlinExtentionsKt.d(8)) + (r9.getWidth() / 2);
    L20:
        return r4;
    }

    public static void e(final View r10, Function3 r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r12, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideSwitchAnimation");
        Function0<Integer> r0 = new BottomRightAnim$hideSwitchAnimationV2$getViewHeight$1(r10);
        ViewPropertyAnimator r1 = r10.animate().alpha(0.0f).setDuration(167);
        a.getClass();
        r1.setInterpolator(new LinearInterpolator()).setListener(new a(r11, r0, r12, r11, r0, r10)).setUpdateListener(new b(r12, r11, r0, r10)).start();
    }

    public static final float[] a(BottomRightAnim r5, RoomContextController r6, View r7, float[] r8) {
        r5.getClass();
        ECContext r9 = r6.r();
        if (r9 == null) goto L20;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r10 = r9.getLinkedAnimController();
        if (r10 == null) goto L21;
        CartCardLinkedAnimController r11 = (CartCardLinkedAnimController) r10.getValue();
        if (r11 == null) goto L22;
        yk2.c r12 = r11.d;
        if (r12 == null) goto L23;
        View r13 = r12.getView();
        if (r13 == null) goto L26;
        int[] r0 = {0, 0};
        r13.getLocationOnScreen(r0);
        int r2 = r0[0];
        int r4 = r0[1];
        r7.getLocationOnScreen(r0);
        int r1 = r0[1];
        if (r2 <= 0) goto L24;
        if (r4 <= 0) goto L25;
        if (r1 > 0) goto L19;
        return r8;
    L19:
        return new float[]{((r2 - UtilityKotlinExtentionsKt.c(12)) - o0.a(r7)) + (r13.getWidth() / 2.0f), (r4 - r1) + UtilityKotlinExtentionsKt.c(5)};
    L25:
        return r8;
    L24:
        return r8;
    L26:
        return r8;
    L23:
        return r8;
    L22:
        return r8;
    L21:
        return r8;
    L20:
        return r8;
    }

    public static void c(final RoomContextController r7, final View r8, final Function3 r9, final Function0 r10) {
        Intrinsics.checkNotNullParameter(r7, "contextController");
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r10, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimation");
        final Function0<Integer> r6 = new BottomRightAnim$hideLinkedAnimation$getViewHeight$1(r8);
        i(r8, new BottomRightAnim$hideLinkedAnimation$1(r8, r7, r10, r9, r6));
    }

    public static void d(final RoomContextController r8, final View r9, final Function3 r10, final Function0 r11) {
        Intrinsics.checkNotNullParameter(r8, "contextController");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r11, "onAnimEnd");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().c() == false) goto L6;
        Intrinsics.checkNotNullParameter(r8, "contextController");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r11, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimationV3");
        final Function0<Integer> r5 = new BottomRightAnim$hideLinkedAnimationV3$getViewHeight$1(r9);
        i(r9, new BottomRightAnim$hideLinkedAnimationV3$1(r9, r11, r10, r5, r8));
        return;
    L6:
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] hideLinkedAnimationV2");
        final Function0<Integer> r6 = new BottomRightAnim$hideLinkedAnimationV2$getViewHeight$1(r9);
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        r7.element = false;
        i(r9, new BottomRightAnim$hideLinkedAnimationV2$1(r9, r11, r10, r6, r7, r8));
    }

    public static void h(final RoomContextController r8, final View r9, final Function3 r10, final Function0 r11, final Function0 r12) {
        Intrinsics.checkNotNullParameter(r8, "contextController");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r11, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r12, "onAnimStart");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showSwitchAnimation");
        final Function0<Integer> r7 = new BottomRightAnim$showSwitchAnimationV2$getViewHeight$1(r9);
        i(r9, new BottomRightAnim$showSwitchAnimationV2$1(r9, r8, r12, r11, r10, r7));
    }

    public static void f(RoomContextController r8, View r9, boolean r10, Function3 r11, Function0 r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r8, "contextController");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r12, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r13, "onAnimStart");
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimation, ignoreLinkedAnim = " + r10);
        i(r9, new BottomRightAnim$showLinkedAnimation$1(r9, r12, r11, r8, r13, r10));
    }

    public final void g(RoomContextController r10, View r11, boolean r12, Function3<? super Integer, ? super Integer, ? super Float, Unit> r13, Function0<Unit> r14, Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "contextController");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r14, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r15, "onAnimStart");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().c() == false) goto L6;
        Intrinsics.checkNotNullParameter(r10, "contextController");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r14, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r15, "onAnimStart");
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimationV3, ignoreLinkedAnim = " + r12);
        i(r11, new BottomRightAnim$showLinkedAnimationV3$1(this, r11, r15, r13, r14, r10, r12));
        return;
    L6:
        int r1 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showLinkedAnimationV2, ignoreLinkedAnim = " + r12);
        i(r11, new BottomRightAnim$showLinkedAnimationV2$1(this, r11, r15, r13, r14, r10, r12));
    }
}
