package com.larus.dora.impl.ota.check;

import com.larus.dora.impl.ota.g.DoraGOTAFetcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1", f = "DoraOTACheckRepository.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e49.a>, Object> {
    int label;

    public DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1(Continuation<? super DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super e49.a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super e49.a> r101) {
        return ((DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7
    L15:
        return (e49.a) r100;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        DoraGOTAFetcher r103 = DoraGOTAFetcher.f337488a;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r100 = r103.a(this);     // Catch: Throwable -> L7
        if (r100 != r101) goto L15;
        return r101;
    L7:
        th = move-exception;
        g49.d.b("DoraOTACheckRepository", "getPeripheralResponse failed: " + th.getMessage());
        return null;
    }
}
