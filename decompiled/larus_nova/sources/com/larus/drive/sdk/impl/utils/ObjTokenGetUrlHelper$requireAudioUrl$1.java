package com.larus.drive.sdk.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {120}, m = "requireAudioUrl", n = {}, s = {})
public final class ObjTokenGetUrlHelper$requireAudioUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObjTokenGetUrlHelper this$0;

    public ObjTokenGetUrlHelper$requireAudioUrl$1(ObjTokenGetUrlHelper r100, Continuation<? super ObjTokenGetUrlHelper$requireAudioUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
