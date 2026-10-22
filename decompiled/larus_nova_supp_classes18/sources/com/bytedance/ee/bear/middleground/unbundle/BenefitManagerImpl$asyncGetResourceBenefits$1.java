package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl", f = "BenefitManagerImpl.kt", i = {0}, l = {DocPermissionAction.ACTION_PUBLIC_PERM_DENY}, m = "asyncGetResourceBenefits", n = {"ownerID"}, s = {"L$0"})
public final class BenefitManagerImpl$asyncGetResourceBenefits$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BenefitManagerImpl this$0;

    public BenefitManagerImpl$asyncGetResourceBenefits$1(BenefitManagerImpl r1, Continuation<? super BenefitManagerImpl$asyncGetResourceBenefits$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d8(null, 0, null, null, this);
    }
}
