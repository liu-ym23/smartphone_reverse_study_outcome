package com.bytedance.ies.uikit.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public class CustomViewBehind extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f249038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f249039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f249040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f249041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f249043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f249047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f249048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f249049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f249050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f249051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f249052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249053p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap f249054q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f249055r;

    public void setCanvasTransformer(SlidingMenu.b r100) {
    }

    public void setCustomViewAbove(CustomViewAbove r100) {
    }

    private int getSelectorTop() {
        return this.f249055r.getTop() + ((this.f249055r.getHeight() - this.f249054q.getHeight()) / 2);
    }

    public int getBehindWidth() {
        return this.f249039b.getWidth();
    }

    public int getSecondaryBehindWidth() {
        return this.f249040c.getWidth();
    }

    public View getContent() {
        return this.f249039b;
    }

    public int getMode() {
        return this.f249045h;
    }

    public float getScrollScale() {
        return this.f249048k;
    }

    public View getSecondaryContent() {
        return this.f249040c;
    }

    public CustomViewBehind(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return !this.f249044g;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return !this.f249044g;
    }

    public void setChildrenEnabled(boolean r100) {
        this.f249044g = r100;
    }

    public void setContent(View r100) {
        View r101 = this.f249039b;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.f249039b = r100;
        addView(r100);
    }

    public void setFadeDegree(float r100) {
        if (r100 > 1.0f) goto L9;
        if (r100 < 0.0f) goto L9;
        this.f249052o = r100;
        return;
    L9:
        throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
    }

    public void setFadeEnabled(boolean r100) {
        this.f249046i = r100;
    }

    public void setMode(int r100) {
        if (r100 != 0) goto L4;
    L5:
        View r101 = this.f249039b;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
    L8:
        View r102 = this.f249040c;
        if (r102 == null) goto L11;
        r102.setVisibility(4);
    L11:
        this.f249045h = r100;
        return;
    L4:
        if (r100 != 1) goto L11;
        goto L5
    }

    public void setScrollScale(float r100) {
        this.f249048k = r100;
    }

    public void setSecondaryContent(View r100) {
        View r101 = this.f249040c;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.f249040c = r100;
        addView(r100);
    }

    public void setSecondaryShadowDrawable(Drawable r100) {
        this.f249050m = r100;
        invalidate();
    }

    public void setSecondaryWidthOffset(int r100) {
        this.f249043f = r100;
        requestLayout();
    }

    public void setSelectedView(View r100) {
        View r101 = this.f249055r;
        if (r101 == null) goto L5;
        r101.setTag(R.id.selected_view, null);
        this.f249055r = null;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getParent() == null) goto L11;
        this.f249055r = r100;
        r100.setTag(R.id.selected_view, "CustomViewBehindSelectedView");
        invalidate();
        return;
    }

    public void setSelectorBitmap(Bitmap r100) {
        this.f249054q = r100;
        refreshDrawableState();
    }

    public void setSelectorEnabled(boolean r100) {
        this.f249053p = r100;
    }

    public void setShadowDrawable(Drawable r100) {
        this.f249049l = r100;
        invalidate();
    }

    public void setShadowWidth(int r100) {
        this.f249051n = r100;
        invalidate();
    }

    public void setTouchMode(int r100) {
        this.f249038a = r100;
    }

    public void setWidthOffset(int r100) {
        this.f249042e = r100;
        requestLayout();
    }

    public CustomViewBehind(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249038a = 0;
        this.f249047j = new Paint();
        this.f249053p = true;
        Resources r102 = getResources();
        this.f249041d = (int) TypedValue.applyDimension(1, 15.0f, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = ViewGroup.getDefaultSize(0, r100);
        int r103 = ViewGroup.getDefaultSize(0, r101);
        setMeasuredDimension(r102, r103);
        int r104 = ViewGroup.getChildMeasureSpec(r100, 0, r102 - this.f249042e);
        int r105 = ViewGroup.getChildMeasureSpec(r101, 0, r103);
        this.f249039b.measure(r104, r105);
        if (this.f249040c == null) goto L6;
        int r106 = ViewGroup.getChildMeasureSpec(r100, 0, r102 - this.f249043f);
        this.f249040c.measure(r106, r105);
        return;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        super.scrollTo(r100, r101);
    }

    public final void a(View r100, Canvas r101, float r102) {
        if (this.f249053p == true) goto L6;
        return;
    L6:
        if (this.f249054q == null) goto L19;
        View r103 = this.f249055r;
        if (r103 != null) goto L10;
        return;
    L10:
        if (((String) r103.getTag(R.id.selected_view)).equals("CustomViewBehindSelectedView") == false) goto L21;
        r101.save();
        int r104 = (int) (this.f249054q.getWidth() * r102);
        int r105 = this.f249045h;
        if (r105 != 0) goto L15;
        int r106 = r100.getLeft();
        int r107 = r106 - r104;
        r101.clipRect(r107, 0, r106, getHeight());
        r101.drawBitmap(this.f249054q, r107, getSelectorTop(), null);
    L17:
        r101.restore();
        return;
    L15:
        if (r105 != 1) goto L17;
        int r108 = r100.getRight();
        int r109 = r104 + r108;
        r101.clipRect(r108, 0, r109, getHeight());
        Bitmap r110 = this.f249054q;
        r101.drawBitmap(r110, r109 - r110.getWidth(), getSelectorTop(), null);
        goto L17
    L21:
        return;
    }

    public final boolean b(View r100, int r101, float r102) {
        int r103 = this.f249045h;
        if (r103 == 0) goto L19;
        if (r103 != 2) goto L8;
        if (r101 == 0) goto L19;
    L8:
        if (r103 == 1) goto L14;
        if (r103 != 2) goto L12;
        if (r101 == 2) goto L14;
    L12:
        return false;
    L14:
        if (r102 <= r100.getRight()) goto L23;
        return false;
    L23:
        return true;
    L19:
        if (r102 >= r100.getLeft()) goto L24;
        return false;
    L24:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = r103 - r101;
        int r106 = r104 - r102;
        this.f249039b.layout(0, 0, r105 - this.f249042e, r106);
        View r107 = this.f249040c;
        if (r107 == null) goto L6;
        r107.layout(0, 0, r105 - this.f249043f, r106);
        return;
    }
}
