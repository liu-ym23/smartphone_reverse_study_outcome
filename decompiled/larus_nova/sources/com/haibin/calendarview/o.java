package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public final class o extends YearView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f276213t;

    @Override // com.haibin.calendarview.YearView
    public final void c() {
    }

    @Override // com.haibin.calendarview.YearView
    public final void d() {
    }

    public o(Context r100) {
        super(r100);
        this.f276213t = f.a(r100, 3.0f);
    }

    @Override // com.haibin.calendarview.YearView
    public final void b(Canvas r100, int r101, int r102, int r103) {
        r100.drawText(getContext().getResources().getStringArray(R.array.month_string_array)[r101 - 1], (r102 + (this.f276129l / 2)) - this.f276213t, r103 + this.f276131n, this.f276125h);
    }

    @Override // com.haibin.calendarview.YearView
    public final void f(Canvas r100, int r101, int r102, int r103, int r104) {
        r100.drawText(getContext().getResources().getStringArray(R.array.year_view_week_string_array)[r101], r102 + (r104 / 2), r103 + this.f276132o, this.f276126i);
    }

    @Override // com.haibin.calendarview.YearView
    public final void e(Canvas r100, Calendar r101, int r102, int r103, boolean r104, boolean r105) {
        float r106 = this.f276130m + r103;
        int r107 = r102 + (this.f276129l / 2);
        if (r105 == false) goto L9;
        String r108 = String.valueOf(r101.getDay());
        float r109 = r107;
        if (r104 == false) goto L7;
        Paint r110 = this.f276122e;
    L8:
        r100.drawText(r108, r109, r106, r110);
        return;
    L7:
        r110 = this.f276123f;
        goto L8
    L9:
        if (r104 == false) goto L18;
        String r111 = String.valueOf(r101.getDay());
        float r112 = r107;
        if (r101.isCurrentDay() == false) goto L14;
        Paint r113 = this.f276124g;
    L17:
        r100.drawText(r111, r112, r106, r113);
        return;
    L14:
        if (r101.isCurrentMonth() == false) goto L16;
        r113 = this.f276122e;
        goto L17
    L16:
        r113 = this.f276120c;
        goto L17
    L18:
        String r114 = String.valueOf(r101.getDay());
        float r115 = r107;
        if (r101.isCurrentDay() == false) goto L22;
        Paint r116 = this.f276124g;
    L25:
        r100.drawText(r114, r115, r106, r116);
        return;
    L22:
        if (r101.isCurrentMonth() == false) goto L24;
        r116 = this.f276119b;
        goto L25
    L24:
        r116 = this.f276120c;
        goto L25
    }
}
