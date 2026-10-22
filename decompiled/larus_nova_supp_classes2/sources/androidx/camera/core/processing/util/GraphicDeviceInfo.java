package androidx.camera.core.processing.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class GraphicDeviceInfo {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract GraphicDeviceInfo build();

        public abstract Builder setEglExtensions(String r1);

        public abstract Builder setEglVersion(String r1);

        public abstract Builder setGlExtensions(String r1);

        public abstract Builder setGlVersion(String r1);
    }

    public abstract String getEglExtensions();

    public abstract String getEglVersion();

    public abstract String getGlExtensions();

    public abstract String getGlVersion();

    public static Builder builder() {
        return new AutoValue_GraphicDeviceInfo.Builder().setGlVersion(GLUtils.VERSION_UNKNOWN).setEglVersion(GLUtils.VERSION_UNKNOWN).setGlExtensions("").setEglExtensions("");
    }

    public GraphicDeviceInfo() {
    }
}
