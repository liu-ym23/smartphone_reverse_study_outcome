package com.larus.avlink.record.page;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel", f = "RecordMinutesModel.kt", i = {}, l = {503}, m = "fetchDoraSdkOfflineRecordings", n = {}, s = {})
final class RecordMinutesModel$fetchDoraSdkOfflineRecordings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$fetchDoraSdkOfflineRecordings$1(RecordMinutesModel r100, Continuation<? super RecordMinutesModel$fetchDoraSdkOfflineRecordings$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return RecordMinutesModel.c(this.this$0, this);
    }
}
