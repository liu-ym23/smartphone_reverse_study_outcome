package com.bytedance.ee.bear.list.move.api;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpaceMoveToWikiStatusPuller$MoveToWikiStatus[] f228845a = null;
    private final int status;

    static {
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r100 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r101 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVING", 1, 0);
        MOVING = r101;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r102 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVE_DONE", 2, 1);
        MOVE_DONE = r102;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r103 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOVE_FAILED", 3, 2);
        MOVE_FAILED = r103;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r104 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("MOUNT_EXTEND_LIMIT", 4, 3);
        MOUNT_EXTEND_LIMIT = r104;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r105 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("HAVE_NO_PERMISSION", 5, 4);
        HAVE_NO_PERMISSION = r105;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r110 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_BITABLE", 6, 5);
        NOT_SUPPORT_BITABLE = r110;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r111 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("ALREADY_EXIST", 7, 6);
        ALREADY_EXIST = r111;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r112 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("ORIGIN_DOCUMENT_NOT_EXIST", 8, 7);
        ORIGIN_DOCUMENT_NOT_EXIST = r112;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r113 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_MOVE_TYPE", 9, 8);
        NOT_SUPPORT_MOVE_TYPE = r113;
        SpaceMoveToWikiStatusPuller$MoveToWikiStatus r114 = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus("NOT_SUPPORT_LABEL", 10, 9);
        NOT_SUPPORT_LABEL = r114;
        f228845a = new SpaceMoveToWikiStatusPuller$MoveToWikiStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static SpaceMoveToWikiStatusPuller$MoveToWikiStatus[] values() {
        return (SpaceMoveToWikiStatusPuller$MoveToWikiStatus[]) f228845a.clone();
    }

    public int getStatus() {
        return this.status;
    }

    public static SpaceMoveToWikiStatusPuller$MoveToWikiStatus valueOf(String r100) {
        return (SpaceMoveToWikiStatusPuller$MoveToWikiStatus) r27.a.a(SpaceMoveToWikiStatusPuller$MoveToWikiStatus.class, r100);
    }

    public SpaceMoveToWikiStatusPuller$MoveToWikiStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
