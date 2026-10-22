package com.bytedance.ee.bear.lynx.impl.xbridge;

import androidx.camera.video.AudioStats;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static final Number a(XReadableMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(r100.getInt(r101)));     // Catch: Throwable -> L5
    L7:
        Object r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        Integer r105 = (Integer) r103;
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
    L34:
        Object r107 = Result.m9449constructorimpl(Double.valueOf(r100.getDouble(r101)));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r107) == true) goto L22;
        r104 = r107;
    L22:
        Double r108 = (Double) r104;
        if (r108 == null) goto L25;
        double r109 = r108.doubleValue();
    L27:
        if (Double.compare(r106, r109) == 0) goto L38;
        long r110 = (long) r109;
        if (Double.compare(r109, r110) != 0) goto L33;
        return Long.valueOf(r110);
    L33:
        return Double.valueOf(r109);
    L38:
        return Integer.valueOf(r106);
    L25:
        r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L13:
        r106 = 0;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
