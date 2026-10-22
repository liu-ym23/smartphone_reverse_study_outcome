package com.larus.bmhome.chat.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginItemPagingCache", f = "PluginItemPagingCache.kt", i = {}, l = {53}, m = "updateFirstPage", n = {}, s = {})
public final class PluginItemPagingCache$updateFirstPage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginItemPagingCache this$0;

    public PluginItemPagingCache$updateFirstPage$1(PluginItemPagingCache r100, Continuation<? super PluginItemPagingCache$updateFirstPage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PluginItemPagingCache r101 = this.this$0;
        int r102 = PluginItemPagingCache.f297284g;
        return r101.b(null, this);
    }
}
