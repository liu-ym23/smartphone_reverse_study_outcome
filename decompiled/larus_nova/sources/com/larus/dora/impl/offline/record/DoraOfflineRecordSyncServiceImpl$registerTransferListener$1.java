package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.c;
import com.xiaomi.mipush.sdk.MiPushClient;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$registerTransferListener$1", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOfflineRecordSyncServiceImpl$registerTransferListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $listener;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$registerTransferListener$1(DoraOfflineRecordSyncServiceImpl r100, c r101, Continuation<? super DoraOfflineRecordSyncServiceImpl$registerTransferListener$1> r102) {
        this.this$0 = r100;
        this.$listener = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOfflineRecordSyncServiceImpl$registerTransferListener$1(this.this$0, this.$listener, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraOfflineRecordSyncServiceImpl$registerTransferListener$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        DoraOfflineRecordSyncServiceImpl r101 = this.this$0;
        DoraOfflineRecordSyncServiceImpl.f(r101, this.$listener, r101.f336535e, MiPushClient.COMMAND_REGISTER);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
