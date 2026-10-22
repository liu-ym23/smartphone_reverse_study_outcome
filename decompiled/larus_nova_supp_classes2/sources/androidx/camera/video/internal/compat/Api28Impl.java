package androidx.camera.video.internal.compat;

import android.media.MediaCodecInfo;
import android.util.Range;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api28Impl {
    private Api28Impl() {
    }

    public static Range<Integer> getQualityRange(MediaCodecInfo.EncoderCapabilities r0) {
        return r0.getQualityRange();
    }
}
