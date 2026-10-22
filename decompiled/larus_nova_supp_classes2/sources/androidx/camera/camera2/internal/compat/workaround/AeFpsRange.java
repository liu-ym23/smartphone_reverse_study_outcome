package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AeFpsRange {
    private final Range<Integer> mAeTargetFpsRange;

    public AeFpsRange(Quirks r2) {
        AeFpsRangeLegacyQuirk r3 = (AeFpsRangeLegacyQuirk) r2.get(AeFpsRangeLegacyQuirk.class);
        if (r3 != null) goto L5;
        this.mAeTargetFpsRange = null;
        return;
    L5:
        this.mAeTargetFpsRange = r3.getRange();
    }

    public void addAeFpsRangeOptions(Camera2ImplConfig.Builder r4) {
        Range<Integer> r0 = this.mAeTargetFpsRange;
        if (r0 == null) goto L6;
        r4.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, r0, Config.OptionPriority.REQUIRED);
        return;
    }
}
