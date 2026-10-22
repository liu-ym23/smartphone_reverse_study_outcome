package mi2;

import android.content.Context;
import com.bytedance.android.ec.monitor.duration.i;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements fl2.a {
    public static String a;
    public static boolean b;

    /* JADX INFO: renamed from: mi2.a$a, reason: collision with other inner class name */
    public static final class C0153a {
    }

    public a() {
    }

    static {
        a = "";
        b = true;
    }

    public final b a(Context r7, com.bytedance.android.livesdk.livecommerce.playback.multicards.a r8, com.bytedance.android.livesdk.livecommerce.playback.multicards.b r9, com.bytedance.android.livesdk.livecommerce.playback.multicards.c r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "roomInfo");
        Intrinsics.checkNotNullParameter("", "replayId");
        Intrinsics.checkNotNullParameter(r9, "btmInfo");
        Intrinsics.checkNotNullParameter(r10, "params");
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "roomInfo");
        Intrinsics.checkNotNullParameter(r9, "btmInfo");
        Intrinsics.checkNotNullParameter(r5, "entranceInfo");
        Intrinsics.checkNotNullParameter("1079", "ecomSceneId");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter("", "replayId");
        d r0 = new d(r8, r9, r5, r10);
        a = i.a.create("ec_perf_duration_b736122");
        return new b(r0, r7);
    }
}
