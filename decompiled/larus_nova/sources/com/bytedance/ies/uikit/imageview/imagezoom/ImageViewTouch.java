package com.bytedance.ies.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes19.dex */
public class ImageViewTouch extends ImageViewTouchBase {
    public boolean A;
    public boolean B;
    public View.OnClickListener C;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScaleGestureDetector f248972r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public GestureDetector f248973s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f248974t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f248975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f248976v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public GestureDetector.OnGestureListener f248977w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ScaleGestureDetector.OnScaleGestureListener f248978x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f248979y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f248980z;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouch f248981a;

        public a(ImageViewTouch r100) {
            this.f248981a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            ImageViewTouch r101 = this.f248981a;
            if (r101.f248979y == false) goto L12;
            float r102 = r101.getScale();
            ImageViewTouch r103 = this.f248981a;
            float r104 = r103.getMaxZoom();
            if (r103.f248976v != 1) goto L10;
            float r105 = r103.f248975u;
            if (((2.0f * r105) + r102) > r104) goto L9;
            r104 = r102 + r105;
        L11:
            float r106 = Math.min(this.f248981a.getMaxZoom(), Math.max(r104, this.f248981a.getMinZoom()));
            ImageViewTouch r107 = this.f248981a;
            r107.f248974t = r106;
            r107.q(r106, r100.getX(), r100.getY(), 200.0f);
            this.f248981a.invalidate();
            goto L12
        L9:
            r103.f248976v = -1;
            goto L11
        L10:
            r103.f248976v = 1;
            r104 = 1.0f;
        L12:
            this.f248981a.getClass();
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            if (this.f248981a.isLongClickable() == true) goto L5;
            return;
        L5:
            if (this.f248981a.f248972r.isInProgress() == true) goto L9;
            this.f248981a.setPressed(true);
            this.f248981a.performLongClick();
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            ImageViewTouch r101 = this.f248981a;
            View.OnClickListener r102 = r101.C;
            if (r102 == null) goto L9;
            if (r101.B == false) goto L9;
            r102.onClick(r101);
            return true;
        L9:
            return super.onSingleTapConfirmed(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
            ImageViewTouch r100 = this.f248981a;
            if (r100.A == true) goto L6;
        L21:
            return false;
        L6:
            if (Logger.debug() == false) goto L9;
            Logger.d("image", "onFling: " + r112 + ", " + r113);
        L9:
            if (r110.getPointerCount() > 1) goto L21;
            if (r111.getPointerCount() > 1) goto L21;
            if (r100.f248972r.isInProgress() == true) goto L21;
            float r101 = r111.getX() - r110.getX();
            float r114 = r111.getY() - r110.getY();
            if (Math.abs(r112) <= 800.0f) goto L19;
        L20:
            r100.f248986d.post(new e56.a(r100, System.currentTimeMillis(), r101 / 2.0f, r114 / 2.0f));
            r100.invalidate();
            return true;
        L19:
            if (Math.abs(r113) <= 800.0f) goto L21;
            goto L20
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            ImageViewTouch r104 = this.f248981a;
            if (r104.A == false) goto L25;
            if (r100 == null) goto L25;
            if (r101 == null) goto L25;
            if (r100.getPointerCount() > 1) goto L25;
            if (r101.getPointerCount() > 1) goto L25;
            if (r104.f248972r.isInProgress() == true) goto L25;
            float r105 = r104.getScale();
            if (Logger.debug() == false) goto L20;
            Logger.d("image", "onScroll: " + r102 + ", " + r103 + " " + r105);
        L20:
            if (r105 == 1.0f) goto L22;
        L24:
            r104.m(-r102, -r103);
            r104.invalidate();
            return true;
        L22:
            if (r104.f248994l == true) goto L24;
        L25:
            return false;
        }
    }

    public interface b {
    }

    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouch f248982a;

        public c(ImageViewTouch r100) {
            this.f248982a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            r100.getCurrentSpan();
            r100.getPreviousSpan();
            float r101 = this.f248982a.f248974t * r100.getScaleFactor();
            ImageViewTouch r102 = this.f248982a;
            if (r102.f248980z == false) goto L6;
            float r103 = Math.min(r102.getMaxZoom(), Math.max(r101, this.f248982a.getMinZoom() - 0.1f));
            this.f248982a.p(r103, r100.getFocusX(), r100.getFocusY());
            ImageViewTouch r104 = this.f248982a;
            r104.f248974t = Math.min(r104.getMaxZoom(), Math.max(r103, this.f248982a.getMinZoom() - 1.0f));
            ImageViewTouch r105 = this.f248982a;
            r105.f248976v = 1;
            r105.invalidate();
            return true;
        L6:
            return false;
        }
    }

    public void setDoubleTapListener(b r100) {
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new a(this);
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new c(this);
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void j() {
        float[] r100 = new float[9];
        this.f248985c.getValues(r100);
        this.f248974t = r100[0];
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void h() {
        super.h();
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f248977w = getGestureListener();
        this.f248978x = getScaleListener();
        this.f248972r = new ScaleGestureDetector(getContext().getApplicationContext(), this.f248978x);
        this.f248973s = new GestureDetector(getContext().getApplicationContext(), this.f248977w, null, true);
        this.f248974t = 1.0f;
        this.f248976v = 1;
    }

    public boolean getDoubleTapEnabled() {
        return this.f248979y;
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void k(float r100) {
        if (this.f248972r.isInProgress() == true) goto L6;
        this.f248974t = r100;
        return;
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void l(float r100) {
        if (this.f248972r.isInProgress() == true) goto L6;
        this.f248974t = r100;
    L6:
        if (r100 >= getMinZoom()) goto L9;
        q(getMinZoom(), getWidth() / 2.0f, getHeight() / 2.0f, 50.0f);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction() & 255;
        if (r101 != 0) goto L6;
        this.B = true;
    L6:
        if (r100.getPointerCount() <= 1) goto L8;
        this.B = false;
    L8:
        this.f248972r.onTouchEvent(r100);
        if (this.f248972r.isInProgress() == true) goto L11;
        this.f248973s.onTouchEvent(r100);
    L11:
        if (r101 == 0) goto L17;
        if (r101 == 1) goto L15;
    L18:
        return true;
    L15:
        if (getScale() >= getMinZoom()) goto L18;
        q(getMinZoom(), getWidth() / 2.0f, getHeight() / 2.0f, 50.0f);
        goto L18
    L17:
        this.f248999q = false;
        goto L18
    }

    public void setDoubleTapEnabled(boolean r100) {
        this.f248979y = r100;
    }

    public void setMyOnClickListener(View.OnClickListener r100) {
        this.C = r100;
    }

    public void setScaleEnabled(boolean r100) {
        this.f248980z = r100;
    }

    public void setScrollEnabled(boolean r100) {
        this.A = r100;
    }

    public ImageViewTouch(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248979y = true;
        this.f248980z = true;
        this.A = true;
        this.B = true;
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void a(Drawable r100, boolean r101, Matrix r102, float r103) {
        super.a(r100, r101, r102, r103);
        this.f248975u = getMaxZoom() / 3.0f;
    }
}
