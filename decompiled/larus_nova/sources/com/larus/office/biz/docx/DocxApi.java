package com.larus.office.biz.docx;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import on9.d;
import on9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/office/biz/docx/DocxApi;", "", "getSubConversationV2", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/biz/docx/GetSubConversationRespV2;", "request", "Lcom/larus/office/biz/docx/GetSubConversationRequestV2;", "(Lcom/larus/office/biz/docx/GetSubConversationRequestV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DocxApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f361254a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f361255a = null;

        static {
            f361255a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, DocxApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f361254a = a.f361255a;
    }

    @POST("samantha/creation/artifact/get_meta_by_resource")
    Object getSubConversationV2(@Body d r100, Continuation<? super BizResponse<e>> r101);
}
