package com.obric.assistant.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.ObricPersonalContextSettingServiceImpl", f = "ObricPersonalContextSettingServiceImpl.kt", i = {0, 0, 0, 0}, l = {360}, m = "setReferenceMemoryToggleEnabledWithSync", n = {"key", "requestUserId", "config", "enabled"}, s = {"L$0", "L$1", "L$2", "Z$0"})
public final class ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPersonalContextSettingServiceImpl this$0;

    public ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1(ObricPersonalContextSettingServiceImpl r100, Continuation<? super ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, false, this);
    }
}
