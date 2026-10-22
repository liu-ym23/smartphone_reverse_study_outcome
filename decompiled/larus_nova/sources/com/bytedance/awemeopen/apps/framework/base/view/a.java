package com.bytedance.awemeopen.apps.framework.base.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f193228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f193229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f193231d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        if (this.f193230c == false) goto L5;
        int r101 = ColorUtils.setAlphaComponent(this.f193229b, 0);
    L6:
        int r102 = r101;
        if (this.f193230c == false) goto L9;
        int r103 = ColorUtils.setAlphaComponent(this.f193229b, 255);
    L10:
        int r104 = r103;
        if (this.f193230c == false) goto L13;
        int r105 = r100.bottom;
        float r106 = r105 - ((r105 - r100.top) * this.f193231d);
    L14:
        int r107 = r100.left;
        this.f193228a.setShader(new LinearGradient(r107, r106, r107, r100.bottom, r102, r104, Shader.TileMode.CLAMP));
        r110.drawRect(r100, this.f193228a);
        return;
    L13:
        r106 = r100.top;
        goto L14
    L9:
        r103 = this.f193229b;
        goto L10
    L5:
        r101 = this.f193229b;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f193228a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f193228a.setColorFilter(r100);
    }

    public a(int r100, float r101) {
        this.f193228a = new Paint();
        this.f193229b = r100;
        this.f193230c = true;
        this.f193231d = r101;
    }
}
