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

/* JADX INFO: loaded from: classes16.dex */
public class GifPhotoView extends GifImageView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f225035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f225036c;

    public RectF getDisplayRect() {
        return this.f225035b.c();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f225035b.f541089l;
    }

    public float getMaximumScale() {
        return this.f225035b.f541081d;
    }

    public float getMinimumScale() {
        return this.f225035b.f541080c;
    }

    public float getScale() {
        return this.f225035b.g();
    }

    public j getAttacher() {
        return this.f225035b;
    }

    public GifPhotoView(Context r100) {
        this(r100, null);
    }

    public void setAllowParentInterceptOnEdge(boolean r100) {
        this.f225035b.f541083f = r100;
    }

    public void setDoubleTapScale(float r100) {
        j r101 = this.f225035b;
        r101.f541082e = Math.min(r100, r101.f541081d);
    }

    public void setImageActionListener(b.a r100) {
        this.f225035b.f541097t = r100;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        j r101 = this.f225035b;
        if (r101 == null) goto L6;
        r101.update();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        j r101 = this.f225035b;
        if (r101 != null) goto L5;
    L7:
        if (r100 == null) goto L10;
        this.f225036c = true;
        return;
    L10:
        return;
    L5:
        if (this.f225036c == true) goto L7;
        r101.update();
        goto L7
    }

    @Override // pl.droidsonroids.gif.GifImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        j r101 = this.f225035b;
        if (r101 == null) goto L6;
        r101.update();
        return;
    }

    @Override // pl.droidsonroids.gif.GifImageView, android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        j r101 = this.f225035b;
        if (r101 == null) goto L6;
        r101.update();
        return;
    }

    public void setMaximumScale(float r100) {
        this.f225035b.f541081d = r100;
    }

    public void setMinimumScale(float r100) {
        this.f225035b.f541080c = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f225035b.f541094q = r100;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r100) {
        this.f225035b.f541086i.setOnDoubleTapListener(r100);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f225035b.f541095r = r100;
    }

    public void setOnMatrixChangeListener(a r100) {
        this.f225035b.f541093p = r100;
    }

    public void setOnOutsidePhotoTapListener(d r100) {
        this.f225035b.getClass();
    }

    public void setOnPhotoTapListener(e r100) {
        this.f225035b.getClass();
    }

    public void setOnScaleChangeListener(f r100) {
        this.f225035b.getClass();
    }

    public void setOnScaleEventListener(bm5.b r100) {
        this.f225035b.f541096s = r100;
    }

    public void setOnSingleFlingListener(g r100) {
        this.f225035b.getClass();
    }

    public void setOnViewDragListener(h r100) {
        this.f225035b.getClass();
    }

    public void setOnViewTapListener(i r100) {
        this.f225035b.getClass();
    }

    public void setRotationBy(float r100) {
        j r101 = this.f225035b;
        r101.f541090m.postRotate(r100 % 360.0f);
        r101.a();
    }

    public void setRotationTo(float r100) {
        j r101 = this.f225035b;
        r101.f541090m.setRotate(r100 % 360.0f);
        r101.a();
    }

    public void setScale(float r100) {
        this.f225035b.j(r100, true);
    }

    public void setZoomTransitionDuration(int r100) {
        this.f225035b.f541079b = r100;
    }

    public void setZoomable(boolean r100) {
        j r101 = this.f225035b;
        r101.f541099v = r100;
        r101.update();
    }

    public GifPhotoView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(float r100, boolean r101) {
        this.f225035b.j(r100, r101);
    }

    public GifPhotoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225035b = new j(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void i(float r100, float r101, float r102) {
        this.f225035b.i(r100, r101, r102, true);
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int r100, int r101, int r102, int r103) {
        boolean r104 = super.setFrame(r100, r101, r102, r103);
        if (r104 == false) goto L5;
        this.f225035b.update();
    L5:
        return r104;
    }
}
