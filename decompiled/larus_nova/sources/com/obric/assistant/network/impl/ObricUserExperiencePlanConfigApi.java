package com.obric.assistant.network.impl;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/network/impl/ObricUserExperiencePlanConfigApi;", "", "upsertConfig", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/obric/assistant/network/impl/ConfigUpsertRequest;", "(Lcom/obric/assistant/network/impl/ConfigUpsertRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryConfig", "Lcom/obric/assistant/network/impl/ConfigQueryResponse;", "Lcom/obric/assistant/network/impl/ConfigQueryRequest;", "(Lcom/obric/assistant/network/impl/ConfigQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ObricUserExperiencePlanConfigApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f390336a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f390337a = null;

        static {
            f390337a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r100, ContinuationImpl r110) {
            FlowHttpConnection r101 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.i(ServiceType.OBRIC, ObricUserExperiencePlanConfigApi.class, r100, null, null, "https://platform-api.oceancloudapi.com/", r110, 112);
        }
    }

    static {
        f390336a = a.f390337a;
    }

    @POST("/cloud/driver/kv/query")
    Object queryConfig(@Body ConfigQueryRequest r100, Continuation<? super BizResponse<ConfigQueryResponse>> r101);

    @POST("/cloud/driver/kv/upsert")
    Object upsertConfig(@Body ConfigUpsertRequest r100, Continuation<? super BizResponse<Object>> r101);
}
