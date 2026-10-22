package com.obric.assistant.chat.component.interaction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.component.interaction.TouchSpeakerEventComponent", f = "TouchSpeakerEventComponent.kt", i = {}, l = {129}, m = "fetchBotIfNeeded", n = {}, s = {})
final class TouchSpeakerEventComponent$fetchBotIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TouchSpeakerEventComponent this$0;

    public TouchSpeakerEventComponent$fetchBotIfNeeded$1(TouchSpeakerEventComponent r100, Continuation<? super TouchSpeakerEventComponent$fetchBotIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return TouchSpeakerEventComponent.F2(this.this$0, this);
    }
}
