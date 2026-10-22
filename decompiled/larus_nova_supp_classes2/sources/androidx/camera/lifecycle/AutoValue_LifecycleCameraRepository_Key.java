package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.cameraId + "}";
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LifecycleCameraRepository.Key) == false) goto L14;
        LifecycleCameraRepository.Key r6 = (LifecycleCameraRepository.Key) r5;
        if (this.lifecycleOwner.equals(r6.getLifecycleOwner()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.cameraId.equals(r6.getCameraId()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner r1, CameraUseCaseAdapter.CameraId r2) {
        if (r1 == null) goto L11;
        this.lifecycleOwner = r1;
        if (r2 == null) goto L9;
        this.cameraId = r2;
        return;
    L9:
        throw new NullPointerException("Null cameraId");
    L11:
        throw new NullPointerException("Null lifecycleOwner");
    }
}
