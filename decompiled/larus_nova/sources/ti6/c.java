package ti6;

import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    void a(String r100);

    MixStreamType b();

    void c(String r100, TaskMixerConfig r101, List<f> r102, String r103, boolean r104, boolean r105, HashMap<String, RTCWaterMarkRegion> r106);

    void d(String r100, bg2.e r101, String r102);

    boolean e();
}
