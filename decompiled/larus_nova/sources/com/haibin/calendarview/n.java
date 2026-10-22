package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes23.dex */
public final class n extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f276208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f276209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f276210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f276211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f276212e;

    public n(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f276208a = r101;
        Paint r102 = new Paint();
        this.f276209b = r102;
        r101.setTextSize(f.a(r100, 8.0f));
        r101.setColor(-1);
        r101.setAntiAlias(true);
        r101.setFakeBoldText(true);
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.FILL);
        r102.setTextAlign(Paint.Align.CENTER);
        r102.setColor(-1223853);
        r102.setFakeBoldText(true);
        float r103 = f.a(getContext(), 7.0f);
        this.f276210c = r103;
        this.f276211d = f.a(getContext(), 4.0f);
        Paint.FontMetrics r104 = r102.getFontMetrics();
        this.f276212e = ((r103 - r104.descent) + ((r104.bottom - r104.top) / 2.0f)) + f.a(getContext(), 1.0f);
    }

    @Override // com.haibin.calendarview.x
    public final void b(Canvas r100, int r110) {
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        int r101 = this.f276211d;
        r100.drawRect(r110 + r101, r101, (r110 + this.mItemWidth) - r101, this.mItemHeight - r101, this.mSelectedPaint);
    }

    @Override // com.haibin.calendarview.x
    public final void a(Canvas r100, Calendar r101, int r102) {
        this.f276209b.setColor(r101.getSchemeColor());
        int r103 = this.mItemWidth + r102;
        int r104 = this.f276211d;
        float r105 = this.f276210c;
        r100.drawCircle((r103 - r104) - (r105 / 2.0f), r104 + r105, r105, this.f276209b);
        r100.drawText(r101.getScheme(), (((r102 + this.mItemWidth) - this.f276211d) - (this.f276210c / 2.0f)) - (this.f276208a.measureText(r101.getScheme()) / 2.0f), this.f276211d + this.f276212e, this.f276208a);
    }

    @Override // com.haibin.calendarview.x
    public final void c(Canvas r100, Calendar r101, int r102, boolean r103, boolean r104) {
        int r105 = r102 + (this.mItemWidth / 2);
        int r106 = (-this.mItemHeight) / 6;
        if (r104 == false) goto L5;
        float r107 = r105;
        r100.drawText(String.valueOf(r101.getDay()), r107, this.mTextBaseLine + r106, this.mSelectTextPaint);
        r100.drawText(r101.getLunar(), r107, this.mTextBaseLine + (this.mItemHeight / 10), this.mSelectedLunarTextPaint);
        return;
    L5:
        if (r103 == false) goto L18;
        String r108 = String.valueOf(r101.getDay());
        float r109 = r105;
        float r110 = this.mTextBaseLine + r106;
        if (r101.isCurrentDay() == false) goto L10;
        Paint r111 = this.mCurDayTextPaint;
    L13:
        r100.drawText(r108, r109, r110, r111);
        String r112 = r101.getLunar();
        float r113 = this.mTextBaseLine + (this.mItemHeight / 10);
        if (r101.isCurrentDay() == false) goto L16;
        Paint r114 = this.mCurDayLunarTextPaint;
    L17:
        r100.drawText(r112, r109, r113, r114);
        return;
    L16:
        r114 = this.mSchemeLunarTextPaint;
        goto L17
    L10:
        if (r101.isCurrentMonth() == false) goto L12;
        r111 = this.mSchemeTextPaint;
        goto L13
    L12:
        r111 = this.mOtherMonthTextPaint;
        goto L13
    L18:
        String r115 = String.valueOf(r101.getDay());
        float r116 = r105;
        float r117 = this.mTextBaseLine + r106;
        if (r101.isCurrentDay() == false) goto L22;
        Paint r118 = this.mCurDayTextPaint;
    L25:
        r100.drawText(r115, r116, r117, r118);
        String r119 = r101.getLunar();
        float r120 = this.mTextBaseLine + (this.mItemHeight / 10);
        if (r101.isCurrentDay() == false) goto L29;
        Paint r121 = this.mCurDayLunarTextPaint;
    L32:
        r100.drawText(r119, r116, r120, r121);
        return;
    L29:
        if (r101.isCurrentMonth() == false) goto L31;
        r121 = this.mCurMonthLunarTextPaint;
        goto L32
    L31:
        r121 = this.mOtherMonthLunarTextPaint;
        goto L32
    L22:
        if (r101.isCurrentMonth() == false) goto L24;
        r118 = this.mCurMonthTextPaint;
        goto L25
    L24:
        r118 = this.mOtherMonthTextPaint;
        goto L25
    }
}
