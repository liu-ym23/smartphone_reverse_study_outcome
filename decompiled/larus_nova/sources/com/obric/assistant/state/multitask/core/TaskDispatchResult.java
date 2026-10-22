package com.obric.assistant.state.multitask.core;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/state/multitask/core/TaskDispatchResult;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "CONSUMED", "INTERCEPTED", "DROPPED", "STALE", ErrorCode.CLOSED, "FAILED", "isSuccess", "", "()Z", "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskDispatchResult extends Enum<TaskDispatchResult> {
    public static final TaskDispatchResult ACCEPTED = null;
    public static final TaskDispatchResult CLOSED = null;
    public static final TaskDispatchResult CONSUMED = null;
    public static final TaskDispatchResult DROPPED = null;
    public static final TaskDispatchResult FAILED = null;
    public static final TaskDispatchResult INTERCEPTED = null;
    public static final TaskDispatchResult STALE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskDispatchResult[] f393280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f393281b = null;

    public static EnumEntries<TaskDispatchResult> getEntries() {
        return f393281b;
    }

    static {
        TaskDispatchResult r100 = new TaskDispatchResult("ACCEPTED", 0);
        ACCEPTED = r100;
        TaskDispatchResult r101 = new TaskDispatchResult("CONSUMED", 1);
        CONSUMED = r101;
        TaskDispatchResult r102 = new TaskDispatchResult("INTERCEPTED", 2);
        INTERCEPTED = r102;
        TaskDispatchResult r103 = new TaskDispatchResult("DROPPED", 3);
        DROPPED = r103;
        TaskDispatchResult r104 = new TaskDispatchResult("STALE", 4);
        STALE = r104;
        TaskDispatchResult r105 = new TaskDispatchResult(ErrorCode.CLOSED, 5);
        CLOSED = r105;
        TaskDispatchResult r110 = new TaskDispatchResult("FAILED", 6);
        FAILED = r110;
        TaskDispatchResult[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f393280a = r111;
        f393281b = EnumEntriesKt.enumEntries(r111);
    }

    public static TaskDispatchResult[] values() {
        return (TaskDispatchResult[]) f393280a.clone();
    }

    public final boolean isSuccess() {
        if (this != ACCEPTED) goto L5;
    L8:
        return true;
    L5:
        if (this == CONSUMED) goto L8;
        return false;
    }

    public static TaskDispatchResult valueOf(String r100) {
        return (TaskDispatchResult) a.a(TaskDispatchResult.class, r100);
    }

    public TaskDispatchResult(String r100, int r101) {
        super(r100, r101);
    }
}
