package androidx.camera.video.internal.compat;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api31Impl {
    private Api31Impl() {
    }

    public static Range<Integer>[] getInputChannelCountRanges(MediaCodecInfo.AudioCapabilities r0) {
        return r0.getInputChannelCountRanges();
    }

    public static int getMinInputChannelCount(MediaCodecInfo.AudioCapabilities r0) {
        return r0.getMinInputChannelCount();
    }

    public static void setContext(AudioRecord.Builder r0, Context r1) {
        r0.setContext(r1);
    }
}
