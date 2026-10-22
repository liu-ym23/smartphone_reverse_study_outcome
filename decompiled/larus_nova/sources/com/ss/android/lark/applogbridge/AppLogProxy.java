package com.ss.android.lark.applogbridge;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sva.a;
import uva.b;
import uva.c;
import uva.d;
import uva.e;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\nH\u0007J\b\u0010\u0016\u001a\u00020\nH\u0007J\b\u0010\u0017\u001a\u00020\nH\u0007J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\"\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0014H\u0007J*\u0010\u001f\u001a\u00020\n2\u0018\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u0014H\u0007J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0007J4\u0010%\u001a\u00020\n2*\u0010&\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010'j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`(H\u0007J\u0012\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010+\u001a\u00020\u0005H\u0007J\u001a\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010.H\u0007J\u001a\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010/H\u0007J<\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u0002042\u0006\u00105\u001a\u0002042\b\u0010 \u001a\u0004\u0018\u00010.H\u0007J\u0018\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020.H\u0007J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0014H\u0007J\n\u0010;\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0014H\u0007J\u0010\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0014H\u0007J\b\u0010@\u001a\u00020\u0005H\u0007J\u0012\u0010A\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010CH\u0007J\u0012\u0010D\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010CH\u0007J\u0010\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0007J\u0010\u0010H\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0007J\b\u0010I\u001a\u00020\u0005H\u0007J\b\u0010J\u001a\u00020\u0005H\u0007J$\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00142\b\b\u0002\u0010N\u001a\u00020\u0014H\u0007J\u001d\u0010O\u001a\u00020\n2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010QH\u0007¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0014H\u0007J\n\u0010T\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010U\u001a\u00020\u0005H\u0007J\u0010\u0010V\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0014H\u0007J\u0018\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0007J\u001c\u0010Z\u001a\u00020\n2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!H\u0007J\u0010\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020^H\u0007J\u0012\u0010_\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010`H\u0007J\u0012\u0010a\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010`H\u0007J\u0012\u0010b\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010cH\u0007J\u0012\u0010d\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010cH\u0007J\u0010\u0010e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010g\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010h\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0014H\u0007J\u0010\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u0014H\u0007J\b\u0010k\u001a\u00020\u0014H\u0007J\n\u0010l\u001a\u0004\u0018\u00010mH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/ss/android/lark/applogbridge/AppLogProxy;", "", "<init>", "()V", "TAG", "", "sAppLogProxyImpl", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "getInstance", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/ss/android/lark/applogbridgeapi/model/AppLogInitConfig;", "methodGetUseNetConfig", "url", "requestHeaders", "", "hasNetConfig", "", "initDataObserver", "initSessionHook", "flush", "setUserUniqueId", "id", "setUidChangedListener", "runnable", "Ljava/lang/Runnable;", "addNetCommonParams", "isApi", "putCommonParams", "params", "", "setCustomNetParams", "key", "value", "setHeaderInfo", "custom", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setAbSdkVersion", "version", "getAid", "onEventV3", "event", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "onEvent", "category", "tag", "label", "", "extValue", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "setEventReportEnable", "enable", "getSessionId", "setAutoABConfig", "isAutoABConfig", "setAutoActiveState", "isAutoActive", "getDid", "addEventObserver", "observer", "Lcom/ss/android/lark/applogbridgeapi/listener/IAppLogEventObserver;", "removeEventObserver", "addEventListener", "listener", "Lcom/ss/android/lark/applogbridgeapi/listener/IEventListener;", "removeEventListener", "getIid", "getUserUniqueId", "setRegisterUriRuntime", "sdkDomain", "isNeedAutoUpgrade", "isNeedUnitUpgraded", "setSendLogUrlRuntime", "sendUris", "", "([Ljava/lang/String;)V", "setETVerifyEnable", "getSDKInnerDid", "getOaid", "silenceInBackground", "setAppLanguageAndRegion", "language", EffectConfiguration.KEY_REGION, "getSsidGroup", "map", "setResetAbVersionCallback", "resetAbVersionCallback", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy$IResetAbVersionCallback;", "addDeviceIdListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IDeviceIdListener;", "removeDeviceIdListener", "addConfigChangeListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IConfigChangeListener;", "removeConfigChangeListener", "onResume", "onPause", "isMigrate", "setEnableMigrateByFirstInstallTime", "setHttpUrlPrefix", "isHttp", "getEncryptAndCompress", "getEncryptor", "Lcom/ss/android/lark/applogbridgeapi/encryptor/IAppLogEncryptor;", "applog-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLogProxy {
    public static final AppLogProxy INSTANCE = null;
    private static final String TAG = "AppLogProxy";
    private static a sAppLogProxyImpl;

    private AppLogProxy() {
    }

    static {
        INSTANCE = new AppLogProxy();
        sAppLogProxyImpl = (a) ClaymoreServiceLoader.loadFirst(a.class);
    }

    @JvmStatic
    public static final void initDataObserver() {
        Log.i(TAG, "addDataObserver");
        getInstance().getDataObserver();
    }

    @JvmStatic
    public static final void flush() {
        getInstance().flush();
    }

    @JvmStatic
    public static final String getAid() {
        return getInstance().getAid();
    }

    @JvmStatic
    public static final String getDid() {
        return getInstance().getDid();
    }

    @JvmStatic
    public static final boolean getEncryptAndCompress() {
        return getInstance().getEncryptAndCompress();
    }

    @JvmStatic
    public static final tva.a getEncryptor() {
        getInstance().getEncryptor();
        return null;
    }

    @JvmStatic
    public static final String getIid() {
        return getInstance().getIid();
    }

    @JvmStatic
    public static final String getOaid() {
        JSONObject r100 = getInstance().getHeader();
        if (r100 == null) goto L7;
        JSONObject r101 = r100.optJSONObject("oaid");
        if (r101 == null) goto L7;
        String r102 = r101.optString("id");
    L9:
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        if (r102.length() != 0) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L18;
        return "";
    L18:
        return s.c(r102);
    L14:
        r103 = false;
    L7:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final String getSDKInnerDid() {
        JSONObject r100 = getInstance().getHeader();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.optString("device_id");
    }

    @JvmStatic
    public static final String getSessionId() {
        return getInstance().getSessionId();
    }

    @JvmStatic
    public static final String getUserUniqueId() {
        return getInstance().getUserUniqueID();
    }

    @JvmStatic
    public static final boolean hasNetConfig() {
        getInstance().getNetConfig();
        return false;
    }

    @JvmStatic
    public static final void initSessionHook() {
        getInstance().addSessionHook();
    }

    @JvmStatic
    public static final a getInstance() {
        return sAppLogProxyImpl;
    }

    @JvmStatic
    public static final void addConfigChangeListener(c r100) {
        getInstance().addConfigChangeListener(r100);
    }

    @JvmStatic
    public static final void addDeviceIdListener(d r100) {
        getInstance().addDeviceIdListener(r100);
    }

    @JvmStatic
    public static final void addEventListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getInstance().addEventListener(r100);
    }

    @JvmStatic
    public static final void addEventObserver(b r100) {
        if (r100 == null) goto L5;
        getInstance().addEventObserver(r100);
        return;
    }

    @JvmStatic
    public static final void getSsidGroup(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        getInstance().getSsidGroup(r100);
    }

    @JvmStatic
    public static final boolean isMigrate(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getInstance().isMigrate(r100);
    }

    @JvmStatic
    public static final void onPause(Context r100) {
        getInstance().onPause(r100);
    }

    @JvmStatic
    public static final void onResume(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        getInstance().onResume(r100);
    }

    @JvmStatic
    public static final boolean removeConfigChangeListener(c r100) {
        return getInstance().removeConfigChangeListener(r100).booleanValue();
    }

    @JvmStatic
    public static final boolean removeDeviceIdListener(d r100) {
        return getInstance().removeDeviceIdListener(r100).booleanValue();
    }

    @JvmStatic
    public static final void removeEventListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getInstance().removeEventListener(r100);
    }

    @JvmStatic
    public static final void removeEventObserver(b r100) {
        if (r100 == null) goto L5;
        getInstance().removeEventObserver(r100);
        return;
    }

    @JvmStatic
    public static final void setAbSdkVersion(String r100) {
        getInstance().setAbSdkVersion(r100);
    }

    @JvmStatic
    public static final void setAutoABConfig(boolean r100) {
        getInstance().setAutoABConfig(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void setAutoActiveState(boolean r100) {
        getInstance().setAutoActiveState(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void setETVerifyEnable(boolean r100) {
        getInstance().setETVerifyEnable(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void setEnableMigrateByFirstInstallTime(boolean r100) {
        getInstance().setEnableMigrateByFirstInstallTime(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void setEventReportEnable(boolean r100) {
        getInstance().setEventReportEnable(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void setHeaderInfo(HashMap<String, Object> r100) {
        getInstance().setHeaderInfo(r100);
    }

    @JvmStatic
    public static final void setHttpUrlPrefix(boolean r100) {
        getInstance().setHttpUrlPrefix(r100);
    }

    @JvmStatic
    public static final void setResetAbVersionCallback(a.InterfaceC7662a r100) {
        Intrinsics.checkNotNullParameter(r100, "resetAbVersionCallback");
        getInstance().setResetAbVersionCallback(r100);
    }

    @JvmStatic
    public static final void setSendLogUrlRuntime(String[] r100) {
        getInstance().setSendLogUrisRuntime(r100);
    }

    @JvmStatic
    public static final void setUidChangedListener(Runnable r100) {
        getInstance().setUidChangedListener(r100);
    }

    @JvmStatic
    public static final void setUserUniqueId(String r100) {
        getInstance().setUserUniqueID(r100);
    }

    @JvmStatic
    public static final void silenceInBackground(boolean r100) {
        getInstance().silenceInBackground(Boolean.valueOf(r100));
    }

    @JvmStatic
    public static final void init(Context r100, vva.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        getInstance().init(r100, r101);
    }

    @JvmStatic
    public static final String methodGetUseNetConfig(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return getInstance().methodGetUseNetConfig(r100, r101);
    }

    @JvmStatic
    public static final void onEventV3(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getInstance().onEventV3(r100, r101);
    }

    @JvmStatic
    public static final void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        getInstance().onMiscEvent(r100, r101);
    }

    @JvmStatic
    public static final void putCommonParams(Map<String, String> r100, boolean r101) {
        getInstance().putCommonParams(r100, r101);
    }

    @JvmStatic
    public static final void setAppLanguageAndRegion(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        getInstance().setAppLanguageAndRegion(r100, r101);
    }

    @JvmStatic
    public static final void setCustomNetParams(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        getInstance().setCustomNetParams(r100, r101);
    }

    @JvmStatic
    public static final void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getInstance().onEventV3(r100, r101);
    }

    @JvmStatic
    public static final String addNetCommonParams(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        return getInstance().addNetCommonParams(r100, r101, r102);
    }

    @JvmStatic
    public static final void setRegisterUriRuntime(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sdkDomain");
        getInstance().setRegisterUriRuntime(r100, r101, r102);
    }

    public static /* synthetic */ void setRegisterUriRuntime$default(String r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        setRegisterUriRuntime(r100, r101, r102);
    }

    @Deprecated(message = "This function is deprecated, use onEventV3 instead", replaceWith = @ReplaceWith(expression = "onEventV3", imports = {}))
    @JvmStatic
    public static final void onEvent(String r100, String r101, String r110, long r111, long r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "tag");
        getInstance().onEvent(r100, r101, r110, Long.valueOf(r111), Long.valueOf(r112), r113);
    }
}
