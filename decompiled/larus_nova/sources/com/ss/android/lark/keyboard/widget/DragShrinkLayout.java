package com.ss.android.lark.keyboard.widget;

import android.animation.AnimatorSet;
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
import com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin;
import com.ss.android.lark.keyboard.editor.input.w;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes36.dex */
public class DragShrinkLayout extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f430982i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f430983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f430984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f430985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f430986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f430987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f430988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f430989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f430990h;

    public interface a {
        void a();

        void b(float r100, float r101);

        void c();

        void d();

        void e();

        void f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r100 = this.f430988f;
        if (r100 == null) goto L5;
        r100.recycle();
        this.f430988f = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f430988f = VelocityTracker.obtain();
    }

    public DragShrinkLayout(Context r100) {
        this(r100, null);
    }

    public final void b(RichTextInputExpandPlugin.b r100) {
        float r101 = getTranslationY();
        final float r102 = getRootView().getHeight();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r101, r102});
        r103.setInterpolator(new DecelerateInterpolator());
        r103.addUpdateListener(new g(this, r102));
        r103.addListener(new i(this, r100));
        AnimatorSet r104 = new AnimatorSet();
        r104.setDuration(350);
        r104.playTogether(new ValueAnimator[]{r103});
        r104.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f430990h == false) goto L5;
        Log.d("DragShrinkLayout", "onInterceptTouchEvent: " + r100.getRawY());
        if (r100.getAction() != 0) goto L10;
        this.f430984b = r100.getRawY();
    L21:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r100.getAction() == 1) goto L21;
        if (r100.getAction() == 3) goto L21;
        if ((r100.getRawY() - this.f430984b) <= 20.0f) goto L21;
        if (a(this, r100) == true) goto L21;
        this.f430983a = r100.getRawY();
        this.f430985c = 0.0f;
        return true;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        Log.d("DragShrinkLayout", "onTouchEvent: " + r100.getAction());
        if (this.f430988f != null) goto L5;
        this.f430988f = VelocityTracker.obtain();
    L5:
        this.f430988f.addMovement(r100);
        VelocityTracker r102 = this.f430988f;
        r102.computeCurrentVelocity(1000, this.f430986d);
        float r103 = r102.getXVelocity();
        float r104 = r102.getYVelocity();
        if (r101 == 1) goto L20;
        if (r101 != 2) goto L10;
        float r105 = this.f430985c + (r100.getRawY() - this.f430983a);
        this.f430985c = r105;
        if (r105 >= 0.0f) goto L16;
        this.f430985c = 0.0f;
    L16:
        setTranslationY(this.f430985c);
        this.f430987e.b(getRootView().getHeight(), this.f430985c);
        this.f430983a = r100.getRawY();
        a r106 = this.f430987e;
        if (r106 == null) goto L26;
        r106.a();
    L26:
        Log.d("DragShrinkLayout", "onTouchEvent: " + r103 + "   " + r104);
        Log.d("DragShrinkLayout", "onTouchEvent: totaloffset=" + this.f430985c + " current=" + r100.getRawY() + " pre=" + this.f430983a + " start=" + this.f430984b);
        return super.onTouchEvent(r100);
    L10:
        if (r101 != 3) goto L26;
        setTranslationY(0.0f);
        goto L26
    L20:
        if (r104 <= 2000.0f) goto L22;
    L25:
        b(null);
        goto L26
    L22:
        if (this.f430985c > 300.0f) goto L25;
        c(null, Boolean.FALSE);
        goto L26
    }

    public void setDragEnabled(boolean r100) {
        this.f430990h = r100;
    }

    public void setListener(a r100) {
        this.f430987e = r100;
    }

    public DragShrinkLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
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

    public final void c(w r100, Boolean r101) {
        final float r102 = getRootView().getHeight();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{getTranslationY(), 0.0f});
        r103.setInterpolator(new DecelerateInterpolator());
        r103.addUpdateListener(new f(this, r102));
        r103.addListener(new h(this, r100));
        AnimatorSet r104 = new AnimatorSet();
        if (r101.booleanValue() == false) goto L5;
        int r105 = 150;
    L6:
        r104.setDuration(r105);
        r104.playTogether(new ValueAnimator[]{r103});
        r104.start();
        return;
    L5:
        r105 = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (View.MeasureSpec.getSize(r101) == 0) goto L5;
    L11:
        this.f430989g = getMeasuredHeight();
        return;
    L5:
        if (View.MeasureSpec.getMode(r101) == 1073741824) goto L9;
        if (View.MeasureSpec.getMode(r101) != Integer.MIN_VALUE) goto L11;
    L9:
        if (this.f430989g == 0) goto L11;
        post(new e(this));
        goto L11
    }

    public DragShrinkLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f430989g = 0;
        this.f430990h = true;
        ViewConfiguration.get(getContext());
        this.f430986d = ViewConfiguration.getMaximumFlingVelocity();
    }
}
