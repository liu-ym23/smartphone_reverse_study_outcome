package com.ss.android.lark.widget.previewanimation.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.widget.previewanimation.player.AnimationPlayer;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends FrameLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f447993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimationPlayer f447994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f447995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f447996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f447997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f447998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f447999g;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.previewanimation.animation.a$a, reason: collision with other inner class name */
    public static final class C5427a {
    }

    static {
    }

    public final long getDuration() {
        return this.f447995c.f448008f;
    }

    public final boolean getDestroyAfterAnimationEnd$photo_picker_release() {
        return this.f447998f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f447998f == false) goto L8;
        Function1<? super Boolean, Unit> r101 = this.f447997e;
        if (r101 == null) goto L7;
        r101.invoke(Boolean.valueOf(!this.f447996d));
    L7:
        post(new c(this));
    L8:
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        invalidate();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        float r101 = this.f447995c.f448004b;
        this.f447994b.a();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f447995c.f448004b;
        AnimationPlayer r102 = this.f447994b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r102.d(r100, r101);
        r100.restore();
    }

    public final void setDestroyAfterAnimationEnd$photo_picker_release(boolean r100) {
        this.f447998f = r100;
    }

    public final void setDuration(long r100) {
        this.f447995c.f448008f = r100;
    }

    public static final void a(final a r100, final j r101) {
        if (r100.f447993a.findViewWithTag(a.class) == null) goto L5;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    L5:
        r100.f447997e = new AnimationContext$prepareAnimation$1(r100, r101);
        r100.f447993a.addView(r100);
    }

    public a(ViewGroup r100, long r101, AnimationPlayer r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "player");
        super(r100.getContext());
        this.f447993a = r100;
        this.f447994b = r102;
        this.f447995c = new d(this);
        this.f447998f = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setOnKeyListener(new b(this));
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        setTag(a.class);
        setDuration(r101);
    }
}
