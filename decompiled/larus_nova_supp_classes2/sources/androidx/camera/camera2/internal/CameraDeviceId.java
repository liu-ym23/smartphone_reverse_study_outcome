package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
abstract class CameraDeviceId {
    public abstract String getBrand();

    public abstract String getCameraId();

    public abstract String getDevice();

    public abstract String getModel();

    public CameraDeviceId() {
    }

    public static CameraDeviceId create(String r1, String r2, String r3, String r4) {
        return new AutoValue_CameraDeviceId(r1.toLowerCase(), r2.toLowerCase(), r3.toLowerCase(), r4.toLowerCase());
    }
}
