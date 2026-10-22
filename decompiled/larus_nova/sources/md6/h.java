package md6;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes19.dex */
public final class h {
    public static final double a(long r100, long r101) {
        if (r101 > 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100 / r101;
    }
}
