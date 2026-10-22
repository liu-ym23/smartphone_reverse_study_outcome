package com.bytedance.applet.jsb;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 {
    public static final boolean a(int r4) {
        Object r0 = AppHost.a.getApplication().getSystemService("audio");
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r4 > r1.getStreamMaxVolume(3)) goto L15;
        if (r4 < 0) goto L16;
        r1.setStreamVolume(3, r4, 1);
        FLogger.a.i("AppletMusicMethod", "setSystemVolume " + r4);
        return true;
    L16:
        return false;
    L15:
        return false;
    L5:
        r1 = null;
        goto L7
    }
}
