package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaMobileService;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaTelecomService;
import com.bytedance.sdk.account.platform.onekey.carrier.ChinaUnionService;
import com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService;
import com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer;
import com.bytedance.sdk.account.platform.onekey.carrier.UnSupportCarrier;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class OnekeyLoginServiceImpl implements IOnekeyLoginService, IServiceContainer {
    private final Map<String, ICarrierService> carrierServices;
    private ICarrierService currentCarrier;
    private final Context mApplicationContext;
    private final OnekeyLoginConfig mConfig;
    private final Handler mHandler;
    private final IOnekeyMonitor mMonitor;
    private final UnSupportCarrier unSupportCarrier;

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void cancel() {
        ICarrierService r100 = this.currentCarrier;
        this.currentCarrier = null;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public String getCacheMaskPhone() {
        AbsCarrierCacheInfo r100 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getMaskPhone();
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public String getCarrier() {
        String r100 = NetworkTypeHelper.getCarrierType(this.mApplicationContext);
        onEvent(OnekeyDataHelper.GET_CARRIER_EVENT, OnekeyDataHelper.generateGetCarrierEvent(this.mApplicationContext, r100));
        return r100;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public int getNetworkStatus() {
        int r100 = NetworkTypeHelper.getNetworkStatus(this.mApplicationContext);
        onEvent(OnekeyDataHelper.GET_NETWORK_STATUS_EVENT, OnekeyDataHelper.generateGetNetStatusEvent(this.mApplicationContext, r100));
        return r100;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public boolean isTokenCacheValid() {
        AbsCarrierCacheInfo r100 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isTokenValid();
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public boolean isValidateTokenCacheValid() {
        AbsCarrierCacheInfo r100 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isValidateTokenValid();
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public OnekeySettingManager getSetting() {
        return OnekeySettingManager.instance();
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public OnekeyLoginConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public Handler getHandler() {
        return this.mHandler;
    }

    private ICarrierService getCarrierService(String r100) {
        ICarrierService r101 = this.carrierServices.get(r100);
        if (r101 != null) goto L5;
        this.unSupportCarrier.setCarrierType(r100);
        r101 = this.unSupportCarrier;
    L5:
        this.currentCarrier = r101;
        return r101;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getAuthToken(AuthorizeCallback r100) {
        getAuthToken(null, false, true, r100);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(AuthorizeCallback r100) {
        getPhoneInfo(null, r100);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getValidateToken(AuthorizeCallback r100) {
        getValidateToken(null, false, true, r100);
    }

    public OnekeyLoginServiceImpl(Context r100, OnekeyLoginConfig r101) {
        HashMap r102 = new HashMap();
        this.carrierServices = r102;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mApplicationContext = r100.getApplicationContext();
        this.mConfig = r101;
        IOnekeyMonitor r103 = r101.getMonitor();
        this.mMonitor = r103;
        this.unSupportCarrier = new UnSupportCarrier(this);
        r102.put("mobile", new ChinaMobileService(this, r101.getCMSettingConfig()));
        r102.put(OnekeyLoginConstants.TELECOM, new ChinaTelecomService(this, r101.getCTSettingConfig()));
        r102.put(OnekeyLoginConstants.UNICOM, new ChinaUnionService(this, r101.getCUSettingConfig()));
        NetworkTypeHelper.setMonitor(r103);
        NetworkTypeHelper.registerReceiver(r100);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(String r100, AuthorizeCallback r101) {
        getPhoneInfo(r100, false, r101);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer
    public void onEvent(String r100, JSONObject r101) {
        IOnekeyMonitor r102 = this.mMonitor;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getPhoneInfo(String r110, boolean r111, AuthorizeCallback r112) {
        NetworkTypeHelper.NetworkType r100 = NetworkTypeHelper.getNetworkType(getApplicationContext());
        boolean r101 = getSetting().requestAbove4GEnable();
        String r113 = NetworkTypeHelper.getNetworkAccessType(r100);
        String r102 = getCarrier();
        int r114 = getNetworkStatus();
        if (r101 == true) goto L5;
    L10:
        if (r111 == true) goto L19;
        AbsCarrierCacheInfo r103 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r103 == null) goto L19;
        Bundle r104 = r103.parseToPhoneInfoResponse();
        if (r104 == null) goto L19;
        if (r112 == null) goto L17;
        r112.onSuccess(r104);
    L17:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0, null, OnekeyDataHelper.getCarrierEvent(r103.getCarrierFrom()), r110, r113, r114, r112));
        return;
    L19:
        getCarrierService(r102).getPhoneInfo(r110, r113, r114, r111, r112);
        return;
    L5:
        if (r100.getValue() >= NetworkTypeHelper.NetworkType.WIFI.getValue()) goto L10;
        if (r112 == null) goto L9;
        r112.onError(OnekeyDataHelper.getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_WEAK_NETWORK, OnekeyLoginConstants.ErrorMsg.ERROR_WEAK_NETWORK_MSG, r102, r114, 1, null));
    L9:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_WEAK_NETWORK, OnekeyLoginConstants.ErrorMsg.ERROR_WEAK_NETWORK_MSG, 0, null, OnekeyDataHelper.getCarrierEvent(r102), r110, r113, r114, r112));
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getAuthToken(String r110, boolean r111, boolean r112, AuthorizeCallback r113) {
        String r114 = NetworkTypeHelper.getNetworkAccessType(NetworkTypeHelper.getNetworkType(getApplicationContext()));
        String r100 = getCarrier();
        int r115 = getNetworkStatus();
        if (r111 == true) goto L12;
        AbsCarrierCacheInfo r101 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r101 == null) goto L12;
        Bundle r102 = r101.parseToAuthTokenResponse(r112);
        if (r102 == null) goto L12;
        if (r113 == null) goto L10;
        r113.onSuccess(r102);
    L10:
        onEvent(OnekeyDataHelper.GET_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0, null, OnekeyDataHelper.getCarrierEvent(r100), r110, r114, r115, r113));
        return;
    L12:
        getCarrierService(r100).getAuthToken(r110, r115, r112, r113);
    }

    @Override // com.bytedance.sdk.account.platform.api.IOnekeyLoginService
    public void getValidateToken(String r110, boolean r111, boolean r112, AuthorizeCallback r113) {
        String r114 = NetworkTypeHelper.getNetworkAccessType(NetworkTypeHelper.getNetworkType(getApplicationContext()));
        String r100 = getCarrier();
        int r115 = getNetworkStatus();
        if (r111 == true) goto L12;
        AbsCarrierCacheInfo r101 = CarrierCacheInfoHelper.INSTANCE.getCarrierCacheInfo(getApplicationContext());
        if (r101 == null) goto L12;
        Bundle r102 = r101.parseToValidateTokenResponse(r112);
        if (r102 == null) goto L12;
        if (r113 == null) goto L10;
        r113.onSuccess(r102);
    L10:
        onEvent(OnekeyDataHelper.GET_VALIDATE_TOKEN_EVENT, OnekeyDataHelper.generateMonitorJson(getApplicationContext(), true, null, null, 0, null, OnekeyDataHelper.getCarrierEvent(r100), r110, r114, r115, r113));
        return;
    L12:
        getCarrierService(r100).getValidateToken(r110, r115, r112, r113);
    }
}
