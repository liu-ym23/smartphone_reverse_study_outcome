package com.larus.common.account.bdauth.repository;

import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository", f = "BDAuthorizeRepository.kt", i = {0}, l = {BDVideoUploaderBase.KeyIsDynamicSliceNormalSize}, m = "buildFallbackCurrentAccount", n = {"secUserId"}, s = {"L$0"})
public final class BDAuthorizeRepository$buildFallbackCurrentAccount$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$buildFallbackCurrentAccount$1(BDAuthorizeRepository r100, Continuation<? super BDAuthorizeRepository$buildFallbackCurrentAccount$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
