package o29;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f521792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f521793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f521794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f521795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f521796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f521797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f521798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f521799h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f521795d == null) goto L5;
        RectF r101 = this.f521799h;
        float r102 = this.f521793b;
        r100.drawRoundRect(r101, r102, r102, this.f521798g);
    L5:
        RectF r103 = this.f521799h;
        float r104 = this.f521793b;
        r100.drawRoundRect(r103, r104, r104, this.f521797f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        RectF r100 = this.f521799h;
        float r101 = r110.left;
        float r102 = this.f521792a;
        r100.set(r101 + (r102 / 2.0f), r110.top + (r102 / 2.0f), r110.right - (r102 / 2.0f), r110.bottom - (r102 / 2.0f));
        double r103 = Math.toRadians(this.f521796e);
        float r111 = (float) Math.cos(r103);
        float r104 = (float) Math.sin(r103);
        float r105 = this.f521799h.centerX();
        float r106 = this.f521799h.centerY();
        float r112 = r111 * (this.f521799h.width() / 2.0f);
        float r107 = r105 - r112;
        float r108 = r104 * (this.f521799h.height() / 2.0f);
        float r109 = r106 - r108;
        float r113 = r112 + r105;
        float r114 = r108 + r106;
        this.f521797f.setShader(new LinearGradient(r107, r109, r113, r114, this.f521794c, null, Shader.TileMode.CLAMP));
        if (this.f521795d == null) goto L6;
        this.f521798g.setShader(new LinearGradient(r107, r109, r113, r114, this.f521795d, null, Shader.TileMode.CLAMP));
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f521797f.setAlpha(r100);
        this.f521798g.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f521797f.setColorFilter(r100);
        this.f521798g.setColorFilter(r100);
        invalidateSelf();
    }

    public a(float r100, float r101, int[] r102, int[] r103) {
        Intrinsics.checkNotNullParameter(r102, "borderColorList");
        this.f521792a = r100;
        this.f521793b = r101;
        this.f521794c = r102;
        this.f521795d = r103;
        this.f521796e = 0.0f;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r100);
        r104.setDither(true);
        r104.setFilterBitmap(true);
        r104.setStrokeJoin(Paint.Join.ROUND);
        r104.setStrokeCap(Paint.Cap.ROUND);
        this.f521797f = r104;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        r105.setDither(true);
        r105.setFilterBitmap(true);
        r105.setStrokeJoin(Paint.Join.ROUND);
        r105.setStrokeCap(Paint.Cap.ROUND);
        this.f521798g = r105;
        this.f521799h = new RectF();
    }
}
