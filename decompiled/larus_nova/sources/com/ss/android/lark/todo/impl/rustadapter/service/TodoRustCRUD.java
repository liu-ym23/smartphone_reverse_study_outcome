package com.ss.android.lark.todo.impl.rustadapter.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.AuthScene;
import com.bytedance.lark.pb.todo.v1.ContainerSection;
import com.bytedance.lark.pb.todo.v1.CreateSubTasksRequest;
import com.bytedance.lark.pb.todo.v1.CreateSubTasksResponse;
import com.bytedance.lark.pb.todo.v1.CreateTodoRequest;
import com.bytedance.lark.pb.todo.v1.CreateTodoResponse;
import com.bytedance.lark.pb.todo.v1.DeleteTodoDraftRequest;
import com.bytedance.lark.pb.todo.v1.DeleteTodoDraftResponse;
import com.bytedance.lark.pb.todo.v1.DeleteTodosRequest;
import com.bytedance.lark.pb.todo.v1.DeleteTodosResponse;
import com.bytedance.lark.pb.todo.v1.DraftScene;
import com.bytedance.lark.pb.todo.v1.FollowTodoRequest;
import com.bytedance.lark.pb.todo.v1.FollowTodoResponse;
import com.bytedance.lark.pb.todo.v1.GetPagingSubTaskRequest;
import com.bytedance.lark.pb.todo.v1.GetPagingSubTaskResponse;
import com.bytedance.lark.pb.todo.v1.GetTodoBadgeRequest;
import com.bytedance.lark.pb.todo.v1.GetTodoBadgeResponse;
import com.bytedance.lark.pb.todo.v1.GetTodoDraftRequest;
import com.bytedance.lark.pb.todo.v1.GetTodoDraftResponse;
import com.bytedance.lark.pb.todo.v1.GetTodoReferResourcesRequest;
import com.bytedance.lark.pb.todo.v1.GetTodoReferResourcesResponse;
import com.bytedance.lark.pb.todo.v1.MGetServerTodosRequest;
import com.bytedance.lark.pb.todo.v1.MGetServerTodosResponse;
import com.bytedance.lark.pb.todo.v1.MarkTodoCompletedRequest;
import com.bytedance.lark.pb.todo.v1.MarkTodoCompletedResponse;
import com.bytedance.lark.pb.todo.v1.MergeMessagesAsTodoResourceRequest;
import com.bytedance.lark.pb.todo.v1.MergeMessagesAsTodoResourceResponse;
import com.bytedance.lark.pb.todo.v1.MergeTopicAsTodoResourceRequest;
import com.bytedance.lark.pb.todo.v1.MergeTopicAsTodoResourceResponse;
import com.bytedance.lark.pb.todo.v1.QuitTodoRequest;
import com.bytedance.lark.pb.todo.v1.QuitTodoResponse;
import com.bytedance.lark.pb.todo.v1.ShareTodoMessageRequest;
import com.bytedance.lark.pb.todo.v1.ShareTodoMessageRequestThreadInfo;
import com.bytedance.lark.pb.todo.v1.ShareTodoMessageResponse;
import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoReferResource;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.UpdateTaskContainerRefRequest;
import com.bytedance.lark.pb.todo.v1.UpdateTaskContainerRefResponse;
import com.bytedance.lark.pb.todo.v1.UpdateTodoRequest;
import com.bytedance.lark.pb.todo.v1.UpdateTodoResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.todo.impl.utils.LogMessageUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoRustCRUD {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TodoRustCRUD f444248a = null;

    public static final class a implements RustLog.a<CreateSubTasksResponse> {
        public a() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(CreateSubTasksResponse r100) {
            CreateSubTasksResponse r101 = r100;
            if (r101 == null) goto L8;
            List<Todo> r102 = r101.sub_tasks;
            if (r102 == null) goto L8;
            String r103 = LogMessageUtilKt.b(r102);
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return CreateSubTasksResponse.ADAPTER.decode(r100);
        }
    }

    public static final class b implements RustLog.a<CreateTodoResponse> {
        public b() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(CreateTodoResponse r100) {
            CreateTodoResponse r101 = r100;
            if (r101 == null) goto L8;
            Todo r102 = r101.todo;
            if (r102 == null) goto L8;
            String r103 = LogMessageUtilKt.a(r102);
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return CreateTodoResponse.ADAPTER.decode(r100);
        }
    }

    public static final class c implements RustLog.a<DeleteTodoDraftResponse> {
        public c() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(DeleteTodoDraftResponse r100) {
            return "TRUE";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return DeleteTodoDraftResponse.ADAPTER.decode(r100);
        }
    }

    public static final class d implements RustLog.a<DeleteTodosResponse> {
        public d() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(DeleteTodosResponse r100) {
            return "TRUE";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return DeleteTodosResponse.ADAPTER.decode(r100);
        }
    }

    public static final class e implements RustLog.a<FollowTodoResponse> {
        public e() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(FollowTodoResponse r100) {
            FollowTodoResponse r101 = r100;
            if (r101 == null) goto L8;
            Todo r102 = r101.todo;
            if (r102 == null) goto L8;
            String r103 = LogMessageUtilKt.a(r102);
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return FollowTodoResponse.ADAPTER.decode(r100);
        }
    }

    public static final class f implements RustLog.a<GetTodoReferResourcesResponse> {
        public f() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetTodoReferResourcesResponse r100) {
            GetTodoReferResourcesResponse r101 = r100;
            if (r101 == null) goto L12;
            List<TodoReferResource> r102 = r101.resources;
            if (r102 == null) goto L12;
            TodoReferResource r103 = (TodoReferResource) CollectionsKt.firstOrNull(r102);
            if (r103 == null) goto L12;
            TodoReferResource.MessageResource r104 = r103.msg;
            if (r104 == null) goto L12;
            String r105 = r104.msg_id;
            if (r105 == null) goto L12;
            return r105;
        L12:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetTodoReferResourcesResponse.ADAPTER.decode(r100);
        }
    }

    public static final class g implements RustLog.a<MGetServerTodosResponse> {
        public g() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MGetServerTodosResponse r100) {
            MGetServerTodosResponse r101 = r100;
            if (r101 == null) goto L9;
            List<Todo> r102 = r101.todos;
            if (r102 == null) goto L9;
            boolean r103 = true;
            if ((!r102.isEmpty()) != true) goto L9;
        L10:
            if (r103 == false) goto L17;
            List<Todo> r104 = r101.todos;
            if (r104 == null) goto L17;
            Todo r105 = (Todo) ListProtector.get(r104, 0);
            if (r105 == null) goto L17;
            String r106 = LogMessageUtilKt.a(r105);
            if (r106 == null) goto L17;
            return r106;
        L17:
            return "NULL";
        L9:
            r103 = false;
            goto L10
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MGetServerTodosResponse.ADAPTER.decode(r100);
        }
    }

    public static final class h implements RustLog.a<GetPagingSubTaskResponse> {
        public h() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(GetPagingSubTaskResponse r100) {
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetPagingSubTaskResponse.ADAPTER.decode(r100);
        }
    }

    public static final class i implements RustLog.a<GetTodoBadgeResponse> {
        public i() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetTodoBadgeResponse r100) {
            GetTodoBadgeResponse r101 = r100;
            if (r101 == null) goto L5;
            Integer r102 = r101.count;
        L7:
            return String.valueOf(r102);
        L5:
            r102 = null;
            goto L7
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetTodoBadgeResponse.ADAPTER.decode(r100);
        }
    }

    public static final class j implements RustLog.a<MarkTodoCompletedResponse> {
        public j() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MarkTodoCompletedResponse r100) {
            MarkTodoCompletedResponse r101 = r100;
            if (r101 == null) goto L8;
            Todo r102 = r101.todo;
            if (r102 == null) goto L8;
            String r103 = LogMessageUtilKt.a(r102);
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MarkTodoCompletedResponse.ADAPTER.decode(r100);
        }
    }

    public static final class k implements RustLog.a<MergeMessagesAsTodoResourceResponse> {
        public k() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MergeMessagesAsTodoResourceResponse r100) {
            MergeMessagesAsTodoResourceResponse r101 = r100;
            if (r101 == null) goto L8;
            TodoReferResource r102 = r101.resource;
            if (r102 == null) goto L8;
            String r103 = r102.f253783id;
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MergeMessagesAsTodoResourceResponse.ADAPTER.decode(r100);
        }
    }

    public static final class l implements RustLog.a<MergeTopicAsTodoResourceResponse> {
        public l() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(MergeTopicAsTodoResourceResponse r100) {
            MergeTopicAsTodoResourceResponse r101 = r100;
            if (r101 == null) goto L8;
            TodoReferResource r102 = r101.resource;
            if (r102 == null) goto L8;
            String r103 = r102.f253783id;
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return MergeTopicAsTodoResourceResponse.ADAPTER.decode(r100);
        }
    }

    public static final class m implements RustLog.a<QuitTodoResponse> {
        public m() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(QuitTodoResponse r100) {
            return "TRUE";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return QuitTodoResponse.ADAPTER.decode(r100);
        }
    }

    public static final class n implements RustLog.a<GetTodoDraftResponse> {
        public n() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetTodoDraftResponse r100) {
            GetTodoDraftResponse r101 = r100;
            if (r101 == null) goto L5;
            boolean r102 = Intrinsics.areEqual(r101.found, Boolean.TRUE);
        L6:
            if (r102 == false) goto L11;
            Todo r103 = r101.todo;
            if (r103 == null) goto L11;
            String r104 = LogMessageUtilKt.a(r103);
            if (r104 == null) goto L11;
            return r104;
        L11:
            return "NULL";
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetTodoDraftResponse.ADAPTER.decode(r100);
        }
    }

    public static final class o implements RustLog.a<ShareTodoMessageResponse> {
        public o() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(ShareTodoMessageResponse r100) {
            ShareTodoMessageResponse r101 = r100;
            if (r101 == null) goto L7;
            List<ShareTodoMessageResponse.ShareFailedChat> r102 = r101.failed_chats;
            if (r102 == null) goto L7;
            Integer r103 = Integer.valueOf(r102.size());
        L9:
            return String.valueOf(r103);
        L7:
            r103 = null;
            goto L9
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return ShareTodoMessageResponse.ADAPTER.decode(r100);
        }
    }

    public static final class p implements RustLog.a<UpdateTaskContainerRefResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskContainerRef f444249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskContainerRef f444250b;

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(UpdateTaskContainerRefResponse r100) {
            StringBuilder r101 = new StringBuilder("update container ref: oldRef {container_guid=");
            TaskContainerRef r102 = this.f444249a;
            String r103 = null;
            if (r102 == null) goto L5;
            String r104 = r102.container_guid;
        L6:
            r101.append(r104);
            r101.append(", section_guid=");
            TaskContainerRef r105 = this.f444249a;
            if (r105 == null) goto L9;
            String r106 = r105.section_guid;
        L10:
            r101.append(r106);
            r101.append(", task_guid=");
            TaskContainerRef r107 = this.f444249a;
            if (r107 == null) goto L13;
            String r108 = r107.task_guid;
        L14:
            r101.append(r108);
            r101.append(", rank=");
            TaskContainerRef r109 = this.f444249a;
            if (r109 == null) goto L17;
            r103 = r109.rank;
        L17:
            r101.append(r103);
            r101.append("}, newRef {container_guid=");
            r101.append(this.f444250b.container_guid);
            r101.append(", section_guid=");
            r101.append(this.f444250b.section_guid);
            r101.append(", task_guid=");
            r101.append(this.f444250b.task_guid);
            r101.append(", rank=");
            r101.append(this.f444250b.rank);
            r101.append('}');
            return r101.toString();
        L13:
            r108 = null;
            goto L14
        L9:
            r106 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return UpdateTaskContainerRefResponse.ADAPTER.decode(r100);
        }

        public p(TaskContainerRef r100, TaskContainerRef r101) {
            this.f444249a = r100;
            this.f444250b = r101;
        }
    }

    public static final class q implements RustLog.a<UpdateTodoResponse> {
        public q() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(UpdateTodoResponse r100) {
            UpdateTodoResponse r101 = r100;
            if (r101 == null) goto L8;
            Todo r102 = r101.todo;
            if (r102 == null) goto L8;
            String r103 = LogMessageUtilKt.a(r102);
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return UpdateTodoResponse.ADAPTER.decode(r100);
        }
    }

    static {
        f444248a = new TodoRustCRUD();
    }

    public TodoRustCRUD() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(Continuation<? super Integer> r100) {
        if ((r100 instanceof TodoRustCRUD$getTodoBadge$1) == false) goto L7;
        TodoRustCRUD$getTodoBadge$1 r101 = (TodoRustCRUD$getTodoBadge$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        RustLog.b r106 = (RustLog.b) r103;
        if (r106.f444239b == null) goto L21;
        return null;
    L21:
        GetTodoBadgeResponse r107 = (GetTodoBadgeResponse) r106.f444238a;
        if (r107 == null) goto L26;
        return r107.count;
    L26:
        return Boxing.boxInt(0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r108 = RustLog.f444237a;
        Command r109 = Command.GET_TODO_BADGE;
        GetTodoBadgeRequest.Builder r110 = new GetTodoBadgeRequest.Builder();
        i r111 = new i();
        r101.label = 1;
        r103 = RustLog.a(r109, r110, r111, "", r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new TodoRustCRUD$getTodoBadge$1(this, r100);
        goto L8
    }

    public static Object g(String r100, Continuation r101) {
        MGetServerTodosRequest.Builder r102 = new MGetServerTodosRequest.Builder().guids(CollectionsKt.mutableListOf(new String[]{r100}));
        int r103 = RustLog.f444237a;
        Command r104 = Command.MGET_SERVER_TODOS;
        Intrinsics.checkNotNull(r102);
        return RustLog.a(r104, r102, new g(), "guid: " + r100, r101);
    }

    public final Object d(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof TodoRustCRUD$deleteTodo$1) == false) goto L7;
        TodoRustCRUD$deleteTodo$1 r101 = (TodoRustCRUD$deleteTodo$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L18:
        if (((RustLog.b) r111).f444239b == null) goto L22;
        return Boxing.boxBoolean(false);
    L22:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        DeleteTodosRequest.Builder r112 = new DeleteTodosRequest.Builder().todo_guids(CollectionsKt.mutableListOf(new String[]{r100}));
        int r105 = RustLog.f444237a;
        Command r106 = Command.DELETE_TODOS;
        Intrinsics.checkNotNull(r112);
        r101.label = 1;
        r111 = RustLog.a(r106, r112, new d(), "guid: " + r100, r101);
        if (r111 != r103) goto L18;
        return r103;
    L7:
        r101 = new TodoRustCRUD$deleteTodo$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(String r100, Continuation<? super TodoReferResource> r101) {
        if ((r101 instanceof TodoRustCRUD$getReferResources$1) == false) goto L7;
        TodoRustCRUD$getReferResources$1 r102 = (TodoRustCRUD$getReferResources$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        RustLog.b r107 = (RustLog.b) r104;
        if (r107.f444239b == null) goto L20;
        return null;
    L20:
        GetTodoReferResourcesResponse r108 = (GetTodoReferResourcesResponse) r107.f444238a;
        if (r108 == null) goto L27;
        List<TodoReferResource> r109 = r108.resources;
        if (r109 == null) goto L27;
        TodoReferResource r110 = (TodoReferResource) CollectionsKt.firstOrNull(r109);
        if (r110 == null) goto L27;
        return r110;
    L27:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        GetTodoReferResourcesRequest.Builder r111 = new GetTodoReferResourcesRequest.Builder().resource_ids(CollectionsKt.mutableListOf(new String[]{r100}));
        int r112 = RustLog.f444237a;
        Command r113 = Command.GET_TODO_REFER_RESOURCES;
        Intrinsics.checkNotNull(r111);
        r102.label = 1;
        r104 = RustLog.a(r113, r111, new f(), "resourceId: " + r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new TodoRustCRUD$getReferResources$1(this, r101);
        goto L8
    }

    public final Object m(String r100, Continuation<? super MergeTopicAsTodoResourceResponse> r101) {
        if ((r101 instanceof TodoRustCRUD$mergeTopicAsTodo$1) == false) goto L7;
        TodoRustCRUD$mergeTopicAsTodo$1 r102 = (TodoRustCRUD$mergeTopicAsTodo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        RustLog.b r107 = (RustLog.b) r104;
        if (r107.f444239b == null) goto L22;
        return null;
    L22:
        return r107.f444238a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MergeTopicAsTodoResourceRequest.Builder r108 = new MergeTopicAsTodoResourceRequest.Builder().thread_id(r100);
        int r109 = RustLog.f444237a;
        Command r110 = Command.MERGE_TOPIC_AS_TODO_RESOURCE;
        Intrinsics.checkNotNull(r108);
        r102.label = 1;
        r104 = RustLog.a(r110, r108, new l(), " threadId: " + r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new TodoRustCRUD$mergeTopicAsTodo$1(this, r101);
        goto L8
    }

    public static Object a(String r100, List r101, Continuation r102) {
        CreateSubTasksRequest.Builder r103 = new CreateSubTasksRequest.Builder().ancestor_guid(r100).sub_tasks(r101);
        int r104 = RustLog.f444237a;
        Command r105 = Command.CREATE_SUB_TASKS;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new a(), "guid:" + r100 + ", subtasks:" + LogMessageUtilKt.b(r101), r102);
    }

    public static Object c(DraftScene.Scene r100, String r101, Continuation r102) {
        DeleteTodoDraftRequest.Builder r103 = new DeleteTodoDraftRequest.Builder().scene(new DraftScene.Builder().scene(r100).scene_id(r101).build());
        int r104 = RustLog.f444237a;
        Command r105 = Command.DELETE_TODO_DRAFT;
        Intrinsics.checkNotNull(r103);
        Object r106 = RustLog.a(r105, r103, new c(), "scene: " + r100 + ", sceneId: " + r101, r102);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r106;
    L6:
        return Unit.INSTANCE;
    }

    public static Object q(TaskContainerRef r100, TaskContainerRef r101, Continuation r102) {
        UpdateTaskContainerRefRequest.Builder r103 = new UpdateTaskContainerRefRequest.Builder().old_task_container_ref(r100).new_task_container_ref(r101);
        int r104 = RustLog.f444237a;
        Command r105 = Command.UPDATE_TASK_CONTAINER_REF;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new p(r100, r101), "", r102);
    }

    public static Object r(Todo r100, Todo r101, Continuation r102) {
        UpdateTodoRequest.Builder r103 = new UpdateTodoRequest.Builder().old_todo(r100).todo(r101);
        int r104 = RustLog.f444237a;
        Command r105 = Command.UPDATE_TODO;
        Intrinsics.checkNotNull(r103);
        return RustLog.a(r105, r103, new q(), "old: " + LogMessageUtilKt.a(r100) + ", new: " + LogMessageUtilKt.a(r101), r102);
    }

    public final Object n(String r100, TodoSource r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof TodoRustCRUD$quitTodo$1) == false) goto L7;
        TodoRustCRUD$quitTodo$1 r103 = (TodoRustCRUD$quitTodo$1) r102;
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
    L18:
        if (((RustLog.b) r105).f444239b == null) goto L22;
        return Boxing.boxBoolean(false);
    L22:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        QuitTodoRequest.Builder r108 = new QuitTodoRequest.Builder().todo_guid(r100).source(r101);
        int r109 = RustLog.f444237a;
        Command r110 = Command.QUIT_TODO;
        Intrinsics.checkNotNull(r108);
        r103.label = 1;
        r105 = RustLog.a(r110, r108, new m(), "guid: " + r100, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new TodoRustCRUD$quitTodo$1(this, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object o(DraftScene.Scene r100, String r101, Continuation<? super Todo> r110) {
        if ((r110 instanceof TodoRustCRUD$restoreDraft$1) == false) goto L7;
        TodoRustCRUD$restoreDraft$1 r102 = (TodoRustCRUD$restoreDraft$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        RustLog.b r112 = (RustLog.b) r111;
        if (r112.f444239b == null) goto L20;
        return null;
    L20:
        GetTodoDraftResponse r106 = (GetTodoDraftResponse) r112.f444238a;
        if (r106 == null) goto L23;
        boolean r107 = Intrinsics.areEqual(r106.found, Boxing.boxBoolean(true));
    L24:
        if (r107 == false) goto L29;
        GetTodoDraftResponse r108 = (GetTodoDraftResponse) r112.f444238a;
        if (r108 != null) goto L28;
        return null;
    L28:
        return r108.todo;
    L29:
        return null;
    L23:
        r107 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        GetTodoDraftRequest.Builder r113 = new GetTodoDraftRequest.Builder().scene(new DraftScene.Builder().scene(r100).scene_id(r101).build());
        int r109 = RustLog.f444237a;
        Command r114 = Command.GET_TODO_DRAFT;
        Intrinsics.checkNotNull(r113);
        r102.label = 1;
        r111 = RustLog.a(r114, r113, new n(), "scene: " + r100 + ", sceneId: " + r101, r102);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r102 = new TodoRustCRUD$restoreDraft$1(this, r110);
        goto L8
    }

    public static Object e(String r100, AuthScene r101, boolean r102, Continuation r103) {
        FollowTodoRequest.Builder r104 = new FollowTodoRequest.Builder().todo_guid(r100).is_follow(Boxing.boxBoolean(r102)).auth_scene(r101);
        int r105 = RustLog.f444237a;
        Command r106 = Command.FOLLOW_TODO;
        Intrinsics.checkNotNull(r104);
        e r107 = new e();
        StringBuilder r108 = new StringBuilder("todoGuid:");
        r108.append(r100);
        r108.append(",authId:");
        AuthScene.Type r109 = null;
        if (r101 == null) goto L5;
        String r110 = r101.f253767id;
    L6:
        r108.append(r110);
        r108.append(",authScene:");
        if (r101 == null) goto L9;
        r109 = r101.type;
    L9:
        r108.append(r109);
        r108.append(",isFollow:");
        r108.append(r102);
        return RustLog.a(r106, r104, r107, r108.toString(), r103);
    L5:
        r110 = null;
        goto L6
    }

    public final Object h(String r100, int r101, String r102, Continuation<? super GetPagingSubTaskResponse> r103) {
        if ((r103 instanceof TodoRustCRUD$getSubTasks$1) == false) goto L7;
        TodoRustCRUD$getSubTasks$1 r104 = (TodoRustCRUD$getSubTasks$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L17:
        RustLog.b r109 = (RustLog.b) r106;
        if (r109.f444239b == null) goto L22;
        return null;
    L22:
        return r109.f444238a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        GetPagingSubTaskRequest.Builder r110 = new GetPagingSubTaskRequest.Builder().guid(r100).count(Boxing.boxInt(r101)).last_token(r102);
        int r111 = RustLog.f444237a;
        Command r112 = Command.GET_PAGING_SUB_TASK;
        Intrinsics.checkNotNull(r110);
        h r113 = new h();
        r104.label = 1;
        r106 = RustLog.a(r112, r110, r113, "", r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new TodoRustCRUD$getSubTasks$1(this, r103);
        goto L8
    }

    public final Object l(String r100, List<String> r101, boolean r102, Continuation<? super MergeMessagesAsTodoResourceResponse> r110) {
        if ((r110 instanceof TodoRustCRUD$mergeMessages$1) == false) goto L7;
        TodoRustCRUD$mergeMessages$1 r103 = (TodoRustCRUD$mergeMessages$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        RustLog.b r112 = (RustLog.b) r111;
        if (r112.f444239b == null) goto L22;
        return null;
    L22:
        return r112.f444238a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        MergeMessagesAsTodoResourceRequest.Builder r107 = new MergeMessagesAsTodoResourceRequest.Builder().chat_id(r100).msg_ids(r101).should_merge(Boxing.boxBoolean(r102));
        int r113 = RustLog.f444237a;
        Command r114 = Command.MERGE_MESSAGES_AS_TODO_RESOURCE;
        Intrinsics.checkNotNull(r107);
        k r108 = new k();
        String r109 = "chatId: " + r100 + ", msgIdSize: " + r101.size();
        r103.label = 1;
        r111 = RustLog.a(r114, r107, r108, r109, r103);
        if (r111 != r105) goto L17;
        return r105;
    L7:
        r103 = new TodoRustCRUD$mergeMessages$1(this, r110);
        goto L8
    }

    public final Object b(TodoData r100, List<Todo> r110, List<ContainerSection> r111, String r112, Continuation<? super RustLog.b<CreateTodoResponse>> r113) {
        if ((r113 instanceof TodoRustCRUD$createTodo$1) == false) goto L7;
        TodoRustCRUD$createTodo$1 r101 = (TodoRustCRUD$createTodo$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L32:
        RustLog.b r115 = (RustLog.b) r114;
        ErrorResult r105 = r115.f444239b;
        if (r105 == null) goto L35;
        z8c.a r116 = z8c.a.f570975a;
        z8c.a.c(Scene.TodoCreate, Event.todo_create, r105);
    L35:
        return r115;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        Todo r117 = r100.parseToPb();
        Long r106 = r117.create_milli_time;
        if (r106 != null) goto L17;
    L19:
        ContainerSection.Builder r107 = new ContainerSection.Builder().container_guid(r100.getOwnedContainerGuid()).section_guid(r100.getOwnedSectionGuid());
        if (TextUtils.isEmpty(r100.getOwnedRank()) == false) goto L22;
        String r108 = "000000";
    L23:
        ContainerSection r109 = r107.rank(r108).build();
        CreateTodoRequest.Builder r118 = new CreateTodoRequest.Builder().todo(r117).chat_to_send(r112);
        if (TextUtils.isEmpty(r100.getOwnedContainerGuid()) == false) goto L26;
    L28:
        r109 = null;
    L29:
        CreateTodoRequest.Builder r119 = r118.container_section(r109).task_list_sections(r111).sub_tasks(r110);
        int r120 = RustLog.f444237a;
        Command r121 = Command.CREATE_TODO;
        Intrinsics.checkNotNull(r119);
        b r122 = new b();
        String r123 = "chatId:" + r112 + ", todo: " + LogMessageUtilKt.a(r117) + ", subtasks:" + LogMessageUtilKt.b(r110);
        r101.label = 1;
        r114 = RustLog.a(r121, r119, r122, r123, r101);
        if (r114 != r103) goto L32;
        return r103;
    L26:
        if (TextUtils.isEmpty(r100.getOwnedSectionGuid()) == true) goto L28;
    L22:
        r108 = r100.getOwnedRank();
        goto L23
    L17:
        if (r106.longValue() <= 0) goto L19;
        Log.w("TodoRustCRUD", "createTodo:" + r117.guid + Typography.greater + r117.create_milli_time);
        r117 = r117.newBuilder().create_milli_time(Boxing.boxLong(0)).build();
    L7:
        r101 = new TodoRustCRUD$createTodo$1(this, r113);
        goto L8
    }

    public final Object p(String r100, List<String> r101, Map<String, String> r102, Map<String, String> r110, ShareTodoMessageRequest.ShareType r111, Continuation<? super ShareTodoMessageResponse> r112) {
        if ((r112 instanceof TodoRustCRUD$shareTodo$1) == false) goto L7;
        TodoRustCRUD$shareTodo$1 r103 = (TodoRustCRUD$shareTodo$1) r112;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r113 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L25:
        RustLog.b r114 = (RustLog.b) r113;
        if (r114.f444239b == null) goto L30;
        return null;
    L30:
        return r114.f444238a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ArrayList r115 = new ArrayList();
        Iterator<Map.Entry<String, String>> r107 = r102.entrySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        Map.Entry<String, String> r108 = r107.next();
        r115.add(new ShareTodoMessageRequestThreadInfo.Builder().thread_id(r108.getKey()).chat_id(r108.getValue()).is_reply_in_thread(Boxing.boxBoolean(false)).build());
        goto L16
    L18:
        Iterator<Map.Entry<String, String>> r109 = r110.entrySet().iterator();
    L20:
        if (r109.hasNext() == false) goto L22;
        Map.Entry<String, String> r116 = r109.next();
        r115.add(new ShareTodoMessageRequestThreadInfo.Builder().thread_id(r116.getKey()).chat_id(r116.getValue()).is_reply_in_thread(Boxing.boxBoolean(true)).build());
        goto L20
    L22:
        ShareTodoMessageRequest.Builder r117 = new ShareTodoMessageRequest.Builder().todo_guid(r100).chat_ids(r101).thread_infos(r115).share_type(r111);
        int r118 = RustLog.f444237a;
        Command r119 = Command.SHARE_TODO_MESSAGE;
        Intrinsics.checkNotNull(r117);
        o r120 = new o();
        String r121 = "guid: " + r100 + ", chatIdSize: " + r101.size();
        r103.label = 1;
        r113 = RustLog.a(r119, r117, r120, r121, r103);
        if (r113 != r105) goto L25;
        return r105;
    L7:
        r103 = new TodoRustCRUD$shareTodo$1(this, r112);
        goto L8
    }

    public static Object j(String r100, boolean r101, TodoSource r102, MarkTodoCompletedRequest.Type r103, List r104, String r105, Continuation r110) {
        if (r102 != TodoSource.DOC) goto L5;
        MarkTodoCompletedRequest.Type r106 = MarkTodoCompletedRequest.Type.Todo;
    L6:
        MarkTodoCompletedRequest.Builder r107 = new MarkTodoCompletedRequest.Builder().guid(r100).is_completed(Boxing.boxBoolean(r101)).source(r102).target_user_ids(r104).type(r106).container_id(r105);
        int r108 = RustLog.f444237a;
        Command r109 = Command.MARK_TODO_COMPLETED;
        Intrinsics.checkNotNull(r107);
        return RustLog.a(r109, r107, new j(), "guid: " + r100 + ", isCompleted: " + r101 + ",source: " + r102 + ", type: " + r103 + ",  target_user_ids:" + r104.size(), r110);
    L5:
        r106 = r103;
        goto L6
    }

    public static /* synthetic */ Object k(String r100, boolean r110, TodoSource r111, MarkTodoCompletedRequest.Type r112, List r113, Continuation r114, int r115) {
        String r101 = null;
        if ((r115 & 4) == 0) goto L5;
        TodoSource r102 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        r113 = new ArrayList();
    L9:
        List r103 = r113;
        if ((r115 & 32) == 0) goto L13;
        r101 = "";
    L13:
        return j(r100, r110, r102, r112, r103, r101, r114);
    L5:
        r102 = r111;
        goto L7
    }
}
