package com.ss.android.lark.flow.chat.page.flow.plugin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowAskDoubaoPlugin", f = "FlowAskDoubaoPlugin.kt", i = {}, l = {145}, m = "insertAtDoubao", n = {}, s = {})
final class FlowAskDoubaoPlugin$insertAtDoubao$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAskDoubaoPlugin this$0;

    public FlowAskDoubaoPlugin$insertAtDoubao$1(FlowAskDoubaoPlugin r100, Continuation<? super FlowAskDoubaoPlugin$insertAtDoubao$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowAskDoubaoPlugin.F(this.this$0, this);
    }
}
