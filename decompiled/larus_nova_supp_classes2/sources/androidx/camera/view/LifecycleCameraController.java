package androidx.camera.view;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class LifecycleCameraController extends CameraController {
    private static final String TAG = "CamLifecycleController";
    private LifecycleOwner mLifecycleOwner;

    public void shutDownForTests() {
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L6;
        r0.shutdownAsync();
        return;
    }

    @Override // androidx.camera.view.CameraController
    public Camera startCamera() {
        if (this.mLifecycleOwner != null) goto L6;
        return null;
    L6:
        if (this.mCameraProvider != null) goto L8;
        return null;
    L8:
        UseCaseGroup r0 = createUseCaseGroup();
        if (r0 != null) goto L16;
        return null;
    L16:
        return this.mCameraProvider.bindToLifecycle(this.mLifecycleOwner, this.mCameraSelector, r0);
    L13:
        e = move-exception;
        throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", e);
    }

    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        ProcessCameraProviderWrapper r0 = this.mCameraProvider;
        if (r0 == null) goto L6;
        r0.unbindAll();
        return;
    }

    public LifecycleCameraController(Context r1) {
        super(r1);
    }

    public void bindToLifecycle(LifecycleOwner r1) {
        Threads.checkMainThread();
        this.mLifecycleOwner = r1;
        startCameraAndTrackStates();
    }

    public LifecycleCameraController(Context r1, ListenableFuture<ProcessCameraProviderWrapper> r2) {
        super(r1, r2);
    }
}
