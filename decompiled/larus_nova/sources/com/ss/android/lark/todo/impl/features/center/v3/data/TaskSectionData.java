package com.ss.android.lark.todo.impl.features.center.v3.data;

import android.text.TextUtils;
import com.bytedance.lark.pb.todo.v1.DueTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.StartTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoOrigin;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.TodoSourceChat;
import com.bytedance.lark.pb.todo.v1.TodoSourceHref;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TaskSectionData implements com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a<TaskSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskSection f441513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskSection f441514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f441515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f441516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f441517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f441518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f441519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f441520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f441521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f441522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashSet<String> f441523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<Function1<Todo, Boolean>> f441524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TaskFieldType f441525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<TodoUser> f441526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f441527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DueTimeGroupCategory f441528p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public StartTimeGroupCategory f441529q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SimpleSubTodoData f441530r;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f441531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f441532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f441533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f441534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList<Function1<Todo, Boolean>> f441535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TaskFieldType f441536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<TodoUser> f441537g;

        public a() {
            this.f441531a = "";
            this.f441532b = "";
            this.f441534d = "";
            this.f441535e = new ArrayList();
            this.f441536f = TaskFieldType.TASK_DEFAULT_SECTION;
            this.f441537g = CollectionsKt.emptyList();
        }

        public final void a(TaskFieldType r100) {
            Intrinsics.checkNotNullParameter(r100, "groupField");
            this.f441536f = r100;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f441538i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TodoSource f441539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f441540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f441541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f441542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f441543e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f441544f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f441545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f441546h;

        public static final class a {
            public static c a(TodoSource r210, TodoOrigin r211) {
                Intrinsics.checkNotNullParameter(r210, "todoSource");
                String r100 = "";
                if (r210 != TodoSource.CHAT) goto L42;
                String r101 = null;
                if (r211 == null) goto L7;
                TodoOrigin.Type r102 = r211.type;
            L9:
                if (r102 != TodoOrigin.Type.CHAT) goto L42;
                if (r211 == null) goto L15;
                TodoSourceChat r103 = r211.chat;
                if (r103 == null) goto L15;
                String r104 = r103.chat_name;
                if (r104 == null) goto L15;
            L16:
                int r105 = com.ss.android.lark.todo.impl.features.center.v3.b.f441422a;
                if (r211 == null) goto L22;
                TodoSourceChat r106 = r211.chat;
                if (r106 == null) goto L22;
                String r107 = r106.link;
                if (r107 == null) goto L22;
            L23:
                String r108 = com.ss.android.lark.todo.impl.features.center.v3.b.a(r107);
                if (r211 == null) goto L29;
                TodoSourceChat r109 = r211.chat;
                if (r109 == null) goto L29;
                r101 = r109.chat_name;
            L29:
                if (TextUtils.isEmpty(r101) == false) goto L31;
                String r110 = r108;
            L32:
                if (r211 == null) goto L39;
                TodoSourceChat r111 = r211.chat;
                if (r111 == null) goto L39;
                String r112 = r111.chat_id;
                if (r112 == null) goto L39;
                String r113 = r112;
            L40:
                c r114 = new c(r210, r113, r108, r110, null, null, r110, 0, 48);
            L113:
                if (TextUtils.isEmpty(r114.f441545g) == true) goto L115;
                return r114;
            L115:
                return new c(TodoSource.UNKNOWN_SOURCE, null, null, null, null, null, i.f444291a.g(R.string.Todo_New_SpecificSource_Others), 0, 190);
            L39:
                r113 = "";
                goto L40
            L31:
                r110 = r104;
            L22:
                r107 = "";
            L15:
                r104 = "";
                goto L16
            L7:
                r102 = null;
            L42:
                if (r210 != TodoSource.DOC) goto L44;
            L78:
                int r115 = com.ss.android.lark.todo.impl.features.center.v3.b.f441422a;
                if (r211 == null) goto L84;
                TodoSourceHref r116 = r211.href;
                if (r116 == null) goto L84;
                String r117 = r116.url;
                if (r117 == null) goto L84;
            L85:
                String r118 = com.ss.android.lark.todo.impl.features.center.v3.b.b(r117);
                if (r211 == null) goto L93;
                TodoSourceHref r119 = r211.href;
                if (r119 == null) goto L93;
                String r120 = r119.title;
                if (r120 == null) goto L93;
                String r121 = r120;
            L94:
                if (r211 == null) goto L99;
                TodoSourceHref r122 = r211.href;
                if (r122 == null) goto L99;
                String r123 = r122.title;
                if (r123 == null) goto L99;
            L101:
                if (TextUtils.isEmpty(r123) == false) goto L103;
                String r124 = i.f444291a.g(R.string.Todo_Task_UnnamedDocPlaceholder);
            L109:
                String r125 = r124;
            L111:
                r114 = new c(r210, null, null, null, r118, r121, r125, 1, 14);
                goto L113
            L103:
                if (r211 == null) goto L110;
                TodoSourceHref r126 = r211.href;
                if (r126 == null) goto L110;
                r124 = r126.title;
                if (r124 != null) goto L109;
            L110:
                r125 = "";
            L99:
                r123 = "";
            L93:
                r121 = "";
            L84:
                r117 = "";
                goto L85
            L44:
                if (r210 == TodoSource.DOCX) goto L78;
                if (r210 != TodoSource.OAPI) goto L77;
                if (r211 == null) goto L55;
                TodoSourceHref r127 = r211.href;
                if (r127 == null) goto L55;
                String r128 = r127.url;
                if (r128 == null) goto L55;
                String r129 = r128;
            L56:
                if (r211 == null) goto L63;
                TodoSourceHref r130 = r211.href;
                if (r130 == null) goto L63;
                String r131 = r130.title;
                if (r131 == null) goto L63;
                String r132 = r131;
            L64:
                if (r211 == null) goto L70;
                String r133 = r211.display_i18n_name;
                if (r133 == null) goto L70;
                r100 = r133;
            L70:
                if (TextUtils.isEmpty(r100) == true) goto L73;
                String r134 = r100;
            L76:
                r114 = new c(r210, null, null, null, r129, r132, r134, 2, 14);
                goto L113
            L73:
                if (TextUtils.isEmpty(r132) == true) goto L75;
                r134 = r132;
                goto L76
            L75:
                r134 = r129;
            L63:
                r132 = "";
            L55:
                r129 = "";
                goto L56
            L77:
                r114 = new c(TodoSource.UNKNOWN_SOURCE, null, null, null, null, null, i.f444291a.g(R.string.Todo_New_SpecificSource_Others), 3, 62);
                goto L113
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f441547a = null;

            static {
                int[] r100 = new int[TodoSource.values().length];
                r100[TodoSource.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[TodoSource.DOCX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[TodoSource.DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[TodoSource.OAPI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f441547a = r100;
            }
        }

        static {
        }

        public final String toString() {
            return "SectionOriginData(type=" + this.f441539a + ", chatID=" + this.f441540b + ", chatLink=" + this.f441541c + ", chatName=" + this.f441542d + ", hrefUrl=" + this.f441543e + ", hrefTitle=" + this.f441544f + ", sectionTitle=" + this.f441545g + ", priority=" + this.f441546h + ')';
        }

        public final int hashCode() {
            TodoSource r100 = this.f441539a;
            int r101 = b.f441547a[r100.ordinal()];
            if (r101 == 1) goto L14;
            if (r101 == 2) goto L17;
            if (r101 == 3) goto L17;
            if (r101 == 4) goto L16;
            return this.f441539a.hashCode();
        L16:
            return this.f441545g.hashCode();
        L17:
            return this.f441543e.hashCode();
        L14:
            return this.f441540b.hashCode();
        }

        public final TodoSource getType() {
            return this.f441539a;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof c) == true) goto L5;
            return false;
        L5:
            TodoSource r101 = this.f441539a;
            c r102 = (c) r100;
            if (r101 == r102.f441539a) goto L8;
            return false;
        L8:
            int r103 = b.f441547a[r101.ordinal()];
            if (r103 == 1) goto L24;
            if (r103 == 2) goto L19;
            if (r103 == 3) goto L19;
            if (r103 == 4) goto L31;
        L16:
            return true;
        L31:
            return Intrinsics.areEqual(this.f441545g, r102.f441545g);
        L19:
            if (Intrinsics.areEqual(this.f441543e, r102.f441543e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f441544f, r102.f441544f) == true) goto L16;
            return false;
        L24:
            if (TextUtils.isEmpty(this.f441540b) == true) goto L29;
            if (TextUtils.isEmpty(r102.f441540b) == true) goto L29;
            return Intrinsics.areEqual(this.f441540b, r102.f441540b);
        L29:
            return Intrinsics.areEqual(this.f441541c, r102.f441541c);
        }

        public c(TodoSource r100, String r101, String r102, String r103, String r104, String r105, String r106, int r110, int r111) {
            if ((r111 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r111 & 4) == 0) goto L9;
            r102 = "";
        L9:
            if ((r111 & 8) == 0) goto L12;
            r103 = "";
        L12:
            if ((r111 & 16) == 0) goto L15;
            r104 = "";
        L15:
            if ((r111 & 32) == 0) goto L18;
            r105 = "";
        L18:
            if ((r111 & 64) == 0) goto L21;
            r106 = "";
        L21:
            if ((r111 & 128) == 0) goto L23;
            r110 = Integer.MAX_VALUE;
        L23:
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "chatID");
            Intrinsics.checkNotNullParameter(r102, "chatLink");
            Intrinsics.checkNotNullParameter(r103, "chatName");
            Intrinsics.checkNotNullParameter(r104, "hrefUrl");
            Intrinsics.checkNotNullParameter(r105, "hrefTitle");
            Intrinsics.checkNotNullParameter(r106, "sectionTitle");
            this.f441539a = r100;
            this.f441540b = r101;
            this.f441541c = r102;
            this.f441542d = r103;
            this.f441543e = r104;
            this.f441544f = r105;
            this.f441545g = r106;
            this.f441546h = r110;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f441548b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<TodoUser> f441549a;

        public static final class a {
            public static d a(Todo r100) {
                Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
                List<TodoAssignee> r101 = r100.assignees;
                ArrayList r102 = new ArrayList();
                Iterator<T> r103 = r101.iterator();
            L4:
                if (r103.hasNext() == false) goto L9;
                TodoUser r104 = ((TodoAssignee) r103.next()).user.user;
                if (r104 == null) goto L4;
                r102.add(r104);
                goto L4
            L9:
                return new d(CollectionsKt.sortedWith(r102, com.ss.android.lark.todo.impl.features.center.v3.f.f441592l));
            }
        }

        static {
        }

        public final String toString() {
            return "SectionOwnerData(owners=" + this.f441549a + ')';
        }

        public final int hashCode() {
            Iterator<T> r100 = this.f441549a.iterator();
            int r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L6;
            r101 = r101 + ((TodoUser) r100.next()).user_id.hashCode();
            goto L4
        L6:
            return r101;
        }

        public d(List<TodoUser> r100) {
            Intrinsics.checkNotNullParameter(r100, "owners");
            this.f441549a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof d) == true) goto L5;
            return false;
        L5:
            d r101 = (d) r100;
            if (this.f441549a.size() == r101.f441549a.size()) goto L8;
            return false;
        L8:
            Iterator<T> r102 = this.f441549a.iterator();
            int r103 = 0;
        L10:
            if (r102.hasNext() == false) goto L15;
            int r104 = r103 + 1;
            if (Intrinsics.areEqual(((TodoUser) r102.next()).user_id, ((TodoUser) ListProtector.get(r101.f441549a, r103)).user_id) == false) goto L13;
            r103 = r104;
            goto L10
        L13:
            return false;
        L15:
            return true;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskSectionData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f441513a, ((TaskSectionData) r100).f441513a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f441513a.hashCode();
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public final boolean isValid() {
        return true;
    }

    public final String toString() {
        return "TaskSectionData(section=" + this.f441513a + ')';
    }

    public final TaskSection b() {
        TaskSection r100 = this.f441514b;
        if (r100 == null) goto L11;
        TaskSection.Builder r101 = r100.newBuilder();
        if (r101 == null) goto L11;
        TaskSection.Builder r102 = r101.name(this.f441516d);
        if (r102 == null) goto L11;
        TaskSection.Builder r103 = r102.rank(this.f441520h);
        if (r103 == null) goto L11;
        return r103.build();
    L11:
        return null;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public final /* bridge */ /* synthetic */ TaskSection parseToPb() {
        return b();
    }

    public TaskSectionData(TaskSection r100) {
        Intrinsics.checkNotNullParameter(r100, "section");
        this.f441513a = r100;
        this.f441514b = r100;
        String r101 = r100.guid;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f441515c = r101;
        String r103 = r100.name;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f441516d = r103;
        Boolean r104 = r100.is_default;
        if (r104 == null) goto L11;
        boolean r105 = r104.booleanValue();
    L12:
        this.f441517e = r105;
        this.f441518f = true;
        String r106 = r100.key;
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        this.f441519g = r106;
        String r107 = r100.rank;
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        this.f441520h = r107;
        String r108 = r100.container_id;
        if (r108 == null) goto L22;
        r102 = r108;
    L22:
        this.f441521i = r102;
        Long r109 = r100.version;
        if (r109 == null) goto L25;
        long r110 = r109.longValue();
    L26:
        this.f441522j = r110;
        Long r111 = r100.delete_milli_time;
        if (r111 == null) goto L29;
        r111.longValue();
    L29:
        this.f441523k = new HashSet();
        ArrayList<Function1<Todo, Boolean>> r112 = new ArrayList();
        r112.add(new TaskSectionData$filters$1$1(this));
        this.f441524l = r112;
        this.f441525m = TaskFieldType.TASK_DEFAULT_SECTION;
        this.f441526n = CollectionsKt.emptyList();
        this.f441528p = DueTimeGroupCategory.UNKNOWN_DUE_TIME;
        this.f441529q = StartTimeGroupCategory.UNKNOWN_START_TIME;
        SimpleSubTodoData.a r113 = new SimpleSubTodoData.a();
        String r114 = TodoDependencyHolder.a().loginDependency().getUserId();
        List<TodoAssignee> r115 = CollectionsKt.mutableListOf(new TodoAssignee[]{new TodoAssignee.Builder().assignee_id(r114).type(TodoItemMemberType.USER).user(new TodoAssignee.User.Builder().completed_milli_time(0L).user(new TodoUser.Builder().user_id(r114).build()).build()).assigner_id(TodoDependencyHolder.a().loginDependency().getUserId()).build()});
        Intrinsics.checkNotNullParameter(r115, "assignees");
        r113.f443829j = r115;
        this.f441530r = r113.a();
        return;
    L25:
        r110 = 0;
        goto L26
    L11:
        r105 = false;
        goto L12
    }

    public final void a(Function1<? super Todo, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        this.f441524l.add(r100);
    }

    public final void update(TaskSection r100) {
        Intrinsics.checkNotNullParameter(r100, "section");
        this.f441514b = r100;
        this.f441515c = r100.guid;
        this.f441521i = r100.container_id;
        this.f441516d = r100.name;
        this.f441520h = r100.rank;
        this.f441522j = r100.version.longValue();
    }

    public TaskSectionData(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this(new TaskSection.Builder().guid(UUID.randomUUID().toString()).name(r100.f441531a).rank(r100.f441532b).version(Long.valueOf(System.currentTimeMillis())).container_id(r100.f441534d).build());
        this.f441518f = r100.f441533c;
        ArrayList<Function1<Todo, Boolean>> r101 = new ArrayList();
        r101.addAll(r100.f441535e);
        this.f441524l = r101;
        this.f441525m = r100.f441536f;
        this.f441526n = r100.f441537g;
    }
}
