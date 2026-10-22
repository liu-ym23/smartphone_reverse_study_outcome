package com.larus.canvas.feature.component.instruction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<c> f323127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a1 f323128b = null;

    static {
        MutableSharedFlow<c> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f323127a = r100;
        f323128b = e.a(r100);
    }

    public static Object a(c r100, Continuation r101) {
        Object r102 = f323127a.emit(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
