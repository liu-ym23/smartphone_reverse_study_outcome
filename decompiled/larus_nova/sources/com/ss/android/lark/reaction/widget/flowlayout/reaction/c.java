package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReactionFlowLayout.e f439434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Drawable f439435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f439436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f439437h;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f439438a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public a(c r100) {
            this.f439438a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f439438a.f439434e.a();
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f439439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f439440b;

        public b(c r100, View r101) {
            this.f439439a = r100;
            this.f439440b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            float r101 = this.f439439a.f439437h;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            float r103 = r101 * ((Float) r102).floatValue();
            float r104 = this.f439439a.f439436g;
            Object r105 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Float");
            float r106 = r104 * ((Float) r105).floatValue();
            c r107 = this.f439439a;
            int r108 = r107.f439437h;
            float r109 = 2;
            int r110 = r107.f439436g;
            r107.f439435f.setBounds((int) ((r108 - r103) / r109), (int) ((r110 - r106) / r109), (int) ((r108 + r103) / r109), (int) ((r110 + r106) / r109));
            this.f439440b.invalidate();
        }
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
    public final Drawable b() {
        return this.f439435f;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.75f, 1.0f});
        r101.setInterpolator(new AccelerateDecelerateInterpolator());
        r101.setDuration(220);
        r101.addUpdateListener(new b(this, r100));
        Intrinsics.checkNotNull(r101);
        r101.addListener(new a(this));
        r101.start();
    }

    public c(ReactionFlowLayout.e r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "extendIconClickListener");
        Intrinsics.checkNotNullParameter(r101, "drawable");
        super(2);
        this.f439434e = r100;
        this.f439435f = r101;
        int r102 = ReactionTextView.f439390o;
        int r103 = ReactionTextView.f439391p;
        this.f439436g = r103;
        if (this.f439435f.getIntrinsicHeight() <= 0) goto L5;
        this.f439437h = (this.f439435f.getIntrinsicWidth() * r103) / this.f439435f.getIntrinsicHeight();
    L5:
        this.f439435f.setBounds(0, 0, this.f439437h, r103);
    }
}
