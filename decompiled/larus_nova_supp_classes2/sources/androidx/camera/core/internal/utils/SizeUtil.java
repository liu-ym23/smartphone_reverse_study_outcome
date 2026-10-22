package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_1080P = null;
    public static final Size RESOLUTION_1440P = null;
    public static final Size RESOLUTION_480P = null;
    public static final Size RESOLUTION_720P = null;
    public static final Size RESOLUTION_QVGA = null;
    public static final Size RESOLUTION_VGA = null;
    public static final Size RESOLUTION_ZERO = null;

    public static int getArea(int r0, int r1) {
        return r0 * r1;
    }

    static {
        RESOLUTION_ZERO = new Size(0, 0);
        RESOLUTION_QVGA = new Size(320, 240);
        RESOLUTION_VGA = new Size(640, 480);
        RESOLUTION_480P = new Size(720, 480);
        RESOLUTION_720P = new Size(1280, 720);
        RESOLUTION_1080P = new Size(1920, 1080);
        RESOLUTION_1440P = new Size(1920, 1440);
    }

    private SizeUtil() {
    }

    public static int getArea(Size r1) {
        return getArea(r1.getWidth(), r1.getHeight());
    }

    public static Size getMaxSize(List<Size> r1) {
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return (Size) Collections.max(r1, new CompareSizesByArea());
    }

    public static <T> T findNearestHigherFor(Size r1, TreeMap<Size, T> r2) {
        Map.Entry<Size, T> r0 = r2.ceilingEntry(r1);
        if (r0 != null) goto L5;
        Map.Entry<Size, T> r3 = r2.floorEntry(r1);
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getValue();
    L5:
        return r0.getValue();
    }

    public static boolean isLongerInAnyEdge(Size r2, Size r3) {
        if (r2.getWidth() <= r3.getWidth()) goto L5;
    L8:
        return true;
    L5:
        if (r2.getHeight() > r3.getHeight()) goto L8;
        return false;
    }

    public static boolean isSmallerByArea(Size r0, Size r1) {
        if (getArea(r0) >= getArea(r1)) goto L5;
        return true;
    L5:
        return false;
    }
}
