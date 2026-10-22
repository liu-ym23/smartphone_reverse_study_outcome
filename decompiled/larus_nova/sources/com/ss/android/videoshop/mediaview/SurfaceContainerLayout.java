package com.ss.android.videoshop.mediaview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cjc.h;

/* JADX INFO: loaded from: classes40.dex */
public class SurfaceContainerLayout extends ViewGroup implements cjc.c, cjc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f456018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceVideoView f456019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f456020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f456021d;

    public cjc.b getGestureTargetView() {
        return this;
    }

    public View getGestureView() {
        return this;
    }

    @Override // cjc.c
    public ViewGroup getVideoContainer() {
        return this;
    }

    @Override // cjc.c
    public final void c() {
        if (this.f456020c.getVisibility() == 8) goto L6;
        this.f456020c.setVisibility(8);
        this.f456020c.setImageBitmap(null);
        return;
    }

    public float getCenterCropScaleFactor() {
        return this.f456018a.a();
    }

    public float getCenterInsideScaleFactor() {
        this.f456018a.getClass();
        return 1.0f;
    }

    @Override // cjc.c
    public int getTextureLayout() {
        return this.f456018a.f24011j;
    }

    @Override // cjc.c
    public int getVideoHeight() {
        return this.f456018a.f24004c;
    }

    @Override // cjc.c
    public int getVideoViewMarginTop() {
        if (this.f456019b == null) goto L8;
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return -1;
    L7:
        return ((ViewGroup.MarginLayoutParams) r100).topMargin;
    L8:
        return -1;
    }

    @Override // cjc.c
    public int getVideoWidth() {
        return this.f456018a.f24003b;
    }

    public RectF getViewRect() {
        h r100 = this.f456018a;
        r100.getClass();
        return new RectF(r100.d(), r100.e(), r100.d() + (r100.f24002a.getWidth() * r100.f24002a.getScaleX()), r100.e() + (r100.f24002a.getHeight() * r100.f24002a.getScaleY()));
    }

    @Override // cjc.c
    public View getBlackCoverView() {
        return this.f456021d;
    }

    @Override // cjc.c
    public a getVideoView() {
        return this.f456019b;
    }

    public SurfaceContainerLayout(Context r100) {
        super(r100);
        d(r100);
    }

    @Override // cjc.c
    public final void a(int r100) {
        this.f456018a.h(r100);
    }

    @Override // cjc.c
    public final void b(Bitmap r100) {
        if (r100 == null) goto L5;
        this.f456020c.setImageBitmap(r100);
        this.f456020c.setVisibility(0);
        return;
    }

    public final void d(Context r100) {
        setClipChildren(false);
        setBackgroundColor(-16777216);
        this.f456018a = new h(this, this);
        SurfaceVideoView r101 = new SurfaceVideoView(r100);
        this.f456019b = r101;
        r101.getHolder();
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        r102.gravity = 17;
        addView(this.f456019b, r102);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -1);
        View r104 = new View(r100);
        this.f456021d = r104;
        r104.setBackgroundColor(-16777216);
        r103.gravity = 17;
        addView(this.f456021d, r103);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -1);
        ImageView r106 = new ImageView(r100);
        this.f456020c = r106;
        r105.gravity = 17;
        addView(r106, r105);
    }

    @Override // cjc.c
    public void setCropStrategy(gjc.a r100) {
        h r101 = this.f456018a;
        if (r100 == r101.f24012k) goto L6;
        r101.f24012k = r100;
        r101.f24013l = null;
        r101.f24002a.requestLayout();
        return;
    }

    public void setMaxScaleFactor(float r100) {
        h r101 = this.f456018a;
        r101.getClass();
        if (Float.isNaN(r100) == false) goto L5;
        return;
    L5:
        if (r100 >= 0.0f) goto L7;
        return;
    L7:
        if (r100 > Float.MAX_VALUE) goto L13;
        r101.f24009h = r100;
        return;
    }

    public void setMinScaleFactor(float r100) {
        h r101 = this.f456018a;
        r101.getClass();
        if (Float.isNaN(r100) == false) goto L5;
        return;
    L5:
        if (r100 >= 0.0f) goto L7;
        return;
    L7:
        if (r100 > Float.MAX_VALUE) goto L13;
        r101.f24010i = r100;
        return;
    }

    @Override // cjc.c
    public void setOptimizeBlackSide(boolean r100) {
        this.f456018a.f24014m = r100;
    }

    @Override // cjc.c
    public void setOptimizeNormalFillScreen(boolean r100) {
        this.f456018a.f24015n = r100;
    }

    public void setResizeListener(cjc.a r100) {
        this.f456018a.getClass();
    }

    public void setRotatable(boolean r100) {
        this.f456018a.getClass();
    }

    public void setScalable(boolean r100) {
        this.f456018a.getClass();
    }

    public void setTextureLayout(int r100) {
        h r101 = this.f456018a;
        if (r101.f24011j == r100) goto L6;
        r101.f24011j = r100;
        r101.f24002a.requestLayout();
        return;
    }

    public void setTranslatable(boolean r100) {
        this.f456018a.getClass();
    }

    @Override // cjc.c
    public void setZoomingEnabled(boolean r100) {
        this.f456018a.f24016o = r100;
    }

    public SurfaceContainerLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        d(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ajc.b.c("SurfaceContainerLayout", "widthMeasureSpec:" + View.MeasureSpec.toString(r100));
        ajc.b.c("SurfaceContainerLayout", "heightMeasureSpec:" + View.MeasureSpec.toString(r101));
        Pair<Integer, Integer> r102 = this.f456018a.f(r100, r101, (getSuggestedMinimumWidth() + getPaddingLeft()) + getPaddingRight(), (getSuggestedMinimumHeight() + getPaddingTop()) + getPaddingBottom());
        setMeasuredDimension(((Integer) r102.first).intValue(), ((Integer) r102.second).intValue());
    }

    @Override // cjc.c
    public final void setVideoSize(int r100, int r101) {
        this.f456018a.i(r100, r101);
    }

    public SurfaceContainerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        d(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = 0;
    L4:
        if (r105 >= getChildCount()) goto L6;
        getChildAt(r105).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        r105 = r105 + 1;
        goto L4
    }
}
