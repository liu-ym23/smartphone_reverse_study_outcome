package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t0 {
    public static final void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ArrayList r101 = (ArrayList) com.bytedance.rts.kmp.foundation.h.c(r100, "data", 2);
        if (r101 == null) goto L13;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.size() == 0) goto L13;
        Object r102 = ListProtector.get(r101, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.MutableMap<kotlin.String, kotlin.Any>>{ com.relax.relaxreact.PerformanceKt.TimingRuntimeEventArguments }");
        ArrayList r103 = (ArrayList) r102;
        if (com.bytedance.rts.kmp.foundation.i.a(r103) <= 0) goto L11;
        Object r104 = ListProtector.get(r103, 0);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.relax.relaxreact.PerformanceKt.TimingInfo }");
        TypeIntrinsics.asMutableMap(r104);
        return;
    L11:
        TypeIntrinsics.asMutableMap(r100);
        return;
    L13:
        TypeIntrinsics.asMutableMap(r100);
    }
}
