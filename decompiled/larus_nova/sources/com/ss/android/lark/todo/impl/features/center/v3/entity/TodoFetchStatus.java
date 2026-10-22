package com.ss.android.lark.todo.impl.features.center.v3.entity;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoFetchStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "LOADING", "FIRST_PAGE_FAILED", "NEXT_PAGE_FAILED", "SUCCESS", "NO_PERMISSION", "DELETED", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TodoFetchStatus extends Enum<TodoFetchStatus> {
    public static final TodoFetchStatus DELETED = null;
    public static final TodoFetchStatus FIRST_PAGE_FAILED = null;
    public static final TodoFetchStatus LOADING = null;
    public static final TodoFetchStatus NEXT_PAGE_FAILED = null;
    public static final TodoFetchStatus NONE = null;
    public static final TodoFetchStatus NO_PERMISSION = null;
    public static final TodoFetchStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TodoFetchStatus[] f441577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441578b = null;
    private final int value;

    public static EnumEntries<TodoFetchStatus> getEntries() {
        return f441578b;
    }

    static {
        TodoFetchStatus r100 = new TodoFetchStatus(UserProfileEvent.POSITION_NONE, 0, 1);
        NONE = r100;
        TodoFetchStatus r101 = new TodoFetchStatus("LOADING", 1, 2);
        LOADING = r101;
        TodoFetchStatus r102 = new TodoFetchStatus("FIRST_PAGE_FAILED", 2, 3);
        FIRST_PAGE_FAILED = r102;
        TodoFetchStatus r103 = new TodoFetchStatus("NEXT_PAGE_FAILED", 3, 4);
        NEXT_PAGE_FAILED = r103;
        TodoFetchStatus r104 = new TodoFetchStatus("SUCCESS", 4, 5);
        SUCCESS = r104;
        TodoFetchStatus r110 = new TodoFetchStatus("NO_PERMISSION", 5, 6);
        NO_PERMISSION = r110;
        TodoFetchStatus r111 = new TodoFetchStatus("DELETED", 6, 7);
        DELETED = r111;
        TodoFetchStatus[] r112 = {r100, r101, r102, r103, r104, r110, r111};
        f441577a = r112;
        f441578b = EnumEntriesKt.enumEntries(r112);
    }

    public static TodoFetchStatus[] values() {
        return (TodoFetchStatus[]) f441577a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TodoFetchStatus valueOf(String r100) {
        return (TodoFetchStatus) a.a(TodoFetchStatus.class, r100);
    }

    public TodoFetchStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
