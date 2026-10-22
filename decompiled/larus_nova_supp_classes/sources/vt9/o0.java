package vt9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.RealtimeCallSceneModeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class o0 {
    public o0() {
    }

    public static RealtimeCallSceneModeConfig a() {
        if (AppHost.a.isOversea() == false) goto L6;
        return new RealtimeCallSceneModeConfig(false, 0, false, false, 15, null);
    L6:
        return new RealtimeCallSceneModeConfig(false, 180, true, false);
    }
}
