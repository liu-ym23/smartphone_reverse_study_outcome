package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/list/move/MoveTaskCreateResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", DBDefinition.TASK_ID, "", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "taskType", "getTaskType", "setTaskType", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoveTaskCreateResult implements NonProguard {
    private String taskId;
    private String taskType;

    public MoveTaskCreateResult() {
        this.taskId = "";
        this.taskType = "";
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final void setTaskId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskId = r100;
    }

    public final void setTaskType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskType = r100;
    }
}
