package com.cronutils.model.definition;

/* JADX INFO: loaded from: classes6.dex */
public final enum CronNicknames extends Enum<CronNicknames> {
    public static final CronNicknames ANNUALLY = null;
    public static final CronNicknames DAILY = null;
    public static final CronNicknames HOURLY = null;
    public static final CronNicknames MIDNIGHT = null;
    public static final CronNicknames MONTHLY = null;
    public static final CronNicknames REBOOT = null;
    public static final CronNicknames WEEKLY = null;
    public static final CronNicknames YEARLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CronNicknames[] f273552a = null;

    static {
        CronNicknames r100 = new CronNicknames("YEARLY", 0);
        YEARLY = r100;
        CronNicknames r101 = new CronNicknames("ANNUALLY", 1);
        ANNUALLY = r101;
        CronNicknames r102 = new CronNicknames("MONTHLY", 2);
        MONTHLY = r102;
        CronNicknames r103 = new CronNicknames("WEEKLY", 3);
        WEEKLY = r103;
        CronNicknames r104 = new CronNicknames("DAILY", 4);
        DAILY = r104;
        CronNicknames r105 = new CronNicknames("MIDNIGHT", 5);
        MIDNIGHT = r105;
        CronNicknames r110 = new CronNicknames("HOURLY", 6);
        HOURLY = r110;
        CronNicknames r111 = new CronNicknames("REBOOT", 7);
        REBOOT = r111;
        f273552a = new CronNicknames[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static CronNicknames[] values() {
        return (CronNicknames[]) f273552a.clone();
    }

    public static CronNicknames valueOf(String r100) {
        return (CronNicknames) r27.a.a(CronNicknames.class, r100);
    }

    public CronNicknames(String r100, int r101) {
        super(r100, r101);
    }
}
