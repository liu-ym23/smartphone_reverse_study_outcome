package qi0;

import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.live.network.response.BaseResponse;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f533091a = null;

    public d() {
    }

    static {
        f533091a = new d();
    }

    public static String b(Throwable r100) {
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r100).getXTtLogId();
    L6:
        if ((r100 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r101 = ((ResponseNoDataException) r100).getResponse();
        if (r101 == null) goto L11;
        String r102 = r101.logId;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.utils.n
    public final void a(boolean r110, String r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "event");
        Intrinsics.checkNotNullParameter(r113, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        ALogger.i("LinkMicGameTraceMonitor", "trace, isAnchor: " + r110 + ", event: " + r111 + ", statusCode: " + r112 + ", statusMsg: " + r113);
        JSONObject r100 = new JSONObject();
        int r101 = rd0.a.f537202a;
        MultiTraceData$TraceBusiness r102 = MultiTraceData$TraceBusiness.MultiRevenue;
        if (r110 == false) goto L5;
        MultiTraceData$TraceEvent r114 = MultiTraceData$TraceEvent.AnchorCloudGame;
    L6:
        rd0.a.b(r102, r114, r111, r112, r113, r100, 64);
        return;
    L5:
        r114 = MultiTraceData$TraceEvent.GuestCloudGame;
        goto L6
    }
}
