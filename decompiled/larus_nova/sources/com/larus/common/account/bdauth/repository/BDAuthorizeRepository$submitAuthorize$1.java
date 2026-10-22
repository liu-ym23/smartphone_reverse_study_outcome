package com.larus.common.account.bdauth.repository;

import com.huawei.hms.common.AccountPicker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository", f = "BDAuthorizeRepository.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {213, 242, 251, 257, 257}, m = "submitAuthorize", n = {"request", AccountPicker.EXTRA_SELECTED_ACCOUNT, "request", "targetAccount", "sceneSnapshot", "targetAccount", "sceneSnapshot"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class BDAuthorizeRepository$submitAuthorize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$submitAuthorize$1(BDAuthorizeRepository r100, Continuation<? super BDAuthorizeRepository$submitAuthorize$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, this);
    }
}
