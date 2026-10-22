package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CameraDeviceId extends CameraDeviceId {
    private final String brand;
    private final String cameraId;
    private final String device;
    private final String model;

    public int hashCode() {
        return ((((((this.brand.hashCode() ^ 1000003) * 1000003) ^ this.device.hashCode()) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        return "CameraDeviceId{brand=" + this.brand + ", device=" + this.device + ", model=" + this.model + ", cameraId=" + this.cameraId + "}";
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getBrand() {
        return this.brand;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getModel() {
        return this.model;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraDeviceId) == false) goto L18;
        CameraDeviceId r6 = (CameraDeviceId) r5;
        if (this.brand.equals(r6.getBrand()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.device.equals(r6.getDevice()) == false) goto L16;
        if (this.model.equals(r6.getModel()) == false) goto L16;
        if (this.cameraId.equals(r6.getCameraId()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_CameraDeviceId(String r1, String r2, String r3, String r4) {
        if (r1 == null) goto L19;
        this.brand = r1;
        if (r2 == null) goto L17;
        this.device = r2;
        if (r3 == null) goto L15;
        this.model = r3;
        if (r4 == null) goto L13;
        this.cameraId = r4;
        return;
    L13:
        throw new NullPointerException("Null cameraId");
    L15:
        throw new NullPointerException("Null model");
    L17:
        throw new NullPointerException("Null device");
    L19:
        throw new NullPointerException("Null brand");
    }
}
