package com.larus.feedback.impl.gateway;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import q99.c;
import q99.d;
import q99.j;
import q99.k;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/feedback/impl/gateway/FlowFeedbackHttpApi;", "", "getContent", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "request", "Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;", "(Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showReport", "", "Lcom/larus/feedback/api/model/FlowFeedbackShownRequest;", "(Lcom/larus/feedback/api/model/FlowFeedbackShownRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickReport", "Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "(Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FlowFeedbackHttpApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f343077a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f343078a = null;

        static {
            f343078a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, FlowFeedbackHttpApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f343077a = a.f343078a;
    }

    @POST("/alice/feedback/click_report")
    Object clickReport(@Body k r100, Continuation<? super BizResponse<Unit>> r101);

    @POST("/alice/feedback/get_content")
    Object getContent(@Body c r100, Continuation<? super BizResponse<d>> r101);

    @POST("/alice/feedback/show_report")
    Object showReport(@Body j r100, Continuation<? super BizResponse<Unit>> r101);
}
