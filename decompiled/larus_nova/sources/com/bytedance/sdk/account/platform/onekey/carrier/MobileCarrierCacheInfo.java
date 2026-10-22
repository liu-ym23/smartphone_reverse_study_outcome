package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/MobileCarrierCacheInfo;", "Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "subscriptionId", "", "(I)V", "scripExpiresTime", "", "getScripExpiresTime", "()J", "setScripExpiresTime", "(J)V", "getCarrierAppId", "", "getCarrierFrom", "getNetType", "putCommonResponse", "", "bundle", "Landroid/os/Bundle;", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
public final class MobileCarrierCacheInfo extends AbsCarrierCacheInfo {
    private long scripExpiresTime;

    public MobileCarrierCacheInfo() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierFrom() {
        return "mobile";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getNetType() {
        return "mobile";
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
        OnekeyLoginConfig.CMSettingConfig r103 = r102.getCMSettingConfig();
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.mCMAppId;
    L14:
        return null;
    L13:
        return null;
    }

    public final long getScripExpiresTime() {
        return this.scripExpiresTime;
    }

    public MobileCarrierCacheInfo(int r100) {
        super(r100);
        this.scripExpiresTime = -1;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public void putCommonResponse(Bundle r100) {
        super.putCommonResponse(r100);
        long r101 = this.scripExpiresTime;
        if (r101 <= 0) goto L6;
        r100.putString("scripExpiresIn", String.valueOf((r101 - System.currentTimeMillis()) / ((long) 1000)));
        return;
    }

    public final void setScripExpiresTime(long r100) {
        this.scripExpiresTime = r100;
    }

    public /* synthetic */ MobileCarrierCacheInfo(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        this(r100);
    }
}
