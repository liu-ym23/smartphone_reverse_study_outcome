package jd7;

import com.bytedance.android.anniex.ability.service.AccountAuthType;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getBindState")
public final class d extends defpackage.f {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        f.b r102 = (f.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        int r103 = r102.getAccountAuthType().intValue();
        AccountAuthType r104 = AccountAuthType.Douyin;
        if (r103 == r104.getValue()) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "only support douyin", null, 4, null);
        return;
    L5:
        AnnieXServiceCenter.f40313a.getClass();
        IAnnieXAccountService r105 = (IAnnieXAccountService) AnnieXServiceCenter.d("default_bid", IAnnieXAccountService.class);
        Unit r106 = null;
        if (r105 == null) goto L8;
        boolean r107 = r105.C0(r104);
        XBaseModel r108 = ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));
        ((f.c) r108).setBind(Boolean.valueOf(r107));
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r108, null, 2, null);
        r106 = Unit.INSTANCE;
    L8:
        if (r106 != null) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "the function getBindState in IAnnieXAccountService is not implemented", null, 4, null);
        return;
    }
}
