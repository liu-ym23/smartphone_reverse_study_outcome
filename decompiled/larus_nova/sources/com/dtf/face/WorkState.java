package com.dtf.face;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum WorkState extends Enum<WorkState> {
    public static final WorkState FACE_CAPTURED = null;
    public static final WorkState FACE_CAPTURING = null;
    public static final WorkState FACE_CAPTURING_DARK = null;
    public static final WorkState FACE_COMPLETED = null;
    public static final WorkState FAILED = null;
    public static final WorkState INIT = null;
    public static final WorkState PAUSE = null;
    public static final WorkState PHOTINUS = null;
    public static final WorkState RET = null;
    public static final WorkState UPLOADED = null;
    public static final WorkState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkState[] f273630a = null;

    static {
        WorkState r100 = new WorkState(ErrorCode.INIT, 0);
        INIT = r100;
        WorkState r101 = new WorkState("FACE_CAPTURING", 1);
        FACE_CAPTURING = r101;
        WorkState r102 = new WorkState("PAUSE", 2);
        PAUSE = r102;
        WorkState r103 = new WorkState("FACE_CAPTURING_DARK", 3);
        FACE_CAPTURING_DARK = r103;
        WorkState r104 = new WorkState("FACE_CAPTURED", 4);
        FACE_CAPTURED = r104;
        WorkState r105 = new WorkState("FACE_COMPLETED", 5);
        FACE_COMPLETED = r105;
        WorkState r110 = new WorkState("UPLOADING", 6);
        UPLOADING = r110;
        WorkState r111 = new WorkState("UPLOADED", 7);
        UPLOADED = r111;
        WorkState r112 = new WorkState("FAILED", 8);
        FAILED = r112;
        WorkState r113 = new WorkState("PHOTINUS", 9);
        PHOTINUS = r113;
        WorkState r114 = new WorkState("RET", 10);
        RET = r114;
        f273630a = new WorkState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static WorkState[] values() {
        return (WorkState[]) f273630a.clone();
    }

    public static WorkState valueOf(String r100) {
        return (WorkState) a.a(WorkState.class, r100);
    }

    public WorkState(String r100, int r101) {
        super(r100, r101);
    }
}
