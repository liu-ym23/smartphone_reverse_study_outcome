package com.larus.applog.api;

import android.os.Bundle;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.feishu.office.im.impl.base.FeishuTrackComponent;
import com.obric.assistant.reporter.ObricReporterImpl;
import com.obric.assistant.reporter.ObricReporterImpl$initLaunchReport$2;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v48.c;
import v48.e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 Z2\u00020\u0001:\u0001ZJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H&J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001bH&J@\u0010\u001d\u001a\u00020\t26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t0\u001fH&J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\tH&J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H&J\u001c\u0010)\u001a\u00020\t2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u000b0+H&J\u001c\u0010-\u001a\u00020\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/H&J\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00103\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0003H&J\n\u00104\u001a\u0004\u0018\u00010\u0003H&J \u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020(H&J\u0010\u0010:\u001a\u00020(2\u0006\u00106\u001a\u000207H&J\u0010\u0010;\u001a\u00020(2\u0006\u00106\u001a\u000207H&J\b\u0010<\u001a\u00020\tH&J\u0018\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0001H&J\u0010\u0010@\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0003H&J\u0010\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020CH&J\u0010\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020CH&J \u0010E\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u000e\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010GH&J\u0018\u0010H\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0001H&J\u0010\u0010I\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0003H&J\u0010\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH&J\u0010\u0010M\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH&J\b\u0010N\u001a\u00020\tH&J\b\u0010O\u001a\u00020\tH&J\u0010\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020\t2\u0006\u0010K\u001a\u00020TH&J\u0010\u0010U\u001a\u00020\t2\u0006\u0010Q\u001a\u00020VH&J\u0012\u0010W\u001a\u0004\u0018\u00010\u00012\u0006\u0010X\u001a\u00020(H&J\n\u0010Y\u001a\u0004\u0018\u00010\u0001H&¨\u0006["}, d2 = {"Lcom/larus/applog/api/IApplog;", "", "getInstallId", "", "getClientDid", "getSsid", "getSessionId", "getDeviceId", "resetAndReInstall", "", "timeout", "", "listener", "Lcom/larus/applog/api/DidCompensationListener;", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "addGetAppLogIdListener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", a.KEY_DID, WsConstants.KEY_INSTALL_ID, "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "putCommonParams", "params", "", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "observer", "Lcom/larus/applog/api/AppLogEventObserver;", "removeEventObserver", "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addSessionObserver", "Lcom/larus/applog/api/OnSessionObserverCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "getUriConfig", "boe", "getNetworkClient", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IApplog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f287053a = null;

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\"H\u0016J@\u0010$\u001a\u00020\u001026\u0010%\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00100&H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0016J\u001c\u00100\u001a\u00020\u00102\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001202H\u0016J\u001c\u00104\u001a\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n06H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u00102\u0006\u00109\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020/H\u0016J\n\u0010C\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\nH\u0016J\n\u0010I\u001a\u0004\u0018\u00010\nH\u0016J \u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/H\u0016J\u0010\u0010O\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\u0018\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020AH\u0016J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\nH\u0016J\u0010\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J \u0010Z\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u000e\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\\H\u0016J\u0018\u0010]\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020AH\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\nH\u0016J\u0010\u0010_\u001a\u00020\u00102\u0006\u0010<\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020\u00102\u0006\u0010<\u001a\u00020`H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006b"}, d2 = {"Lcom/larus/applog/api/IApplog$Companion;", "Lcom/larus/applog/api/IApplog;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/applog/api/IApplog;", "impl$delegate", "Lkotlin/Lazy;", "getInstallId", "", "getClientDid", "getSsid", "getSessionId", "getDeviceId", "resetAndReInstall", "", "timeout", "", "listener", "Lcom/larus/applog/api/DidCompensationListener;", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "addGetAppLogIdListener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", a.KEY_DID, WsConstants.KEY_INSTALL_ID, "openETVerify", "closeETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "putCommonParams", "params", "", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/larus/applog/api/OnLaunchCallback;", "addSessionObserver", "observer", "Lcom/larus/applog/api/OnSessionObserverCallback;", "addNavigatorCallback", "Lcom/larus/applog/api/OnNavigateCallback;", "getUriConfig", "", "boe", "getNetworkClient", "onBgSessionTaskResume", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "appendExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "open", "auto", "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addCommonParamInterceptor", "interceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "removeEventCommonParams", "addEventObserver", "Lcom/larus/applog/api/AppLogEventObserver;", "removeEventObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IApplog {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f287054b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IApplog> f287055c = null;

        private Companion() {
        }

        static {
            f287054b = new Companion();
            f287055c = LazyKt.lazy(new c());
        }

        public static IApplog A() {
            return f287055c.getValue();
        }

        @Override // com.larus.applog.api.IApplog
        public final void p() {
            Intrinsics.checkNotNullParameter("series_no", "key");
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.p();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final String e() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.e();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final void flush() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.flush();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void g() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.g();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final String getAbSdkVersion() {
            IApplog r100 = A();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getAbSdkVersion();
        }

        @Override // com.larus.applog.api.IApplog
        public final String getClientDid() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getClientDid();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getDeviceId() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getDeviceId();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getInstallId() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getInstallId();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getSessionId() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getSessionId();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getSsid() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getSsid();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getUserID() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getUserID();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final String getUserUniqueID() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            String r101 = r100.getUserUniqueID();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.applog.api.IApplog
        public final void l() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.l();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void m() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.m();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final Object v() {
            IApplog r100 = A();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.v();
        }

        @Override // com.larus.applog.api.IApplog
        public final Object y() {
            IApplog r100 = A();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.y();
        }

        @Override // com.larus.applog.api.IApplog
        public final void z() {
            IApplog r100 = A();
            if (r100 == null) goto L6;
            r100.z();
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void d(Pair<Integer, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "pair");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void f(Function2<? super String, ? super String, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.f(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void h(FeishuTrackComponent.b r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void j(e r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.j(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void k(e r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void n(FeishuTrackComponent.b r100) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.n(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void o(String r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.o(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void putCommonParams(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.putCommonParams(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void q(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.q(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void r(ObricReporterImpl.d r100) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.r(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void s(ObricReporterImpl$initLaunchReport$2 r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.s(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void t(String r100) {
            Intrinsics.checkNotNullParameter(r100, "vid");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.t(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void w(ObricReporterImpl.c r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.w(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void x(String r100) {
            Intrinsics.checkNotNullParameter(r100, "vid");
            IApplog r101 = A();
            if (r101 == null) goto L6;
            r101.x(r100);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void b(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void c(String r100, Function0<? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "valueGenerator");
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.c(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void i(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.i(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void onMiscEvent(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "logType");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.onMiscEvent(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void reportEvent(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            IApplog r102 = A();
            if (r102 == null) goto L6;
            r102.reportEvent(r100, r101);
            return;
        }

        @Override // com.larus.applog.api.IApplog
        public final void u(long r100, nba.c.a r101) {
            IApplog r102 = A();
            if (r102 == null) goto L5;
            r102.u(r100, r101);
            return;
        L5:
            if (r101 == null) goto L9;
            r101.onTimeout();
            return;
        }
    }

    static {
        f287053a = Companion.f287054b;
    }

    void a(String r100, Object r101);

    void b(String r100, Bundle r101);

    void c(String r100, Function0<? extends Object> r101);

    void d(Pair<Integer, Long> r100);

    String e();

    void f(Function2<? super String, ? super String, Unit> r100);

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

    void h(FeishuTrackComponent.b r100);

    void i(String r100, Object r101);

    void j(e r100);

    void k(e r100);

    void l();

    void m();

    void n(FeishuTrackComponent.b r100);

    void o(String r100);

    void onMiscEvent(String r100, JSONObject r101);

    void p();

    void putCommonParams(Map<String, String> r100);

    void q(String r100);

    void r(ObricReporterImpl.d r100);

    void reportEvent(String r100, JSONObject r101);

    void s(ObricReporterImpl$initLaunchReport$2 r100);

    void t(String r100);

    void u(long r100, nba.c.a r101);

    Object v();

    void w(ObricReporterImpl.c r100);

    void x(String r100);

    Object y();

    void z();
}
