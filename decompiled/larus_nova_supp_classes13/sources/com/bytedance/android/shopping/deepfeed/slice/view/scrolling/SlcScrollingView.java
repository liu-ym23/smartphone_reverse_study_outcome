package com.bytedance.android.shopping.deepfeed.slice.view.scrolling;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/scrolling/SlcScrollingView;", "Landroid/view/ViewGroup;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/scrolling/SlcScrollingView$b;", "listener", "", "setOnScrollAnimationEndListener", "", "speed", "setScrollingSpeed", "", "duration", "setWaitDuration", "delay", "setStartDelay", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcScrollingView extends ViewGroup {
    public static final /* synthetic */ int g = 0;
    public boolean a;
    public ValueAnimator b;
    public b c;
    public float d;
    public long e;
    public long f;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SlcScrollingView a;
        public final /* synthetic */ int b;

        public c(SlcScrollingView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            View r0 = this.a.getChildAt(0);
            if (r0 != null) goto L5;
        L16:
            this.a.c();
            return;
        L5:
            if (r0.getMeasuredWidth() != this.b) goto L16;
            if ((!Intrinsics.areEqual(r3, this.a.b)) == false) goto L10;
            return;
        L10:
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L15;
            this.a.b(((Float) r4).floatValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ SlcScrollingView a;
        public final /* synthetic */ int b;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void a() {
                d r0 = this.a;
                SlcScrollingView r1 = r0.a;
                int r2 = r0.b;
                int r3 = SlcScrollingView.g;
                if (r1.getChildCount() != 0) goto L5;
                r1.a = false;
                return;
            L5:
                int r4 = r1.getChildAt(0).getMeasuredWidth();
                if (r1.getWidth() <= 0) goto L8;
                r2 = r1.getWidth();
            L8:
                int r5 = r4 - r2;
                if (r5 > 0) goto L13;
                r1.a = false;
                r1.b(0.0f);
                b r6 = r1.c;
                if (r6 == null) goto L16;
                r6.a();
                return;
            L16:
                return;
            L13:
                float r7 = r5;
                ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{r7, 0.0f});
                r8.setDuration(Math.max(0, (long) ((r7 / r1.d) * 1000)));
                r8.addUpdateListener(new cd3.c(r1, r4));
                r8.addListener(new cd3.d(r1));
                r8.start();
                Unit r9 = Unit.INSTANCE;
                r1.b = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            SlcScrollingView r5 = this.a;
            if (r5.a == true) goto L5;
            return;
        L5:
            r5.postDelayed(new a(this), r5.e);
        }

        public d(SlcScrollingView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public SlcScrollingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SlcScrollingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c() {
        ValueAnimator r0 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.b = null;
        this.a = false;
        b(0.0f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public final void b(float r5) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getChildAt(r1).setTranslationX(-r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r2);
    L6:
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public final void setOnScrollAnimationEndListener(b r1) {
        this.c = r1;
    }

    public final void setScrollingSpeed(float r2) {
        if (r2 <= 0) goto L6;
        this.d = r2;
        return;
    }

    public final void setStartDelay(long r1) {
        this.f = r1;
    }

    public final void setWaitDuration(long r1) {
        this.e = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    public final void a(int r7, int r8) {
        float r0 = r7 - r8;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, r0});
        r1.setDuration(Math.max(0, (long) ((r0 / this.d) * 1000)));
        r1.addUpdateListener(new c(this, r7));
        r1.addListener(new d(this, r8));
        r1.start();
        Unit r9 = Unit.INSTANCE;
        this.b = r1;
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        int r0 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        View r4 = getChildAt(r2);
        r4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r3 = Math.max(r3, r4.getMeasuredHeight());
        r2 = r2 + 1;
        goto L3
    L5:
        int r10 = View.MeasureSpec.getSize(r8);
        int r1 = View.MeasureSpec.getMode(r9);
        if (r1 != Integer.MIN_VALUE) goto L8;
        int r5 = Math.min((r3 + getPaddingTop()) + getPaddingBottom(), View.MeasureSpec.getSize(r9));
    L12:
        setMeasuredDimension(r10, r5);
        return;
    L8:
        if (r1 == 1073741824) goto L10;
        r5 = (r3 + getPaddingTop()) + getPaddingBottom();
        goto L12
    L10:
        r5 = View.MeasureSpec.getSize(r9);
        goto L12
    }

    public SlcScrollingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = 100.0f;
        this.e = 1000;
        this.f = 1000;
    }

    public /* synthetic */ SlcScrollingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getPaddingLeft();
        int r9 = getPaddingTop();
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() == 8) goto L7;
        r12.layout(r8, r9, r12.getMeasuredWidth() + r8, r12.getMeasuredHeight() + r9);
    L7:
        r11 = r11 + 1;
        goto L3
    }
}
