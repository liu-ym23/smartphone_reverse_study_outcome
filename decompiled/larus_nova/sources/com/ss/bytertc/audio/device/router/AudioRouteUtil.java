package com.ss.bytertc.audio.device.router;

import android.content.Context;
import com.bytedance.realx.base.ContextUtils;

/* JADX INFO: loaded from: classes40.dex */
public class AudioRouteUtil {
    public AudioRouteUtil() {
    }

    public static String modeString(int r100) {
        if (r100 != 0) goto L4;
        return "MODE_NORMAL";
    L4:
        if (r100 != 1) goto L6;
        return "MODE_RINGTONE";
    L6:
        if (r100 != 2) goto L8;
        return "MODE_IN_CALL";
    L8:
        if (r100 == 3) goto L11;
        return "MODE_INVALID";
    L11:
        return "MODE_IN_COMMUNICATION";
    }

    public static Context getContext() {
        return ContextUtils.getApplicationContext();
    }
}
