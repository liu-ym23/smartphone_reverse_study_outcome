package com.ss.android.lark.todo.impl.features.center.v3.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/TaskViewType;", "", "<init>", "(Ljava/lang/String;I)V", "TABLE_VIEW", "KANBAN_VIEW", "GANTT_VIEW", "CALENDAR_VIEW", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskViewType extends Enum<TaskViewType> {
    public static final TaskViewType CALENDAR_VIEW = null;
    public static final TaskViewType GANTT_VIEW = null;
    public static final TaskViewType KANBAN_VIEW = null;
    public static final TaskViewType TABLE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskViewType[] f441773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441774b = null;

    public static EnumEntries<TaskViewType> getEntries() {
        return f441774b;
    }

    static {
        TaskViewType r100 = new TaskViewType("TABLE_VIEW", 0);
        TABLE_VIEW = r100;
        TaskViewType r101 = new TaskViewType("KANBAN_VIEW", 1);
        KANBAN_VIEW = r101;
        TaskViewType r102 = new TaskViewType("GANTT_VIEW", 2);
        GANTT_VIEW = r102;
        TaskViewType r103 = new TaskViewType("CALENDAR_VIEW", 3);
        CALENDAR_VIEW = r103;
        TaskViewType[] r104 = {r100, r101, r102, r103};
        f441773a = r104;
        f441774b = EnumEntriesKt.enumEntries(r104);
    }

    public static TaskViewType[] values() {
        return (TaskViewType[]) f441773a.clone();
    }

    public static TaskViewType valueOf(String r100) {
        return (TaskViewType) a.a(TaskViewType.class, r100);
    }

    public TaskViewType(String r100, int r101) {
        super(r100, r101);
    }
}
