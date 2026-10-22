package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = null;

    public static abstract class Builder {
        public abstract StreamSpec build();

        public abstract Builder setDynamicRange(DynamicRange r1);

        public abstract Builder setExpectedFrameRateRange(Range<Integer> r1);

        public abstract Builder setImplementationOptions(Config r1);

        public abstract Builder setResolution(Size r1);

        public abstract Builder setZslDisabled(boolean r1);

        public Builder() {
        }
    }

    public StreamSpec() {
    }

    public abstract DynamicRange getDynamicRange();

    public abstract Range<Integer> getExpectedFrameRateRange();

    public abstract Config getImplementationOptions();

    public abstract Size getResolution();

    public abstract boolean getZslDisabled();

    public abstract Builder toBuilder();

    static {
        FRAME_RATE_RANGE_UNSPECIFIED = new Range(0, 0);
    }

    public static Builder builder(Size r1) {
        return new AutoValue_StreamSpec.Builder().setResolution(r1).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED).setDynamicRange(DynamicRange.SDR).setZslDisabled(false);
    }
}
