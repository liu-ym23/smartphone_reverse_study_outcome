package com.bytedance.ee.bear.list.move.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SpaceMoveToWikiStatusPuller$MoveToWikiStatus extends Enum<SpaceMoveToWikiStatusPuller$MoveToWikiStatus> {
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus ALREADY_EXIST = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus HAVE_NO_PERMISSION = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus MOUNT_EXTEND_LIMIT = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus MOVE_DONE = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus MOVE_FAILED = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus MOVING = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus NOT_SUPPORT_BITABLE = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus NOT_SUPPORT_LABEL = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus NOT_SUPPORT_MOVE_TYPE = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus ORIGIN_DOCUMENT_NOT_EXIST = null;
    public static final SpaceMoveToWikiStatusPuller$MoveToWikiStatus UNKNOWN = null;
    public static final /* synthetic */ SpaceMoveToWikiStatusPuller$MoveToWikiStatus[] a = null;
    private final int status;

    static {
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r0 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r1 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVING", 1, 0);
        MOVING = r1;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r2 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVE_DONE", 2, 1);
        MOVE_DONE = r2;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r5 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVE_FAILED", 3, 2);
        MOVE_FAILED = r5;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r7 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOUNT_EXTEND_LIMIT", 4, 3);
        MOUNT_EXTEND_LIMIT = r7;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r9 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("HAVE_NO_PERMISSION", 5, 4);
        HAVE_NO_PERMISSION = r9;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r11 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_BITABLE", 6, 5);
        NOT_SUPPORT_BITABLE = r11;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r13 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("ALREADY_EXIST", 7, 6);
        ALREADY_EXIST = r13;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r15 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("ORIGIN_DOCUMENT_NOT_EXIST", 8, 7);
        ORIGIN_DOCUMENT_NOT_EXIST = r15;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r14 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_MOVE_TYPE", 9, 8);
        NOT_SUPPORT_MOVE_TYPE = r14;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r12 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_LABEL", 10, 9);
        NOT_SUPPORT_LABEL = r12;
        a = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus[]{r0, r1, r2, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public static SpaceMoveToWikiStatusPuller$MoveToWikiStatus[] values() {
        return (SpaceMoveToWikiStatusPuller$MoveToWikiStatus[]) a.clone();
    }

    public int getStatus() {
        return this.status;
    }

    public static SpaceMoveToWikiStatusPuller$MoveToWikiStatus valueOf(String r1) {
        return (SpaceMoveToWikiStatusPuller$MoveToWikiStatus) r27.a.a(SpaceMoveToWikiStatusPuller$MoveToWikiStatus.class, r1);
    }

    public SpaceMoveToWikiStatusPuller$MoveToWikiStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
