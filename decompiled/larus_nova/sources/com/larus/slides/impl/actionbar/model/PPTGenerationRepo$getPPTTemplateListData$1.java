package com.larus.slides.impl.actionbar.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.slides.impl.actionbar.model.PPTGenerationRepo", f = "PPTGenerationRepo.kt", i = {}, l = {16}, m = "getPPTTemplateListData", n = {}, s = {})
public final class PPTGenerationRepo$getPPTTemplateListData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PPTGenerationRepo this$0;

    public PPTGenerationRepo$getPPTTemplateListData$1(PPTGenerationRepo r100, Continuation<? super PPTGenerationRepo$getPPTTemplateListData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, this);
    }
}
