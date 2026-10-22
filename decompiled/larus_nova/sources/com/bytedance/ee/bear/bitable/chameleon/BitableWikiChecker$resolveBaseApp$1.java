package com.bytedance.ee.bear.bitable.chameleon;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.chameleon.BitableWikiChecker", f = "BitableWikiChecker.kt", i = {0, 0}, l = {153}, m = "resolveBaseApp", n = {"key", "deferred"}, s = {"L$0", "L$1"})
public final class BitableWikiChecker$resolveBaseApp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableWikiChecker this$0;

    public BitableWikiChecker$resolveBaseApp$1(BitableWikiChecker r100, Continuation<? super BitableWikiChecker$resolveBaseApp$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        BitableWikiChecker r101 = this.this$0;
        BitableWikiChecker r102 = BitableWikiChecker.f209632a;
        return r101.f(null, this);
    }
}
