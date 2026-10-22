package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_StreamSpec extends StreamSpec {
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Config implementationOptions;
    private final Size resolution;
    private final boolean zslDisabled;

    /* JADX INFO: renamed from: androidx.camera.core.impl.AutoValue_StreamSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends StreamSpec.Builder {
        private DynamicRange dynamicRange;
        private Range<Integer> expectedFrameRateRange;
        private Config implementationOptions;
        private Size resolution;
        private Boolean zslDisabled;

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec build() {
            if (this.resolution != null) goto L5;
            String r0 = " resolution";
        L7:
            if (this.dynamicRange != null) goto L10;
            r0 = r0 + " dynamicRange";
        L10:
            if (this.expectedFrameRateRange != null) goto L13;
            r0 = r0 + " expectedFrameRateRange";
        L13:
            if (this.zslDisabled != null) goto L16;
            r0 = r0 + " zslDisabled";
        L16:
            if (r0.isEmpty() == false) goto L20;
            return new AutoValue_StreamSpec(this.resolution, this.dynamicRange, this.expectedFrameRateRange, this.implementationOptions, this.zslDisabled.booleanValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(StreamSpec r2) {
            this.resolution = r2.getResolution();
            this.dynamicRange = r2.getDynamicRange();
            this.expectedFrameRateRange = r2.getExpectedFrameRateRange();
            this.implementationOptions = r2.getImplementationOptions();
            this.zslDisabled = Boolean.valueOf(r2.getZslDisabled());
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setDynamicRange(DynamicRange r2) {
            if (r2 == null) goto L6;
            this.dynamicRange = r2;
            return this;
        L6:
            throw new NullPointerException("Null dynamicRange");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> r2) {
            if (r2 == null) goto L6;
            this.expectedFrameRateRange = r2;
            return this;
        L6:
            throw new NullPointerException("Null expectedFrameRateRange");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setImplementationOptions(Config r1) {
            this.implementationOptions = r1;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setResolution(Size r2) {
            if (r2 == null) goto L6;
            this.resolution = r2;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setZslDisabled(boolean r1) {
            this.zslDisabled = Boolean.valueOf(r1);
            return this;
        }

        public /* synthetic */ Builder(StreamSpec r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public int hashCode() {
        int r0 = (((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config r2 = this.implementationOptions;
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        int r1 = (r0 ^ r3) * 1000003;
        if (this.zslDisabled == false) goto L9;
        int r4 = 1231;
    L11:
        return r1 ^ r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r3 = r2.hashCode();
        goto L6
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public StreamSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", dynamicRange=" + this.dynamicRange + ", expectedFrameRateRange=" + this.expectedFrameRateRange + ", implementationOptions=" + this.implementationOptions + ", zslDisabled=" + this.zslDisabled + "}";
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public boolean getZslDisabled() {
        return this.zslDisabled;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StreamSpec) == false) goto L25;
        StreamSpec r6 = (StreamSpec) r5;
        if (this.resolution.equals(r6.getResolution()) == true) goto L10;
    L23:
        return false;
    L10:
        if (this.dynamicRange.equals(r6.getDynamicRange()) == false) goto L23;
        if (this.expectedFrameRateRange.equals(r6.getExpectedFrameRateRange()) == false) goto L23;
        Config r1 = this.implementationOptions;
        if (r1 != null) goto L19;
        if (r6.getImplementationOptions() != null) goto L23;
    L21:
        if (this.zslDisabled != r6.getZslDisabled()) goto L23;
        return true;
    L19:
        if (r1.equals(r6.getImplementationOptions()) == false) goto L23;
    L25:
        return false;
    }

    private AutoValue_StreamSpec(Size r1, DynamicRange r2, Range<Integer> r3, Config r4, boolean r5) {
        this.resolution = r1;
        this.dynamicRange = r2;
        this.expectedFrameRateRange = r3;
        this.implementationOptions = r4;
        this.zslDisabled = r5;
    }

    public /* synthetic */ AutoValue_StreamSpec(Size r1, DynamicRange r2, Range r3, Config r4, boolean r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }
}
