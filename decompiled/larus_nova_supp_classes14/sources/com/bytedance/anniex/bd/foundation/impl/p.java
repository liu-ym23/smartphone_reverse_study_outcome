package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.rts.foundation.y;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public p() {
    }

    public final void b(String r12) {
        Intrinsics.checkNotNullParameter("AnnieXServiceCenter", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        int r0 = y.a;
        Object[] r1 = {"AnnieXServiceCenter: " + r12};
        Intrinsics.checkNotNullParameter(r1, "messages");
        Object[] r2 = Arrays.copyOf(r1, 1);
        Intrinsics.checkNotNullParameter(r2, "messages");
        System.err.println("RTSWarning:" + ArraysKt.joinToString$default(r2, " ", null, null, 0, null, null, 62, null));
    }

    public final void a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        int r0 = y.a;
        Object[] r1 = {r12 + ": " + r13};
        Intrinsics.checkNotNullParameter(r1, "messages");
        Object[] r2 = Arrays.copyOf(r1, 1);
        Intrinsics.checkNotNullParameter(r2, "messages");
        System.out.println("RTSInfo:" + ArraysKt.joinToString$default(r2, " ", null, null, 0, null, null, 62, null));
    }
}
