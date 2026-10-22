package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum DrivePriority$UploadPriority extends Enum<DrivePriority$UploadPriority> {
    public static final DrivePriority$UploadPriority BACKGROUND = null;
    public static final DrivePriority$UploadPriority DEFAULT = null;
    public static final DrivePriority$UploadPriority DEFAULT_HEIGHT = null;
    public static final DrivePriority$UploadPriority DEFAULT_LOW = null;
    public static final DrivePriority$UploadPriority USER_INTERACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePriority$UploadPriority[] f232466a = null;
    private int priority;

    static {
        DrivePriority$UploadPriority r100 = new DrivePriority$UploadPriority("USER_INTERACTION", 0, 10);
        USER_INTERACTION = r100;
        DrivePriority$UploadPriority r101 = new DrivePriority$UploadPriority("DEFAULT_HEIGHT", 1, 5);
        DEFAULT_HEIGHT = r101;
        DrivePriority$UploadPriority r102 = new DrivePriority$UploadPriority("DEFAULT", 2, 0);
        DEFAULT = r102;
        DrivePriority$UploadPriority r103 = new DrivePriority$UploadPriority("DEFAULT_LOW", 3, -5);
        DEFAULT_LOW = r103;
        DrivePriority$UploadPriority r104 = new DrivePriority$UploadPriority("BACKGROUND", 4, -10);
        BACKGROUND = r104;
        f232466a = new DrivePriority$UploadPriority[]{r100, r101, r102, r103, r104};
    }

    public static DrivePriority$UploadPriority[] values() {
        return (DrivePriority$UploadPriority[]) f232466a.clone();
    }

    public int getPriority() {
        return this.priority;
    }

    public static DrivePriority$UploadPriority getUploadPriority(int r100) {
        DrivePriority$UploadPriority r101 = USER_INTERACTION;
        if (r100 != r101.priority) goto L5;
        return r101;
    L5:
        DrivePriority$UploadPriority r102 = DEFAULT_HEIGHT;
        if (r100 != r102.priority) goto L8;
        return r102;
    L8:
        DrivePriority$UploadPriority r103 = DEFAULT;
        if (r100 != r103.priority) goto L11;
        return r103;
    L11:
        DrivePriority$UploadPriority r104 = DEFAULT_LOW;
        if (r100 != r104.priority) goto L14;
        return r104;
    L14:
        DrivePriority$UploadPriority r105 = BACKGROUND;
        if (r100 != r105.priority) goto L17;
        return r105;
    L17:
        return r103;
    }

    public static DrivePriority$UploadPriority valueOf(String r100) {
        return (DrivePriority$UploadPriority) a.a(DrivePriority$UploadPriority.class, r100);
    }

    public DrivePriority$UploadPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
