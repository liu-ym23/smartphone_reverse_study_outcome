package com.larus.dorag.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetEntryManager", f = "DoraWidgetEntryManager.kt", i = {0}, l = {205}, m = "runProviderPreviewSafely", n = {"definition"}, s = {"L$0"})
public final class DoraWidgetEntryManager$runProviderPreviewSafely$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWidgetEntryManager this$0;

    public DoraWidgetEntryManager$runProviderPreviewSafely$1(DoraWidgetEntryManager r100, Continuation<? super DoraWidgetEntryManager$runProviderPreviewSafely$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraWidgetEntryManager r101 = this.this$0;
        DoraWidgetEntryManager r102 = DoraWidgetEntryManager.f340986a;
        return r101.d(null, null, null, 0, this);
    }
}
