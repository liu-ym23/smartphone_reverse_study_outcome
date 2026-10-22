package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TemplateParamsOverride {
    private final boolean mWorkaroundByCaptureIntentPreview;
    private final boolean mWorkaroundByCaptureIntentStillCapture;

    public TemplateParamsOverride(Quirks r2) {
        this.mWorkaroundByCaptureIntentPreview = CaptureIntentPreviewQuirk.CC.workaroundByCaptureIntentPreview(r2);
        this.mWorkaroundByCaptureIntentStillCapture = r2.contains(ImageCaptureFailedForVideoSnapshotQuirk.class);
    }

    public Map<CaptureRequest.Key<?>, Object> getOverrideParams(int r3) {
        if (r3 != 3) goto L9;
        if (this.mWorkaroundByCaptureIntentPreview == false) goto L9;
        HashMap r4 = new HashMap();
        r4.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
        return Collections.unmodifiableMap(r4);
    L9:
        if (r3 != 4) goto L15;
        if (this.mWorkaroundByCaptureIntentStillCapture == false) goto L15;
        HashMap r5 = new HashMap();
        r5.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
        return Collections.unmodifiableMap(r5);
    L15:
        return Collections.emptyMap();
    }
}
