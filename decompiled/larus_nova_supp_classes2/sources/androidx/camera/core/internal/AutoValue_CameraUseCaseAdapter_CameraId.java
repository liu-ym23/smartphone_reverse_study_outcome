package androidx.camera.core.internal;

import androidx.camera.core.impl.Identifier;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CameraUseCaseAdapter_CameraId extends CameraUseCaseAdapter.CameraId {
    private final Identifier cameraConfigId;
    private final String cameraIdString;

    public int hashCode() {
        return ((this.cameraIdString.hashCode() ^ 1000003) * 1000003) ^ this.cameraConfigId.hashCode();
    }

    public String toString() {
        return "CameraId{cameraIdString=" + this.cameraIdString + ", cameraConfigId=" + this.cameraConfigId + "}";
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public Identifier getCameraConfigId() {
        return this.cameraConfigId;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public String getCameraIdString() {
        return this.cameraIdString;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraUseCaseAdapter.CameraId) == false) goto L14;
        CameraUseCaseAdapter.CameraId r6 = (CameraUseCaseAdapter.CameraId) r5;
        if (this.cameraIdString.equals(r6.getCameraIdString()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.cameraConfigId.equals(r6.getCameraConfigId()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_CameraUseCaseAdapter_CameraId(String r1, Identifier r2) {
        if (r1 == null) goto L11;
        this.cameraIdString = r1;
        if (r2 == null) goto L9;
        this.cameraConfigId = r2;
        return;
    L9:
        throw new NullPointerException("Null cameraConfigId");
    L11:
        throw new NullPointerException("Null cameraIdString");
    }
}
