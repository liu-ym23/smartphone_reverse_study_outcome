package com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import bm5.a;
import n65.b;
import pl.droidsonroids.gif.GifImageView;
import s95.d;
import s95.e;
import s95.f;
import s95.g;
import s95.h;
import s95.i;
import s95.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class GifPhotoView extends GifImageView {
    public j b;
    public boolean c;

    public RectF getDisplayRect() {
        return this.b.c();
    }

    public Matrix getImageMatrix() {
        return this.b.l;
    }

    public float getMaximumScale() {
        return this.b.d;
    }

    public float getMinimumScale() {
        return this.b.c;
    }

    public float getScale() {
        return this.b.g();
    }

    public j getAttacher() {
        return this.b;
    }

    public GifPhotoView(Context r2) {
        this(r2, null);
    }

    public void setAllowParentInterceptOnEdge(boolean r2) {
        this.b.f = r2;
    }

    public void setDoubleTapScale(float r3) {
        j r0 = this.b;
        r0.e = Math.min(r3, r0.d);
    }

    public void setImageActionListener(b.a r2) {
        this.b.t = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r1) {
        super/*android.widget.ImageView*/.setImageBitmap(r1);
        j r2 = this.b;
        if (r2 == null) goto L6;
        r2.update();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageDrawable(Drawable r3) {
        super/*android.widget.ImageView*/.setImageDrawable(r3);
        j r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        if (r3 == null) goto L10;
        this.c = true;
        return;
    L10:
        return;
    L5:
        if (this.c == true) goto L7;
        r0.update();
        goto L7
    }

    public void setImageResource(int r1) {
        super.setImageResource(r1);
        j r2 = this.b;
        if (r2 == null) goto L6;
        r2.update();
        return;
    }

    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        j r2 = this.b;
        if (r2 == null) goto L6;
        r2.update();
        return;
    }

    public void setMaximumScale(float r2) {
        this.b.d = r2;
    }

    public void setMinimumScale(float r2) {
        this.b.c = r2;
    }

    public void setOnClickListener(View.OnClickListener r2) {
        this.b.q = r2;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r2) {
        this.b.i.setOnDoubleTapListener(r2);
    }

    public void setOnLongClickListener(View.OnLongClickListener r2) {
        this.b.r = r2;
    }

    public void setOnMatrixChangeListener(a r2) {
        this.b.p = r2;
    }

    public void setOnOutsidePhotoTapListener(d r1) {
        this.b.getClass();
    }

    public void setOnPhotoTapListener(e r1) {
        this.b.getClass();
    }

    public void setOnScaleChangeListener(f r1) {
        this.b.getClass();
    }

    public void setOnScaleEventListener(bm5.b r2) {
        this.b.s = r2;
    }

    public void setOnSingleFlingListener(g r1) {
        this.b.getClass();
    }

    public void setOnViewDragListener(h r1) {
        this.b.getClass();
    }

    public void setOnViewTapListener(i r1) {
        this.b.getClass();
    }

    public void setRotationBy(float r4) {
        j r0 = this.b;
        r0.m.postRotate(r4 % 360.0f);
        r0.a();
    }

    public void setRotationTo(float r4) {
        j r0 = this.b;
        r0.m.setRotate(r4 % 360.0f);
        r0.a();
    }

    public void setScale(float r3) {
        this.b.j(r3, true);
    }

    public void setZoomTransitionDuration(int r2) {
        this.b.b = r2;
    }

    public void setZoomable(boolean r2) {
        j r0 = this.b;
        r0.v = r2;
        r0.update();
    }

    public GifPhotoView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(float r2, boolean r3) {
        this.b.j(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifPhotoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new j(this);
        super/*android.widget.ImageView*/.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void i(float r3, float r4, float r5) {
        this.b.i(r3, r4, r5, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean setFrame(int r1, int r2, int r3, int r4) {
        boolean r5 = super/*android.widget.ImageView*/.setFrame(r1, r2, r3, r4);
        if (r5 == false) goto L5;
        this.b.update();
    L5:
        return r5;
    }
}
