package com.obric.assistant.ipc;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1", f = "ObricXttTokenSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1(String r100, Continuation<? super ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1> r101) {
        this.$reason = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1 r102 = new ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1(this.$reason, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$reason;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        l.a(AppHost.f326268a.getApplication().getApplicationContext().getContentResolver(), "notify-xtt-token-updated", com.larus.utils.f.c(new Pair[]{TuplesKt.to("reason", r102)}));     // Catch: Throwable -> L7
        FLogger.f375446a.i("ObricXttTokenSyncManager", "notifyInteractorTokenUpdated reason=" + r102);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r105 = this.$reason;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L13;
        FLogger.f375446a.w("ObricXttTokenSyncManager", "notifyInteractorTokenUpdated failed reason=" + r105 + ": " + r106.getMessage(), r106);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
