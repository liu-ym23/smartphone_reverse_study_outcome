package com.larus.office.base.plugins.authorization;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.account.base.model.AuthorizationPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/plugins/authorization/LarkAuthorizationPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getAuthorizationData", "data", "Lcom/larus/office/base/plugins/authorization/AuthModel;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getTicketInfo", "Lcom/larus/office/base/plugins/authorization/TicketInfoModel;", "Companion", "GetAuthHeader", "GetTicketInfo", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LarkAuthorizationPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_AUTH_HEADER = "biz.util.getAuthHeader";
    private static final String BIZ_TICKET_INFO = "biz.util.getTicketInfo";
    public static final a Companion = null;
    private static final String TAG = "LarkAuthorizationPluginV2";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements i<AuthModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarkAuthorizationPluginV2 f360730a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(LarkAuthorizationPluginV2 r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
            this.f360730a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            AuthModel r112 = (AuthModel) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            FLogger r100 = FLogger.f375446a;
            r100.i(LarkAuthorizationPluginV2.TAG, "GetAuthHeader:" + r112);
            if (r112 != null) goto L5;
            r111.b(new JSONObject());
            r100.i(LarkAuthorizationPluginV2.TAG, "GetAuthHeader data null");
            return;
        L5:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LarkAuthorizationPluginV2$GetAuthHeader$handle$1(this, r112, r111, null), 2, null);
        }
    }

    public static final class c implements i<TicketInfoModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarkAuthorizationPluginV2 f360731a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public c(LarkAuthorizationPluginV2 r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
            this.f360731a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            TicketInfoModel r112 = (TicketInfoModel) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            FLogger r100 = FLogger.f375446a;
            r100.i(LarkAuthorizationPluginV2.TAG, "GetTicketInfo:" + r112);
            if (r112 != null) goto L5;
            r111.b(new JSONObject());
            r100.i(LarkAuthorizationPluginV2.TAG, "GetTicketInfo data null");
            return;
        L5:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LarkAuthorizationPluginV2$GetTicketInfo$handle$1(this, r112, r111, null), 2, null);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public LarkAuthorizationPluginV2() {
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
        com.larus.office.base.plugins.authorization.a r101 = com.larus.office.base.plugins.authorization.a.f360732a;
        monitor-enter(r101);
        com.larus.office.base.plugins.authorization.a.f360734c++;     // Catch: Throwable -> L7
        FLogger.f375446a.i("AuthorizationCookiesManager", "attach..., current count is " + com.larus.office.base.plugins.authorization.a.f360734c);     // Catch: Throwable -> L7
        com.larus.office.base.plugins.authorization.a.f360733b.mo10962trySendJP2dKIU(Integer.valueOf(com.larus.office.base.plugins.authorization.a.f360734c));     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        com.larus.office.base.plugins.authorization.a r101 = com.larus.office.base.plugins.authorization.a.f360732a;
        monitor-enter(r101);
        int r102 = com.larus.office.base.plugins.authorization.a.f360734c;     // Catch: Throwable -> L10
        if (r102 <= 0) goto L7;
        com.larus.office.base.plugins.authorization.a.f360734c = r102 - 1;     // Catch: Throwable -> L10
    L7:
        FLogger.f375446a.i("AuthorizationCookiesManager", "detach..., current count is " + com.larus.office.base.plugins.authorization.a.f360734c);     // Catch: Throwable -> L10
        com.larus.office.base.plugins.authorization.a.f360733b.mo10962trySendJP2dKIU(Integer.valueOf(com.larus.office.base.plugins.authorization.a.f360734c));     // Catch: Throwable -> L10
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
        Iterator r102 = ServiceManager.get().getServices(IThirdPartyPlatformAuthorizationProvider.class).iterator();
    L4:
        if (r102.hasNext() == false) goto L33;
        IThirdPartyPlatformAuthorizationProvider r103 = (IThirdPartyPlatformAuthorizationProvider) r102.next();
        if (r103.c() != AuthorizationPlatform.LARK) goto L4;
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
        Map r107 = IThirdPartyPlatformAuthorizationProvider.a.a(r103, r105, r104, 12);
        FLogger.f375446a.i(TAG, "GetAuthHeader: header size=" + r107.size());
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L31
        if ((!r107.isEmpty()) == false) goto L25;
        Iterator r109 = r107.entrySet().iterator();     // Catch: Exception -> L31
    L22:
        if (r109.hasNext() == false) goto L25;
        Map.Entry r110 = (Map.Entry) r109.next();     // Catch: Exception -> L31
        r108.put2((String) r110.getKey(), r110.getValue());     // Catch: Exception -> L31
    L25:
        if (AppHost.f326268a.isDebug() == true) goto L27;
    L29:
        r101.b(r108);     // Catch: Exception -> L31
        goto L4
    L27:
        if (o0.d(HttpExtKt.e().f360169d) == false) goto L29;
        r108.put2("x-tt-env", HttpExtKt.e().f360169d);     // Catch: Exception -> L31
        r108.put2("env", "pre_release");     // Catch: Exception -> L31
    L31:
        e = move-exception;
        r101.b(new JSONObject());
        FLogger.f375446a.e(TAG, "getAuthorizationData (): get failed", e);
    L11:
        r105 = "";
        goto L12
    }

    private final void getTicketInfo(TicketInfoModel r100, m r110) {
        if (r100 == null) goto L5;
        String r101 = r100.getUrl();
    L6:
        boolean r102 = false;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L46;
        FLogger.f375446a.i(TAG, "GetTicketInfo: url empty, return empty");
        r110.b(new JSONObject());
        return;
    L46:
        Iterator r104 = ServiceManager.get().getServices(IThirdPartyPlatformAuthorizationProvider.class).iterator();     // Catch: Exception -> L43
    L19:
        if (r104.hasNext() == false) goto L26;
        Object r105 = r104.next();     // Catch: Exception -> L43
        if (((IThirdPartyPlatformAuthorizationProvider) r105).c() != AuthorizationPlatform.LARK) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L19;
    L27:
        IThirdPartyPlatformAuthorizationProvider r107 = (IThirdPartyPlatformAuthorizationProvider) r105;     // Catch: Exception -> L43
        if (r107 == null) goto L32;
        Pair<String, String> r108 = r107.f(r101);     // Catch: Exception -> L43
        if (r108 == null) goto L32;
    L33:
        String r109 = r108.component1();     // Catch: Exception -> L43
        Object r111 = (String) r108.component2();     // Catch: Exception -> L43
        if (r109 != null) goto L36;
    L37:
        r102 = true;
    L38:
        if (r102 == false) goto L41;
        FLogger.f375446a.i(TAG, "GetTicketInfo: ticket empty, return empty");     // Catch: Exception -> L43
        r110.b(new JSONObject());     // Catch: Exception -> L43
        return;
    L41:
        FLogger.f375446a.i(TAG, "GetTicketInfo: sign success");     // Catch: Exception -> L43
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L43
        r112.put2("ticket", r109);     // Catch: Exception -> L43
        r112.put2("ticket_signature", r111);     // Catch: Exception -> L43
        r110.b(r112);     // Catch: Exception -> L43
        return;
    L36:
        if (r109.length() != 0) goto L38;
    L32:
        r108 = TuplesKt.to(null, null);     // Catch: Exception -> L43
        goto L33
    L23:
        r106 = false;
        goto L24
    L26:
        r105 = null;
    L43:
        e = move-exception;
        r110.b(new JSONObject());
        FLogger.f375446a.e(TAG, "getTicketInfo (): get failed", e);
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public static final /* synthetic */ void access$getAuthorizationData(LarkAuthorizationPluginV2 r100, AuthModel r101, m r102) {
        r100.getAuthorizationData(r101, r102);
    }

    public static final /* synthetic */ void access$getTicketInfo(LarkAuthorizationPluginV2 r100, TicketInfoModel r101, m r102) {
        r100.getTicketInfo(r101, r102);
    }
}
