package com.haibin.calendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class w extends LinearLayout {
    private l mDelegate;

    public void onDateSelected(Calendar r100, int r101, boolean r102) {
    }

    public w(Context r100) {
        super(r100);
        if ("com.haibin.calendarview.w".equals(getClass().getName()) == false) goto L6;
        LayoutInflater.from(r100).inflate(R.layout.cv_week_bar, this, true);
        return;
    }

    public void onWeekStartChange(int r100) {
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName()) == true) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= getChildCount()) goto L9;
        ((TextView) getChildAt(r101)).setText(getWeekString(r101, r100));
        r101 = r101 + 1;
        goto L7
    }

    public void setTextColor(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        ((TextView) getChildAt(r101)).setTextColor(r100);
        r101 = r101 + 1;
        goto L4
    }

    public void setTextSize(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        ((TextView) getChildAt(r101)).setTextSize(0, r100);
        r101 = r101 + 1;
        goto L4
    }

    public void setup(l r100) {
        this.mDelegate = r100;
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName()) == false) goto L6;
        setTextSize(this.mDelegate.H);
        setTextColor(r100.f276166f);
        setBackgroundColor(r100.F);
        int r101 = r100.f276184o;
        setPadding(r101, 0, r101, 0);
        return;
    }

    private String getWeekString(int r100, int r101) {
        String[] r102 = getContext().getResources().getStringArray(R.array.week_string_array);
        if (r101 == 1) goto L5;
        int r103 = 6;
        if (r101 != 2) goto L13;
        if (r100 != 6) goto L10;
        int r104 = 0;
    L12:
        return r102[r104];
    L10:
        r104 = r100 + 1;
        goto L12
    L13:
        if (r100 == 0) goto L17;
        r103 = r100 - 1;
    L17:
        return r102[r103];
    L5:
        return r102[r100];
    }

    public int getViewIndexByCalendar(Calendar r100, int r101) {
        int r102 = r100.getWeek() + 1;
        if (r101 != 1) goto L7;
        return r102 - 1;
    L7:
        if (r101 != 2) goto L13;
        if (r102 != 1) goto L11;
        return 6;
    L11:
        return r102 - 2;
    L13:
        if (r102 != 7) goto L17;
        return 0;
    L17:
        return r102;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        l r102 = this.mDelegate;
        if (r102 == null) goto L5;
        int r103 = View.MeasureSpec.makeMeasureSpec(r102.f276163d0, 1073741824);
    L6:
        super.onMeasure(r100, r103);
        return;
    L5:
        r103 = View.MeasureSpec.makeMeasureSpec(f.a(getContext(), 40.0f), 1073741824);
        goto L6
    }
}
