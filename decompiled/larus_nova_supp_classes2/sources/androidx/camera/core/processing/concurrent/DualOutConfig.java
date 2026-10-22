package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.OutConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class DualOutConfig {
    public DualOutConfig() {
    }

    public abstract OutConfig getPrimaryOutConfig();

    public abstract OutConfig getSecondaryOutConfig();

    public static DualOutConfig of(OutConfig r1, OutConfig r2) {
        return new AutoValue_DualOutConfig(r1, r2);
    }
}
