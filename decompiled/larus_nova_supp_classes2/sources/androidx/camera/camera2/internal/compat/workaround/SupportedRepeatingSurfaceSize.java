package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SupportedRepeatingSurfaceSize {
    private static final Size MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = null;
    private static final Comparator<Size> SIZE_COMPARATOR = null;
    private final RepeatingStreamConstraintForVideoRecordingQuirk mQuirk;

    static {
        MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = new Size(320, 240);
        SIZE_COMPARATOR = new CompareSizesByArea();
    }

    public SupportedRepeatingSurfaceSize() {
        this.mQuirk = (RepeatingStreamConstraintForVideoRecordingQuirk) DeviceQuirks.get(RepeatingStreamConstraintForVideoRecordingQuirk.class);
    }

    public Size[] getSupportedSizes(Size[] r8) {
        if (this.mQuirk != null) goto L5;
        return r8;
    L5:
        if (RepeatingStreamConstraintForVideoRecordingQuirk.isHuaweiMate9() == false) goto L18;
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L13;
        Size r4 = r8[r3];
        if (SIZE_COMPARATOR.compare(r4, MINI_PREVIEW_SIZE_HUAWEI_MATE_9) < 0) goto L11;
        r0.add(r4);
    L11:
        r3 = r3 + 1;
        goto L7
    L13:
        return (Size[]) r0.toArray(new Size[0]);
    L18:
        return r8;
    }
}
