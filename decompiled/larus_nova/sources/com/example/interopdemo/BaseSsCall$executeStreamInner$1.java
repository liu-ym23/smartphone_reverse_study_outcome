package com.example.interopdemo;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.example.interopdemo.BaseSsCall", f = "BaseSsCall.kt", i = {0, 0}, l = {114, 121}, m = "executeStreamInner", n = {"request", "callback"}, s = {"L$0", "L$1"})
final class BaseSsCall$executeStreamInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public BaseSsCall$executeStreamInner$1(b r100, Continuation<? super BaseSsCall$executeStreamInner$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        b r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        BaseSsCall$executeStreamInner$1 r101 = this;
    L6:
        Object r112 = r101.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r101.label;
        if (r103 != 0) goto L9;
        ResultKt.throwOnFailure(r112);
        throw null;
    L9:
        if (r103 == 1) goto L14;
        if (r103 != 2) goto L13;
        ResultKt.throwOnFailure(r112);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ot7.c r104 = (ot7.c) r101.L$1;
        nt7.c r105 = (nt7.c) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ot7.b r106 = new ot7.b();
        String r107 = r105.f520528a;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f526688a = r107;
        r106.f526694g = -99;
        String r113 = "Stream execution failed unexpectedly: " + e.getMessage();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r106.f526695h = r113;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (r104.onError() != r102) goto L22;
        return r102;
    L5:
        r101 = new BaseSsCall$executeStreamInner$1(r111, this);
        goto L6
    }
}
