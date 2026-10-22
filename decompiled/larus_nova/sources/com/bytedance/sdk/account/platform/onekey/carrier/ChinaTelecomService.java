package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ChinaTelecomService extends AbsCarrier {
    private final OnekeyLoginConfig.CTSettingConfig mCTSettingConfig;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements TraceLogger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChinaTelecomService f269295a;

        public a(ChinaTelecomService r100) {
            this.f269295a = r100;
        }

        public final void a(String r100) {
            if (TextUtils.isEmpty(ChinaTelecomService.access$000(this.f269295a).getLogTag()) == true) goto L5;
            ChinaTelecomService.access$000(this.f269295a).getLogTag();
            return;
        }

        @Override // cn.com.chinatelecom.account.api.TraceLogger
        public final void debug(String r100, String r101) {
            a(r100);
        }

        @Override // cn.com.chinatelecom.account.api.TraceLogger
        public final void info(String r100, String r101) {
            a(r100);
        }

        @Override // cn.com.chinatelecom.account.api.TraceLogger
        public final void warn(String r100, String r101, Throwable r102) {
            a(r100);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements ResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f269296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f269297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f269298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AuthorizeCallback f269299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f269300e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f269301f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f269302g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ChinaTelecomService f269303h;

        @Override // cn.com.chinatelecom.account.api.ResultListener
        public final void onResult(String r310) {
            String r110 = "unknown";
            long r111 = System.currentTimeMillis() - this.f269296a;
            String r210 = "-1";
            String r211 = "";
            JSONObject r100 = null;
            if (TextUtils.isEmpty(r310) == false) goto L65;
            String r101 = OnekeyDataHelper.GET_PHONE_EVENT;
            r110 = "invalid_response";
        L50:
            JSONObject r311 = r100;
        L51:
            String r212 = r110;
            String r213 = r210;
            String r214 = r211;
            if (r101.equals(this.f269297b) == false) goto L54;
            this.f269303h.postLoginErrorResponse(r213, r212, r214, OnekeyLoginConstants.TELECOM_V2, this.f269300e, this.f269301f, this.f269302g, 1, System.currentTimeMillis() - this.f269296a, r311, this.f269299d);
            return;
        L54:
            this.f269303h.postLoginErrorResponse(r213, r212, r214, OnekeyLoginConstants.TELECOM_V2, this.f269300e, this.f269301f, this.f269302g, 2, System.currentTimeMillis() - this.f269296a, r311, this.f269299d);
            return;
        L65:
            JSONObject r112 = new JSONObject(r310);     // Catch: Exception -> L46
        L43:
            e = e;
            JSONObject r102 = r112;
            r101 = OnekeyDataHelper.GET_PHONE_EVENT;
        L45:
            r100 = r102;
        L48:
            e.printStackTrace();
            goto L50
        L6:
            if (r112.optInt("result") != 0) goto L38;
            JSONObject r103 = (JSONObject) r112.opt("data");     // Catch: Exception -> L43
            if (r103 == null) goto L38;
            if (r103.has("number") == false) goto L38;
            String r104 = r103.optString("number");     // Catch: Exception -> L36
            String r105 = r103.optString("accessCode");     // Catch: Exception -> L36
            int r106 = r103.optInt("expiredTime");     // Catch: Exception -> L36
            TelecomCarrierCacheInfo r113 = this.f269303h.getCacheInfoNotNull();     // Catch: Exception -> L36
            r113.updateMaskPhoneResult(r104, r310);     // Catch: Exception -> L36
            if (this.f269297b.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT) == false) goto L20;
            r113.updateValidateTokenResult(r105, r310, 1000 * ((long) r106), -1);     // Catch: Exception -> L17
        L21:
            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(r113);     // Catch: Exception -> L36
            if (this.f269297b.equals(OnekeyDataHelper.GET_PHONE_EVENT) == false) goto L26;
            Bundle r107 = r113.parseToPhoneInfoResponse();     // Catch: Exception -> L17
        L30:
            this.f269303h.sendOneKeySuccessMessage(new OnekeyResponseCallable(this.f269299d, r107));     // Catch: Exception -> L36
            ChinaTelecomService r108 = this.f269303h;     // Catch: Exception -> L36
            String r109 = this.f269297b;     // Catch: Exception -> L36
            r102 = r112;
            r108.onEvent(r109, OnekeyDataHelper.generateMonitorJson(r108.getContext(), true, null, null, r111, null, OnekeyDataHelper.CT_EVENT_CARRIER, this.f269300e, this.f269301f, this.f269302g, this.f269299d));     // Catch: Exception -> L34
            return;
        L34:
            e = e;
            r101 = OnekeyDataHelper.GET_PHONE_EVENT;
            goto L45
        L26:
            if (this.f269297b.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT) == false) goto L29;
            r107 = r113.parseToValidateTokenResponse(this.f269298c);     // Catch: Exception -> L17
            goto L30
        L29:
            r107 = r113.parseToAuthTokenResponse(this.f269298c);     // Catch: Exception -> L36
        L17:
            e = e;
            r100 = r112;
        L47:
            r101 = OnekeyDataHelper.GET_PHONE_EVENT;
            goto L48
        L20:
            r113.updateAuthTokenResult(r105, r310, 1000 * ((long) r106), -1);     // Catch: Exception -> L36
        L36:
            e = e;
            r100 = r112;
        L38:
            r102 = r112;
            r101 = OnekeyDataHelper.GET_PHONE_EVENT;
            r210 = String.valueOf(r102.optInt("result"));     // Catch: Exception -> L41
            r110 = r102.optString("msg");     // Catch: Exception -> L41
            r211 = r102.optString("reqId");     // Catch: Exception -> L41
            r311 = r102;
        L41:
            e = e;
        L46:
            e = e;
            goto L47
        }

        public b(ChinaTelecomService r100, long r101, String r102, boolean r103, AuthorizeCallback r104, String r105, String r106, int r107) {
            this.f269303h = r100;
            this.f269296a = r101;
            this.f269297b = r102;
            this.f269298c = r103;
            this.f269299d = r104;
            this.f269300e = r105;
            this.f269301f = r106;
            this.f269302g = r107;
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier, com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void cancel() {
        this.isCancel = false;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String getCarrierName() {
        return OnekeyLoginConstants.TELECOM;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String settingKey() {
        return OnekeySettingManager.KEY_CT_CONFIG;
    }

    public TelecomCarrierCacheInfo getCacheInfoNotNull() {
        int r100 = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo r101 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(r100);
        if ((r101 instanceof TelecomCarrierCacheInfo) == false) goto L7;
        return (TelecomCarrierCacheInfo) r101;
    L7:
        return new TelecomCarrierCacheInfo(r100);
    }

    public static /* synthetic */ OnekeyLoginConfig.CTSettingConfig access$000(ChinaTelecomService r100) {
        return r100.mCTSettingConfig;
    }

    public ChinaTelecomService(IServiceContainer r100, OnekeyLoginConfig.CTSettingConfig r101) {
        super(r100);
        this.mCTSettingConfig = r101;
        if (r101.isShowLog() == false) goto L5;
        CtAuth.getInstance().init(getContext(), r101.mCTAppKey, r101.mCTAppSecret, new a(this));
        return;
    L5:
        CtAuth.getInstance().init(getContext(), r101.mCTAppKey, r101.mCTAppSecret, null);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(String r110, int r111, boolean r112, AuthorizeCallback r113) {
        if (isEnable() == true) goto L6;
        postCarrierDisableError(OnekeyLoginConstants.TELECOM, null, null, r111, OnekeyDataHelper.GET_TOKEN_EVENT, 2, r113);
        return;
    L6:
        getCtInfo(OnekeyDataHelper.GET_TOKEN_EVENT, r110, null, r111, r112, r113);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(String r110, int r111, boolean r112, AuthorizeCallback r113) {
        if (isEnable() == true) goto L6;
        postCarrierDisableError(OnekeyLoginConstants.TELECOM, null, null, r111, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, r113);
        return;
    L6:
        getCtInfo(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, r110, null, r111, r112, r113);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String r110, String r111, int r112, boolean r113, AuthorizeCallback r114) {
        if (isEnable() == true) goto L6;
        postCarrierDisableError(OnekeyLoginConstants.TELECOM, r110, r111, r112, OnekeyDataHelper.GET_PHONE_EVENT, 1, r114);
        return;
    L6:
        boolean r115 = NetworkTypeHelper.isMobileEnabled(r112);
        if (needDataMobile(true) == false) goto L11;
        if (r115 == true) goto L11;
        postDataMobileDisableError(OnekeyLoginConstants.TELECOM, r110, r111, r112, r114);
        return;
    L11:
        getCtInfo(OnekeyDataHelper.GET_PHONE_EVENT, r110, r111, r112, false, r114);
    }

    private void getCtInfo(String r210, String r211, String r310, int r311, boolean r312, AuthorizeCallback r313) {
        if (this.mCTSettingConfig != null) goto L13;
        if (r313 != null) goto L6;
    L10:
        onEvent(r210, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CT_EVENT_CARRIER, r211, r310, r311, r313));
        return;
    L6:
        if (r210.equals(OnekeyDataHelper.GET_PHONE_EVENT) == false) goto L8;
        OnekeyLoginErrorResponse r100 = OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.TELECOM, r311, 1, null);
    L9:
        r313.onError(r100);
        goto L10
    L8:
        r100 = OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.TELECOM, r311, 2, null);
        goto L9
    L13:
        if (r210.equals(OnekeyDataHelper.GET_PHONE_EVENT) == false) goto L17;
        onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, r211, r310, r311, r313));
    L20:
        int r101 = (int) getTimeout(r211);
        long r110 = System.currentTimeMillis();
        CtAuth.getInstance().requestPreLogin(new CtSetting(r101, r101, r101), new b(this, r110, r210, r312, r313, r211, r310, r311));     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        if (OnekeyDataHelper.GET_PHONE_EVENT.equals(r210) == false) goto L27;
        postLoginErrorResponse("-1", e.getMessage(), null, OnekeyLoginConstants.TELECOM_V2, r211, r310, r311, 1, System.currentTimeMillis() - r110, null, r313);
        return;
    L27:
        postLoginErrorResponse("-1", e.getMessage(), null, OnekeyLoginConstants.TELECOM_V2, r211, r310, r311, 2, System.currentTimeMillis() - r110, null, r313);
        return;
    L17:
        if (r210.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT) == false) goto L19;
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, r211, r310, r311, r313));
        goto L20
    L19:
        onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CT_EVENT_CARRIER, r211, r310, r311, r313));
        goto L20
    }
}
