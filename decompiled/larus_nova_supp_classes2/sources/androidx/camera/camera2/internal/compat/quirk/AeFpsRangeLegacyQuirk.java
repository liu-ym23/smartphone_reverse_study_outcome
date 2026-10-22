package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AeFpsRangeLegacyQuirk implements Quirk {
    private final Range<Integer> mAeFpsRange;

    public Range<Integer> getRange() {
        return this.mAeFpsRange;
    }

    public AeFpsRangeLegacyQuirk(CameraCharacteristicsCompat r2) {
        this.mAeFpsRange = pickSuitableFpsRange((Range[]) r2.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private Range<Integer> getCorrectedFpsRange(Range<Integer> r5) {
        int r0 = ((Integer) r5.getUpper()).intValue();
        int r1 = ((Integer) r5.getLower()).intValue();
        if (((Integer) r5.getUpper()).intValue() < 1000) goto L6;
        r0 = ((Integer) r5.getUpper()).intValue() / 1000;
    L6:
        if (((Integer) r5.getLower()).intValue() < 1000) goto L9;
        r1 = ((Integer) r5.getLower()).intValue() / 1000;
    L9:
        return new Range(Integer.valueOf(r1), Integer.valueOf(r0));
    }

    public static boolean load(CameraCharacteristicsCompat r1) {
        Integer r2 = (Integer) r1.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.intValue() != 2) goto L7;
        return true;
    }

    private Range<Integer> pickSuitableFpsRange(Range<Integer>[] r7) {
        Range<Integer> r0 = null;
        if (r7 != null) goto L5;
    L18:
        return r0;
    L5:
        if (r7.length == 0) goto L18;
        int r1 = r7.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L18;
        Range<Integer> r3 = getCorrectedFpsRange(r7[r2]);
        if (((Integer) r3.getUpper()).intValue() != 30) goto L17;
        if (r0 != null) goto L15;
    L16:
        r0 = r3;
        goto L17
    L15:
        if (((Integer) r3.getLower()).intValue() < ((Integer) r0.getLower()).intValue()) goto L16;
    L17:
        r2 = r2 + 1;
        goto L8
    }
}
