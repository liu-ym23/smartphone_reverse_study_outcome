package com.bytedance.ee.bear.middleground.comment.card.aside;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final Object a(RecyclerView r3, ContinuationImpl r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        r3.post(new a(r0));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L6:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r5;
    L9:
        return Unit.INSTANCE;
    }
}
