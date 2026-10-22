package com.larus.home.api.block;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/home/api/block/BlockUserApi;", "", "createBlocklistUserRequest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/home/api/block/BlockUserResponse;", "Lcom/larus/home/api/block/CreateBlocklistUserRequest;", "(Lcom/larus/home/api/block/CreateBlocklistUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBlocklistUserRequest", "Lcom/larus/home/api/block/UnBlockUserResponse;", "Lcom/larus/home/api/block/DeleteBlocklistUserRequest;", "(Lcom/larus/home/api/block/DeleteBlocklistUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserBlocklist", "Lcom/larus/home/api/block/BlockUserListResponse;", "getUserBlocklistRequest", "Lcom/larus/home/api/block/GetUserBlocklistRequest;", "(Lcom/larus/home/api/block/GetUserBlocklistRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BlockUserApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f344075a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f344076a = null;

        static {
            f344076a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, BlockUserApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f344075a = a.f344076a;
    }

    @POST("/alice/user/blocklist/create")
    Object createBlocklistUserRequest(@Body d r100, Continuation<? super BizResponse<BlockUserResponse>> r101);

    @POST("/alice/user/blocklist/delete")
    Object deleteBlocklistUserRequest(@Body e r100, Continuation<? super BizResponse<UnBlockUserResponse>> r101);

    @POST("/alice/user/blocklist/list")
    Object getUserBlocklist(@Body f r100, Continuation<? super BizResponse<BlockUserListResponse>> r101);
}
