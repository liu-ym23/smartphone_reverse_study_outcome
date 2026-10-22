package psc;

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

/* JADX INFO: loaded from: classes41.dex */
public final class a extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f530580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.business.markdown.impl.markwon.core.spans.codeblock.c f530581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f530582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f530583d;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return this.f530580a.f515557q;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        this.f530580a.a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        this.f530580a.a(r100);
    }

    public a(s r100, com.larus.business.markdown.impl.markwon.core.spans.codeblock.c r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f530580a = r100;
        this.f530581b = r101;
        this.f530582c = new Rect();
        this.f530583d = new Paint(1);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r110, CharSequence r111, int r112, int r113, boolean r114, Layout r115) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r115, "layout");
        int r106 = r115.getWidth();
        if (r103 <= 0) goto L5;
        int r107 = r102;
        r102 = r106;
    L7:
        if (this.f530581b.f320626g == false) goto L28;
        this.f530583d.setStyle(Paint.Style.FILL);
        Paint r108 = this.f530583d;
        s r116 = this.f530580a;
        int r109 = r116.f515556p;
        if (r109 != 0) goto L12;
        r109 = r116.f515555o;
    L12:
        if (r109 != 0) goto L15;
        r109 = ftc.a.a(r101.getColor(), 25);
    L15:
        r108.setColor(r109);
        Integer r117 = this.f530581b.f320620a;
        if (r117 != null) goto L19;
    L21:
        Integer r118 = this.f530581b.f320621b;
        if (r118 != null) goto L25;
    L27:
        this.f530582c.set(r107, r104, r102, r110);
        r100.drawRect(this.f530582c, this.f530583d);
        goto L28
    L25:
        if (r113 != r118.intValue()) goto L27;
        Path r119 = new Path();
        float r120 = r102 - r107;
        float r121 = this.f530581b.f320623d;
        r119.moveTo(r107, r104);
        r119.rLineTo(r120, 0.0f);
        float r122 = (r110 - r104) - r121;
        r119.rLineTo(0.0f, r122);
        float r123 = -r121;
        r119.rQuadTo(0.0f, r121, r123, r121);
        r119.rLineTo(-(r120 - (2 * r121)), 0.0f);
        r119.rQuadTo(r123, 0.0f, r123, r123);
        r119.rLineTo(0.0f, -r122);
        r119.close();
        r100.drawPath(r119, this.f530583d);
        goto L28
    L19:
        if (r112 != r117.intValue()) goto L21;
        Path r124 = new Path();
        float r125 = r102 - r107;
        float r126 = this.f530581b.f320623d;
        r124.moveTo(r107 + r126, r104);
        r124.rLineTo(r125 - (2 * r126), 0.0f);
        r124.rQuadTo(r126, 0.0f, r126, r126);
        float r127 = (r110 - r104) - r126;
        r124.rLineTo(0.0f, r127);
        r124.rLineTo(-r125, 0.0f);
        r124.rLineTo(0.0f, -r127);
        float r128 = -r126;
        r124.rQuadTo(0.0f, r128, r126, r128);
        r124.close();
        this.f530583d.setColor(this.f530581b.f320622c);
        r100.drawPath(r124, this.f530583d);
    L28:
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.c r129 = this.f530581b;
        if (r129.f320625f != 0) goto L31;
        return;
    L31:
        if (r129.f320624e != 0.0f) goto L33;
        boolean r130 = true;
    L34:
        if (r130 == true) goto L50;
        this.f530583d.setStyle(Paint.Style.STROKE);
        this.f530583d.setStrokeWidth(this.f530581b.f320624e);
        this.f530583d.setColor(this.f530581b.f320625f);
        Integer r131 = this.f530581b.f320620a;
        if (r131 != null) goto L39;
    L41:
        Integer r132 = this.f530581b.f320621b;
        if (r132 != null) goto L45;
    L47:
        float r133 = r107;
        float r134 = r104;
        float r135 = r110;
        r100.drawLine(r133, r134, r133, r135, this.f530583d);
        float r136 = r102;
        r100.drawLine(r136, r134, r136, r135, this.f530583d);
        return;
    L45:
        if (r113 != r132.intValue()) goto L47;
        Path r137 = new Path();
        float r138 = r102 - r107;
        float r139 = this.f530581b.f320623d;
        r137.moveTo(r107, r104);
        float r140 = (r110 - r104) - r139;
        r137.rLineTo(0.0f, r140);
        r137.rQuadTo(0.0f, r139, r139, r139);
        r137.rLineTo(r138 - (2 * r139), 0.0f);
        r137.rQuadTo(r139, 0.0f, r139, -r139);
        r137.rLineTo(0.0f, -r140);
        r100.drawPath(r137, this.f530583d);
        return;
    L39:
        if (r112 != r131.intValue()) goto L41;
        Path r141 = new Path();
        float r142 = r102 - r107;
        float r143 = this.f530581b.f320623d;
        r141.moveTo(r107, r110);
        float r144 = (r110 - r104) - r143;
        r141.rLineTo(0.0f, -r144);
        float r145 = -r143;
        r141.rQuadTo(0.0f, r145, r143, r145);
        r141.rLineTo(r142 - (2 * r143), 0.0f);
        r141.rQuadTo(r143, 0.0f, r143, r143);
        r141.rLineTo(0.0f, r144);
        r100.drawPath(r141, this.f530583d);
        return;
    L50:
        return;
    L33:
        r130 = false;
        goto L34
    L5:
        r107 = r102 - r106;
        goto L7
    }
}
