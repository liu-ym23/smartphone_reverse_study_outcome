package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ForwardingCameraInfo;
import androidx.camera.core.impl.utils.TransformUtils;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VirtualCameraInfo extends ForwardingCameraInfo {
    private final String mVirtualCameraId;
    private int mVirtualCameraRotationDegrees;

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mVirtualCameraId;
    }

    public VirtualCameraInfo(CameraInfoInternal r3) {
        super(r3);
        this.mVirtualCameraId = "virtual-" + r3.getCameraId() + "-" + UUID.randomUUID().toString();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int r2) {
        return TransformUtils.within360(super.getSensorRotationDegrees(r2) - this.mVirtualCameraRotationDegrees);
    }

    public void setVirtualCameraRotationDegrees(int r1) {
        this.mVirtualCameraRotationDegrees = r1;
    }
}
