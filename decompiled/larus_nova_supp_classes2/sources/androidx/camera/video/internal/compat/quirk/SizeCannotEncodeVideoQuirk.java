package androidx.camera.video.internal.compat.quirk;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SizeCannotEncodeVideoQuirk implements Quirk {
    public SizeCannotEncodeVideoQuirk() {
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static Set<Size> getProblematicSizes() {
        if (isMotoC() == false) goto L7;
        return new HashSet(Collections.singletonList(new Size(720, 1280)));
    L7:
        return Collections.emptySet();
    }

    public static boolean load() {
        return isMotoC();
    }

    public boolean isProblematicEncodeSize(Size r2) {
        return getProblematicSizes().contains(r2);
    }

    public Rect adjustCropRectForProblematicEncodeSize(Rect r2, int r3, VideoEncoderInfo r4) {
        Size r5 = TransformUtils.rotateSize(TransformUtils.rectToSize(r2), r3);
        if (isProblematicEncodeSize(r5) == true) goto L5;
        return r2;
    L5:
        if (r4 == null) goto L7;
        int r6 = r4.getHeightAlignment() / 2;
    L8:
        Rect r0 = new Rect(r2);
        if (r2.width() != r5.getHeight()) goto L11;
        r0.left += r6;
        r0.right -= r6;
    L12:
        return r0;
    L11:
        r0.top += r6;
        r0.bottom -= r6;
        goto L12
    L7:
        r6 = 8;
        goto L8
    }
}
