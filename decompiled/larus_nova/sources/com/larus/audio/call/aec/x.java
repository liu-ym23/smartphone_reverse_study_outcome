package com.larus.audio.call.aec;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289020a = 0;

    static {
    }

    public static byte[] a(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r102 = 0;
        int r103 = RangesKt.coerceIn(r101, 0, r100.length);
        int r104 = r103 - (r103 % 4);
        if (r104 <= 0) goto L5;
        byte[] r105 = new byte[r104 / 2];
        int r106 = 0;
    L7:
        int r107 = r102 + 1;
        if (r107 >= r104) goto L10;
        r105[r106] = r100[r102];
        r105[r106 + 1] = r100[r107];
        r102 = r102 + 4;
        r106 = r106 + 2;
        goto L7
    L10:
        return r105;
    L5:
        return new byte[0];
    }
}
