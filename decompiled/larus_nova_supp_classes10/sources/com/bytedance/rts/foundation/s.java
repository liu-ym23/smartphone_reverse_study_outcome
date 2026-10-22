package com.bytedance.rts.foundation;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s {
    public final Function0<Unit> a;
    public long b;
    public final long c;
    public final boolean d;
    public final n e;

    public s(Function0<Unit> r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "sourceLooper");
        this.a = r2;
        this.e = r3;
        this.c = 0;
        this.b = SystemClock.uptimeMillis();
        this.d = false;
    }

    public s(Function0<Unit> r2, n r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "sourceLooper");
        this.a = r2;
        this.e = r3;
        this.c = r4;
        this.b = SystemClock.uptimeMillis() + r4;
        this.d = r6;
    }
}
