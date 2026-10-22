package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import x6a.i;

/* JADX INFO: loaded from: classes32.dex */
class SwiperView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding, x6a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f382994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f382995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f382996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f383000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IDrawChildHook f383001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f383002i;

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public final View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // x6a.e
    public final /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, false);
    }

    @Override // x6a.e
    public final /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, false);
    }

    public final void a() {
        View r100 = new View(getContext());
        r100.setClickable(false);
        int r101 = this.f382996c;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r101, r101);
        if (this.f383000g != 1) goto L5;
        int r103 = this.f382996c / 2;
        r102.bottomMargin = r103;
        r102.topMargin = r103;
    L6:
        this.f382995b.addView(r100, r102);
        int r104 = this.f382995b.getChildCount();
        int r105 = this.f382997d;
        if (r104 != r105) goto L9;
        r100.setBackground(b(r105));
        return;
    L9:
        r100.setBackground(b(this.f382998e));
        return;
    L5:
        int r106 = this.f382996c / 2;
        r102.rightMargin = r106;
        r102.leftMargin = r106;
        goto L6
    }

    public final void e() {
        int r100 = this.f382995b.getChildCount();
    L3:
        r100 = r100 - 1;
        if (r100 <= (-1)) goto L10;
        View r101 = this.f382995b.getChildAt(r100);
        if (r100 != this.f382999f) goto L8;
        r101.setBackground(b(this.f382997d));
        goto L3
    L8:
        r101.setBackground(b(this.f382998e));
        goto L3
    }

    @Override // x6a.e
    public final i getRenderer() {
        return this.f383002i;
    }

    public final GradientDrawable b(int r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(1);
        r101.setColor(r100);
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f383001h = r100;
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
        ViewCompat.setLayoutDirection(this.f382995b, 1);
    L5:
        this.f382994a.setIsRTL(r100);
        return;
    L4:
        ViewCompat.setLayoutDirection(this.f382995b, 0);
        goto L5
    }

    public final void d(int r100) {
        this.f383000g = r100;
        LinearLayout r101 = this.f382995b;
        if (r101 == null) goto L5;
        removeView(r101);
        f(r100);
    L5:
        this.f382994a.setOrientation(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        IDrawChildHook r101 = this.f383001h;
        if (r101 == null) goto L5;
        r101.beforeDispatchDraw(r100);
    L5:
        super.dispatchDraw(r100);
        i r102 = this.f383002i;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }

    public final void f(int r100) {
        int r101 = 0;
        if (r100 != 1) goto L5;
        this.f382995b.setGravity(16);
        this.f382995b.setOrientation(1);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -1);
        r102.rightMargin = (int) com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        r102.gravity = 8388629;
    L6:
        addView(this.f382995b, r102);
        int r103 = this.f382995b.getChildCount();
        this.f382995b.removeAllViews();
    L7:
        if (r101 >= r103) goto L9;
        a();
        r101 = r101 + 1;
        goto L7
    L9:
        e();
        return;
    L5:
        this.f382995b.setGravity(17);
        this.f382995b.setOrientation(0);
        r102 = new FrameLayout.LayoutParams(-1, -2);
        r102.bottomMargin = (int) com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        r102.gravity = 81;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f383002i == null) goto L6;
        this.f383002i.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    @Override // x6a.e
    public final void setRenderer(i r100) {
        this.f383002i = r100;
    }

    public SwiperView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f382997d = XSwiperUI.G;
        this.f382998e = XSwiperUI.H;
        this.f382999f = 0;
        this.f383000g = 0;
        this.f382996c = (int) com.lynx.tasm.utils.i.b(7.0f, 0.0f);
        ViewPager r102 = new ViewPager(r100);
        this.f382994a = r102;
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        this.f382995b = new LinearLayout(r100);
        f(0);
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r100, int r101) {
        return new i(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        i r103 = this.f383002i;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        i r105 = this.f383002i;
        if (r105 == null) goto L8;
        r105.getClass();
        r100.restore();
    L8:
        return r104;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.f383002i;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
