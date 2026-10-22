package com.ss.android.lark.keyboard.viewmodel;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.viewmodel.KeyboardModel", f = "KeyboardModel.kt", i = {0}, l = {61}, m = "markdownToRichText", n = {PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0"})
public final class KeyboardModel$markdownToRichText$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KeyboardModel this$0;

    public KeyboardModel$markdownToRichText$1(KeyboardModel r100, Continuation<? super KeyboardModel$markdownToRichText$1> r101) {
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
