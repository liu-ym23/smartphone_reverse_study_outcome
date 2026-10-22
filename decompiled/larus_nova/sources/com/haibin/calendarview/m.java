package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes23.dex */
public final class m extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f276203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f276204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f276205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f276206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f276207e;

    public m(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f276203a = r101;
        Paint r102 = new Paint();
        this.f276204b = r102;
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
        this.f276205c = r103;
        this.f276206d = f.a(getContext(), 4.0f);
        Paint.FontMetrics r104 = r102.getFontMetrics();
        this.f276207e = ((r103 - r104.descent) + ((r104.bottom - r104.top) / 2.0f)) + f.a(getContext(), 1.0f);
    }

    @Override // com.haibin.calendarview.s
    public final void onDrawScheme(Canvas r100, Calendar r101, int r102, int r103) {
        this.f276204b.setColor(r101.getSchemeColor());
        int r104 = this.mItemWidth + r102;
        int r105 = this.f276206d;
        float r106 = this.f276205c;
        r100.drawCircle((r104 - r105) - (r106 / 2.0f), (r105 + r103) + r106, r106, this.f276204b);
        r100.drawText(r101.getScheme(), (((r102 + this.mItemWidth) - this.f276206d) - (this.f276205c / 2.0f)) - (this.f276203a.measureText(r101.getScheme()) / 2.0f), (r103 + this.f276206d) + this.f276207e, this.f276203a);
    }

    @Override // com.haibin.calendarview.s
    public final boolean onDrawSelected(Canvas r100, Calendar r101, int r102, int r110, boolean r111) {
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        int r103 = this.f276206d;
        r100.drawRect(r102 + r103, r110 + r103, (r102 + this.mItemWidth) - r103, (r110 + this.mItemHeight) - r103, this.mSelectedPaint);
        return true;
    }

    @Override // com.haibin.calendarview.s
    public final void onDrawText(Canvas r100, Calendar r101, int r102, int r103, boolean r104, boolean r105) {
        int r106 = r102 + (this.mItemWidth / 2);
        int r107 = r103 - (this.mItemHeight / 6);
        if (r105 == false) goto L5;
        float r108 = r106;
        r100.drawText(String.valueOf(r101.getDay()), r108, this.mTextBaseLine + r107, this.mSelectTextPaint);
        r100.drawText(r101.getLunar(), r108, (this.mTextBaseLine + r103) + (this.mItemHeight / 10), this.mSelectedLunarTextPaint);
        return;
    L5:
        if (r104 == false) goto L18;
        String r109 = String.valueOf(r101.getDay());
        float r110 = r106;
        float r111 = this.mTextBaseLine + r107;
        if (r101.isCurrentDay() == false) goto L10;
        Paint r112 = this.mCurDayTextPaint;
    L13:
        r100.drawText(r109, r110, r111, r112);
        String r113 = r101.getLunar();
        float r114 = (this.mTextBaseLine + r103) + (this.mItemHeight / 10);
        if (r101.isCurrentDay() == false) goto L16;
        Paint r115 = this.mCurDayLunarTextPaint;
    L17:
        r100.drawText(r113, r110, r114, r115);
        return;
    L16:
        r115 = this.mSchemeLunarTextPaint;
        goto L17
    L10:
        if (r101.isCurrentMonth() == false) goto L12;
        r112 = this.mSchemeTextPaint;
        goto L13
    L12:
        r112 = this.mOtherMonthTextPaint;
        goto L13
    L18:
        String r116 = String.valueOf(r101.getDay());
        float r117 = r106;
        float r118 = this.mTextBaseLine + r107;
        if (r101.isCurrentDay() == false) goto L22;
        Paint r119 = this.mCurDayTextPaint;
    L25:
        r100.drawText(r116, r117, r118, r119);
        String r120 = r101.getLunar();
        float r121 = (this.mTextBaseLine + r103) + (this.mItemHeight / 10);
        if (r101.isCurrentDay() == false) goto L29;
        Paint r122 = this.mCurDayLunarTextPaint;
    L32:
        r100.drawText(r120, r117, r121, r122);
        return;
    L29:
        if (r101.isCurrentMonth() == false) goto L31;
        r122 = this.mCurMonthLunarTextPaint;
        goto L32
    L31:
        r122 = this.mOtherMonthLunarTextPaint;
        goto L32
    L22:
        if (r101.isCurrentMonth() == false) goto L24;
        r119 = this.mCurMonthTextPaint;
        goto L25
    L24:
        r119 = this.mOtherMonthTextPaint;
        goto L25
    }
}
