package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraFactory {

    public interface Provider {
        CameraFactory newInstance(Context r1, CameraThreadConfig r2, CameraSelector r3, long r4) throws InitializationException;
    }

    Set<String> getAvailableCameraIds();

    CameraInternal getCamera(String r1) throws CameraUnavailableException;

    CameraCoordinator getCameraCoordinator();

    Object getCameraManager();
}
