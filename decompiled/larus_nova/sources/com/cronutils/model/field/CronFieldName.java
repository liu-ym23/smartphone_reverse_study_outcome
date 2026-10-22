package com.cronutils.model.field;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum CronFieldName extends Enum<CronFieldName> {
    public static final CronFieldName DAY_OF_MONTH = null;
    public static final CronFieldName DAY_OF_WEEK = null;
    public static final CronFieldName DAY_OF_YEAR = null;
    public static final CronFieldName HOUR = null;
    public static final CronFieldName MINUTE = null;
    public static final CronFieldName MONTH = null;
    public static final CronFieldName SECOND = null;
    public static final CronFieldName YEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CronFieldName[] f273558a = null;
    private int order;

    static {
        CronFieldName r100 = new CronFieldName("SECOND", 0, 0);
        SECOND = r100;
        CronFieldName r101 = new CronFieldName("MINUTE", 1, 1);
        MINUTE = r101;
        CronFieldName r102 = new CronFieldName("HOUR", 2, 2);
        HOUR = r102;
        CronFieldName r103 = new CronFieldName("DAY_OF_MONTH", 3, 3);
        DAY_OF_MONTH = r103;
        CronFieldName r104 = new CronFieldName("MONTH", 4, 4);
        MONTH = r104;
        CronFieldName r105 = new CronFieldName("DAY_OF_WEEK", 5, 5);
        DAY_OF_WEEK = r105;
        CronFieldName r110 = new CronFieldName("YEAR", 6, 6);
        YEAR = r110;
        CronFieldName r111 = new CronFieldName("DAY_OF_YEAR", 7, 7);
        DAY_OF_YEAR = r111;
        f273558a = new CronFieldName[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static CronFieldName[] values() {
        return (CronFieldName[]) f273558a.clone();
    }

    public int getOrder() {
        return this.order;
    }

    public static CronFieldName valueOf(String r100) {
        return (CronFieldName) a.a(CronFieldName.class, r100);
    }

    public CronFieldName(String r100, int r101, int r102) {
        super(r100, r101);
        this.order = r102;
    }
}
