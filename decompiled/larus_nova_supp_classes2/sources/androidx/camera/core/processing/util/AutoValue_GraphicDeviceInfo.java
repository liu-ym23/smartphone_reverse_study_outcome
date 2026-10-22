package androidx.camera.core.processing.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_GraphicDeviceInfo extends GraphicDeviceInfo {
    private final String eglExtensions;
    private final String eglVersion;
    private final String glExtensions;
    private final String glVersion;

    /* JADX INFO: renamed from: androidx.camera.core.processing.util.AutoValue_GraphicDeviceInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends GraphicDeviceInfo.Builder {
        private String eglExtensions;
        private String eglVersion;
        private String glExtensions;
        private String glVersion;

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo build() {
            if (this.glVersion != null) goto L5;
            String r0 = " glVersion";
        L7:
            if (this.eglVersion != null) goto L10;
            r0 = r0 + " eglVersion";
        L10:
            if (this.glExtensions != null) goto L13;
            r0 = r0 + " glExtensions";
        L13:
            if (this.eglExtensions != null) goto L16;
            r0 = r0 + " eglExtensions";
        L16:
            if (r0.isEmpty() == false) goto L20;
            return new AutoValue_GraphicDeviceInfo(this.glVersion, this.eglVersion, this.glExtensions, this.eglExtensions, null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setEglExtensions(String r2) {
            if (r2 == null) goto L6;
            this.eglExtensions = r2;
            return this;
        L6:
            throw new NullPointerException("Null eglExtensions");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setEglVersion(String r2) {
            if (r2 == null) goto L6;
            this.eglVersion = r2;
            return this;
        L6:
            throw new NullPointerException("Null eglVersion");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setGlExtensions(String r2) {
            if (r2 == null) goto L6;
            this.glExtensions = r2;
            return this;
        L6:
            throw new NullPointerException("Null glExtensions");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setGlVersion(String r2) {
            if (r2 == null) goto L6;
            this.glVersion = r2;
            return this;
        L6:
            throw new NullPointerException("Null glVersion");
        }
    }

    public int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.glVersion + ", eglVersion=" + this.eglVersion + ", glExtensions=" + this.glExtensions + ", eglExtensions=" + this.eglExtensions + "}";
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getEglExtensions() {
        return this.eglExtensions;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getEglVersion() {
        return this.eglVersion;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getGlExtensions() {
        return this.glExtensions;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getGlVersion() {
        return this.glVersion;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GraphicDeviceInfo) == false) goto L18;
        GraphicDeviceInfo r6 = (GraphicDeviceInfo) r5;
        if (this.glVersion.equals(r6.getGlVersion()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.eglVersion.equals(r6.getEglVersion()) == false) goto L16;
        if (this.glExtensions.equals(r6.getGlExtensions()) == false) goto L16;
        if (this.eglExtensions.equals(r6.getEglExtensions()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_GraphicDeviceInfo(String r1, String r2, String r3, String r4) {
        this.glVersion = r1;
        this.eglVersion = r2;
        this.glExtensions = r3;
        this.eglExtensions = r4;
    }

    public /* synthetic */ AutoValue_GraphicDeviceInfo(String r1, String r2, String r3, String r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }
}
