package com.bytedance.applog.priority.original;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public final int a;
    public final t b;
    public final int c;
    public final m d;
    public final n e;
    public final r f;
    public final List<String> g;
    public final String h;

    public final String toString() {
        return "GroupConfig-" + this.a;
    }

    public l(int r2, t r3, int r4, m r5, n r6, r r7, List<String> r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r5, "frequency");
        Intrinsics.checkNotNullParameter(r6, "priority");
        Intrinsics.checkNotNullParameter(r8, "supportEventTypes");
        Intrinsics.checkNotNullParameter(r9, "reportUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        if (r4 > 0) goto L6;
        r5.d = Integer.MAX_VALUE;
        return;
    L6:
        if (r5.d > 0) goto L11;
        r5.d = RangesKt.coerceAtLeast(60 / r4, 10);
        return;
    }
}
