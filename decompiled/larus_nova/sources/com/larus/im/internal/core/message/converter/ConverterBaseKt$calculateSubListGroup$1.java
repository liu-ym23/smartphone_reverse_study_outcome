package com.larus.im.internal.core.message.converter;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.converter.ConverterBaseKt", f = "ConverterBase.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {60, 60, 67, 67}, m = "calculateSubListGroup", n = {"$this$calculateSubListGroup", "extMap", "parentMsgId", DyPayConstant.KEY_START_TIME, "$this$calculateSubListGroup", "extMap", "parentMsgId", "destination$iv$iv", DyPayConstant.KEY_START_TIME, "extMap", "parentMsgId", DyPayConstant.KEY_START_TIME, "extMap", "parentMsgId", "destination$iv$iv", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class ConverterBaseKt$calculateSubListGroup$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    public ConverterBaseKt$calculateSubListGroup$1(Continuation<? super ConverterBaseKt$calculateSubListGroup$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ConverterBaseKt.c(null, null, this);
    }
}
