package com.ss.android.lark.widget.timepicker.monthview.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum MonthViewAttr$DateState extends Enum<MonthViewAttr$DateState> {
    public static final MonthViewAttr$DateState CURRENT_DATE = null;
    public static final MonthViewAttr$DateState FUTURE_DATE = null;
    public static final MonthViewAttr$DateState PAST_DATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthViewAttr$DateState[] f449048a = null;

    static {
        MonthViewAttr$DateState r100 = new MonthViewAttr$DateState("PAST_DATE", 0);
        PAST_DATE = r100;
        MonthViewAttr$DateState r101 = new MonthViewAttr$DateState("FUTURE_DATE", 1);
        FUTURE_DATE = r101;
        MonthViewAttr$DateState r102 = new MonthViewAttr$DateState("CURRENT_DATE", 2);
        CURRENT_DATE = r102;
        f449048a = new MonthViewAttr$DateState[]{r100, r101, r102};
    }

    public static MonthViewAttr$DateState[] values() {
        return (MonthViewAttr$DateState[]) f449048a.clone();
    }

    public static MonthViewAttr$DateState valueOf(String r100) {
        return (MonthViewAttr$DateState) a.a(MonthViewAttr$DateState.class, r100);
    }

    public MonthViewAttr$DateState(String r100, int r101) {
        super(r100, r101);
    }
}
