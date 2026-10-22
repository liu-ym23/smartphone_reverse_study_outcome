package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/message/block/TaskCardActionStage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "THINKING", "COMPUTER_BROWSER", "LARK_AUTH", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskCardActionStage extends Enum<TaskCardActionStage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TaskCardActionStage[] $VALUES = null;
    public static final TaskCardActionStage COMPUTER_BROWSER = null;
    public static final TaskCardActionStage DEFAULT = null;
    public static final TaskCardActionStage LARK_AUTH = null;
    public static final TaskCardActionStage THINKING = null;
    private final int value;

    private static final /* synthetic */ TaskCardActionStage[] $values() {
        return new TaskCardActionStage[]{DEFAULT, THINKING, COMPUTER_BROWSER, LARK_AUTH};
    }

    public static EnumEntries<TaskCardActionStage> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new TaskCardActionStage("DEFAULT", 0, 0);
        THINKING = new TaskCardActionStage("THINKING", 1, 1);
        COMPUTER_BROWSER = new TaskCardActionStage("COMPUTER_BROWSER", 2, 2);
        LARK_AUTH = new TaskCardActionStage("LARK_AUTH", 3, 3);
        TaskCardActionStage[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TaskCardActionStage[] values() {
        return (TaskCardActionStage[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskCardActionStage valueOf(String r100) {
        return (TaskCardActionStage) a.a(TaskCardActionStage.class, r100);
    }

    private TaskCardActionStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
