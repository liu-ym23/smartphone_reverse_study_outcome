package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TaskDependentRef;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoItemPermission;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004:\u0001}B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010y\u001a\u00020\u0002H\u0016J\u000e\u0010z\u001a\u00020{2\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010|\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001a\u00108\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R\u001a\u0010;\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R\u001a\u0010>\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R\u001a\u0010A\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010\u0019R\u001a\u0010D\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0017\"\u0004\bF\u0010\u0019R\u001a\u0010G\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010 \"\u0004\bI\u0010\"R \u0010J\u001a\b\u0012\u0004\u0012\u00020K0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010,\"\u0004\bM\u0010.R \u0010N\u001a\b\u0012\u0004\u0012\u00020O0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010,\"\u0004\bQ\u0010.R\u001a\u0010R\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010%\"\u0004\bS\u0010'R\u001a\u0010T\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\\0[j\b\u0012\u0004\u0012\u00020\\`]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bb\u0010%R\u001a\u0010c\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010%\"\u0004\bd\u0010'R\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR*\u0010k\u001a\u0012\u0012\u0004\u0012\u00020l0[j\b\u0012\u0004\u0012\u00020l`]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010_\"\u0004\bn\u0010aR(\u0010p\u001a\u0004\u0018\u00010K2\b\u0010o\u001a\u0004\u0018\u00010K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010\u0007¨\u0006~"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/SimpleSubTodoData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "Lcom/larksuite/framework/section/IActionData;", "Ljava/io/Serializable;", IOfflineExtraParser.ParserType.TODO, "<init>", "(Lcom/bytedance/lark/pb/todo/v1/Todo;)V", "builder", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/SimpleSubTodoData$Builder;", "(Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/SimpleSubTodoData$Builder;)V", "summary", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;", "getSummary", "()Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;", "setSummary", "(Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;)V", "description", "getDescription", "setDescription", "dueTimeMillis", "", "getDueTimeMillis", "()J", "setDueTimeMillis", "(J)V", "startTimeMillis", "getStartTimeMillis", "setStartTimeMillis", "dueTimeZone", "", "getDueTimeZone", "()Ljava/lang/String;", "setDueTimeZone", "(Ljava/lang/String;)V", "isAllDay", "", "()Z", "setAllDay", "(Z)V", "reminders", "", "Lcom/bytedance/lark/pb/todo/v1/TodoReminder;", "getReminders", "()Ljava/util/List;", "setReminders", "(Ljava/util/List;)V", "rrule", "getRrule", "setRrule", "rruleText", "getRruleText", "setRruleText", "guid", "getGuid", "setGuid", "completedMilliTime", "getCompletedMilliTime", "setCompletedMilliTime", "displayCompletedMilliTime", "getDisplayCompletedMilliTime", "setDisplayCompletedMilliTime", "createMilliTime", "getCreateMilliTime", "setCreateMilliTime", "deletedMilliTime", "getDeletedMilliTime", "setDeletedMilliTime", "hiddenMilliTime", "getHiddenMilliTime", "setHiddenMilliTime", "creatorId", "getCreatorId", "setCreatorId", "assignees", "Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "getAssignees", "setAssignees", "followers", "Lcom/bytedance/lark/pb/todo/v1/TodoFollower;", "getFollowers", "setFollowers", "isInCreate", "setInCreate", "mode", "Lcom/bytedance/lark/pb/todo/v1/TaskMode;", "getMode", "()Lcom/bytedance/lark/pb/todo/v1/TaskMode;", "setMode", "(Lcom/bytedance/lark/pb/todo/v1/TaskMode;)V", "attachments", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/todo/v1/TodoAttachment;", "Lkotlin/collections/ArrayList;", "getAttachments", "()Ljava/util/ArrayList;", "setAttachments", "(Ljava/util/ArrayList;)V", "isComplete", "isMileStone", "setMileStone", "selfPermission", "Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;", "getSelfPermission", "()Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;", "setSelfPermission", "(Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;)V", "dependentRefs", "Lcom/bytedance/lark/pb/todo/v1/TaskDependentRef;", "getDependentRefs", "setDependentRefs", "value", "owner", "getOwner", "()Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "setOwner", "(Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;)V", "pbData", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/Todo;", "setPbData", "parseToPb", "updateFromPbData", "", "newBuilder", "Builder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleSubTodoData implements com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a<Todo>, com.larksuite.framework.section.b, Serializable {
    private List<TodoAssignee> assignees;
    private ArrayList<TodoAttachment> attachments;
    private long completedMilliTime;
    private long createMilliTime;
    private String creatorId;
    private long deletedMilliTime;
    private ArrayList<TaskDependentRef> dependentRefs;
    private TodoRichContent description;
    private long displayCompletedMilliTime;
    private long dueTimeMillis;
    private String dueTimeZone;
    private List<TodoFollower> followers;
    private String guid;
    private long hiddenMilliTime;
    private boolean isAllDay;
    private boolean isInCreate;
    private boolean isMileStone;
    private TaskMode mode;
    private Todo pbData;
    private List<TodoReminder> reminders;
    private String rrule;
    private String rruleText;
    private TodoItemPermission selfPermission;
    private long startTimeMillis;
    private TodoRichContent summary;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TodoRichContent f443820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TodoRichContent f443821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f443822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f443823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f443824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f443825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<TodoReminder> f443826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f443827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f443828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<TodoAssignee> f443829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<TodoAttachment> f443830k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public TaskMode f443831l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f443832m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public TodoItemPermission f443833n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<TaskDependentRef> f443834o;

        public final SimpleSubTodoData a() {
            return new SimpleSubTodoData(this, null);
        }

        public final a b() {
            a r100 = new a();
            r100.c(this.f443820a.getRichText());
            RichText r101 = this.f443821b.getRichText();
            Intrinsics.checkNotNullParameter(r101, "richText");
            r100.f443821b.setRichText(r101);
            r100.f443822c = this.f443822c;
            r100.f443823d = this.f443823d;
            r100.f443825f = this.f443825f;
            List<TodoReminder> r102 = this.f443826g;
            Intrinsics.checkNotNullParameter(r102, "reminders");
            r100.f443826g = r102;
            String r103 = this.f443827h;
            Intrinsics.checkNotNullParameter(r103, "rrule");
            r100.f443827h = r103;
            String r104 = this.f443828i;
            Intrinsics.checkNotNullParameter(r104, "rruleText");
            r100.f443828i = r104;
            List<TodoAssignee> r105 = this.f443829j;
            Intrinsics.checkNotNullParameter(r105, "assignees");
            r100.f443829j = r105;
            TaskMode r106 = this.f443831l;
            Intrinsics.checkNotNullParameter(r106, "mode");
            r100.f443831l = r106;
            List<TodoAttachment> r107 = this.f443830k;
            Intrinsics.checkNotNullParameter(r107, "attachments");
            r100.f443830k = r107;
            r100.f443832m = this.f443832m;
            r100.f443833n = this.f443833n;
            List<TaskDependentRef> r108 = this.f443834o;
            Intrinsics.checkNotNullParameter(r108, "dependents");
            r100.f443834o = r108;
            return r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            boolean r100 = false;
            int r101 = 2;
            this.f443820a = new TodoRichContent(null, r100, r101, 0 == true ? 1 : 0);
            this.f443821b = new TodoRichContent(0 == true ? 1 : 0, r100, r101, 0 == true ? 1 : 0);
            this.f443824e = TimeZone.getDefault().getID();
            this.f443826g = new ArrayList();
            this.f443827h = "";
            this.f443828i = "";
            this.f443829j = new ArrayList();
            this.f443830k = new ArrayList();
            this.f443831l = TaskMode.TASK_COMPLETE;
            this.f443834o = new ArrayList();
        }

        public final void c(RichText r100) {
            Intrinsics.checkNotNullParameter(r100, "richText");
            this.f443820a.setRichText(r100);
        }
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    public final TodoAssignee getOwner() {
        List<TodoAssignee> r100 = this.assignees;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return null;
    L12:
        return (TodoAssignee) ListProtector.get(this.assignees, 0);
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isComplete() {
        if (this.displayCompletedMilliTime <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final a newBuilder() {
        a r100 = new a();
        r100.c(this.summary.getRichText());
        RichText r101 = this.description.getRichText();
        Intrinsics.checkNotNullParameter(r101, "richText");
        r100.f443821b.setRichText(r101);
        r100.f443822c = this.dueTimeMillis;
        r100.f443823d = this.startTimeMillis;
        String r102 = this.dueTimeZone;
        Intrinsics.checkNotNullParameter(r102, "dueTimeZone");
        r100.f443824e = r102;
        r100.f443825f = this.isAllDay;
        List<TodoReminder> r103 = this.reminders;
        Intrinsics.checkNotNullParameter(r103, "reminders");
        r100.f443826g = r103;
        String r104 = this.rrule;
        Intrinsics.checkNotNullParameter(r104, "rrule");
        r100.f443827h = r104;
        String r105 = this.rruleText;
        Intrinsics.checkNotNullParameter(r105, "rruleText");
        r100.f443828i = r105;
        List<TodoAssignee> r106 = this.assignees;
        Intrinsics.checkNotNullParameter(r106, "assignees");
        r100.f443829j = r106;
        ArrayList<TodoAttachment> r107 = this.attachments;
        Intrinsics.checkNotNullParameter(r107, "attachments");
        r100.f443830k = r107;
        TaskMode r108 = this.mode;
        Intrinsics.checkNotNullParameter(r108, "mode");
        r100.f443831l = r108;
        r100.f443832m = this.isMileStone;
        r100.f443833n = this.selfPermission;
        ArrayList<TaskDependentRef> r109 = this.dependentRefs;
        Intrinsics.checkNotNullParameter(r109, "dependents");
        r100.f443834o = r109;
        return r100;
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8683getPbData() {
        return getPbData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public Todo parseToPb() {
        Todo r100 = getPbData();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new Todo.Builder().rich_summary(this.summary.parseToPb()).rich_description(this.description.parseToPb()).due_time(Long.valueOf(this.dueTimeMillis / ((long) 1000))).start_milli_time(Long.valueOf(this.startTimeMillis)).is_all_day(Boolean.valueOf(this.isAllDay)).reminders(this.reminders).rrule(this.rrule).creator_id(this.creatorId).assignees(this.assignees).followers(this.followers).guid(this.guid).mode(this.mode).attachments(this.attachments).is_milestone(Boolean.valueOf(this.isMileStone)).self_permission(this.selfPermission).dependents(this.dependentRefs).build();
    }

    public final List<TodoAssignee> getAssignees() {
        return this.assignees;
    }

    public final ArrayList<TodoAttachment> getAttachments() {
        return this.attachments;
    }

    public final long getCompletedMilliTime() {
        return this.completedMilliTime;
    }

    public final long getCreateMilliTime() {
        return this.createMilliTime;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final long getDeletedMilliTime() {
        return this.deletedMilliTime;
    }

    public final ArrayList<TaskDependentRef> getDependentRefs() {
        return this.dependentRefs;
    }

    public final TodoRichContent getDescription() {
        return this.description;
    }

    public final long getDisplayCompletedMilliTime() {
        return this.displayCompletedMilliTime;
    }

    public final long getDueTimeMillis() {
        return this.dueTimeMillis;
    }

    public final String getDueTimeZone() {
        return this.dueTimeZone;
    }

    public final List<TodoFollower> getFollowers() {
        return this.followers;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final long getHiddenMilliTime() {
        return this.hiddenMilliTime;
    }

    public final TaskMode getMode() {
        return this.mode;
    }

    public final List<TodoReminder> getReminders() {
        return this.reminders;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final String getRruleText() {
        return this.rruleText;
    }

    public final TodoItemPermission getSelfPermission() {
        return this.selfPermission;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    public final TodoRichContent getSummary() {
        return this.summary;
    }

    public final boolean isAllDay() {
        return this.isAllDay;
    }

    public final boolean isInCreate() {
        return this.isInCreate;
    }

    public final boolean isMileStone() {
        return this.isMileStone;
    }

    public Todo getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ Todo parseToPb() {
        return parseToPb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleSubTodoData(Todo r110) {
        Intrinsics.checkNotNullParameter(r110, IOfflineExtraParser.ParserType.TODO);
        Object[] r100 = 0;
        Object[] r101 = 0;
        boolean r102 = false;
        int r103 = 2;
        this.summary = new TodoRichContent(null, r102, r103, 0 == true ? 1 : 0);
        this.description = new TodoRichContent(0 == true ? 1 : 0, r102, r103, 0 == true ? 1 : 0);
        this.dueTimeZone = TimeZone.getDefault().getID();
        this.reminders = new ArrayList();
        String r104 = "";
        this.rrule = "";
        this.rruleText = "";
        this.guid = UUID.randomUUID().toString();
        this.creatorId = TodoDependencyHolder.a().loginDependency().getUserId();
        this.assignees = new ArrayList();
        this.followers = new ArrayList();
        TaskMode r105 = TaskMode.TASK_COMPLETE;
        this.mode = r105;
        this.attachments = new ArrayList();
        this.dependentRefs = new ArrayList();
        setPbData(r110);
        String r106 = r110.guid;
        if (r106 != null) goto L5;
        r106 = UUID.randomUUID().toString();
    L5:
        this.guid = r106;
        this.summary = new TodoRichContent(r110.rich_summary, r102, r103, r101 == true ? 1 : 0);
        this.description = new TodoRichContent(r110.rich_description, r102, r103, r100 == true ? 1 : 0);
        Long r107 = r110.due_time;
        long r108 = 0;
        if (r107 == null) goto L8;
        long r109 = r107.longValue();
    L9:
        this.dueTimeMillis = r109 * ((long) 1000);
        Long r111 = r110.start_milli_time;
        if (r111 == null) goto L12;
        long r112 = r111.longValue();
    L13:
        this.startTimeMillis = r112;
        Boolean r113 = r110.is_all_day;
        if (r113 == null) goto L16;
        boolean r114 = r113.booleanValue();
    L17:
        this.isAllDay = r114;
        List<TodoReminder> r115 = r110.reminders;
        if (r115 != null) goto L20;
        r115 = new ArrayList();
    L20:
        this.reminders = r115;
        String r116 = r110.rrule;
        if (r116 == null) goto L24;
        r104 = r116;
    L24:
        this.rrule = r104;
        Long r117 = r110.completed_milli_time;
        if (r117 == null) goto L27;
        long r118 = r117.longValue();
    L28:
        this.completedMilliTime = r118;
        Long r119 = r110.display_completed_milli_time;
        if (r119 == null) goto L31;
        long r120 = r119.longValue();
    L32:
        this.displayCompletedMilliTime = r120;
        Long r121 = r110.deleted_milli_time;
        if (r121 == null) goto L35;
        long r122 = r121.longValue();
    L36:
        this.deletedMilliTime = r122;
        Long r123 = r110.hidden_milli_time;
        if (r123 == null) goto L39;
        long r124 = r123.longValue();
    L40:
        this.hiddenMilliTime = r124;
        String r125 = r110.creator_id;
        if (r125 != null) goto L43;
        r125 = TodoDependencyHolder.a().loginDependency().getUserId();
    L43:
        this.creatorId = r125;
        List<TodoFollower> r126 = r110.followers;
        if (r126 != null) goto L46;
        r126 = new ArrayList();
    L46:
        this.followers = r126;
        List<TodoAssignee> r127 = r110.assignees;
        if (r127 != null) goto L49;
        r127 = new ArrayList();
    L49:
        this.assignees = r127;
        TaskMode r128 = r110.mode;
        if (r128 == null) goto L53;
        r105 = r128;
    L53:
        this.mode = r105;
        this.attachments = new ArrayList(r110.attachments);
        Long r129 = r110.create_milli_time;
        if (r129 == null) goto L56;
        r108 = r129.longValue();
    L56:
        this.createMilliTime = r108;
        Boolean r130 = r110.is_milestone;
        if (r130 == null) goto L59;
        r102 = r130.booleanValue();
    L59:
        this.isMileStone = r102;
        this.selfPermission = r110.self_permission;
        this.dependentRefs = new ArrayList(r110.dependents);
        return;
    L39:
        r124 = 0;
        goto L40
    L35:
        r122 = 0;
        goto L36
    L31:
        r120 = 0;
        goto L32
    L27:
        r118 = 0;
        goto L28
    L16:
        r114 = false;
        goto L17
    L12:
        r112 = 0;
        goto L13
    L8:
        r109 = 0;
        goto L9
    }

    public final void setAllDay(boolean r100) {
        this.isAllDay = r100;
    }

    public final void setAssignees(List<TodoAssignee> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assignees = r100;
    }

    public final void setAttachments(ArrayList<TodoAttachment> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attachments = r100;
    }

    public final void setCompletedMilliTime(long r100) {
        this.completedMilliTime = r100;
    }

    public final void setCreateMilliTime(long r100) {
        this.createMilliTime = r100;
    }

    public final void setCreatorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.creatorId = r100;
    }

    public final void setDeletedMilliTime(long r100) {
        this.deletedMilliTime = r100;
    }

    public final void setDependentRefs(ArrayList<TaskDependentRef> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dependentRefs = r100;
    }

    public final void setDescription(TodoRichContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setDisplayCompletedMilliTime(long r100) {
        this.displayCompletedMilliTime = r100;
    }

    public final void setDueTimeMillis(long r100) {
        this.dueTimeMillis = r100;
    }

    public final void setDueTimeZone(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dueTimeZone = r100;
    }

    public final void setFollowers(List<TodoFollower> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.followers = r100;
    }

    public final void setGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.guid = r100;
    }

    public final void setHiddenMilliTime(long r100) {
        this.hiddenMilliTime = r100;
    }

    public final void setInCreate(boolean r100) {
        this.isInCreate = r100;
    }

    public final void setMileStone(boolean r100) {
        this.isMileStone = r100;
    }

    public final void setMode(TaskMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }

    public final void setOwner(TodoAssignee r100) {
        if (r100 != null) goto L4;
        this.assignees.clear();
        return;
    L4:
        this.assignees.clear();
        this.assignees.add(r100);
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((Todo) r100);
    }

    public final void setReminders(List<TodoReminder> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reminders = r100;
    }

    public final void setRrule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rrule = r100;
    }

    public final void setRruleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rruleText = r100;
    }

    public final void setSelfPermission(TodoItemPermission r100) {
        this.selfPermission = r100;
    }

    public final void setStartTimeMillis(long r100) {
        this.startTimeMillis = r100;
    }

    public final void setSummary(TodoRichContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.summary = r100;
    }

    public final void updateFromPbData(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
        setPbData(r100);
        this.guid = r100.guid;
        boolean r101 = false;
        int r102 = 2;
        DefaultConstructorMarker r103 = null;
        this.summary = new TodoRichContent(r100.rich_summary, r101, r102, r103);
        this.description = new TodoRichContent(r100.rich_description, r101, r102, r103);
        this.dueTimeMillis = r100.due_time.longValue() * ((long) 1000);
        this.startTimeMillis = r100.start_milli_time.longValue();
        this.isAllDay = r100.is_all_day.booleanValue();
        this.reminders = r100.reminders;
        this.rrule = r100.rrule;
        this.completedMilliTime = r100.completed_milli_time.longValue();
        this.displayCompletedMilliTime = r100.display_completed_milli_time.longValue();
        this.deletedMilliTime = r100.deleted_milli_time.longValue();
        this.hiddenMilliTime = r100.hidden_milli_time.longValue();
        this.creatorId = r100.creator_id;
        this.followers = r100.followers;
        this.assignees = r100.assignees;
        this.mode = r100.mode;
        this.attachments = new ArrayList(r100.attachments);
        this.createMilliTime = r100.create_milli_time.longValue();
        this.isMileStone = r100.is_milestone.booleanValue();
        this.selfPermission = r100.self_permission;
        this.dependentRefs = new ArrayList(r100.dependents);
    }

    public void setPbData(Todo r100) {
        this.pbData = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleSubTodoData(a r100, DefaultConstructorMarker r101) {
        boolean r102 = false;
        int r103 = 2;
        this.summary = new TodoRichContent(null, r102, r103, 0 == true ? 1 : 0);
        this.description = new TodoRichContent(0 == true ? 1 : 0, r102, r103, 0 == true ? 1 : 0);
        this.dueTimeZone = TimeZone.getDefault().getID();
        this.reminders = new ArrayList();
        this.rrule = "";
        this.rruleText = "";
        this.guid = UUID.randomUUID().toString();
        this.creatorId = TodoDependencyHolder.a().loginDependency().getUserId();
        this.assignees = new ArrayList();
        this.followers = new ArrayList();
        this.mode = TaskMode.TASK_COMPLETE;
        this.attachments = new ArrayList();
        this.dependentRefs = new ArrayList();
        this.summary = r100.f443820a;
        this.description = r100.f443821b;
        this.dueTimeMillis = r100.f443822c;
        this.startTimeMillis = r100.f443823d;
        this.dueTimeZone = r100.f443824e;
        this.isAllDay = r100.f443825f;
        this.reminders = r100.f443826g;
        this.rrule = r100.f443827h;
        this.rruleText = r100.f443828i;
        this.assignees = r100.f443829j;
        this.isInCreate = true;
        this.mode = r100.f443831l;
        this.attachments = new ArrayList(r100.f443830k);
        this.createMilliTime = System.currentTimeMillis();
        this.isMileStone = r100.f443832m;
        this.selfPermission = r100.f443833n;
        this.dependentRefs = new ArrayList(r100.f443834o);
    }
}
