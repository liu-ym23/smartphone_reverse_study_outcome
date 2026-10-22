package com.obric.assistant.omnidetailpage.localmedia;

import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.localmedia.LocalMediaShareHelper", f = "LocalMediaShareHelper.kt", i = {0}, l = {85}, m = SVGRenderEngine.SAVE, n = {PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0"})
public final class LocalMediaShareHelper$save$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalMediaShareHelper this$0;

    public LocalMediaShareHelper$save$1(LocalMediaShareHelper r100, Continuation<? super LocalMediaShareHelper$save$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
