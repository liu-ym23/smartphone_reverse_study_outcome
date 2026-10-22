package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository", f = "BDAuthorizeRepository.kt", i = {}, l = {476, 480, 481}, m = "ensureCurrentUserProfileIfNeeded", n = {}, s = {})
public final class BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1(BDAuthorizeRepository r100, Continuation<? super BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
