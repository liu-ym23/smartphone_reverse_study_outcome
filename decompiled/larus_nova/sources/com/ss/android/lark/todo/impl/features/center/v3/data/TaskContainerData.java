package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerPermission;
import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.TaskView;
import com.bytedance.lark.pb.todo.v1.TaskViewFilters;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TaskContainerData implements com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a<TaskContainer> {
    public final HashMap<String, Boolean> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TaskContainer f441457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskContainer.Category f441459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContainerType f441460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f441461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TaskContainerPermission f441462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TodoUser f441463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f441464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f441465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f441466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<TaskFieldType> f441467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinkedHashMap<TaskFieldType, Boolean> f441468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<TaskListMember> f441469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f441470n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f441471o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TaskFieldType f441472p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TaskFieldType f441473q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f441474r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TaskCompleteStatusFieldFilterValue.TaskCompleteStatus f441475s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f441476t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TaskViewFilters f441477u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TaskView f441478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<TaskContainerRef> f441479w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList<TaskSectionData> f441480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<TaskSectionData> f441481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TaskSectionData f441482z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskContainerData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f441457a, ((TaskContainerData) r100).f441457a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f441457a.hashCode();
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public final boolean isValid() {
        return true;
    }

    public final String toString() {
        return "TaskContainerData(pbData=" + this.f441457a + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public final TaskContainer parseToPb() {
        return this.f441457a.newBuilder().name(this.f441464h).delete_milli_time(Long.valueOf(this.f441465i)).archived_milli_time(Long.valueOf(this.f441466j)).build();
    }

    public final ContainerType getType() {
        return this.f441460d;
    }

    public TaskContainerData(TaskContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.f441457a = r100;
        String r101 = r100.guid;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f441458b = r101;
        TaskContainer.Category r103 = r100.category;
        if (r103 != null) goto L8;
        r103 = TaskContainer.Category.UNKNOWN;
    L8:
        this.f441459c = r103;
        ContainerType.a r104 = ContainerType.Companion;
        String r105 = r100.key;
        if (r105 == null) goto L12;
        r102 = r105;
    L12:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        switch(r102.hashCode()) {
            case -1566329541: goto L40;
            case -1284338179: goto L36;
            case -867221252: goto L32;
            case 243871791: goto L28;
            case 873566934: goto L24;
            case 1784536402: goto L20;
            case 1979043929: goto L16;
            default: goto L43;
        };
    L43:
        ContainerType r106 = ContainerType.TASK_LIST_CONTAINER;
    L44:
        this.f441460d = r106;
        TaskContainer r107 = this.f441457a;
        String r108 = r107.rank;
        Long r109 = r107.version;
        long r110 = 0;
        if (r109 == null) goto L47;
        long r111 = r109.longValue();
    L48:
        this.f441461e = r111;
        TaskContainer r112 = this.f441457a;
        this.f441462f = r112.current_user_permission;
        Long r113 = r112.current_user_join_milli_time;
        if (r113 == null) goto L51;
        r113.longValue();
    L51:
        TaskContainer r114 = this.f441457a;
        this.f441463g = r114.owner;
        String r115 = r114.name;
        if (r115 != null) goto L54;
    L57:
        boolean r116 = true;
    L58:
        if (r116 == false) goto L60;
        String r117 = this.f441460d.toString();
    L61:
        this.f441464h = r117;
        Long r118 = this.f441457a.delete_milli_time;
        if (r118 == null) goto L64;
        long r119 = r118.longValue();
    L65:
        this.f441465i = r119;
        Long r120 = this.f441457a.archived_milli_time;
        if (r120 == null) goto L68;
        r110 = r120.longValue();
    L68:
        this.f441466j = r110;
        this.f441467k = new ArrayList();
        this.f441468l = new LinkedHashMap();
        this.f441469m = CollectionsKt.emptyList();
        this.f441471o = new ConcurrentHashMap();
        this.f441472p = TaskFieldType.TASK_NO_SECTION;
        this.f441473q = TaskFieldType.DUE_TIME;
        this.f441474r = true;
        this.f441475s = TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED;
        this.f441479w = new ArrayList();
        this.f441480x = new ArrayList();
        this.f441481y = new ArrayList();
        this.A = new HashMap();
        return;
    L64:
        r119 = 0;
        goto L65
    L60:
        r117 = this.f441457a.name;
        goto L61
    L54:
        if (r115.length() == 0) goto L57;
        r116 = false;
        goto L58
    L47:
        r111 = 0;
        goto L48
    L16:
        if (r102.equals("__container_created_tasks") == false) goto L43;
        r106 = ContainerType.CREATE_FROM_ME_CONTAINER;
        goto L44
    L20:
        if (r102.equals("__container_all_tasks") == false) goto L43;
        r106 = ContainerType.ALL_RELATION_CONTAINER;
        goto L44
    L24:
        if (r102.equals("__container_owned_tasks") == false) goto L43;
        r106 = ContainerType.OWNED_BY_ME_CONTAINER;
        goto L44
    L28:
        if (r102.equals("__container_collaborated_tasks") == false) goto L43;
        r106 = ContainerType.COLLABORATE_WITH_ME_CONTAINER;
        goto L44
    L32:
        if (r102.equals("__container_completed_tasks") == false) goto L43;
        r106 = ContainerType.COMPLETED_CONTAINER;
        goto L44
    L36:
        if (r102.equals("__container_followed_tasks") == false) goto L43;
        r106 = ContainerType.FOLLOWED_BY_ME_CONTAINER;
        goto L44
    L40:
        if (r102.equals("__container_assigned_tasks") == false) goto L43;
        r106 = ContainerType.ASSIGN_FROM_ME_CONTAINER;
        goto L44
    }

    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        Iterator<T> r101 = this.f441481y.iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((TaskSectionData) r103).f441515c, r100) == false) goto L3;
    L9:
        TaskSectionData r104 = (TaskSectionData) r103;
        if (r104 != null) goto L12;
        return;
    L12:
        Iterator<T> r105 = this.f441481y.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (((TaskSectionData) r106).f441517e == false) goto L14;
        r102 = r106;
    L18:
        TaskSectionData r107 = (TaskSectionData) r102;
        if (r107 != null) goto L21;
        return;
    L21:
        HashSet<String> r108 = r107.f441523k;
        if (r108 == null) goto L24;
        r108.addAll(r104.f441523k);
    L24:
        CollectionsKt.removeAll(this.f441481y, new TaskContainerData$deleteSection$1(r100));
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void b(ContainerType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f441460d = r100;
    }

    public final void c(CopyOnWriteArrayList<TaskSection> r110) {
        Intrinsics.checkNotNullParameter(r110, "sections");
        Iterator<TaskSection> r111 = r110.iterator();
        boolean r100 = false;
    L4:
        if (r111.hasNext() == false) goto L29;
        TaskSection r101 = r111.next();
        if (Intrinsics.areEqual(r101.container_id, this.f441458b) == false) goto L4;
        Iterator<T> r102 = this.f441481y.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((TaskSectionData) r103).f441515c, r101.guid) == false) goto L9;
    L14:
        TaskSectionData r104 = (TaskSectionData) r103;
        if (r104 != null) goto L17;
        Long r105 = r101.delete_milli_time;
        if (r105 == null) goto L4;
        if (r105.longValue() != 0) goto L4;
        ArrayList<TaskSectionData> r106 = this.f441481y;
        Intrinsics.checkNotNull(r101);
        r106.add(new TaskSectionData(r101));
    L28:
        r100 = true;
        goto L4
    L17:
        if (r101.version.longValue() < r104.f441522j) goto L4;
        if (r101.delete_milli_time.longValue() > 0) goto L20;
        Intrinsics.checkNotNull(r101);
        r104.update(r101);
        goto L28
    L20:
        a(r101.guid);
        goto L4
    L13:
        r103 = null;
        goto L14
    L29:
        if (r100 == false) goto L51;
        Collections.sort(this.f441481y, com.ss.android.lark.todo.impl.features.center.v3.f.f441597q);
        return;
    }

    public final void d(TaskContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (Intrinsics.areEqual(r100.guid, this.f441458b) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f441457a = r100;
        String r101 = r100.name;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        this.f441464h = r101;
        Long r102 = r100.version;
        long r103 = 0;
        if (r102 == null) goto L11;
        long r104 = r102.longValue();
    L12:
        this.f441461e = r104;
        Long r105 = r100.delete_milli_time;
        if (r105 == null) goto L15;
        long r106 = r105.longValue();
    L16:
        this.f441465i = r106;
        Long r107 = r100.archived_milli_time;
        if (r107 == null) goto L19;
        r103 = r107.longValue();
    L19:
        this.f441466j = r103;
        this.f441462f = r100.current_user_permission;
        Long r108 = r100.current_user_join_milli_time;
        if (r108 == null) goto L22;
        r108.longValue();
    L22:
        this.f441463g = r100.owner;
        return;
    L15:
        r106 = 0;
        goto L16
    L11:
        r104 = 0;
        goto L12
    }

    public final void e(CopyOnWriteArrayList<TaskContainerRef> r100) {
        Intrinsics.checkNotNullParameter(r100, "newRefs");
        Iterator<TaskContainerRef> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L48;
        TaskContainerRef r102 = r101.next();
        if (Intrinsics.areEqual(this.f441458b, r102.container_guid) == false) goto L4;
        Iterator<T> r103 = this.f441479w.iterator();
    L8:
        Object r104 = null;
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        if (Intrinsics.areEqual(((TaskContainerRef) r105).task_guid, r102.task_guid) == false) goto L8;
    L14:
        TaskContainerRef r106 = (TaskContainerRef) r105;
        if (r106 == null) goto L17;
        this.f441479w.remove(r106);
    L17:
        Long r107 = r102.delete_milli_time;
        if (r107 == null) goto L36;
        if (r107.longValue() != 0) goto L36;
        this.f441479w.add(r102);
        this.f441471o.put(r102.task_guid, r102.rank);
        Iterator<T> r108 = this.f441481y.iterator();
    L24:
        if (r108.hasNext() == false) goto L26;
        ((TaskSectionData) r108.next()).f441523k.remove(r102.task_guid);
        goto L24
    L26:
        Iterator<T> r109 = this.f441481y.iterator();
    L28:
        if (r109.hasNext() == false) goto L32;
        Object r110 = r109.next();
        if (Intrinsics.areEqual(((TaskSectionData) r110).f441515c, r102.section_guid) == false) goto L28;
        r104 = r110;
    L32:
        TaskSectionData r111 = (TaskSectionData) r104;
        if (r111 != null) goto L35;
        r111 = new TaskSectionData(new TaskSection.Builder().guid(r102.section_guid).container_id(r102.container_guid).build());
        this.f441481y.add(r111);
    L35:
        r111.f441523k.add(r102.task_guid);
    L36:
        Iterator<T> r112 = this.f441481y.iterator();
    L38:
        if (r112.hasNext() == false) goto L42;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((TaskSectionData) r113).f441515c, r102.section_guid) == false) goto L38;
        r104 = r113;
    L42:
        TaskSectionData r114 = (TaskSectionData) r104;
        if (r114 == null) goto L47;
        HashSet<String> r115 = r114.f441523k;
        if (r115 == null) goto L47;
        r115.remove(r102.task_guid);
    L47:
        this.f441471o.remove(r102.task_guid);
        goto L4
    L13:
        r105 = null;
        goto L14
    }
}
