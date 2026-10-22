package oe7;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.open")
public final class c extends oe7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f523013d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f523014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f523015b;

        public a(c r100, IBDXBridgeContext r101) {
            this.f523014a = r100;
            this.f523015b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f523014a.getClass();     // Catch: Throwable -> L6
            IHostRouterDepend r100 = c.a();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            IHostRouterDepend.a.a(r100, this.f523015b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f523016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f523017b;

        public b(c r100, IBDXBridgeContext r101) {
            this.f523016a = r100;
            this.f523017b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f523016a.getClass();     // Catch: Throwable -> L6
            IHostRouterDepend r100 = c.a();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            IHostRouterDepend.a.a(r100, this.f523017b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static IHostRouterDepend a() {
        XBaseRuntime.f270095a.getClass();
        return XBaseRuntime.f270102h;
    }

    public c() {
        this.f523013d = CollectionsKt.listOf(new String[]{"sslocal://lynxview", "sslocal://webview", "sslocal://lynxview_popup", "sslocal://webview_popup", "aweme://lynxview", "aweme://webview", "aweme://lynxview_popup", "aweme://webview_popup", "bullet://bullet", "sslocal://flower/lynxview", "sslocal://flower/webview", "sslocal://polaris/lynxview", "sslocal://polaris/webview", "sslocal://polaris/lynx", "sslocal://polaris/lynx_page", "sslocal://polaris/lynx_popup", "sslocal://polaris/lynxview_popup", "sslocal://polaris/webview", "sslocal://polaris/webview_popup", "sslocal://polaris/proxy"});
    }

    public final void b(IBDXBridgeContext r210, oe7.a.b r211, CompletionBlock<oe7.a.c> r212) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r211, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        String r110 = r211.getSchema();
        boolean r111 = r211.getReplace();
        boolean r112 = r211.getUseSysBrowser();
        Map<String, Object> r113 = r211.getExtra();
        com.bytedance.ies.bullet.base.utils.logger.a r114 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r114.a("session_id", r210.getContainerID());
        r114.a(FailedBinderCallBack.CALLER_ID, r210.getCallId());
        Integer r100 = 0;
        if (h.f246501h.f246502a == false) goto L10;
        if (r112 == true) goto L10;
        if (StringsKt.startsWith$default(r110, "https://", false, 2, null) == false) goto L10;
        Activity r101 = r210.getOwnerActivity();
        if (r101 == null) goto L10;
        Toast.makeText(r101, "不支持以https开头的schema,请确认使用 \"sslocal://webview\" 或者 \"aweme://webview\" 格式schema", 1).show();
    L10:
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.k("BridgeParam", "x.openParam", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", r110), TuplesKt.to("replace", Boolean.valueOf(r111)), TuplesKt.to("useSysBrowser", Boolean.valueOf(r112)), TuplesKt.to("replaceType", r211.getReplaceType()), TuplesKt.to("starterSessionId", r210.getContainerID())}), r114);
        if (r110.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        HybridLogger.g("BridgeParam", "schema should not be empty", MapsKt.mapOf(TuplesKt.to("schema", r110)), r114);
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "schema should not be empty", null, 4, null);
        return;
    L17:
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        g r105 = (g) x26.a.a(g.class);
        if (r105 == null) goto L24;
        e r106 = (e) r105.n0(e.class);
        if (r106 == null) goto L24;
        List<String> r107 = r106.x2();
        if (r107 == null) goto L24;
    L25:
        this.f523013d = r107;
        String r108 = r210.getContainerID();
        String r109 = r210.getCallId();
        Iterator r115 = this.f523013d.iterator();
    L27:
        if (r115.hasNext() == false) goto L32;
        Integer r213 = r100;
        Iterator r116 = r115;
        if (StringsKt.startsWith$default(r110, (String) r115.next(), false, 2, null) == true) goto L30;
        r115 = r116;
        r100 = r213;
        goto L27
    L30:
        String r117 = UriProtector.parse(r110).buildUpon().appendQueryParameter("__bullet_trident_starter_session_id", r108).appendQueryParameter("__bullet_trident_call_id", r109).build().toString();
    L33:
        HybridLogger r118 = HybridLogger.f246343a;
        HybridLogger.k("BridgeParam", "x.open transformSchema", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", r110), TuplesKt.to("realSchema", r117)}), r114);
        Activity r119 = r210.getOwnerActivity();
        if (r119 != null) goto L36;
        char r214 = 0;
        int r120 = 2;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Context not provided in host", null, 4, null);
        Unit r121 = Unit.INSTANCE;
    L37:
        Pair[] r122 = new Pair[3];
        r122[r214] = TuplesKt.to("useSysBrowser", Boolean.valueOf(r112));
        if (r113 != null) goto L40;
        r113 = MapsKt.emptyMap();
    L40:
        r122[1] = TuplesKt.to("extra", r113);
        r122[r120] = TuplesKt.to("open_schema_with_replace", Boolean.valueOf(r111));
        Map<String, ? extends Object> r123 = MapsKt.mapOf(r122);
        if (r111 == true) goto L50;
        IHostRouterDepend r124 = a();
        if (r124 == null) goto L45;
        boolean r125 = r124.openSchema(r210, r117, r123, r119);
    L46:
        if (r125 == false) goto L48;
        oe7.a.c r126 = (oe7.a.c) ne7.e.c(Reflection.getOrCreateKotlinClass(oe7.a.c.class));
        Pair[] r127 = new Pair[r120];
        r127[r214] = TuplesKt.to("success", Boolean.valueOf(r125));
        r127[1] = TuplesKt.to("bridgeCallBack", String.valueOf(r126.convert()));
        HybridLogger.g("BridgeResult", "x.openResult", MapsKt.mapOf(r127), r114);
        CompletionBlock.DefaultImpls.onSuccess$default(r212, r126, null, r120, null);
        return;
    L48:
        Pair[] r128 = new Pair[3];
        r128[r214] = TuplesKt.to("success", Boolean.valueOf(r125));
        r128[1] = TuplesKt.to("code", r213);
        r128[r120] = TuplesKt.to("message", "Failed to open schema: ".concat(r110));
        HybridLogger.g("BridgeResult", "x.openResult", MapsKt.mapOf(r128), r114);
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Failed to open schema: ".concat(r110), null, 4, null);
        return;
    L45:
        r125 = false;
        goto L46
    L50:
        String r129 = r211.getReplaceType();
        int r130 = r129.hashCode();
        if (r130 == (-1465864472)) goto L83;
        if (r130 == 169053298) goto L74;
        if (r130 != 2116215581) goto L101;
        if (r129.equals("alwaysCloseAfterOpen") == false) goto L101;
        IHostRouterDepend r131 = a();
        if (r131 == null) goto L63;
        boolean r132 = r131.openSchema(r210, r117, r123, r119);
    L65:
        if (com.bytedance.android.anniex.lite.utils.c.g(r210) != null) goto L67;
    L69:
        boolean r215 = r132;
        IHostRouterDepend r133 = a();
        if (r133 == null) goto L72;
        IHostRouterDepend.a.a(r133, r210);
    L72:
        boolean r134 = r215;
    L102:
        if (r134 == false) goto L104;
        oe7.a.c r135 = (oe7.a.c) ne7.e.c(Reflection.getOrCreateKotlinClass(oe7.a.c.class));
        Pair[] r136 = new Pair[2];
        r136[r214] = TuplesKt.to("success", Boolean.valueOf(r134));
        r136[1] = TuplesKt.to("bridgeCallBack", String.valueOf(r135.convert()));
        HybridLogger.g("BridgeResult", "x.openResult", MapsKt.mapOf(r136), r114);
        CompletionBlock.DefaultImpls.onSuccess$default(r212, r135, null, 2, null);
        return;
    L104:
        Pair[] r137 = new Pair[3];
        r137[r214] = TuplesKt.to("success", Boolean.valueOf(r134));
        r137[1] = TuplesKt.to("code", r213);
        r137[2] = TuplesKt.to("message", "Failed to open schema: ".concat(r110));
        HybridLogger.g("BridgeResult", "x.openResult", MapsKt.mapOf(r137), r114);
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Failed to open schema: ".concat(r110), null, 4, null);
        return;
    L67:
        if (com.bytedance.ies.bullet.service.base.h.a() <= 0) goto L69;
        r215 = r132;
        new Handler(Looper.getMainLooper()).postDelayed(new a(this, r210), com.bytedance.ies.bullet.service.base.h.a());
        goto L72
    L63:
        r132 = false;
    L101:
        r134 = false;
        goto L102
    L74:
        if (r129.equals("alwaysCloseBeforeOpen") == false) goto L101;
        IHostRouterDepend r138 = a();
        if (r138 == null) goto L79;
        IHostRouterDepend.a.a(r138, r210);
    L79:
        IHostRouterDepend r139 = a();
        if (r139 == null) goto L101;
        r134 = r139.openSchema(r210, r117, r123, r119);
        goto L102
    L83:
        if (r129.equals("onlyCloseAfterOpenSucceed") == false) goto L101;
        IHostRouterDepend r140 = a();
        if (r140 != null) goto L88;
    L90:
        boolean r141 = false;
    L91:
        if (r141 == false) goto L101;
        if (com.bytedance.android.anniex.lite.utils.c.g(r210) != null) goto L95;
    L97:
        IHostRouterDepend r142 = a();
        if (r142 == null) goto L100;
        IHostRouterDepend.a.a(r142, r210);
    L100:
        r134 = true;
        goto L102
    L95:
        if (com.bytedance.ies.bullet.service.base.h.b() <= 0) goto L97;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, r210), com.bytedance.ies.bullet.service.base.h.b());
        goto L100
    L88:
        if (r140.openSchema(r210, r117, r123, r119) != true) goto L90;
        r141 = true;
        goto L91
    L36:
        r120 = 2;
        r214 = 0;
        goto L37
    L32:
        r213 = r100;
        r117 = r110;
    L24:
        r107 = this.f523013d;
        goto L25
    L13:
        r103 = false;
        goto L14
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b(r100, (oe7.a.b) r101, r102);
    }
}
