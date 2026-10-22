package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource", f = "ImProjectSource.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {676, 685}, m = "reloadProjectConversations", n = {"projectId", "reason", "state", "targetVisibleCount", "projectId", "reason", "state", "page", "targetVisibleCount"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
final class ImProjectSource$reloadProjectConversations$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImProjectSource this$0;

    public ImProjectSource$reloadProjectConversations$1(ImProjectSource r100, Continuation<? super ImProjectSource$reloadProjectConversations$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ImProjectSource.i(this.this$0, null, 0, null, this);
    }
}
