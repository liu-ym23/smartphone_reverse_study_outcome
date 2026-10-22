package com.cronutils.model;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum CronType extends Enum<CronType> {
    public static final CronType CRON4J = null;
    public static final CronType QUARTZ = null;
    public static final CronType SPRING = null;
    public static final CronType SPRING53 = null;
    public static final CronType UNIX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CronType[] f273551a = null;

    static {
        CronType r100 = new CronType("CRON4J", 0);
        CRON4J = r100;
        CronType r101 = new CronType("QUARTZ", 1);
        QUARTZ = r101;
        CronType r102 = new CronType("UNIX", 2);
        UNIX = r102;
        CronType r103 = new CronType("SPRING", 3);
        SPRING = r103;
        CronType r104 = new CronType("SPRING53", 4);
        SPRING53 = r104;
        f273551a = new CronType[]{r100, r101, r102, r103, r104};
    }

    public static CronType[] values() {
        return (CronType[]) f273551a.clone();
    }

    public static CronType valueOf(String r100) {
        return (CronType) a.a(CronType.class, r100);
    }

    public CronType(String r100, int r101) {
        super(r100, r101);
    }
}
