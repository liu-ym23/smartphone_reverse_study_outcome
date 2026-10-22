package com.larus.bmhome.chat.referenceicon;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f308527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f308528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitmapShader f308529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f308530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f308531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f308532f;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.referenceicon.a$a, reason: collision with other inner class name */
    public static final class C4067a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    public a(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f308527a = RangesKt.coerceAtLeast(r100.getWidth(), 1);
        this.f308528b = RangesKt.coerceAtLeast(r100.getHeight(), 1);
        Shader.TileMode r101 = Shader.TileMode.CLAMP;
        BitmapShader r102 = new BitmapShader(r100, r101, r101);
        this.f308529c = r102;
        this.f308530d = new Matrix();
        Paint r103 = new Paint(1);
        r103.setShader(r102);
        this.f308531e = r103;
        this.f308532f = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = Math.min(this.f308532f.width(), this.f308532f.height()) * 0.2f;
        r100.drawRoundRect(this.f308532f, r101, r101, this.f308531e);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f308532f.set(r100);
        float r101 = Math.max(r100.width() / this.f308527a, r100.height() / this.f308528b);
        float r102 = r100.left + ((r100.width() - (this.f308527a * r101)) / 2.0f);
        float r103 = r100.top + ((r100.height() - (this.f308528b * r101)) / 2.0f);
        this.f308530d.setScale(r101, r101);
        this.f308530d.postTranslate(r102, r103);
        this.f308529c.setLocalMatrix(this.f308530d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f308531e.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f308531e.setColorFilter(r100);
        invalidateSelf();
    }
}
