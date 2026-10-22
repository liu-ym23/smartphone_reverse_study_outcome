package com.larus.agents.impl.settings;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.settings.DefaultOfficeTaskPreferenceRepository", f = "OfficeTaskPreferenceRepository.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {164, 78, 171, 94}, m = SVGRenderEngine.SAVE, n = {"instruction", "$this$withLock_u24default$iv", "instruction", "$this$withLock_u24default$iv", "accountId", "instruction", "$this$withLock_u24default$iv", "accountId", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class DefaultOfficeTaskPreferenceRepository$save$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultOfficeTaskPreferenceRepository this$0;

    public DefaultOfficeTaskPreferenceRepository$save$1(DefaultOfficeTaskPreferenceRepository r100, Continuation<? super DefaultOfficeTaskPreferenceRepository$save$1> r101) {
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
