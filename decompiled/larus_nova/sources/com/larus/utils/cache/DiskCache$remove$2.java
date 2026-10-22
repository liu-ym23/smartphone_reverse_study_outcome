package com.larus.utils.cache;

import dvc.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.utils.cache.DiskCache$remove$2", f = "DiskCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DiskCache$remove$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ DiskCache this$0;

    public DiskCache$remove$2(DiskCache r100, String r101, Continuation<? super DiskCache$remove$2> r102) {
        this.this$0 = r100;
        this.$key = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DiskCache$remove$2(this.this$0, this.$key, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((DiskCache$remove$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        DiskCache r101 = this.this$0;
        String r102 = this.$key;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Boxing.boxBoolean(((e) r101.f375376c.getValue()).m(r102)));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r104) == false) goto L12;
        r104 = null;
    L12:
        Boolean r105 = (Boolean) r104;
        if (r105 == null) goto L15;
        boolean r106 = r105.booleanValue();
    L17:
        return Boxing.boxBoolean(r106);
    L15:
        r106 = false;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
