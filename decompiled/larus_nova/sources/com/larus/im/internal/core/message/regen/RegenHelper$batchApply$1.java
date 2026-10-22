package com.larus.im.internal.core.message.regen;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.regen.RegenHelper", f = "RegenHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {77, 81}, m = "batchApply", n = {"bodies", "applyFor", "ret", "localMsgList", "applyFor", "ret", "localMsgList", ContainerPosition.BODY, "tarEntity"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$4", "L$5"})
public final class RegenHelper$batchApply$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RegenHelper this$0;

    public RegenHelper$batchApply$1(RegenHelper r100, Continuation<? super RegenHelper$batchApply$1> r101) {
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
