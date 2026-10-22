package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class r implements com.bytedance.android.livesdk.performance.q {
    public r() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L6;
        HashMap r102 = (HashMap) r100;
        r102.put(IPerformanceManager.Temperature.temperature_android, String.valueOf(r101.N));
        return;
    }
}
