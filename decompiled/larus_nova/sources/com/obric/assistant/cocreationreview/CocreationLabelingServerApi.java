package com.obric.assistant.cocreationreview;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationLabelingServerApi;", "", "submitUserFeedback", "Lcom/larus/network/bean/BizResponse;", "xTtToken", "", "request", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitUserFeedbackStat", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitMemoryTraceReport", "Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface CocreationLabelingServerApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f387036a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f387037a = null;

        static {
            f387037a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r100, Continuation r110) {
            FlowHttpConnection r101 = FlowHttpConnection.f359975a;
            int r102 = k0.f387337a;
            int r103 = iaa.a.f488962a;
            StringBuilder r104 = new StringBuilder("https://");
            if (t9a.b.a().e() == false) goto L5;
            String r105 = "ofa.bytedance.net";
        L6:
            r104.append(r105);
            r104.append('/');
            return FlowHttpConnection.i(ServiceType.OBRIC, CocreationLabelingServerApi.class, r100, null, null, StringsKt.removeSuffix(r104.toString(), HTTP.URL_DEFAULT), r110, 112);
        L5:
            r105 = "ofa.obriccloud.com";
            goto L6
        }
    }

    static {
        f387036a = a.f387037a;
    }

    @POST("/intent/feedback/user/memory-trace-report")
    Object submitMemoryTraceReport(@Header(LoginVerifyService.X_TT_TOKEN) String r100, @Body CocreationMemoryTraceReportRequest r101, Continuation<? super BizResponse<Object>> r102);

    @POST("/intent/feedback/user/new")
    Object submitUserFeedback(@Header(LoginVerifyService.X_TT_TOKEN) String r100, @Body CocreationUserFeedbackRequest r101, Continuation<? super BizResponse<Object>> r102);

    @POST("/intent/feedback/user/stat")
    Object submitUserFeedbackStat(@Header(LoginVerifyService.X_TT_TOKEN) String r100, @Body CocreationUserFeedbackStatRequest r101, Continuation<? super BizResponse<Object>> r102);
}
