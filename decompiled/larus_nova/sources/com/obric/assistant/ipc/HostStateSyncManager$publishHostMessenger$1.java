package com.obric.assistant.ipc;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$publishHostMessenger$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$publishHostMessenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$publishHostMessenger$1(Context r100, Bundle r101, String r102, Continuation<? super HostStateSyncManager$publishHostMessenger$1> r103) {
        this.$appContext = r100;
        this.$extras = r101;
        this.$reason = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        HostStateSyncManager$publishHostMessenger$1 r102 = new HostStateSyncManager$publishHostMessenger$1(this.$appContext, this.$extras, this.$reason, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((HostStateSyncManager$publishHostMessenger$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$appContext;
        Bundle r103 = this.$extras;
        String r104 = this.$reason;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        l.a(r102.getContentResolver(), "set-tracker-messenger", r103);     // Catch: Throwable -> L7
        FLogger.f375446a.i("HostStateSyncManager", "publishHostMessenger reason=" + r104 + " generation=" + com.obric.assistant.voice.c.f394377b);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r107 = this.$reason;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
        if (r108 == null) goto L13;
        FLogger.f375446a.w("HostStateSyncManager", "publishHostMessenger failed reason=" + r107 + ": " + r108.getMessage(), r108);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
