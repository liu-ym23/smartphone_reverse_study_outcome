package ff0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f476647a = null;

    public d() {
    }

    static {
        f476647a = new d();
    }

    public final void a(int r110, String r111, int r112, String r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r111, "step");
        Intrinsics.checkNotNullParameter(r113, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        ALogger.i("HamletAvatarTraceMonitor", "trace, step: " + r111 + ",statusCode: " + r112 + ", statusMsg: " + r113);
        MultiTraceData$TraceEvent r100 = null;
        if (((Boolean) vm2.d.L6.getValue(null, vm2.d.f555776a[399(0x18f, float:5.59E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        if (r114 == null) goto L16;
        Set<String> r102 = r114.keySet();     // Catch: Exception -> L14
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();     // Catch: Exception -> L14
    L11:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();     // Catch: Exception -> L14
        r101.put(r104, r114.get(r104));     // Catch: Exception -> L14
    L16:
        if (r110 != 1) goto L18;
        MultiTraceData$TraceEvent r115 = MultiTraceData$TraceEvent.GameAvatarStart;
    L22:
        r100 = r115;
    L23:
        MultiTraceData$TraceEvent r105 = r100;
        if (r105 == null) goto L31;
        int r116 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.GameAvatar, r105, r111, r112, r113, r101, 64);
        return;
    L31:
        return;
    L18:
        if (r110 != 2) goto L23;
        r115 = MultiTraceData$TraceEvent.GameAvatarEnd;
        goto L22
    }
}
