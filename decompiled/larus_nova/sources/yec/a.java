package yec;

import com.larksuite.framework.utils.e;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static CalendarDate a(CalendarDate r100) {
        CalendarDate r101 = new CalendarDate(r100);
        r101.setMonthDay(1);
        CalendarDate r102 = r101.addDay(e.d(r101.getYear(), r101.getMonth()) - 1).moveToDayEnd();
        CalendarDate r103 = new CalendarDate(r101).addMonth(1);
        int r104 = c(r103.getYear(), r103.getMonth());
        if (r104 > 0) goto L5;
        return r102;
    L5:
        return r102.addDay(7 - r104);
    }

    public static CalendarDate b(CalendarDate r100) {
        int r101 = c(r100.getYear(), r100.getMonth());
        CalendarDate r102 = new CalendarDate(r100);
        r102.setMonthDay(1);
        return r102.addDay(-r101).moveToDayStart();
    }

    public static int c(int r100, int r101) {
        CalendarDate r102 = new CalendarDate();
        r102.setYear(r100);
        r102.setMonth(r101);
        r102.setMonthDay(1);
        return r102.getWeeklyDayIndex();
    }

    public static boolean d(CalendarDate r100, CalendarDate r101) {
        if (r100.getYear() == r101.getYear()) goto L5;
    L7:
        return false;
    L5:
        if (r100.getMonth() != r101.getMonth()) goto L7;
        return true;
    }
}
