package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.bytedance.lark.pb.todo.v1.ActivityRecord;
import com.bytedance.lark.pb.todo.v1.ContainerMetaData;
import com.bytedance.lark.pb.todo.v1.DeleteTaskContainerRequest;
import com.bytedance.lark.pb.todo.v1.DeleteTaskContainerResponse;
import com.bytedance.lark.pb.todo.v1.GetPagingActivityRecordsRequest;
import com.bytedance.lark.pb.todo.v1.GetPagingActivityRecordsResponse;
import com.bytedance.lark.pb.todo.v1.GetPagingTaskListMembersRequest;
import com.bytedance.lark.pb.todo.v1.GetPagingTaskListMembersResponse;
import com.bytedance.lark.pb.todo.v1.MGetServerContainerTasksRequest;
import com.bytedance.lark.pb.todo.v1.MGetServerContainerTasksResponse;
import com.bytedance.lark.pb.todo.v1.MGetTaskContainerMetaDataRequest;
import com.bytedance.lark.pb.todo.v1.MGetTaskContainerMetaDataResponse;
import com.bytedance.lark.pb.todo.v1.PageParam;
import com.bytedance.lark.pb.todo.v1.PageResult;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerInfo;
import com.bytedance.lark.pb.todo.v1.TaskContainerPermission;
import com.bytedance.lark.pb.todo.v1.TaskContainerSection;
import com.bytedance.lark.pb.todo.v1.TaskContainerSectionRef;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TaskView;
import com.bytedance.lark.pb.todo.v1.TaskViewFilters;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.lark.pb.todo.v1.UpsertTaskContainerRequest;
import com.bytedance.lark.pb.todo.v1.UpsertTaskContainerResponse;
import com.bytedance.lark.pb.todo.v1.UpsertTaskContainerSectionRequest;
import com.bytedance.lark.pb.todo.v1.UpsertTaskContainerSectionResponse;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.pb.todo.UpdateTaskListMembersRequest;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.todo.impl.features.center.v3.FilterUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TaskContainerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskContainerService f444240a = null;

    public static final class a implements RustLog.a<DeleteTaskContainerResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f444241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f444242b;

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(DeleteTaskContainerResponse r100) {
            return "id:" + this.f444241a + " removeNoOwnerTask:" + this.f444242b;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return DeleteTaskContainerResponse.ADAPTER.decode(r100);
        }

        public a(String r100, boolean r101) {
            this.f444241a = r100;
            this.f444242b = r101;
        }
    }

    public static final class b implements RustLog.a<MGetServerContainerTasksResponse> {
        public b() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MGetServerContainerTasksResponse r100) {
            MGetServerContainerTasksResponse r101 = r100;
            StringBuilder r102 = new StringBuilder("size:");
            if (r101 == null) goto L7;
            List<TaskContainerInfo> r103 = r101.tasks;
            if (r103 == null) goto L7;
            Integer r104 = Integer.valueOf(r103.size());
        L8:
            r102.append(r104);
            return r102.toString();
        L7:
            r104 = null;
            goto L8
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MGetServerContainerTasksResponse.ADAPTER.decode(r100);
        }
    }

    public static final class c implements RustLog.a<GetPagingActivityRecordsResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GetPagingActivityRecordsRequest.SceneType f444243a;

        public c(GetPagingActivityRecordsRequest.SceneType r100) {
            this.f444243a = r100;
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetPagingActivityRecordsResponse r100) {
            GetPagingActivityRecordsResponse r101 = r100;
            StringBuilder r102 = new StringBuilder("getPagingActivityRecordsRequest: scene_type=");
            r102.append(this.f444243a);
            r102.append(", size=");
            String r103 = null;
            if (r101 == null) goto L7;
            List<ActivityRecord> r104 = r101.activity_records;
            if (r104 == null) goto L7;
            Integer r105 = Integer.valueOf(r104.size());
        L8:
            r102.append(r105);
            r102.append(",hasMore=");
            if (r101 == null) goto L13;
            PageResult r106 = r101.page_result;
            if (r106 == null) goto L13;
            Boolean r107 = r106.has_more;
        L14:
            r102.append(r107);
            r102.append(",lastToken=");
            if (r101 == null) goto L19;
            PageResult r108 = r101.page_result;
            if (r108 == null) goto L19;
            r103 = r108.last_token;
        L19:
            r102.append(r103);
            return r102.toString();
        L13:
            r107 = null;
        L7:
            r105 = null;
            goto L8
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetPagingActivityRecordsResponse.ADAPTER.decode(r100);
        }
    }

    public static final class d implements RustLog.a<GetPagingTaskListMembersResponse> {
        public d() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetPagingTaskListMembersResponse r100) {
            GetPagingTaskListMembersResponse r101 = r100;
            StringBuilder r102 = new StringBuilder("task list member size: ");
            if (r101 == null) goto L7;
            List<TaskListMember> r103 = r101.task_list_members;
            if (r103 == null) goto L7;
            int r104 = r103.size();
        L8:
            r102.append(r104);
            r102.append(", has_more: ");
            String r105 = null;
            if (r101 == null) goto L11;
            Boolean r106 = r101.has_more;
        L12:
            r102.append(r106);
            r102.append(", last_token: ");
            if (r101 == null) goto L15;
            r105 = r101.last_token;
        L15:
            r102.append(r105);
            return r102.toString();
        L11:
            r106 = null;
        L7:
            r104 = 0;
            goto L8
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetPagingTaskListMembersResponse.ADAPTER.decode(r100);
        }
    }

    public static final class e implements RustLog.a<MGetTaskContainerMetaDataResponse> {
        public e() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MGetTaskContainerMetaDataResponse r110) {
            MGetTaskContainerMetaDataResponse r111 = r110;
            if (r111 == null) goto L50;
            Map<String, ContainerMetaData> r112 = r111.meta_data;
            if (r112 == null) goto L50;
            Collection<ContainerMetaData> r113 = r112.values();
            if (r113 == null) goto L50;
            ArrayList r100 = new ArrayList();
            Iterator<T> r114 = r113.iterator();
        L10:
            if (r114.hasNext() == false) goto L48;
            ContainerMetaData r101 = (ContainerMetaData) r114.next();
            int r102 = com.ss.android.lark.todo.impl.features.center.v3.b.f441422a;
            Intrinsics.checkNotNull(r101);
            Intrinsics.checkNotNullParameter(r101, "metaData");
            TaskContainer r103 = r101.container;
            ArrayList r104 = null;
            if (r103 == null) goto L31;
            StringBuilder r105 = new StringBuilder("{container_guid=");
            r105.append(r103.guid);
            r105.append(", rank=");
            r105.append(r103.rank);
            r105.append(", version=");
            r105.append(r103.version);
            r105.append(", deleteMilliTime=");
            r105.append(r103.delete_milli_time);
            r105.append(", archiveMilliTime=");
            r105.append(r103.archived_milli_time);
            r105.append("}, userJoinMilliTime=");
            r105.append(r103.current_user_join_milli_time);
            r105.append(", owner_id=");
            TodoUser r106 = r103.owner;
            if (r106 == null) goto L16;
            String r107 = r106.user_id;
        L17:
            r105.append(r107);
            r105.append(", view_permission=");
            TaskContainerPermission r108 = r103.current_user_permission;
            if (r108 == null) goto L22;
            Map<Integer, Boolean> r109 = r108.permissions;
            if (r109 == null) goto L22;
            Boolean r115 = r109.get(Integer.valueOf(TaskContainerPermission.Action.VIEW.getValue()));
        L23:
            r105.append(r115);
            r105.append(", edit_task_permission=");
            TaskContainerPermission r116 = r103.current_user_permission;
            if (r116 == null) goto L28;
            Map<Integer, Boolean> r117 = r116.permissions;
            if (r117 == null) goto L28;
            Boolean r118 = r117.get(Integer.valueOf(TaskContainerPermission.Action.EDIT_TASK.getValue()));
        L29:
            r105.append(r118);
            String r119 = r105.toString();
            if (r119 == null) goto L31;
        L32:
            List<TaskView> r120 = r101.views;
            if (r120 == null) goto L45;
            r104 = new ArrayList();
            Iterator<T> r121 = r120.iterator();
        L36:
            if (r121.hasNext() == false) goto L45;
            TaskView r122 = (TaskView) r121.next();
            int r123 = com.ss.android.lark.todo.impl.features.center.v3.b.f441422a;
            Intrinsics.checkNotNull(r122);
            Pair r124 = com.ss.android.lark.todo.impl.features.center.v3.b.f(r122);
            StringBuilder r125 = new StringBuilder("{viewType=");
            r125.append(r122.type);
            r125.append(", groupField=");
            r125.append(com.ss.android.lark.todo.impl.features.center.v3.b.e(r122).name());
            r125.append(", sortField=");
            r125.append(r124.getFirst());
            r125.append(", sortIsAsc=");
            r125.append(((Boolean) r124.getSecond()).booleanValue());
            r125.append(", completeStatus=");
            TaskViewFilters r126 = r122.view_filters;
            if (r126 == null) goto L41;
            String r127 = FilterUtil.d(r126).name();
            if (r127 == null) goto L41;
        L42:
            r125.append(r127);
            r125.append('}');
            String r128 = r125.toString();
            if (r128 == null) goto L36;
            r104.add(r128);
        L41:
            r127 = AccountType.ALL;
        L45:
            String r129 = "{container=" + r119 + ", task_views=" + r104 + '}';
            if (r129 == null) goto L10;
            r100.add(r129);
        L28:
            r118 = null;
        L22:
            r115 = null;
            goto L23
        L16:
            r107 = null;
        L31:
            r119 = SliceInitService.DEFAULT_SWITCH;
            goto L32
        L48:
            String r130 = r100.toString();
            if (r130 == null) goto L50;
            return r130;
        L50:
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MGetTaskContainerMetaDataResponse.ADAPTER.decode(r100);
        }
    }

    public static final class f implements RustLog.a<UpsertTaskContainerResponse> {
        public f() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(UpsertTaskContainerResponse r100) {
            UpsertTaskContainerResponse r101 = r100;
            StringBuilder r102 = new StringBuilder("key:");
            Long r103 = null;
            if (r101 == null) goto L9;
            ContainerMetaData r104 = r101.container_meta_data;
            if (r104 == null) goto L9;
            TaskContainer r105 = r104.container;
            if (r105 == null) goto L9;
            String r106 = r105.key;
        L10:
            r102.append(r106);
            r102.append(" guid:");
            if (r101 == null) goto L17;
            ContainerMetaData r107 = r101.container_meta_data;
            if (r107 == null) goto L17;
            TaskContainer r108 = r107.container;
            if (r108 == null) goto L17;
            String r109 = r108.guid;
        L18:
            r102.append(r109);
            r102.append(" name:");
            if (r101 == null) goto L27;
            ContainerMetaData r110 = r101.container_meta_data;
            if (r110 == null) goto L27;
            TaskContainer r111 = r110.container;
            if (r111 == null) goto L27;
            String r112 = r111.name;
            if (r112 == null) goto L27;
            Integer r113 = Integer.valueOf(r112.length());
        L28:
            r102.append(r113);
            r102.append(" delete:");
            if (r101 == null) goto L35;
            ContainerMetaData r114 = r101.container_meta_data;
            if (r114 == null) goto L35;
            TaskContainer r115 = r114.container;
            if (r115 == null) goto L35;
            r103 = r115.delete_milli_time;
        L35:
            r102.append(r103);
            return r102.toString();
        L27:
            r113 = null;
        L17:
            r109 = null;
        L9:
            r106 = null;
            goto L10
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return UpsertTaskContainerResponse.ADAPTER.decode(r100);
        }
    }

    public static final class g implements RustLog.a<UpsertTaskContainerSectionResponse> {
        public g() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(UpsertTaskContainerSectionResponse r100) {
            UpsertTaskContainerSectionResponse r101 = r100;
            StringBuilder r102 = new StringBuilder("guid:");
            Long r103 = null;
            if (r101 == null) goto L7;
            TaskContainerSection r104 = r101.container_section;
            if (r104 == null) goto L7;
            String r105 = r104.guid;
        L8:
            r102.append(r105);
            r102.append(" name:");
            if (r101 == null) goto L15;
            TaskContainerSection r106 = r101.container_section;
            if (r106 == null) goto L15;
            String r107 = r106.name;
            if (r107 == null) goto L15;
            Integer r108 = Integer.valueOf(r107.length());
        L16:
            r102.append(r108);
            r102.append(" delete:");
            if (r101 == null) goto L21;
            TaskContainerSection r109 = r101.container_section;
            if (r109 == null) goto L21;
            r103 = r109.delete_milli_time;
        L21:
            r102.append(r103);
            return r102.toString();
        L15:
            r108 = null;
        L7:
            r105 = null;
            goto L8
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return UpsertTaskContainerSectionResponse.ADAPTER.decode(r100);
        }
    }

    static {
        f444240a = new TaskContainerService();
    }

    public TaskContainerService() {
    }

    public static Object a(TaskContainer r100, Continuation r101) {
        TaskContainer.Builder r102 = r100.newBuilder();
        Long r103 = r100.archived_milli_time;
        long r104 = 0;
        if (r103 != null) goto L6;
    L8:
        TaskContainer r105 = r102.archived_milli_time(Boxing.boxLong(r104)).build();
        Intrinsics.checkNotNull(r105);
        return i(r100, r105, null, r101);
    L6:
        if (r103.longValue() != 0) goto L8;
        r104 = System.currentTimeMillis();
        goto L8
    }

    public static Object j(TaskContainerSection r100, Continuation r101) {
        UpsertTaskContainerSectionRequest.Builder r102 = new UpsertTaskContainerSectionRequest.Builder().container_section(r100);
        int r103 = RustLog.f444237a;
        Command r104 = Command.UPSERT_TASK_CONTAINER_SECTION;
        Intrinsics.checkNotNull(r102);
        return RustLog.a(r104, r102, new g(), "", r101);
    }

    public static Object c(String r100, boolean r101, Continuation r102) {
        DeleteTaskContainerRequest.Builder r103 = new DeleteTaskContainerRequest.Builder().container_guid(r100).remove_no_owner_task(Boxing.boxBoolean(r101));
        int r104 = RustLog.f444237a;
        Command r105 = Command.DELETE_TASK_CONTAINER;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new a(r100, r101), "id:" + r100 + " removeNoOwnerTask:" + r101, r102);
    }

    public static Object g(List r100, boolean r101, Continuation r102) {
        MGetTaskContainerMetaDataRequest.Builder r103 = new MGetTaskContainerMetaDataRequest.Builder().container_guids(r100).need_sections(Boxing.boxBoolean(r101));
        int r104 = RustLog.f444237a;
        Command r105 = Command.MGET_TASK_CONTAINER_META_DATA;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new e(), "req size: " + r100.size(), r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(String r100, List<String> r101, Continuation<? super List<TaskContainerInfo>> r102) {
        if ((r102 instanceof TaskContainerService$getContainerTasks$1) == false) goto L7;
        TaskContainerService$getContainerTasks$1 r103 = (TaskContainerService$getContainerTasks$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        MGetServerContainerTasksResponse r108 = (MGetServerContainerTasksResponse) ((RustLog.b) r105).f444238a;
        if (r108 == null) goto L22;
        List<TaskContainerInfo> r109 = r108.tasks;
        if (r109 == null) goto L22;
        return r109;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MGetServerContainerTasksRequest.Builder r110 = new MGetServerContainerTasksRequest.Builder().container_guid(r100).task_guids(r101);
        int r111 = RustLog.f444237a;
        Command r112 = Command.MGET_SERVER_CONTAINER_TASKS;
        Intrinsics.checkNotNull(r110);
        b r113 = new b();
        r103.label = 1;
        r105 = RustLog.a(r112, r110, r113, "", r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new TaskContainerService$getContainerTasks$1(this, r102);
        goto L8
    }

    public static Object f(String r100, String r101, int r102, Continuation r103) {
        GetPagingTaskListMembersRequest.Builder r104 = new GetPagingTaskListMembersRequest.Builder().task_list_guid(r100).last_token(r101).count(Boxing.boxLong(r102));
        ArrayList r105 = new ArrayList();
        r105.add(TodoItemMemberType.USER);
        r105.add(TodoItemMemberType.GROUP);
        r105.add(TodoItemMemberType.DOCS);
        GetPagingTaskListMembersRequest.Builder r106 = r104.enable_member_type(r105);
        int r107 = RustLog.f444237a;
        Command r108 = Command.GET_PAGING_TASK_LIST_MEMBERS;
        Intrinsics.checkNotNull(r106);
        return RustLog.a(r108, r106, new d(), "", r103);
    }

    public static Object i(TaskContainer r100, TaskContainer r101, TaskContainerSectionRef r102, Continuation r103) {
        UpsertTaskContainerRequest.Builder r104 = new UpsertTaskContainerRequest.Builder().old_container(r100).new_container(r101);
        if (r102 == null) goto L5;
        r104.container_section_refs(CollectionsKt.listOf(r102));
    L5:
        int r105 = RustLog.f444237a;
        Command r106 = Command.UPSERT_TASK_CONTAINER;
        Intrinsics.checkNotNull(r104);
        return RustLog.a(r106, r104, new f(), "", r103);
    }

    public static Object b(String r100, String r101, String r102, String r103, Continuation r104) {
        TaskContainer r105 = new TaskContainer.Builder().category(TaskContainer.Category.TASK_LIST).guid(r101).name(r100).build();
        if (r102 != null) goto L5;
        TaskContainerSectionRef r106 = null;
    L9:
        Intrinsics.checkNotNull(r105);
        return i(null, r105, r106, r104);
    L5:
        TaskContainerSectionRef.Builder r107 = new TaskContainerSectionRef.Builder().section_guid(r102).container_guid(r101);
        ArrayList<Character> r108 = com.ss.android.lark.todo.impl.features.center.v3.e.f441576a;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r106 = r107.rank(com.ss.android.lark.todo.impl.features.center.v3.e.b(r103)).build();
        goto L9
    }

    public static void h(final String r100, Map r101, boolean r102, String r103, final UIGetDataCallback r104) {
        Intrinsics.checkNotNullParameter(r100, "taskListGuid");
        Intrinsics.checkNotNullParameter(r101, "memberToRole");
        Intrinsics.checkNotNullParameter(r103, "note");
        Intrinsics.checkNotNullParameter(r104, "callback");
        UpdateTaskListMembersRequest.Builder r105 = new UpdateTaskListMembersRequest.Builder().send_note(Boolean.valueOf(r102)).note(r103).task_list_guid(r100).updated_member(r101);
        SdkSender.sendPassThroughRequest(com.ss.android.lark.pb.improto.Command.UPDATE_TASK_LIST_MEMBERS, r105, new TaskContainerService$updateTaskListMembersRequest$1(r100, r104), h.f444257a);
    }

    public static Object e(GetPagingActivityRecordsRequest.SceneType r100, int r101, String r102, LanguageType r103, String r104, Continuation r105) {
        PageParam r106 = new PageParam.Builder().page_token(r102).page_count(Boxing.boxInt(r101)).build();
        GetPagingActivityRecordsRequest.Builder r107 = new GetPagingActivityRecordsRequest.Builder().scene_type(r100).param(r106).language_type(r103);
        if (r100 != GetPagingActivityRecordsRequest.SceneType.TASK) goto L5;
    L6:
        r107.target_guid(r104);
    L7:
        int r108 = RustLog.f444237a;
        Command r109 = Command.GET_PAGING_ACTIVITY_RECORDS;
        Intrinsics.checkNotNull(r107);
        return RustLog.a(r109, r107, new c(r100), "", r105);
    L5:
        if (r100 != GetPagingActivityRecordsRequest.SceneType.TASK_LIST) goto L7;
        goto L6
    }
}
