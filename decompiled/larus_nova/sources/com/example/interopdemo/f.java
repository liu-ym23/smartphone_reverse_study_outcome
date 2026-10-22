package com.example.interopdemo;

import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f274035a = null;

    static {
        f274035a = new f();
    }

    public f() {
    }

    public final c a(Continuation r100) {
        if ((r100 instanceof TTNetworkUtils$getMultiNetState$1) == false) goto L7;
        TTNetworkUtils$getMultiNetState$1 r101 = (TTNetworkUtils$getMultiNetState$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r103);
        ((pt7.e) r103).getClass();
        return new c();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        new pt7.c();
        r101.label = 1;
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    L7:
        r101 = new TTNetworkUtils$getMultiNetState$1(this, r100);
        goto L8
    }
}
