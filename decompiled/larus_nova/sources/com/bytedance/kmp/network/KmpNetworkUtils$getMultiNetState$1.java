package com.bytedance.kmp.network;

import com.bytedance.kmp.network.multinet.MultiNetStateValue;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkUtils", f = "KmpNetworkUtils.kt", i = {}, l = {66}, m = "getMultiNetState", n = {}, s = {})
final class KmpNetworkUtils$getMultiNetState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkUtils this$0;

    public KmpNetworkUtils$getMultiNetState$1(KmpNetworkUtils r100, Continuation<? super KmpNetworkUtils$getMultiNetState$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        KmpNetworkUtils r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        KmpNetworkUtils$getMultiNetState$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
    L15:
        com.example.interopdemo.c r107 = (com.example.interopdemo.c) r104;
        MultiNetStateValue.a r108 = MultiNetStateValue.Companion;
        int r109 = r107.f274032a;
        r108.getClass();
        MultiNetStateValue r110 = (MultiNetStateValue) ((Map) MultiNetStateValue.access$getValueMap$delegate$cp().getValue()).get(Integer.valueOf(r109));
        if (r110 != null) goto L18;
        r110 = MultiNetStateValue.STOPPED;
    L18:
        MultiNetStateValue r111 = (MultiNetStateValue) ((Map) MultiNetStateValue.access$getValueMap$delegate$cp().getValue()).get(Integer.valueOf(r107.f274033b));
        if (r111 != null) goto L21;
        r111 = MultiNetStateValue.STOPPED;
    L21:
        r105 = new com.bytedance.kmp.network.multinet.a(r110, r111);
    L22:
        return r105;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        Lazy r112 = com.example.interopdemo.e.f274034a;
        r103.label = 1;
        r104 = com.example.interopdemo.f.f274035a.a(r103);
        if (r104 != r105) goto L15;
    L5:
        r103 = new KmpNetworkUtils$getMultiNetState$1(r101, this);
        goto L6
    }
}
