package com.larus.avlink.activeSummary;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveSummaryApi;", "", "createActiveSummaryInfoRequest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryInfoResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryInfoRequest;", "(Lcom/larus/avlink/activeSummary/ProactiveSummaryInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProactiveSummaryApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f291419a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291420a = null;

        static {
            f291420a = new a();
        }

        public a() {
        }
    }

    static {
        f291419a = a.f291420a;
    }

    @POST("/alice/audio/get_summary_info")
    Object createActiveSummaryInfoRequest(@Body c r100, Continuation<? super BizResponse<f>> r101);
}
