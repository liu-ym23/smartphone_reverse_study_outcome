package com.larus.bmhome.chat.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginItemPagingCache", f = "PluginItemPagingCache.kt", i = {0, 0}, l = {26, 40}, m = "requestNextPage", n = {"downgradeSource", "updateFirstPage"}, s = {"L$0", "Z$0"})
public final class PluginItemPagingCache$requestNextPage$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginItemPagingCache this$0;

    public PluginItemPagingCache$requestNextPage$1(PluginItemPagingCache r100, Continuation<? super PluginItemPagingCache$requestNextPage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, null, this);
    }
}
