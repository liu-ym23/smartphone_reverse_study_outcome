package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosBSDialogInfoManager {
    public static final /* synthetic */ int k = 0;
    public AosBottomSheetBehavior<FrameLayout> a;
    public FrameLayout b;
    public FrameLayout c;
    public a0 d;
    public boolean e;
    public b0 f;
    public s24.b g;
    public float h;
    public float i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ AosBSDialogInfoManager a;
        public final /* synthetic */ ObjectAnimator b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ b0 d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.e = false;
            this.b.removeListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.e = false;
            this.b.removeListener(this);
            if (this.c.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.c.isDestroyed() == true) goto L10;
            AosBSDialogInfoManager.a(this.a, this.d);
            return;
        }

        public b(AosBSDialogInfoManager r1, ObjectAnimator r2, Activity r3, b0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void b() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.post(new com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a(this));
        return;
    }

    public AosBSDialogInfoManager() {
        this.j = LazyKt.lazy(AosBSDialogInfoManager$enableCommentShrink$2.INSTANCE);
    }

    public static final void a(AosBSDialogInfoManager r3, b0 r4) {
        r3.getClass();
        Dialog r5 = r4.getDialog();
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        a0 r6 = r3.d;
        if (r6 == null) goto L26;
        r6.onClose();
        return;
    L26:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }

    public final void c(Activity r5, View r6, b0 r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.e == false) goto L6;
        return;
    L6:
        this.e = true;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r6, "translationY", new float[]{0.0f, r6.getMeasuredHeight()});
        r8.setDuration(300);
        r8.addListener(new b(this, r8, r5, r7));
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L9;
        r8.addUpdateListener(new e(this));
    L9:
        r8.start();
    }

    public static View d(final AosBSDialogInfoManager r5, final b0 r6, View r7, ViewGroup.LayoutParams r8) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "bottomSheetDialog");
        Intrinsics.checkNotNullParameter(r7, "view");
        r5.f = r6;
        if (r5.b != null) goto L18;
        View r0 = View.inflate(r6.getActivity(), 2131558617, null);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r1 = (FrameLayout) r0;
        r5.b = r1;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r1.findViewById(2131367947), "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        FrameLayout r2 = r5.b;
        Intrinsics.checkNotNull(r2);
        View r3 = r2.findViewById(2131368870);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r4 = (FrameLayout) r3;
        r5.c = r4;
        Intrinsics.checkNotNull(r4);
        CoordinatorLayout.LayoutParams r9 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r10 = r9;
        int r11 = r6.getBottomSheetHeight();
        if (r11 <= 0) goto L7;
        ((ViewGroup.MarginLayoutParams) r10).height = r11;
    L7:
        FrameLayout r12 = r5.c;
        Intrinsics.checkNotNull(r12);
        AosBottomSheetBehavior<FrameLayout> r13 = AosBottomSheetBehavior.from(r12);
        r5.a = r13;
        if (r13 == null) goto L11;
        r13.setHideable(true);
    L11:
        AosBottomSheetBehavior<FrameLayout> r14 = r5.a;
        if (r14 == null) goto L15;
        r14.setState(3);
    L15:
        FrameLayout r15 = r5.c;
        if (r15 == null) goto L18;
        x54.b.b(r15);
    L18:
        FrameLayout r16 = r5.b;
        if (r16 == null) goto L21;
        View r17 = r16.findViewById(2131367947);
    L22:
        FrameLayout r18 = r5.c;
        if (r18 == null) goto L25;
        r18.removeAllViews();
    L25:
        FrameLayout r19 = r5.c;
        if (r19 == null) goto L28;
        r19.addView(r7, r8);
    L28:
        if (r17 == null) goto L32;
        View r20 = r17.findViewById(2131389274);
        if (r20 == null) goto L32;
        r20.setOnClickListener(new com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b(r5, r6));
    L32:
        FrameLayout r21 = r5.c;
        if (r21 == null) goto L35;
        r21.setOnTouchListener(new c());
    L35:
        AosBottomSheetBehavior<FrameLayout> r22 = r5.a;
        if (r22 == null) goto L38;
        r22.addBottomSheetCallback(new h(r5, r6));
    L38:
        r5.g = null;
        FrameLayout r23 = r5.c;
        if (r23 == null) goto L41;
        r23.post(new d(r5));
    L41:
        FrameLayout r24 = r5.b;
        if (r24 == null) goto L44;
        float r25 = r24.getHeight();
    L45:
        r5.i = r25;
        return r5.b;
    L44:
        r25 = 0.0f;
        goto L45
    L21:
        r17 = null;
        goto L22
    }
}
