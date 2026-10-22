package com.ss.android.lark.audio.recorder;

import androidx.camera.video.AudioStats;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static final double a(ByteBuffer r100, int r101) {
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L19;
        if (r101 == 0) goto L20;
        r100.limit(r101);
        r100.position(0);
    L8:
        if (r100.remaining() < 16) goto L12;
        short r103 = r100.getShort();
        if (r103 <= 2500) goto L8;
        r102 = r102 + ((double) (r103 * r103));
        goto L8
    L12:
        double r104 = Math.log10(r102 / ((double) r101));
        double r105 = r104 * ((double) 20);
        r100.limit(r101);
        r100.position(0);
        return r105;
    L20:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L19:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static final double b(ByteBuffer r100, int r101) {
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L13;
        if (r101 <= 0) goto L14;
        r100.limit(r101);
        r100.position(0);
    L8:
        if (r100.remaining() < 2) goto L10;
        short r103 = r100.getShort();
        r102 = r102 + ((double) (r103 * r103));
        goto L8
    L10:
        double r104 = Math.sqrt((r102 / ((double) r101)) / ((double) 2));
        Log.i("LarkAudioRecorder", "calculateVolume:" + r104 + '/' + r101);
        r100.limit(r101);
        r100.position(0);
        return r104;
    L14:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L13:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
