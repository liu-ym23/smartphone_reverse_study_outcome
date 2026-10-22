package com.bytedance.awemeopen.apps.framework.base.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends Drawable {
    public final Paint a;
    public int b;
    public boolean c;
    public final float d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r11) {
        Rect r0 = getBounds();
        if (this.c == false) goto L5;
        int r1 = ColorUtils.setAlphaComponent(this.b, 0);
    L6:
        int r7 = r1;
        if (this.c == false) goto L9;
        int r2 = ColorUtils.setAlphaComponent(this.b, 255);
    L10:
        int r8 = r2;
        if (this.c == false) goto L13;
        int r3 = r0.bottom;
        float r4 = r3 - ((r3 - r0.top) * this.d);
    L14:
        int r5 = r0.left;
        this.a.setShader(new LinearGradient(r5, r4, r5, r0.bottom, r7, r8, Shader.TileMode.CLAMP));
        r11.drawRect(r0, this.a);
        return;
    L13:
        r4 = r0.top;
        goto L14
    L9:
        r2 = this.b;
        goto L10
    L5:
        r1 = this.b;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    public a(int r2, float r3) {
        this.a = new Paint();
        this.b = r2;
        this.c = true;
        this.d = r3;
    }
}
