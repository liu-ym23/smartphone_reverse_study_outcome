package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.b;
import g49.d;
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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$configureStorage$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$configureStorage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ b $config;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$configureStorage$2(DoraOfflineRecordSyncServiceImpl r100, b r101, Continuation<? super DoraOfflineRecordSyncServiceImpl$configureStorage$2> r102) {
        this.this$0 = r100;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOfflineRecordSyncServiceImpl$configureStorage$2(this.this$0, null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((DoraOfflineRecordSyncServiceImpl$configureStorage$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r100);
        DoraOfflineRecordSyncServiceImpl r101 = this.this$0;
        int r102 = DoraOfflineRecordSyncServiceImpl.f336530g;
        if (r101.h() == true) goto L27;
        d.d("DoraOfflineRecordSyncService", "Configure offline record storage skipped because ability is unsupported");
        boolean r103 = false;
    L20:
        return Boxing.boxBoolean(r103);
    L27:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        throw null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9456isSuccessimpl(r106) == false) goto L14;
        ((Boolean) r106).booleanValue();
        throw null;
    L14:
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L22;
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = r107;
    L18:
        r103 = ((Boolean) r106).booleanValue();
        goto L20
    L22:
        throw null;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
