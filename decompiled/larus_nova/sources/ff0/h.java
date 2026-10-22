package ff0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.utils.p;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f476654a = null;

    public h() {
    }

    static {
        f476654a = new h();
    }

    public final void a(boolean r100, String r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r112, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        ALogger.i("LinkMicXplayBasicTraceMonitor", "trace, isAnchor: " + r100 + ", event: " + r110 + ", statusCode: " + r111 + ", statusMsg: " + r112);
        JSONObject r101 = new JSONObject();
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.InteractXplay, MultiTraceData$TraceEvent.InteractXplay, r110, r111, r112, r101, 64);
    }
}
