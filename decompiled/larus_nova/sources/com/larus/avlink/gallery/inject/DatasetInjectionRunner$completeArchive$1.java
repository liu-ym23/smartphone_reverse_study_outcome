package com.larus.avlink.gallery.inject;

import com.ss.bduploader.BDAbstractUpload;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner", f = "DatasetInjectionRunner.kt", i = {0}, l = {BDAbstractUpload.KeyIsSDKMaxRetryTimeout}, m = "completeArchive", n = {"uniqId"}, s = {"L$0"})
public final class DatasetInjectionRunner$completeArchive$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DatasetInjectionRunner this$0;

    public DatasetInjectionRunner$completeArchive$1(DatasetInjectionRunner r100, Continuation<? super DatasetInjectionRunner$completeArchive$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DatasetInjectionRunner r101 = this.this$0;
        DatasetInjectionRunner r102 = DatasetInjectionRunner.f292593a;
        return r101.e(null, null, this);
    }
}
