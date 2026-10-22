package com.larus.avatar.impl.upload.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.utils.ViewModelUtilsKt", f = "ViewModelUtils.kt", i = {0}, l = {73, 75}, m = "safelyCall", n = {"$this$safelyCall"}, s = {"L$0"})
public final class ViewModelUtilsKt$safelyCall$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ViewModelUtilsKt$safelyCall$1(Continuation<? super ViewModelUtilsKt$safelyCall$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ViewModelUtilsKt.b(null, this);
    }
}
