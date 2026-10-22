package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/TodoShareTaskListChatType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "CHAT", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TodoShareTaskListChatType extends Enum<TodoShareTaskListChatType> {
    public static final TodoShareTaskListChatType CHAT = null;
    public static final TodoShareTaskListChatType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TodoShareTaskListChatType[] f444152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444153b = null;
    private final String typeName;

    public static EnumEntries<TodoShareTaskListChatType> getEntries() {
        return f444153b;
    }

    static {
        TodoShareTaskListChatType r100 = new TodoShareTaskListChatType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, "user");
        USER = r100;
        TodoShareTaskListChatType r101 = new TodoShareTaskListChatType("CHAT", 1, "chat");
        CHAT = r101;
        TodoShareTaskListChatType[] r102 = {r100, r101};
        f444152a = r102;
        f444153b = EnumEntriesKt.enumEntries(r102);
    }

    public static TodoShareTaskListChatType[] values() {
        return (TodoShareTaskListChatType[]) f444152a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static TodoShareTaskListChatType valueOf(String r100) {
        return (TodoShareTaskListChatType) r27.a.a(TodoShareTaskListChatType.class, r100);
    }

    public TodoShareTaskListChatType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
