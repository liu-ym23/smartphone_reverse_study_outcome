package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.urlpreview.OfficeWikiTokenResolverServiceImpl", f = "OfficeWikiTokenResolverServiceImpl.kt", i = {}, l = {19}, m = "resolveObjectToken", n = {}, s = {})
public final class OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeWikiTokenResolverServiceImpl this$0;

    public OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1(OfficeWikiTokenResolverServiceImpl r100, Continuation<? super OfficeWikiTokenResolverServiceImpl$resolveObjectToken$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
