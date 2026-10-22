package com.larksuite.component.ignition.widget.blur;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.ignition.widget.blur.BlurProcessor", f = "BlurProcessor.kt", i = {0, 0}, l = {25}, m = "process", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "color"}, s = {"L$0", "I$0"})
public final class BlurProcessor$process$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BlurProcessor this$0;

    public BlurProcessor$process$1(BlurProcessor r100, Continuation<? super BlurProcessor$process$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, this);
    }
}
