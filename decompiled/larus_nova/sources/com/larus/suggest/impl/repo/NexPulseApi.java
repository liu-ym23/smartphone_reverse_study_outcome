package com.larus.suggest.impl.repo;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.network.bean.BizResponse;
import ic8.s;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/suggest/impl/repo/NexPulseApi;", "", "getNexPulse", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "request", "Lcom/larus/bmhome/chat/bean/GetNexPulseRequest;", "headers", "", "", "(Lcom/larus/bmhome/chat/bean/GetNexPulseRequest;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface NexPulseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f369908a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f369909a = null;

        static {
            f369909a = new a();
        }

        public a() {
        }
    }

    static {
        f369908a = a.f369909a;
    }

    @POST("/biz/onboarding/get_nexpulse")
    Object getNexPulse(@Body s r100, @HeaderMap Map<String, String> r101, Continuation<? super BizResponse<NexPulseResponseData>> r102);
}
