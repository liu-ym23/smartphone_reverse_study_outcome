package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StillCaptureFlow {
    private final boolean mShouldStopRepeatingBeforeStillCapture;

    public StillCaptureFlow() {
        if (((StillCaptureFlashStopRepeatingQuirk) DeviceQuirks.get(StillCaptureFlashStopRepeatingQuirk.class)) == null) goto L5;
        boolean r0 = true;
    L6:
        this.mShouldStopRepeatingBeforeStillCapture = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public boolean shouldStopRepeatingBeforeCapture(List<CaptureRequest> r3, boolean r4) {
        if (this.mShouldStopRepeatingBeforeStillCapture == false) goto L15;
        if (r4 == false) goto L15;
        Iterator<CaptureRequest> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        int r6 = ((Integer) r5.next().get(CaptureRequest.CONTROL_AE_MODE)).intValue();
        if (r6 == 2) goto L13;
        if (r6 != 3) goto L8;
        return true;
    L13:
        return true;
    L15:
        return false;
    }
}
