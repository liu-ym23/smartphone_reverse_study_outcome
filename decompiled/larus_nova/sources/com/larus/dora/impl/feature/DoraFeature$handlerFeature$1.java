package com.larus.dora.impl.feature;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feature.DoraFeature", f = "DoraFeature.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {89, 107}, m = "handlerFeature", n = {"uid", "p2pRTCRuntimeState", "linkMode", "xLinkConfig", "userBluetoothRTCEnabled", "userP2PRTCEnabled", "p2pRTCRuntimeSupported", "effectiveBluetoothRTCEnabled", "effectiveP2PRTCEnabled"}, s = {"L$0", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "I$0", "I$1"})
public final class DoraFeature$handlerFeature$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFeature this$0;

    public DoraFeature$handlerFeature$1(DoraFeature r100, Continuation<? super DoraFeature$handlerFeature$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraFeature r101 = this.this$0;
        DoraFeature r102 = DoraFeature.f335550a;
        return r101.a(this);
    }
}
