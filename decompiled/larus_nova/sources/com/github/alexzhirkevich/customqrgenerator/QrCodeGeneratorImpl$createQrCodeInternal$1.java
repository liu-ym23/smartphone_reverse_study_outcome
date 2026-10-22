package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl", f = "QrCodeGeneratorImpl.kt", i = {0, 0}, l = {46, 54}, m = "createQrCodeInternal", n = {"this", "options"}, s = {"L$0", "L$1"})
final class QrCodeGeneratorImpl$createQrCodeInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public QrCodeGeneratorImpl$createQrCodeInternal$1(b r100, Continuation<? super QrCodeGeneratorImpl$createQrCodeInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, this);
    }
}
