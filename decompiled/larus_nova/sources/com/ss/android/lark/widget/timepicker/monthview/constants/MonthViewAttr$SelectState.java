package com.ss.android.lark.widget.timepicker.monthview.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum MonthViewAttr$SelectState extends Enum<MonthViewAttr$SelectState> {
    public static final MonthViewAttr$SelectState SELECT = null;
    public static final MonthViewAttr$SelectState UN_SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthViewAttr$SelectState[] f449051a = null;

    static {
        MonthViewAttr$SelectState r100 = new MonthViewAttr$SelectState("SELECT", 0);
        SELECT = r100;
        MonthViewAttr$SelectState r101 = new MonthViewAttr$SelectState("UN_SELECT", 1);
        UN_SELECT = r101;
        f449051a = new MonthViewAttr$SelectState[]{r100, r101};
    }

    public static MonthViewAttr$SelectState[] values() {
        return (MonthViewAttr$SelectState[]) f449051a.clone();
    }

    public static MonthViewAttr$SelectState valueOf(String r100) {
        return (MonthViewAttr$SelectState) a.a(MonthViewAttr$SelectState.class, r100);
    }

    public MonthViewAttr$SelectState(String r100, int r101) {
        super(r100, r101);
    }
}
