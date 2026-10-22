package ql5;

import com.haibin.calendarview.Calendar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 {
    public static Calendar a(long r2) {
        java.util.Calendar r0 = java.util.Calendar.getInstance();
        r0.setTimeInMillis(r2);
        Calendar r3 = new Calendar();
        r3.setYear(r0.get(1));
        r3.setMonth(r0.get(2) + 1);
        r3.setDay(r0.get(5));
        return r3;
    }

    public static long b(Calendar r3, int r4, int r5, int r6) {
        java.util.Calendar r0 = java.util.Calendar.getInstance();
        r0.setTimeInMillis(r3.getTimeInMillis());
        r0.set(11, r4);
        r0.set(12, r5);
        r0.set(13, r6);
        return r0.getTimeInMillis();
    }
}
