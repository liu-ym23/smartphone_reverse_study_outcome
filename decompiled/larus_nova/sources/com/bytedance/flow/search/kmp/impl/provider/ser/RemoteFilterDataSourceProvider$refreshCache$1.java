package com.bytedance.flow.search.kmp.impl.provider.ser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.ser.RemoteFilterDataSourceProvider", f = "RemoteFilterDataSourceProvider.kt", i = {}, l = {38}, m = "refreshCache", n = {}, s = {})
public final class RemoteFilterDataSourceProvider$refreshCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteFilterDataSourceProvider this$0;

    public RemoteFilterDataSourceProvider$refreshCache$1(RemoteFilterDataSourceProvider r100, Continuation<? super RemoteFilterDataSourceProvider$refreshCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RemoteFilterDataSourceProvider r101 = this.this$0;
        int r102 = RemoteFilterDataSourceProvider.f243651b;
        return r101.b(null, this);
    }
}
