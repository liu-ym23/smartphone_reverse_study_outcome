package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.CarrierCacheInfoHelper;
import com.bytedance.sdk.account.platform.onekey.NetworkTypeHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import com.unicom.online.account.shield.ResultListener;
import com.unicom.online.account.shield.UniAccountHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ChinaUnionService extends AbsCarrier {
    private static final String TAG = "ChinaUnionService";
    private final OnekeyLoginConfig.CUSettingConfig mCUSettingConfig;
    private boolean mIsCuReqTimeout;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements ResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f269304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f269305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f269306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f269307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AuthorizeCallback f269308e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f269309f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f269310g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ChinaUnionService f269311h;

        @Override // com.unicom.online.account.shield.ResultListener
        public final void onResult(String r210) {
            tb7.a.d(ChinaUnionService.TAG, "getCuPhoneAndAccessCode(), onResult(), scene=" + this.f269304a + ", event=" + this.f269305b + ", mIsCuReqTimeout=" + ChinaUnionService.access$400(this.f269311h));
            if (ChinaUnionService.access$400(this.f269311h) == false) goto L5;
            return;
        L5:
            this.f269311h.clearTimer();
            long r211 = System.currentTimeMillis() - this.f269306c;
            boolean r100 = TextUtils.isEmpty(r210);
            String r110 = OnekeyDataHelper.GET_PHONE_EVENT;
            String r101 = "";
            JSONObject r102 = null;
            if (r100 == false) goto L67;
            r110 = OnekeyDataHelper.GET_PHONE_EVENT;
            String r111 = "";
            String r112 = r111;
            String r113 = r112;
            JSONObject r212 = null;
        L54:
            if (r110.equals(this.f269305b) == false) goto L56;
            this.f269311h.postLoginErrorResponse(r111, r112, r113, OnekeyLoginConstants.UNICOM, this.f269304a, this.f269309f, this.f269310g, 1, r211, r212, this.f269308e);
            return;
        L56:
            this.f269311h.postLoginErrorResponse(r111, r112, r113, OnekeyLoginConstants.UNICOM, this.f269304a, this.f269309f, this.f269310g, 2, r211, r212, this.f269308e);
            return;
        L67:
            r102 = new JSONObject(r210);     // Catch: Exception -> L48
            String r213 = r102.optString("resultCode");     // Catch: Exception -> L46
            String r214 = r102.optString("resultMsg");     // Catch: Exception -> L42
            String r215 = r102.optString(OnekeyLoginConstants.CU_KEY_SEQ);     // Catch: Exception -> L40
            JSONObject r103 = r102.optJSONObject(OnekeyLoginConstants.CU_KEY_RESULT_DATA);     // Catch: Exception -> L38
            if (r103 != null) goto L14;
        L37:
            r110 = OnekeyDataHelper.GET_PHONE_EVENT;
            r212 = r102;
            r111 = r213;
        L51:
            r112 = r214;
            r113 = r215;
            goto L54
        L14:
            if (r103.has(OnekeyLoginConstants.CU_KEY_FAKE_MOBILE) == false) goto L37;
            String r104 = r103.optString(OnekeyLoginConstants.CU_KEY_FAKE_MOBILE);     // Catch: Exception -> L38
            String r105 = r103.optString("accessCode");     // Catch: Exception -> L38
            long r106 = r103.optLong(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES);     // Catch: Exception -> L38
            UnionCarrierCacheInfo r114 = this.f269311h.getCacheInfoNotNull();     // Catch: Exception -> L38
            r114.updateMaskPhoneResult(r104, r210);     // Catch: Exception -> L38
            if (this.f269305b.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT) == true) goto L60;
            r114.updateAuthTokenResult(r105, r210, this.f269311h.getTokenExpireIn(), r106);     // Catch: Exception -> L38
        L22:
            CarrierCacheInfoHelper.INSTANCE.saveCarrierCacheInfo(r114);     // Catch: Exception -> L38
            if (this.f269305b.equals(OnekeyDataHelper.GET_PHONE_EVENT) == false) goto L27;
            Bundle r107 = r114.parseToPhoneInfoResponse();     // Catch: Exception -> L19
        L31:
            this.f269311h.sendOneKeySuccessMessage(new OnekeyResponseCallable(this.f269308e, r107, this.f269304a));     // Catch: Exception -> L38
            ChinaUnionService r108 = this.f269311h;     // Catch: Exception -> L38
            r108.onEvent(this.f269305b, OnekeyDataHelper.generateMonitorJson(r108.getContext(), true, null, null, r211, null, OnekeyDataHelper.CU_EVENT_CARRIER, this.f269304a, this.f269309f, this.f269310g, this.f269308e));     // Catch: Exception -> L35
            return;
        L35:
            e = e;
        L45:
            r101 = r213;
        L50:
            e.printStackTrace();
            r111 = r101;
            r212 = r102;
            goto L51
        L27:
            if (this.f269305b.equals(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT) == false) goto L30;
            r107 = r114.parseToValidateTokenResponse(this.f269307d);     // Catch: Exception -> L19
            goto L31
        L30:
            r107 = r114.parseToAuthTokenResponse(this.f269307d);     // Catch: Exception -> L38
            goto L31
        L60:
            r114.updateValidateTokenResult(r105, r210, this.f269311h.getTokenExpireIn(), r106);     // Catch: Exception -> L19
        L19:
            e = e;
            r110 = OnekeyDataHelper.GET_PHONE_EVENT;
        L38:
            e = e;
        L40:
            e = e;
            r215 = "";
        L42:
            e = e;
            r214 = "";
            r215 = r214;
        L46:
            e = e;
            r110 = OnekeyDataHelper.GET_PHONE_EVENT;
            r214 = "";
            r215 = r214;
            r102 = r102;
        L48:
            e = e;
            r110 = OnekeyDataHelper.GET_PHONE_EVENT;
            r214 = "";
            r215 = r214;
            goto L50
        }

        public a(ChinaUnionService r100, String r101, String r102, long r103, boolean r104, AuthorizeCallback r105, String r106, int r107) {
            this.f269311h = r100;
            this.f269304a = r101;
            this.f269305b = r102;
            this.f269306c = r103;
            this.f269307d = r104;
            this.f269308e = r105;
            this.f269309f = r106;
            this.f269310g = r107;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OnekeyLoginErrorResponse f269312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f269313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f269314c;

        public b() {
        }
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String getCarrierName() {
        return OnekeyLoginConstants.UNICOM;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public String settingKey() {
        return OnekeySettingManager.KEY_CU_CONFIG;
    }

    public long getTokenExpireIn() {
        IServiceContainer r100 = this.mContainer;
        if (r100 != null) goto L5;
        return 3600000;
    L5:
        return r100.getSetting().getTokenExpireIn(settingKey());
    }

    public UnionCarrierCacheInfo getCacheInfoNotNull() {
        int r100 = NetworkTypeHelper.getDefaultDataSubscriptionId(getContext());
        AbsCarrierCacheInfo r101 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(r100);
        if ((r101 instanceof UnionCarrierCacheInfo) == false) goto L7;
        return (UnionCarrierCacheInfo) r101;
    L7:
        return new UnionCarrierCacheInfo(r100);
    }

    public static /* synthetic */ boolean access$400(ChinaUnionService r100) {
        return r100.mIsCuReqTimeout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrier
    public void notifyTimeout(OnekeyResponseCallable<?> r210) {
        this.mIsCuReqTimeout = true;
        if (r210 == null) goto L9;
        StringBuilder r100 = new StringBuilder("notifyTimeout(), scene: ");
        r100.append(r210.scene);
        r100.append(", callback is null: ");
        if (r210.mCallback != null) goto L7;
        boolean r101 = true;
    L8:
        r100.append(r101);
        tb7.a.d(TAG, r100.toString());
        goto L9
    L7:
        r101 = false;
    L9:
        if (r210 == null) goto L27;
        AuthorizeCallback r102 = r210.mCallback;
        if (r102 == null) goto L28;
        T r103 = r210.response;
        if ((r103 instanceof b) == false) goto L16;
        OnekeyLoginErrorResponse r104 = ((b) r103).f269312a;
        String r105 = ((b) r103).f269313b;
        String r110 = ((b) r103).f269314c;
        String r111 = r105;
    L20:
        if (r104 == null) goto L29;
        r102.onError(r104);
        if (r104.errorType != 1) goto L24;
        String r106 = OnekeyDataHelper.GET_PHONE_EVENT;
    L25:
        onEvent(r106, OnekeyDataHelper.generateMonitorJson(getContext(), false, r104.platformErrorCode, r104.platformErrorMsg, getTimeout(r111), null, OnekeyDataHelper.CU_EVENT_CARRIER, r111, r110, r104.netStatus, r210.mCallback));
        return;
    L24:
        r106 = OnekeyDataHelper.GET_TOKEN_EVENT;
        goto L25
    L29:
        return;
    L16:
        if ((r103 instanceof OnekeyLoginErrorResponse) == false) goto L18;
        r104 = (OnekeyLoginErrorResponse) r103;
        r111 = null;
    L19:
        r110 = r111;
        goto L20
    L18:
        r104 = null;
        r111 = null;
        goto L19
    L28:
        return;
    }

    public ChinaUnionService(IServiceContainer r100, OnekeyLoginConfig.CUSettingConfig r101) {
        super(r100);
        this.mCUSettingConfig = r101;
        UniAccountHelper.getInstance().init(getContext(), r101.mCUAppId);
        UniAccountHelper.getInstance().setUseCacheFlag(false);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getAuthToken(String r210, int r211, boolean r212, AuthorizeCallback r213) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (isEnable() == true) goto L7;
        postCarrierDisableError(OnekeyLoginConstants.UNICOM, r210, null, r211, OnekeyDataHelper.GET_TOKEN_EVENT, 2, r213);
        return;
    L7:
        if (this.isCancel == false) goto L10;
        return;
    L10:
        if (this.mCUSettingConfig != null) goto L15;
        if (r213 == null) goto L13;
        r213.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, r211, 2, null));
    L13:
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CU_EVENT_CARRIER, r210, null, r211, r213));
        return;
    L15:
        long r100 = getTimeout(r210);
        startTimer(r100, new OnekeyResponseCallable(r213, OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, r211, 3, null), r210));
        onEvent(OnekeyDataHelper.GET_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, r210, null, r211, r213));
        getCuPhoneAndAccessCode(OnekeyDataHelper.GET_TOKEN_EVENT, (int) r100, r210, null, r211, r212, r213);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getValidateToken(String r210, int r211, boolean r212, AuthorizeCallback r213) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (isEnable() == true) goto L7;
        postCarrierDisableError(OnekeyLoginConstants.UNICOM, r210, null, r211, OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, 2, r213);
        return;
    L7:
        if (this.isCancel == false) goto L10;
        return;
    L10:
        if (this.mCUSettingConfig != null) goto L15;
        if (r213 == null) goto L13;
        r213.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, r211, 2, null));
    L13:
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CU_EVENT_CARRIER, r210, null, r211, r213));
        return;
    L15:
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, r210, null, r211, r213));
        long r100 = getTimeout(r210);
        startTimer(r100, new OnekeyResponseCallable(r213, OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, r211, 3, null), r210));
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, r210, null, r211, r213));
        getCuPhoneAndAccessCode(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, (int) r100, r210, null, r211, r212, r213);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void getPhoneInfo(String r210, String r211, int r212, boolean r213, AuthorizeCallback r214) {
        this.mIsCuReqTimeout = false;
        this.isCancel = false;
        if (this.mCUSettingConfig != null) goto L9;
        if (r214 == null) goto L6;
        r214.onError(OnekeyDataHelper.getErrorResponse("-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, OnekeyLoginConstants.UNICOM, r212, 1, null));
    L6:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, "-3", OnekeyLoginConstants.ErrorMsg.ERROR_SDK_INIT_MSG, 0, null, OnekeyDataHelper.CU_EVENT_CARRIER, r210, r211, r212, r214));
        return;
    L9:
        if (isEnable() == true) goto L12;
        postCarrierDisableError(OnekeyLoginConstants.UNICOM, r210, r211, r212, OnekeyDataHelper.GET_PHONE_EVENT, 1, r214);
        return;
    L12:
        boolean r100 = NetworkTypeHelper.isMobileEnabled(r212);
        if (needDataMobile(true) == false) goto L17;
        if (r100 == true) goto L17;
        postDataMobileDisableError(OnekeyLoginConstants.UNICOM, r210, r211, r212, r214);
        return;
    L17:
        long r101 = getTimeout(r210);
        b r102 = new b();
        r102.f269313b = r210;
        r102.f269314c = r211;
        r102.f269312a = OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT, OnekeyLoginConstants.ErrorMsg.ERROR_CU_REQUEST_TIMEOUT_MSG, OnekeyLoginConstants.UNICOM, r212, 3, null);
        startTimer(r101, new OnekeyResponseCallable(r214, r102, r210));
        onEvent(OnekeyDataHelper.GET_PHONE_SEND_EVENT, OnekeyDataHelper.getMonitorJson(getContext(), OnekeyDataHelper.CU_EVENT_CARRIER, r210, r211, r212, r214));
        getCuPhoneAndAccessCode(OnekeyDataHelper.GET_PHONE_EVENT, (int) r101, r210, r211, r212, false, r214);
    }

    private void getCuPhoneAndAccessCode(String r110, int r111, String r112, String r210, int r211, boolean r212, AuthorizeCallback r213) {
        tb7.a.d(TAG, "getCuPhoneAndAccessCode(), start, scene=" + r112 + ", event=" + r110 + ", timeout=" + r111 + ", cleanCache=" + r212);
        long r113 = System.currentTimeMillis();
        UniAccountHelper.getInstance().cuGetToken(r111, new a(this, r112, r110, r113, r212, r213, r210, r211));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (OnekeyDataHelper.GET_PHONE_EVENT.equals(r110) == false) goto L9;
        postLoginErrorResponse("-1", e.getMessage(), null, OnekeyLoginConstants.UNICOM, r112, r210, r211, 1, System.currentTimeMillis() - r113, null, r213);
        return;
    L9:
        postLoginErrorResponse("-1", e.getMessage(), null, OnekeyLoginConstants.UNICOM, r112, r210, r211, 2, System.currentTimeMillis() - r113, null, r213);
    }
}
