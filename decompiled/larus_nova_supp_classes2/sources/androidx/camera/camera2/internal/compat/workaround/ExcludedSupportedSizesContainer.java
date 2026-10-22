package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExcludedSupportedSizesContainer {
    private final String mCameraId;

    public ExcludedSupportedSizesContainer(String r1) {
        this.mCameraId = r1;
    }

    public List<Size> get(int r3) {
        ExcludedSupportedSizesQuirk r0 = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getExcludedSizes(this.mCameraId, r3);
    }

    public List<Size> get(Class<?> r3) {
        ExcludedSupportedSizesQuirk r0 = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getExcludedSizes(this.mCameraId, r3);
    }
}
