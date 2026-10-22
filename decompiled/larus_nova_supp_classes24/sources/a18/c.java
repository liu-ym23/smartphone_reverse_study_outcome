package a18;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class c extends Drawable {
    public final z08.b a;
    public final Paint b;
    public int c;
    public final Rect d;

    public abstract void a(Canvas r1);

    public abstract void b(Canvas r1, Paint r2, float r3, int r4);

    public abstract void c(Canvas r1, Paint r2, int r3);

    public abstract int d();

    public abstract int e();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.c;
    }

    public c(z08.b r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        this.a = r2;
        this.b = new Paint();
        this.c = 255;
        this.d = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r5.getClipBounds(this.d) == false) goto L13;
        r5.save();
        a(r5);
        int r0 = this.a.c;
        c(r5, this.b, ColorUtils.setAlphaComponent(r0, (Color.alpha(r0) * this.c) / 255));
        int r1 = this.a.d;
        b(r5, this.b, this.a.f / 100.0f, ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * this.c) / 255));
        r5.restore();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
        this.c = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.b.setColorFilter(r2);
        invalidateSelf();
    }
}
