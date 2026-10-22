package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.unbundle.BenefitStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/unbundle/BenefitStore;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl$fetchResourceBenefitsFromServer$1", f = "BenefitManagerImpl.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
final class BenefitManagerImpl$fetchResourceBenefitsFromServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BenefitStore>, Object> {
    final /* synthetic */ boolean $includeOwnerTenantInfo;
    final /* synthetic */ String $ownerID;
    final /* synthetic */ String $token;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ BenefitManagerImpl this$0;

    public BenefitManagerImpl$fetchResourceBenefitsFromServer$1(BenefitManagerImpl r1, String r2, int r3, String r4, boolean r5, Continuation<? super BenefitManagerImpl$fetchResourceBenefitsFromServer$1> r6) {
        this.this$0 = r1;
        this.$token = r2;
        this.$type = r3;
        this.$ownerID = r4;
        this.$includeOwnerTenantInfo = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new BenefitManagerImpl$fetchResourceBenefitsFromServer$1(this.this$0, this.$token, this.$type, this.$ownerID, this.$includeOwnerTenantInfo, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BenefitStore> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        BenefitManagerImpl r2 = this.this$0;
        if (r2.c == true) goto L12;
        return null;
    L12:
        String r11 = this.$token;
        int r3 = this.$type;
        String r4 = this.$ownerID;
        boolean r6 = this.$includeOwnerTenantInfo;
        this.label = 1;
        r10 = BenefitManagerImpl.a(r2, r11, r3, r4, null, r6, this, 8);
        if (r10 != r0) goto L15;
        return r0;
    }
}
