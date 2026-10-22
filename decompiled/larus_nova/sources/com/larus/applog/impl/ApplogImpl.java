package com.larus.applog.impl;

import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.l;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.feishu.office.im.impl.base.FeishuTrackComponent;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.reporter.ObricReporterImpl;
import com.obric.assistant.reporter.ObricReporterImpl$initLaunchReport$2;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nba.c;
import org.json.JSONObject;
import ow3.b;
import v48.e;
import w48.d;
import w48.g;
import w48.k;
import w48.m;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J@\u0010\u001b\u001a\u00020\u001726\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00170\u001dH\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u00020\u00172\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H\u0016J\u001c\u0010,\u001a\u00020\u00172\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010\u00112\u0006\u0010:\u001a\u00020&H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\u001a\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020+2\b\u0010\u0018\u001a\u0004\u0018\u00010AH\u0016J(\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020*2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020\u0005H\u0016J\b\u0010H\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u0005H\u0016J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0018\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020NH\u0016J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010V\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\b\u0010X\u001a\u00020\u0017H\u0002J\n\u0010Y\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010Z\u001a\u00020&2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020&H\u0016J\u0010\u0010_\u001a\u00020&2\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010`\u001a\u00020&2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010a\u001a\u00020\u0017H\u0016J\u0018\u0010b\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0011H\u0016J\b\u0010e\u001a\u00020&H\u0002J\u0010\u0010f\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0010\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020\u00172\u0006\u0010h\u001a\u00020iH\u0016J \u0010k\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u000e\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110mH\u0016J\u0018\u0010n\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0011H\u0016J\u0010\u0010o\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0010\u0010p\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0014H\u0016J\u0010\u0010q\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/larus/applog/impl/ApplogImpl;", "Lcom/larus/applog/api/IApplog;", "<init>", "()V", "vidsFromAbTest", "", "getVidsFromAbTest", "()Ljava/lang/String;", "setVidsFromAbTest", "(Ljava/lang/String;)V", "vidsFromSettings", "getVidsFromSettings", "setVidsFromSettings", "vidsFromCustom", "getVidsFromCustom", "setVidsFromCustom", "eventObserverLock", "", "eventObserverAdapters", "Ljava/util/IdentityHashMap;", "Lcom/larus/applog/api/AppLogEventObserver;", "Lcom/bytedance/applog/IEventObserver;", "addGetAppLogIdListener", "", "listener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.bytedance.android.ec.core.event.a.KEY_DID, WsConstants.KEY_INSTALL_ID, "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "putCommonParams", "params", "", "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "addSessionObserver", "observer", "Lcom/larus/applog/api/OnSessionObserverCallback;", "getUriConfig", "boe", "getNetworkClient", "getDeviceId", "getInstallId", "getClientDid", "resetAndReInstall", "timeout", "Lcom/larus/applog/api/DidCompensationListener;", "reportDidCompensationResult", "success", "errCode", "errMsg", "getSsid", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "updateExternalAbVersion", "getAbSdkVersion", "setNewUserMode", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "isTestChannel", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "removeEventObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplogImpl implements IApplog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f287056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f287057c;

    @Override // com.larus.applog.api.IApplog
    public final Object y() {
        return m.a(false);
    }

    public final void B() {
        FLogger.f375446a.i("ApplogImpl", "updateExternalAbVersion: vidsFromSettings=" + this.f287057c + ", vidsFromAbTest=" + this.f287056b + ", vidsFromCustom=null");     // Catch: Exception -> L11
        List r100 = CollectionsKt.listOfNotNull(new String[]{this.f287057c, this.f287056b, null});     // Catch: Exception -> L11
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L11
        Iterator r102 = r100.iterator();     // Catch: Exception -> L11
    L5:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();     // Catch: Exception -> L11
        if ((!StringsKt.isBlank((String) r103)) == false) goto L5;
        r101.add(r103);     // Catch: Exception -> L11
        goto L5
    L9:
        String r104 = CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null);     // Catch: Exception -> L11
        AppLog.setExternalAbVersion(r104);     // Catch: Exception -> L11
        FLogger.f375446a.i("ApplogImpl", "updateExternalAbVersion: setExternalAbVersion=" + r104);     // Catch: Exception -> L11
        return;
    }

    @Override // com.larus.applog.api.IApplog
    public final void p() {
        Intrinsics.checkNotNullParameter("series_no", "key");
        AppLog.removeHeaderInfo("series_no");
    }

    @Override // com.larus.applog.api.IApplog
    public final Object v() {
        return new a.C3947a();
    }

    @Override // com.larus.applog.api.IApplog
    public final void z() {
        v48.a r100 = a.f287058a;
        v48.a r101 = a.f287058a;
        if (r101 == null) goto L6;
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(r101.f553111a), false, AppHost.f326268a.getApplication());
        return;
    }

    public ApplogImpl() {
        new IdentityHashMap();
    }

    @Override // com.larus.applog.api.IApplog
    public final String e() {
        String r100 = AppLog.getOpenUdid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getAbSdkVersion() {
        return AppLog.getAbSdkVersion();
    }

    @Override // com.larus.applog.api.IApplog
    public final String getClientDid() {
        String r100 = AppLog.getClientUdid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getDeviceId() {
        String r100 = AppLog.getDid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getInstallId() {
        String r100 = AppLog.getIid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getSessionId() {
        String r100 = AppLog.getSessionId();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getSsid() {
        String r100 = AppLog.getSsid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getUserID() {
        String r100 = AppLog.getUserID();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getUserUniqueID() {
        String r100 = AppLog.getUserUniqueID();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.applog.api.IApplog
    public final void flush() {
        AppLog.flush();
    }

    @Override // com.larus.applog.api.IApplog
    public final void g() {
        AppLog.onBgSessionTaskPause();
    }

    @Override // com.larus.applog.api.IApplog
    public final void l() {
        AppLog.onBgSessionTaskResume();
    }

    @Override // com.larus.applog.api.IApplog
    public final void m() {
        a.c();
    }

    @Override // com.larus.applog.api.IApplog
    public final void d(final Pair<Integer, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "pair");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "pair");
        AppLog.setBDAccountCallback(new d(r100));
        AppLog.setEnableEventUserId(true);
    }

    @Override // com.larus.applog.api.IApplog
    public final void f(Function2<? super String, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "action");
        String r102 = AppLog.getDid();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r104 = AppLog.getIid();
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        boolean r105 = true;
        if (r102.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L15;
    L24:
        g r107 = new g(r100);
        Intrinsics.checkNotNullParameter(r107, "listener");
        ((CopyOnWriteArrayList) a.f287059b).add(r107);
        return;
    L15:
        if (ObricFeatureServiceDelegate.f387839b.c() == false) goto L19;
        if (Intrinsics.areEqual(r102, "0") == true) goto L24;
    L19:
        if (r103.length() > 0) goto L22;
        r105 = false;
    L22:
        if (r105 == false) goto L24;
        a.f(r102, r103, "doWhenIdsReady");
        r100.invoke(r102, r103);
        return;
    L12:
        r106 = false;
        goto L13
    }

    @Override // com.larus.applog.api.IApplog
    public final void h(FeishuTrackComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "eventInterceptor");
        a.f287062e.remove(r100);
    }

    @Override // com.larus.applog.api.IApplog
    public final void j(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) a.f287059b).add(r100);
    }

    @Override // com.larus.applog.api.IApplog
    public final void k(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) a.f287059b).remove(r100);
    }

    @Override // com.larus.applog.api.IApplog
    public final void n(FeishuTrackComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "eventInterceptor");
        CopyOnWriteArrayList<v48.d> r102 = a.f287062e;
        if (r102.contains(r100) == true) goto L7;
        r102.add(r100);
        return;
    }

    @Override // com.larus.applog.api.IApplog
    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        v48.a r101 = a.f287058a;
        a.d(r100, f.c(new kotlin.Pair[0]));
    }

    @Override // com.larus.applog.api.IApplog
    public final void putCommonParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        AppLog.putCommonParams(AppHost.f326268a.getApplication(), r100, true, Level.L1);
    }

    @Override // com.larus.applog.api.IApplog
    public final void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "key");
        a.f287061d.remove(r100);
    }

    @Override // com.larus.applog.api.IApplog
    public final void r(ObricReporterImpl.d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "observer");
        ((CopyOnWriteArrayList) a.f287065h).add(r100);
    }

    @Override // com.larus.applog.api.IApplog
    public final void s(final ObricReporterImpl$initLaunchReport$2 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "observer");
        List<l> r102 = a.f287064g;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        r103.add(new w48.e(r100));
    }

    @Override // com.larus.applog.api.IApplog
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        if (Intrinsics.areEqual(r100, this.f287056b) == false) goto L5;
        return;
    L5:
        this.f287056b = r100;
        B();
    }

    @Override // com.larus.applog.api.IApplog
    public final void w(ObricReporterImpl.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        v48.a r101 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        List<b> r102 = a.f287063f;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        r103.add(new w48.f(r100));
    }

    @Override // com.larus.applog.api.IApplog
    public final void x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        if (Intrinsics.areEqual(r100, this.f287057c) == false) goto L5;
        return;
    L5:
        this.f287057c = r100;
        B();
    }

    @Override // com.larus.applog.api.IApplog
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L17;
        AppHost.Companion r102 = AppHost.f326268a;
        if (r102.isDebug() == false) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L17;
        if (r102.isOversea() == false) goto L17;
        throw new IllegalStateException("AppLog.setHeaderInfo MUST NOT be called in main thread (For Cici App)");
    L7:
        if (r102.isTestChannel() == true) goto L10;
        r103 = false;
    L17:
        AppLog.setHeaderInfo(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void b(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a.d(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void c(String r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGenerator");
        v48.a r102 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGenerator");
        ((ConcurrentHashMap) a.f287060c).put(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void i(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        v48.a r102 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        a.f287061d.put(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        v48.a r102 = a.f287058a;
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        FLogger.f375446a.i("AppLogHelper", "onMiscEvent: " + r100 + ": " + r101);
        AppLog.onMiscEvent(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a.e(r100, r101);
    }

    @Override // com.larus.applog.api.IApplog
    public final void u(long r100, c.a r101) {
        AppLog.resetAndReInstall(r100, new k(this, r101));
    }

    public static void A(int r100, String r101, String r102) {
        v48.a r103 = a.f287058a;
        JSONObject r104 = new JSONObject();
        r104.put("success", r100);
        r104.putOpt("err_code", r101);
        r104.putOpt(LocationMonitorConst.ERR_MSG, r102);
        Unit r105 = Unit.INSTANCE;
        a.e("device_id_compensate_result", r104);
    }
}
