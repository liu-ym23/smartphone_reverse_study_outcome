package com.obric.assistant.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.VContextMessageExKt", f = "VContextMessageEx.kt", i = {}, l = {25}, m = "queryMessage", n = {}, s = {})
public final class VContextMessageExKt$queryMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public VContextMessageExKt$queryMessage$1(Continuation<? super VContextMessageExKt$queryMessage$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return VContextMessageExKt.a(null, null, this);
    }
}
