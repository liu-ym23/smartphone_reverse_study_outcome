package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.ImSdkConversationQueryService", f = "ImConversationQueryService.kt", i = {}, l = {122}, m = "getBriefMessages", n = {}, s = {})
public final class ImSdkConversationQueryService$getBriefMessages$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImSdkConversationQueryService this$0;

    public ImSdkConversationQueryService$getBriefMessages$1(ImSdkConversationQueryService r100, Continuation<? super ImSdkConversationQueryService$getBriefMessages$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
