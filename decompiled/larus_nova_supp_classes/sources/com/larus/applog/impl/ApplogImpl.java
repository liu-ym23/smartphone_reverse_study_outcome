package com.larus.applog.impl;

import android.os.Bundle;
import android.os.Looper;
import android.util.EventsUtils;
import android.util.Pair;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.l;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.bdinstall.Level;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.ttnet.TTNetInit;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.feishu.office.im.impl.base.FeishuTrackComponent;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.reporter.ObricReporterImpl;
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
import org.xmlpull.v1.XmlPullParser;
import ow3.b;
import v48.e;
import w48.d;
import w48.g;
import w48.k;
import w48.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J@\u0010\u001b\u001a\u00020\u001726\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00170\u001dH\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u00020\u00172\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H\u0016J\u001c\u0010,\u001a\u00020\u00172\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010\u00112\u0006\u0010:\u001a\u00020&H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\u001a\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020+2\b\u0010\u0018\u001a\u0004\u0018\u00010AH\u0016J(\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020*2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020\u0005H\u0016J\b\u0010H\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u0005H\u0016J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0018\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020NH\u0016J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010V\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0005H\u0016J\b\u0010X\u001a\u00020\u0017H\u0002J\n\u0010Y\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010Z\u001a\u00020&2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020&H\u0016J\u0010\u0010_\u001a\u00020&2\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010`\u001a\u00020&2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010a\u001a\u00020\u0017H\u0016J\u0018\u0010b\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0011H\u0016J\b\u0010e\u001a\u00020&H\u0002J\u0010\u0010f\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0010\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020\u00172\u0006\u0010h\u001a\u00020iH\u0016J \u0010k\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u000e\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110mH\u0016J\u0018\u0010n\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0011H\u0016J\u0010\u0010o\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0010\u0010p\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0014H\u0016J\u0010\u0010q\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/larus/applog/impl/ApplogImpl;", "Lcom/larus/applog/api/IApplog;", "<init>", "()V", "vidsFromAbTest", XmlPullParser.NO_NAMESPACE, "getVidsFromAbTest", "()Ljava/lang/String;", "setVidsFromAbTest", "(Ljava/lang/String;)V", "vidsFromSettings", "getVidsFromSettings", "setVidsFromSettings", "vidsFromCustom", "getVidsFromCustom", "setVidsFromCustom", "eventObserverLock", XmlPullParser.NO_NAMESPACE, "eventObserverAdapters", "Ljava/util/IdentityHashMap;", "Lcom/larus/applog/api/AppLogEventObserver;", "Lcom/bytedance/applog/IEventObserver;", "addGetAppLogIdListener", XmlPullParser.NO_NAMESPACE, "listener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", XmlPullParser.NO_NAMESPACE, "setBDAccountCallback", "pair", "Landroid/util/Pair;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "putCommonParams", "params", XmlPullParser.NO_NAMESPACE, "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "addSessionObserver", "observer", "Lcom/larus/applog/api/OnSessionObserverCallback;", "getUriConfig", TTNetInit.DOMAIN_BOE_KEY, "getNetworkClient", "getDeviceId", "getInstallId", "getClientDid", "resetAndReInstall", "timeout", "Lcom/larus/applog/api/DidCompensationListener;", "reportDidCompensationResult", "success", "errCode", "errMsg", "getSsid", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "updateExternalAbVersion", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "isTestChannel", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "removeEventObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ApplogImpl implements IApplog {
    public String b;
    public String c;

    @Override // com.larus.applog.api.IApplog
    public final Object y() {
        return m.a(false);
    }

    public final void B() {
        FLogger.a.i("ApplogImpl", "updateExternalAbVersion: vidsFromSettings=" + this.c + ", vidsFromAbTest=" + this.b + ", vidsFromCustom=null");     // Catch: Exception -> L11
        List r1 = CollectionsKt.listOfNotNull(new String[]{this.c, this.b, null});     // Catch: Exception -> L11
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L11
        Iterator r2 = r1.iterator();     // Catch: Exception -> L11
    L5:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();     // Catch: Exception -> L11
        if ((!StringsKt.isBlank((String) r3)) == false) goto L5;
        r4.add(r3);     // Catch: Exception -> L11
        goto L5
    L9:
        String r5 = CollectionsKt.joinToString$default(r4, ",", null, null, 0, null, null, 62, null);     // Catch: Exception -> L11
        AppLog.setExternalAbVersion(r5);     // Catch: Exception -> L11
        FLogger.a.i("ApplogImpl", "updateExternalAbVersion: setExternalAbVersion=" + r5);     // Catch: Exception -> L11
        return;
    }

    @Override // com.larus.applog.api.IApplog
    public final void p() {
        Intrinsics.checkNotNullParameter("series_no", "key");
        AppLog.removeHeaderInfo("series_no");
    }

    @Override // com.larus.applog.api.IApplog
    public final Object v() {
        return new a.C0005a();
    }

    @Override // com.larus.applog.api.IApplog
    public final void z() {
        v48.a r0 = a.a;
        v48.a r1 = a.a;
        if (r1 == null) goto L6;
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(r1.a), false, AppHost.a.getApplication());
        return;
    }

    public ApplogImpl() {
        new IdentityHashMap();
    }

    @Override // com.larus.applog.api.IApplog
    public final String e() {
        String r0 = AppLog.getOpenUdid();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getAbSdkVersion() {
        return AppLog.getAbSdkVersion();
    }

    @Override // com.larus.applog.api.IApplog
    public final String getClientDid() {
        String r0 = AppLog.getClientUdid();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getDeviceId() {
        String r0 = AppLog.getDid();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getInstallId() {
        String r0 = AppLog.getIid();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getSessionId() {
        String r0 = AppLog.getSessionId();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getSsid() {
        String r0 = AppLog.getSsid();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getUserID() {
        String r0 = AppLog.getUserID();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
    }

    @Override // com.larus.applog.api.IApplog
    public final String getUserUniqueID() {
        String r0 = AppLog.getUserUniqueID();
        if (r0 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r0;
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
    public final void d(Pair<Integer, Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "pair");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "pair");
        AppLog.setBDAccountCallback(new d(r3));
        AppLog.setEnableEventUserId(true);
    }

    @Override // com.larus.applog.api.IApplog
    public final void f(Function2<? super String, ? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r6, "action");
        String r0 = AppLog.getDid();
        String r2 = XmlPullParser.NO_NAMESPACE;
        if (r0 != null) goto L5;
        r0 = XmlPullParser.NO_NAMESPACE;
    L5:
        String r3 = AppLog.getIid();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        boolean r4 = true;
        if (r0.length() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
    L24:
        g r7 = new g(r6);
        Intrinsics.checkNotNullParameter(r7, "listener");
        ((CopyOnWriteArrayList) a.b).add(r7);
        return;
    L15:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L19;
        if (Intrinsics.areEqual(r0, MiraMonitor.VALUE_DEFAULT) == true) goto L24;
    L19:
        if (r2.length() > 0) goto L22;
        r4 = false;
    L22:
        if (r4 == false) goto L24;
        a.f(r0, r2, "doWhenIdsReady");
        r6.invoke(r0, r2);
        return;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.larus.applog.api.IApplog
    public final void h(FeishuTrackComponent.b r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        v48.a r0 = a.a;
        Intrinsics.checkNotNullParameter(r2, "eventInterceptor");
        a.e.remove(r2);
    }

    @Override // com.larus.applog.api.IApplog
    public final void j(e r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) a.b).add(r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void k(e r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) a.b).remove(r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void n(FeishuTrackComponent.b r3) {
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        v48.a r0 = a.a;
        Intrinsics.checkNotNullParameter(r3, "eventInterceptor");
        CopyOnWriteArrayList<v48.d> r1 = a.e;
        if (r1.contains(r3) == true) goto L7;
        r1.add(r3);
        return;
    }

    @Override // com.larus.applog.api.IApplog
    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        v48.a r0 = a.a;
        a.d(r2, f.c(new kotlin.Pair[0]));
    }

    @Override // com.larus.applog.api.IApplog
    public final void putCommonParams(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        AppLog.putCommonParams(AppHost.a.getApplication(), r4, true, Level.L1);
    }

    @Override // com.larus.applog.api.IApplog
    public final void q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        a.d.remove(r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void r(ObricReporterImpl.d r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "observer");
        ((CopyOnWriteArrayList) a.h).add(r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void s(ObricReporterImpl.initLaunchReport.2 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        v48.a r0 = a.a;
        Intrinsics.checkNotNullParameter(r3, "observer");
        List<l> r1 = a.g;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;
        r2.add(new w48.e(r3));
    }

    @Override // com.larus.applog.api.IApplog
    public final void t(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        if (Intrinsics.areEqual(r2, this.b) == false) goto L5;
        return;
    L5:
        this.b = r2;
        B();
    }

    @Override // com.larus.applog.api.IApplog
    public final void w(ObricReporterImpl.c r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        v48.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        List<b> r0 = a.f;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r0;
        r2.add(new w48.f(r3));
    }

    @Override // com.larus.applog.api.IApplog
    public final void x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        if (Intrinsics.areEqual(r2, this.c) == false) goto L5;
        return;
    L5:
        this.c = r2;
        B();
    }

    @Override // com.larus.applog.api.IApplog
    public final void a(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L17;
        AppHost.Companion r0 = AppHost.a;
        if (r0.isDebug() == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L17;
        if (r0.isOversea() == false) goto L17;
        throw new IllegalStateException("AppLog.setHeaderInfo MUST NOT be called in main thread (For Cici App)");
    L7:
        if (r0.isTestChannel() == true) goto L10;
        r1 = false;
    L17:
        AppLog.setHeaderInfo(r3, r4);
    }

    @Override // com.larus.applog.api.IApplog
    public final void b(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        a.d(r2, r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void c(String r4, Function0<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "valueGenerator");
        v48.a r2 = a.a;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "valueGenerator");
        ((ConcurrentHashMap) a.c).put(r4, r5);
    }

    @Override // com.larus.applog.api.IApplog
    public final void i(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        v48.a r2 = a.a;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        a.d.put(r4, r5);
    }

    @Override // com.larus.applog.api.IApplog
    public final void onMiscEvent(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "logType");
        Intrinsics.checkNotNullParameter(r5, "obj");
        v48.a r2 = a.a;
        Intrinsics.checkNotNullParameter(r4, "logType");
        Intrinsics.checkNotNullParameter(r5, "obj");
        FLogger.a.i("AppLogHelper", "onMiscEvent: " + r4 + ": " + r5);
        AppLog.onMiscEvent(r4, r5);
    }

    @Override // com.larus.applog.api.IApplog
    public final void reportEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        a.e(r2, r3);
    }

    @Override // com.larus.applog.api.IApplog
    public final void u(long r2, c.a r4) {
        AppLog.resetAndReInstall(r2, new k(this, r4));
    }

    public static void A(int r2, String r3, String r4) {
        v48.a r0 = a.a;
        JSONObject r1 = new JSONObject();
        r1.put("success", r2);
        r1.putOpt("err_code", r3);
        r1.putOpt("err_msg", r4);
        Unit r5 = Unit.INSTANCE;
        a.e("device_id_compensate_result", r1);
    }
}
