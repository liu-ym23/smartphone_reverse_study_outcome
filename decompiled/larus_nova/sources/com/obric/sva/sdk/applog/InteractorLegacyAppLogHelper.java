package com.obric.sva.sdk.applog;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.apm.api.IExtraParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.common.spi.ObricContextServiceDelegate;
import com.obric.sva.sdk.logger.SLogger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.common.applog.g0;
import com.ss.android.common.applog.i0;
import com.ss.android.common.applog.j0;
import com.ss.android.common.applog.m0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jta.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v48.d;
import v48.e;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fJ\u001a\u0010!\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0#J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020'J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001bJ>\u00106\u001a\u00020\u001f26\u00107\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001f08J\u0006\u0010=\u001a\u00020\u001fJ\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0019J\u001e\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00052\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014J\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001J\u000e\u0010G\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0005J\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020)H\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0005H\u0002J \u0010P\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J!\u0010Q\u001a\u00020\u00052\u0012\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050S\"\u00020\u0005H\u0002¢\u0006\u0002\u0010TJ$\u0010U\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J \u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020'2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001H\u0002J \u0010X\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020)2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001H\u0002J\u0018\u0010Y\u001a\u00020)2\u000e\u0010W\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030ZH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/obric/sva/sdk/applog/InteractorLegacyAppLogHelper;", "", "<init>", "()V", "TAG", "", "INTERACTOR_DB_NAME", "INTERACTOR_SP_NAME", "INTERACTOR_ENCRYPT_SP_NAME", "ID_FAST_POLLING_ATTEMPTS", "", "ID_FAST_POLLING_INTERVAL_MS", "", "ID_SLOW_POLLING_INTERVAL_MS", "mConfigInfo", "Lcom/larus/applog/api/AppLogConfigInfo;", "initialized", "", "eventCommonParamsGenerators", "", "Lkotlin/Function0;", "eventCommonParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "commonParamInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/applog/api/IEventInterceptor;", "didListenerCallbackList", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "idNotifyScheduled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "configInfo", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "getDeviceId", "getInstallId", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "addGetAppLogIdListener", "listener", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.bytedance.android.ec.core.event.a.KEY_DID, WsConstants.KEY_INSTALL_ID, "openETVerify", "closeETVerify", "addCommonParamInterceptor", "eventInterceptor", "removeCommonParamInterceptor", "addEventCommonParams", "key", "valueGenerator", "putEventCommonParams", "value", "removeEventCommonParams", "updateHeaderInfo", "getHeaderInfo", "buildUrlConfig", "Lcom/ss/android/common/applog/UrlConfig;", "boe", "notifyIdsReadyIfNeeded", "from", "scheduleIdsReadyCheck", "notifyDidListeners", "getStringFromAppLog", "methodNames", "", "([Ljava/lang/String;)Ljava/lang/String;", "updateBdTuringId", "addToJSONObject", "params", "addToBundle", "toBundle", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractorLegacyAppLogHelper {
    private static final int ID_FAST_POLLING_ATTEMPTS = 10;
    private static final long ID_FAST_POLLING_INTERVAL_MS = 500;
    private static final long ID_SLOW_POLLING_INTERVAL_MS = 2000;
    public static final InteractorLegacyAppLogHelper INSTANCE = null;
    private static final String INTERACTOR_DB_NAME = "obric_interactor_legacy_applog.db";
    private static final String INTERACTOR_ENCRYPT_SP_NAME = "obric_interactor_legacy_applog_encrypt";
    private static final String INTERACTOR_SP_NAME = "obric_interactor_legacy_applog_stats";
    private static final String TAG = "InteractorLegacyAppLogHelper";
    private static final CopyOnWriteArrayList<d> commonParamInterceptors = null;
    private static final CopyOnWriteArrayList<e> didListenerCallbackList = null;
    private static final Map<String, Function0<Object>> eventCommonParamsGenerators = null;
    private static final ConcurrentHashMap<String, Object> eventCommonParamsMap = null;
    private static final AtomicBoolean idNotifyScheduled = null;
    private static volatile boolean initialized;
    private static v48.a mConfigInfo;

    private InteractorLegacyAppLogHelper() {
    }

    public static /* synthetic */ Pair a(Pair r100) {
        return setBDAccountCallback$lambda$0(r100);
    }

    public static /* synthetic */ void b() {
        updateHeaderInfo$lambda$9();
    }

    public static /* synthetic */ void c(String r100) {
        scheduleIdsReadyCheck$lambda$12(r100);
    }

    private static final Pair setBDAccountCallback$lambda$0(Pair r100) {
        return r100;
    }

    static {
        INSTANCE = new InteractorLegacyAppLogHelper();
        eventCommonParamsGenerators = new ConcurrentHashMap();
        eventCommonParamsMap = new ConcurrentHashMap();
        commonParamInterceptors = new CopyOnWriteArrayList();
        didListenerCallbackList = new CopyOnWriteArrayList();
        idNotifyScheduled = new AtomicBoolean(false);
    }

    private final Bundle getHeaderInfo() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        AppLocaleUtils.f375332a.getClass();
        Locale r100 = AppLocaleUtils.c();
    L6:
        Bundle r101 = new Bundle();
        InteractorLegacyAppLogHelper r102 = INSTANCE;
        r101.putAll(r102.toBundle(IExtraParams.f286942a.c()));
        String r103 = b0.f375362a;
        Intrinsics.checkNotNull(r100);
        r101.putString("system_language_detail", b0.f(r100));
        r101.putString(EffectConfiguration.KEY_APP_LANGUAGE, b0.c(r100));
        Map<String, String> r104 = ObricConfigServiceDelegate.f387835b.getCommonParams();
        if (r104 == null) goto L9;
        r101.putAll(r102.toBundle(r104));
    L9:
        SLogger.INSTANCE.i(TAG, "getHeaderInfo headerInfo = " + r101);
        return r101;
    L5:
        r100 = Locale.CHINA;
        goto L6
    }

    private final void updateHeaderInfo() {
        ThreadPlus.submitRunnable(new c());
    }

    private static final void updateHeaderInfo$lambda$9() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        AppLocaleUtils.f375332a.getClass();
        Locale r100 = AppLocaleUtils.c();
    L6:
        Bundle r101 = new Bundle();
        InteractorLegacyAppLogHelper r102 = INSTANCE;
        r101.putAll(r102.toBundle(IExtraParams.f286942a.c()));
        String r103 = b0.f375362a;
        Intrinsics.checkNotNull(r100);
        r101.putString("system_language_detail", b0.f(r100));
        r101.putString(EffectConfiguration.KEY_APP_LANGUAGE, b0.c(r100));
        Map<String, String> r104 = ObricConfigServiceDelegate.f387835b.getCommonParams();
        if (r104 == null) goto L9;
        r101.putAll(r102.toBundle(r104));
    L9:
        SLogger.INSTANCE.i(TAG, "interactor set legacy AppLog headerInfo = " + r101);
        AppLog.f408004g0.d(r101);
        return;
    L5:
        r100 = Locale.CHINA;
        goto L6
    }

    public final void closeETVerify() {
        if (mConfigInfo != null) goto L5;
        return;
    L5:
        EventVerify.inst().setEnable(false, AppHost.f326268a.getApplication());
    }

    public final String getDeviceId() {
        return getStringFromAppLog(new String[]{"getDid", "getServerDeviceId"});
    }

    public final String getInstallId() {
        return getStringFromAppLog(new String[]{"getIid", "getInstallId"});
    }

    public final String getOpenUDid() {
        return getStringFromAppLog(new String[]{"getOpenUdid", "getOpenUDID"});
    }

    public final String getSessionId() {
        return getStringFromAppLog(new String[]{"getSessionId", "getCurrentSessionId"});
    }

    public final String getUserID() {
        return getStringFromAppLog(new String[]{"getUserID", "getUserId"});
    }

    public final String getUserUniqueID() {
        return getStringFromAppLog(new String[]{"getUserUniqueID", "getUserUniqueId"});
    }

    public final void openETVerify() {
        if (mConfigInfo != null) goto L5;
        return;
    L5:
        SLogger.INSTANCE.i(TAG, "openETVerify");
        EventVerify.inst().setEventVerifyUrl("https://log.bytedance.net");
        EventVerify.inst().setEnable(true, AppHost.f326268a.getApplication());
    }

    private final m0 buildUrlConfig(boolean r100) {
        if (AppHost.f326268a.isOversea() == true) goto L5;
        if (r100 == false) goto L10;
        return new m0(new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, new String[]{"https://rtlog.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com.boe-gateway.byted.org/service/2/app_alert_check/"}, "https://log.snssdk.com.boe-gateway.byted.org/service/2/log_settings/", new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, "https://log.snssdk.com.boe-gateway.byted.org/service/2/log_settings/");
    L10:
        return m0.f408190h;
    L5:
        return m0.f408191i;
    }

    private final String getStringFromAppLog(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L27;
        String r103 = r100[r102];
        Object r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Object r106 = AppLog.class.getMethod(r103, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if ((r106 instanceof String) == false) goto L8;
        String r107 = (String) r106;     // Catch: Throwable -> L11
    L9:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r108) == true) goto L17;
        r104 = r108;
    L17:
        String r109 = (String) r104;
        if (r109 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == false) goto L25;
        r102 = r102 + 1;
        goto L3
    L25:
        return r109;
    L20:
        if (r109.length() == 0) goto L23;
        r110 = false;
        goto L24
    L8:
        r107 = null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L27:
        return "";
    }

    private final void notifyIdsReadyIfNeeded(String r100) {
        String r101 = getDeviceId();
        String r102 = getInstallId();
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L12;
        SLogger.INSTANCE.i(TAG, "notifyIdsReadyIfNeeded skipped: did empty, from=" + r100);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L14;
        scheduleIdsReadyCheck(r100);
        return;
    L14:
        return;
    L12:
        SLogger.INSTANCE.i(TAG, "notifyIdsReadyIfNeeded, did=" + r101 + ", iid=" + r102 + ", from=" + r100);
        updateBdTuringId(r101, r102, r100);
        notifyDidListeners(r101, r102, r100);
        return;
    L5:
        r103 = false;
        goto L7
    }

    private final void scheduleIdsReadyCheck(final String r100) {
        if (idNotifyScheduled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ThreadPlus.submitRunnable(new b(r100));
    }

    private static final void scheduleIdsReadyCheck$lambda$12(String r110) {
        boolean r100 = false;
        int r101 = 0;
    L55:
        CopyOnWriteArrayList<e> r102 = didListenerCallbackList;     // Catch: Throwable -> L35 InterruptedException -> L37
        if ((!r102.isEmpty()) == false) goto L26;
        r101 = r101 + 1;     // Catch: Throwable -> L35 InterruptedException -> L37
        if (r101 > 10) goto L9;
        long r103 = 500;
    L10:
        Thread.sleep(r103);     // Catch: Throwable -> L35 InterruptedException -> L37
        InteractorLegacyAppLogHelper r104 = INSTANCE;     // Catch: Throwable -> L35 InterruptedException -> L37
        String r105 = r104.getDeviceId();     // Catch: Throwable -> L35 InterruptedException -> L37
        if (r105.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L55;
        if (Intrinsics.areEqual(r105, "0") == true) goto L55;
        String r107 = r104.getInstallId();     // Catch: Throwable -> L35 InterruptedException -> L37
        SLogger.INSTANCE.i(TAG, "ids ready after polling, from=" + r110 + ", retry=" + r101);     // Catch: Throwable -> L35 InterruptedException -> L37
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L35 InterruptedException -> L37
        r108.append("polling:");     // Catch: Throwable -> L35 InterruptedException -> L37
        r108.append(r110);     // Catch: Throwable -> L35 InterruptedException -> L37
        r104.updateBdTuringId(r105, r107, r108.toString());     // Catch: Throwable -> L35 InterruptedException -> L37
        r104.notifyDidListeners(r105, r107, "polling:" + r110);     // Catch: Throwable -> L35 InterruptedException -> L37
        idNotifyScheduled.set(false);
        if ((!r102.isEmpty()) == true) goto L21;
        return;
    L21:
        if (r104.getDeviceId().length() != 0) goto L23;
        r100 = true;
    L23:
        if (r100 == false) goto L63;
        r104.scheduleIdsReadyCheck("reschedule:" + r110);
        return;
    L63:
        return;
    L13:
        r106 = false;
        goto L14
    L9:
        r103 = 2000;
        goto L10
    L26:
        SLogger.INSTANCE.i(TAG, "ids polling stopped with no listener, from=" + r110);     // Catch: Throwable -> L35 InterruptedException -> L37
        idNotifyScheduled.set(false);
        if ((!r102.isEmpty()) == false) goto L46;
        InteractorLegacyAppLogHelper r109 = INSTANCE;
        if (r109.getDeviceId().length() != 0) goto L32;
        r100 = true;
    L32:
        if (r100 == false) goto L64;
        StringBuilder r111 = new StringBuilder("reschedule:");
    L34:
        r111.append(r110);
        r109.scheduleIdsReadyCheck(r111.toString());
        return;
    L64:
        return;
    L46:
        return;
    L37:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L35
        SLogger.INSTANCE.w(TAG, "ids polling interrupted", e);     // Catch: Throwable -> L35
        idNotifyScheduled.set(false);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L66;
        r109 = INSTANCE;
        if (r109.getDeviceId().length() != 0) goto L44;
        r100 = true;
    L44:
        if (r100 == false) goto L67;
        r111 = new StringBuilder("reschedule:");
        goto L34
    L67:
        return;
    L66:
        return;
    L35:
        th = move-exception;
        idNotifyScheduled.set(false);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L54;
        InteractorLegacyAppLogHelper r112 = INSTANCE;
        if (r112.getDeviceId().length() != 0) goto L52;
        r100 = true;
    L52:
        if (r100 == false) goto L54;
        r112.scheduleIdsReadyCheck("reschedule:" + r110);
    L54:
        throw th;
    }

    private final Bundle toBundle(Map<?, ?> r100) {
        Bundle r101 = new Bundle();
        Iterator<Map.Entry<?, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<?, ?> r103 = r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r104 == null) goto L4;
        String r106 = r104.toString();
        if (r106 == null) goto L4;
        if (r105 == null) goto L4;
        INSTANCE.addToBundle(r101, r106, r105);
        goto L4
    L12:
        return r101;
    }

    public final void addCommonParamInterceptor(d r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInterceptor");
        CopyOnWriteArrayList<d> r101 = commonParamInterceptors;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final void addGetAppLogIdListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        didListenerCallbackList.add(r100);
        notifyIdsReadyIfNeeded("addGetAppLogIdListener");
    }

    public final void doWhenIdsReady(final Function2<? super String, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        String r101 = getDeviceId();
        String r102 = getInstallId();
        boolean r103 = true;
        if (r101.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L14:
        addGetAppLogIdListener(new AnonymousClass1(r100));
        return;
    L8:
        if (r102.length() > 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L14;
        updateBdTuringId(r101, r102, "doWhenIdsReady");
        r100.invoke(r101, r102);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final synchronized void init(final v48.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "configInfo");     // Catch: Throwable -> L20
        if (initialized == false) goto L9;
        SLogger.INSTANCE.i(TAG, "init skipped: already initialized");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        ObricContextServiceDelegate r101 = ObricContextServiceDelegate.f387837b;     // Catch: Throwable -> L20
        AppHost.Companion r102 = AppHost.f326268a;     // Catch: Throwable -> L20
        if (r101.a(r102.getApplication().getApplicationContext()) == true) goto L14;
        SLogger.INSTANCE.i(TAG, "init skipped: not interactor process");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        NetworkClient.setDefault(new px3.a());     // Catch: Throwable -> L20
        SLogger.INSTANCE.i(TAG, "init legacy AppLog: configInfo=" + r100);     // Catch: Throwable -> L20
        mConfigInfo = r100;     // Catch: Throwable -> L20
        AppLog.f407999b0 = 0;     // Catch: Throwable -> L20
        g.f500370d = 0;     // Catch: Throwable -> L20
        AppLog.f408004g0.r();     // Catch: Throwable -> L20
        AppLog.f408004g0.j(r100.f553119i);     // Catch: Throwable -> L20
        AppLog.f408004g0.f(r100.f553120j);     // Catch: Throwable -> L20
        AppLog.f408004g0.B();     // Catch: Throwable -> L20
        if (r102.isDebug() == false) goto L17;
        Logger.setLogLevel(2);     // Catch: Throwable -> L20
        AppLog.f408004g0.n(new InteractorAppLogLogger(TAG));     // Catch: Throwable -> L20
    L17:
        eta.b r103 = new InteractorLegacyAppLogHelper$init$appContext$1(r100);     // Catch: Throwable -> L20
        Context r104 = r102.getApplication().getApplicationContext();     // Catch: Throwable -> L20
        m0 r105 = m0.f408190h;     // Catch: Throwable -> L20
        i0 r106 = new i0();     // Catch: Throwable -> L20
        r106.f408157e = r104;     // Catch: Throwable -> L20
        r106.f408159g = r105;     // Catch: Throwable -> L20
        r106.f408158f = true;     // Catch: Throwable -> L20
        r106.f408153a = r103;     // Catch: Throwable -> L20
        r106.f408156d = new InteractorLegacyAppLogHelper$init$config$1(r100);     // Catch: Throwable -> L20
        r106.f408154b = new j0();     // Catch: Throwable -> L20
        r106.f408155c = getHeaderInfo();     // Catch: Throwable -> L20
        g0.a(r106.a());     // Catch: Throwable -> L20
        initialized = true;     // Catch: Throwable -> L20
        notifyIdsReadyIfNeeded("init");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void removeCommonParamInterceptor(d r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInterceptor");
        commonParamInterceptors.remove(r100);
    }

    public final void removeDidListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        didListenerCallbackList.remove(r100);
    }

    public final void removeEventCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        eventCommonParamsMap.remove(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.sva.sdk.applog.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setBDAccountCallback(final Pair<Integer, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "pair");
        ?? r101 = new a(r100);
        AppLog.f408004g0.o(r101);
        AppLog.f408004g0.q();
    }

    public final void addEventCommonParams(String r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGenerator");
        eventCommonParamsGenerators.put(r100, r101);
    }

    public final void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        SLogger.INSTANCE.i(TAG, "onMiscEvent: " + r100 + ": " + r101);
        AppLog.recordMiscLog(AppHost.f326268a.getApplication(), r100, r101);
    }

    public final void putEventCommonParams(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        eventCommonParamsMap.put(r100, r101);
    }

    public final void reportEvent(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        SLogger.INSTANCE.d(TAG, r100 + ": " + r101);
        if (r101 != null) goto L5;
        Bundle r102 = new Bundle();
    L26:
        Iterator<T> r103 = commonParamInterceptors.iterator();     // Catch: Exception -> L22
    L8:
        if (r103.hasNext() == false) goto L10;
        ((d) r103.next()).a(r100, r101);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator<Map.Entry<String, Function0<Object>>> r104 = eventCommonParamsGenerators.entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, Function0<Object>> r105 = r104.next();     // Catch: Exception -> L22
        String r106 = r105.getKey();     // Catch: Exception -> L22
        Object r107 = r105.getValue().invoke();     // Catch: Exception -> L22
        if (r102.containsKey(r106) == true) goto L12;
        if (r107 == null) goto L12;
        INSTANCE.addToBundle(r102, r106, r107);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r108 = eventCommonParamsMap.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r108.hasNext() == false) goto L24;
        Map.Entry<String, Object> r109 = r108.next();     // Catch: Exception -> L22
        INSTANCE.addToBundle(r102, r109.getKey(), r109.getValue());     // Catch: Exception -> L22
    L24:
        AppLogNewUtils.onEventV3Bundle(r100, r102);
        return;
    L22:
        e = move-exception;
        SLogger.INSTANCE.e(TAG, "reportEvent: Bundle params error", e);
        goto L24
    L5:
        r102 = r101;
        goto L26
    }

    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        SLogger.INSTANCE.i(TAG, r100 + ": " + r101);
        Iterator<T> r102 = commonParamInterceptors.iterator();     // Catch: Exception -> L22
    L8:
        if (r102.hasNext() == false) goto L10;
        ((d) r102.next()).intercept(r100, r101);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator<Map.Entry<String, Function0<Object>>> r103 = eventCommonParamsGenerators.entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, Function0<Object>> r104 = r103.next();     // Catch: Exception -> L22
        String r105 = r104.getKey();     // Catch: Exception -> L22
        Object r106 = r104.getValue().invoke();     // Catch: Exception -> L22
        if (r101.has(r105) == true) goto L12;
        if (r106 == null) goto L12;
        r101.put(r105, r106);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r107 = eventCommonParamsMap.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r107.hasNext() == false) goto L24;
        Map.Entry<String, Object> r108 = r107.next();     // Catch: Exception -> L22
        INSTANCE.addToJSONObject(r101, r108.getKey(), r108.getValue());     // Catch: Exception -> L22
    L24:
        AppLogNewUtils.onEventV3(r100, r101);
        return;
    L22:
        e = move-exception;
        SLogger.INSTANCE.e(TAG, "reportEvent: JSONObject params error", e);
        goto L24
    }

    private final void addToBundle(Bundle r100, String r101, Object r102) {
        if (r100.containsKey(r101) == false) goto L6;
        return;
    L6:
        if ((r102 instanceof String) == false) goto L9;
        r100.putString(r101, (String) r102);
        return;
    L9:
        if ((r102 instanceof Integer) == false) goto L12;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L12:
        if ((r102 instanceof Long) == false) goto L15;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L15:
        if ((r102 instanceof Boolean) == false) goto L18;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L18:
        if ((r102 instanceof Float) == false) goto L21;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L21:
        if ((r102 instanceof Double) == false) goto L24;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L24:
        if (AppHost.f326268a.isTestChannel() == true) goto L27;
        return;
    L27:
        throw new IllegalArgumentException("addToBundle -> unsupported type: ".concat(r102.getClass().getName()));
    }

    private final void addToJSONObject(JSONObject r100, String r101, Object r102) {
        if (r100.has(r101) == false) goto L6;
        return;
    L6:
        if ((r102 instanceof String) == false) goto L9;
        r100.put(r101, r102);
        return;
    L9:
        if ((r102 instanceof Integer) == false) goto L12;
        r100.put(r101, ((Number) r102).intValue());
        return;
    L12:
        if ((r102 instanceof Long) == false) goto L15;
        r100.put(r101, ((Number) r102).longValue());
        return;
    L15:
        if ((r102 instanceof Boolean) == false) goto L18;
        r100.put(r101, ((Boolean) r102).booleanValue());
        return;
    L18:
        if ((r102 instanceof Float) == false) goto L21;
        r100.put(r101, r102);
        return;
    L21:
        if ((r102 instanceof Double) == false) goto L24;
        r100.put(r101, ((Number) r102).doubleValue());
        return;
    L24:
        if (AppHost.f326268a.isTestChannel() == true) goto L28;
        Unit r103 = Unit.INSTANCE;
        return;
    L28:
        throw new IllegalArgumentException("addToJSONObject -> unsupported type: ".concat(r102.getClass().getName()));
    }

    private final void notifyDidListeners(String r100, String r101, String r102) {
        String r103 = getStringFromAppLog(new String[]{"getSsid"});
        Iterator<T> r104 = didListenerCallbackList.iterator();
    L4:
        if (r104.hasNext() == false) goto L13;
        e r105 = (e) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        r105.onGetId(r100, r101, r103);     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L4;
        SLogger.INSTANCE.w(TAG, "notify did listener failed, from=" + r102, r108);
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void updateBdTuringId(String r100, String r101, String r102) {
        SLogger.INSTANCE.i(TAG, "updateBdTuringId: " + r102 + ", did=" + r100 + ", iid=" + r101);
        qb4.b r103 = qb4.b.c.f532315a;
        BdTuringConfig r104 = r103.f532302a;
        if (r104 == null) goto L5;
        r104.setDeviceId(r100);
    L5:
        BdTuringConfig r105 = r103.f532302a;
        if (r105 == null) goto L9;
        r105.setInstallId(r101);
        return;
    }

    public static final /* synthetic */ void access$updateBdTuringId(InteractorLegacyAppLogHelper r100, String r101, String r102, String r103) {
        r100.updateBdTuringId(r101, r102, r103);
    }
}
