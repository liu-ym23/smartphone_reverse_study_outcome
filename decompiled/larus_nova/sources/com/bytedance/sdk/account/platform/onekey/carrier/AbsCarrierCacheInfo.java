package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001a\u001a\u00020\u0006H&J\u0006\u0010\u001b\u001a\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020\"H\u0016J\n\u0010'\u001a\u0004\u0018\u00010%H\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020%H\u0014J,\u0010+\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bJ\u001a\u0010,\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006J,\u0010.\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "", "subscriptionId", "", "(I)V", "authToken", "", "authTokenExpireIn", "", "authTokenExpireTime", "authTokenRawResult", "authTokenUpdateTime", "maskPhone", "phoneInfoRawResult", "getSubscriptionId", "()I", "setSubscriptionId", "validateToken", "validateTokenExpireIn", "validateTokenExpireTime", "validateTokenRawResult", "validateTokenUpdateTime", "cleanTokenCache", "", "cleanValidateTokenCache", "getCarrierAppId", "getCarrierFrom", "getMaskPhone", "getNetType", "getTokenExpireIn", "getTokenExpireTime", "getValidateTokenExpireIn", "getValidateTokenExpireTime", "isTokenValid", "", "isValidateTokenValid", "parseToAuthTokenResponse", "Landroid/os/Bundle;", "cleanCache", "parseToPhoneInfoResponse", "parseToValidateTokenResponse", "putCommonResponse", "bundle", "updateAuthTokenResult", "updateMaskPhoneResult", "phoneInfoResult", "updateValidateTokenResult", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
public abstract class AbsCarrierCacheInfo {
    private String authToken;
    private long authTokenExpireIn;
    private long authTokenExpireTime;
    private String authTokenRawResult;
    private long authTokenUpdateTime;
    private String maskPhone;
    private String phoneInfoRawResult;
    private int subscriptionId;
    private String validateToken;
    private long validateTokenExpireIn;
    private long validateTokenExpireTime;
    private String validateTokenRawResult;
    private long validateTokenUpdateTime;

    public AbsCarrierCacheInfo() {
        int r100 = 0;
        this(r100, 1, null);
    }

    private final void cleanTokenCache() {
        this.authToken = null;
        this.authTokenExpireTime = -1;
        this.authTokenRawResult = null;
    }

    private final void cleanValidateTokenCache() {
        this.validateToken = null;
        this.validateTokenExpireTime = -1;
        this.validateTokenRawResult = null;
    }

    public abstract String getCarrierAppId();

    public abstract String getCarrierFrom();

    public abstract String getNetType();

    public final String getMaskPhone() {
        String r100 = this.maskPhone;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public final boolean isTokenValid() {
        if (TextUtils.isEmpty(this.authToken) == false) goto L6;
        return false;
    L6:
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L12;
        if (getTokenExpireIn() <= 0) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (this.authTokenExpireTime <= System.currentTimeMillis()) goto L16;
        return true;
    L16:
        return false;
    }

    public final boolean isValidateTokenValid() {
        if (TextUtils.isEmpty(this.validateToken) == false) goto L6;
        return false;
    L6:
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L12;
        if (getValidateTokenExpireIn() <= 0) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (this.validateTokenExpireTime <= System.currentTimeMillis()) goto L16;
        return true;
    L16:
        return false;
    }

    public Bundle parseToPhoneInfoResponse() {
        if (TextUtils.isEmpty(this.maskPhone) == false) goto L6;
        return null;
    L6:
        Bundle r100 = new Bundle();
        putCommonResponse(r100);
        return r100;
    }

    private final long getTokenExpireIn() {
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L7;
        long r100 = this.authTokenExpireIn;
        long r101 = SystemClock.elapsedRealtime() - this.authTokenUpdateTime;
    L6:
        return r100 - r101;
    L7:
        r100 = this.authTokenExpireTime;
        r101 = System.currentTimeMillis();
        goto L6
    }

    private final long getTokenExpireTime() {
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L7;
        return System.currentTimeMillis() + getTokenExpireIn();
    L7:
        return this.authTokenExpireTime;
    }

    private final long getValidateTokenExpireIn() {
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L7;
        long r100 = this.validateTokenExpireIn;
        long r101 = SystemClock.elapsedRealtime() - this.validateTokenUpdateTime;
    L6:
        return r100 - r101;
    L7:
        r100 = this.validateTokenExpireTime;
        r101 = System.currentTimeMillis();
        goto L6
    }

    private final long getValidateTokenExpireTime() {
        if (OnekeySettingManager.instance().isEnableExpireTimeOpt() == false) goto L7;
        return System.currentTimeMillis() + getValidateTokenExpireIn();
    L7:
        return this.validateTokenExpireTime;
    }

    public final int getSubscriptionId() {
        return this.subscriptionId;
    }

    public AbsCarrierCacheInfo(int r100) {
        this.subscriptionId = r100;
        this.authTokenExpireIn = -1;
        this.authTokenExpireTime = -1;
        this.authTokenUpdateTime = -1;
        this.validateTokenExpireIn = -1;
        this.validateTokenExpireTime = -1;
        this.validateTokenUpdateTime = -1;
    }

    public Bundle parseToAuthTokenResponse(boolean r100) {
        if (isTokenValid() == true) goto L6;
        return null;
    L6:
        Bundle r101 = new Bundle();
        putCommonResponse(r101);
        String r102 = this.authTokenRawResult;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        r101.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, this.authTokenRawResult);
    L15:
        if (r100 == false) goto L17;
        cleanTokenCache();
    L17:
        return r101;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public Bundle parseToValidateTokenResponse(boolean r100) {
        if (isValidateTokenValid() == true) goto L6;
        return null;
    L6:
        Bundle r101 = new Bundle();
        putCommonResponse(r101);
        r101.putString("access_token", this.validateToken);
        r101.putString("expires_in", String.valueOf(getValidateTokenExpireIn() / ((long) 1000)));
        r101.putString("expires_time", String.valueOf(getValidateTokenExpireTime()));
        String r102 = this.validateTokenRawResult;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        r101.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, this.validateTokenRawResult);
    L15:
        if (r100 == false) goto L17;
        cleanValidateTokenCache();
    L17:
        return r101;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public void putCommonResponse(Bundle r100) {
        r100.putString("carrier_app_id", getCarrierAppId());
        r100.putString("net_type", getNetType());
        r100.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, getCarrierFrom());
        r100.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, this.phoneInfoRawResult);
        r100.putString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE, this.maskPhone);
        if (isTokenValid() == false) goto L6;
        r100.putString("access_token", this.authToken);
        r100.putString("expires_in", String.valueOf(getTokenExpireIn() / ((long) 1000)));
        r100.putString("expires_time", String.valueOf(getTokenExpireTime()));
        return;
    }

    public final void setSubscriptionId(int r100) {
        this.subscriptionId = r100;
    }

    public final void updateMaskPhoneResult(String r100, String r101) {
        this.maskPhone = r100;
        this.phoneInfoRawResult = r101;
    }

    public /* synthetic */ AbsCarrierCacheInfo(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        this(r100);
    }

    public static /* synthetic */ Bundle parseToAuthTokenResponse$default(AbsCarrierCacheInfo r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = true;
    L7:
        return r100.parseToAuthTokenResponse(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseToAuthTokenResponse");
    }

    public static /* synthetic */ Bundle parseToValidateTokenResponse$default(AbsCarrierCacheInfo r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = true;
    L7:
        return r100.parseToValidateTokenResponse(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseToValidateTokenResponse");
    }

    public final void updateAuthTokenResult(String r100, String r101, long r102, long r103) {
        if (r100 != null) goto L4;
    L7:
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        cleanTokenCache();
        return;
    L11:
        this.authToken = r100;
        this.authTokenRawResult = r101;
        this.authTokenExpireIn = r102;
        if (r103 > 0) goto L15;
        r103 = System.currentTimeMillis() + r102;
    L15:
        this.authTokenExpireTime = r103;
        this.authTokenUpdateTime = SystemClock.elapsedRealtime();
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r104 = false;
        goto L8
    }

    public final void updateValidateTokenResult(String r100, String r101, long r102, long r103) {
        if (r100 != null) goto L4;
    L7:
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        cleanValidateTokenCache();
        return;
    L11:
        this.validateToken = r100;
        this.validateTokenRawResult = r101;
        this.validateTokenExpireIn = r102;
        if (r103 > 0) goto L15;
        r103 = System.currentTimeMillis() + r102;
    L15:
        this.validateTokenExpireTime = r103;
        this.validateTokenUpdateTime = SystemClock.elapsedRealtime();
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r104 = false;
        goto L8
    }

    public static /* synthetic */ void updateAuthTokenResult$default(AbsCarrierCacheInfo r100, String r101, String r102, long r110, long r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L6;
        r111 = -1;
    L6:
        r100.updateAuthTokenResult(r101, r102, r110, r111);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAuthTokenResult");
    }

    public static /* synthetic */ void updateValidateTokenResult$default(AbsCarrierCacheInfo r100, String r101, String r102, long r110, long r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L6;
        r111 = -1;
    L6:
        r100.updateValidateTokenResult(r101, r102, r110, r111);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateValidateTokenResult");
    }
}
