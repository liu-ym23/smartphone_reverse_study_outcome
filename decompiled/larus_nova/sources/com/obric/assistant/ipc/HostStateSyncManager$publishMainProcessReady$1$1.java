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
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$publishMainProcessReady$1$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$publishMainProcessReady$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ long $generation;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$publishMainProcessReady$1$1(Context r100, Bundle r101, String r102, long r103, Continuation<? super HostStateSyncManager$publishMainProcessReady$1$1> r104) {
        this.$appContext = r100;
        this.$extras = r101;
        this.$reason = r102;
        this.$generation = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        HostStateSyncManager$publishMainProcessReady$1$1 r101 = new HostStateSyncManager$publishMainProcessReady$1$1(this.$appContext, this.$extras, this.$reason, this.$generation, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((HostStateSyncManager$publishMainProcessReady$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        long r105 = this.$generation;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L7
        l.a(r102.getContentResolver(), "set-main-process-ready-binder", r103);     // Catch: Throwable -> L7
        FLogger.f375446a.i("HostStateSyncManager", "main_process_ready_publish_success: reason=" + r104 + " generation=" + r105);     // Catch: Throwable -> L7
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r108 = this.$reason;
        long r109 = this.$generation;
        Throwable r110 = Result.m9452exceptionOrNullimpl(r107);
        if (r110 == null) goto L13;
        FLogger.f375446a.w("HostStateSyncManager", "main_process_ready_publish_failed: reason=" + r108 + " generation=" + r109 + " message=" + r110.getMessage(), r110);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
