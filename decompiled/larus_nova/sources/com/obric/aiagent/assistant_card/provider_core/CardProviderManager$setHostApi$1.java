package com.obric.aiagent.assistant_card.provider_core;

import android.os.IBinder;
import java.util.concurrent.ConcurrentHashMap;
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

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$setHostApi$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$setHostApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IHostApi $hostApi;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$setHostApi$1(IHostApi r100, Continuation<? super CardProviderManager$setHostApi$1> r101) {
        this.$hostApi = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CardProviderManager$setHostApi$1 r102 = new CardProviderManager$setHostApi$1(this.$hostApi, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CardProviderManager$setHostApi$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        IHostApi r102 = c.f384642c;
        if (r102 != null) goto L34;
    L14:
        ConcurrentHashMap<String, a> r103 = c.f384640a;
        c.f384642c = this.$hostApi;
        IHostApi r104 = this.$hostApi;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L23
        if (r104 == null) goto L20;
        IBinder r106 = r104.asBinder();     // Catch: Throwable -> L23
        if (r106 == null) goto L20;
        r106.linkToDeath(c.f384644e, 0);     // Catch: Throwable -> L23
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L23
    L25:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L29;
        p9a.b.c("CardProviderManager", "setHostApi: failed to linkToDeath", r109);
    L29:
        return Unit.INSTANCE;
    L20:
        r107 = null;
    L23:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L34:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L8
        Object r112 = Result.m9449constructorimpl(Boxing.boxBoolean(r102.asBinder().unlinkToDeath(c.f384644e, 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L13;
        p9a.b.c("CardProviderManager", "setHostApi: failed to unlinkToDeath", r113);
    L13:
        Result.m9448boximpl(r112);
    L8:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
