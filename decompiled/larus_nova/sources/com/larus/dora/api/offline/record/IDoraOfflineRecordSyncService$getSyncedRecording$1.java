package com.larus.dora.api.offline.record;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService$DefaultImpls", f = "IDoraOfflineRecordSyncService.kt", i = {0}, l = {46}, m = "getSyncedRecording", n = {"vuiId"}, s = {"L$0"})
final class IDoraOfflineRecordSyncService$getSyncedRecording$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public IDoraOfflineRecordSyncService$getSyncedRecording$1(Continuation<? super IDoraOfflineRecordSyncService$getSyncedRecording$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        IDoraOfflineRecordSyncService$getSyncedRecording$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        String r105 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
        Iterator r106 = ((Iterable) r103).iterator();
    L11:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((e) r107).f331795a, r105) == false) goto L11;
        return r107;
    L23:
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.label = 1;
        throw null;
    L5:
        r102 = new IDoraOfflineRecordSyncService$getSyncedRecording$1(this);
        goto L6
    }
}
