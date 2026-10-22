package zu1;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.enterparam.ILiveCommonMonitorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ILiveCommonMonitorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f573661a = null;

    public a() {
    }

    static {
        f573661a = new a();
    }

    @Override // com.bytedance.android.livesdkapi.enterparam.ILiveCommonMonitorService
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveTracingMonitor.i(r100, r101, r102, r103);
    }
}
