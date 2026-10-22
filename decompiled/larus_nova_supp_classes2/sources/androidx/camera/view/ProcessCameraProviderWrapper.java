package androidx.camera.view;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface ProcessCameraProviderWrapper {
    Camera bindToLifecycle(LifecycleOwner r1, CameraSelector r2, UseCaseGroup r3);

    CameraInfo getCameraInfo(CameraSelector r1);

    boolean hasCamera(CameraSelector r1) throws CameraInfoUnavailableException;

    ListenableFuture<Void> shutdownAsync();

    void unbind(UseCase... r1);

    void unbindAll();
}
