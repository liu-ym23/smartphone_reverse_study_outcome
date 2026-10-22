package com.larus.agents.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.service.OfficeTaskSettingsServiceImpl", f = "OfficeTaskSettingsServiceImpl.kt", i = {}, l = {23}, m = "getPreferenceInstruction", n = {}, s = {})
public final class OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeTaskSettingsServiceImpl this$0;

    public OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1(OfficeTaskSettingsServiceImpl r100, Continuation<? super OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
