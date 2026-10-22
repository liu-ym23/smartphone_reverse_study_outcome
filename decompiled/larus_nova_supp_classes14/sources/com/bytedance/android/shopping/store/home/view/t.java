package com.bytedance.android.shopping.store.home.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends Drawable {
    public final Paint a;
    public final int[] b;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public t(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "colorArray");
        this.b = r2;
        this.a = new Paint();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r3.drawRect(getBounds(), this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r11) {
        Intrinsics.checkNotNullParameter(r11, "bounds");
        super.onBoundsChange(r11);
        this.a.setShader(new LinearGradient(0.0f, 0.0f, r11.right - r11.left, 0.0f, this.b, null, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }
}
