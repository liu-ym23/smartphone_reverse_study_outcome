package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_ResolutionInfo_ResolutionInfoInternal extends ResolutionInfo.ResolutionInfoInternal {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    /* JADX INFO: renamed from: androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends ResolutionInfo.ResolutionInfoInternal.Builder {
        private Rect cropRect;
        private Size resolution;
        private Integer rotationDegrees;

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal build() {
            if (this.resolution != null) goto L5;
            String r0 = " resolution";
        L7:
            if (this.cropRect != null) goto L10;
            r0 = r0 + " cropRect";
        L10:
            if (this.rotationDegrees != null) goto L13;
            r0 = r0 + " rotationDegrees";
        L13:
            if (r0.isEmpty() == false) goto L17;
            return new AutoValue_ResolutionInfo_ResolutionInfoInternal(this.resolution, this.cropRect, this.rotationDegrees.intValue(), null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setCropRect(Rect r2) {
            if (r2 == null) goto L6;
            this.cropRect = r2;
            return this;
        L6:
            throw new NullPointerException("Null cropRect");
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setResolution(Size r2) {
            if (r2 == null) goto L6;
            this.resolution = r2;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setRotationDegrees(int r1) {
            this.rotationDegrees = Integer.valueOf(r1);
            return this;
        }
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        return "ResolutionInfoInternal{resolution=" + this.resolution + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + "}";
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResolutionInfo.ResolutionInfoInternal) == false) goto L16;
        ResolutionInfo.ResolutionInfoInternal r6 = (ResolutionInfo.ResolutionInfoInternal) r5;
        if (this.resolution.equals(r6.getResolution()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.cropRect.equals(r6.getCropRect()) == false) goto L14;
        if (this.rotationDegrees != r6.getRotationDegrees()) goto L14;
        return true;
    L16:
        return false;
    }

    private AutoValue_ResolutionInfo_ResolutionInfoInternal(Size r1, Rect r2, int r3) {
        this.resolution = r1;
        this.cropRect = r2;
        this.rotationDegrees = r3;
    }

    public /* synthetic */ AutoValue_ResolutionInfo_ResolutionInfoInternal(Size r1, Rect r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }
}
