package com.bytedance.locallife.poi.newdetail.task;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/task/TaskStatus;", "", "", "value", "I", "getValue", "()I", "FAIL", "NOT_KNOWN", "SUCCESS", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus FAIL = null;
    public static final TaskStatus NOT_KNOWN = null;
    public static final TaskStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f263297a = null;
    private final int value;

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) a.a(TaskStatus.class, r100);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f263297a.clone();
    }

    static {
        TaskStatus r100 = new TaskStatus("FAIL", 0, -1);
        FAIL = r100;
        TaskStatus r101 = new TaskStatus("NOT_KNOWN", 1, 0);
        NOT_KNOWN = r101;
        TaskStatus r102 = new TaskStatus("SUCCESS", 2, 1);
        SUCCESS = r102;
        f263297a = new TaskStatus[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public TaskStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public /* synthetic */ TaskStatus(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
