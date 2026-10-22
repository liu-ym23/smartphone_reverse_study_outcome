package androidx.camera.core.impl.utils;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.impl.SessionProcessor;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SessionProcessorUtil {
    private SessionProcessorUtil() {
    }

    public static FocusMeteringAction getModifiedFocusMeteringAction(SessionProcessor r7, FocusMeteringAction r8) {
        if (r7 != null) goto L4;
        return r8;
    L4:
        FocusMeteringAction.Builder r0 = new FocusMeteringAction.Builder(r8);
        boolean r4 = true;
        if (r8.getMeteringPointsAf().isEmpty() == false) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (r8.getMeteringPointsAe().isEmpty() == true) goto L16;
        if (isOperationSupported(r7, new int[]{3}) == true) goto L16;
        r0.removePoints(2);
        r1 = true;
    L16:
        if (r8.getMeteringPointsAwb().isEmpty() == false) goto L18;
    L20:
        r4 = r1;
    L21:
        if (r4 == true) goto L23;
        return r8;
    L23:
        FocusMeteringAction r9 = r0.build();
        if (r9.getMeteringPointsAf().isEmpty() == false) goto L32;
        if (r9.getMeteringPointsAe().isEmpty() == false) goto L32;
        if (r9.getMeteringPointsAwb().isEmpty() == false) goto L32;
        return null;
    L32:
        return r0.build();
    L18:
        if (isOperationSupported(r7, new int[]{4}) == true) goto L20;
        r0.removePoints(4);
        goto L21
    L7:
        if (isOperationSupported(r7, new int[]{1, 2}) == true) goto L9;
        r0.removePoints(1);
        r1 = true;
        goto L11
    }

    public static boolean isOperationSupported(SessionProcessor r4, int... r5) {
        if (r4 != null) goto L5;
        return true;
    L5:
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        r0.add(Integer.valueOf(r5[r2]));
        r2 = r2 + 1;
        goto L6
    L9:
        return r4.getSupportedCameraOperations().containsAll(r0);
    }
}
