package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes16.dex */
public class RoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f226535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f226536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f226537c;

    public RoundImageView(Context r100) {
        super(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Paint r101 = new Paint();
        this.f226535a = r101;
        r101.setDither(true);
        this.f226535a.setAntiAlias(true);
        if (getDrawable() != null) goto L5;
        return;
    L5:
        Drawable r102 = getDrawable();
    L11:
        e = move-exception;
        tt5.a.f("BitmapUtils", e, false);
        Bitmap r103 = null;
    L13:
        Shader.TileMode r104 = Shader.TileMode.CLAMP;
        BitmapShader r105 = new BitmapShader(r103, r104, r104);
        this.f226537c = (this.f226536b * 2.0f) / Math.min(r103.getHeight(), r103.getWidth());
        Matrix r106 = new Matrix();
        float r107 = this.f226537c;
        r106.setScale(r107, r107);
        r105.setLocalMatrix(r106);
        this.f226535a.setShader(r105);
        int r108 = this.f226536b;
        r100.drawCircle(r108, r108, r108, this.f226535a);
        return;
    L7:
        if ((r102 instanceof BitmapDrawable) == false) goto L9;
        r103 = ((BitmapDrawable) r102).getBitmap();     // Catch: Exception -> L11
    L15:
        goto L13
    L9:
        int r109 = r102.getIntrinsicWidth();     // Catch: Exception -> L11
        int r110 = r102.getIntrinsicHeight();     // Catch: Exception -> L11
        Bitmap r111 = Bitmap.createBitmap(r109, r110, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L11
        Canvas r112 = new Canvas(r111);     // Catch: Exception -> L11
        r102.setBounds(0, 0, r109, r110);     // Catch: Exception -> L11
        r102.draw(r112);     // Catch: Exception -> L11
        r103 = r111;
        goto L15
    }

    public RoundImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f226536b = Math.min(getMeasuredWidth(), getMeasuredHeight()) / 2;
    }

    public RoundImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
