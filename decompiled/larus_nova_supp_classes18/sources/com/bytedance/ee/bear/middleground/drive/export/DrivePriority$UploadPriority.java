package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum DrivePriority$UploadPriority extends Enum<DrivePriority$UploadPriority> {
    public static final DrivePriority$UploadPriority BACKGROUND = null;
    public static final DrivePriority$UploadPriority DEFAULT = null;
    public static final DrivePriority$UploadPriority DEFAULT_HEIGHT = null;
    public static final DrivePriority$UploadPriority DEFAULT_LOW = null;
    public static final DrivePriority$UploadPriority USER_INTERACTION = null;
    public static final /* synthetic */ DrivePriority$UploadPriority[] a = null;
    private int priority;

    static {
        DrivePriority$UploadPriority r0 = new DrivePriority$UploadPriority("USER_INTERACTION", 0, 10);
        USER_INTERACTION = r0;
        DrivePriority$UploadPriority r1 = new DrivePriority$UploadPriority("DEFAULT_HEIGHT", 1, 5);
        DEFAULT_HEIGHT = r1;
        DrivePriority$UploadPriority r2 = new DrivePriority$UploadPriority("DEFAULT", 2, 0);
        DEFAULT = r2;
        DrivePriority$UploadPriority r6 = new DrivePriority$UploadPriority("DEFAULT_LOW", 3, -5);
        DEFAULT_LOW = r6;
        DrivePriority$UploadPriority r8 = new DrivePriority$UploadPriority("BACKGROUND", 4, -10);
        BACKGROUND = r8;
        a = new DrivePriority$UploadPriority[]{r0, r1, r2, r6, r8};
    }

    public static DrivePriority$UploadPriority[] values() {
        return (DrivePriority$UploadPriority[]) a.clone();
    }

    public int getPriority() {
        return this.priority;
    }

    public static DrivePriority$UploadPriority getUploadPriority(int r3) {
        DrivePriority$UploadPriority r0 = USER_INTERACTION;
        if (r3 != r0.priority) goto L5;
        return r0;
    L5:
        DrivePriority$UploadPriority r1 = DEFAULT_HEIGHT;
        if (r3 != r1.priority) goto L8;
        return r1;
    L8:
        DrivePriority$UploadPriority r2 = DEFAULT;
        if (r3 != r2.priority) goto L11;
        return r2;
    L11:
        DrivePriority$UploadPriority r4 = DEFAULT_LOW;
        if (r3 != r4.priority) goto L14;
        return r4;
    L14:
        DrivePriority$UploadPriority r5 = BACKGROUND;
        if (r3 != r5.priority) goto L17;
        return r5;
    L17:
        return r2;
    }

    public static DrivePriority$UploadPriority valueOf(String r1) {
        return (DrivePriority$UploadPriority) a.a(DrivePriority$UploadPriority.class, r1);
    }

    public DrivePriority$UploadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
