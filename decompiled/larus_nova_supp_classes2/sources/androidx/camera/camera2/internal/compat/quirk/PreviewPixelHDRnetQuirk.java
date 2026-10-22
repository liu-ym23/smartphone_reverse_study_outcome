package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class PreviewPixelHDRnetQuirk implements Quirk {
    private static final List<String> SUPPORTED_DEVICES = null;

    public PreviewPixelHDRnetQuirk() {
    }

    static {
        SUPPORTED_DEVICES = Arrays.asList(new String[]{"sunfish", "bramble", "redfin", "barbet"});
    }

    public static boolean load() {
        if ("Google".equals(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if (SUPPORTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.getDefault())) == false) goto L7;
        return true;
    }
}
