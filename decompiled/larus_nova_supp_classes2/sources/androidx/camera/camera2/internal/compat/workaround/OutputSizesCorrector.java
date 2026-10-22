package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class OutputSizesCorrector {
    private static final String TAG = "OutputSizesCorrector";
    private final String mCameraId;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final ExtraSupportedOutputSizeQuirk mExtraSupportedOutputSizeQuirk;

    public OutputSizesCorrector(String r2) {
        this.mExtraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);
        this.mCameraId = r2;
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(r2);
    }

    private void addExtraSupportedOutputSizesByClass(List<Size> r2, Class<?> r3) {
        ExtraSupportedOutputSizeQuirk r0 = this.mExtraSupportedOutputSizeQuirk;
        if (r0 != null) goto L5;
        return;
    L5:
        Size[] r4 = r0.getExtraSupportedResolutions(r3);
        if (r4.length <= 0) goto L9;
        r2.addAll(Arrays.asList(r4));
        return;
    }

    private void addExtraSupportedOutputSizesByFormat(List<Size> r2, int r3) {
        ExtraSupportedOutputSizeQuirk r0 = this.mExtraSupportedOutputSizeQuirk;
        if (r0 != null) goto L5;
        return;
    L5:
        Size[] r4 = r0.getExtraSupportedResolutions(r3);
        if (r4.length <= 0) goto L9;
        r2.addAll(Arrays.asList(r4));
        return;
    }

    private void excludeProblematicOutputSizesByClass(List<Size> r2, Class<?> r3) {
        List<Size> r4 = this.mExcludedSupportedSizesContainer.get(r3);
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        r2.removeAll(r4);
    }

    private void excludeProblematicOutputSizesByFormat(List<Size> r2, int r3) {
        List<Size> r4 = this.mExcludedSupportedSizesContainer.get(r3);
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        r2.removeAll(r4);
    }

    public Size[] applyQuirks(Size[] r2, int r3) {
        ArrayList r0 = new ArrayList(Arrays.asList(r2));
        addExtraSupportedOutputSizesByFormat(r0, r3);
        excludeProblematicOutputSizesByFormat(r0, r3);
        if (r0.isEmpty() == false) goto L6;
        Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
    L6:
        return (Size[]) r0.toArray(new Size[0]);
    }

    public <T> Size[] applyQuirks(Size[] r2, Class<T> r3) {
        ArrayList r0 = new ArrayList(Arrays.asList(r2));
        addExtraSupportedOutputSizesByClass(r0, r3);
        excludeProblematicOutputSizesByClass(r0, r3);
        if (r0.isEmpty() == false) goto L6;
        Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
    L6:
        return (Size[]) r0.toArray(new Size[0]);
    }
}
