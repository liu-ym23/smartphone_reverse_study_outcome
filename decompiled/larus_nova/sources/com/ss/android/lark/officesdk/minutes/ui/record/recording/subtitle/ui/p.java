package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class p extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f436517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f436518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f436519c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f436519c.isEmpty() == true) goto L6;
        RectF r101 = this.f436519c;
        float r102 = this.f436517a;
        r100.drawRoundRect(r101, r102, r102, this.f436518b);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f436518b.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f436518b.setColorFilter(r100);
        invalidateSelf();
    }

    public p(int r100, float r101) {
        this.f436517a = r101;
        Paint r102 = new Paint(1);
        r102.setColor(r100);
        r102.setStyle(Paint.Style.FILL);
        this.f436518b = r102;
        this.f436519c = new RectF();
    }
}
