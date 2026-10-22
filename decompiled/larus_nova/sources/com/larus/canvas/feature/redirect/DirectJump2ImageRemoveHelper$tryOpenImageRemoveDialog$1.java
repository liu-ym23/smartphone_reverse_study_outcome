package com.larus.canvas.feature.redirect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper", f = "DirectJump2ImageRemoveHelper.kt", i = {1, 1}, l = {47, 49, 62}, m = "tryOpenImageRemoveDialog", n = {"activity", "imageInfo"}, s = {"L$0", "L$1"})
final class DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectJump2ImageRemoveHelper this$0;

    public DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1(DirectJump2ImageRemoveHelper r100, Continuation<? super DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1> r101) {
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
