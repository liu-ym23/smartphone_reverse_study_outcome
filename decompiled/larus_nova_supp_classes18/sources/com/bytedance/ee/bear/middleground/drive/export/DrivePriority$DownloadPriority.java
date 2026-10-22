package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum DrivePriority$DownloadPriority extends Enum<DrivePriority$DownloadPriority> {
    public static final DrivePriority$DownloadPriority DEFAULT = null;
    public static final DrivePriority$DownloadPriority MANUAL_OFFLINE = null;
    public static final DrivePriority$DownloadPriority PRELOAD = null;
    public static final DrivePriority$DownloadPriority PREVIEW = null;
    public static final DrivePriority$DownloadPriority USER_INTERACTION = null;
    public static final /* synthetic */ DrivePriority$DownloadPriority[] a = null;
    private int priority;

    static {
        DrivePriority$DownloadPriority r0 = new DrivePriority$DownloadPriority("USER_INTERACTION", 0, 10);
        USER_INTERACTION = r0;
        DrivePriority$DownloadPriority r1 = new DrivePriority$DownloadPriority("PREVIEW", 1, 5);
        PREVIEW = r1;
        DrivePriority$DownloadPriority r2 = new DrivePriority$DownloadPriority("DEFAULT", 2, 0);
        DEFAULT = r2;
        DrivePriority$DownloadPriority r6 = new DrivePriority$DownloadPriority("MANUAL_OFFLINE", 3, -5);
        MANUAL_OFFLINE = r6;
        DrivePriority$DownloadPriority r8 = new DrivePriority$DownloadPriority("PRELOAD", 4, -10);
        PRELOAD = r8;
        a = new DrivePriority$DownloadPriority[]{r0, r1, r2, r6, r8};
    }

    public static DrivePriority$DownloadPriority[] values() {
        return (DrivePriority$DownloadPriority[]) a.clone();
    }

    public int getPriority() {
        return this.priority;
    }

    public static DrivePriority$DownloadPriority valueOf(String r1) {
        return (DrivePriority$DownloadPriority) a.a(DrivePriority$DownloadPriority.class, r1);
    }

    public DrivePriority$DownloadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
