package com.larus.common.pollingconfig.impl;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/common/pollingconfig/impl/PollingConfigNetworkApi;", "", "fetchConfig", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/common/pollingconfig/impl/PollingConfigResponse;", "request", "Lcom/larus/common/pollingconfig/impl/PollingConfigRequest;", "(Lcom/larus/common/pollingconfig/impl/PollingConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMetrics", "Lcom/larus/common/pollingconfig/impl/UploadMetricsRequest;", "(Lcom/larus/common/pollingconfig/impl/UploadMetricsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PollingConfigNetworkApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f326446a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f326447a = null;

        static {
            f326447a = new a();
        }

        public a() {
        }
    }

    static {
        f326446a = a.f326447a;
    }

    @POST("alice/real_time/polling_config")
    Object fetchConfig(@Body e r100, Continuation<? super BizResponse<f>> r101);

    @POST("alice/real_time/emit")
    Object uploadMetrics(@Body h r100, Continuation<? super BizResponse<Object>> r101);
}
