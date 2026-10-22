package com.bytedance.ee.bear.reminder.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum EAlertTimeEvent extends Enum<EAlertTimeEvent> {
    public static final /* synthetic */ EAlertTimeEvent[] a = null;
    public static final EAlertTimeEvent atTimeOfEvent = null;
    public static final EAlertTimeEvent before15Mins = null;
    public static final EAlertTimeEvent before1Day = null;
    public static final EAlertTimeEvent before1Hour = null;
    public static final EAlertTimeEvent before1Week = null;
    public static final EAlertTimeEvent before2Days = null;
    public static final EAlertTimeEvent before2Hours = null;
    public static final EAlertTimeEvent before30Mins = null;
    public static final EAlertTimeEvent before5Mins = null;
    public static final EAlertTimeEvent noAlert = null;
    public static final EAlertTimeEvent onDayOfEvent = null;
    public static final EAlertTimeEvent oneDayBefore = null;
    public static final EAlertTimeEvent oneWeekBefore = null;
    public static final EAlertTimeEvent twoDaysBefore = null;
    int res;

    static {
        EAlertTimeEvent r0 = new EAlertTimeEvent("noAlert", 0, 2131888151);
        noAlert = r0;
        EAlertTimeEvent r1 = new EAlertTimeEvent("onDayOfEvent", 1, 2131888157);
        onDayOfEvent = r1;
        EAlertTimeEvent r2 = new EAlertTimeEvent("oneDayBefore", 2, 2131888159);
        oneDayBefore = r2;
        EAlertTimeEvent r4 = new EAlertTimeEvent("twoDaysBefore", 3, 2131888168);
        twoDaysBefore = r4;
        EAlertTimeEvent r6 = new EAlertTimeEvent("oneWeekBefore", 4, 2131888160);
        oneWeekBefore = r6;
        EAlertTimeEvent r8 = new EAlertTimeEvent("atTimeOfEvent", 5, 2131888141);
        atTimeOfEvent = r8;
        EAlertTimeEvent r10 = new EAlertTimeEvent("before5Mins", 6, 2131888138);
        before5Mins = r10;
        EAlertTimeEvent r12 = new EAlertTimeEvent("before15Mins", 7, 2131888131);
        before15Mins = r12;
        EAlertTimeEvent r14 = new EAlertTimeEvent("before30Mins", 8, 2131888137);
        before30Mins = r14;
        EAlertTimeEvent r13 = new EAlertTimeEvent("before1Hour", 9, 2131888133);
        before1Hour = r13;
        EAlertTimeEvent r11 = new EAlertTimeEvent("before2Hours", 10, 2131888136);
        before2Hours = r11;
        EAlertTimeEvent r9 = new EAlertTimeEvent("before1Day", 11, 2131888132);
        before1Day = r9;
        EAlertTimeEvent r7 = new EAlertTimeEvent("before2Days", 12, 2131888135);
        before2Days = r7;
        EAlertTimeEvent r5 = new EAlertTimeEvent("before1Week", 13, 2131888134);
        before1Week = r5;
        a = new EAlertTimeEvent[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5};
    }

    public static EAlertTimeEvent[] values() {
        return (EAlertTimeEvent[]) a.clone();
    }

    public int getRes() {
        return this.res;
    }

    public static EAlertTimeEvent valueOf(String r1) {
        return (EAlertTimeEvent) r27.a.a(EAlertTimeEvent.class, r1);
    }

    public EAlertTimeEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.res = r3;
    }
}
