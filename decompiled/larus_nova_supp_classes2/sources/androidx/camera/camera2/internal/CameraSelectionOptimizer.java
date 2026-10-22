package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    public static List<String> getSelectedAvailableCameraIds(Camera2CameraFactory r6, CameraSelector r7) throws InitializationException {
        ArrayList r0 = new ArrayList();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        List r1 = Arrays.asList(r6.getCameraManager().getCameraIdList());     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        if (r7 != null) goto L32;
        Iterator r8 = r1.iterator();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
    L6:
        if (r8.hasNext() == false) goto L9;
        r0.add((String) r8.next());     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        goto L6
    L9:
        return r0;
    L32:
        Integer r2 = r7.getLensFacing();     // Catch: IllegalStateException -> L12 CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        String r3 = decideSkippedCameraIdByHeuristic(r6.getCameraManager(), r2, r1);     // Catch: IllegalStateException -> L12 CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
    L13:
        ArrayList r4 = new ArrayList();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        Iterator r5 = r1.iterator();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
    L15:
        if (r5.hasNext() == false) goto L20;
        String r9 = (String) r5.next();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        if (r9.equals(r3) == true) goto L15;
        r4.add(r6.getCameraInfo(r9));     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        goto L15
    L20:
        Iterator<CameraInfo> r10 = r7.filter(r4).iterator();     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
    L22:
        if (r10.hasNext() == false) goto L25;
        r0.add(((CameraInfoInternal) r10.next()).getCameraId());     // Catch: CameraUnavailableException -> L26 CameraAccessExceptionCompat -> L29
        goto L22
    L25:
        return r0;
    L12:
        r3 = null;
    L29:
        e = move-exception;
        throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
    L26:
        e = move-exception;
        throw new InitializationException(e);
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat r4, Integer r5, List<String> r6) throws CameraAccessExceptionCompat {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r6.contains("0") == true) goto L8;
        return null;
    L8:
        if (r6.contains("1") == true) goto L11;
        return null;
    L11:
        if (r5.intValue() != 1) goto L16;
        if (((Integer) r4.getCameraCharacteristicsCompat("0").get(CameraCharacteristics.LENS_FACING)).intValue() == 1) goto L23;
        return null;
    L23:
        return "1";
    L16:
        if (r5.intValue() == 0) goto L18;
        return null;
    L18:
        if (((Integer) r4.getCameraCharacteristicsCompat("1").get(CameraCharacteristics.LENS_FACING)).intValue() == 0) goto L20;
        return null;
    L20:
        return "0";
    }
}
