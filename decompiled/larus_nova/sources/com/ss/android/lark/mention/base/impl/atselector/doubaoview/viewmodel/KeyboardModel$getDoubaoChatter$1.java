package com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.KeyboardModel", f = "KeyboardModel.kt", i = {}, l = {28}, m = "getDoubaoChatter", n = {}, s = {})
public final class KeyboardModel$getDoubaoChatter$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KeyboardModel this$0;

    public KeyboardModel$getDoubaoChatter$1(KeyboardModel r100, Continuation<? super KeyboardModel$getDoubaoChatter$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
