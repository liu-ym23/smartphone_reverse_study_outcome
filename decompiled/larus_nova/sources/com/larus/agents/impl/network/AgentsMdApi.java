package com.larus.agents.impl.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/agents/impl/network/AgentsMdApi;", "", "getAgentsMd", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/agents/impl/network/GetAgentsMdData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAgentsMd", "", "request", "Lcom/larus/agents/impl/network/SetAgentsMdRequest;", "(Lcom/larus/agents/impl/network/SetAgentsMdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AgentsMdApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f286697a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f286698a = null;

        static {
            f286698a = new a();
        }

        public a() {
        }
    }

    static {
        f286697a = a.f286698a;
    }

    @POST("/alice/generaltask/memory/get_agentsmd")
    Object getAgentsMd(Continuation<? super BizResponse<d>> r100);

    @POST("/alice/generaltask/memory/set_agentsmd")
    Object setAgentsMd(@Body j r100, Continuation<? super BizResponse<Unit>> r101);
}
