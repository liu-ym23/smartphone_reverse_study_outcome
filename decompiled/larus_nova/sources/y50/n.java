package y50;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements wm0.a {
    public n() {
    }

    @Override // wm0.a
    public final void a(JSONObject r100) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", 1, r100);
    }

    @Override // wm0.a
    public final void monitorCommonLog(String r100, JSONObject r101) {
        LiveSlardarMonitor.monitorCommonLog(r100, null, r101);
    }

    @Override // wm0.a
    public final void c(int r100, long r101, JSONObject r102) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", r100, r101, r102);
    }

    @Override // wm0.a
    public final void monitorStatus(String r100, int r101, JSONObject r102) {
        LiveSlardarMonitor.monitorStatus(r100, r101, r102);
    }

    @Override // wm0.a
    public final void d(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveTracingMonitor.i(r100, r101, r102, r103);
    }

    @Override // wm0.a
    public final void g(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        LiveTracingMonitor.g(r100, r101, r102, r103, r104, r105);
    }

    @Override // wm0.a
    public final void b(String r100, String r101, int r102, String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter("ttlive_schema_process_error", "serviceName");
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        SettingKey<Boolean> r103 = LiveTracingMonitor.f64909a;
        if (h.a("ttlive_schema_process_error") == true) goto L7;
        LiveTracingMonitor.l(r113, "status_code", String.valueOf(r102));
        LiveTracingMonitor.l(r113, "status_msg", String.valueOf(r110));
        LiveTracingMonitor.g("ttlive_schema_process_error", r100, r101, r111, r112, r113);
        return;
    }
}
