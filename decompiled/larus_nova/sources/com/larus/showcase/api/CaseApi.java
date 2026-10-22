package com.larus.showcase.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.model.showcase.CaseActionRequest;
import com.larus.platform.model.showcase.CaseListRequest;
import com.larus.platform.model.showcase.CaseMessageDataRequest;
import com.larus.platform.model.showcase.ListCaseResponse;
import com.larus.platform.model.showcase.RecommendCaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/showcase/api/CaseApi;", "", "requestCaseList", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/platform/model/showcase/ListCaseResponse;", "request", "Lcom/larus/platform/model/showcase/CaseListRequest;", "(Lcom/larus/platform/model/showcase/CaseListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestRecommendCaseList", "Lcom/larus/platform/model/showcase/RecommendCaseResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operatorCase", "", "Lcom/larus/platform/model/showcase/CaseActionRequest;", "(Lcom/larus/platform/model/showcase/CaseActionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaseData", "", "", "Lcom/larus/platform/model/showcase/CaseMessageDataRequest;", "(Lcom/larus/platform/model/showcase/CaseMessageDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f369255a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f369256a = null;

        static {
            f369256a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, CaseApi.class, r110, true, null, null, null, r111, 240);
        }
    }

    static {
        f369255a = a.f369256a;
    }

    @POST("/app_framework/use_case/get_message_data")
    Object getCaseData(@Body CaseMessageDataRequest r100, Continuation<? super BizResponse<List<String>>> r101);

    @POST("/app_framework/use_case/action")
    Object operatorCase(@Body CaseActionRequest r100, Continuation<? super BizResponse<Unit>> r101);

    @POST("/app_framework/use_case/list")
    Object requestCaseList(@Body CaseListRequest r100, Continuation<? super BizResponse<ListCaseResponse>> r101);

    @POST("/app_framework/use_case/recommend/list ")
    Object requestRecommendCaseList(Continuation<? super BizResponse<RecommendCaseResponse>> r100);
}
