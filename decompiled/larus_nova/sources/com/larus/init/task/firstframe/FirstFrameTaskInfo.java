package com.larus.init.task.firstframe;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/larus/init/task/firstframe/FirstFrameTaskInfo;", "Ljava/io/Serializable;", "", "realPriority", "", "task", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "taskName", "", "workThread", "canUseBoostExecutor", "", "<init>", "(ILcom/larus/init/task/firstframe/IFirstFrameTask;Ljava/lang/String;IZ)V", "getRealPriority", "()I", "getTask", "()Lcom/larus/init/task/firstframe/IFirstFrameTask;", "getTaskName", "()Ljava/lang/String;", "getWorkThread", "getCanUseBoostExecutor", "()Z", "compareTo", "other", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirstFrameTaskInfo implements Serializable, Comparable<FirstFrameTaskInfo> {
    private final boolean canUseBoostExecutor;
    private final int realPriority;
    private final m task;
    private final String taskName;
    private final int workThread;

    public final boolean getCanUseBoostExecutor() {
        return this.canUseBoostExecutor;
    }

    public final int getRealPriority() {
        return this.realPriority;
    }

    public final m getTask() {
        return this.task;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final int getWorkThread() {
        return this.workThread;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FirstFrameTaskInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return Intrinsics.compare(r100.realPriority, this.realPriority);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FirstFrameTaskInfo r100) {
        return compareTo2(r100);
    }

    public FirstFrameTaskInfo(int r100, m r101, String r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r102, "taskName");
        this.realPriority = r100;
        this.task = r101;
        this.taskName = r102;
        this.workThread = r103;
        this.canUseBoostExecutor = r104;
    }

    public /* synthetic */ FirstFrameTaskInfo(int r100, m r101, String r110, int r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r113 & 8) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r113 & 16) == 0) goto L13;
        boolean r104 = false;
    L14:
        this(r102, r101, r110, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
