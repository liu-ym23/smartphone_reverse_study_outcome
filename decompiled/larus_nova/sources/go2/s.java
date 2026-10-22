package go2;

import com.bytedance.android.livesdk.performance.LiveSystemVolumeManager;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class s implements com.bytedance.android.livesdk.performance.q {
    public s() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L5;
        HashMap r102 = (HashMap) r100;
        r102.put(IPerformanceManager.PlayerClient.system_music_current_volume, String.valueOf(LiveSystemVolumeManager.f154399e));
        int r103 = LiveSystemVolumeManager.f154398d;
        r102.put(IPerformanceManager.PlayerClient.system_music_max_volume, String.valueOf(r103));
        int r104 = LiveSystemVolumeManager.f154399e;
        float r105 = ((r104 - LiveSystemVolumeManager.f154400f) * 1.0f) / r103;
        LiveSystemVolumeManager.f154400f = r104;
        r102.put(IPerformanceManager.PlayerClient.system_music_changed, String.valueOf(r105));
        return;
    }
}
