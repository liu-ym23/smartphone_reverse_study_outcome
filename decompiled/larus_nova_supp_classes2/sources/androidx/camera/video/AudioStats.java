package androidx.camera.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class AudioStats {
    public static final double AUDIO_AMPLITUDE_NONE = 0.0d;
    public static final int AUDIO_STATE_ACTIVE = 0;
    public static final int AUDIO_STATE_DISABLED = 1;
    public static final int AUDIO_STATE_ENCODER_ERROR = 3;
    public static final int AUDIO_STATE_MUTED = 5;
    public static final int AUDIO_STATE_SOURCE_ERROR = 4;
    public static final int AUDIO_STATE_SOURCE_SILENCED = 2;
    private static final Set<Integer> ERROR_STATES = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioState {
    }

    public abstract double getAudioAmplitudeInternal();

    public abstract int getAudioState();

    public abstract Throwable getErrorCause();

    static {
        ERROR_STATES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{2, 3, 4})));
    }

    public boolean hasError() {
        return ERROR_STATES.contains(Integer.valueOf(getAudioState()));
    }

    public double getAudioAmplitude() {
        if (getAudioState() != 1) goto L7;
        return AUDIO_AMPLITUDE_NONE;
    L7:
        return getAudioAmplitudeInternal();
    }

    public boolean hasAudio() {
        if (getAudioState() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public AudioStats() {
    }

    public static AudioStats of(int r1, Throwable r2, double r3) {
        return new AutoValue_AudioStats(r1, r3, r2);
    }
}
