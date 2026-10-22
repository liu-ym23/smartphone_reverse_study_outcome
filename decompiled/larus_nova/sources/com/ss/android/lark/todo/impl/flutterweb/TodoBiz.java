package com.ss.android.lark.todo.impl.flutterweb;

import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/TodoBiz;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "TaskCenter", "TaskList", "TaskDetail", "TaskActivity", "TaskCreate", "TaskSetting", "TaskAssignee", "RecentFocusDetail", "TaskAgentRecordDetail", "TaskEmpty", "path", "", "getPath", "()Ljava/lang/String;", "webViewPoolConfig", "Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "getWebViewPoolConfig", "()Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "cmlBizType", "getCmlBizType", "scene", "getScene", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TodoBiz extends Enum<TodoBiz> {
    public static final TodoBiz RecentFocusDetail = null;
    public static final TodoBiz TaskActivity = null;
    public static final TodoBiz TaskAgentRecordDetail = null;
    public static final TodoBiz TaskAssignee = null;
    public static final TodoBiz TaskCenter = null;
    public static final TodoBiz TaskCreate = null;
    public static final TodoBiz TaskDetail = null;
    public static final TodoBiz TaskEmpty = null;
    public static final TodoBiz TaskList = null;
    public static final TodoBiz TaskSetting = null;
    public static final TodoBiz Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TodoBiz[] f444126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444127b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444128a = null;

        static {
            int[] r100 = new int[TodoBiz.values().length];
            r100[TodoBiz.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[TodoBiz.TaskCenter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[TodoBiz.TaskList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[TodoBiz.TaskDetail.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[TodoBiz.TaskActivity.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[TodoBiz.TaskCreate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[TodoBiz.TaskSetting.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[TodoBiz.TaskAssignee.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[TodoBiz.RecentFocusDetail.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[TodoBiz.TaskAgentRecordDetail.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[TodoBiz.TaskEmpty.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f444128a = r100;
        }
    }

    public static EnumEntries<TodoBiz> getEntries() {
        return f444127b;
    }

    static {
        TodoBiz r100 = new TodoBiz("Unknown", 0);
        Unknown = r100;
        TodoBiz r101 = new TodoBiz("TaskCenter", 1);
        TaskCenter = r101;
        TodoBiz r102 = new TodoBiz("TaskList", 2);
        TaskList = r102;
        TodoBiz r103 = new TodoBiz("TaskDetail", 3);
        TaskDetail = r103;
        TodoBiz r104 = new TodoBiz("TaskActivity", 4);
        TaskActivity = r104;
        TodoBiz r105 = new TodoBiz("TaskCreate", 5);
        TaskCreate = r105;
        TodoBiz r110 = new TodoBiz("TaskSetting", 6);
        TaskSetting = r110;
        TodoBiz r111 = new TodoBiz("TaskAssignee", 7);
        TaskAssignee = r111;
        TodoBiz r112 = new TodoBiz("RecentFocusDetail", 8);
        RecentFocusDetail = r112;
        TodoBiz r113 = new TodoBiz("TaskAgentRecordDetail", 9);
        TaskAgentRecordDetail = r113;
        TodoBiz r114 = new TodoBiz("TaskEmpty", 10);
        TaskEmpty = r114;
        TodoBiz[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f444126a = r115;
        f444127b = EnumEntriesKt.enumEntries(r115);
    }

    public static TodoBiz[] values() {
        return (TodoBiz[]) f444126a.clone();
    }

    public final String getCmlBizType() {
        if (a.f444128a[ordinal()] != 2) goto L6;
        return ChameleonBizType.BIZ_TODO_TAB.getType();
    L6:
        return ChameleonBizType.BIZ_TODO_PAGE.getType();
    }

    public final String getPath() {
        switch(a.f444128a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            default: goto L5;
        };
    L6:
        return "/task_empty";
    L7:
        return "/task_agent_record_detail";
    L8:
        return "/recent_focus_detail";
    L9:
        return "/task_assignee";
    L10:
        return "/task_setting";
    L11:
        return "/task_create";
    L12:
        return "/task_activity";
    L13:
        return "/task_detail";
    L14:
        return "/task_list";
    L15:
        return "/task_center";
    L16:
        return "/unknown";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String getScene() {
        if (a.f444128a[ordinal()] != 2) goto L5;
        return "tab";
    L5:
        return "page";
    }

    public final WebViewPoolConfig getWebViewPoolConfig() {
        if (a.f444128a[ordinal()] != 2) goto L6;
        return null;
    L6:
        return new WebViewPoolConfig(0, 0, Integer.MAX_VALUE, 0, 3, null);
    }

    public static TodoBiz valueOf(String r100) {
        return (TodoBiz) r27.a.a(TodoBiz.class, r100);
    }

    public TodoBiz(String r100, int r101) {
        super(r100, r101);
    }
}
