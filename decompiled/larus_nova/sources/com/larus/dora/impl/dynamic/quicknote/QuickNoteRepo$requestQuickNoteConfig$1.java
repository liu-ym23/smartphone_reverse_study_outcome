package com.larus.dora.impl.dynamic.quicknote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo", f = "QuickNoteRepo.kt", i = {}, l = {143}, m = "requestQuickNoteConfig", n = {}, s = {})
public final class QuickNoteRepo$requestQuickNoteConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickNoteRepo this$0;

    public QuickNoteRepo$requestQuickNoteConfig$1(QuickNoteRepo r100, Continuation<? super QuickNoteRepo$requestQuickNoteConfig$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        QuickNoteRepo r101 = this.this$0;
        QuickNoteRepo r102 = QuickNoteRepo.f335241a;
        return r101.g(null, this);
    }
}
