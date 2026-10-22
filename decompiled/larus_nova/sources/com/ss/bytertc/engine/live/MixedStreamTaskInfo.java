package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamTaskInfo {
    private MixedStreamPushTargetType targetType;
    private String taskId;

    public MixedStreamTaskInfo() {
        this.taskId = "";
        this.targetType = MixedStreamPushTargetType.PUSH_TO_CDN;
    }

    public MixedStreamPushTargetType getTargetType() {
        return this.targetType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public MixedStreamTaskInfo setTargetType(MixedStreamPushTargetType r100) {
        this.targetType = r100;
        return this;
    }

    public MixedStreamTaskInfo setTaskId(String r100) {
        this.taskId = r100;
        return this;
    }

    public static MixedStreamTaskInfo from(String r100, int r101) {
        MixedStreamTaskInfo r102 = new MixedStreamTaskInfo();
        if (r101 != 0) goto L5;
        r102.setTargetType(MixedStreamPushTargetType.PUSH_TO_CDN);
    L9:
        r102.setTaskId(r100);
        return r102;
    L5:
        if (r101 == 1) goto L7;
        r102.setTargetType(MixedStreamPushTargetType.PUSH_TO_CDN);
        goto L9
    L7:
        r102.setTargetType(MixedStreamPushTargetType.PUSH_TO_WTN);
        goto L9
    }
}
