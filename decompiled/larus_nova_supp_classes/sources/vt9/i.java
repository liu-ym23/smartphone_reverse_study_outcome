package vt9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.AudioFeedbackSwitch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i {
    public i() {
    }

    public static AudioFeedbackSwitch a() {
        if (AppHost.a.isOversea() == false) goto L6;
        return new AudioFeedbackSwitch(false, false, false, 7, null);
    L6:
        return new AudioFeedbackSwitch(true, true, false);
    }
}
