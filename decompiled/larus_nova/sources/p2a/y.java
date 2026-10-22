package p2a;

import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: classes4.dex */
public final class y {
    public static final boolean a() {
        Keva r100 = Keva.getRepo("larus_voice_setting_debug_repo");
        if (r100.contains("larus_voice_setting_enable_kmp_debug") == false) goto L6;
        return r100.getBoolean("larus_voice_setting_enable_kmp_debug", false);
    L6:
        return z2.f365865a.enableKmpVoiceSetting();
    }
}
