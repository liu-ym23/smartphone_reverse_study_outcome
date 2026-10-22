package com.larus.bmhome.chat.bubble.floating.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerApi;", "", "sendCommonRequest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "request", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizRequest;", "(Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportBannerShow", "Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerShowReportRequest;", "(Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerShowReportRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BubbleBannerApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f297526a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f297527a = null;

        static {
            f297527a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, BubbleBannerApi.class, r110, true, null, null, null, r111, 240);
        }
    }

    static {
        f297526a = a.f297527a;
    }

    @POST("/alice/notify/banner_show_report")
    Object reportBannerShow(@Body BubbleBannerShowReportRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/biz/experience/common_request")
    Object sendCommonRequest(@Body ExperienceCommonBizRequest r100, Continuation<? super BizResponse<ExperienceCommonBizData>> r101);
}
