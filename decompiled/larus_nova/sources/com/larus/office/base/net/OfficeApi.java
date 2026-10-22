package com.larus.office.base.net;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import com.larus.office.base.permission.DocBatchMetaRequest;
import com.larus.office.base.permission.DocBatchMetaResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/office/base/net/OfficeApi;", "", "getSubConversationV2", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/base/net/GetSubConversationRespV2;", "request", "Lcom/larus/office/base/net/GetSubConversationRequestV2;", "(Lcom/larus/office/base/net/GetSubConversationRequestV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocBatchMeta", "Lcom/larus/office/base/permission/DocBatchMetaResponse;", "Lcom/larus/office/base/permission/DocBatchMetaRequest;", "(Lcom/larus/office/base/permission/DocBatchMetaRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OfficeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f360583a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f360584a = null;

        static {
            f360584a = new a();
        }

        public a() {
        }
    }

    static {
        f360583a = a.f360584a;
    }

    @POST("alice/writing/docs/batch_meta")
    Object getDocBatchMeta(@Body DocBatchMetaRequest r100, Continuation<? super BizResponse<DocBatchMetaResponse>> r101);

    @POST("samantha/creation/artifact/get_meta_by_resource")
    Object getSubConversationV2(@Body f r100, Continuation<? super BizResponse<g>> r101);
}
