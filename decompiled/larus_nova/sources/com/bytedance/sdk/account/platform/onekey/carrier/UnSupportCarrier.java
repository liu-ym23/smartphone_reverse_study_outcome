package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;

/* JADX INFO: loaded from: classes3.dex */
public class UnSupportCarrier extends AbsCarrier {
    private String mCarrier;

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String getCarrierName() {
        return "others";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String settingKey() {
        return null;
    }

    public UnSupportCarrier(IServiceContainer r100) {
        super(r100);
    }

    public void setCarrierType(String r100) {
        this.mCarrier = r100;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(String r100, int r101, boolean r110, AuthorizeCallback r111) {
        if (r111 == null) goto L4;
        OnekeyLoginErrorResponse r112 = new OnekeyLoginErrorResponse();
        r112.netType = this.mCarrier;
        r112.errorType = 2;
        r112.platformErrorCode = "-2";
        r112.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
        r111.onError(r112);
    L4:
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, r100, "", r101, r111);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(String r100, int r101, boolean r110, AuthorizeCallback r111) {
        if (r111 == null) goto L4;
        OnekeyLoginErrorResponse r112 = new OnekeyLoginErrorResponse();
        r112.netType = this.mCarrier;
        r112.errorType = 2;
        r112.platformErrorCode = "-2";
        r112.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
        r111.onError(r112);
    L4:
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, r100, "", r101, r111);
    }

    private void onEvent(String r110, String r111, String r112, int r113, AuthorizeCallback r114) {
        onEvent(r110, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-2", OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT, 0, null, this.mCarrier, r111, r112, r113, r114));
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String r100, String r101, int r110, boolean r111, AuthorizeCallback r112) {
        if (r112 == null) goto L4;
        OnekeyLoginErrorResponse r113 = new OnekeyLoginErrorResponse();
        r113.netType = this.mCarrier;
        r113.netStatus = r110;
        r113.errorType = 1;
        r113.platformErrorCode = "-2";
        r113.platformErrorMsg = OnekeyLoginConstants.ErrorMsg.ERROR_NOT_SUPPORT;
        r112.onError(r113);
    L4:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, r100, r101, r110, r112);
    }
}
