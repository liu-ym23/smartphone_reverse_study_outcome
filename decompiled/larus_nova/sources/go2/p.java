package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements com.bytedance.android.livesdk.performance.q {
    public p() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L10;
        HashMap r102 = (HashMap) r100;
        r102.put("fps", String.valueOf(r101.f154735p0));
        r102.put(IPerformanceManager.Stall.stall_video_ui_rate, String.valueOf(r101.f154741s0));
        r102.put(IPerformanceManager.Stall.stall_ui_rate, String.valueOf(r101.f154743t0));
        r102.put(IPerformanceManager.Stall.stall_ui_rate_new, String.valueOf(r101.f154745u0));
        r102.put(IPerformanceManager.Stall.stall_video_rate, String.valueOf(r101.f154747v0));
        r102.put(IPerformanceManager.Stall.stall_ui_minor_rate, String.valueOf(r101.f154749w0));
        r102.put(IPerformanceManager.Stall.stall_ui_slight_rate, String.valueOf(r101.f154753y0));
        r102.put(IPerformanceManager.Stall.stall_ui_moderate_rate, String.valueOf(r101.A0));
        r102.put(IPerformanceManager.Stall.stall_ui_serious_rate, String.valueOf(r101.C0));
        if (r101.E0 == false) goto L7;
        String r103 = "1";
    L8:
        r102.put(IPerformanceManager.Stall.has_stall, r103);
        r102.put(IPerformanceManager.Stall.stall_drop_frame, r101.F0);
        r102.put(IPerformanceManager.Stall.stall_monitor_duration, String.valueOf(r101.G0));
        r102.put(IPerformanceManager.Stall.stall_ui_count, String.valueOf(r101.J0));
        r102.put(IPerformanceManager.Stall.stall_ui_duration, String.valueOf(r101.I0));
        r102.put(IPerformanceManager.Stall.stall_video_count, String.valueOf(r101.L0));
        r102.put(IPerformanceManager.Stall.stall_video_duration, String.valueOf(r101.M0));
        r102.put(IPerformanceManager.Stall.stall_video_origin_info, r101.H0.toString());
        return;
    L7:
        r103 = "0";
        goto L8
    }
}
