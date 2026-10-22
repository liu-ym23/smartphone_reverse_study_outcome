package androidx.camera.video.internal.audio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = null;

    public static abstract class Builder {
        public abstract AudioSettings autoBuild();

        public abstract Builder setAudioFormat(int r1);

        public abstract Builder setAudioSource(int r1);

        public abstract Builder setChannelCount(int r1);

        public abstract Builder setSampleRate(int r1);

        public final AudioSettings build() {
            AudioSettings r0 = autoBuild();
            if (r0.getAudioSource() != (-1)) goto L5;
            String r1 = " audioSource";
        L7:
            if (r0.getSampleRate() > 0) goto L10;
            r1 = r1 + " sampleRate";
        L10:
            if (r0.getChannelCount() > 0) goto L13;
            r1 = r1 + " channelCount";
        L13:
            if (r0.getAudioFormat() != (-1)) goto L16;
            r1 = r1 + " audioFormat";
        L16:
            if (r1.isEmpty() == false) goto L19;
            return r0;
        L19:
            throw new IllegalArgumentException("Required settings missing or non-positive:".concat(r1));
        L5:
            r1 = "";
            goto L7
        }

        public Builder() {
        }
    }

    static {
        COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(new Integer[]{48000, 44100, 22050, 11025, 8000, 4800}));
    }

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public abstract int getChannelCount();

    public abstract int getSampleRate();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    public AudioSettings() {
    }
}
