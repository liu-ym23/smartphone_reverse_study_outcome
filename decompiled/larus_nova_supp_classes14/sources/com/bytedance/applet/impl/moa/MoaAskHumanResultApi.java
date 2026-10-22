package com.bytedance.applet.impl.moa;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \n2\u00020\u0001:\u0001\nJ1\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\b0\u0006H§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applet/impl/moa/MoaAskHumanResultApi;", "", "uploadResult", "Lcom/larus/network/bean/BizResponse;", "", "request", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface MoaAskHumanResultApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/office/tool_local/upload_ask_human_warn_result")
    Object uploadResult(@Body Map<String, Object> r1, Continuation<? super BizResponse<Unit>> r2);
}
