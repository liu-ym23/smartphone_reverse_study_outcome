package xl2;

import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livesdk.config.oj0;
import com.bytedance.android.livesdkapi.livetrace.ILivePreviewTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.LivePreviewTraceSettingConfig;
import com.bytedance.android.livesdkapi.livetrace.TraceMetaWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ILivePreviewTraceMonitor {
    public a() {
    }

    public final void monitorEvent(TraceMetaWrapper r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r4, "traceMetaWrapper");
        if (((LivePreviewTraceSettingConfig) oj0.a.getValue()).getOpen() == true) goto L5;
        return;
    L5:
        int r0 = e.m;
        e.a r1 = e.b.a(r4.getEventType(), r4.getBusinessType());
        r1.g = r4.getUserId();
        r1.f = r4.getAnchorId();
        r1.a = r4.getTraceId();
        r1.e = r4.getRoomId();
        Map r2 = r4.getIndex();
        if (r2 != null) goto L8;
        r2 = new LinkedHashMap();
    L8:
        Intrinsics.checkNotNullParameter(r2, "index");
        r1.j = r2;
        r1.b = r4.getLogId();
        r1.d = r4.getStep();
        r1.c = r4.getProductId();
        r1.h = r4.getStatusCode();
        r1.i = r4.getStatusMsg();
        e r8 = r1.a();
        a60.e r3 = c.a;
        Intrinsics.checkNotNullParameter(r8, "traceMeta");
        TraceMonitor.i(r8, r5, r6, r7);
    }
}
