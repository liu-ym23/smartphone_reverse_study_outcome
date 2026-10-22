package com.bytedance.rts.foundation;

import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u {
    public static final void a(Object r2) {
        n r0 = t.a.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        s r3 = (s) r2;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "task");
        ((LinkedList) r0.a).remove(r3);
    }

    public static final void b(Object r2) {
        n r0 = t.a.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        s r3 = (s) r2;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "task");
        ((LinkedList) r0.a).remove(r3);
    }

    public static final s c(Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        return t.a.get().b(r4, 1000, true);
    }

    public static final s d(Function0 r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        return t.a.get().b(r3, r4, false);
    }
}
