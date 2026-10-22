package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CaptureFailedRetryEnabler {
    private final CaptureFailedRetryQuirk mCaptureFailedRetryQuirk;

    public int getRetryCount() {
        CaptureFailedRetryQuirk r0 = this.mCaptureFailedRetryQuirk;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getRetryCount();
    }

    public CaptureFailedRetryEnabler() {
        this.mCaptureFailedRetryQuirk = (CaptureFailedRetryQuirk) DeviceQuirks.get(CaptureFailedRetryQuirk.class);
    }
}
