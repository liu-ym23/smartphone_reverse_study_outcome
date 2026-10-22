package com.bytedance.ee.bear.reminder.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderWeekBar extends w implements NonProguard {
    public static final int WEEK_START_WITH_MON = 2;
    public static final int WEEK_START_WITH_SAT = 7;
    public static final int WEEK_START_WITH_SUN = 1;
    private int mPreSelectedIndex;
    private List<Integer> mWeeks;

    private void initWeeks() {
        this.mWeeks.add(2131888163);
        this.mWeeks.add(2131888150);
        this.mWeeks.add(2131888167);
        this.mWeeks.add(2131888169);
        this.mWeeks.add(2131888164);
        this.mWeeks.add(2131888149);
        this.mWeeks.add(2131888161);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReminderWeekBar(Context r3) {
        super(r3);
        this.mWeeks = new ArrayList();
        initWeeks();
        LayoutInflater.from(r3).inflate(2131568216, this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWeekStartChange(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        ((TextView) getChildAt(r0)).setText(getWeekString(r0, r4));
        r0 = r0 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getWeekString(int r3, int r4) {
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L17;
        if (r4 != 7) goto L9;
        Resources r5 = getResources();
        if (r3 != 0) goto L13;
        int r6 = 6;
    L15:
        return r5.getString(r6);
    L13:
        r6 = r3 - 1;
        goto L15
    L9:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r3)).intValue());
    L17:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r3 + 1)).intValue());
    L19:
        return getResources().getString(((Integer) ListProtector.get(this.mWeeks, r3)).intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDateSelected(Calendar r2, int r3, boolean r4) {
        getChildAt(this.mPreSelectedIndex).setSelected(false);
        int r5 = getViewIndexByCalendar(r2, r3);
        getChildAt(r5).setSelected(true);
        this.mPreSelectedIndex = r5;
    }
}
