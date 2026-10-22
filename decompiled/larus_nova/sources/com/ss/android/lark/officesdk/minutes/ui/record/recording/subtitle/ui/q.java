package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class q implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f436520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f436521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f436522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f436523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f436524e;

    public q(int r100, float r101, float r102, float r103) {
        this.f436520a = r101;
        this.f436521b = r102;
        this.f436522c = r103;
        Paint r104 = new Paint(1);
        r104.setColor(r100);
        r104.setStyle(Paint.Style.FILL);
        this.f436523d = r104;
        this.f436524e = new RectF();
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter(r107, "text");
        if ((r107 instanceof Spanned) == false) goto L5;
        Spanned r109 = (Spanned) r107;
    L6:
        if (r109 != null) goto L8;
        return;
    L8:
        int r112 = Math.max(r109.getSpanStart(this), r108);
        int r113 = Math.min(r109.getSpanEnd(this), r110);
        if (r112 < r113) goto L11;
        return;
    L11:
        if (r112 <= r108) goto L13;
        float r114 = r101.measureText(r107, r108, r112);
    L14:
        float r115 = r102 + r114;
        float r116 = r115 - this.f436520a;
        float r117 = (r115 + r101.measureText(r107, r112, r113)) + this.f436520a;
        RectF r118 = this.f436524e;
        float r119 = r104;
        float r120 = this.f436521b;
        r118.set(r116, r119 - r120, r117, r106 + r120);
        RectF r121 = this.f436524e;
        float r122 = this.f436522c;
        r100.drawRoundRect(r121, r122, r122, this.f436523d);
        return;
    L13:
        r114 = 0.0f;
        goto L14
    L5:
        r109 = null;
        goto L6
    }
}
