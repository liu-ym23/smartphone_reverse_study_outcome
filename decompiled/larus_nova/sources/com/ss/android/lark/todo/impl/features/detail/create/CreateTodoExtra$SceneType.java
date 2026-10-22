package com.ss.android.lark.todo.impl.features.detail.create;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/CreateTodoExtra$SceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "THREAD_TOPIC", "THREAD_REPLY", "THREAD_MULTI", "MESSAGE_TOOLBAR", "INPUT_BOX", "CHAT_MULTI", "REPLY_IN_THREAD_TOPIC", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateTodoExtra$SceneType extends Enum<CreateTodoExtra$SceneType> {
    public static final CreateTodoExtra$SceneType CHAT_MULTI = null;
    public static final CreateTodoExtra$SceneType INPUT_BOX = null;
    public static final CreateTodoExtra$SceneType MESSAGE_TOOLBAR = null;
    public static final CreateTodoExtra$SceneType REPLY_IN_THREAD_TOPIC = null;
    public static final CreateTodoExtra$SceneType THREAD_MULTI = null;
    public static final CreateTodoExtra$SceneType THREAD_REPLY = null;
    public static final CreateTodoExtra$SceneType THREAD_TOPIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateTodoExtra$SceneType[] f443030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f443031b = null;
    private final int value;

    public static EnumEntries<CreateTodoExtra$SceneType> getEntries() {
        return f443031b;
    }

    static {
        CreateTodoExtra$SceneType r100 = new CreateTodoExtra$SceneType("THREAD_TOPIC", 0, 1);
        THREAD_TOPIC = r100;
        CreateTodoExtra$SceneType r101 = new CreateTodoExtra$SceneType("THREAD_REPLY", 1, 2);
        THREAD_REPLY = r101;
        CreateTodoExtra$SceneType r102 = new CreateTodoExtra$SceneType("THREAD_MULTI", 2, 3);
        THREAD_MULTI = r102;
        CreateTodoExtra$SceneType r103 = new CreateTodoExtra$SceneType("MESSAGE_TOOLBAR", 3, 4);
        MESSAGE_TOOLBAR = r103;
        CreateTodoExtra$SceneType r104 = new CreateTodoExtra$SceneType("INPUT_BOX", 4, 5);
        INPUT_BOX = r104;
        CreateTodoExtra$SceneType r110 = new CreateTodoExtra$SceneType("CHAT_MULTI", 5, 6);
        CHAT_MULTI = r110;
        CreateTodoExtra$SceneType r111 = new CreateTodoExtra$SceneType("REPLY_IN_THREAD_TOPIC", 6, 7);
        REPLY_IN_THREAD_TOPIC = r111;
        CreateTodoExtra$SceneType[] r112 = {r100, r101, r102, r103, r104, r110, r111};
        f443030a = r112;
        f443031b = EnumEntriesKt.enumEntries(r112);
    }

    public static CreateTodoExtra$SceneType[] values() {
        return (CreateTodoExtra$SceneType[]) f443030a.clone();
    }

    public static CreateTodoExtra$SceneType valueOf(String r100) {
        return (CreateTodoExtra$SceneType) a.a(CreateTodoExtra$SceneType.class, r100);
    }

    public CreateTodoExtra$SceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
