package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.SetPrivateAction", f = "SetPrivateAction.kt", i = {0, 0, 1, 1, 2, 2}, l = {73, 76, 83}, m = "setPrivateViaCreationRecord", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "creationId", PerfLog.PARAM_KEY_CONTEXT_ID, "creationId", PerfLog.PARAM_KEY_CONTEXT_ID, "creationId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class SetPrivateAction$setPrivateViaCreationRecord$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetPrivateAction this$0;

    public SetPrivateAction$setPrivateViaCreationRecord$1(SetPrivateAction r100, Continuation<? super SetPrivateAction$setPrivateViaCreationRecord$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SetPrivateAction r101 = this.this$0;
        int r102 = SetPrivateAction.f324699a;
        return r101.f(null, null, this);
    }
}
