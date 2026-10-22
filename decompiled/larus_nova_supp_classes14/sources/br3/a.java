package br3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends Drawable {
    public final Paint a;
    public Rect b;
    public final int[] c;
    public final float[] d;

    /* JADX INFO: renamed from: br3.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        Rect r0 = getBounds();
        if (Intrinsics.areEqual(r0, this.b) == true) goto L6;
        Paint r1 = this.a;
        float r5 = r0.left;
        r1.setShader(new LinearGradient(r5, r0.top, r5, r0.bottom, this.c, this.d, Shader.TileMode.CLAMP));
        this.b = r0;
    L6:
        r12.drawRect(getBounds(), this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    public a(int[] r2, float[] r3) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.c = r2;
        this.d = r3;
        this.a = new Paint(1);
    }
}
