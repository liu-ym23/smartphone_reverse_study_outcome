package com.ss.android.lark.officesdk.applog.impl;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uva.c;
import uva.d;
import uva.e;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(sva.a.class)
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 w2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0017\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J0\u0010\u001d\u001a\u00020\u000b2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 \u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 \u0018\u0001`!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\u0012\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010+\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u000202H\u0016J(\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\r2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u000bH\u0016J\u0012\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J$\u0010;\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u00104\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0016H\u0016J&\u0010=\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001062\u0006\u0010<\u001a\u00020\u0016H\u0016J\u001c\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\r2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010A\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J0\u0010C\u001a\u00020\u000b2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`!H\u0016J\u0012\u0010D\u001a\u00020\u000b2\b\u0010E\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010F\u001a\u00020\rH\u0016J<\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\r2\u0006\u0010@\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020OH\u0016J\u0012\u0010Q\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010RH\u0016J\b\u0010T\u001a\u00020\rH\u0016J\"\u0010U\u001a\u00020\u000b2\b\u0010V\u001a\u0004\u0018\u00010\r2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u0016H\u0016J\u001f\u0010Y\u001a\u00020\u000b2\u0010\u0010Z\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010[H\u0016¢\u0006\u0002\u0010\\J\u0017\u0010]\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010^\u001a\u00020\u000b2\b\u0010_\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010`\u001a\u00020\u000b2\b\u0010a\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010b\u001a\u00020\u000b2\b\u0010c\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010d\u001a\u00020\u000b2\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u000106H\u0016J\u0012\u0010f\u001a\u00020\u000b2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010i\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010jH\u0016J\u0017\u0010k\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0002\u0010lJ\u0012\u0010m\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010nH\u0016J\u0017\u0010o\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010nH\u0016¢\u0006\u0002\u0010pJ\n\u0010q\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u0016H\u0016J\b\u0010t\u001a\u00020\u0016H\u0016J\n\u0010u\u001a\u0004\u0018\u00010vH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006x"}, d2 = {"Lcom/ss/android/lark/officesdk/applog/impl/OfficeSDKAppLogProxyImpl;", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "<init>", "()V", "officeSDKAppLog", "Lcom/ss/android/lark/officesdk/applog/api/IOfficeSDKAppLog;", "getOfficeSDKAppLog", "()Lcom/ss/android/lark/officesdk/applog/api/IOfficeSDKAppLog;", "officeSDKAppLog$delegate", "Lkotlin/Lazy;", "onEventV3", "", "event", "", "params", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "setEventReportEnable", "enable", "", "(Ljava/lang/Boolean;)V", "getSessionId", "getDid", "getUserUniqueID", "setUserUniqueID", "id", "setHeaderInfo", "custom", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeader", "setAppLanguageAndRegion", "language", EffectConfiguration.KEY_REGION, "flush", "onResume", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onPause", "init", "originConfig", "Lcom/ss/android/lark/applogbridgeapi/model/AppLogInitConfig;", "getNetConfig", "Lcom/ss/android/lark/applogbridgeapi/network/IAppLogNetworkClient;", "addDataObserver", "listener", "Lcom/ss/android/lark/applogbridgeapi/listener/IAppLogDataObserver;", "methodGetUseNetConfig", "url", "requestHeaders", "", "addSessionHook", "setUidChangedListener", "runnable", "Ljava/lang/Runnable;", "addNetCommonParams", "isApi", "putCommonParams", "setCustomNetParams", "key", "value", "isMigrate", "setEnableMigrateByFirstInstallTime", "setExtraParams", "setAbSdkVersion", "version", "getAid", "onEvent", "category", "tag", "label", "", "extValue", "addEventObserver", "observer", "Lcom/ss/android/lark/applogbridgeapi/listener/IAppLogEventObserver;", "removeEventObserver", "addEventListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IEventListener;", "removeEventListener", "getIid", "setRegisterUriRuntime", "registerUri", "isNeedAutoUpgrade", "isNeedUnitUpgraded", "setSendLogUrisRuntime", "sendUris", "", "([Ljava/lang/String;)V", "setETVerifyEnable", "setAutoActiveState", "isAutoActive", "setAutoABConfig", "isAutoABConfig", "silenceInBackground", "isSilenceInBackground", "getSsidGroup", "map", "setResetAbVersionCallback", "callback", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy$IResetAbVersionCallback;", "addDeviceIdListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IDeviceIdListener;", "removeDeviceIdListener", "(Lcom/ss/android/lark/applogbridgeapi/listener/IDeviceIdListener;)Ljava/lang/Boolean;", "addConfigChangeListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IConfigChangeListener;", "removeConfigChangeListener", "(Lcom/ss/android/lark/applogbridgeapi/listener/IConfigChangeListener;)Ljava/lang/Boolean;", "getDataObserver", "setHttpUrlPrefix", "isHttp", "getEncryptAndCompress", "getEncryptor", "Lcom/ss/android/lark/applogbridgeapi/encryptor/IAppLogEncryptor;", "Companion", "applog-officesdk-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKAppLogProxyImpl implements sva.a {
    public static final a Companion = null;
    private static final String TAG = "OfficeSDKAppLog";
    private final Lazy officeSDKAppLog$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // sva.a
    public void setHttpUrlPrefix(boolean r100) {
    }

    private final gtb.a getOfficeSDKAppLog() {
        return (gtb.a) this.officeSDKAppLog$delegate.getValue();
    }

    @Override // sva.a
    public void addSessionHook() {
        Log.w(TAG, "addSessionHook() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public String getAid() {
        Log.w(TAG, "getAid() is not supported in OfficeSDK");
        return "";
    }

    @Override // sva.a
    public uva.a getDataObserver() {
        Log.w(TAG, "getDataObserver() is not supported in OfficeSDK");
        return null;
    }

    @Override // sva.a
    public String getDid() {
        Log.w(TAG, "getDid() is not supported in OfficeSDK");
        return "";
    }

    @Override // sva.a
    public boolean getEncryptAndCompress() {
        Log.w(TAG, "getEncryptAndCompress() is not supported in OfficeSDK");
        return false;
    }

    @Override // sva.a
    public tva.a getEncryptor() {
        Log.w(TAG, "getEncryptor() is not supported in OfficeSDK");
        return null;
    }

    @Override // sva.a
    public JSONObject getHeader() {
        Log.w(TAG, "getHeader() is not supported in OfficeSDK");
        return null;
    }

    @Override // sva.a
    public String getIid() {
        Log.w(TAG, "getIid() is not supported in OfficeSDK");
        return "";
    }

    @Override // sva.a
    public wva.a getNetConfig() {
        Log.w(TAG, "getNetConfig() is not supported in OfficeSDK");
        return null;
    }

    @Override // sva.a
    public String getSessionId() {
        Log.w(TAG, "getSessionId() is not supported in OfficeSDK");
        return "";
    }

    @Override // sva.a
    public String getUserUniqueID() {
        Log.w(TAG, "getUserUniqueID() is not supported in OfficeSDK");
        return "";
    }

    public OfficeSDKAppLogProxyImpl() {
        this.officeSDKAppLog$delegate = LazyKt.lazy(OfficeSDKAppLogProxyImpl$officeSDKAppLog$2.INSTANCE);
    }

    @Override // sva.a
    public void flush() {
        gtb.a r100 = getOfficeSDKAppLog();
        if (r100 == null) goto L6;
        r100.flush();
        return;
    }

    @Override // sva.a
    public void addConfigChangeListener(c r100) {
        Log.w(TAG, "addConfigChangeListener() is not supported in OfficeSDK");
    }

    public void addDataObserver(uva.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Log.w(TAG, "addDataObserver() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void addDeviceIdListener(d r100) {
        Log.w(TAG, "addDeviceIdListener() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void addEventListener(e r100) {
        Log.w(TAG, "addEventListener() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void addEventObserver(uva.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Log.w(TAG, "addEventObserver() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void getSsidGroup(Map<String, String> r100) {
        Log.w(TAG, "getSsidGroup() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public boolean isMigrate(Context r100) {
        Log.w(TAG, "isMigrate() is not supported in OfficeSDK");
        return false;
    }

    @Override // sva.a
    public void onPause(Context r100) {
        Log.w(TAG, "onPause() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void onResume(Context r100) {
        Log.w(TAG, "onResume() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public Boolean removeConfigChangeListener(c r100) {
        Log.w(TAG, "removeConfigChangeListener() is not supported in OfficeSDK");
        return Boolean.FALSE;
    }

    @Override // sva.a
    public Boolean removeDeviceIdListener(d r100) {
        Log.w(TAG, "removeDeviceIdListener() is not supported in OfficeSDK");
        return Boolean.FALSE;
    }

    @Override // sva.a
    public void removeEventListener(e r100) {
        Log.w(TAG, "removeEventListener() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void removeEventObserver(uva.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Log.w(TAG, "removeEventObserver() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setAbSdkVersion(String r100) {
        Log.w(TAG, "setAbSdkVersion() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setAutoABConfig(Boolean r100) {
        Log.w(TAG, "setAutoABConfig() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setAutoActiveState(Boolean r100) {
        Log.w(TAG, "setAutoActiveState() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setETVerifyEnable(Boolean r100) {
        Log.w(TAG, "setETVerifyEnable() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public /* bridge */ /* synthetic */ void setEnableMigrateByFirstInstallTime(Boolean r100) {
        setEnableMigrateByFirstInstallTime(r100.booleanValue());
    }

    @Override // sva.a
    public void setEventReportEnable(Boolean r100) {
        Log.w(TAG, "setEventReportEnable() is not supported in OfficeSDK");
    }

    public void setExtraParams(HashMap<String, String> r100) {
        Log.w(TAG, "setExtraParams() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setHeaderInfo(HashMap<String, Object> r100) {
        Log.w(TAG, "setHeaderInfo() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setResetAbVersionCallback(sva.a.InterfaceC7662a r100) {
        Log.w(TAG, "setResetAbVersionCallback() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setSendLogUrisRuntime(String[] r100) {
        Log.w(TAG, "setSendLogUrisRuntime() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setUidChangedListener(Runnable r100) {
        Log.w(TAG, "setUidChangedListener() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setUserUniqueID(String r100) {
        Log.w(TAG, "setUserUniqueID() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void silenceInBackground(Boolean r100) {
        Log.w(TAG, "silenceInBackground() is not supported in OfficeSDK");
    }

    public void setEnableMigrateByFirstInstallTime(boolean r100) {
        Log.w(TAG, "setEnableMigrateByFirstInstallTime() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void init(Context r100, vva.a r101) {
        Log.w(TAG, "init() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public String methodGetUseNetConfig(String r100, Map<String, String> r101) {
        Log.w(TAG, "methodGetUseNetConfig() is not supported in OfficeSDK");
        return "";
    }

    @Override // sva.a
    public void onEventV3(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gtb.a r102 = getOfficeSDKAppLog();
        if (r102 == null) goto L6;
        r102.onEventV3(r100, r101);
        return;
    }

    @Override // sva.a
    public void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        gtb.a r102 = getOfficeSDKAppLog();
        if (r102 == null) goto L6;
        r102.onMiscEvent(r100, r101);
        return;
    }

    @Override // sva.a
    public void putCommonParams(Map<String, String> r100, boolean r101) {
        Log.w(TAG, "putCommonParams() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setAppLanguageAndRegion(String r100, String r101) {
        Log.w(TAG, "setAppLanguageAndRegion() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void setCustomNetParams(String r100, String r101) {
        Log.w(TAG, "setCustomNetParams() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gtb.a r102 = getOfficeSDKAppLog();
        if (r102 == null) goto L6;
        r102.onEventV3(r100, r101);
        return;
    }

    @Override // sva.a
    public String addNetCommonParams(Context r100, String r101, boolean r102) {
        Log.w(TAG, "addNetCommonParams() is not supported in OfficeSDK");
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // sva.a
    public void setRegisterUriRuntime(String r100, boolean r101, boolean r102) {
        Log.w(TAG, "setRegisterUriRuntime() is not supported in OfficeSDK");
    }

    public void onEvent(String r100, String r101, String r102, long r103, long r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Log.w(TAG, "onEvent() is not supported in OfficeSDK");
    }

    @Override // sva.a
    public /* bridge */ /* synthetic */ void onEvent(String r110, String r111, String r112, Long r113, Long r114, JSONObject r115) {
        onEvent(r110, r111, r112, r113.longValue(), r114.longValue(), r115);
    }
}
