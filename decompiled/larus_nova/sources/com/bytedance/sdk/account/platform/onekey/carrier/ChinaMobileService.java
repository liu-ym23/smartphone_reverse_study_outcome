package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.CommonUtils;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ChinaMobileService extends AbsCarrier {
    private final AuthnHelper mAuthHelper;
    private final OnekeyLoginConfig.CMSettingConfig mCMSettingConfig;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements TokenListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f269277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthorizeCallback f269278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f269279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f269280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f269281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ChinaMobileService f269282f;

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public final void onGetTokenComplete(JSONObject r110) {
            long r100 = System.currentTimeMillis() - this.f269277a;
            if (r110 != null) goto L5;
            String r101 = "-1";
            String r102 = "invalid_response";
        L10:
            String r103 = r102;
            String r104 = r101;
            this.f269282f.postLoginErrorResponse(r104, r103, null, "mobile", this.f269279c, this.f269280d, this.f269281e, 1, System.currentTimeMillis() - this.f269277a, r110, this.f269278b);
            return;
        L5:
            if (r110.has(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP) == false) goto L8;
            String r105 = r110.toString();
            String r106 = r110.optString(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP);
            int r107 = r110.optInt("scripExpiresIn");
            MobileCarrierCacheInfo r108 = this.f269282f.getCacheInfoNotNull();
            r108.updateMaskPhoneResult(r106, r105);
            r108.setScripExpiresTime(System.currentTimeMillis() + (((long) r107) * 1000));
            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(r108);
            this.f269282f.sendOneKeySuccessMessage(new OnekeyResponseCallable(this.f269278b, r108.parseToPhoneInfoResponse()));
            ChinaMobileService r109 = this.f269282f;
            r109.onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(r109.getContext(), true, null, null, r100, null, OnekeyDataHelper.CM_EVENT_CARRIER, this.f269279c, this.f269280d, this.f269281e, this.f269278b));
            return;
        L8:
            r101 = r110.optString("resultCode");
            r102 = r110.optString("resultDesc");
            goto L10
        }

        public a(ChinaMobileService r100, long r101, AuthorizeCallback r102, String r103, String r104, int r105) {
            this.f269282f = r100;
            this.f269277a = r101;
            this.f269278b = r102;
            this.f269279c = r103;
            this.f269280d = r104;
            this.f269281e = r105;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements TokenListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f269283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f269284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AuthorizeCallback f269285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f269286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f269287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ChinaMobileService f269288f;

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public final void onGetTokenComplete(JSONObject r210) {
            long r100 = System.currentTimeMillis() - this.f269283a;
            if (r210 != null) goto L5;
            String r101 = "-1";
        L16:
            String r102 = "invalid_response";
        L17:
            this.f269288f.postLoginErrorResponse(r101, r102, null, "mobile", this.f269286d, null, this.f269287e, 2, System.currentTimeMillis() - this.f269283a, r210, this.f269285c);
            return;
        L5:
            if ("103000".equals(r210.optString("resultCode")) == true) goto L7;
            r102 = "unknown";
            r101 = r210.optString("resultCode");
            goto L17
        L7:
            if (r210.has("token") == false) goto L13;
            String r110 = r210.toString();
            String r103 = r210.optString(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP);
            String r104 = r210.optString("token");
            String r105 = r210.optString("authType");
            String r106 = r210.optString("openId");
            String r107 = r210.optString("authTypeDes");
            int r111 = r210.optInt("scripExpiresIn");
            int r112 = r210.optInt(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN);
            long r108 = ((long) r112) * 1000;
            long r113 = System.currentTimeMillis() + r108;
            Bundle r109 = new Bundle();
            r109.putString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE, r103);
            r109.putString("access_token", r104);
            r109.putString("net_type", "mobile");
            r109.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, "mobile");
            r109.putString("openId", r106);
            r109.putString("authType", r105);
            r109.putString("authTypeDes", r107);
            r109.putString("scripExpiresIn", String.valueOf(r111));
            r109.putString("expires_in", String.valueOf(r112));
            r109.putString("expires_time", String.valueOf(r113));
            r109.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, r210.toString());
            r109.putString("carrier_app_id", ChinaMobileService.access$000(this.f269288f).mCMAppId);
            MobileCarrierCacheInfo r114 = this.f269288f.getCacheInfoNotNull();
            r114.updateMaskPhoneResult(r103, r110);
            r114.setScripExpiresTime(System.currentTimeMillis() + (((long) r111) * 1000));
            if (this.f269284b == true) goto L11;
            r114.updateAuthTokenResult(r104, r110, r108, -1);
        L11:
            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(r114);
            this.f269288f.sendOneKeySuccessMessage(new OnekeyResponseCallable(this.f269285c, r109));
            ChinaMobileService r115 = this.f269288f;
            r115.onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(r115.getContext(), true, null, null, r100, null, OnekeyDataHelper.CM_EVENT_CARRIER, this.f269286d, null, this.f269287e, this.f269285c));
            return;
        L13:
            r101 = r210.optString("resultCode");
            goto L16
        }

        public b(ChinaMobileService r100, long r101, boolean r102, AuthorizeCallback r103, String r104, int r105) {
            this.f269288f = r100;
            this.f269283a = r101;
            this.f269284b = r102;
            this.f269285c = r103;
            this.f269286d = r104;
            this.f269287e = r105;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c implements TokenListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f269289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f269290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AuthorizeCallback f269291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f269292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f269293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ChinaMobileService f269294f;

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public final void onGetTokenComplete(JSONObject r210) {
            long r100 = System.currentTimeMillis() - this.f269289a;
            if (r210 != null) goto L5;
            String r101 = "-1";
        L17:
            String r102 = "invalid_response";
        L18:
            this.f269294f.postLoginErrorResponse(r101, r102, null, "mobile", this.f269292d, null, this.f269293e, 2, System.currentTimeMillis() - this.f269289a, r210, this.f269291c);
            return;
        L5:
            if ("103000".equals(r210.optString("resultCode")) == true) goto L7;
            r102 = "unknown";
            r101 = r210.optString("resultCode");
            goto L18
        L7:
            if (r210.has("token") == false) goto L14;
            String r110 = r210.toString();
            String r103 = r210.optString("token");
            String r104 = r210.optString("authType");
            String r105 = r210.optString("authTypeDes");
            int r106 = r210.optInt("scripExpiresIn");
            int r107 = r210.optInt(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN);
            Bundle r111 = new Bundle();
            r111.putString("access_token", r103);
            r111.putString("net_type", "mobile");
            r111.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, "mobile");
            r111.putString("authType", r104);
            r111.putString("authTypeDes", r105);
            r111.putString("scripExpiresIn", String.valueOf(r106));
            r111.putString("expires_in", String.valueOf(r107));
            long r108 = r107;
            r111.putString("expires_time", String.valueOf(System.currentTimeMillis() + (r108 * 1000)));
            r111.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, r210.toString());
            r111.putString("carrier_app_id", ChinaMobileService.access$000(this.f269294f).mCMAppId);
            MobileCarrierCacheInfo r109 = this.f269294f.getCacheInfoNotNull();
            r109.setScripExpiresTime(System.currentTimeMillis() + (((long) r106) * 1000));
            if (this.f269290b == true) goto L12;
            r109.updateValidateTokenResult(r103, r110, r108, -1);
        L12:
            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(r109);
            this.f269294f.sendOneKeySuccessMessage(new OnekeyResponseCallable(this.f269291c, r111));
            ChinaMobileService r112 = this.f269294f;
            r112.onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(r112.getContext(), true, null, null, r100, null, OnekeyDataHelper.CM_EVENT_CARRIER, this.f269292d, null, this.f269293e, this.f269291c));
            return;
        L14:
            r101 = r210.optString("resultCode");
            goto L17
        }

        public c(ChinaMobileService r100, long r101, boolean r102, AuthorizeCallback r103, String r104, int r105) {
            this.f269294f = r100;
            this.f269289a = r101;
            this.f269290b = r102;
            this.f269291c = r103;
            this.f269292d = r104;
            this.f269293e = r105;
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String getCarrierName() {
        return "mobile";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String settingKey() {
        return OnekeySettingManager.KEY_CM_CONFIG;
    }

    public MobileCarrierCacheInfo getCacheInfoNotNull() {
        int r100 = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo r101 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(r100);
        if ((r101 instanceof MobileCarrierCacheInfo) == false) goto L7;
        return (MobileCarrierCacheInfo) r101;
    L7:
        return new MobileCarrierCacheInfo(r100);
    }

    public static /* synthetic */ OnekeyLoginConfig.CMSettingConfig access$000(ChinaMobileService r100) {
        return r100.mCMSettingConfig;
    }

    public ChinaMobileService(IServiceContainer r100, OnekeyLoginConfig.CMSettingConfig r101) {
        super(r100);
        this.mCMSettingConfig = r101;
        this.mAuthHelper = AuthnHelper.getInstance(r100.getApplicationContext());
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(String r110, int r111, boolean r112, AuthorizeCallback r210) {
        if (isEnable() == true) goto L7;
        postCarrierDisableError("mobile", r110, null, r111, OnekeyDataHelper.GET_TOKEN_EVENT, 2, r210);
        return;
    L7:
        if (needReadPhonePermission() == false) goto L13;
        if (CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE") == true) goto L13;
        postNoPermissionError(r110, null, r111, OnekeyDataHelper.GET_TOKEN_EVENT, 2, r210);
        return;
    L13:
        if (this.mCMSettingConfig != null) goto L18;
        if (r210 == null) goto L16;
        r210.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", r111, 2, null));
    L16:
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CM_EVENT_CARRIER, r110, null, r111, r210));
        return;
    L18:
        onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, r110, null, r111, r210));
        long r100 = System.currentTimeMillis();
        this.mAuthHelper.setOverTime(getTimeout(r110));     // Catch: Exception -> L21
        AuthnHelper r101 = this.mAuthHelper;     // Catch: Exception -> L21
        OnekeyLoginConfig.CMSettingConfig r102 = this.mCMSettingConfig;     // Catch: Exception -> L21
        r101.loginAuth(r102.mCMAppId, r102.mCMAppKey, new b(this, r100, r112, r210, r110, r111));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        postLoginErrorResponse("-1", e.getMessage(), null, "mobile", r110, null, r111, 2, System.currentTimeMillis() - r100, null, r210);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(String r110, int r111, boolean r112, AuthorizeCallback r210) {
        if (isEnable() == true) goto L7;
        postCarrierDisableError("mobile", r110, null, r111, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, r210);
        return;
    L7:
        if (needReadPhonePermission() == false) goto L13;
        if (CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE") == true) goto L13;
        postNoPermissionError(r110, null, r111, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, r210);
        return;
    L13:
        if (this.mCMSettingConfig != null) goto L20;
        if (r210 != null) goto L16;
    L18:
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CM_EVENT_CARRIER, r110, null, r111, r210));
        return;
    L16:
        if (this.isCancel == true) goto L18;
        r210.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", r111, 2, null));
        goto L18
    L20:
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, r110, null, r111, r210));
        long r100 = System.currentTimeMillis();
        this.mAuthHelper.setOverTime(getTimeout(r110));     // Catch: Exception -> L23
        AuthnHelper r101 = this.mAuthHelper;     // Catch: Exception -> L23
        OnekeyLoginConfig.CMSettingConfig r102 = this.mCMSettingConfig;     // Catch: Exception -> L23
        r101.mobileAuth(r102.mCMAppId, r102.mCMAppKey, new c(this, r100, r112, r210, r110, r111));     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        postLoginErrorResponse("-1", e.getMessage(), null, "mobile", r110, null, r111, 2, System.currentTimeMillis() - r100, null, r210);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String r110, String r111, int r112, boolean r210, AuthorizeCallback r211) {
        if (this.mCMSettingConfig != null) goto L9;
        if (r211 == null) goto L6;
        r211.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, "mobile", r112, 1, null));
    L6:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CM_EVENT_CARRIER, r110, r111, r112, r211));
        return;
    L9:
        if (isEnable() == true) goto L12;
        postCarrierDisableError("mobile", r110, r111, r112, OnekeyDataHelper.GET_PHONE_EVENT, 1, r211);
        return;
    L12:
        boolean r100 = NetworkTypeHelper.isMobileEnabled(r112);
        if (needDataMobile(false) == false) goto L18;
        if (r100 == true) goto L18;
        postDataMobileDisableError("mobile", r110, r111, r112, r211);
        return;
    L18:
        if (needReadPhonePermission() == true) goto L20;
    L23:
        onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CM_EVENT_CARRIER, r110, r111, r112, r211));
        long r101 = System.currentTimeMillis();
        this.mAuthHelper.setOverTime(getTimeout(r110));     // Catch: Exception -> L26
        AuthnHelper r102 = this.mAuthHelper;     // Catch: Exception -> L26
        OnekeyLoginConfig.CMSettingConfig r103 = this.mCMSettingConfig;     // Catch: Exception -> L26
        r102.getPhoneInfo(r103.mCMAppId, r103.mCMAppKey, new a(this, r101, r211, r110, r111, r112));     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
        postLoginErrorResponse("-1", e.getMessage(), null, "mobile", r110, r111, r112, 1, System.currentTimeMillis() - r101, null, r211);
        return;
    L20:
        if (CommonUtils.hasPermission(getContext(), "android.permission.READ_PHONE_STATE") == true) goto L23;
        postNoPermissionError(r110, r111, r112, OnekeyDataHelper.GET_PHONE_EVENT, 1, r211);
    }

    private void postNoPermissionError(String r210, String r211, int r212, String r213, int r214, AuthorizeCallback r215) {
        if (r215 != null) goto L5;
    L7:
        onEvent(r213, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_NO_PHONE_STATE_PERMISSON, OnekeyLoginConstants.ErrorMsg.ERROR_NO_PHONE_STATE_PERMISSON_MSG, 0, null, "mobile", r210, r211, r212, r215));
        return;
    L5:
        if (this.isCancel == true) goto L7;
        r215.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_NO_PHONE_STATE_PERMISSON, OnekeyLoginConstants.ErrorMsg.ERROR_NO_PHONE_STATE_PERMISSON_MSG, "mobile", r212, r214));
        goto L7
    }
}
