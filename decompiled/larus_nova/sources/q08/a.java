package q08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements p08.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f531196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f531197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f531198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextPaint f531199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextPaint f531200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f531201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f531202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f531203i;

    @Override // p08.a
    public final int b() {
        return this.f531195a;
    }

    @Override // p08.a
    public final void c(float r100) {
        this.f531196b = r100;
        this.f531198d.setTextSize(r100);
        this.f531199e.setTextSize(r100);
        this.f531200f.setTextSize(r100);
        this.f531201g.setTextSize(r100);
    }

    public final float d(TextPaint r100) {
        Paint.FontMetrics r101 = r100.getFontMetrics();
        float r102 = this.f531195a / 2;
        float r103 = r101.descent;
        return (r102 + ((r103 - r101.ascent) / 2)) - r103;
    }

    @Override // p08.a
    public final void setTypeFace(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        this.f531198d.setTypeface(r100);
        this.f531199e.setTypeface(r100);
        this.f531200f.setTypeface(r100);
        this.f531201g.setTypeface(r100);
    }

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f531195a = r101;
        this.f531196b = d.a(r100, 16.0f);
        TextPaint r102 = new TextPaint();
        this.f531198d = r102;
        TextPaint r103 = new TextPaint();
        this.f531199e = r103;
        TextPaint r104 = new TextPaint();
        this.f531200f = r104;
        TextPaint r105 = new TextPaint();
        this.f531201g = r105;
        Paint r106 = new Paint();
        this.f531202h = r106;
        Paint r107 = new Paint();
        this.f531203i = r107;
        this.f531197c = (int) d.a(r100, 16.0f);
        d.a(r100, 6.0f);
        d.a(r100, 6.0f);
        r102.setTextSize(this.f531196b);
        r102.setTextAlign(Paint.Align.CENTER);
        r102.setColor(r100.getResources().getColor(R.color.text_title));
        r102.setAntiAlias(true);
        r103.setTextSize(this.f531196b);
        r103.setTextAlign(Paint.Align.CENTER);
        r103.setColor(r100.getResources().getColor(R.color.text_placeholder));
        r103.setAntiAlias(true);
        r104.setTextSize(this.f531196b);
        r104.setTextAlign(Paint.Align.CENTER);
        r104.setColor(r100.getResources().getColor(R.color.primary_on_primary_fill));
        r104.setAntiAlias(true);
        r105.setTextSize(this.f531196b);
        r105.setTextAlign(Paint.Align.CENTER);
        r105.setColor(r100.getResources().getColor(R.color.primary_content_default));
        r105.setAntiAlias(true);
        r106.setStyle(Paint.Style.FILL);
        r106.setColor(r100.getResources().getColor(R.color.primary_fill_default));
        r106.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        r107.setColor(r100.getResources().getColor(R.color.line_border_card));
        r107.setAntiAlias(true);
    }

    @Override // p08.a
    public final void a(Canvas r100, n08.a r101) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "baseDay");
        int r102 = r100.save();
        int r103 = r100.getWidth() / 7;
        r100.translate((r101.f516607b * r103) + (r103 / 2), r101.f516606a * this.f531195a);
        CalendarAttr r104 = r101.f516609d;
        CalendarAttr.MonthState r105 = r104.f284798c;
        CalendarAttr.SelectState r106 = r104.f284796a;
        CalendarAttr.DateState r107 = r104.f284797b;
        String r108 = String.valueOf(r101.f516608c.getMonthDay());
        if (r105 != CalendarAttr.MonthState.CURRENT_MONTH) goto L15;
        float r109 = this.f531195a / 2;
        if (r106 != CalendarAttr.SelectState.SELECT) goto L11;
        if (r107 != CalendarAttr.DateState.CURRENT_DATE) goto L9;
        r100.drawCircle(0.0f, r109, this.f531197c, this.f531202h);
        r100.drawText(r108, 0.0f, d(this.f531200f), this.f531200f);
    L18:
        r100.restoreToCount(r102);
        return;
    L9:
        r100.drawCircle(0.0f, r109, this.f531197c, this.f531203i);
        r100.drawText(r108, 0.0f, d(this.f531198d), this.f531198d);
        goto L18
    L11:
        if (r107 != CalendarAttr.DateState.CURRENT_DATE) goto L13;
        r100.drawText(r108, 0.0f, d(this.f531201g), this.f531201g);
        goto L18
    L13:
        r100.drawText(r108, 0.0f, d(this.f531198d), this.f531198d);
        goto L18
    L15:
        if (r107 != CalendarAttr.DateState.CURRENT_DATE) goto L17;
        r100.drawText(r108, 0.0f, d(this.f531201g), this.f531201g);
        goto L18
    L17:
        r100.drawText(r108, 0.0f, d(this.f531199e), this.f531199e);
        goto L18
    }
}
