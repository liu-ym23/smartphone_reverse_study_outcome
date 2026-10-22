package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api23Impl {
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    private Api23Impl() {
    }

    public static AudioRecord build(AudioRecord.Builder r0) {
        return r0.build();
    }

    public static void setAudioFormat(AudioRecord.Builder r0, AudioFormat r1) {
        r0.setAudioFormat(r1);
    }

    public static void setAudioSource(AudioRecord.Builder r0, int r1) {
        r0.setAudioSource(r1);
    }

    public static void setBufferSizeInBytes(AudioRecord.Builder r0, int r1) {
        r0.setBufferSizeInBytes(r1);
    }
}
