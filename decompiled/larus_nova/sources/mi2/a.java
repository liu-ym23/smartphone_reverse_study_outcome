package mi2;

import android.content.Context;
import com.bytedance.android.ec.monitor.duration.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements fl2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f514048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f514049b;

    /* JADX INFO: renamed from: mi2.a$a, reason: collision with other inner class name */
    public static final class C6817a {
    }

    public a() {
    }

    static {
        f514048a = "";
        f514049b = true;
    }

    @Override // xk.b
    public final b a(Context r100, com.bytedance.android.livesdk.livecommerce.playback.multicards.a r101, com.bytedance.android.livesdk.livecommerce.playback.multicards.b r102, com.bytedance.android.livesdk.livecommerce.playback.multicards.c r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomInfo");
        Intrinsics.checkNotNullParameter("", "replayId");
        Intrinsics.checkNotNullParameter(r102, "btmInfo");
        Intrinsics.checkNotNullParameter(r110, "params");
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "roomInfo");
        Intrinsics.checkNotNullParameter(r102, "btmInfo");
        Intrinsics.checkNotNullParameter(r103, "entranceInfo");
        Intrinsics.checkNotNullParameter("1079", "ecomSceneId");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter("", "replayId");
        d r104 = new d(r101, r102, r103, r110);
        f514048a = i.f47987a.create("ec_perf_duration_b736122");
        return new b(r104, r100);
    }
}
