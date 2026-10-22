package com.larus.audio.call.util;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f289650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f289651b;

    public o(long r100) {
        this.f289650a = r100;
        this.f289651b = -1;
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f289651b) <= this.f289650a) goto L6;
        r100.invoke();
        this.f289651b = r101;
        return;
    }
}
