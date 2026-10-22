package androidx.camera.video.internal.compat;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api24Impl {
    private Api24Impl() {
    }

    public static int getClientAudioSessionId(AudioRecordingConfiguration r0) {
        return r0.getClientAudioSessionId();
    }

    public static int getTimestamp(AudioRecord r0, AudioTimestamp r1, int r2) {
        return r0.getTimestamp(r1, r2);
    }
}
