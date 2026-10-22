package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CaptureIntentPreviewQuirk extends Quirk {

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$workaroundByCaptureIntentPreview(CaptureIntentPreviewQuirk r0) {
            return true;
        }

        public static boolean workaroundByCaptureIntentPreview(Quirks r1) {
            Iterator r2 = r1.getAll(CaptureIntentPreviewQuirk.class).iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            if (((CaptureIntentPreviewQuirk) r2.next()).workaroundByCaptureIntentPreview() == false) goto L4;
            return true;
        L9:
            return false;
        }
    }

    boolean workaroundByCaptureIntentPreview();
}
