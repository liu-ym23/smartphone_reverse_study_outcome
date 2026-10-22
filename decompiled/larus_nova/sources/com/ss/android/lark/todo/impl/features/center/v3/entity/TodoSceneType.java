package com.ss.android.lark.todo.impl.features.center.v3.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoSceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TODO_UNDEFINED", "SINGLE_MESSAGE", "MULTIPLE_MESSAGES", "MESSAGE_AFTER_FORWARDING", "MESSAGE_TOOLBAR", "INPUT_BOX", "CHAT_TODO_LIST", "TODO_ALL", "TODO_ASSIGIN_FROM_ME", "TODO_ASSIGN_TO_ME", "TODO_COMPLETED", "TODO_FOLLOWED", "TODO_FROM_DOCS", "TASK_LIST", "APPLINK", "INTERFACE", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TodoSceneType extends Enum<TodoSceneType> {
    public static final TodoSceneType APPLINK = null;
    public static final TodoSceneType CHAT_TODO_LIST = null;
    public static final a Companion = null;
    public static final TodoSceneType INPUT_BOX = null;
    public static final TodoSceneType INTERFACE = null;
    public static final TodoSceneType MESSAGE_AFTER_FORWARDING = null;
    public static final TodoSceneType MESSAGE_TOOLBAR = null;
    public static final TodoSceneType MULTIPLE_MESSAGES = null;
    public static final TodoSceneType SINGLE_MESSAGE = null;
    public static final TodoSceneType TASK_LIST = null;
    public static final TodoSceneType TODO_ALL = null;
    public static final TodoSceneType TODO_ASSIGIN_FROM_ME = null;
    public static final TodoSceneType TODO_ASSIGN_TO_ME = null;
    public static final TodoSceneType TODO_COMPLETED = null;
    public static final TodoSceneType TODO_FOLLOWED = null;
    public static final TodoSceneType TODO_FROM_DOCS = null;
    public static final TodoSceneType TODO_UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TodoSceneType[] f441579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441580b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TodoSceneType> getEntries() {
        return f441580b;
    }

    static {
        TodoSceneType r100 = new TodoSceneType("TODO_UNDEFINED", 0, 0);
        TODO_UNDEFINED = r100;
        TodoSceneType r101 = new TodoSceneType("SINGLE_MESSAGE", 1, 1);
        SINGLE_MESSAGE = r101;
        TodoSceneType r102 = new TodoSceneType("MULTIPLE_MESSAGES", 2, 2);
        MULTIPLE_MESSAGES = r102;
        TodoSceneType r103 = new TodoSceneType("MESSAGE_AFTER_FORWARDING", 3, 3);
        MESSAGE_AFTER_FORWARDING = r103;
        TodoSceneType r104 = new TodoSceneType("MESSAGE_TOOLBAR", 4, 4);
        MESSAGE_TOOLBAR = r104;
        TodoSceneType r105 = new TodoSceneType("INPUT_BOX", 5, 5);
        INPUT_BOX = r105;
        TodoSceneType r110 = new TodoSceneType("CHAT_TODO_LIST", 6, 6);
        CHAT_TODO_LIST = r110;
        TodoSceneType r111 = new TodoSceneType("TODO_ALL", 7, 15);
        TODO_ALL = r111;
        TodoSceneType r112 = new TodoSceneType("TODO_ASSIGIN_FROM_ME", 8, 16);
        TODO_ASSIGIN_FROM_ME = r112;
        TodoSceneType r113 = new TodoSceneType("TODO_ASSIGN_TO_ME", 9, 17);
        TODO_ASSIGN_TO_ME = r113;
        TodoSceneType r106 = new TodoSceneType("TODO_COMPLETED", 10, 18);
        TODO_COMPLETED = r106;
        TodoSceneType r107 = new TodoSceneType("TODO_FOLLOWED", 11, 19);
        TODO_FOLLOWED = r107;
        TodoSceneType r108 = new TodoSceneType("TODO_FROM_DOCS", 12, 20);
        TODO_FROM_DOCS = r108;
        TodoSceneType r114 = new TodoSceneType("TASK_LIST", 13, 21);
        TASK_LIST = r114;
        TodoSceneType r109 = new TodoSceneType("APPLINK", 14, 22);
        APPLINK = r109;
        TodoSceneType r115 = new TodoSceneType("INTERFACE", 15, 23);
        INTERFACE = r115;
        TodoSceneType[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r114, r109, r115};
        f441579a = r116;
        f441580b = EnumEntriesKt.enumEntries(r116);
        Companion = new a();
    }

    public static TodoSceneType[] values() {
        return (TodoSceneType[]) f441579a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TodoSceneType valueOf(int r100) {
        Companion.getClass();
        switch(r100) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            default: goto L4;
        };
    L4:
        switch(r100) {
            case 15: goto L21;
            case 16: goto L36;
            case 17: goto L35;
            case 18: goto L34;
            case 19: goto L33;
            case 20: goto L32;
            case 21: goto L31;
            case 22: goto L30;
            case 23: goto L29;
            default: goto L22;
        };
    L22:
        return TODO_UNDEFINED;
    L29:
        return INTERFACE;
    L30:
        return APPLINK;
    L31:
        return TASK_LIST;
    L32:
        return TODO_FROM_DOCS;
    L33:
        return TODO_FOLLOWED;
    L34:
        return TODO_COMPLETED;
    L35:
        return TODO_ASSIGN_TO_ME;
    L36:
        return TODO_ASSIGIN_FROM_ME;
    L21:
        return TODO_ALL;
    L23:
        return CHAT_TODO_LIST;
    L24:
        return INPUT_BOX;
    L25:
        return MESSAGE_TOOLBAR;
    L26:
        return MESSAGE_AFTER_FORWARDING;
    L27:
        return MULTIPLE_MESSAGES;
    L28:
        return SINGLE_MESSAGE;
    }

    public static TodoSceneType valueOf(String r100) {
        return (TodoSceneType) r27.a.a(TodoSceneType.class, r100);
    }

    public TodoSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
