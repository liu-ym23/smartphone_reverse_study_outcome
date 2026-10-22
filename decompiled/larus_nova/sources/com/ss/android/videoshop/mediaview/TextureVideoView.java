package com.ss.android.videoshop.mediaview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import cjc.h;
import com.bytedance.common.utility.reflect.ReflectUtils;
import com.ss.android.videoshop.log.VideoTracer;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class TextureVideoView extends TextureView implements a, cjc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureView.SurfaceTextureListener f456029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a.InterfaceC5459a f456030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f456031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f456032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Surface f456033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SurfaceTexture f456034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f456035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f456036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f456037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tic.a f456038j;

    public View getGestureView() {
        return this;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public View getView() {
        return this;
    }

    public final void b() {
        if (this.f456031c == true) goto L5;
        return;
    L5:
        if (this.f456034f != null) goto L7;
        return;
    L7:
        if (this.f456032d == false) goto L25;
        Surface r100 = this.f456033e;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.isValid() == true) goto L13;
        return;
    L13:
        if (this.f456034f == getSurfaceTexture()) goto L28;
        boolean r101 = a(this.f456034f);
        System.err.println("isSurfaceTextureReleased:" + r101);
        if (r101 == true) goto L29;
        setSurfaceTexture(this.f456034f);
        ajc.b.a("TextureVideoView", "onWindowVisibilityChanged setSurfaceTexture");
        a.InterfaceC5459a r102 = this.f456030b;
        if (r102 == null) goto L19;
        ((VideoPatchLayout) r102).f0();
    L19:
        TextureView.SurfaceTextureListener r103 = this.f456029a;
        if (r103 == null) goto L30;
        r103.onSurfaceTextureAvailable(this.f456034f, 0, 0);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public float getCenterCropScaleFactor() {
        return this.f456037i.a();
    }

    public float getCenterInsideScaleFactor() {
        this.f456037i.getClass();
        return 1.0f;
    }

    public float getLayoutScaleFactor() {
        return this.f456037i.c();
    }

    public Rect getRealViewRect() {
        return new Rect((int) getRealLeft(), (int) getRealTop(), (int) getRealRight(), (int) getRealBottom());
    }

    public RectF getRealViewRectF() {
        return new RectF(getRealLeft(), getRealTop(), getRealRight(), getRealBottom());
    }

    public int getVideoHeight() {
        return this.f456037i.f24004c;
    }

    public int getVideoWidth() {
        return this.f456037i.f24003b;
    }

    public RectF getViewRect() {
        h r100 = this.f456037i;
        r100.getClass();
        return new RectF(r100.d(), r100.e(), r100.d() + (r100.f24002a.getWidth() * r100.f24002a.getScaleX()), r100.e() + (r100.f24002a.getHeight() * r100.f24002a.getScaleY()));
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        h r100 = this.f456037i;
        r100.f24005d = 0;
        r100.f24006e = 0;
        super.onAttachedToWindow();
    }

    public float getRealBottom() {
        return getRealTop() + getRealHeight();
    }

    public float getRealHeight() {
        return getHeight() * getScaleY();
    }

    public float getRealLeft() {
        return (getLeft() + ((getWidth() - getRealWidth()) / 2.0f)) + getTranslationX();
    }

    public float getRealRight() {
        return getRealLeft() + getRealWidth();
    }

    public float getRealTop() {
        return (getTop() + ((getHeight() - getRealHeight()) / 2.0f)) + getTranslationY();
    }

    public float getRealWidth() {
        return getWidth() * getScaleX();
    }

    public tic.a getPlayEntity() {
        return this.f456038j;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public Surface getSurface() {
        return this.f456033e;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public TextureVideoView(Context r100) {
        this(r100, null);
    }

    public static boolean a(SurfaceTexture r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        Method r101 = ReflectUtils.getMethod(SurfaceTexture.class, "isReleased", null);
        if (r101 == null) goto L22;
        Object r102 = r101.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
        if ((r102 instanceof Boolean) == false) goto L23;
    L25:
        return ((Boolean) r102).booleanValue();
    L23:
        return false;
    L17:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L22:
        return false;
    L8:
        return r100.isReleased();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (getVisibility() != 0) goto L7;
        if (r100 != 0) goto L8;
        b();
        return;
    L8:
        return;
    }

    public void setCropStrategy(gjc.a r100) {
        h r101 = this.f456037i;
        if (r100 == r101.f24012k) goto L6;
        r101.f24012k = r100;
        r101.f24013l = null;
        r101.f24002a.requestLayout();
        return;
    }

    @Override // android.view.View
    public void setKeepScreenOn(boolean r100) {
        super.setKeepScreenOn(r100);
        ajc.b.a("TextureVideoView", "texture view keep_screen_on:" + Boolean.valueOf(r100).toString());
    }

    public void setMaxScaleFactor(float r100) {
        h r101 = this.f456037i;
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
        h r101 = this.f456037i;
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

    public void setOptimizeBlackSide(boolean r100) {
        this.f456037i.f24014m = r100;
    }

    public void setOptimizeNormalFillScreen(boolean r100) {
        this.f456037i.f24015n = r100;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public void setPlayEntity(tic.a r100) {
        this.f456038j = r100;
    }

    public void setResizeListener(cjc.a r100) {
        this.f456037i.getClass();
    }

    public void setReuseSurfaceTexture(boolean r100) {
        this.f456031c = r100;
    }

    public void setRotatable(boolean r100) {
        this.f456037i.getClass();
    }

    public void setScalable(boolean r100) {
        this.f456037i.getClass();
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public void setSurfaceCallback(a.InterfaceC5459a r100) {
        this.f456030b = r100;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        this.f456029a = r100;
    }

    public void setTextureLayout(int r100) {
        h r101 = this.f456037i;
        if (r101.f24011j == r100) goto L6;
        r101.f24011j = r100;
        r101.f24002a.requestLayout();
        return;
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix r100) {
        super.setTransform(r100);
        this.f456037i.getClass();
    }

    public void setTranslatable(boolean r100) {
        this.f456037i.getClass();
    }

    public void setZoomingEnabled(boolean r100) {
        this.f456037i.f24016o = r100;
    }

    public TextureVideoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f456031c = false;
        this.f456037i = new h(this, this);
        super.setSurfaceTextureListener(new d(this));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ajc.b.c("TextureVideoView", "widthMeasureSpec:" + View.MeasureSpec.toString(r100));
        ajc.b.c("TextureVideoView", "heightMeasureSpec:" + View.MeasureSpec.toString(r101));
        Pair<Integer, Integer> r102 = this.f456037i.f(r100, r101, (getSuggestedMinimumWidth() + getPaddingLeft()) + getPaddingRight(), (getSuggestedMinimumHeight() + getPaddingTop()) + getPaddingBottom());
        setMeasuredDimension(((Integer) r102.first).intValue(), ((Integer) r102.second).intValue());
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);     // Catch: Exception -> L4
    L5:
        if (r100 != this) goto L11;
        if (r101 != 0) goto L12;
        b();
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        super.onLayout(r100, r110, r111, r112, r113);
        int r101 = getWidth();
        int r102 = getHeight();
        if (this.f456035g == r101) goto L5;
    L6:
        this.f456035g = r101;
        this.f456036h = r102;
        String r103 = "tv_size_layout:" + r101 + "*" + r102 + " parent:" + this.f456037i.f24007f + "*" + this.f456037i.f24008g;
        ajc.b.a("TextureVideoView", r103);
        VideoTracer r104 = VideoTracer.INS;
        tic.a r105 = this.f456038j;
        h r114 = this.f456037i;
        r104.updateTextureSize(r105, r101, r102, r114.f24007f, r114.f24008g, getScaleX(), getContext());
        bjc.b r115 = bjc.b.b("TVOnLayout", PathID.TEXTURE_SIZE, 6);
        if (r115 == null) goto L11;
        r115.a("info", r103);
        LogTracer.INS.addTrace(this.f456038j, r115);
        return;
    L11:
        return;
    L5:
        if (this.f456036h != r102) goto L6;
    }
}
