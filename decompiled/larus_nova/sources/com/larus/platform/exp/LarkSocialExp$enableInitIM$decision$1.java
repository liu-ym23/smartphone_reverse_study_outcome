package com.larus.platform.exp;

import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LarkSocialExp$enableInitIM$decision$1 extends FunctionReferenceImpl implements Function0<LarkSocialExp.c> {
    public LarkSocialExp$enableInitIM$decision$1(Object r100) {
        super(0, r100, LarkSocialExp.class, "currentImInitializationContext", "currentImInitializationContext()Lcom/larus/platform/exp/LarkSocialExp$ImInitializationContext;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LarkSocialExp.c invoke() {
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
        return new LarkSocialExp.c(r103, r104, r105, r102.isEnterpriseAccount(), r102.getTenantId());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LarkSocialExp.c invoke() {
        return invoke();
    }
}
