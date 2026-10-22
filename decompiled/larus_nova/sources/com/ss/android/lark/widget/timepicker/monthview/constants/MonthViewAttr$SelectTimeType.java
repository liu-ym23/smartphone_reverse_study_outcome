package com.ss.android.lark.widget.timepicker.monthview.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum MonthViewAttr$SelectTimeType extends Enum<MonthViewAttr$SelectTimeType> {
    public static final MonthViewAttr$SelectTimeType END_TIME = null;
    public static final MonthViewAttr$SelectTimeType START_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthViewAttr$SelectTimeType[] f449052a = null;
    private int value;

    static {
        MonthViewAttr$SelectTimeType r100 = new MonthViewAttr$SelectTimeType("START_TIME", 0, 1);
        START_TIME = r100;
        MonthViewAttr$SelectTimeType r101 = new MonthViewAttr$SelectTimeType("END_TIME", 1, 2);
        END_TIME = r101;
        f449052a = new MonthViewAttr$SelectTimeType[]{r100, r101};
    }

    public static MonthViewAttr$SelectTimeType[] values() {
        return (MonthViewAttr$SelectTimeType[]) f449052a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static MonthViewAttr$SelectTimeType forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return START_TIME;
    L9:
        return END_TIME;
    L11:
        return START_TIME;
    }

    public static MonthViewAttr$SelectTimeType valueOf(String r100) {
        return (MonthViewAttr$SelectTimeType) a.a(MonthViewAttr$SelectTimeType.class, r100);
    }

    public static MonthViewAttr$SelectTimeType valueOf(int r100) {
        return forNumber(r100);
    }

    public MonthViewAttr$SelectTimeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
