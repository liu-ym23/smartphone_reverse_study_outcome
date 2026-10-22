package com.larus.business.markdown.impl.markwon.custom.title;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;
import msc.s;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f320674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f320675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f320677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f320678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f320679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f320680g;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return this.f320674a.f515557q;
    }

    public d(s r100, float r101, int r102, Integer r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        this.f320674a = r100;
        this.f320675b = r101;
        this.f320676c = r102;
        this.f320677d = r103;
        this.f320678e = r104;
        new Rect();
        this.f320679f = new Paint(1);
        this.f320680g = new Paint(1);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r110, int r111, int r112, boolean r113, Layout r114) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r114, "layout");
        if (r111 != r112) goto L5;
        return;
    L5:
        this.f320679f.setStyle(Paint.Style.FILL);
        int r107 = r114.getWidth();
        if (r103 <= 0) goto L8;
        r102 = r107;
        int r108 = r102;
    L9:
        int r109 = com.larus.business.markdown.impl.common.utils.d.a(Double.valueOf(0.5d));
        Integer r115 = this.f320677d;
        if (r115 != null) goto L13;
        return;
    L13:
        if (r111 != r115.intValue()) goto L16;
        Path r116 = new Path();
        float r117 = r102 - r108;
        int r118 = r106 - r104;
        float r119 = this.f320675b;
        float r120 = r108;
        r116.moveTo(r120 + r119, r104);
        float r121 = r117 - (2 * r119);
        r116.rLineTo(r121, 0.0f);
        r116.rQuadTo(r119, 0.0f, r119, r119);
        float r122 = r118 - r119;
        r116.rLineTo(0.0f, r122);
        r116.rLineTo(-r117, 0.0f);
        float r123 = -r122;
        r116.rLineTo(0.0f, r123);
        float r124 = -r119;
        r116.rQuadTo(0.0f, r124, r119, r124);
        r116.close();
        this.f320679f.setColor(this.f320676c);
        r100.drawPath(r116, this.f320679f);
        Path r125 = new Path();
        this.f320680g.setColor(this.f320678e);
        this.f320680g.setStyle(Paint.Style.STROKE);
        this.f320680g.setStrokeWidth(r109);
        r125.moveTo(r120, r106);
        r125.rLineTo(0.0f, r123);
        r125.rQuadTo(0.0f, r124, r119, r124);
        r125.rLineTo(r121, 0.0f);
        r125.rQuadTo(r119, 0.0f, r119, r119);
        r125.rLineTo(0.0f, r122);
        r100.drawPath(r125, this.f320680g);
        return;
    L16:
        return;
    L8:
        r108 = r102 - r107;
        goto L9
    }
}
