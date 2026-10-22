package androidx.camera.video;

import android.util.Range;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoSpec {
    public static final Range<Integer> BITRATE_RANGE_AUTO = null;
    public static final Range<Integer> FRAME_RATE_RANGE_AUTO = null;
    public static final QualitySelector QUALITY_SELECTOR_AUTO = null;

    public static abstract class Builder {
        public abstract VideoSpec build();

        public abstract Builder setAspectRatio(int r1);

        public abstract Builder setBitrate(Range<Integer> r1);

        public abstract Builder setFrameRate(Range<Integer> r1);

        public abstract Builder setQualitySelector(QualitySelector r1);

        public Builder() {
        }
    }

    public abstract int getAspectRatio();

    public abstract Range<Integer> getBitrate();

    public abstract Range<Integer> getFrameRate();

    public abstract QualitySelector getQualitySelector();

    public abstract Builder toBuilder();

    static {
        FRAME_RATE_RANGE_AUTO = new Range(0, Integer.MAX_VALUE);
        BITRATE_RANGE_AUTO = new Range(0, Integer.MAX_VALUE);
        Quality r2 = Quality.FHD;
        QUALITY_SELECTOR_AUTO = QualitySelector.fromOrderedList(Arrays.asList(new Quality[]{r2, Quality.HD, Quality.SD}), FallbackStrategy.higherQualityOrLowerThan(r2));
    }

    public static Builder builder() {
        return new AutoValue_VideoSpec.Builder().setQualitySelector(QUALITY_SELECTOR_AUTO).setFrameRate(FRAME_RATE_RANGE_AUTO).setBitrate(BITRATE_RANGE_AUTO).setAspectRatio(-1);
    }

    public VideoSpec() {
    }
}
