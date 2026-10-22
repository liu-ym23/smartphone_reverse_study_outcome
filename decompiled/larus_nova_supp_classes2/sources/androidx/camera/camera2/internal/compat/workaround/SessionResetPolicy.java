package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SessionResetPolicy {
    private final boolean mNeedAbortCapture;

    public boolean needAbortCapture() {
        return this.mNeedAbortCapture;
    }

    public SessionResetPolicy(Quirks r2) {
        this.mNeedAbortCapture = r2.contains(Preview3AThreadCrashQuirk.class);
    }
}
