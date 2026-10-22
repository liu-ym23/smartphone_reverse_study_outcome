package com.larus.office.base.watermark.local;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.local.LocalImageBridge", f = "LocalImageBridge.kt", i = {}, l = {72}, m = "getWatermarkedResource", n = {}, s = {})
final class LocalImageBridge$getWatermarkedResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalImageBridge this$0;

    public LocalImageBridge$getWatermarkedResource$1(LocalImageBridge r100, Continuation<? super LocalImageBridge$getWatermarkedResource$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LocalImageBridge.a(this.this$0, null, this);
    }
}
