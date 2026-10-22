package com.bytedance.ee.bear.bitable.formpreload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/formpreload/TaskStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "WAIT", "UPLOADING", "SUCCESS", "FAIL", "CANCEL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus CANCEL = null;
    public static final TaskStatus FAIL = null;
    public static final TaskStatus SUCCESS = null;
    public static final TaskStatus UPLOADING = null;
    public static final TaskStatus WAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f212141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212142b = null;

    public static EnumEntries<TaskStatus> getEntries() {
        return f212142b;
    }

    static {
        TaskStatus r100 = new TaskStatus("WAIT", 0);
        WAIT = r100;
        TaskStatus r101 = new TaskStatus("UPLOADING", 1);
        UPLOADING = r101;
        TaskStatus r102 = new TaskStatus("SUCCESS", 2);
        SUCCESS = r102;
        TaskStatus r103 = new TaskStatus("FAIL", 3);
        FAIL = r103;
        TaskStatus r104 = new TaskStatus("CANCEL", 4);
        CANCEL = r104;
        TaskStatus[] r105 = {r100, r101, r102, r103, r104};
        f212141a = r105;
        f212142b = EnumEntriesKt.enumEntries(r105);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f212141a.clone();
    }

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) a.a(TaskStatus.class, r100);
    }

    public TaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
