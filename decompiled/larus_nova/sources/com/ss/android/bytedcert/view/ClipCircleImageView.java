package com.ss.android.bytedcert.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class ClipCircleImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f407735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f407736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f407737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f407738d;

    @Override // android.widget.ImageView
    public Drawable getDrawable() {
        Drawable r100 = super.getDrawable();
        if ((r100 instanceof BitmapDrawable) == false) goto L10;
        Bitmap r101 = ((BitmapDrawable) r100).getBitmap();
        if (r101 == null) goto L10;
        int r102 = getWidth();
        int r103 = getHeight();
        float r104 = r102;
        float r105 = r101.getWidth();
        float r106 = (r104 * 1.0f) / r105;
        float r107 = r103;
        float r108 = r101.getHeight();
        float r109 = (1.0f * r107) / r108;
        if (r106 > r109) goto L9;
        float r110 = r108 * r106;
        int r111 = (int) ((r107 - r110) / 2.0f);
        r100.setBounds(0, r111, (int) (r105 * r106), (int) (r111 + r110));
        goto L10
    L9:
        float r112 = r105 * r109;
        int r113 = (int) ((r104 - r112) / 2.0f);
        r100.setBounds(r113, 0, (int) (r113 + r112), (int) (r108 * r109));
    L10:
        return r100;
    }

    public ClipCircleImageView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        float r101 = getWidth() / 2.0f;
        boolean r102 = true;
        if (this.f407737c == r101) goto L5;
        this.f407737c = r101;
        boolean r103 = true;
    L6:
        float r104 = getHeight() / 2.0f;
        if (this.f407738d == r104) goto L9;
        this.f407738d = r104;
        r103 = true;
    L9:
        float r105 = i.d(getContext());
        if (this.f407736b == r105) goto L12;
        this.f407736b = r105;
    L13:
        if (r102 == false) goto L16;
        this.f407735a.reset();
        this.f407735a.addCircle(this.f407737c, this.f407738d, this.f407736b, Path.Direction.CW);
        return;
    L16:
        return;
    L12:
        r102 = r103;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Drawable r101 = getDrawable();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.getSaveCount();
        r100.save();
        r100.clipPath(this.f407735a);
        r101.draw(r100);
        r100.restoreToCount(r102);
    }

    public ClipCircleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        float r102 = getMeasuredWidth() / 2.0f;
        float r103 = getMeasuredHeight() / 2.0f;
        this.f407735a.reset();
        this.f407735a.addCircle(r102, r103, this.f407736b, Path.Direction.CW);
    }

    public ClipCircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407735a = new Path();
        this.f407736b = i.d(getContext());
    }
}
