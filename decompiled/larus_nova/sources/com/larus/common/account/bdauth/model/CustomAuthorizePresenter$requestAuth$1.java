package com.larus.common.account.bdauth.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomAuthorizePresenter", f = "CustomAuthorizePresenter.kt", i = {}, l = {81}, m = "requestAuth", n = {}, s = {})
final class CustomAuthorizePresenter$requestAuth$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CustomAuthorizePresenter$requestAuth$1(a r100, Continuation<? super CustomAuthorizePresenter$requestAuth$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
