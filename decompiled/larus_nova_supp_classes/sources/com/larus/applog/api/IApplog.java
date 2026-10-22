package com.larus.applog.api;

import android.os.Bundle;
import android.util.EventsUtils;
import android.util.Pair;
import com.bytedance.ttnet.TTNetInit;
import com.larus.feishu.office.im.impl.base.FeishuTrackComponent;
import com.obric.assistant.reporter.ObricReporterImpl;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import v48.c;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 Z2\u00020\u0001:\u0001ZJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H&J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001bH&J@\u0010\u001d\u001a\u00020\t26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t0\u001fH&J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\tH&J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H&J\u001c\u0010)\u001a\u00020\t2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u000b0+H&J\u001c\u0010-\u001a\u00020\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/H&J\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00103\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\n\u00104\u001a\u0004\u0018\u00010\u0003H&J \u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020(H&J\u0010\u0010:\u001a\u00020(2\u0006\u00106\u001a\u000207H&J\u0010\u0010;\u001a\u00020(2\u0006\u00106\u001a\u000207H&J\b\u0010<\u001a\u00020\tH&J\u0018\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0001H&J\u0010\u0010@\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0003H&J\u0010\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020CH&J\u0010\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020CH&J \u0010E\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u000e\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010GH&J\u0018\u0010H\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0001H&J\u0010\u0010I\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0003H&J\u0010\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH&J\u0010\u0010M\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH&J\b\u0010N\u001a\u00020\tH&J\b\u0010O\u001a\u00020\tH&J\u0010\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020\t2\u0006\u0010K\u001a\u00020TH&J\u0010\u0010U\u001a\u00020\t2\u0006\u0010Q\u001a\u00020VH&J\u0012\u0010W\u001a\u0004\u0018\u00010\u00012\u0006\u0010X\u001a\u00020(H&J\n\u0010Y\u001a\u0004\u0018\u00010\u0001H&¨\u0006["}, d2 = {"Lcom/larus/applog/api/IApplog;", XmlPullParser.NO_NAMESPACE, "getInstallId", XmlPullParser.NO_NAMESPACE, "getClientDid", "getSsid", "getSessionId", "getDeviceId", "resetAndReInstall", XmlPullParser.NO_NAMESPACE, "timeout", XmlPullParser.NO_NAMESPACE, "listener", "Lcom/larus/applog/api/DidCompensationListener;", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "addGetAppLogIdListener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", XmlPullParser.NO_NAMESPACE, "setBDAccountCallback", "pair", "Landroid/util/Pair;", XmlPullParser.NO_NAMESPACE, "putCommonParams", "params", XmlPullParser.NO_NAMESPACE, "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "observer", "Lcom/larus/applog/api/AppLogEventObserver;", "removeEventObserver", "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addSessionObserver", "Lcom/larus/applog/api/OnSessionObserverCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "getUriConfig", TTNetInit.DOMAIN_BOE_KEY, "getNetworkClient", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IApplog {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\"H\u0016J@\u0010$\u001a\u00020\u001026\u0010%\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00100&H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0016J\u001c\u00100\u001a\u00020\u00102\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001202H\u0016J\u001c\u00104\u001a\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n06H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u00102\u0006\u00109\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020/H\u0016J\n\u0010C\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\n\u0010I\u001a\u0004\u0018\u00010\nH\u0016J \u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/H\u0016J\u0010\u0010O\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\u0018\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020AH\u0016J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\nH\u0016J\u0010\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J \u0010Z\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u000e\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\\H\u0016J\u0018\u0010]\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020AH\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\nH\u0016J\u0010\u0010_\u001a\u00020\u00102\u0006\u0010<\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020\u00102\u0006\u0010<\u001a\u00020`H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006b"}, d2 = {"Lcom/larus/applog/api/IApplog$Companion;", "Lcom/larus/applog/api/IApplog;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/applog/api/IApplog;", "impl$delegate", "Lkotlin/Lazy;", "getInstallId", XmlPullParser.NO_NAMESPACE, "getClientDid", "getSsid", "getSessionId", "getDeviceId", "resetAndReInstall", XmlPullParser.NO_NAMESPACE, "timeout", XmlPullParser.NO_NAMESPACE, "listener", "Lcom/larus/applog/api/DidCompensationListener;", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "addGetAppLogIdListener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", XmlPullParser.NO_NAMESPACE, "setBDAccountCallback", "pair", "Landroid/util/Pair;", XmlPullParser.NO_NAMESPACE, "putCommonParams", "params", XmlPullParser.NO_NAMESPACE, "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addSessionObserver", "observer", "Lcom/larus/applog/api/OnSessionObserverCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "getUriConfig", XmlPullParser.NO_NAMESPACE, TTNetInit.DOMAIN_BOE_KEY, "getNetworkClient", "onBgSessionTaskResume", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "Lcom/larus/applog/api/AppLogEventObserver;", "removeEventObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements IApplog {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IApplog> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new c());
        }

        public static IApplog A() {
            return c.getValue();
        }

        @Override // com.larus.applog.api.IApplog
        public final void p() {
            Intrinsics.checkNotNullParameter("series_no", "key");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.p();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final String e() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.e();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final void flush() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.flush();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void g() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.g();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getAbSdkVersion() {
            IApplog r0 = A();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getAbSdkVersion();
        }

        @Override // com.larus.applog.api.IApplog
        public final String getClientDid() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getClientDid();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getDeviceId() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getDeviceId();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getInstallId() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getInstallId();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getSessionId() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getSessionId();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getSsid() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getSsid();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getUserID() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getUserID();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getUserUniqueID() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            String r1 = r0.getUserUniqueID();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.applog.api.IApplog
        public final void l() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.l();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void m() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.m();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final Object v() {
            IApplog r0 = A();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.v();
        }

        @Override // com.larus.applog.api.IApplog
        public final Object y() {
            IApplog r0 = A();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.y();
        }

        @Override // com.larus.applog.api.IApplog
        public final void z() {
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.z();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void d(Pair<Integer, Long> r2) {
            Intrinsics.checkNotNullParameter(r2, "pair");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.d(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void f(Function2<? super String, ? super String, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.f(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void h(FeishuTrackComponent.b r2) {
            Intrinsics.checkNotNullParameter(r2, "interceptor");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.h(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void j(e r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.j(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void k(e r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.k(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void n(FeishuTrackComponent.b r2) {
            Intrinsics.checkNotNullParameter(r2, "interceptor");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.n(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void o(String r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.o(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void putCommonParams(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.putCommonParams(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void q(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.q(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void r(ObricReporterImpl.d r2) {
            Intrinsics.checkNotNullParameter(r2, "observer");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.r(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void s(ObricReporterImpl.initLaunchReport.2 r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.s(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void t(String r2) {
            Intrinsics.checkNotNullParameter(r2, "vid");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.t(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void w(ObricReporterImpl.c r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.w(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void x(String r2) {
            Intrinsics.checkNotNullParameter(r2, "vid");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.x(r2);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void a(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void b(String r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.b(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void c(String r2, Function0<? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "valueGenerator");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.c(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void i(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.i(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void onMiscEvent(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "logType");
            Intrinsics.checkNotNullParameter(r3, "obj");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.onMiscEvent(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void reportEvent(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IApplog r0 = A();
            if (r0 == null) goto L6;
            r0.reportEvent(r2, r3);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void u(long r2, nba.c.a r4) {
            IApplog r0 = A();
            if (r0 == null) goto L5;
            r0.u(r2, r4);
            return;
        L5:
            if (r4 == null) goto L9;
            r4.onTimeout();
            return;
        }
    }

    static {
        a = Companion.b;
    }

    void a(String r1, Object r2);

    void b(String r1, Bundle r2);

    void c(String r1, Function0<? extends Object> r2);

    void d(Pair<Integer, Long> r1);

    String e();

    void f(Function2<? super String, ? super String, Unit> r1);

    void flush();

    void g();

    String getAbSdkVersion();

    String getClientDid();

    String getDeviceId();

    String getInstallId();

    String getSessionId();

    String getSsid();

    String getUserID();

    String getUserUniqueID();

    void h(FeishuTrackComponent.b r1);

    void i(String r1, Object r2);

    void j(e r1);

    void k(e r1);

    void l();

    void m();

    void n(FeishuTrackComponent.b r1);

    void o(String r1);

    void onMiscEvent(String r1, JSONObject r2);

    void p();

    void putCommonParams(Map<String, String> r1);

    void q(String r1);

    void r(ObricReporterImpl.d r1);

    void reportEvent(String r1, JSONObject r2);

    void s(ObricReporterImpl.initLaunchReport.2 r1);

    void t(String r1);

    void u(long r1, nba.c.a r3);

    Object v();

    void w(ObricReporterImpl.c r1);

    void x(String r1);

    Object y();

    void z();
}
