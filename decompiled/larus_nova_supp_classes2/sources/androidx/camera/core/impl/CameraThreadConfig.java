package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class CameraThreadConfig {
    public CameraThreadConfig() {
    }

    public abstract Executor getCameraExecutor();

    public abstract Handler getSchedulerHandler();

    public static CameraThreadConfig create(Executor r1, Handler r2) {
        return new AutoValue_CameraThreadConfig(r1, r2);
    }
}
