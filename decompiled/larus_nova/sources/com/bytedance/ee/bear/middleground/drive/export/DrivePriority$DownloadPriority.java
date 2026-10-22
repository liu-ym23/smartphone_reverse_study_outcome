package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum DrivePriority$DownloadPriority extends Enum<DrivePriority$DownloadPriority> {
    public static final DrivePriority$DownloadPriority DEFAULT = null;
    public static final DrivePriority$DownloadPriority MANUAL_OFFLINE = null;
    public static final DrivePriority$DownloadPriority PRELOAD = null;
    public static final DrivePriority$DownloadPriority PREVIEW = null;
    public static final DrivePriority$DownloadPriority USER_INTERACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePriority$DownloadPriority[] f232465a = null;
    private int priority;

    static {
        DrivePriority$DownloadPriority r100 = new DrivePriority$DownloadPriority("USER_INTERACTION", 0, 10);
        USER_INTERACTION = r100;
        DrivePriority$DownloadPriority r101 = new DrivePriority$DownloadPriority("PREVIEW", 1, 5);
        PREVIEW = r101;
        DrivePriority$DownloadPriority r102 = new DrivePriority$DownloadPriority("DEFAULT", 2, 0);
        DEFAULT = r102;
        DrivePriority$DownloadPriority r103 = new DrivePriority$DownloadPriority("MANUAL_OFFLINE", 3, -5);
        MANUAL_OFFLINE = r103;
        DrivePriority$DownloadPriority r104 = new DrivePriority$DownloadPriority("PRELOAD", 4, -10);
        PRELOAD = r104;
        f232465a = new DrivePriority$DownloadPriority[]{r100, r101, r102, r103, r104};
    }

    public static DrivePriority$DownloadPriority[] values() {
        return (DrivePriority$DownloadPriority[]) f232465a.clone();
    }

    public int getPriority() {
        return this.priority;
    }

    public static DrivePriority$DownloadPriority valueOf(String r100) {
        return (DrivePriority$DownloadPriority) a.a(DrivePriority$DownloadPriority.class, r100);
    }

    public DrivePriority$DownloadPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
