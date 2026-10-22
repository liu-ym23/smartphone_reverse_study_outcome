package com.bytedance.ruler.utils;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ALogWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f267752a;

    public ALogWrapper() {
        this.f267752a = 5;
    }

    public final void a(final int r100, final Function1<? super com.bytedance.express.util.a.C3487a, Unit> r101) {
        if (r100 >= this.f267752a) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(AsyncExecutorKt.f267756b.get(), Boolean.TRUE) == false) goto L7;
        AsyncExecutorKt.a(new ALogWrapper$log$$inlined$runInLogThread$1(r101, r100));
        return;
    L7:
        Handler r102 = a.f267757a;
        a.b(new ALogWrapper$log$$inlined$runInLogThread$2(r101, r100));
    }
}
