package com.larus.im.internal.network.chunk;

import com.larus.im.internal.protocol.bean.DownlinkMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChunkOperator$ChunkChannel$sendMessage$6 extends FunctionReferenceImpl implements Function2<DownlinkMessage, Continuation<? super String>, Object>, SuspendFunction {
    public ChunkOperator$ChunkChannel$sendMessage$6(Object r100) {
        super(2, r100, Intrinsics.Kotlin.class, "suspendConversion6", "sendMessage$suspendConversion6(Lkotlin/jvm/functions/Function1;Lcom/larus/im/internal/protocol/bean/DownlinkMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DownlinkMessage r100, Continuation<? super String> r101) {
        return ((Function1) this.receiver).invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(DownlinkMessage r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }
}
