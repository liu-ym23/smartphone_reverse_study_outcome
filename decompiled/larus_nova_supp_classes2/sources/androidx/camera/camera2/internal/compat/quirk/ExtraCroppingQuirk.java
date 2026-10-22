package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExtraCroppingQuirk implements Quirk {
    private static final Map<String, Range<Integer>> SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP = null;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType = null;

        static {
            int[] r0 = new int[SurfaceConfig.ConfigType.values().length];
            $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType = r0;
            r0[SurfaceConfig.ConfigType.PRIV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.YUV.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.JPEG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public ExtraCroppingQuirk() {
    }

    static {
        HashMap r0 = new HashMap();
        SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP = r0;
        r0.put("SM-T580", null);
        r0.put("SM-J710MN", new Range(21, 26));
        r0.put("SM-A320FL", null);
        r0.put("SM-G570M", null);
        r0.put("SM-G610F", null);
        r0.put("SM-G610M", new Range(21, 26));
    }

    private static boolean isSamsungDistortion() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        Range<Integer> r1 = SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP.get(Build.MODEL.toUpperCase(Locale.US));
        if (r1 != null) goto L14;
        return true;
    L14:
        return r1.contains(Integer.valueOf(Build.VERSION.SDK_INT));
    L5:
        if (SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP.containsKey(Build.MODEL.toUpperCase(Locale.US)) == false) goto L7;
        r0 = true;
        goto L8
    }

    public static boolean load() {
        return isSamsungDistortion();
    }

    public Size getVerifiedResolution(SurfaceConfig.ConfigType r3) {
        if (isSamsungDistortion() == false) goto L17;
        int r4 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L14;
        if (r4 == 3) goto L12;
        return null;
    L12:
        return new Size(3264, 1836);
    L14:
        return new Size(1280, 720);
    L16:
        return new Size(1920, 1080);
    L17:
        return null;
    }
}
