package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExcludedSupportedSizesQuirk implements Quirk {
    private static final String TAG = "ExcludedSupportedSizesQuirk";
    private static final int UNKNOWN_IMAGE_FORMAT = -1;

    public ExcludedSupportedSizesQuirk() {
    }

    private static boolean isHuaweiP20Lite() {
        if ("HUAWEI".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HWANE".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isOnePlus6() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("OnePlus6".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isOnePlus6T() {
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("OnePlus6T".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isRedmiNote9Pro() {
        if ("REDMI".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("joyeuse".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ7Api27Above() {
        if ("SAMSUNG".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("J7XELTE".equalsIgnoreCase(Build.DEVICE) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        if ("SAMSUNG".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("ON7XELTE".equalsIgnoreCase(Build.DEVICE) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    public static boolean load() {
        if (isOnePlus6() == false) goto L5;
    L16:
        return true;
    L5:
        if (isOnePlus6T() == true) goto L16;
        if (isHuaweiP20Lite() == true) goto L16;
        if (isSamsungJ7PrimeApi27Above() == true) goto L16;
        if (isSamsungJ7Api27Above() == true) goto L16;
        if (isRedmiNote9Pro() == true) goto L16;
        return false;
    }

    private List<Size> getOnePlus6ExcludedSizes(String r3, int r4) {
        ArrayList r0 = new ArrayList();
        if (r3.equals("0") == true) goto L5;
    L7:
        return r0;
    L5:
        if (r4 != 256) goto L7;
        r0.add(new Size(4160, 3120));
        r0.add(new Size(4000, 3000));
        goto L7
    }

    private List<Size> getOnePlus6TExcludedSizes(String r3, int r4) {
        ArrayList r0 = new ArrayList();
        if (r3.equals("0") == true) goto L5;
    L7:
        return r0;
    L5:
        if (r4 != 256) goto L7;
        r0.add(new Size(4160, 3120));
        r0.add(new Size(4000, 3000));
        goto L7
    }

    private List<Size> getRedmiNote9ProExcludedSizes(String r3, int r4) {
        ArrayList r0 = new ArrayList();
        if (r3.equals("0") == true) goto L5;
    L7:
        return r0;
    L5:
        if (r4 != 256) goto L7;
        r0.add(new Size(9280, 6944));
        goto L7
    }

    public List<Size> getExcludedSizes(String r3, int r4) {
        if (isOnePlus6() == false) goto L7;
        return getOnePlus6ExcludedSizes(r3, r4);
    L7:
        if (isOnePlus6T() == false) goto L11;
        return getOnePlus6TExcludedSizes(r3, r4);
    L11:
        if (isHuaweiP20Lite() == false) goto L15;
        return getHuaweiP20LiteExcludedSizes(r3, r4, null);
    L15:
        if (isSamsungJ7PrimeApi27Above() == false) goto L19;
        return getSamsungJ7PrimeApi27AboveExcludedSizes(r3, r4, null);
    L19:
        if (isSamsungJ7Api27Above() == false) goto L23;
        return getSamsungJ7Api27AboveExcludedSizes(r3, r4, null);
    L23:
        if (isRedmiNote9Pro() == true) goto L25;
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    L25:
        return getRedmiNote9ProExcludedSizes(r3, r4);
    }

    public List<Size> getExcludedSizes(String r3, Class<?> r4) {
        if (isHuaweiP20Lite() == false) goto L7;
        return getHuaweiP20LiteExcludedSizes(r3, -1, r4);
    L7:
        if (isSamsungJ7PrimeApi27Above() == false) goto L11;
        return getSamsungJ7PrimeApi27AboveExcludedSizes(r3, -1, r4);
    L11:
        if (isSamsungJ7Api27Above() == true) goto L13;
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    L13:
        return getSamsungJ7Api27AboveExcludedSizes(r3, -1, r4);
    }

    private List<Size> getHuaweiP20LiteExcludedSizes(String r3, int r4, Class<?> r5) {
        ArrayList r0 = new ArrayList();
        if (r3.equals("0") == true) goto L5;
    L10:
        return r0;
    L5:
        if (r4 != 34) goto L7;
    L9:
        r0.add(new Size(720, 720));
        r0.add(new Size(400, 400));
        goto L10
    L7:
        if (r4 == 35) goto L9;
        if (r5 == null) goto L10;
        goto L9
    }

    private List<Size> getSamsungJ7Api27AboveExcludedSizes(String r10, int r11, Class<?> r12) {
        ArrayList r0 = new ArrayList();
        if (r10.equals("0") == false) goto L11;
        if (r11 == 34) goto L9;
        if (r12 != null) goto L9;
        if (r11 != 35) goto L16;
        r0.add(new Size(2048, 1536));
        r0.add(new Size(2048, 1152));
        r0.add(new Size(1920, 1080));
    L16:
        return r0;
    L9:
        r0.add(new Size(4128, 3096));
        r0.add(new Size(4128, 2322));
        r0.add(new Size(3088, 3088));
        r0.add(new Size(3264, 2448));
        r0.add(new Size(3264, 1836));
        r0.add(new Size(2048, 1536));
        r0.add(new Size(2048, 1152));
        r0.add(new Size(1920, 1080));
        goto L16
    L11:
        if (r10.equals("1") == false) goto L16;
        if (r11 == 34) goto L15;
        if (r11 == 35) goto L15;
        if (r12 == null) goto L16;
    L15:
        r0.add(new Size(2576, 1932));
        r0.add(new Size(2560, 1440));
        r0.add(new Size(1920, 1920));
        r0.add(new Size(2048, 1536));
        r0.add(new Size(2048, 1152));
        r0.add(new Size(1920, 1080));
        goto L16
    }

    private List<Size> getSamsungJ7PrimeApi27AboveExcludedSizes(String r16, int r17, Class<?> r18) {
        ArrayList r2 = new ArrayList();
        if (r16.equals("0") == false) goto L12;
        if (r17 == 34) goto L10;
        if (r18 != null) goto L10;
        if (r17 != 35) goto L17;
        r2.add(new Size(4128, 2322));
        r2.add(new Size(3088, 3088));
        r2.add(new Size(3264, 2448));
        r2.add(new Size(3264, 1836));
        r2.add(new Size(2048, 1536));
        r2.add(new Size(2048, 1152));
        r2.add(new Size(1920, 1080));
    L17:
        return r2;
    L10:
        r2.add(new Size(4128, 3096));
        r2.add(new Size(4128, 2322));
        r2.add(new Size(3088, 3088));
        r2.add(new Size(3264, 2448));
        r2.add(new Size(3264, 1836));
        r2.add(new Size(2048, 1536));
        r2.add(new Size(2048, 1152));
        r2.add(new Size(1920, 1080));
        goto L17
    L12:
        if (r16.equals("1") == false) goto L17;
        if (r17 == 34) goto L16;
        if (r17 == 35) goto L16;
        if (r18 == null) goto L17;
    L16:
        r2.add(new Size(3264, 2448));
        r2.add(new Size(3264, 1836));
        r2.add(new Size(2448, 2448));
        r2.add(new Size(1920, 1920));
        r2.add(new Size(2048, 1536));
        r2.add(new Size(2048, 1152));
        r2.add(new Size(1920, 1080));
        goto L17
    }
}
