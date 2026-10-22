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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.google.android.material.internal.AosBottomSheetBehavior;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AosBSDialogInfoManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f196846k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AosBottomSheetBehavior<FrameLayout> f196847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f196848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f196849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f196850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f196851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b0 f196852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s24.b f196853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f196854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f196855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f196856j;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosBSDialogInfoManager f196857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObjectAnimator f196858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f196859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b0 f196860d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f196857a.f196851e = false;
            this.f196858b.removeListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f196857a.f196851e = false;
            this.f196858b.removeListener(this);
            if (this.f196859c.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.f196859c.isDestroyed() == true) goto L10;
            AosBSDialogInfoManager.a(this.f196857a, this.f196860d);
            return;
        }

        public b(AosBSDialogInfoManager r100, ObjectAnimator r101, Activity r102, b0 r103) {
            this.f196857a = r100;
            this.f196858b = r101;
            this.f196859c = r102;
            this.f196860d = r103;
        }
    }

    static {
    }

    public final void b() {
        FrameLayout r100 = this.f196849c;
        if (r100 == null) goto L6;
        r100.post(new com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a(this));
        return;
    }

    public AosBSDialogInfoManager() {
        this.f196856j = LazyKt.lazy(AosBSDialogInfoManager$enableCommentShrink$2.INSTANCE);
    }

    public static final void a(AosBSDialogInfoManager r100, b0 r101) {
        r100.getClass();
        Dialog r102 = r101.getDialog();
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r102);
    L17:
        a0 r104 = r100.f196850d;
        if (r104 == null) goto L26;
        r104.onClose();
        return;
    L26:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r103.getLooper()) goto L7;
        r103.post(DialogLancet.createDismissRunnable(r102));
        goto L17
    }

    public final void c(Activity r100, View r101, b0 r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f196851e == false) goto L6;
        return;
    L6:
        this.f196851e = true;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r101.getMeasuredHeight()});
        r103.setDuration(300);
        r103.addListener(new b(this, r103, r100, r102));
        if (((Boolean) this.f196856j.getValue()).booleanValue() == false) goto L9;
        r103.addUpdateListener(new e(this));
    L9:
        r103.start();
    }

    public static View d(final AosBSDialogInfoManager r100, final b0 r101, View r102, ViewGroup.LayoutParams r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "bottomSheetDialog");
        Intrinsics.checkNotNullParameter(r102, "view");
        r100.f196852f = r101;
        if (r100.f196848b != null) goto L18;
        View r104 = View.inflate(r101.getActivity(), R.layout.aos_design_bottom_sheet, null);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r105 = (FrameLayout) r104;
        r100.f196848b = r105;
        Intrinsics.checkNotNull(r105);
        View r106 = r105.findViewById(R.id.coordinator);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        CoordinatorLayout r107 = (CoordinatorLayout) r106;
        FrameLayout r108 = r100.f196848b;
        Intrinsics.checkNotNull(r108);
        View r109 = r108.findViewById(R.id.design_bottom_sheet);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r110 = (FrameLayout) r109;
        r100.f196849c = r110;
        Intrinsics.checkNotNull(r110);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r112 = (CoordinatorLayout.LayoutParams) r111;
        int r113 = r101.getBottomSheetHeight();
        if (r113 <= 0) goto L7;
        ((ViewGroup.MarginLayoutParams) r112).height = r113;
    L7:
        FrameLayout r114 = r100.f196849c;
        Intrinsics.checkNotNull(r114);
        AosBottomSheetBehavior<FrameLayout> r115 = AosBottomSheetBehavior.from(r114);
        r100.f196847a = r115;
        if (r115 == null) goto L11;
        r115.setHideable(true);
    L11:
        AosBottomSheetBehavior<FrameLayout> r116 = r100.f196847a;
        if (r116 == null) goto L15;
        r116.setState(3);
    L15:
        FrameLayout r117 = r100.f196849c;
        if (r117 == null) goto L18;
        x54.b.b(r117);
    L18:
        FrameLayout r118 = r100.f196848b;
        if (r118 == null) goto L21;
        View r119 = r118.findViewById(R.id.coordinator);
    L22:
        FrameLayout r120 = r100.f196849c;
        if (r120 == null) goto L25;
        r120.removeAllViews();
    L25:
        FrameLayout r121 = r100.f196849c;
        if (r121 == null) goto L28;
        r121.addView(r102, r103);
    L28:
        if (r119 == null) goto L32;
        View r122 = r119.findViewById(R.id.touch_outside);
        if (r122 == null) goto L32;
        r122.setOnClickListener(new com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b(r100, r101));
    L32:
        FrameLayout r123 = r100.f196849c;
        if (r123 == null) goto L35;
        r123.setOnTouchListener(new c());
    L35:
        AosBottomSheetBehavior<FrameLayout> r124 = r100.f196847a;
        if (r124 == null) goto L38;
        r124.addBottomSheetCallback(new h(r100, r101));
    L38:
        r100.f196853g = null;
        FrameLayout r125 = r100.f196849c;
        if (r125 == null) goto L41;
        r125.post(new d(r100));
    L41:
        FrameLayout r126 = r100.f196848b;
        if (r126 == null) goto L44;
        float r127 = r126.getHeight();
    L45:
        r100.f196855i = r127;
        return r100.f196848b;
    L44:
        r127 = 0.0f;
        goto L45
    L21:
        r119 = null;
        goto L22
    }
}
