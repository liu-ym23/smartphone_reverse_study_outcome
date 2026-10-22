package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class OverrideAeModeForStillCapture {
    private boolean mAePrecaptureStarted;
    private final boolean mHasAutoFlashUnderExposedQuirk;

    public void onAePrecaptureFinished() {
        this.mAePrecaptureStarted = false;
    }

    public void onAePrecaptureStarted() {
        this.mAePrecaptureStarted = true;
    }

    public OverrideAeModeForStillCapture(Quirks r3) {
        boolean r0 = false;
        this.mAePrecaptureStarted = false;
        if (r3.get(AutoFlashUnderExposedQuirk.class) == null) goto L5;
        r0 = true;
    L5:
        this.mHasAutoFlashUnderExposedQuirk = r0;
    }

    public boolean shouldSetAeModeAlwaysFlash(int r2) {
        if (this.mAePrecaptureStarted == false) goto L8;
        if (r2 != 0) goto L8;
        if (this.mHasAutoFlashUnderExposedQuirk == false) goto L8;
        return true;
    L8:
        return false;
    }
}
