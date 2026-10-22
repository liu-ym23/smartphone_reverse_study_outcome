package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/UnionCarrierCacheInfo;", "Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "subscriptionId", "", "(I)V", "getCarrierAppId", "", "getCarrierFrom", "getNetType", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
public final class UnionCarrierCacheInfo extends AbsCarrierCacheInfo {
    public UnionCarrierCacheInfo() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierFrom() {
        return OnekeyLoginConstants.UNICOM_V2;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getNetType() {
        return OnekeyLoginConstants.UNICOM;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierAppId() {
        IAuthorizeService r100 = AuthorizeFramework.getService(IOnekeyLoginService.class);
        if ((r100 instanceof IServiceContainer) == true) goto L5;
        r100 = null;
    L5:
        IServiceContainer r101 = (IServiceContainer) r100;
        if (r101 == null) goto L13;
        OnekeyLoginConfig r102 = r101.getConfig();
        if (r102 == null) goto L14;
        OnekeyLoginConfig.CUSettingConfig r103 = r102.getCUSettingConfig();
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.mCUAppId;
    L14:
        return null;
    L13:
        return null;
    }

    public UnionCarrierCacheInfo(int r100) {
        super(r100);
    }

    public /* synthetic */ UnionCarrierCacheInfo(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        this(r100);
    }
}
