package com.ss.android.lark.widget.timepicker.monthview.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum MonthViewAttr$MonthState extends Enum<MonthViewAttr$MonthState> {
    public static final MonthViewAttr$MonthState CURRENT_MONTH = null;
    public static final MonthViewAttr$MonthState LAST_MONTH = null;
    public static final MonthViewAttr$MonthState NEXT_MONTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthViewAttr$MonthState[] f449049a = null;

    static {
        MonthViewAttr$MonthState r100 = new MonthViewAttr$MonthState("CURRENT_MONTH", 0);
        CURRENT_MONTH = r100;
        MonthViewAttr$MonthState r101 = new MonthViewAttr$MonthState("LAST_MONTH", 1);
        LAST_MONTH = r101;
        MonthViewAttr$MonthState r102 = new MonthViewAttr$MonthState("NEXT_MONTH", 2);
        NEXT_MONTH = r102;
        f449049a = new MonthViewAttr$MonthState[]{r100, r101, r102};
    }

    public static MonthViewAttr$MonthState[] values() {
        return (MonthViewAttr$MonthState[]) f449049a.clone();
    }

    public static MonthViewAttr$MonthState valueOf(String r100) {
        return (MonthViewAttr$MonthState) a.a(MonthViewAttr$MonthState.class, r100);
    }

    public MonthViewAttr$MonthState(String r100, int r101) {
        super(r100, r101);
    }
}
