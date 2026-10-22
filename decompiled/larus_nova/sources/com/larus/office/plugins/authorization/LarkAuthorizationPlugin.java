package com.larus.office.plugins.authorization;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.OfficeAuthServiceImpl;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.IFlowOfficeAuthService;
import com.larus.platform.service.a2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0018"}, d2 = {"Lcom/larus/office/plugins/authorization/LarkAuthorizationPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getAuthorizationData", "data", "Lcom/larus/office/plugins/authorization/AuthModel;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getTicketInfo", "Lcom/larus/office/plugins/authorization/TicketInfoModel;", "Companion", "GetAuthHeader", "GetTicketInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkAuthorizationPlugin extends OfficeDocumentPlugin {
    private static final String BIZ_AUTH_HEADER = "biz.util.getAuthHeader";
    private static final String BIZ_TICKET_INFO = "biz.util.getTicketInfo";
    public static final a Companion = null;
    private static final String TAG = "LarkAuthorizationPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements i<AuthModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarkAuthorizationPlugin f362359a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(LarkAuthorizationPlugin r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
            this.f362359a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            AuthModel r112 = (AuthModel) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            FLogger r100 = FLogger.f375446a;
            r100.i(LarkAuthorizationPlugin.TAG, "GetAuthHeader:" + r112);
            if (r112 != null) goto L5;
            r111.b(new JSONObject());
            r100.i(LarkAuthorizationPlugin.TAG, "GetAuthHeader data null");
            return;
        L5:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LarkAuthorizationPlugin$GetAuthHeader$handle$1(this, r112, r111, null), 2, null);
        }
    }

    public static final class c implements i<TicketInfoModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarkAuthorizationPlugin f362360a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public c(LarkAuthorizationPlugin r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
            this.f362360a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            TicketInfoModel r112 = (TicketInfoModel) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            FLogger r100 = FLogger.f375446a;
            r100.i(LarkAuthorizationPlugin.TAG, "GetTicketInfo:" + r112);
            if (r112 != null) goto L5;
            r111.b(new JSONObject());
            r100.i(LarkAuthorizationPlugin.TAG, "GetTicketInfo data null");
            return;
        L5:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LarkAuthorizationPlugin$GetTicketInfo$handle$1(this, r112, r111, null), 2, null);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public LarkAuthorizationPlugin() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_AUTH_HEADER, new b(this));
        r100.put(BIZ_TICKET_INFO, new c(this));
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        com.larus.office.plugins.authorization.b r101 = com.larus.office.plugins.authorization.b.f362363a;
        monitor-enter(r101);
        com.larus.office.plugins.authorization.b.f362365c++;     // Catch: Throwable -> L7
        FLogger.f375446a.i("AuthorizationCookiesManager", "attach..., current count is " + com.larus.office.plugins.authorization.b.f362365c);     // Catch: Throwable -> L7
        com.larus.office.plugins.authorization.b.f362364b.mo10962trySendJP2dKIU(Integer.valueOf(com.larus.office.plugins.authorization.b.f362365c));     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        com.larus.office.plugins.authorization.b r101 = com.larus.office.plugins.authorization.b.f362363a;
        monitor-enter(r101);
        int r102 = com.larus.office.plugins.authorization.b.f362365c;     // Catch: Throwable -> L10
        if (r102 <= 0) goto L7;
        com.larus.office.plugins.authorization.b.f362365c = r102 - 1;     // Catch: Throwable -> L10
    L7:
        FLogger.f375446a.i("AuthorizationCookiesManager", "detach..., current count is " + com.larus.office.plugins.authorization.b.f362365c);     // Catch: Throwable -> L10
        com.larus.office.plugins.authorization.b.f362364b.mo10962trySendJP2dKIU(Integer.valueOf(com.larus.office.plugins.authorization.b.f362365c));     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    private final void getAuthorizationData(AuthModel r100, m r101) {
        IFlowOfficeAuthService r102 = a2.a();
        if (r102 == null) goto L34;
        OfficeAuthServiceImpl r103 = (OfficeAuthServiceImpl) r102;
        if (r103.d() == false) goto L34;
        String r104 = "";
        if (r100 == null) goto L11;
        String r105 = r100.getMethod();
        if (r105 == null) goto L11;
    L12:
        if (r100 == null) goto L17;
        String r106 = r100.getUrl();
        if (r106 == null) goto L17;
        r104 = r106;
    L17:
        Map<String, String> r107 = r103.a(r105, r104);
        FLogger.f375446a.i(TAG, "GetAuthHeader: header size=" + r107.size());
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L31
        if ((!r107.isEmpty()) == false) goto L25;
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();     // Catch: Exception -> L31
    L22:
        if (r109.hasNext() == false) goto L25;
        Map.Entry<String, String> r110 = r109.next();     // Catch: Exception -> L31
        r108.put2(r110.getKey(), r110.getValue());     // Catch: Exception -> L31
    L25:
        if (AppHost.f326268a.isDebug() == true) goto L27;
    L29:
        r101.b(r108);     // Catch: Exception -> L31
        return;
    L27:
        if (o0.d(HttpExtKt.e().f360169d) == false) goto L29;
        r108.put2("x-tt-env", HttpExtKt.e().f360169d);     // Catch: Exception -> L31
        r108.put2("env", "pre_release");     // Catch: Exception -> L31
    L31:
        e = move-exception;
        r101.b(new JSONObject());
        FLogger.f375446a.e(TAG, "getAuthorizationData (): get failed", e);
        return;
    L11:
        r105 = "";
    L34:
        FLogger.f375446a.i(TAG, "GetAuthHeader: authService null or not lark platform, return empty");
        r101.b(new JSONObject());
    }

    private final void getTicketInfo(TicketInfoModel r100, m r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getUrl();
    L5:
        boolean r103 = true;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        FLogger.f375446a.i(TAG, "GetTicketInfo: url empty, return empty");
        r101.b(new JSONObject());
        return;
    L16:
        IFlowOfficeAuthService r105 = a2.a();
        if (r105 == null) goto L35;
        OfficeAuthServiceImpl r106 = (OfficeAuthServiceImpl) r105;
        if (r106.d() == false) goto L35;
        Pair<String, String> r107 = r106.c(r102);     // Catch: Exception -> L32
        String r108 = r107.component1();     // Catch: Exception -> L32
        Object r109 = (String) r107.component2();     // Catch: Exception -> L32
        if (r108 != null) goto L24;
    L27:
        if (r103 == false) goto L30;
        FLogger.f375446a.i(TAG, "GetTicketInfo: ticket empty, return empty");     // Catch: Exception -> L32
        r101.b(new JSONObject());     // Catch: Exception -> L32
        return;
    L30:
        FLogger.f375446a.i(TAG, "GetTicketInfo: sign success");     // Catch: Exception -> L32
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L32
        r110.put2("ticket", r108);     // Catch: Exception -> L32
        r110.put2("ticket_signature", r109);     // Catch: Exception -> L32
        r101.b(r110);     // Catch: Exception -> L32
        return;
    L24:
        if (r108.length() == 0) goto L27;
        r103 = false;
    L32:
        e = move-exception;
        r101.b(new JSONObject());
        FLogger.f375446a.e(TAG, "getTicketInfo (): get failed", e);
        return;
    L35:
        FLogger.f375446a.i(TAG, "GetTicketInfo: authService null or not lark platform, return empty");
        r101.b(new JSONObject());
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r104 = false;
        goto L13
    L4:
        r102 = null;
        goto L5
    }

    public static final /* synthetic */ void access$getAuthorizationData(LarkAuthorizationPlugin r100, AuthModel r101, m r102) {
        r100.getAuthorizationData(r101, r102);
    }

    public static final /* synthetic */ void access$getTicketInfo(LarkAuthorizationPlugin r100, TicketInfoModel r101, m r102) {
        r100.getTicketInfo(r101, r102);
    }
}
