package com.ss.android.lark.todo.impl.features.tasklist.events.item;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/events/item/TaskListEventPayLoadType;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT_TARGET_TYPE", "EVENT_TARGET_NAME", "EVENT_OPERATOR", "EVENT_TITLE", "EVENT_DESCRIPTION", "EVENT_CONTENT", "EVENT_TIME_STR", "EVENT_ATTACHMENTS", "EVENT_FILE_ATTACHMENTS", "EVENT_ITEM_CLICK", "EVENT_BACKGROUND", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskListEventPayLoadType extends Enum<TaskListEventPayLoadType> {
    public static final TaskListEventPayLoadType EVENT_ATTACHMENTS = null;
    public static final TaskListEventPayLoadType EVENT_BACKGROUND = null;
    public static final TaskListEventPayLoadType EVENT_CONTENT = null;
    public static final TaskListEventPayLoadType EVENT_DESCRIPTION = null;
    public static final TaskListEventPayLoadType EVENT_FILE_ATTACHMENTS = null;
    public static final TaskListEventPayLoadType EVENT_ITEM_CLICK = null;
    public static final TaskListEventPayLoadType EVENT_OPERATOR = null;
    public static final TaskListEventPayLoadType EVENT_TARGET_NAME = null;
    public static final TaskListEventPayLoadType EVENT_TARGET_TYPE = null;
    public static final TaskListEventPayLoadType EVENT_TIME_STR = null;
    public static final TaskListEventPayLoadType EVENT_TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskListEventPayLoadType[] f444077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444078b = null;

    public static EnumEntries<TaskListEventPayLoadType> getEntries() {
        return f444078b;
    }

    static {
        TaskListEventPayLoadType r100 = new TaskListEventPayLoadType("EVENT_TARGET_TYPE", 0);
        EVENT_TARGET_TYPE = r100;
        TaskListEventPayLoadType r101 = new TaskListEventPayLoadType("EVENT_TARGET_NAME", 1);
        EVENT_TARGET_NAME = r101;
        TaskListEventPayLoadType r102 = new TaskListEventPayLoadType("EVENT_OPERATOR", 2);
        EVENT_OPERATOR = r102;
        TaskListEventPayLoadType r103 = new TaskListEventPayLoadType("EVENT_TITLE", 3);
        EVENT_TITLE = r103;
        TaskListEventPayLoadType r104 = new TaskListEventPayLoadType("EVENT_DESCRIPTION", 4);
        EVENT_DESCRIPTION = r104;
        TaskListEventPayLoadType r105 = new TaskListEventPayLoadType("EVENT_CONTENT", 5);
        EVENT_CONTENT = r105;
        TaskListEventPayLoadType r110 = new TaskListEventPayLoadType("EVENT_TIME_STR", 6);
        EVENT_TIME_STR = r110;
        TaskListEventPayLoadType r111 = new TaskListEventPayLoadType("EVENT_ATTACHMENTS", 7);
        EVENT_ATTACHMENTS = r111;
        TaskListEventPayLoadType r112 = new TaskListEventPayLoadType("EVENT_FILE_ATTACHMENTS", 8);
        EVENT_FILE_ATTACHMENTS = r112;
        TaskListEventPayLoadType r113 = new TaskListEventPayLoadType("EVENT_ITEM_CLICK", 9);
        EVENT_ITEM_CLICK = r113;
        TaskListEventPayLoadType r114 = new TaskListEventPayLoadType("EVENT_BACKGROUND", 10);
        EVENT_BACKGROUND = r114;
        TaskListEventPayLoadType[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f444077a = r115;
        f444078b = EnumEntriesKt.enumEntries(r115);
    }

    public static TaskListEventPayLoadType[] values() {
        return (TaskListEventPayLoadType[]) f444077a.clone();
    }

    public static TaskListEventPayLoadType valueOf(String r100) {
        return (TaskListEventPayLoadType) r27.a.a(TaskListEventPayLoadType.class, r100);
    }

    public TaskListEventPayLoadType(String r100, int r101) {
        super(r100, r101);
    }
}
