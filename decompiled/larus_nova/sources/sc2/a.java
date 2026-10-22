package sc2;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.virtualinteract.api.VirtualInteractRetrofitApi;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "createActor")
public final class a extends com.bytedance.ies.web.jsbridge2.f<C7594a, com.bytedance.android.livesdk.interactivity.virtualinteract.model.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f541335a;

    /* JADX INFO: renamed from: sc2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsc2/a$a;", "", "", "roomId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "gameType", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C7594a {

        @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
        private final String gameType;

        @SerializedName("room_id")
        private final Long roomId;

        public final String a() {
            return this.gameType;
        }

        public final Long b() {
            return this.roomId;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f541335a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(C7594a r100, CallContext r101) {
        C7594a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        VirtualInteractRetrofitApi r103 = (VirtualInteractRetrofitApi) com.bytedance.android.live.network.c.b().e(VirtualInteractRetrofitApi.class);
        Disposable r104 = null;
        if (r103 == null) goto L11;
        Pair[] r105 = new Pair[2];
        Long r106 = r102.b();
        if (r106 == null) goto L7;
        String r107 = String.valueOf(r106.longValue());
    L8:
        r105[0] = TuplesKt.to("room_id", r107);
        r105[1] = TuplesKt.to(BdpAppEventConstant.PARAMS_GAME_TYPE, r102.a());
        Observable<Response<com.bytedance.android.livesdk.interactivity.virtualinteract.model.a>> r108 = r103.createActor(new HashMap(MapsKt.mapOf(r105)));
        if (r108 == null) goto L11;
        Observable<Response<com.bytedance.android.livesdk.interactivity.virtualinteract.model.a>> r109 = r108.subscribeOn(Schedulers.io());
    L12:
        if (r109 == null) goto L16;
        Observable<Response<com.bytedance.android.livesdk.interactivity.virtualinteract.model.a>> r110 = r109.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L16;
        r104 = r110.subscribe(new b(this, r102), new c(this));
    L16:
        this.f541335a = r104;
        return;
    L7:
        r107 = null;
    L11:
        r109 = null;
        goto L12
    }
}
