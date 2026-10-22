package com.bytedance.ee.bear.tts.impl.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model", f = "TtsM3U8Model.kt", i = {0, 0, 0, 0}, l = {338}, m = "reload", n = {"requestSegmentId", "request", "disposable", "beginTimeMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
public final class TtsM3U8Model$reload$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsM3U8Model this$0;

    public TtsM3U8Model$reload$1(TtsM3U8Model r100, Continuation<? super TtsM3U8Model$reload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
