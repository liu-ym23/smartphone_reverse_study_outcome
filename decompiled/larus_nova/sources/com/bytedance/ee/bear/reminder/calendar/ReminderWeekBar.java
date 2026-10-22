package com.bytedance.ee.bear.reminder.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.w;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class ReminderWeekBar extends w implements NonProguard {
    public static final int WEEK_START_WITH_MON = 2;
    public static final int WEEK_START_WITH_SAT = 7;
    public static final int WEEK_START_WITH_SUN = 1;
    private int mPreSelectedIndex;
    private List<Integer> mWeeks;

    private void initWeeks() {
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Sunday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Monday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Tuesday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Wedsday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Thursday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Friday));
        this.mWeeks.add(Integer.valueOf(R.string.Doc_Reminder_Saturday));
    }

    public ReminderWeekBar(Context r100) {
        super(r100);
        this.mWeeks = new ArrayList();
        initWeeks();
        LayoutInflater.from(r100).inflate(R.layout.weekbar_layout, this, true);
    }

    @Override // com.haibin.calendarview.w
    public void onWeekStartChange(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        ((TextView) getChildAt(r101)).setText(getWeekString(r101, r100));
        r101 = r101 + 1;
        goto L4
    }

    private String getWeekString(int r100, int r101) {
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L17;
        if (r101 != 7) goto L9;
        Resources r102 = getResources();
        if (r100 != 0) goto L13;
        int r103 = 6;
    L15:
        return r102.getString(r103);
    L13:
        r103 = r100 - 1;
        goto L15
    L9:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r100)).intValue());
    L17:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r100 + 1)).intValue());
    L19:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r100)).intValue());
    }

    @Override // com.haibin.calendarview.w
    public void onDateSelected(Calendar r100, int r101, boolean r102) {
        getChildAt(this.mPreSelectedIndex).setSelected(false);
        int r103 = getViewIndexByCalendar(r100, r101);
        getChildAt(r103).setSelected(true);
        this.mPreSelectedIndex = r103;
    }
}
