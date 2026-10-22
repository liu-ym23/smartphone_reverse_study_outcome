package androidx.camera.camera2.internal;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface ZslControl {
    void addZslConfig(SessionConfig.Builder r1);

    ImageProxy dequeueImageFromBuffer();

    boolean enqueueImageToImageWriter(ImageProxy r1);

    boolean isZslDisabledByFlashMode();

    boolean isZslDisabledByUserCaseConfig();

    void setZslDisabledByFlashMode(boolean r1);

    void setZslDisabledByUserCaseConfig(boolean r1);
}
