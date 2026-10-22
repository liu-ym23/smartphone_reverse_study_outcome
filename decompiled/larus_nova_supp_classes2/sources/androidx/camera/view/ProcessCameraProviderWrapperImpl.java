package androidx.camera.view;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ProcessCameraProviderWrapperImpl implements ProcessCameraProviderWrapper {
    private final ProcessCameraProvider mProcessCameraProvider;

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public ListenableFuture<Void> shutdownAsync() {
        return this.mProcessCameraProvider.shutdownAsync();
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public void unbindAll() {
        this.mProcessCameraProvider.unbindAll();
    }

    public ProcessCameraProviderWrapperImpl(ProcessCameraProvider r1) {
        this.mProcessCameraProvider = r1;
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public CameraInfo getCameraInfo(CameraSelector r2) {
        return this.mProcessCameraProvider.getCameraInfo(r2);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public boolean hasCamera(CameraSelector r2) throws CameraInfoUnavailableException {
        return this.mProcessCameraProvider.hasCamera(r2);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public void unbind(UseCase... r2) {
        this.mProcessCameraProvider.unbind(r2);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public Camera bindToLifecycle(LifecycleOwner r2, CameraSelector r3, UseCaseGroup r4) {
        return this.mProcessCameraProvider.bindToLifecycle(r2, r3, r4);
    }
}
