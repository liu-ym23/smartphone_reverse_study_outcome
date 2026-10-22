package com.larus.sheet.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.sheet.sdk.impl.SheetSdkServiceImplV2", f = "SheetSdkServiceImplV2.kt", i = {}, l = {201}, m = "initSdkIfNeeded", n = {}, s = {})
public final class SheetSdkServiceImplV2$initSdkIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SheetSdkServiceImplV2 this$0;

    public SheetSdkServiceImplV2$initSdkIfNeeded$1(SheetSdkServiceImplV2 r100, Continuation<? super SheetSdkServiceImplV2$initSdkIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
