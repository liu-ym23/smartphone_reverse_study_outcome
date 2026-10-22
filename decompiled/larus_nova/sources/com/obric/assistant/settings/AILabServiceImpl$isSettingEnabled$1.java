package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl", f = "AILabServiceImpl.kt", i = {}, l = {92}, m = "isSettingEnabled", n = {}, s = {})
public final class AILabServiceImpl$isSettingEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AILabServiceImpl this$0;

    public AILabServiceImpl$isSettingEnabled$1(AILabServiceImpl r100, Continuation<? super AILabServiceImpl$isSettingEnabled$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
