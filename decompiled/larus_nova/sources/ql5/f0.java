package ql5;

import com.haibin.calendarview.Calendar;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 {
    public static Calendar a(long r100) {
        java.util.Calendar r101 = java.util.Calendar.getInstance();
        r101.setTimeInMillis(r100);
        Calendar r102 = new Calendar();
        r102.setYear(r101.get(1));
        r102.setMonth(r101.get(2) + 1);
        r102.setDay(r101.get(5));
        return r102;
    }

    public static long b(Calendar r100, int r101, int r102, int r103) {
        java.util.Calendar r104 = java.util.Calendar.getInstance();
        r104.setTimeInMillis(r100.getTimeInMillis());
        r104.set(11, r101);
        r104.set(12, r102);
        r104.set(13, r103);
        return r104.getTimeInMillis();
    }
}
