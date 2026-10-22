package com.ss.android.lark.todo.impl.flutterweb.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.flutterweb.bridge.GetInitialRichSummaryForChatCreatingHandler", f = "GetInitialRichSummaryForChatCreatingHandler.kt", i = {0, 0, 0, 0}, l = {99}, m = "buildRichContentWithUrlPreview", n = {"richText", "baseBuilder", "originText", "todoRichContent"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetInitialRichSummaryForChatCreatingHandler this$0;

    public GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1(GetInitialRichSummaryForChatCreatingHandler r100, Continuation<? super GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GetInitialRichSummaryForChatCreatingHandler.a(this.this$0, null, null, this);
    }
}
