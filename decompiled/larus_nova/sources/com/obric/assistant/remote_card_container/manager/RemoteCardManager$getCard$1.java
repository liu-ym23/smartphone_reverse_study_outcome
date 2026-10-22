package com.obric.assistant.remote_card_container.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.RemoteCardManager", f = "RemoteCardManager.kt", i = {}, l = {106}, m = "getCard", n = {}, s = {})
public final class RemoteCardManager$getCard$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteCardManager this$0;

    public RemoteCardManager$getCard$1(RemoteCardManager r100, Continuation<? super RemoteCardManager$getCard$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
