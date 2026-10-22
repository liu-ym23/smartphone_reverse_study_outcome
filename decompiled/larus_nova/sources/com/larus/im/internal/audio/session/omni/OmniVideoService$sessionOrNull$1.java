package com.larus.im.internal.audio.session.omni;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.audio.session.omni.OmniVideoService", f = "OmniVideoService.kt", i = {0}, l = {120}, m = "sessionOrNull", n = {com.alipay.sdk.m.p.e.f25671s}, s = {"L$0"})
final class OmniVideoService$sessionOrNull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniVideoService this$0;

    public OmniVideoService$sessionOrNull$1(OmniVideoService r100, Continuation<? super OmniVideoService$sessionOrNull$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OmniVideoService.a(this.this$0, null, this);
    }
}
