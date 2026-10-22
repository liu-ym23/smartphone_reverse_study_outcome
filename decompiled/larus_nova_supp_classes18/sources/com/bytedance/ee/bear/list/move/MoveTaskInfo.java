package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/list/move/MoveTaskInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "taskStatus", "", "getTaskStatus", "()I", "setTaskStatus", "(I)V", "taskType", "getTaskType", "setTaskType", "objType", "getObjType", "()Ljava/lang/Integer;", "setObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "objToken", "getObjToken", "setObjToken", "bizType", "getBizType", "setBizType", "nodeToken", "getNodeToken", "setNodeToken", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoveTaskInfo implements NonProguard {
    private Integer bizType;
    private String nodeToken;
    private String objToken;
    private Integer objType;
    private String taskId;
    private int taskStatus;
    private String taskType;

    public MoveTaskInfo() {
        this.taskId = "";
        this.taskType = "";
    }

    public final Integer getBizType() {
        return this.bizType;
    }

    public final String getNodeToken() {
        return this.nodeToken;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final Integer getObjType() {
        return this.objType;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final void setBizType(Integer r1) {
        this.bizType = r1;
    }

    public final void setNodeToken(String r1) {
        this.nodeToken = r1;
    }

    public final void setObjToken(String r1) {
        this.objToken = r1;
    }

    public final void setObjType(Integer r1) {
        this.objType = r1;
    }

    public final void setTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.taskId = r2;
    }

    public final void setTaskStatus(int r1) {
        this.taskStatus = r1;
    }

    public final void setTaskType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.taskType = r2;
    }
}
