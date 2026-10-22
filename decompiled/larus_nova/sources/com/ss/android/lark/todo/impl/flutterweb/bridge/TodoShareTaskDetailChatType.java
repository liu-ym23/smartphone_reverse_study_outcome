package com.ss.android.lark.todo.impl.flutterweb.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/TodoShareTaskDetailChatType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "CHAT", "THREAD", "THREAD_REPLY", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TodoShareTaskDetailChatType extends Enum<TodoShareTaskDetailChatType> {
    public static final TodoShareTaskDetailChatType CHAT = null;
    public static final TodoShareTaskDetailChatType THREAD = null;
    public static final TodoShareTaskDetailChatType THREAD_REPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TodoShareTaskDetailChatType[] f444149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444150b = null;
    private final String typeName;

    public static EnumEntries<TodoShareTaskDetailChatType> getEntries() {
        return f444150b;
    }

    static {
        TodoShareTaskDetailChatType r100 = new TodoShareTaskDetailChatType("CHAT", 0, "chat");
        CHAT = r100;
        TodoShareTaskDetailChatType r101 = new TodoShareTaskDetailChatType("THREAD", 1, "thread");
        THREAD = r101;
        TodoShareTaskDetailChatType r102 = new TodoShareTaskDetailChatType("THREAD_REPLY", 2, "threadReply");
        THREAD_REPLY = r102;
        TodoShareTaskDetailChatType[] r103 = {r100, r101, r102};
        f444149a = r103;
        f444150b = EnumEntriesKt.enumEntries(r103);
    }

    public static TodoShareTaskDetailChatType[] values() {
        return (TodoShareTaskDetailChatType[]) f444149a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static TodoShareTaskDetailChatType valueOf(String r100) {
        return (TodoShareTaskDetailChatType) r27.a.a(TodoShareTaskDetailChatType.class, r100);
    }

    public TodoShareTaskDetailChatType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
