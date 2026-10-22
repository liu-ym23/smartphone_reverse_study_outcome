package com.larus.bmhome.resource.access;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.ResourceNodeRunner", f = "ResourceAccessPipeline.kt", i = {0, 0, 0, 0, 0}, l = {634}, m = "executeNode", n = {"task", PerfLog.PARAM_KEY_CONTEXT_ID, "node", "allowResultAfterTerminal", "start"}, s = {"L$0", "L$1", "L$2", "Z$0", "J$0"})
public final class ResourceNodeRunner$executeNode$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceNodeRunner this$0;

    public ResourceNodeRunner$executeNode$1(ResourceNodeRunner r100, Continuation<? super ResourceNodeRunner$executeNode$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, false, false, this);
    }
}
