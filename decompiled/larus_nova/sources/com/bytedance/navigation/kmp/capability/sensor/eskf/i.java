package com.bytedance.navigation.kmp.capability.sensor.eskf;

import androidx.camera.video.AudioStats;
import com.byted.cast.common.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {
    public static final void a(EskfDeviceHeadingSensor.b r210, int r211, float[] r212, long r213) {
        Intrinsics.checkNotNullParameter(r210, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r212, "values");
        if (r211 == 1) goto L16;
        if (r211 != 2) goto L6;
        r210.c(r212[0], r212[1], r212[2]);
        return;
    L6:
        if (r211 != 4) goto L8;
        r210.b(r212[0], r212[1], r212[2], AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, r213);
        return;
    L8:
        if (r211 != 16) goto L10;
        r210.b(r212[0], r212[1], r212[2], r212[3], r212[4], r212[5], r213);
        return;
    L10:
        if (r211 != 35) goto L22;
        r210.a(r212[0], r212[1], r212[2], r212[3], r212[4], r212[5]);
        return;
    L22:
        return;
    L16:
        r210.a(r212[0], r212[1], r212[2], AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
