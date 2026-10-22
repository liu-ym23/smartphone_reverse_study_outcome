package com.obric.miniapp.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1", f = "MiniAppFragment.kt", i = {}, l = {1002}, m = "clearContext", n = {}, s = {})
public final class MiniAppFragment$floatingSpeakerController$1$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$0;

    public MiniAppFragment$floatingSpeakerController$1$clearContext$1(MiniAppFragment$floatingSpeakerController$1 r100, Continuation<? super MiniAppFragment$floatingSpeakerController$1$clearContext$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
