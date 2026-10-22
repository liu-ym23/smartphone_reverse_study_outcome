package com.larus.avlink.env.diary.feedback.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import j98.h;
import j98.i;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/api/DoraEnvObserveDiaryFeedbackApi;", "", "getFeedbackConfig", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackConfigData;", "request", "Lcom/larus/avlink/env/diary/feedback/model/GetDiaryFeedbackConfigRequest;", "(Lcom/larus/avlink/env/diary/feedback/model/GetDiaryFeedbackConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitFeedback", "Lcom/larus/avlink/env/diary/feedback/model/SubmitDiaryFeedbackRequest;", "(Lcom/larus/avlink/env/diary/feedback/model/SubmitDiaryFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraEnvObserveDiaryFeedbackApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f292058a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f292059a = null;

        static {
            f292059a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.DORA, DoraEnvObserveDiaryFeedbackApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f292058a = a.f292059a;
    }

    @POST("/alice/wearable/feedback/get_config")
    Object getFeedbackConfig(@Body h r100, Continuation<? super BizResponse<j98.a>> r101);

    @POST("/alice/wearable/feedback/submit")
    Object submitFeedback(@Body i r100, Continuation<? super BizResponse<Object>> r101);
}
