package com.obric.assistant.settings;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392241a = 0;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f392242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f392243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GradientDrawable f392244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f392245d;

        /* JADX INFO: renamed from: com.obric.assistant.settings.p0$a$a, reason: collision with other inner class name */
        public static final class C4631a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f392246a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View.OnLayoutChangeListener f392247b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ GradientDrawable f392248c;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f392246a.removeOnLayoutChangeListener(this.f392247b);
                this.f392246a.getOverlay().remove(this.f392248c);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f392246a.removeOnLayoutChangeListener(this.f392247b);
                this.f392246a.getOverlay().remove(this.f392248c);
            }

            public C4631a(View r100, View.OnLayoutChangeListener r101, GradientDrawable r102) {
                this.f392246a = r100;
                this.f392247b = r101;
                this.f392248c = r102;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f392242a.removeOnLayoutChangeListener(this.f392243b);
            this.f392242a.getOverlay().remove(this.f392244c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f392244c.setColor(this.f392245d);
            this.f392244c.setAlpha(255);
            final View r101 = this.f392242a;
            final GradientDrawable r102 = this.f392244c;
            final View.OnLayoutChangeListener r103 = this.f392243b;
            r101.postDelayed(new n0(r102, r101, r103), 1000);
        }

        public a(View r100, l0 r101, GradientDrawable r102, int r103) {
            this.f392242a = r100;
            this.f392243b = r101;
            this.f392244c = r102;
            this.f392245d = r103;
        }
    }

    static {
    }

    public static Rect a(ViewGroup r100) {
        Rect r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L25;
        View r104 = r100.getChildAt(r103);
        if (r104.getVisibility() != 0) goto L24;
        if (r104.getWidth() <= 0) goto L24;
        if (r104.getHeight() <= 0) goto L24;
        if ((r104 instanceof ViewGroup) == false) goto L20;
        ViewGroup r105 = (ViewGroup) r104;
        Rect r106 = a(r105);
        if (r106 == null) goto L19;
        r100.offsetDescendantRectToMyCoords(r104, r106);
    L21:
        if (r101 == null) goto L23;
        r101.union(r106);
        goto L24
    L23:
        r101 = r106;
        goto L24
    L19:
        r106 = new Rect(r105.getLeft(), r105.getTop(), r105.getRight(), r105.getBottom());
        goto L21
    L20:
        r106 = new Rect(r104.getLeft(), r104.getTop(), r104.getRight(), r104.getBottom());
    L24:
        r103 = r103 + 1;
        goto L6
    L25:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.obric.assistant.settings.k0] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View$OnLayoutChangeListener, com.obric.assistant.settings.l0] */
    public static void d(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        int r101 = ContextCompat.getColor(r100.getContext(), R.color.oui_fill_element_2);
        final GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setColor(r101);
        r102.setAlpha(0);
        float[] r103 = null;
        if ((r100 instanceof OCardListItem) == false) goto L5;
        OCardListItem r104 = (OCardListItem) r100;
    L6:
        if (r104 == null) goto L10;
        FrameLayout r105 = r104.getCardContainer();
        if (r105 == null) goto L10;
        Drawable r106 = r105.getBackground();
    L12:
        if ((r106 instanceof GradientDrawable) == false) goto L14;
        GradientDrawable r107 = (GradientDrawable) r106;
    L15:
        if (r107 == null) goto L17;
        r103 = r107.getCornerRadii();
    L17:
        if (r103 == null) goto L19;
        r102.setCornerRadii(Arrays.copyOf(r103, r103.length));
    L23:
        final ?? r108 = new k0(r100, r102);
        ?? r109 = new l0(r108);
        r108.invoke();
        r100.animate().cancel();
        r100.getOverlay().clear();
        r100.getOverlay().add(r102);
        r100.addOnLayoutChangeListener(r109);
        ValueAnimator r110 = ValueAnimator.ofInt(new int[]{0, 224});
        r110.setDuration(220);
        r110.setInterpolator(new DecelerateInterpolator());
        r110.addUpdateListener(new m0(r102));
        AnimatorSet r111 = new AnimatorSet();
        r111.playTogether(new Animator[]{r110});
        r111.addListener(new a(r100, r109, r102, r101));
        r111.start();
        return;
    L19:
        if (r107 == null) goto L21;
        float r112 = r107.getCornerRadius();
    L22:
        r102.setCornerRadius(r112);
        goto L23
    L21:
        r112 = b(r100.getContext(), 16.0f);
        goto L22
    L14:
        r107 = null;
    L10:
        r106 = null;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    public static float b(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static Rect c(Rect r100, int r101, int r102, int r103) {
        int r104 = RangesKt.coerceAtMost(r101, RangesKt.coerceAtLeast(r100.width() - 1, 0) / 2);
        int r105 = RangesKt.coerceAtMost(r101, RangesKt.coerceAtLeast(r100.height() - 1, 0) / 2);
        return new Rect(RangesKt.coerceAtLeast(r100.left + r104, 0), RangesKt.coerceAtLeast(r100.top + r105, 0), RangesKt.coerceAtMost(r100.right - r104, r102), RangesKt.coerceAtMost(r100.bottom - r105, r103));
    }
}
