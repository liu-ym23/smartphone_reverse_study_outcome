package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction", f = "PublishAction.kt", i = {0, 0}, l = {210, 212}, m = "setCreationPublic", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "creationId"}, s = {"L$0", "L$1"})
public final class PublishAction$setCreationPublic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublishAction this$0;

    public PublishAction$setCreationPublic$1(PublishAction r100, Continuation<? super PublishAction$setCreationPublic$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PublishAction r101 = this.this$0;
        int r102 = PublishAction.f324696a;
        return r101.g(null, null, this);
    }
}
