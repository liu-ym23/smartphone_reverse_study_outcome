package urc;

import androidx.camera.video.AudioStats;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class n {
    public static final boolean a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L5;
        return true;
    L5:
        if ((r100 instanceof Number) == false) goto L12;
        if (((Number) r100).doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return true;
    L9:
        r101 = false;
    L12:
        if ((r100 instanceof CharSequence) == false) goto L19;
        if (((CharSequence) r100).length() != 0) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == false) goto L19;
        return true;
    L16:
        r102 = false;
    L19:
        if ((r100 instanceof y) == true) goto L26;
        return false;
    L26:
        return true;
    }
}
