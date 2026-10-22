package androidx.camera.video;

import android.location.Location;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutputOptions {
    public static final int DURATION_UNLIMITED = 0;
    public static final int FILE_SIZE_UNLIMITED = 0;
    private final OutputOptionsInternal mOutputOptionsInternal;

    public static abstract class Builder<T extends OutputOptions, B> {
        final OutputOptionsInternal.Builder<?> mRootInternalBuilder;

        public abstract T build();

        public Builder(OutputOptionsInternal.Builder<?> r3) {
            this.mRootInternalBuilder = r3;
            r3.setFileSizeLimit(0);
            r3.setDurationLimitMillis(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setDurationLimitMillis(long r4) {
            if (r4 < 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "The specified duration limit can't be negative.");
            this.mRootInternalBuilder.setDurationLimitMillis(r4);
            return this;
        L5:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setFileSizeLimit(long r4) {
            if (r4 < 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "The specified file size limit can't be negative.");
            this.mRootInternalBuilder.setFileSizeLimit(r4);
            return this;
        L5:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setLocation(Location r8) {
            if (r8 == null) goto L16;
            boolean r4 = true;
            if (r8.getLatitude() >= (-90.0d)) goto L6;
        L8:
            boolean r0 = false;
        L9:
            Preconditions.checkArgument(r0, "Latitude must be in the range [-90, 90]");
            if (r8.getLongitude() >= (-180.0d)) goto L12;
        L14:
            r4 = false;
        L15:
            Preconditions.checkArgument(r4, "Longitude must be in the range [-180, 180]");
            goto L16
        L12:
            if (r8.getLongitude() > 180.0d) goto L14;
        L6:
            if (r8.getLatitude() > 90.0d) goto L8;
            r0 = true;
        L16:
            this.mRootInternalBuilder.setLocation(r8);
            return this;
        }
    }

    public static abstract class OutputOptionsInternal {

        public static abstract class Builder<B> {
            public Builder() {
            }

            public abstract OutputOptionsInternal build();

            public abstract B setDurationLimitMillis(long r1);

            public abstract B setFileSizeLimit(long r1);

            public abstract B setLocation(Location r1);
        }

        public OutputOptionsInternal() {
        }

        public abstract long getDurationLimitMillis();

        public abstract long getFileSizeLimit();

        public abstract Location getLocation();
    }

    public long getDurationLimitMillis() {
        return this.mOutputOptionsInternal.getDurationLimitMillis();
    }

    public long getFileSizeLimit() {
        return this.mOutputOptionsInternal.getFileSizeLimit();
    }

    public Location getLocation() {
        return this.mOutputOptionsInternal.getLocation();
    }

    public OutputOptions(OutputOptionsInternal r1) {
        this.mOutputOptionsInternal = r1;
    }
}
