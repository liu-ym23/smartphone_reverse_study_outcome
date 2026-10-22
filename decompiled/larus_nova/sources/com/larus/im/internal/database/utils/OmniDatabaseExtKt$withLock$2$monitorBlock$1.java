package com.larus.im.internal.database.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.utils.OmniDatabaseExtKt$withLock$2$monitorBlock$1", f = "OmniDatabaseExt.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDatabaseExtKt$withLock$2$monitorBlock$1<R> extends SuspendLambda implements Function1<Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public OmniDatabaseExtKt$withLock$2$monitorBlock$1(Function1<? super Continuation<? super R>, ? extends Object> r100, Continuation<? super OmniDatabaseExtKt$withLock$2$monitorBlock$1> r101) {
        this.$block = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new OmniDatabaseExtKt$withLock$2$monitorBlock$1(this.$block, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((Continuation) r100);
    }

    public final Object invoke(Continuation<? super R> r100) {
        return ((OmniDatabaseExtKt$withLock$2$monitorBlock$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        OmniDatabaseExtKt.c(OmniDatabaseExtKt.f348153b - 1);
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<? super R>, Object> r103 = this.$block;
        this.label = 1;
        r100 = r103.invoke(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
