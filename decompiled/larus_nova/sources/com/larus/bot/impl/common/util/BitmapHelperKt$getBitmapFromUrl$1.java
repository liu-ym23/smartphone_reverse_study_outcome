package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt", f = "BitmapHelper.kt", i = {}, l = {94, 95}, m = "getBitmapFromUrl", n = {}, s = {})
public final class BitmapHelperKt$getBitmapFromUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public BitmapHelperKt$getBitmapFromUrl$1(Continuation<? super BitmapHelperKt$getBitmapFromUrl$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return BitmapHelperKt.c(null, this);
    }
}
