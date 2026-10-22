package androidx.camera.video;

import androidx.core.util.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class MediaSpec {
    private static final int AAC_DEFAULT_PROFILE = 2;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";
    public static final int OUTPUT_FORMAT_AUTO = -1;
    public static final int OUTPUT_FORMAT_MPEG_4 = 0;
    public static final int OUTPUT_FORMAT_WEBM = 1;
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";

    public static abstract class Builder {
        public abstract MediaSpec build();

        public abstract AudioSpec getAudioSpec();

        public abstract VideoSpec getVideoSpec();

        public abstract Builder setAudioSpec(AudioSpec r1);

        public abstract Builder setOutputFormat(int r1);

        public abstract Builder setVideoSpec(VideoSpec r1);

        public Builder() {
        }

        public Builder configureAudio(Consumer<AudioSpec.Builder> r2) {
            AudioSpec.Builder r0 = getAudioSpec().toBuilder();
            r2.accept(r0);
            setAudioSpec(r0.build());
            return this;
        }

        public Builder configureVideo(Consumer<VideoSpec.Builder> r2) {
            VideoSpec.Builder r0 = getVideoSpec().toBuilder();
            r2.accept(r0);
            setVideoSpec(r0.build());
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputFormat {
    }

    public static String outputFormatToAudioMime(int r1) {
        if (r1 == 1) goto L6;
        return AUDIO_ENCODER_MIME_MPEG4_DEFAULT;
    L6:
        return AUDIO_ENCODER_MIME_WEBM_DEFAULT;
    }

    public static int outputFormatToMuxerFormat(int r1) {
        if (r1 == 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static String outputFormatToVideoMime(int r1) {
        if (r1 == 1) goto L6;
        return VIDEO_ENCODER_MIME_MPEG4_DEFAULT;
    L6:
        return VIDEO_ENCODER_MIME_WEBM_DEFAULT;
    }

    public abstract AudioSpec getAudioSpec();

    public abstract int getOutputFormat();

    public abstract VideoSpec getVideoSpec();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_MediaSpec.Builder().setOutputFormat(-1).setAudioSpec(AudioSpec.builder().build()).setVideoSpec(VideoSpec.builder().build());
    }

    public MediaSpec() {
    }

    public static int outputFormatToAudioProfile(int r1) {
        if (Objects.equals(outputFormatToAudioMime(r1), AUDIO_ENCODER_MIME_MPEG4_DEFAULT) == false) goto L6;
        return 2;
    L6:
        return -1;
    }
}
