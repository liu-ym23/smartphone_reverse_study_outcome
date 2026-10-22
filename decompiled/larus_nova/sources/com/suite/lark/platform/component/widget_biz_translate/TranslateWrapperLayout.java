package com.suite.lark.platform.component.widget_biz_translate;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002&'B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateWrapperLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "preY", "", "startY", "totalOffsetY", "maxVelocity", "listener", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateWrapperLayout$ShrinkLayoutChangeListener;", "velocityTracker", "Landroid/view/VelocityTracker;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "setListener", "", "onTouchEvent", "event", "onAttachedToWindow", "onDetachedFromWindow", "isChildNeedScroll", "viewGroup", "Landroid/view/ViewGroup;", "isLocationInView", "view", "Landroid/view/View;", "x", "y", "startRestore", "ShrinkLayoutChangeListener", "Companion", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslateWrapperLayout extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f461137f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f461138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f461139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f461140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f461141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f461142e;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public TranslateWrapperLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TranslateWrapperLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setListener(b r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r100 = this.f461142e;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
        this.f461142e = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f461142e = VelocityTracker.obtain();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Log.d("TranslateWrapperLayout", "onInterceptTouchEvent: ev: " + r100.getActionMasked());
        if (r100.getActionMasked() != 0) goto L6;
        this.f461139b = r100.getRawY();
    L17:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r100.getActionMasked() != 2) goto L17;
        if ((r100.getRawY() - this.f461139b) <= 20.0f) goto L10;
        boolean r101 = true;
    L11:
        boolean r102 = a(this, r100);
        if (r101 == false) goto L17;
        if (r102 == true) goto L17;
        this.f461138a = r100.getRawY();
        this.f461140c = 0.0f;
        return true;
    L10:
        r101 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        Log.d("TranslateWrapperLayout", "onTouchEvent: " + r100.getAction());
        if (this.f461142e != null) goto L5;
        this.f461142e = VelocityTracker.obtain();
    L5:
        VelocityTracker r102 = this.f461142e;
        Intrinsics.checkNotNull(r102);
        r102.addMovement(r100);
        VelocityTracker r103 = this.f461142e;
        Intrinsics.checkNotNull(r103);
        r103.computeCurrentVelocity(1000, this.f461141d);
        r103.getXVelocity();
        float r104 = r103.getYVelocity();
        boolean r105 = false;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L10;
    L24:
        return true;
    L10:
        if (this.f461138a != 0.0f) goto L12;
        r105 = true;
    L12:
        if (r105 == false) goto L14;
        this.f461138a = r100.getRawY();
    L14:
        this.f461140c += r100.getRawY() - this.f461138a;
        Log.d("TranslateWrapperLayout", "mTotalOffsetY is " + this.f461140c + "  event.rawY is " + r100.getRawY() + " mPreY os " + this.f461138a);
        if (this.f461140c >= 0.0f) goto L17;
        this.f461140c = 0.0f;
    L17:
        setTranslationY(this.f461140c);
        this.f461138a = r100.getRawY();
        goto L24
    L19:
        if (r104 > 2000.0f) goto L24;
        if (this.f461140c > 300.0f) goto L24;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{getTranslationY(), 0.0f});
        r106.setInterpolator(new DecelerateInterpolator());
        r106.addUpdateListener(new e(this));
        Intrinsics.checkNotNull(r106);
        r106.addListener(new d(this));
        r106.addListener(new c(this));
        r106.start();
        goto L24
    }

    public static boolean a(ViewGroup r110, MotionEvent r111) {
        if (r110.canScrollVertically(-1) == false) goto L5;
        return true;
    L5:
        int r100 = r110.getChildCount();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L20;
        View r102 = r110.getChildAt(r101);
        if (r102 == null) goto L19;
        float r103 = r111.getRawX();
        float r104 = r111.getRawY();
        int[] r105 = new int[2];
        r102.getLocationOnScreen(r105);
        int r112 = r105[0];
        if (new RectF(r112, r105[1], r112 + r102.getWidth(), r105[1] + r102.getHeight()).contains(r103, r104) == false) goto L19;
        if ((r102 instanceof ViewGroup) == false) goto L16;
        boolean r106 = a((ViewGroup) r102, r111);
    L17:
        if (r106 == false) goto L19;
        return true;
    L16:
        r106 = r102.canScrollVertically(-1);
    L19:
        r101 = r101 + 1;
        goto L6
    L20:
        return false;
    }

    public TranslateWrapperLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r100 == null) goto L7;
        this.f461141d = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public /* synthetic */ TranslateWrapperLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
