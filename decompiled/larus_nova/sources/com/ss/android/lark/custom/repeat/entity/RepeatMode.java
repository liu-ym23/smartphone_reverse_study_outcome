package com.ss.android.lark.custom.repeat.entity;

import android.text.format.Time;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class RepeatMode implements Serializable {
    public static final int TYPE_CUSTOM_BYDAY = 7;
    public static final int TYPE_CUSTOM_BYMONTHDAY = 9;
    public static final int TYPE_CUSTOM_BYMONTHWEEK = 10;
    public static final int TYPE_CUSTOM_BYWEEK = 8;
    public static final int TYPE_CUSTOM_BYYEAR = 11;
    public static final int TYPE_DAILY = 1;
    public static final int TYPE_MONTHLY = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_TWO_WEEK = 3;
    public static final int TYPE_WEEKLY = 2;
    public static final int TYPE_WORKDAY = 6;
    public static final int TYPE_YEARLY = 5;
    private static final long serialVersionUID = 1;
    private List<Integer> mCustomerByMonthDay;
    private String mCustomerByMonthWeekDay;
    private String mCustomerByMonthWeekNo;
    private List<Integer> mCustomerByWeek;
    private int mFrequency;
    private int mInterval;
    private boolean mIsSingleInMonth;
    private boolean mIsSingleInWeek;
    private String[] mMonthlyDay;
    private int mRepeatType;
    private CalendarDate mUntilDate;
    private String[] mWeekNo;
    private CustomRepeatParams$DayOfWeek mWeekStartDay;
    private String[] mWeeks;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420326a = null;

        static {
            int[] r100 = new int[CustomRepeatParams$DayOfWeek.values().length];
            f420326a = r100;
            r100[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f420326a[CustomRepeatParams$DayOfWeek.TUESDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f420326a[CustomRepeatParams$DayOfWeek.WEDNESDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f420326a[CustomRepeatParams$DayOfWeek.THURSDAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f420326a[CustomRepeatParams$DayOfWeek.FRIDAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f420326a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static int a(int r100) {
        switch(r100) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 4194304;
    L7:
        return 2097152;
    L9:
        return 1048576;
    L11:
        return 524288;
    L13:
        return 262144;
    L15:
        return 131072;
    L17:
        return 65536;
    }

    public static int b(int r100) {
        if (r100 != 65536) goto L5;
        return 0;
    L5:
        if (r100 != 131072) goto L7;
        return 1;
    L7:
        if (r100 != 262144) goto L9;
        return 2;
    L9:
        if (r100 != 524288) goto L11;
        return 3;
    L11:
        if (r100 != 1048576) goto L13;
        return 4;
    L13:
        if (r100 != 2097152) goto L15;
        return 5;
    L15:
        if (r100 == 4194304) goto L18;
        return -1;
    L18:
        return 6;
    }

    public void clearRule() {
        this.mRepeatType = 0;
        this.mFrequency = 0;
        this.mInterval = 0;
        this.mCustomerByWeek = null;
        this.mCustomerByMonthDay = null;
        this.mCustomerByMonthWeekDay = "";
        this.mCustomerByMonthWeekNo = "";
    }

    public EventRecurrence toER() {
        EventRecurrence r100 = new EventRecurrence();
        r100.f420302a = this.mFrequency;
        r100.f420305d = this.mInterval;
        int r101 = 0;
        switch(this.mRepeatType) {
            case 6: goto L30;
            case 7: goto L49;
            case 8: goto L30;
            case 9: goto L22;
            case 10: goto L5;
            default: goto L49;
        };
    L5:
        r100.f420315n = 1;
        r100.f420313l = new int[1];
        int[] r102 = new int[1];
        r100.f420314m = r102;
        String r103 = this.mCustomerByMonthWeekNo;
        int r104 = 0;
    L6:
        String[] r105 = this.mWeekNo;
        int r106 = -1;
        if (r104 >= r105.length) goto L12;
        if (r105[r104].equals(r103) == true) goto L10;
        r104 = r104 + 1;
        goto L6
    L10:
        int r107 = r104 + 1;
    L13:
        r102[0] = r107;
        int[] r108 = r100.f420313l;
        String r109 = this.mCustomerByMonthWeekDay;
        int r110 = 0;
    L14:
        String[] r111 = this.mWeeks;
        if (r110 >= r111.length) goto L20;
        if (r111[r110].equals(r109) == true) goto L18;
        r110 = r110 + 1;
        goto L14
    L18:
        r106 = a(r110);
    L20:
        r108[0] = r106;
        goto L49
    L12:
        r107 = -1;
        goto L13
    L22:
        if (CollectionUtils.isNotEmpty(this.mCustomerByMonthDay) == false) goto L24;
        int r112 = this.mCustomerByMonthDay.size();
    L25:
        r100.f420317p = r112;
        r100.f420316o = new int[r112];
    L27:
        if (r101 >= r100.f420317p) goto L49;
        r100.f420316o[r101] = ((Integer) ListProtector.get(this.mCustomerByMonthDay, r101)).intValue();
        r101 = r101 + 1;
        goto L27
    L24:
        r112 = 0;
        goto L25
    L30:
        if (CollectionUtils.isNotEmpty(this.mCustomerByWeek) == false) goto L32;
        int r113 = this.mCustomerByWeek.size();
    L33:
        r100.f420315n = r113;
        r100.f420313l = new int[r113];
        r100.f420314m = new int[r113];
        int r114 = 0;
    L35:
        if (r114 >= r100.f420315n) goto L38;
        r100.f420314m[r114] = 0;
        r100.f420313l[r114] = a(((Integer) ListProtector.get(this.mCustomerByWeek, r114)).intValue());
        r114 = r114 + 1;
        goto L35
    L38:
        if (this.mInterval <= 1) goto L49;
        switch(a.f420326a[this.mWeekStartDay.ordinal()]) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L42;
            default: goto L41;
        };
    L41:
        r100.f420306e = 65536;
        goto L49
    L42:
        r100.f420306e = 4194304;
        goto L49
    L43:
        r100.f420306e = 2097152;
        goto L49
    L44:
        r100.f420306e = 1048576;
        goto L49
    L45:
        r100.f420306e = 524288;
        goto L49
    L46:
        r100.f420306e = 262144;
        goto L49
    L47:
        r100.f420306e = 131072;
        goto L49
    L32:
        r113 = 0;
    L49:
        if (this.mUntilDate == null) goto L51;
        Time r115 = new Time();
        r115.set(this.mUntilDate.getMonthDay(), this.mUntilDate.getMonth() - 1, this.mUntilDate.getYear());
        r100.f420303b = r115.format2445();
    L51:
        return r100;
    }

    public String toString() {
        return "repeatType: " + this.mRepeatType + " mFrequency: " + this.mFrequency + " mInterval: " + this.mInterval;
    }

    public RepeatMode() {
        this.mIsSingleInWeek = false;
        this.mIsSingleInMonth = false;
        this.mWeekStartDay = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.mRepeatType = 0;
        this.mWeeks = UIHelper.getStringArray(R.array.weekly);
        this.mWeekNo = UIHelper.getStringArray(R.array.week_no);
        this.mMonthlyDay = UIHelper.getStringArray(R.array.custom_repeat_days);
    }

    public List<Integer> getCustomerByMonthDayList() {
        return this.mCustomerByMonthDay;
    }

    public List<Integer> getCustomerByWeekList() {
        return this.mCustomerByWeek;
    }

    public int getRepeatType() {
        return this.mRepeatType;
    }

    public CustomRepeatParams$DayOfWeek getWeekStartDay() {
        return this.mWeekStartDay;
    }

    public boolean isSingleInMonth() {
        return this.mIsSingleInMonth;
    }

    public boolean isSingleInWeek() {
        return this.mIsSingleInWeek;
    }

    public RepeatMode(EventRecurrence r110) {
        int r100 = 0;
        this.mIsSingleInWeek = false;
        this.mIsSingleInMonth = false;
        this.mWeekStartDay = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.mWeeks = UIHelper.getStringArray(R.array.weekly);
        this.mWeekNo = UIHelper.getStringArray(R.array.week_no);
        this.mMonthlyDay = UIHelper.getStringArray(R.array.custom_repeat_days);
        int r101 = r110.f420302a;
        this.mFrequency = r101;
        int r102 = r110.f420305d;
        this.mInterval = r102;
        if (r101 != 4) goto L8;
        if (r102 > 1) goto L6;
        this.mRepeatType = 1;
    L50:
        if (r110.f420303b == null) goto L57;
        Time r103 = new Time();
        r103.parse(r110.f420303b);
        this.mUntilDate = new CalendarDate(r103.year, r103.month + 1, r103.monthDay, r103.hour, r103.minute, 0);
        return;
    L57:
        return;
    L6:
        this.mRepeatType = 7;
        goto L50
    L8:
        if (r101 == 5) goto L10;
        if (r101 == 6) goto L33;
        if (r101 != 7) goto L50;
        if (r102 > 1) goto L48;
        this.mRepeatType = 5;
        goto L50
    L48:
        this.mRepeatType = 11;
        goto L50
    L33:
        if (r110.f420315n <= 0) goto L39;
        this.mRepeatType = 10;
        int r104 = r110.f420314m[0] - 1;
        if (r104 >= 0) goto L37;
        r104 = 0;
    L37:
        this.mCustomerByMonthWeekNo = this.mWeekNo[r104];
        this.mCustomerByMonthWeekDay = this.mWeeks[b(r110.f420313l[0])];
        goto L50
    L39:
        if (r110.f420317p <= 0) goto L44;
        this.mRepeatType = 9;
        this.mCustomerByMonthDay = new ArrayList();
    L42:
        if (r100 >= r110.f420317p) goto L50;
        this.mCustomerByMonthDay.add(Integer.valueOf(r110.f420316o[r100]));
        r100 = r100 + 1;
        goto L42
    L44:
        this.mRepeatType = 4;
        goto L50
    L10:
        if (r110.f420315n <= 0) goto L26;
        this.mRepeatType = 8;
        this.mCustomerByWeek = new ArrayList();
        int r105 = 0;
    L13:
        if (r105 >= r110.f420315n) goto L16;
        this.mCustomerByWeek.add(Integer.valueOf(b(r110.f420313l[r105])));
        r105 = r105 + 1;
        goto L13
    L16:
        if (this.mCustomerByWeek.size() != 5) goto L50;
        Collections.sort(this.mCustomerByWeek);
    L18:
        if (r100 >= 5) goto L23;
        int r106 = r100 + 1;
        if (((Integer) ListProtector.get(this.mCustomerByWeek, r100)).intValue() != r106) goto L23;
        r100 = r106;
    L23:
        if (r100 != 5) goto L50;
        this.mRepeatType = 6;
        goto L50
    L26:
        if (r102 > 1) goto L28;
        this.mRepeatType = 2;
        goto L50
    L28:
        if (r102 != 2) goto L30;
        this.mRepeatType = 3;
        goto L50
    L30:
        this.mRepeatType = 8;
        goto L50
    }

    public void addMonthList(int r100) {
        if (this.mCustomerByMonthDay != null) goto L6;
        this.mCustomerByMonthDay = new ArrayList();
    L6:
        if (this.mCustomerByMonthDay.contains(Integer.valueOf(r100)) == true) goto L9;
        this.mCustomerByMonthDay.add(Integer.valueOf(r100));
        Collections.sort(this.mCustomerByMonthDay);
        return;
    }

    public void addWeekList(int r100) {
        if (this.mCustomerByWeek != null) goto L6;
        this.mCustomerByWeek = new ArrayList();
    L6:
        if (this.mCustomerByWeek.contains(Integer.valueOf(r100)) == true) goto L9;
        this.mCustomerByWeek.add(Integer.valueOf(r100));
        Collections.sort(this.mCustomerByWeek);
        return;
    }

    public boolean containsMonthDay(int r100) {
        if (CollectionUtils.isEmpty(this.mCustomerByMonthDay) == false) goto L7;
        return false;
    L7:
        return this.mCustomerByMonthDay.contains(Integer.valueOf(r100));
    }

    public boolean containsWeekDay(int r100) {
        if (CollectionUtils.isEmpty(this.mCustomerByWeek) == false) goto L7;
        return false;
    L7:
        return this.mCustomerByWeek.contains(Integer.valueOf(r100));
    }

    public String getWeekDay(int r100) {
        if (r100 < 0) goto L8;
        String[] r101 = this.mWeeks;
        if (r100 < r101.length) goto L7;
        return "";
    L7:
        return r101[r100];
    L8:
        return "";
    }

    public String getWeekNo(int r100) {
        if (r100 < 0) goto L8;
        String[] r101 = this.mWeekNo;
        if (r100 < r101.length) goto L7;
        return "";
    L7:
        return r101[r100];
    L8:
        return "";
    }

    public void removeMonthList(int r100) {
        List<Integer> r101 = this.mCustomerByMonthDay;
        if (r101 == null) goto L6;
        r101.remove(Integer.valueOf(r100));
        return;
    }

    public void removeWeekList(int r100) {
        List<Integer> r101 = this.mCustomerByWeek;
        if (r101 == null) goto L6;
        r101.remove(Integer.valueOf(r100));
        return;
    }

    public void setCustomerByMonthWeekDay(String r100) {
        this.mCustomerByMonthWeekDay = r100;
    }

    public void setCustomerByMonthWeekNo(String r100) {
        this.mCustomerByMonthWeekNo = r100;
    }

    public void setInterval(int r100) {
        this.mInterval = r100;
    }

    public void setIsSingleInMonth(boolean r100) {
        this.mIsSingleInMonth = r100;
    }

    public void setIsSingleInWeek(boolean r100) {
        this.mIsSingleInWeek = r100;
    }

    public void setRepeatType(int r100) {
        this.mRepeatType = r100;
        switch(r100) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L29;
        };
    L5:
        this.mFrequency = 7;
        return;
    L6:
        this.mFrequency = 6;
        return;
    L7:
        this.mFrequency = 6;
        return;
    L8:
        this.mFrequency = 5;
        return;
    L9:
        this.mFrequency = 4;
        return;
    L10:
        this.mFrequency = 5;
        this.mCustomerByWeek = new ArrayList();
        int r101 = 1;
    L11:
        if (r101 >= 6) goto L30;
        this.mCustomerByWeek.add(Integer.valueOf(r101));
        r101 = r101 + 1;
        goto L11
    L30:
        return;
    L13:
        this.mFrequency = 7;
        return;
    L14:
        this.mFrequency = 6;
        return;
    L15:
        this.mFrequency = 5;
        return;
    L16:
        this.mFrequency = 5;
        return;
    L17:
        this.mFrequency = 4;
        return;
    }

    public void setWeekStartDay(CustomRepeatParams$DayOfWeek r100) {
        this.mWeekStartDay = r100;
    }
}
