package rt2;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements vlc.g {
    public e() {
    }

    @Override // vlc.g
    public final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        SettingKey<Boolean> r102 = LiveTracingMonitor.f64909a;
        IHostMonitor r103 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r103 == null) goto L6;
        r103.ensureNotReachHere(r101, r100);
        return;
    }

    @Override // vlc.g
    public final void d(long r100, JSONObject r110, JSONObject r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter("uplink_status_all", "serviceName");
        LiveTracingMonitor.k("uplink_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r100, r110, r111, r112);
    }

    @Override // vlc.g
    public final void e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        LiveTracingMonitor.f(r100, r104, r101, r102, r103);
    }
}
