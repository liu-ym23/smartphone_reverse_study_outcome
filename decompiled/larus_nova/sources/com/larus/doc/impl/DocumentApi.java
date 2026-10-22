package com.larus.doc.impl;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.larus.doc.api.data.DeleteRequest;
import com.larus.doc.impl.review.DocAppealCreateRequest;
import com.larus.doc.impl.review.DocAppealCreateResponse;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001cH§@¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020 H§@¢\u0006\u0002\u0010!J\"\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020#H§@¢\u0006\u0002\u0010$J\"\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020'H§@¢\u0006\u0002\u0010(¨\u0006*"}, d2 = {"Lcom/larus/doc/impl/DocumentApi;", "", "deleteDocument", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/doc/api/data/DeleteResponse;", "request", "Lcom/larus/doc/api/data/DeleteRequest;", "(Lcom/larus/doc/api/data/DeleteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocShareLink", "Lcom/larus/doc/impl/operation/PublishResponse;", "type", "", "resourceId", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDocPermission", "Lcom/larus/doc/impl/operation/SetDodPublicRequest;", "(Lcom/larus/doc/impl/operation/SetDodPublicRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportDocResource", "Lcom/larus/doc/impl/operation/download/ExportResourceResponse;", "Lcom/larus/doc/impl/operation/download/ExportResourceRequest;", "(Lcom/larus/doc/impl/operation/download/ExportResourceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceDownloadLink", "Lcom/larus/doc/impl/operation/download/GetExportLinkResponse;", "Lcom/larus/doc/impl/operation/download/GetExportLinkRequest;", "(Lcom/larus/doc/impl/operation/download/GetExportLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubConversationV2", "Lcom/larus/doc/impl/chat/data/GetSubConversationRespV2;", "Lcom/larus/doc/impl/chat/data/GetSubConversationRequestV2;", "(Lcom/larus/doc/impl/chat/data/GetSubConversationRequestV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewDocV2", "Lcom/larus/doc/impl/chat/data/CreateNewDocRespV2;", "Lcom/larus/doc/impl/chat/data/CreateNewDocRequestV2;", "(Lcom/larus/doc/impl/chat/data/CreateNewDocRequestV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBrief", "Lcom/larus/doc/impl/operation/UpdateDocBriefRequest;", "(Lcom/larus/doc/impl/operation/UpdateDocBriefRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAppeal", "Lcom/larus/doc/impl/review/DocAppealCreateResponse;", "Lcom/larus/doc/impl/review/DocAppealCreateRequest;", "(Lcom/larus/doc/impl/review/DocAppealCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DocumentApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f331050a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f331051a = null;

        static {
            f331051a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, DocumentApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f331050a = a.f331051a;
    }

    @POST("alice/safety/api/appeal/create")
    Object createAppeal(@Body DocAppealCreateRequest r100, Continuation<? super BizResponse<DocAppealCreateResponse>> r101);

    @POST("samantha/otter/doc/pages/create")
    Object createNewDocV2(@Body h39.c r100, Continuation<? super BizResponse<h39.d>> r101);

    @POST("samantha/otter/doc/pages/delete")
    Object deleteDocument(@Body DeleteRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("samantha/otter/export/page/create")
    Object exportDocResource(@Body com.larus.doc.impl.operation.download.l r100, Continuation<? super BizResponse<com.larus.doc.impl.operation.download.m>> r101);

    @POST("samantha/otter/doc/permission/get_internet_public")
    Object getDocShareLink(@Query("obj_type") int r100, @Query("obj_token") String r101, Continuation<? super BizResponse<com.larus.doc.impl.operation.p>> r102);

    @POST("samantha/otter/export/page/result")
    Object getResourceDownloadLink(@Body com.larus.doc.impl.operation.download.n r100, Continuation<? super BizResponse<com.larus.doc.impl.operation.download.o>> r101);

    @POST("samantha/creation/artifact/get_meta_by_resource")
    Object getSubConversationV2(@Body h39.g r100, Continuation<? super BizResponse<h39.h>> r101);

    @POST("samantha/otter/doc/permission/set_internet_public")
    Object setDocPermission(@Body com.larus.doc.impl.operation.q r100, Continuation<? super BizResponse<Object>> r101);

    @POST("samantha/creation/artifact/update_block")
    Object updateBrief(@Body com.larus.doc.impl.operation.r r100, Continuation<? super BizResponse<Object>> r101);
}
