package com.obric.assistant.settings.provider;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.AILabSettingProvider", f = "AILabSettingProvider.kt", i = {0, 0}, l = {49}, m = "getSettingItems", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "items"}, s = {"L$0", "L$1"})
public final class AILabSettingProvider$getSettingItems$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AILabSettingProvider this$0;

    public AILabSettingProvider$getSettingItems$1(AILabSettingProvider r100, Continuation<? super AILabSettingProvider$getSettingItems$1> r101) {
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
