package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes33.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    public static final CalendarMode MONTHS = null;
    public static final CalendarMode WEEKS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CalendarMode[] f399163a = null;
    final int visibleWeeksCount;

    static {
        CalendarMode r100 = new CalendarMode("MONTHS", 0, 5);
        MONTHS = r100;
        CalendarMode r101 = new CalendarMode("WEEKS", 1, 1);
        WEEKS = r101;
        f399163a = new CalendarMode[]{r100, r101};
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) f399163a.clone();
    }

    public static CalendarMode valueOf(String r100) {
        return (CalendarMode) r27.a.a(CalendarMode.class, r100);
    }

    public CalendarMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.visibleWeeksCount = r102;
    }
}
