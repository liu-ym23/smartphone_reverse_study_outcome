package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements com.bytedance.android.livesdk.performance.q {
    public m() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L6;
        HashMap r102 = (HashMap) r100;
        r102.put(IPerformanceManager.PYTHIA.CURRENT_PYTHIA_SCROE, String.valueOf(r101.f154731n0));
        r102.put(IPerformanceManager.PYTHIA.STABLE_PYTHIA_SCROE, String.valueOf(r101.f154733o0));
        return;
    }
}
