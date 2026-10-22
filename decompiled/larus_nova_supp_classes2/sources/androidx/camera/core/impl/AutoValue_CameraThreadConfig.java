package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CameraThreadConfig extends CameraThreadConfig {
    private final Executor cameraExecutor;
    private final Handler schedulerHandler;

    public int hashCode() {
        return ((this.cameraExecutor.hashCode() ^ 1000003) * 1000003) ^ this.schedulerHandler.hashCode();
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.cameraExecutor + ", schedulerHandler=" + this.schedulerHandler + "}";
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    public Executor getCameraExecutor() {
        return this.cameraExecutor;
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    public Handler getSchedulerHandler() {
        return this.schedulerHandler;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraThreadConfig) == false) goto L14;
        CameraThreadConfig r6 = (CameraThreadConfig) r5;
        if (this.cameraExecutor.equals(r6.getCameraExecutor()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.schedulerHandler.equals(r6.getSchedulerHandler()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_CameraThreadConfig(Executor r1, Handler r2) {
        if (r1 == null) goto L11;
        this.cameraExecutor = r1;
        if (r2 == null) goto L9;
        this.schedulerHandler = r2;
        return;
    L9:
        throw new NullPointerException("Null schedulerHandler");
    L11:
        throw new NullPointerException("Null cameraExecutor");
    }
}
