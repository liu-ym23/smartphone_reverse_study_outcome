package com.github.alexzhirkevich.customqrgenerator;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.ThreadPolicy$DoubleThread", f = "QrCodeGenerator.kt", i = {}, l = {77, 86}, m = AbsMethodDelegate.TAG_INVOKE, n = {}, s = {})
public final class ThreadPolicy$DoubleThread$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThreadPolicy.DoubleThread this$0;

    public ThreadPolicy$DoubleThread$invoke$1(ThreadPolicy.DoubleThread r100, Continuation<? super ThreadPolicy$DoubleThread$invoke$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0, 0, null, this);
    }
}
