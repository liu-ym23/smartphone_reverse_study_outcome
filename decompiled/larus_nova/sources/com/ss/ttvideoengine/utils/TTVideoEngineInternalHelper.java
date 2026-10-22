package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes35.dex */
public class TTVideoEngineInternalHelper {
    public TTVideoEngineInternalHelper() {
    }

    public static float getVolume(Context r100) {
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        int r101 = 0;
        AudioManager r102 = (AudioManager) r100.getSystemService("audio");     // Catch: Exception -> L16
        if (r102 == null) goto L10;
        int r103 = r102.getStreamVolume(3);     // Catch: Exception -> L16
    L11:
        if (r103 < 0) goto L15;
        r101 = r103;
        goto L15
    L10:
        r103 = 0;
    L15:
        return r101;
    }
}
