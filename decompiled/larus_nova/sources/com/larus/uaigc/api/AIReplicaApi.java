package com.larus.uaigc.api;

import com.bytedance.retrofit2.http.POST;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/larus/uaigc/api/AIReplicaApi;", "", "getAiReplicaInfo", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAiReplicaTrainQuota", "Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AIReplicaApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370258a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f370259a = null;

        static {
            f370259a = new Companion();
        }

        public Companion() {
        }

        public static Object a(String r110, Continuation r111) {
            return IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, ServiceType.UGC, a.class, "/creativity/aireplica/info", new JSONObject(), null, true, null, MapsKt.mapOf(TuplesKt.to("source", r110)), r111, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        }

        public static Object b(Function2 r100, Continuation r101) {
            return BuildersKt.withContext(Dispatchers.getIO(), new AIReplicaApi$Companion$safeCall$2(r100, null), r101);
        }
    }

    static {
        f370258a = Companion.f370259a;
    }

    @POST("/creativity/aireplica/info")
    Object getAiReplicaInfo(Continuation<? super BizResponse<a>> r100);

    @POST("/creativity/aireplica/train_quota")
    Object getAiReplicaTrainQuota(Continuation<? super BizResponse<b>> r100);
}
