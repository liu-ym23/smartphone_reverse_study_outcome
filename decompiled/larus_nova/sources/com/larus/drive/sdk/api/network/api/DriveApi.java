package com.larus.drive.sdk.api.network.api;

import c89.b;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.drive.sdk.api.network.request.EmptyRequest;
import com.larus.drive.sdk.api.network.resp.GetUserStorageResp;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/drive/sdk/api/network/api/DriveApi;", "", "getSubConversation", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/drive/sdk/api/network/resp/GetSubConversationResp;", "request", "Lcom/larus/drive/sdk/api/network/request/GetSubConversationRequest;", "(Lcom/larus/drive/sdk/api/network/request/GetSubConversationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserStorage", "Lcom/larus/drive/sdk/api/network/resp/GetUserStorageResp;", ContainerPosition.BODY, "Lcom/larus/drive/sdk/api/network/request/EmptyRequest;", "(Lcom/larus/drive/sdk/api/network/request/EmptyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileTokensByUris", "Lcom/larus/drive/sdk/api/network/resp/GetFileTokensByUrisResp;", "Lcom/larus/drive/sdk/api/network/request/GetFileTokensByUrisRequest;", "(Lcom/larus/drive/sdk/api/network/request/GetFileTokensByUrisRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DriveApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f341593a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f341594a = null;

        static {
            f341594a = new a();
        }

        public a() {
        }
    }

    static {
        f341593a = a.f341594a;
    }

    @POST("alice/resource/mget_file_tokens_by_uris")
    Object getFileTokensByUris(@Body c89.a r100, Continuation<? super BizResponse<d89.a>> r101);

    @POST("samantha/creation/artifact/get_meta_by_resource")
    Object getSubConversation(@Body b r100, Continuation<? super BizResponse<d89.b>> r101);

    @POST("alice/aispace/facade/get_user_storage")
    Object getUserStorage(@Body EmptyRequest r100, Continuation<? super BizResponse<GetUserStorageResp>> r101);
}
