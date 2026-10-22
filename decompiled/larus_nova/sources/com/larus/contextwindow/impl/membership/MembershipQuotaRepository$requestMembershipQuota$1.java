package com.larus.contextwindow.impl.membership;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.membership.MembershipQuotaRepository", f = "MembershipQuotaRepository.kt", i = {0}, l = {92}, m = "requestMembershipQuota", n = {"request"}, s = {"L$0"})
public final class MembershipQuotaRepository$requestMembershipQuota$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MembershipQuotaRepository this$0;

    public MembershipQuotaRepository$requestMembershipQuota$1(MembershipQuotaRepository r100, Continuation<? super MembershipQuotaRepository$requestMembershipQuota$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MembershipQuotaRepository r101 = this.this$0;
        Lazy<MembershipQuotaRepository> r102 = MembershipQuotaRepository.f330347k;
        return r101.e(false, this);
    }
}
