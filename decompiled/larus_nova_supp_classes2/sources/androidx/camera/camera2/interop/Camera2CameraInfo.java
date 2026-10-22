package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.Camera2PhysicalCameraInfoImpl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CameraInfo {
    private static final String TAG = "Camera2CameraInfo";
    private Camera2CameraInfoImpl mCamera2CameraInfoImpl;
    private Camera2PhysicalCameraInfoImpl mCamera2PhysicalCameraInfo;

    public Map<String, CameraCharacteristics> getCameraCharacteristicsMap() {
        if (this.mCamera2PhysicalCameraInfo == null) goto L7;
        return Collections.emptyMap();
    L7:
        return this.mCamera2CameraInfoImpl.getCameraCharacteristicsMap();
    }

    public String getCameraId() {
        Camera2PhysicalCameraInfoImpl r0 = this.mCamera2PhysicalCameraInfo;
        if (r0 == null) goto L7;
        return r0.getCameraId();
    L7:
        return this.mCamera2CameraInfoImpl.getCameraId();
    }

    public Camera2CameraInfo(Camera2CameraInfoImpl r1) {
        this.mCamera2CameraInfoImpl = r1;
    }

    public static CameraCharacteristics extractCameraCharacteristics(CameraInfo r2) {
        if ((r2 instanceof Camera2PhysicalCameraInfoImpl) == true) goto L5;
        CameraInfoInternal r3 = ((CameraInfoInternal) r2).getImplementation();
        Preconditions.checkState(r3 instanceof Camera2CameraInfoImpl, "CameraInfo does not contain any Camera2 information.");
        return ((Camera2CameraInfoImpl) r3).getCameraCharacteristicsCompat().toCameraCharacteristics();
    L5:
        return ((Camera2PhysicalCameraInfoImpl) r2).getCameraCharacteristicsCompat().toCameraCharacteristics();
    }

    public static Camera2CameraInfo from(CameraInfo r2) {
        if ((r2 instanceof Camera2PhysicalCameraInfoImpl) == true) goto L5;
        CameraInfoInternal r3 = ((CameraInfoInternal) r2).getImplementation();
        Preconditions.checkArgument(r3 instanceof Camera2CameraInfoImpl, "CameraInfo doesn't contain Camera2 implementation.");
        return ((Camera2CameraInfoImpl) r3).getCamera2CameraInfo();
    L5:
        return ((Camera2PhysicalCameraInfoImpl) r2).getCamera2CameraInfo();
    }

    public <T> T getCameraCharacteristic(CameraCharacteristics.Key<T> r2) {
        Camera2PhysicalCameraInfoImpl r0 = this.mCamera2PhysicalCameraInfo;
        if (r0 == null) goto L7;
        return (T) r0.getCameraCharacteristicsCompat().get(r2);
    L7:
        return (T) this.mCamera2CameraInfoImpl.getCameraCharacteristicsCompat().get(r2);
    }

    public Camera2CameraInfo(Camera2PhysicalCameraInfoImpl r1) {
        this.mCamera2PhysicalCameraInfo = r1;
    }
}
