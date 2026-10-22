package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TorchStateReset {
    private final boolean mIsImageCaptureTorchIsClosedQuirkEnabled;

    public TorchStateReset() {
        if (DeviceQuirks.get(TorchIsClosedAfterImageCapturingQuirk.class) == null) goto L5;
        boolean r0 = true;
    L6:
        this.mIsImageCaptureTorchIsClosedQuirkEnabled = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public CaptureConfig createTorchResetRequest(CaptureConfig r4) {
        CaptureConfig.Builder r0 = new CaptureConfig.Builder();
        r0.setTemplateType(r4.getTemplateType());
        Iterator<DeferrableSurface> r1 = r4.getSurfaces().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addSurface(r1.next());
        goto L4
    L6:
        r0.addImplementationOptions(r4.getImplementationOptions());
        Camera2ImplConfig.Builder r5 = new Camera2ImplConfig.Builder();
        r5.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
        r0.addImplementationOptions(r5.build());
        return r0.build();
    }

    public boolean isTorchResetRequired(List<CaptureRequest> r2, boolean r3) {
        if (this.mIsImageCaptureTorchIsClosedQuirkEnabled == false) goto L14;
        if (r3 == false) goto L22;
        Iterator<CaptureRequest> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L23;
        Integer r5 = (Integer) r4.next().get(CaptureRequest.FLASH_MODE);
        if (r5 == null) goto L7;
        if (r5.intValue() != 2) goto L7;
        return true;
    L23:
        return false;
    L22:
        return false;
    L14:
        return false;
    }
}
