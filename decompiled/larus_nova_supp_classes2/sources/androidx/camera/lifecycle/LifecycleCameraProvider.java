package androidx.camera.lifecycle;

import androidx.camera.core.CameraProvider;
import androidx.camera.core.UseCase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface LifecycleCameraProvider extends CameraProvider {
    boolean isBound(UseCase r1);

    void unbind(UseCase... r1);

    void unbindAll();
}
