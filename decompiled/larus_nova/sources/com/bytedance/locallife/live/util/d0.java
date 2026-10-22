package com.bytedance.locallife.live.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d0 extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f260696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f260697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f260698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f260699d;

    public d0(float r100, int r101, int r102) {
        this.f260696a = -1;
        this.f260697b = r100;
        this.f260698c = r101;
        this.f260699d = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 == null) goto L5;
        CharSequence r105 = r101.subSequence(r102, r103);
    L7:
        return (int) (this.f260698c + r100.measureText(String.valueOf(r105)));
    L5:
        r105 = null;
        goto L7
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r117, "paint");
        r117.setColor(this.f260696a);
        r117.setTextSize(this.f260697b);
        r100.drawText(r110, r111, r112, r113 + this.f260698c, r115 - this.f260699d, r117);
    }
}
