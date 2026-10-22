package xl2;

import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livesdk.config.oj0;
import com.bytedance.android.livesdkapi.livetrace.ILivePreviewTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.TraceMetaWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ILivePreviewTraceMonitor {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.livetrace.ILivePreviewTraceMonitor
    public final void monitorEvent(TraceMetaWrapper r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "traceMetaWrapper");
        if (oj0.f120910a.getValue().getOpen() == true) goto L5;
        return;
    L5:
        int r104 = e.f64997m;
        e.a r105 = e.b.a(r100.getEventType(), r100.getBusinessType());
        r105.f65016g = r100.getUserId();
        r105.f65015f = r100.getAnchorId();
        r105.f65010a = r100.getTraceId();
        r105.f65014e = r100.getRoomId();
        Map<String, Object> r106 = r100.getIndex();
        if (r106 != null) goto L8;
        r106 = new LinkedHashMap();
    L8:
        Intrinsics.checkNotNullParameter(r106, "index");
        r105.f65019j = r106;
        r105.f65011b = r100.getLogId();
        r105.f65013d = r100.getStep();
        r105.f65012c = r100.getProductId();
        r105.f65017h = r100.getStatusCode();
        r105.f65018i = r100.getStatusMsg();
        e r107 = r105.a();
        a60.e r108 = c.f64995a;
        Intrinsics.checkNotNullParameter(r107, "traceMeta");
        TraceMonitor.i(r107, r101, r102, r103);
    }
}
