package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AutoFlashUnderExposedQuirk implements Quirk {
    public AutoFlashUnderExposedQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r0) {
        return false;
    }
}
