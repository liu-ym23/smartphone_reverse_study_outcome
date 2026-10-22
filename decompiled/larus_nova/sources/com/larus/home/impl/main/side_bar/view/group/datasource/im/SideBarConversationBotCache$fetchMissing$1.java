package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.SideBarConversationBotCache", f = "SideBarConversationBotCache.kt", i = {0}, l = {55}, m = "fetchMissing", n = {"missingIds"}, s = {"L$0"})
public final class SideBarConversationBotCache$fetchMissing$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SideBarConversationBotCache this$0;

    public SideBarConversationBotCache$fetchMissing$1(SideBarConversationBotCache r100, Continuation<? super SideBarConversationBotCache$fetchMissing$1> r101) {
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
