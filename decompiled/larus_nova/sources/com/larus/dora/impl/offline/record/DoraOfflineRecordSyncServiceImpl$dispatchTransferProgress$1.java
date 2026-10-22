package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.c;
import com.larus.dora.api.offline.record.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $progress;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1(DoraOfflineRecordSyncServiceImpl r100, d r101, Continuation<? super DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1> r102) {
        this.this$0 = r100;
        this.$progress = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1(this.this$0, this.$progress, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        DoraOfflineRecordSyncServiceImpl r101 = this.this$0;
        CopyOnWriteArraySet<c> r102 = r101.f336532b;
        d r103 = this.$progress;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        c r105 = (c) r104.next();
        Intrinsics.checkNotNull(r105);
        DoraOfflineRecordSyncServiceImpl.f(r101, r105, r103, "progress_changed");
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
