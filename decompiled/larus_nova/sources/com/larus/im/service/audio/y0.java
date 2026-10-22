package com.larus.im.service.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y0 {
    public static final boolean a(AudioSessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != AudioSessionType.RTC) goto L5;
    L8:
        return true;
    L5:
        if (r100 == AudioSessionType.QUIC) goto L8;
        return false;
    }

    public static final boolean b(AudioSessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != AudioSessionType.MMT) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean c(AudioSessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != AudioSessionType.RTC) goto L5;
    L10:
        return true;
    L5:
        if (r100 == AudioSessionType.QUIC) goto L10;
        if (r100 == AudioSessionType.MMT) goto L10;
        return false;
    }

    public static final boolean d(AudioSessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != AudioSessionType.QUIC) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean e(AudioSessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != AudioSessionType.RTC) goto L5;
        return true;
    L5:
        return false;
    }
}
