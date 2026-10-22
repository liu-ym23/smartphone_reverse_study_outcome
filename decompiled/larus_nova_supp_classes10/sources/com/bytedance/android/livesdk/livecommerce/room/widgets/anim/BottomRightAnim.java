package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightAnim {
    public static final /* synthetic */ int a = 0;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.invoke();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function1 b;

        public b(View r1, Function1 r2) {
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

    static {
    }

    public static void b(View r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "onAnimEnd");
        r2.animate().alpha(0.0f).setDuration(300).setInterpolator(new LinearInterpolator()).setListener(new a(r3)).start();
    }

    public static void e(View r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Integer r0 = Integer.valueOf(r4.getMeasuredHeight());
        boolean r2 = false;
        if (r0.intValue() <= 0) goto L10;
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
        r4.addOnLayoutChangeListener(new b(r4, r5));
        r4.requestLayout();
    }

    public static void a(final RoomContextController r1, final View r2, final Function0 r3) {
        Intrinsics.checkNotNullParameter(r1, "contextController");
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "onAnimEnd");
        e(r2, new BottomRightAnim$hideLinkedAnimation$1(r2, r1, r3));
    }

    public static void d(final boolean r1, final View r2, final Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "onAnimEnd");
        e(r2, new BottomRightAnim$showSwitchAnimation$1(r2, r1, r3));
    }

    public static void c(RoomContextController r7, View r8, Function0 r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r7, "contextController");
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r10, "onAnimStart");
        e(r8, new BottomRightAnim$showLinkedAnimation$1(r8, r7, r9, r10, false));
    }
}
