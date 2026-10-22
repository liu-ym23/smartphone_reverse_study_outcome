package kf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {
    public static long a(long r110, long r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "tag");
        if (r110 > 0) goto L5;
    L8:
        fe9.a.f476620a.b("AVTraceContext", "safeDiffDuration tag: " + r112 + ", from: " + r110 + ", to: " + r111 + ", enableZero: false");
        return -1;
    L5:
        if (r111 <= 0) goto L8;
        long r100 = r111 - r110;
        fe9.a.f476620a.e("AVTraceContext", "safeDiffDuration tag: " + r112 + ", from: " + r110 + ", to: " + r111 + ", enableZero: false, ret: " + r100);
        return r100;
    }
}
