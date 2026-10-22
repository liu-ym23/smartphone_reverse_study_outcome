package com.bytedance.live.artist.core;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, d2 = {"Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runnable", "Lkotlin/coroutines/Continuation;", "", "continuation", "", UGCMonitor.TYPE_POST}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine", f = "CoreEngine.kt", i = {0, 0, 0}, l = {249}, m = UGCMonitor.TYPE_POST, n = {"this", "runnable", "$this$withPermit$iv"}, s = {"L$0", "L$1", "L$2"})
public final class CoreEngine$post$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoreEngine this$0;

    public CoreEngine$post$1(CoreEngine r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
