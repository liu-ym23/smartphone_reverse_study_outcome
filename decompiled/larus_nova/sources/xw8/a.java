package xw8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f565263c;

    /* JADX INFO: renamed from: xw8.a$a, reason: collision with other inner class name */
    public static final class C8279a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(getBounds(), this.f565263c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        this.f565263c.setShader(new LinearGradient(0.0f, r110.top, 0.0f, r110.bottom, new int[]{this.f565261a, this.f565262b}, new float[]{0.12201f, 0.26414f}, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f565263c.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f565263c.setColorFilter(r100);
        invalidateSelf();
    }

    public a(int r100, int r101) {
        this.f565261a = r100;
        this.f565262b = r101;
        this.f565263c = new Paint(1);
    }
}
