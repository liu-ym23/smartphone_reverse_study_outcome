package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes19.dex */
public class RotateImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f248969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f248970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f248971f;

    public Bitmap getCurrentRotateBitmap() {
        Matrix r100 = new Matrix();
        float r101 = getScale();
        this.f248970e = r101;
        r100.postScale(r101, r101);
        float r102 = this.f248968c;
        float r103 = this.f248970e;
        r100.postTranslate((this.f248966a - ((int) (r102 * r103))) / 2.0f, (this.f248967b - ((int) (this.f248969d * r103))) / 2.0f);
        r100.postRotate(0, this.f248966a / 2, this.f248967b / 2);
        Bitmap r104 = this.f248971f;
        return Bitmap.createBitmap(r104, 0, 0, r104.getWidth(), this.f248971f.getHeight(), r100, true);
    }

    public Rect getRotateImageRect() {
        Rect r100 = new Rect();
        float r101 = getScale();
        this.f248970e = r101;
        int r102 = (int) (this.f248968c * r101);
        int r103 = (int) (this.f248969d * r101);
        int r104 = this.f248966a;
        r100.left = (r104 - r102) / 2;
        int r105 = this.f248967b;
        r100.top = (r105 - r103) / 2;
        r100.right = (r104 + r102) / 2;
        r100.bottom = (r105 + r103) / 2;
        return r100;
    }

    public float getScale() {
        int r100 = this.f248968c;
        int r101 = this.f248969d;
        int r102 = this.f248966a;
        float r103 = 1.0f;
        if (r100 <= r102) goto L5;
        float r104 = (r102 * 1.0f) / r100;
    L6:
        int r105 = this.f248967b;
        if (r101 <= r105) goto L10;
        r103 = (r105 * 1.0f) / r101;
    L10:
        if (r104 > r103) goto L12;
        return r104;
    L12:
        return r103;
    L5:
        r104 = 1.0f;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        if (r100 == null) goto L5;
        this.f248968c = r100.getWidth();
        this.f248969d = r100.getHeight();
    L5:
        this.f248971f = r100;
    }

    public RotateImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = r103 - r101;
        this.f248966a = r105;
        int r106 = r104 - r102;
        this.f248967b = r106;
        if ((((r105 * r106) * this.f248969d) * this.f248968c) == 0) goto L7;
        Matrix r107 = new Matrix();
        float r108 = getScale();
        this.f248970e = r108;
        r107.postScale(r108, r108);
        float r109 = this.f248968c;
        float r110 = this.f248970e;
        r107.postTranslate((this.f248966a - ((int) (r109 * r110))) / 2.0f, (this.f248967b - ((int) (this.f248969d * r110))) / 2.0f);
        r107.postRotate(0, this.f248966a / 2, this.f248967b / 2);
        setImageMatrix(r107);
        return;
    }
}
