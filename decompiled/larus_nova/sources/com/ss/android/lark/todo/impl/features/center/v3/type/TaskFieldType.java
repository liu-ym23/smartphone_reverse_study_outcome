package com.ss.android.lark.todo.impl.features.center.v3.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/TaskFieldType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKOWN", "COMPLETE_STATUS", "ATTACHMENT", "CREATOR", "ASSIGNEE", "ASSIGNER", "COLLABORATOR", "FOLLOWER", "CREATE_TIME", "COMPLETE_TIME", "DELETE_TIME", "UPDATE_TIME", "DUE_TIME", "START_TIME", "SOURCE_TYPE", "SOURCE", "SUB_TASK_PROGRESS", "TASK_GUID", "TASK_NO_SECTION", "TASK_DEFAULT_SECTION", "TASK_DEFAULT_SORT", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskFieldType extends Enum<TaskFieldType> {
    public static final TaskFieldType ASSIGNEE = null;
    public static final TaskFieldType ASSIGNER = null;
    public static final TaskFieldType ATTACHMENT = null;
    public static final TaskFieldType COLLABORATOR = null;
    public static final TaskFieldType COMPLETE_STATUS = null;
    public static final TaskFieldType COMPLETE_TIME = null;
    public static final TaskFieldType CREATE_TIME = null;
    public static final TaskFieldType CREATOR = null;
    public static final a Companion = null;
    public static final TaskFieldType DELETE_TIME = null;
    public static final TaskFieldType DUE_TIME = null;
    public static final TaskFieldType FOLLOWER = null;
    public static final TaskFieldType SOURCE = null;
    public static final TaskFieldType SOURCE_TYPE = null;
    public static final TaskFieldType START_TIME = null;
    public static final TaskFieldType SUB_TASK_PROGRESS = null;
    public static final TaskFieldType TASK_DEFAULT_SECTION = null;
    public static final TaskFieldType TASK_DEFAULT_SORT = null;
    public static final String TASK_DEFAULT_SORT_VALUE = "__task_default_sort";
    public static final TaskFieldType TASK_GUID = null;
    public static final TaskFieldType TASK_NO_SECTION = null;
    public static final String TASK_NO_SECTION_VALUE = "__task_no_section";
    public static final TaskFieldType UNKOWN = null;
    public static final TaskFieldType UPDATE_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskFieldType[] f441770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441771b = null;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5324a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f441772a = null;

            static {
                int[] r100 = new int[TaskFieldType.values().length];
                r100[TaskFieldType.COMPLETE_STATUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
            L67:
                r100[TaskFieldType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
            L79:
                r100[TaskFieldType.CREATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
            L49:
                r100[TaskFieldType.ASSIGNEE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
            L53:
                r100[TaskFieldType.COLLABORATOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
            L61:
                r100[TaskFieldType.FOLLOWER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
            L73:
                r100[TaskFieldType.CREATE_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
            L57:
                r100[TaskFieldType.COMPLETE_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
            L69:
                r100[TaskFieldType.DELETE_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
            L71:
                r100[TaskFieldType.UPDATE_TIME.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
            L45:
                r100[TaskFieldType.DUE_TIME.ordinal()] = 11;     // Catch: NoSuchFieldError -> L34
            L65:
                r100[TaskFieldType.START_TIME.ordinal()] = 12;     // Catch: NoSuchFieldError -> L35
            L77:
                r100[TaskFieldType.SOURCE_TYPE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L36
            L43:
                r100[TaskFieldType.SOURCE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L37
            L55:
                r100[TaskFieldType.SUB_TASK_PROGRESS.ordinal()] = 15;     // Catch: NoSuchFieldError -> L38
            L75:
                r100[TaskFieldType.TASK_GUID.ordinal()] = 16;     // Catch: NoSuchFieldError -> L39
            L47:
                r100[TaskFieldType.TASK_DEFAULT_SECTION.ordinal()] = 17;     // Catch: NoSuchFieldError -> L40
            L51:
                r100[TaskFieldType.TASK_NO_SECTION.ordinal()] = 18;     // Catch: NoSuchFieldError -> L41
            L63:
                r100[TaskFieldType.TASK_DEFAULT_SORT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L42
            L22:
                f441772a = r100;
            }
        }

        public a() {
        }

        public static TaskFieldType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            switch(r100.hashCode()) {
                case -2095338381: goto L82;
                case -1992816381: goto L78;
                case -1902682803: goto L74;
                case -1317976660: goto L70;
                case -1173255561: goto L66;
                case -791378559: goto L62;
                case -769600178: goto L58;
                case -689728261: goto L54;
                case -280779351: goto L50;
                case -231569104: goto L46;
                case 53544161: goto L42;
                case 93474020: goto L38;
                case 93474033: goto L34;
                case 446209179: goto L30;
                case 659397662: goto L26;
                case 695036016: goto L22;
                case 765157171: goto L18;
                case 939665144: goto L14;
                case 1330020959: goto L10;
                case 1790696822: goto L6;
                default: goto L86;
            };
        L6:
            if (r100.equals(TaskFieldType.TASK_DEFAULT_SORT_VALUE) == false) goto L86;
            return TaskFieldType.TASK_DEFAULT_SORT;
        L10:
            if (r100.equals("__field_task_start_time") == false) goto L86;
            return TaskFieldType.START_TIME;
        L14:
            if (r100.equals("__field_task_attachment") == false) goto L86;
            return TaskFieldType.ATTACHMENT;
        L18:
            if (r100.equals("__field_task_follower") == false) goto L86;
            return TaskFieldType.FOLLOWER;
        L22:
            if (r100.equals("__field_task_source") == false) goto L86;
            return TaskFieldType.SOURCE;
        L26:
            if (r100.equals("__field_task_complete_time") == false) goto L86;
            return TaskFieldType.COMPLETE_TIME;
        L30:
            if (r100.equals("__field_task_collaborator") == false) goto L86;
            return TaskFieldType.COLLABORATOR;
        L34:
            if (r100.equals("__field_task_assigner") == false) goto L86;
            return TaskFieldType.ASSIGNER;
        L38:
            if (r100.equals("__field_task_assignee") == false) goto L86;
            return TaskFieldType.ASSIGNEE;
        L42:
            if (r100.equals("__field_task_task_num") == false) goto L86;
            return TaskFieldType.TASK_GUID;
        L46:
            if (r100.equals("__field_task_section") == false) goto L86;
            return TaskFieldType.TASK_DEFAULT_SECTION;
        L50:
            if (r100.equals("__field_task_source_type") == false) goto L86;
            return TaskFieldType.SOURCE_TYPE;
        L54:
            if (r100.equals("__field_task_create_time") == false) goto L86;
            return TaskFieldType.CREATE_TIME;
        L58:
            if (r100.equals("__field_task_update_time") == false) goto L86;
            return TaskFieldType.UPDATE_TIME;
        L62:
            if (r100.equals(TaskFieldType.TASK_NO_SECTION_VALUE) == false) goto L86;
            return TaskFieldType.TASK_NO_SECTION;
        L66:
            if (r100.equals("__field_task_creator") == false) goto L86;
            return TaskFieldType.CREATOR;
        L70:
            if (r100.equals("__field_task_delete_time") == false) goto L86;
            return TaskFieldType.DELETE_TIME;
        L74:
            if (r100.equals("__field_task_due_time") == false) goto L86;
            return TaskFieldType.DUE_TIME;
        L78:
            if (r100.equals("__field_task_complete_status") == false) goto L86;
            return TaskFieldType.COMPLETE_STATUS;
        L82:
            if (r100.equals("__field_task_sub_task_progress") == false) goto L86;
            return TaskFieldType.SUB_TASK_PROGRESS;
        L86:
            return TaskFieldType.UNKOWN;
        }

        public static String b(TaskFieldType r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "fieldType");
            switch(C5324a.f441772a[r100.ordinal()]) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L10;
                case 17: goto L9;
                case 18: goto L7;
                case 19: goto L5;
                default: goto L26;
            };
        L5:
            if (r101 == false) goto L26;
            return TaskFieldType.TASK_DEFAULT_SORT_VALUE;
        L7:
            if (r101 == false) goto L26;
            return TaskFieldType.TASK_NO_SECTION_VALUE;
        L9:
            return "__field_task_section";
        L10:
            return "__field_task_task_num";
        L11:
            return "__field_task_sub_task_progress";
        L12:
            return "__field_task_source";
        L13:
            return "__field_task_source_type";
        L14:
            return "__field_task_start_time";
        L15:
            return "__field_task_due_time";
        L16:
            return "__field_task_update_time";
        L17:
            return "__field_task_delete_time";
        L18:
            return "__field_task_complete_time";
        L19:
            return "__field_task_create_time";
        L20:
            return "__field_task_follower";
        L21:
            return "__field_task_collaborator";
        L22:
            return "__field_task_assignee";
        L23:
            return "__field_task_creator";
        L24:
            return "__field_task_attachment";
        L25:
            return "__field_task_complete_status";
        L26:
            return "";
        }

        public static /* synthetic */ String c(a r100, TaskFieldType r101) {
            r100.getClass();
            return b(r101, false);
        }
    }

    public static EnumEntries<TaskFieldType> getEntries() {
        return f441771b;
    }

    static {
        TaskFieldType r100 = new TaskFieldType("UNKOWN", 0);
        UNKOWN = r100;
        TaskFieldType r101 = new TaskFieldType("COMPLETE_STATUS", 1);
        COMPLETE_STATUS = r101;
        TaskFieldType r102 = new TaskFieldType("ATTACHMENT", 2);
        ATTACHMENT = r102;
        TaskFieldType r103 = new TaskFieldType("CREATOR", 3);
        CREATOR = r103;
        TaskFieldType r104 = new TaskFieldType("ASSIGNEE", 4);
        ASSIGNEE = r104;
        TaskFieldType r105 = new TaskFieldType("ASSIGNER", 5);
        ASSIGNER = r105;
        TaskFieldType r110 = new TaskFieldType("COLLABORATOR", 6);
        COLLABORATOR = r110;
        TaskFieldType r111 = new TaskFieldType("FOLLOWER", 7);
        FOLLOWER = r111;
        TaskFieldType r112 = new TaskFieldType("CREATE_TIME", 8);
        CREATE_TIME = r112;
        TaskFieldType r113 = new TaskFieldType("COMPLETE_TIME", 9);
        COMPLETE_TIME = r113;
        TaskFieldType r114 = new TaskFieldType("DELETE_TIME", 10);
        DELETE_TIME = r114;
        TaskFieldType r115 = new TaskFieldType("UPDATE_TIME", 11);
        UPDATE_TIME = r115;
        TaskFieldType r106 = new TaskFieldType("DUE_TIME", 12);
        DUE_TIME = r106;
        TaskFieldType r107 = new TaskFieldType("START_TIME", 13);
        START_TIME = r107;
        TaskFieldType r108 = new TaskFieldType("SOURCE_TYPE", 14);
        SOURCE_TYPE = r108;
        TaskFieldType r109 = new TaskFieldType("SOURCE", 15);
        SOURCE = r109;
        TaskFieldType r116 = new TaskFieldType("SUB_TASK_PROGRESS", 16);
        SUB_TASK_PROGRESS = r116;
        TaskFieldType r117 = new TaskFieldType("TASK_GUID", 17);
        TASK_GUID = r117;
        TaskFieldType r118 = new TaskFieldType("TASK_NO_SECTION", 18);
        TASK_NO_SECTION = r118;
        TaskFieldType r119 = new TaskFieldType("TASK_DEFAULT_SECTION", 19);
        TASK_DEFAULT_SECTION = r119;
        TaskFieldType r120 = new TaskFieldType("TASK_DEFAULT_SORT", 20);
        TASK_DEFAULT_SORT = r120;
        TaskFieldType[] r121 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
        f441770a = r121;
        f441771b = EnumEntriesKt.enumEntries(r121);
        Companion = new a();
    }

    public static TaskFieldType[] values() {
        return (TaskFieldType[]) f441770a.clone();
    }

    public static TaskFieldType valueOf(String r100) {
        return (TaskFieldType) r27.a.a(TaskFieldType.class, r100);
    }

    public TaskFieldType(String r100, int r101) {
        super(r100, r101);
    }
}
