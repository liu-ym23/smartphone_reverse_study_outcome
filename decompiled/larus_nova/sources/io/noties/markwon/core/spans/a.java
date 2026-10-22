package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f492301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f492302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Float f492303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f492304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f492305l;

    @Override // io.noties.markwon.core.spans.r, android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        Integer r101 = this.f492304k;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        return r102 + (this.f492302i * 2);
    L5:
        r102 = 0;
        goto L7
    }

    public a(msc.s r100, String r101, int r102, int r103, Float r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "orderNumber");
        super(r100, r101);
        this.f492301h = r102;
        this.f492302i = r103;
        this.f492303j = r104;
        this.f492304k = r105;
        this.f492305l = new Paint(1);
    }

    @Override // io.noties.markwon.core.spans.r, android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        if (r111 == true) goto L4;
        return;
    L4:
        if (ftc.c.a(r108, r107, this) == false) goto L28;
        this.f492365c.set(r101);
        this.f492363a.b(this.f492365c, true);
        String r109 = this.f492364b;
        String r113 = r109.substring(0, r109.length() - 1);
        int r114 = (int) (this.f492365c.measureText(this.f492364b) + 0.5f);
        int r115 = (int) (this.f492365c.measureText(r113) + 0.5f);
        Rect r116 = new Rect();
        if (r101 == null) goto L9;
        r101.getTextBounds(r113, 0, r113.length(), r116);
    L9:
        float r117 = r116.height() + 0.5f;
        if (r114 <= this.f492363a.f515543c) goto L12;
        this.f492366d = r114;
    L13:
        this.f492305l.setColor(this.f492301h);
        this.f492305l.setStyle(Paint.Style.FILL);
        float r118 = r105;
        int r119 = this.f492302i;
        float r120 = 0.0f;
        RectF r121 = new RectF(0.0f, (r118 - r117) - r119, r115 + (r119 * 2), r119 + r118);
        if (r100 == null) goto L23;
        Float r122 = this.f492303j;
        if (r122 == null) goto L18;
        float r123 = r122.floatValue();
    L19:
        Float r124 = this.f492303j;
        if (r124 == null) goto L22;
        r120 = r124.floatValue();
    L22:
        r100.drawRoundRect(r121, r123, r120, this.f492305l);
        goto L23
    L18:
        r123 = 0.0f;
    L23:
        if (r100 == null) goto L27;
        r100.drawText(this.f492364b, this.f492302i, r118, this.f492365c);
        return;
    L27:
        return;
    L12:
        this.f492366d = 0;
        goto L13
    }
}
