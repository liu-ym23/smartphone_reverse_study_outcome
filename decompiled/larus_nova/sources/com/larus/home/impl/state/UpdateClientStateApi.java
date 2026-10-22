package com.larus.home.impl.state;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/home/impl/state/UpdateClientStateApi;", "", "updateClientState", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/home/impl/state/UpdateClientStateRequest;", "(Lcom/larus/home/impl/state/UpdateClientStateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UpdateClientStateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f346276a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346277a = null;

        static {
            f346277a = new a();
        }

        public a() {
        }

        public final Object call(int r110, long r111, Continuation<? super com.larus.network.http.a<? extends Object>> r112) {
            FlowDowngradeServiceDelegate r100 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r101 = new JSONObject();
            r101.put("conn_status_code", r110);
            Unit r113 = Unit.INSTANCE;
            if (r111 != 0) goto L5;
            DowngradeSource r114 = DowngradeSource.COLD_LAUNCH;
        L7:
            return IFlowDowngradeService.a.b(r100, ServiceType.BASIC_SERVICE, Object.class, "/notice/user_client_state", r101, null, false, null, MapsKt.mapOf(TuplesKt.to("source", r114.getValue())), r112, 1008);
        L5:
            r114 = DowngradeSource.POLLING;
            goto L7
        }
    }

    static {
        f346276a = a.f346277a;
    }

    @POST("/notice/user_client_state")
    Object updateClientState(@Body com.larus.home.impl.state.a r100, Continuation<? super BizResponse<Object>> r101);
}
