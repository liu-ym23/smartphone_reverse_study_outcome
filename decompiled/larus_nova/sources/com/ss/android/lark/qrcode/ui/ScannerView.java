package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes37.dex */
public class ScannerView extends SurfaceView implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f439033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f439034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScaleGestureDetector f439035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f439036d;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
    }

    private float getScale() {
        this.f439033a.getValues(this.f439034b);
        return this.f439034b[0];
    }

    public ScannerView(Context r100) {
        super(r100);
        this.f439033a = new Matrix();
        this.f439034b = new float[9];
        Resources r101 = getContext().getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        this.f439035c = new ScaleGestureDetector(getContext(), this);
    }

    private void setScanner(a r100) {
        this.f439036d = r100;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        getScale();
        r100.getScaleFactor();
        r100.getCurrentSpan();
        r100.getCurrentSpan();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        r100.getCurrentSpan();
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        ScaleGestureDetector r101 = this.f439035c;
        if (r101 != null) goto L5;
        return true;
    L5:
        r101.onTouchEvent(r100);
        if (r100.getPointerCount() != 1) goto L10;
        a r102 = this.f439036d;
        if (r102 == null) goto L10;
        r100.getX();
        r100.getY();
        getWidth();
        getHeight();
        r102.getClass();
    L10:
        return true;
    }

    public ScannerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f439033a = new Matrix();
        this.f439034b = new float[9];
        Resources r102 = getContext().getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.f439035c = new ScaleGestureDetector(getContext(), this);
    }

    public ScannerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f439033a = new Matrix();
        this.f439034b = new float[9];
        Resources r103 = getContext().getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        this.f439035c = new ScaleGestureDetector(getContext(), this);
    }
}
