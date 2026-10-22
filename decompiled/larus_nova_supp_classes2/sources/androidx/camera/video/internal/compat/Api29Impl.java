package androidx.camera.video.internal.compat;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api29Impl {
    private Api29Impl() {
    }

    public static AudioRecordingConfiguration getActiveRecordingConfiguration(AudioRecord r0) {
        return r0.getActiveRecordingConfiguration();
    }

    public static boolean isClientSilenced(AudioRecordingConfiguration r0) {
        return r0.isClientSilenced();
    }

    public static void unregisterAudioRecordingCallback(AudioRecord r0, AudioManager.AudioRecordingCallback r1) {
        r0.unregisterAudioRecordingCallback(r1);
    }

    public static void registerAudioRecordingCallback(AudioRecord r0, Executor r1, AudioManager.AudioRecordingCallback r2) {
        r0.registerAudioRecordingCallback(r1, r2);
    }
}
