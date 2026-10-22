package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AutoFlashAEModeDisabler {
    private final boolean mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled;
    private final boolean mIsImageCaptureFailWithAutoFlashQuirkEnabled;

    public AutoFlashAEModeDisabler(Quirks r2) {
        this.mIsImageCaptureFailWithAutoFlashQuirkEnabled = r2.contains(ImageCaptureFailWithAutoFlashQuirk.class);
        if (DeviceQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) == null) goto L5;
        boolean r3 = true;
    L6:
        this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public int getCorrectedAeMode(int r2) {
        if (this.mIsImageCaptureFailWithAutoFlashQuirkEnabled == true) goto L7;
        if (this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled == true) goto L7;
        return r2;
    L7:
        if (r2 != 2) goto L11;
        return 1;
    L11:
        return r2;
    }
}
