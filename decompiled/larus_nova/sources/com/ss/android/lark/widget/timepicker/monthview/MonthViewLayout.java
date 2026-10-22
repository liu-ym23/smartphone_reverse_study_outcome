package com.ss.android.lark.widget.timepicker.monthview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vec.k;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDownY", "", "mDownX", "mLastY", "mIsScrollingUp", "", "mVerticalSlop", "mMonthViewListener", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewListener;", "getMMonthViewListener", "()Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewListener;", "setMMonthViewListener", "(Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewListener;)V", "mMonthValueAnimator", "Landroid/animation/ValueAnimator;", "mTitleHeight", "getMTitleHeight", "()I", "setMTitleHeight", "(I)V", "getScaledTouchSlop", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "hideMonthView", "", "dy", "spreadMonthView", "getMoveOffset", "offset", "maxOffset", "autoScroll", "startScroll", "start", "end", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonthViewLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f449036c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f449037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449038b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthViewLayout f449039a;

        public a(MonthViewLayout r100) {
            this.f449039a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue() - this.f449039a.getTop();
            this.f449039a.offsetTopAndBottom(r102);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthViewLayout f449040a;

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

        public b(MonthViewLayout r100) {
            this.f449040a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MonthViewLayout r101 = this.f449040a;
            int r102 = MonthViewLayout.f449036c;
            r101.getClass();
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return true;
    }

    public final k getMMonthViewListener() {
        k r100 = this.f449037a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mMonthViewListener");
        return null;
    }

    public final int getMTitleHeight() {
        return this.f449038b;
    }

    public MonthViewLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void setMMonthViewListener(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f449037a = r100;
    }

    public final void setMTitleHeight(int r100) {
        this.f449038b = r100;
    }

    public MonthViewLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewConfiguration.get(r100).getScaledTouchSlop();
        ValueAnimator r102 = new ValueAnimator();
        r102.addUpdateListener(new a(this));
        r102.addListener(new b(this));
    }
}
