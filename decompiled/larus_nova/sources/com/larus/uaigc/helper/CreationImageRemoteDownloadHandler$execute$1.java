package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageRemoteDownloadHandler", f = "CreationImageNodeHandlers.kt", i = {0}, l = {371}, m = "execute", n = {"resourceInput"}, s = {"L$0"})
public final class CreationImageRemoteDownloadHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageRemoteDownloadHandler this$0;

    public CreationImageRemoteDownloadHandler$execute$1(CreationImageRemoteDownloadHandler r100, Continuation<? super CreationImageRemoteDownloadHandler$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
