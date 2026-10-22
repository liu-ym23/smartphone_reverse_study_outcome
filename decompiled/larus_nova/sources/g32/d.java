package g32;

import am2.x;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f479796a = 0;

    static {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        j0.l().sendLog("livesdk_live_interactivity_degrade_recieve_request", MapsKt.mapOf(new Pair[]{TuplesKt.to("degrade_scene", "VALUE_ANIMATOR_FALLBACK"), TuplesKt.to("degrade_level", DegradeSceneLevel.Default.NONE.logName()), TuplesKt.to("degrade_dimension", DegradeDimension.ROOM.name()), TuplesKt.to("trigger_source", r100)}), new Object[0]);
    }

    public static void a(e32.a r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "degradeRequest");
        Intrinsics.checkNotNullParameter(r101, "extraInfo");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("degrade_scene", r100.f470901a.name());
        r102.put("degrade_level", r100.f470902b.logName());
        if (r100.f470903c != DegradeDimension.ROOM) goto L5;
        String r103 = "0";
    L6:
        r102.put("degrade_dimension", r103);
        if (r100.f470901a != DegradeScene.PERFORMANCE_FRAME) goto L9;
        r102.putAll(r101);
    L9:
        j0.l().sendLog("livesdk_live_interactivity_degrade_recieve_request", r102, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r103 = "1";
        goto L6
    }
}
