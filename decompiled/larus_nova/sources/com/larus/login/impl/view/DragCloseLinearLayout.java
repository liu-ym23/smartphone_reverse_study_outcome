package com.larus.login.impl.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/login/impl/view/DragCloseLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "", "moveY", "initialY", "contentSize", "getContentSize", "()F", "contentSize$delegate", "Lkotlin/Lazy;", "onTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "endAnim", "", "close", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "mMaximumFlingVelocity", "getYVelocity", "listener", "Lcom/larus/login/impl/view/DragCloseLinearLayout$LayCloseListener;", "setLayoutCloseListener", "LayCloseListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragCloseLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f358343h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f358344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f358345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f358346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f358347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VelocityTracker f358348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f358349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f358350g;

    public interface a {
        void close();
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragCloseLinearLayout f358351a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(DragCloseLinearLayout r100) {
            this.f358351a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f358351a.f358350g;
            if (r101 == null) goto L6;
            r101.close();
            return;
        }
    }

    public DragCloseLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DragCloseLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final float getContentSize() {
        return ((Number) this.f358347d.getValue()).floatValue();
    }

    public final void a(boolean r100) {
        Property r101 = View.TRANSLATION_Y;
        float[] r102 = new float[2];
        r102[0] = getTranslationY();
        if (r100 == false) goto L5;
        float r103 = getContentSize();
    L6:
        r102[1] = r103;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, r101, r102);
        r104.setDuration(150);
        r104.setInterpolator(new LinearInterpolator());
        if (r100 == false) goto L9;
        r104.addListener(new b(this));
    L9:
        r104.start();
        return;
    L5:
        r103 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f358348e.addMovement(r100);
        int r101 = r100.getAction();
        if (r101 == 0) goto L21;
        if (r101 != 1) goto L6;
        VelocityTracker r102 = this.f358348e;
        int r103 = r100.getPointerId(0);
        r102.computeCurrentVelocity(1000, this.f358349f);
        if (r102.getYVelocity(r103) <= 700.0f) goto L17;
        a(true);
    L24:
        return true;
    L17:
        if (getTranslationY() >= (getHeight() / 3)) goto L19;
        a(false);
        goto L24
    L19:
        a(true);
        goto L24
    L6:
        if (r101 != 2) goto L24;
        if (r100.getRawY() < this.f358344a) goto L11;
    L12:
        this.f358345b = r100.getRawY() - this.f358344a;
        setTranslationY(getTranslationY() + this.f358345b);
        this.f358344a = r100.getRawY();
        goto L24
    L11:
        if (getTranslationY() <= 0.0f) goto L24;
    L21:
        if (this.f358346c >= 0.0f) goto L23;
        this.f358346c = r100.getY();
    L23:
        this.f358344a = r100.getRawY();
        goto L24
    }

    public final void setLayoutCloseListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f358350g = r100;
    }

    public DragCloseLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f358346c = -1.0f;
        this.f358347d = LazyKt.lazy(new ck9.b(this));
        this.f358348e = VelocityTracker.obtain();
        this.f358349f = ViewConfiguration.getMaximumFlingVelocity();
    }

    public /* synthetic */ DragCloseLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
