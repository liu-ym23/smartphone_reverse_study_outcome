package com.larus.bmhome.chat.thinkmode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.thinkmode.ThinkModeMemoryReportServiceImpl", f = "ThinkModeMemoryReportServiceImpl.kt", i = {}, l = {44}, m = "report", n = {}, s = {})
public final class ThinkModeMemoryReportServiceImpl$report$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThinkModeMemoryReportServiceImpl this$0;

    public ThinkModeMemoryReportServiceImpl$report$1(ThinkModeMemoryReportServiceImpl r100, Continuation<? super ThinkModeMemoryReportServiceImpl$report$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
