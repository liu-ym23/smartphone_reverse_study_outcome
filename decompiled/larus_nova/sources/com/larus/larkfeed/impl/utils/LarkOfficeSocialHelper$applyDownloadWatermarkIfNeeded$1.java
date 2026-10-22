package com.larus.larkfeed.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.utils.LarkOfficeSocialHelper", f = "LarkOfficeSocialHelper.kt", i = {}, l = {248}, m = "applyDownloadWatermarkIfNeeded", n = {}, s = {})
public final class LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkOfficeSocialHelper this$0;

    public LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1(LarkOfficeSocialHelper r100, Continuation<? super LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LarkOfficeSocialHelper r101 = this.this$0;
        LarkOfficeSocialHelper r102 = LarkOfficeSocialHelper.f355542a;
        return r101.a(null, this);
    }
}
