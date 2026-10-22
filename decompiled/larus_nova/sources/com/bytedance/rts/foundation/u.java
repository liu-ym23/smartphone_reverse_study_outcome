package com.bytedance.rts.foundation;

import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u {
    public static final void a(Object r100) {
        n r101 = t.f267593a.get();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        s r102 = (s) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "task");
        ((LinkedList) r101.f267582a).remove(r102);
    }

    public static final void b(Object r100) {
        n r101 = t.f267593a.get();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        s r102 = (s) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "task");
        ((LinkedList) r101.f267582a).remove(r102);
    }

    public static final s c(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return t.f267593a.get().b(r100, 1000, true);
    }

    public static final s d(Function0 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return t.f267593a.get().b(r100, r101, false);
    }
}
