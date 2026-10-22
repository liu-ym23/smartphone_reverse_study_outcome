package com.larus.platform.exp;

import com.larus.platform.service.AccountService;
import hq9.o2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LarkSocialExp$recomputeState$transition$1 extends FunctionReferenceImpl implements Function0<o2> {
    public LarkSocialExp$recomputeState$transition$1(Object r100) {
        super(0, r100, LarkSocialExp.class, "currentEligibilityContext", "currentEligibilityContext()Lcom/larus/platform/model/LarkSocialEligibilityContext;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final o2 invoke() {
        LarkSocialExp r100 = (LarkSocialExp) this.receiver;
        LarkSocialExp r101 = LarkSocialExp.f365340a;
        r100.getClass();
        AccountService r102 = AccountService.f365697a;
        String r103 = r102.getUserId();
        String r104 = r102.getSecUserId();
        boolean r105 = true;
        if (r102.isLogin().booleanValue() == true) goto L7;
        r105 = false;
    L7:
        return new o2(r103, r104, r105, r102.isEnterpriseAccount());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ o2 invoke() {
        return invoke();
    }
}
