package com.ss.android.lark.widget.timepicker.monthview.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum MonthViewAttr$OptionalState extends Enum<MonthViewAttr$OptionalState> {
    public static final MonthViewAttr$OptionalState NOT_OPTIONAL = null;
    public static final MonthViewAttr$OptionalState OPTIONAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthViewAttr$OptionalState[] f449050a = null;

    static {
        MonthViewAttr$OptionalState r100 = new MonthViewAttr$OptionalState("OPTIONAL", 0);
        OPTIONAL = r100;
        MonthViewAttr$OptionalState r101 = new MonthViewAttr$OptionalState("NOT_OPTIONAL", 1);
        NOT_OPTIONAL = r101;
        f449050a = new MonthViewAttr$OptionalState[]{r100, r101};
    }

    public static MonthViewAttr$OptionalState[] values() {
        return (MonthViewAttr$OptionalState[]) f449050a.clone();
    }

    public static MonthViewAttr$OptionalState valueOf(String r100) {
        return (MonthViewAttr$OptionalState) a.a(MonthViewAttr$OptionalState.class, r100);
    }

    public MonthViewAttr$OptionalState(String r100, int r101) {
        super(r100, r101);
    }
}
