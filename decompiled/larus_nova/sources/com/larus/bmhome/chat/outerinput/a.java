package com.larus.bmhome.chat.outerinput;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f308418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f308419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f308420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f308421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f308422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f308423f;

    public a(int r100, int r101, float r102, float r103) {
        this.f308418a = r100;
        this.f308419b = r102;
        this.f308420c = r103;
        Paint r104 = new Paint(1);
        this.f308421d = r104;
        r104.setColor(r101);
        r104.setStrokeWidth(r102);
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter(r107, "text");
        boolean r109 = true;
        if (r108 > 0) goto L6;
        if (r110 < 0) goto L6;
        boolean r112 = true;
    L7:
        if (r112 == false) goto L9;
        float r113 = r101.measureText(r107, r108, 0);
    L10:
        this.f308422e = r113;
        if (r108 > 0) goto L14;
        if (r110 < 0) goto L14;
    L15:
        if (r109 == false) goto L17;
        float r114 = r101.measureText(r107, 0, Math.min(this.f308418a, r110));
    L18:
        this.f308423f = r113 + r114;
        float r115 = RangesKt.coerceAtMost(r105 + this.f308420c, r106 - this.f308419b);
        r100.drawLine(this.f308422e, r115, this.f308423f, r115, this.f308421d);
        return;
    L17:
        r114 = r101.measureText(r107, r108, Math.min(this.f308418a, r110));
    L14:
        r109 = false;
        goto L15
    L9:
        r113 = 0.0f;
    L6:
        r112 = false;
        goto L7
    }
}
