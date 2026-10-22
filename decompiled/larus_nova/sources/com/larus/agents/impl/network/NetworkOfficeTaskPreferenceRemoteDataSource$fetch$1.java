package com.larus.agents.impl.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.NetworkOfficeTaskPreferenceRemoteDataSource", f = "AgentsMdApi.kt", i = {}, l = {62}, m = "fetch-IoAF18A", n = {}, s = {})
public final class NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkOfficeTaskPreferenceRemoteDataSource this$0;

    public NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1(NetworkOfficeTaskPreferenceRemoteDataSource r100, Continuation<? super NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.a(this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
