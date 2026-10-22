package z1b;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f569722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f569724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f569725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f569726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f569727h;

    public a() {
        this.f569720a = "send_start_time";
        this.f569721b = "send_end_time";
        this.f569722c = "send_diff_time";
        this.f569723d = "send_state";
        this.f569724e = SeiMessageConst.MSG_TYPE;
        this.f569725f = "msg_length";
        this.f569726g = 1;
        this.f569727h = 2;
    }

    public final void a() {
        if (getDefaultParamsMap().get(this.f569720a) == null) goto L6;
        Object r100 = getDefaultParamsMap().get(this.f569720a);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Long");
        long r101 = ((Long) r100).longValue();
        long r102 = SystemClock.elapsedRealtime();
        Long r103 = Long.valueOf(r102);
        getDefaultParamsMap().put(this.f569721b, r103);
        getDefaultParamsMap().put(this.f569722c, Long.valueOf(r102 - r101));
        Statistics.sendEvent("perf_send_msg", new JSONObject().put(this.f569720a, getDefaultParamsMap().get(this.f569720a)).put(this.f569721b, getDefaultParamsMap().get(this.f569721b)).put(this.f569722c, getDefaultParamsMap().get(this.f569722c)).put(this.f569723d, getDefaultParamsMap().get(this.f569723d)).put(this.f569724e, getDefaultParamsMap().get(this.f569724e)).put(this.f569725f, getDefaultParamsMap().get(this.f569725f)));
        return;
    }
}
