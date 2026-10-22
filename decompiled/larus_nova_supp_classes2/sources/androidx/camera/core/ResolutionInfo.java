package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    public static abstract class ResolutionInfoInternal {

        public static abstract class Builder {
            public Builder() {
            }

            public abstract ResolutionInfoInternal build();

            public abstract Builder setCropRect(Rect r1);

            public abstract Builder setResolution(Size r1);

            public abstract Builder setRotationDegrees(int r1);
        }

        public ResolutionInfoInternal() {
        }

        public abstract Rect getCropRect();

        public abstract Size getResolution();

        public abstract int getRotationDegrees();
    }

    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }

    public boolean equals(Object r2) {
        return this.mResolutionInfoInternal.equals(r2);
    }

    public ResolutionInfo(Size r2, Rect r3, int r4) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(r2).setCropRect(r3).setRotationDegrees(r4).build();
    }
}
