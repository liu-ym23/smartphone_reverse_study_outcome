package com.bytedance.flow_audio.impl.core.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/flow_audio/impl/core/task/TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "Started", "Running", "Stopped", "Failed", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus Failed = null;
    public static final TaskStatus Initial = null;
    public static final TaskStatus Running = null;
    public static final TaskStatus Started = null;
    public static final TaskStatus Stopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f244119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f244120b = null;

    public static EnumEntries<TaskStatus> getEntries() {
        return f244120b;
    }

    static {
        TaskStatus r100 = new TaskStatus("Initial", 0);
        Initial = r100;
        TaskStatus r101 = new TaskStatus("Started", 1);
        Started = r101;
        TaskStatus r102 = new TaskStatus("Running", 2);
        Running = r102;
        TaskStatus r103 = new TaskStatus("Stopped", 3);
        Stopped = r103;
        TaskStatus r104 = new TaskStatus("Failed", 4);
        Failed = r104;
        TaskStatus[] r105 = {r100, r101, r102, r103, r104};
        f244119a = r105;
        f244120b = EnumEntriesKt.enumEntries(r105);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f244119a.clone();
    }

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) r27.a.a(TaskStatus.class, r100);
    }

    public TaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
