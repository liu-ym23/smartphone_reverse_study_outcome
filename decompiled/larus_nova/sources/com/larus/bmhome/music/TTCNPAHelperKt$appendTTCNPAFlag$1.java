package com.larus.bmhome.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.TTCNPAHelperKt", f = "TTCNPAHelper.kt", i = {0, 0, 1, 1}, l = {51, 53}, m = "appendTTCNPAFlag", n = {"filePath", "pid", "filePath", "pid"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class TTCNPAHelperKt$appendTTCNPAFlag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public TTCNPAHelperKt$appendTTCNPAFlag$1(Continuation<? super TTCNPAHelperKt$appendTTCNPAFlag$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return TTCNPAHelperKt.a(null, null, this);
    }
}
