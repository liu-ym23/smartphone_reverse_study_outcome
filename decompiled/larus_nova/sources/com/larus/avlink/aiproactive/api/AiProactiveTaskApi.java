package com.larus.avlink.aiproactive.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import t88.c;
import t88.d;
import t88.e;
import t88.f;
import t88.g;
import t88.h;
import t88.i;
import t88.j;
import t88.m;
import t88.o;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/aiproactive/api/AiProactiveTaskApi;", "", "parseUserAonTaskDraft", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/aiproactive/model/UserAonTaskDraft;", "request", "Lcom/larus/avlink/aiproactive/model/ParseUserAonTaskDraftRequest;", "(Lcom/larus/avlink/aiproactive/model/ParseUserAonTaskDraftRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUserAonTask", "Lcom/larus/avlink/aiproactive/model/CreateUserAonTaskResponse;", "Lcom/larus/avlink/aiproactive/model/CreateUserAonTaskRequest;", "(Lcom/larus/avlink/aiproactive/model/CreateUserAonTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserAonTaskList", "Lcom/larus/avlink/aiproactive/model/GetUserAonTaskListResponse;", "Lcom/larus/avlink/aiproactive/model/GetUserAonTaskListRequest;", "(Lcom/larus/avlink/aiproactive/model/GetUserAonTaskListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserAonTask", "Lcom/larus/avlink/aiproactive/model/DeleteUserAonTaskResponse;", "Lcom/larus/avlink/aiproactive/model/DeleteUserAonTaskRequest;", "(Lcom/larus/avlink/aiproactive/model/DeleteUserAonTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeUserAonTaskStatus", "Lcom/larus/avlink/aiproactive/model/ChangeUserAonTaskStatusResponse;", "Lcom/larus/avlink/aiproactive/model/ChangeUserAonTaskStatusRequest;", "(Lcom/larus/avlink/aiproactive/model/ChangeUserAonTaskStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editUserAonTask", "Lcom/larus/avlink/aiproactive/model/EditUserAonTaskResponse;", "Lcom/larus/avlink/aiproactive/model/EditUserAonTaskRequest;", "(Lcom/larus/avlink/aiproactive/model/EditUserAonTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AiProactiveTaskApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f291553a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291554a = null;

        static {
            f291554a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, ContinuationImpl r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.DORA, AiProactiveTaskApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f291553a = a.f291554a;
    }

    @POST("/alice/wearable/aon_task/change_user_aon_task_status")
    Object changeUserAonTaskStatus(@Body c r100, Continuation<? super BizResponse<d>> r101);

    @POST("/alice/wearable/aon_task/create_user_aon_task")
    Object createUserAonTask(@Body e r100, Continuation<? super BizResponse<f>> r101);

    @POST("/alice/wearable/aon_task/delete_user_aon_task_request")
    Object deleteUserAonTask(@Body g r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/alice/wearable/aon_task/edit_user_aon_task")
    Object editUserAonTask(@Body h r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/alice/wearable/aon_task/get_user_aon_task_list")
    Object getUserAonTaskList(@Body i r100, Continuation<? super BizResponse<j>> r101);

    @POST("/alice/wearable/aon_task/parse_user_aon_task_draft")
    Object parseUserAonTaskDraft(@Body m r100, Continuation<? super BizResponse<o>> r101);
}
