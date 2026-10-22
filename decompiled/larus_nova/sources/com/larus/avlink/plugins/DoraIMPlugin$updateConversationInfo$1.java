package com.larus.avlink.plugins;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraIMPlugin", f = "DoraIMPlugin.kt", i = {}, l = {192}, m = "updateConversationInfo", n = {}, s = {})
final class DoraIMPlugin$updateConversationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraIMPlugin this$0;

    public DoraIMPlugin$updateConversationInfo$1(DoraIMPlugin r100, Continuation<? super DoraIMPlugin$updateConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraIMPlugin.k3(this.this$0, this);
    }
}
