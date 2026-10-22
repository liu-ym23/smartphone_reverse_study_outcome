package com.bytedance.ee.bear.reminder.model;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum EAlertTimeEvent extends Enum<EAlertTimeEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EAlertTimeEvent[] f236473a = null;
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
        EAlertTimeEvent r100 = new EAlertTimeEvent("noAlert", 0, R.string.Doc_Reminder_NoAlert);
        noAlert = r100;
        EAlertTimeEvent r101 = new EAlertTimeEvent("onDayOfEvent", 1, R.string.Doc_Reminder_OnDayOfEvent9am);
        onDayOfEvent = r101;
        EAlertTimeEvent r102 = new EAlertTimeEvent("oneDayBefore", 2, R.string.Doc_Reminder_OneDayBefore9am);
        oneDayBefore = r102;
        EAlertTimeEvent r103 = new EAlertTimeEvent("twoDaysBefore", 3, R.string.Doc_Reminder_TwoDaysBefore9am);
        twoDaysBefore = r103;
        EAlertTimeEvent r104 = new EAlertTimeEvent("oneWeekBefore", 4, R.string.Doc_Reminder_OneWeekBefore9am);
        oneWeekBefore = r104;
        EAlertTimeEvent r105 = new EAlertTimeEvent("atTimeOfEvent", 5, R.string.Doc_Reminder_AtTimeOfEvent);
        atTimeOfEvent = r105;
        EAlertTimeEvent r110 = new EAlertTimeEvent("before5Mins", 6, R.string.Doc_Reminder_5MinsBefore);
        before5Mins = r110;
        EAlertTimeEvent r111 = new EAlertTimeEvent("before15Mins", 7, R.string.Doc_Reminder_15MinsBefore);
        before15Mins = r111;
        EAlertTimeEvent r112 = new EAlertTimeEvent("before30Mins", 8, R.string.Doc_Reminder_30MinsBefore);
        before30Mins = r112;
        EAlertTimeEvent r113 = new EAlertTimeEvent("before1Hour", 9, R.string.Doc_Reminder_1HourBefore);
        before1Hour = r113;
        EAlertTimeEvent r114 = new EAlertTimeEvent("before2Hours", 10, R.string.Doc_Reminder_2HoursBefore);
        before2Hours = r114;
        EAlertTimeEvent r106 = new EAlertTimeEvent("before1Day", 11, R.string.Doc_Reminder_1DayBefore);
        before1Day = r106;
        EAlertTimeEvent r107 = new EAlertTimeEvent("before2Days", 12, R.string.Doc_Reminder_2DaysBefore);
        before2Days = r107;
        EAlertTimeEvent r108 = new EAlertTimeEvent("before1Week", 13, R.string.Doc_Reminder_1WeekBefore);
        before1Week = r108;
        f236473a = new EAlertTimeEvent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
    }

    public static EAlertTimeEvent[] values() {
        return (EAlertTimeEvent[]) f236473a.clone();
    }

    public int getRes() {
        return this.res;
    }

    public static EAlertTimeEvent valueOf(String r100) {
        return (EAlertTimeEvent) r27.a.a(EAlertTimeEvent.class, r100);
    }

    public EAlertTimeEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.res = r102;
    }
}
