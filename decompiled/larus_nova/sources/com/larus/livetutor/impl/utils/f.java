package com.larus.livetutor.impl.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f356672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f356673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f356674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Point f356675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f356676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f356677f;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = this.f356676e;
        if (r100 <= 0.0f) goto L5;
        r110.drawRoundRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, r100, r100, this.f356677f);
        return;
    L5:
        r110.drawRect(getBounds(), this.f356677f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        Paint r111 = this.f356677f;
        Point r100 = this.f356674c;
        float r101 = r100.x;
        float r102 = r100.y;
        Point r103 = this.f356675d;
        r111.setShader(new LinearGradient(r101, r102, r103.x, r103.y, this.f356672a, this.f356673b, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f356677f.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f356677f.setColorFilter(r100);
    }

    public f(int[] r110, float[] r111, Point r112, Point r113) {
        Intrinsics.checkNotNullParameter(r110, "colors");
        Intrinsics.checkNotNullParameter(r111, "positions");
        Intrinsics.checkNotNullParameter(r112, "startPoint");
        Intrinsics.checkNotNullParameter(r113, "endPoint");
        this.f356672a = r110;
        this.f356673b = r111;
        this.f356674c = r112;
        this.f356675d = r113;
        this.f356676e = 0;
        Paint r100 = new Paint(1);
        r100.setShader(new LinearGradient(r112.x, r112.y, r113.x, r113.y, r110, r111, Shader.TileMode.CLAMP));
        this.f356677f = r100;
    }
}
