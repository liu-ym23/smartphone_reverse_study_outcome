package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CaptureCallbackConverter {
    private CaptureCallbackConverter() {
    }

    public static CameraCaptureSession.CaptureCallback toCaptureCallback(CameraCaptureCallback r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        toCaptureCallback(r2, r0);
        if (r0.size() != 1) goto L9;
        return (CameraCaptureSession.CaptureCallback) ListProtector.get(r0, 0);
    L9:
        return Camera2CaptureCallbacks.createComboCallback(r0);
    }

    public static void toCaptureCallback(CameraCaptureCallback r1, List<CameraCaptureSession.CaptureCallback> r2) {
        if ((r1 instanceof CameraCaptureCallbacks.ComboCameraCaptureCallback) == false) goto L9;
        Iterator<CameraCaptureCallback> r3 = ((CameraCaptureCallbacks.ComboCameraCaptureCallback) r1).getCallbacks().iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        toCaptureCallback(r3.next(), r2);
        goto L6
    L15:
        return;
    L9:
        if ((r1 instanceof CaptureCallbackContainer) == false) goto L11;
        r2.add(((CaptureCallbackContainer) r1).getCaptureCallback());
        return;
    L11:
        r2.add(new CaptureCallbackAdapter(r1));
    }
}
