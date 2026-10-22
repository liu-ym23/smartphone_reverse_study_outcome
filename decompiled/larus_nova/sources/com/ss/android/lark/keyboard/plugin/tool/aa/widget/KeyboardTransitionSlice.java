package com.ss.android.lark.keyboard.plugin.tool.aa.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J2\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002JB\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/aa/widget/KeyboardTransitionSlice;", "Landroidx/transition/Visibility;", "animationMode", "", "<init>", "(I)V", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", LynxVideoManagerLite.EVENT_ON_APPEAR, "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "startValues", "Landroidx/transition/TransitionValues;", "endValues", "onDisappear", "captureStartValues", "", "transitionValues", "captureEndValues", "captureValues", "createAnimation", "values", "viewPos", "", "startY", "", "endY", "Landroid/animation/TimeInterpolator;", "transition", "Landroidx/transition/Transition;", "Companion", "TransitionPositionListener", "keyboard-biz-aa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardTransitionSlice extends Visibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f429596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DecelerateInterpolator f429597b;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f429598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f429599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f429600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f429601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f429602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f429603f;

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f429602e != null) goto L5;
            this.f429602e = new int[2];
        L5:
            int[] r101 = this.f429602e;
            Intrinsics.checkNotNull(r101);
            r101[1] = MathKt.roundToInt(this.f429601d + this.f429598a.getTranslationY());
            this.f429599b.setTag(R.id.transition_position, this.f429602e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f429603f = this.f429598a.getTranslationY();
            this.f429598a.setTranslationY(this.f429600c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f429598a.setTranslationY(this.f429603f);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
            this.f429598a.setTranslationY(this.f429600c);
            r100.removeListener(this);
        }

        public b(View r100, View r101, int r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "movingView");
            Intrinsics.checkNotNullParameter(r101, "viewInHierarchy");
            this.f429598a = r100;
            this.f429599b = r101;
            this.f429600c = r103;
            this.f429601d = r102 - MathKt.roundToInt(r100.getTranslationY());
            int[] r104 = (int[]) r101.getTag(R.id.transition_position);
            this.f429602e = r104;
            if (r104 == null) goto L6;
            r101.setTag(R.id.transition_position, null);
            return;
        }
    }

    static {
    }

    public KeyboardTransitionSlice() {
        this.f429596a = 1;
        this.f429597b = new DecelerateInterpolator();
        setDuration(300);
    }

    public static void a(TransitionValues r100) {
        int[] r101 = new int[2];
        r100.view.getLocationOnScreen(r101);
        r100.values.put("keyboard_slide_screenPosition", r101);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void captureEndValues(TransitionValues r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionValues");
        super.captureEndValues(r100);
        a(r100);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void captureStartValues(TransitionValues r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionValues");
        super.captureStartValues(r100);
        a(r100);
    }

    @Override // androidx.transition.Visibility
    public final Animator onAppear(ViewGroup r100, View r101, TransitionValues r110, TransitionValues r111) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L17;
        if (r111 == null) goto L18;
        r101.setTranslationY(0.0f);
        float r102 = r101.getTranslationY();
        if (this.f429596a != 1) goto L9;
        float r103 = r100.getHeight() + r102;
    L10:
        float r104 = r103;
        int[] r105 = (int[]) r111.values.get("keyboard_slide_screenPosition");
        if (r105 != null) goto L14;
        r105 = new int[2];
    L14:
        return b(r101, r111, r105, r104, r102, this.f429597b, this);
    L9:
        r103 = r102 - r100.getHeight();
        goto L10
    L18:
        return null;
    L17:
        return null;
    L15:
        return null;
    }

    @Override // androidx.transition.Visibility
    public final Animator onDisappear(ViewGroup r100, View r101, TransitionValues r110, TransitionValues r111) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L17;
        if (r111 == null) goto L18;
        r101.setTranslationY(0.0f);
        float r102 = r101.getTranslationY();
        if (this.f429596a != 1) goto L9;
        float r103 = r102 - r100.getHeight();
    L10:
        float r104 = r103;
        int[] r105 = (int[]) r111.values.get("keyboard_slide_screenPosition");
        if (r105 != null) goto L14;
        r105 = new int[2];
    L14:
        return b(r101, r111, r105, r102, r104, this.f429597b, this);
    L9:
        r103 = r100.getHeight() + r102;
        goto L10
    L18:
        return null;
    L17:
        return null;
    L15:
        return null;
    }

    public static Animator b(View r100, TransitionValues r101, int[] r102, float r103, float r110, TimeInterpolator r111, Transition r112) {
        float r104 = r100.getTranslationY();
        int r105 = r102[1];
        int[] r106 = (int[]) r101.view.getTag(R.id.transition_position);
        if (r106 == null) goto L5;
        r103 = (r106[1] - r105) + r104;
    L5:
        int r107 = r105 + MathKt.roundToInt(r103 - r104);
        r100.setTranslationY(r103);
        if (r103 != r110) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == false) goto L12;
        return null;
    L12:
        ObjectAnimator r109 = ObjectAnimator.ofPropertyValuesHolder(r100, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r103, r110})});
        b r113 = new b(r100, r101.view, r107, r104);
        r112.addListener(r113);
        r109.addListener(r113);
        r109.addPauseListener(r113);
        r109.setInterpolator(r111);
        return r109;
    L8:
        r108 = false;
        goto L9
    }
}
