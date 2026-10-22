package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SessionConfig_OutputConfig extends SessionConfig.OutputConfig {
    private final DynamicRange dynamicRange;
    private final int mirrorMode;
    private final String physicalCameraId;
    private final List<DeferrableSurface> sharedSurfaces;
    private final DeferrableSurface surface;
    private final int surfaceGroupId;

    /* JADX INFO: renamed from: androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends SessionConfig.OutputConfig.Builder {
        private DynamicRange dynamicRange;
        private Integer mirrorMode;
        private String physicalCameraId;
        private List<DeferrableSurface> sharedSurfaces;
        private DeferrableSurface surface;
        private Integer surfaceGroupId;

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig build() {
            if (this.surface != null) goto L5;
            String r0 = " surface";
        L7:
            if (this.sharedSurfaces != null) goto L10;
            r0 = r0 + " sharedSurfaces";
        L10:
            if (this.mirrorMode != null) goto L13;
            r0 = r0 + " mirrorMode";
        L13:
            if (this.surfaceGroupId != null) goto L16;
            r0 = r0 + " surfaceGroupId";
        L16:
            if (this.dynamicRange != null) goto L19;
            r0 = r0 + " dynamicRange";
        L19:
            if (r0.isEmpty() == false) goto L23;
            return new AutoValue_SessionConfig_OutputConfig(this.surface, this.sharedSurfaces, this.physicalCameraId, this.mirrorMode.intValue(), this.surfaceGroupId.intValue(), this.dynamicRange, null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setDynamicRange(DynamicRange r2) {
            if (r2 == null) goto L6;
            this.dynamicRange = r2;
            return this;
        L6:
            throw new NullPointerException("Null dynamicRange");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setMirrorMode(int r1) {
            this.mirrorMode = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setPhysicalCameraId(String r1) {
            this.physicalCameraId = r1;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSharedSurfaces(List<DeferrableSurface> r2) {
            if (r2 == null) goto L6;
            this.sharedSurfaces = r2;
            return this;
        L6:
            throw new NullPointerException("Null sharedSurfaces");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurface(DeferrableSurface r2) {
            if (r2 == null) goto L6;
            this.surface = r2;
            return this;
        L6:
            throw new NullPointerException("Null surface");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurfaceGroupId(int r1) {
            this.surfaceGroupId = Integer.valueOf(r1);
            return this;
        }
    }

    public int hashCode() {
        int r0 = (((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.sharedSurfaces.hashCode()) * 1000003;
        String r2 = this.physicalCameraId;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return ((((((r0 ^ r3) * 1000003) ^ this.mirrorMode) * 1000003) ^ this.surfaceGroupId) * 1000003) ^ this.dynamicRange.hashCode();
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OutputConfig{surface=" + this.surface + ", sharedSurfaces=" + this.sharedSurfaces + ", physicalCameraId=" + this.physicalCameraId + ", mirrorMode=" + this.mirrorMode + ", surfaceGroupId=" + this.surfaceGroupId + ", dynamicRange=" + this.dynamicRange + "}";
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int getMirrorMode() {
        return this.mirrorMode;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public List<DeferrableSurface> getSharedSurfaces() {
        return this.sharedSurfaces;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public DeferrableSurface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int getSurfaceGroupId() {
        return this.surfaceGroupId;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SessionConfig.OutputConfig) == false) goto L27;
        SessionConfig.OutputConfig r6 = (SessionConfig.OutputConfig) r5;
        if (this.surface.equals(r6.getSurface()) == true) goto L10;
    L25:
        return false;
    L10:
        if (this.sharedSurfaces.equals(r6.getSharedSurfaces()) == false) goto L25;
        String r1 = this.physicalCameraId;
        if (r1 != null) goto L17;
        if (r6.getPhysicalCameraId() != null) goto L25;
    L19:
        if (this.mirrorMode != r6.getMirrorMode()) goto L25;
        if (this.surfaceGroupId != r6.getSurfaceGroupId()) goto L25;
        if (this.dynamicRange.equals(r6.getDynamicRange()) == false) goto L25;
        return true;
    L17:
        if (r1.equals(r6.getPhysicalCameraId()) == false) goto L25;
    L27:
        return false;
    }

    private AutoValue_SessionConfig_OutputConfig(DeferrableSurface r1, List<DeferrableSurface> r2, String r3, int r4, int r5, DynamicRange r6) {
        this.surface = r1;
        this.sharedSurfaces = r2;
        this.physicalCameraId = r3;
        this.mirrorMode = r4;
        this.surfaceGroupId = r5;
        this.dynamicRange = r6;
    }

    public /* synthetic */ AutoValue_SessionConfig_OutputConfig(DeferrableSurface r1, List r2, String r3, int r4, int r5, DynamicRange r6, AnonymousClass1 r7) {
        this(r1, r2, r3, r4, r5, r6);
    }
}
