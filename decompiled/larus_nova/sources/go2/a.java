package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements com.bytedance.android.livesdk.performance.q {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L6;
        HashMap r102 = (HashMap) r100;
        r102.put("battery_level", String.valueOf(r101.f154697b0));
        r102.put(IPerformanceManager.Battery.battery_state_android, String.valueOf(r101.f154712g0));
        r102.put(IPerformanceManager.Battery.battery_current, String.valueOf(r101.f154718i0));
        r102.put(IPerformanceManager.Battery.battery_voltage, String.valueOf(r101.f154700c0));
        r102.put(IPerformanceManager.Battery.battery_health, String.valueOf(r101.f154706e0));
        r102.put(IPerformanceManager.Battery.battery_scale, String.valueOf(r101.f154703d0));
        return;
    }
}
