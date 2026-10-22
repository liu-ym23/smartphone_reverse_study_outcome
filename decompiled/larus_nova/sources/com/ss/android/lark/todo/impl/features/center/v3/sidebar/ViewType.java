package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ViewType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HEADER_QUICK_ACCESS", "CONTAINER_ITEM", "HEADER_TASK_LIST", "TASK_LIST_ITEM", "HEADER_ARCHIVE_LIST", "HEADER_TASK_LIST_MANAGE", "HEADER_TASK_LIST_SECTION", "HEADER_CREATE_SECTION", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ViewType extends Enum<ViewType> {
    public static final ViewType CONTAINER_ITEM = null;
    public static final a Companion = null;
    public static final ViewType HEADER_ARCHIVE_LIST = null;
    public static final ViewType HEADER_CREATE_SECTION = null;
    public static final ViewType HEADER_QUICK_ACCESS = null;
    public static final ViewType HEADER_TASK_LIST = null;
    public static final ViewType HEADER_TASK_LIST_MANAGE = null;
    public static final ViewType HEADER_TASK_LIST_SECTION = null;
    public static final ViewType TASK_LIST_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewType[] f441688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441689b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ViewType> getEntries() {
        return f441689b;
    }

    static {
        ViewType r100 = new ViewType("HEADER_QUICK_ACCESS", 0, 0);
        HEADER_QUICK_ACCESS = r100;
        ViewType r101 = new ViewType("CONTAINER_ITEM", 1, 1);
        CONTAINER_ITEM = r101;
        ViewType r102 = new ViewType("HEADER_TASK_LIST", 2, 2);
        HEADER_TASK_LIST = r102;
        ViewType r103 = new ViewType("TASK_LIST_ITEM", 3, 3);
        TASK_LIST_ITEM = r103;
        ViewType r104 = new ViewType("HEADER_ARCHIVE_LIST", 4, 4);
        HEADER_ARCHIVE_LIST = r104;
        ViewType r105 = new ViewType("HEADER_TASK_LIST_MANAGE", 5, 5);
        HEADER_TASK_LIST_MANAGE = r105;
        ViewType r110 = new ViewType("HEADER_TASK_LIST_SECTION", 6, 6);
        HEADER_TASK_LIST_SECTION = r110;
        ViewType r111 = new ViewType("HEADER_CREATE_SECTION", 7, 7);
        HEADER_CREATE_SECTION = r111;
        ViewType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f441688a = r112;
        f441689b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static ViewType[] values() {
        return (ViewType[]) f441688a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ViewType valueOf(String r100) {
        return (ViewType) r27.a.a(ViewType.class, r100);
    }

    public ViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
