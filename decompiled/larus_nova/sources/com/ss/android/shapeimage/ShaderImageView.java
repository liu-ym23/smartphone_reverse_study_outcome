package com.ss.android.shapeimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import dgc.d;
import dgc.f;
import egc.a;
import egc.b;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public abstract class ShaderImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f449568a;

    public abstract a a();

    public a getPathHelper() {
        if (this.f449568a != null) goto L6;
        this.f449568a = a();
    L6:
        return this.f449568a;
    }

    public float getBorderAlpha() {
        return getPathHelper().f472623d;
    }

    public int getBorderWidth() {
        return getPathHelper().f472622c;
    }

    public ShaderImageView(Context r100) {
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        b r101 = (b) getPathHelper();
        int r102 = r101.f472635p;
        if (r102 == (-1)) goto L18;
        Map<Integer, d> r103 = cgc.a.f23710a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        d r105 = (d) r104.get(Integer.valueOf(r102));
        if (r105 != null) goto L15;
        InputStream r106 = null;
        r106 = r100.getResources().openRawResource(r102);     // Catch: Throwable -> L11
        d r107 = f.b(r106);     // Catch: Throwable -> L11
        ConcurrentHashMap r108 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L11
        r108.put(Integer.valueOf(r102), r107);     // Catch: Throwable -> L11
        if (r106 != null) goto L21;
    L10:
        r105 = r107;
        goto L15
    L21:
        r106.close();     // Catch: Throwable -> L19
    L11:
        th = move-exception;
        if (r106 != null) goto L25;
    L14:
        throw th;
    L25:
        r106.close();     // Catch: Throwable -> L20
    L15:
        r101.f472634o = r105;
        return;
    L18:
        throw new RuntimeException("No resource is defined as shape");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        a r101 = getPathHelper();
        if (r101.f472627h != null) goto L12;
        Bitmap r102 = r101.a();
        if (r102 == null) goto L12;
        if (r102.getWidth() <= 0) goto L12;
        if (r102.getHeight() <= 0) goto L12;
        Shader.TileMode r103 = Shader.TileMode.CLAMP;
        BitmapShader r104 = new BitmapShader(r102, r103, r103);
        r101.f472627h = r104;
        r101.f472626g.setShader(r104);
    L12:
        if (r101.f472627h != null) goto L14;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == true) goto L22;
        super.onDraw(r100);
        return;
    L22:
        return;
    L14:
        if (r101.f472620a <= 0) goto L18;
        if (r101.f472621b <= 0) goto L18;
        Paint r106 = r101.f472626g;
        Paint r107 = r101.f472625f;
        b r108 = (b) r101;
        r100.save();
        r100.drawPath(r108.f472631l, r107);
        r100.concat(r108.f472629j);
        r100.drawPath(r108.f472630k, r106);
        r100.restore();
        r105 = true;
        goto L19
    }

    public void setBorderAlpha(float r100) {
        a r101 = getPathHelper();
        r101.f472623d = r100;
        Paint r102 = r101.f472625f;
        if (r102 == null) goto L5;
        r102.setAlpha(Float.valueOf(r100 * 255.0f).intValue());
    L5:
        invalidate();
    }

    public void setBorderColor(int r100) {
        Paint r101 = getPathHelper().f472625f;
        if (r101 == null) goto L5;
        r101.setColor(r100);
    L5:
        invalidate();
    }

    public void setBorderWidth(int r100) {
        a r101 = getPathHelper();
        r101.f472622c = r100;
        Paint r102 = r101.f472625f;
        if (r102 == null) goto L5;
        r102.setStrokeWidth(r100);
    L5:
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        getPathHelper().b(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        getPathHelper().b(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        getPathHelper().b(getDrawable());
    }

    public void setSquare(boolean r100) {
        getPathHelper().f472624e = r100;
        invalidate();
    }

    public ShaderImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getPathHelper().f472624e == false) goto L5;
        super.onMeasure(r100, r100);
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    public ShaderImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a r104 = getPathHelper();
        if (r104.f472620a == r100) goto L5;
    L7:
        r104.f472620a = r100;
        r104.f472621b = r101;
        if (r104.f472624e == false) goto L11;
        int r105 = Math.min(r100, r101);
        r104.f472621b = r105;
        r104.f472620a = r105;
    L11:
        if (r104.f472627h == null) goto L14;
        r104.a();
        return;
    L14:
        return;
    L5:
        if (r104.f472621b != r101) goto L7;
    }
}
