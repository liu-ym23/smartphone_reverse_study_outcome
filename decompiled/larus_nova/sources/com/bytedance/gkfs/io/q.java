package com.bytedance.gkfs.io;

import kotlin.UByte;
import kotlin.UInt;

/* JADX INFO: loaded from: classes19.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f245249a = null;

    static {
        f245249a = new char[]{'G', 'K', 'F', 'S'};
    }

    public static final int a(byte[] r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) (r100[r101] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 24) + UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) (r100[r101 + 1] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 16)) + UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) (r100[r101 + 2] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 8)) + UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) (r100[r101 + 3] & UByte.MAX_VALUE)) & UByte.MAX_VALUE));
    }
}
