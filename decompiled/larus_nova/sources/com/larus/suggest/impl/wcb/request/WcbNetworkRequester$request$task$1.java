package com.larus.suggest.impl.wcb.request;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/suggest/impl/wcb/request/WcbRequestResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbNetworkRequester$request$task$1", f = "WcbNetworkRequester.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class WcbNetworkRequester$request$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ long $apiStartTime;
    final /* synthetic */ b.a $key;
    final /* synthetic */ f $snapshot;
    int label;

    public WcbNetworkRequester$request$task$1(f r100, long r101, b.a r102, Continuation<? super WcbNetworkRequester$request$task$1> r103) {
        this.$snapshot = r100;
        this.$apiStartTime = r101;
        this.$key = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WcbNetworkRequester$request$task$1(this.$snapshot, this.$apiStartTime, this.$key, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super e> r101) {
        return ((WcbNetworkRequester$request$task$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
    L13:
        b.b(this.$snapshot, (e) r100);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        e r103 = (e) r100;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        b.f370093c.remove(this.$key);
        return r103;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        b r104 = b.f370091a;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        f r105 = this.$snapshot;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        long r106 = this.$apiStartTime;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        this.label = 1;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        r100 = b.a(r104, r105, r106, this);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        if (r100 != r101) goto L13;
        return r101;
    L16:
        th = move-exception;
        b.f370093c.remove(this.$key);
        throw th;
    L21:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        FLogger.f375446a.e("WcbLog", "[network] failed exec=" + this.$snapshot.f370117e + " error=" + e);     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    }
}
