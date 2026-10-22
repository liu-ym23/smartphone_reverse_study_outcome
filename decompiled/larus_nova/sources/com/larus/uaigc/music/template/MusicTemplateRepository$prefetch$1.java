package com.larus.uaigc.music.template;

import com.bytedance.pia.core.metrics.ErrorType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateRepository", f = "MusicTemplateRepository.kt", i = {}, l = {129}, m = ErrorType.PREFETCH, n = {}, s = {})
public final class MusicTemplateRepository$prefetch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicTemplateRepository this$0;

    public MusicTemplateRepository$prefetch$1(MusicTemplateRepository r100, Continuation<? super MusicTemplateRepository$prefetch$1> r101) {
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
