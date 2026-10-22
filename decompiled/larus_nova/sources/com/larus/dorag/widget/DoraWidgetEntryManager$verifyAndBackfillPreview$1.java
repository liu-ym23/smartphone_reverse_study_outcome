package com.larus.dorag.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetEntryManager", f = "DoraWidgetEntryManager.kt", i = {0, 0, 1, 1, 1}, l = {178, 190}, m = "verifyAndBackfillPreview", n = {"appWidgetManager", "requestGeneration", "appWidgetManager", "registeredProviders", "requestGeneration"}, s = {"L$0", "J$0", "L$0", "L$1", "J$0"})
public final class DoraWidgetEntryManager$verifyAndBackfillPreview$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWidgetEntryManager this$0;

    public DoraWidgetEntryManager$verifyAndBackfillPreview$1(DoraWidgetEntryManager r100, Continuation<? super DoraWidgetEntryManager$verifyAndBackfillPreview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraWidgetEntryManager r101 = this.this$0;
        DoraWidgetEntryManager r102 = DoraWidgetEntryManager.f340986a;
        return r101.h(null, 0, this);
    }
}
