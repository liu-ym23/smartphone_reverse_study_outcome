package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class q implements com.bytedance.android.livesdk.performance.q {
    public q() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f154693a == false) goto L7;
        HashMap r102 = (HashMap) r100;
        r102.put(IPerformanceManager.Stream.stream_preview_fps, String.valueOf(r101.Q));
        r102.put(IPerformanceManager.Stream.stream_real_fps, String.valueOf(r101.R));
        r102.put(IPerformanceManager.Stream.stream_in_cap_fps, String.valueOf(r101.Y));
        return;
    L7:
        HashMap r103 = (HashMap) r100;
        r103.put(IPerformanceManager.Stream.stream_preview_fps, String.valueOf(r101.Q));
        r103.put(IPerformanceManager.Stream.stream_real_fps, String.valueOf(r101.R));
        r103.put(IPerformanceManager.Stream.stream_host, r101.U);
        r103.put(IPerformanceManager.Stream.stream_cdn_play_url, r101.T);
        r103.put(IPerformanceManager.Stream.stream_cdn_ip, r101.S);
        r103.put("resolution", String.valueOf(Math.min(r101.V, r101.W)));
        if (r101.P == false) goto L10;
        String r104 = "1";
    L11:
        r103.put(IPerformanceManager.Stream.stream_surface_render, r104);
        return;
    L10:
        r104 = "0";
        goto L11
    }
}
