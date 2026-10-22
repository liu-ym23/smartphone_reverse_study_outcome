package com.relax.relaxreact;

import androidx.camera.video.AudioStats;
import com.relax.relaxreact.utils.__utils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p0 {
    public static final boolean a(Object r100, Object r101) {
        int r102 = __utils.f405591a;
        if (r100 == null) goto L44;
        if (r101 == null) goto L44;
        if (r100 != r101) goto L9;
        return true;
    L9:
        if ((r100 instanceof Boolean) == false) goto L14;
        if ((r101 instanceof Boolean) == false) goto L14;
        return Intrinsics.areEqual(r100, r101);
    L14:
        if ((r100 instanceof String) == false) goto L19;
        if ((r101 instanceof String) == false) goto L19;
        return Intrinsics.areEqual(r100, r101);
    L19:
        if ((r100 instanceof Number) == true) goto L21;
    L43:
        return false;
    L21:
        if ((r101 instanceof Number) == false) goto L43;
        double r103 = ((Number) r100).doubleValue();
        double r104 = ((Number) r101).doubleValue();
        if (Double.isNaN(r103) == false) goto L28;
        if (Double.isNaN(r104) == false) goto L28;
        return true;
    L28:
        if (r103 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L41;
        if (r104 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L41;
        if (Math.signum(r103) != Math.signum(r104)) goto L43;
        return true;
    L35:
        r106 = false;
    L41:
        if (r103 != r104) goto L43;
        return true;
    L30:
        r105 = false;
    L44:
        if (r100 != r101) goto L43;
        return true;
    }
}
