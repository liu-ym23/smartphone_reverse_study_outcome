package com.larus.avlink.env.event.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import n98.b;
import n98.c;
import n98.d;
import n98.f;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/avlink/env/event/api/DoraEnvObservePersonalMemoryApi;", "", "getUserProfileList", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/event/api/UserProfileListResponse;", "request", "Lcom/larus/avlink/env/event/api/GetUserProfileListRequest;", "(Lcom/larus/avlink/env/event/api/GetUserProfileListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUserProfile", "Lcom/larus/avlink/env/event/api/AddUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/AddUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "Lcom/larus/avlink/env/event/api/UpdateUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/UpdateUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserProfile", "Lcom/larus/avlink/env/event/api/DeleteUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/DeleteUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraEnvObservePersonalMemoryApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f292245a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f292246a = null;

        static {
            f292246a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.DORA, DoraEnvObservePersonalMemoryApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f292245a = a.f292246a;
    }

    @POST("/alice/wearable/diary/add_user_profile")
    Object addUserProfile(@Body n98.a r100, Continuation<? super BizResponse<f>> r101);

    @POST("/alice/wearable/diary/delete_user_profile")
    Object deleteUserProfile(@Body b r100, Continuation<? super BizResponse<f>> r101);

    @POST("/alice/wearable/diary/get_user_profile_list")
    Object getUserProfileList(@Body c r100, Continuation<? super BizResponse<f>> r101);

    @POST("/alice/wearable/diary/update_user_profile")
    Object updateUserProfile(@Body d r100, Continuation<? super BizResponse<f>> r101);
}
