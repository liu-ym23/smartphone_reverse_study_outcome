package com.ss.android.lark.todo.impl.features.center.v3.type;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "OWNED_BY_ME_CONTAINER", "FOLLOWED_BY_ME_CONTAINER", "ALL_RELATION_CONTAINER", "CREATE_FROM_ME_CONTAINER", "ASSIGN_FROM_ME_CONTAINER", "COLLABORATE_WITH_ME_CONTAINER", "COMPLETED_CONTAINER", "TASK_LIST_CONTAINER", "TASK_LIST_MANAGE", "toString", "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType ALL_RELATION_CONTAINER = null;
    public static final ContainerType ASSIGN_FROM_ME_CONTAINER = null;
    public static final ContainerType COLLABORATE_WITH_ME_CONTAINER = null;
    public static final ContainerType COMPLETED_CONTAINER = null;
    public static final ContainerType CREATE_FROM_ME_CONTAINER = null;
    public static final a Companion = null;
    public static final ContainerType FOLLOWED_BY_ME_CONTAINER = null;
    public static final ContainerType OWNED_BY_ME_CONTAINER = null;
    public static final ContainerType TASK_LIST_CONTAINER = null;
    public static final ContainerType TASK_LIST_MANAGE = null;
    public static final ContainerType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f441760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441761b = null;
    private final int value;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5323a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f441762a = null;

            static {
                int[] r100 = new int[ContainerType.values().length];
                r100[ContainerType.OWNED_BY_ME_CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[ContainerType.FOLLOWED_BY_ME_CONTAINER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[ContainerType.ALL_RELATION_CONTAINER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ContainerType.CREATE_FROM_ME_CONTAINER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[ContainerType.ASSIGN_FROM_ME_CONTAINER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[ContainerType.COLLABORATE_WITH_ME_CONTAINER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[ContainerType.COMPLETED_CONTAINER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f441762a = r100;
            }
        }

        public a() {
        }

        public static String a(ContainerType r100) {
            Intrinsics.checkNotNullParameter(r100, "containerType");
            switch(C5323a.f441762a[r100.ordinal()]) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L4;
            };
        L4:
            return "";
        L5:
            return "__container_completed_tasks";
        L6:
            return "__container_collaborated_tasks";
        L7:
            return "__container_assigned_tasks";
        L8:
            return "__container_created_tasks";
        L9:
            return "__container_all_tasks";
        L10:
            return "__container_followed_tasks";
        L11:
            return "__container_owned_tasks";
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441763a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.OWNED_BY_ME_CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ContainerType.FOLLOWED_BY_ME_CONTAINER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ContainerType.ALL_RELATION_CONTAINER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ContainerType.CREATE_FROM_ME_CONTAINER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ContainerType.ASSIGN_FROM_ME_CONTAINER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ContainerType.COLLABORATE_WITH_ME_CONTAINER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ContainerType.COMPLETED_CONTAINER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f441763a = r100;
        }
    }

    public static EnumEntries<ContainerType> getEntries() {
        return f441761b;
    }

    static {
        ContainerType r100 = new ContainerType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ContainerType r101 = new ContainerType("OWNED_BY_ME_CONTAINER", 1, 1);
        OWNED_BY_ME_CONTAINER = r101;
        ContainerType r102 = new ContainerType("FOLLOWED_BY_ME_CONTAINER", 2, 2);
        FOLLOWED_BY_ME_CONTAINER = r102;
        ContainerType r103 = new ContainerType("ALL_RELATION_CONTAINER", 3, 3);
        ALL_RELATION_CONTAINER = r103;
        ContainerType r104 = new ContainerType("CREATE_FROM_ME_CONTAINER", 4, 4);
        CREATE_FROM_ME_CONTAINER = r104;
        ContainerType r105 = new ContainerType("ASSIGN_FROM_ME_CONTAINER", 5, 5);
        ASSIGN_FROM_ME_CONTAINER = r105;
        ContainerType r110 = new ContainerType("COLLABORATE_WITH_ME_CONTAINER", 6, 6);
        COLLABORATE_WITH_ME_CONTAINER = r110;
        ContainerType r111 = new ContainerType("COMPLETED_CONTAINER", 7, 7);
        COMPLETED_CONTAINER = r111;
        ContainerType r112 = new ContainerType("TASK_LIST_CONTAINER", 8, 8);
        TASK_LIST_CONTAINER = r112;
        ContainerType r113 = new ContainerType("TASK_LIST_MANAGE", 9, 9);
        TASK_LIST_MANAGE = r113;
        ContainerType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f441760a = r114;
        f441761b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f441760a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(b.f441763a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        int r100 = R.string.Lark_Legacy_UnknownErr;
    L13:
        return UIHelper.getString(r100);
    L5:
        r100 = R.string.Todo_New_Completed_TabTitle;
        goto L13
    L6:
        r100 = R.string.Todo_New_Collaborating_TabTitle;
        goto L13
    L7:
        r100 = R.string.Todo_New_AssignedByMe_TabTitle;
        goto L13
    L8:
        r100 = R.string.Todo_New_CreatedByMe_TabTitle;
        goto L13
    L9:
        r100 = R.string.Todo_New_AllTasks_TabTitle;
        goto L13
    L10:
        r100 = R.string.Todo_New_SubscribedByMe_TabTitle;
        goto L13
    L11:
        r100 = R.string.Todo_New_OwnedByMe_TabTitle;
        goto L13
    }

    public final int getValue() {
        return this.value;
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) r27.a.a(ContainerType.class, r100);
    }

    public ContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
