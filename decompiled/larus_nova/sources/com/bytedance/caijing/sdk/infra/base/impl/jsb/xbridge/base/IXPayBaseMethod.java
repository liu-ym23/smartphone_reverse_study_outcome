package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base;

import android.content.Context;
import android.util.Log;
import cd4.m;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.h5jsb.geninfo.CJJsbError;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.ContainerUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public abstract class IXPayBaseMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f202606g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<CJHostService> f202607h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<AppLogService> f202608i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<Map<String, ? extends Object>> f202609j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ALogService f202610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public XBridgePlatformType f202611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<m> f202612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f202613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f202614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f202615f;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(Map<String, Object> r100, String r101);

        void success(Map<String, Object> r100);
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IXPayBaseMethod f202616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f202617b;

        @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod.b
        public final void success(Map<String, Object> r110) {
            Intrinsics.checkNotNullParameter(r110, "successRet");
            r110.put("cj_jsb_native_callback_timestamp", Long.valueOf(System.currentTimeMillis()));
            IXPayBaseMethod r100 = this.f202616a;
            XBridgeMethod.Callback r101 = this.f202617b;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            if (r110.get("msg") != null) goto L6;
        L8:
            XCoreBridgeMethod.onSuccess$default(r100, r101, r110, null, 4, null);     // Catch: Throwable -> L11
        L9:
            Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            IXPayBaseMethod r104 = this.f202616a;
            XBridgeMethod.Callback r105 = this.f202617b;
            if (Result.m9452exceptionOrNullimpl(r103) == null) goto L19;
            XCoreBridgeMethod.onSuccess$default(r104, r105, r110, null, 4, null);
            return;
        L19:
            return;
        L6:
            if ((r110.get("msg") instanceof String) == false) goto L8;
            r100.onSuccess(r101, r110, String.valueOf(r110.get("msg")));     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }

        public c(IXPayBaseMethod r100, XBridgeMethod.Callback r101) {
            this.f202616a = r100;
            this.f202617b = r101;
        }

        @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod.b
        public final void a(Map<String, Object> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "ret");
            r100.put("cj_jsb_native_callback_timestamp", Long.valueOf(System.currentTimeMillis()));
            IXPayBaseMethod r102 = this.f202616a;
            XBridgeMethod.Callback r103 = this.f202617b;
            if (r101 != null) goto L5;
            r101 = "fail";
        L5:
            r102.onFailure(r103, 0, r101, r100);
        }
    }

    public abstract void e(Context r100, JSONObject r101, c r102);

    static {
        new a();
        f202606g = new AtomicBoolean(false);
        f202607h = LazyKt.lazy(IXPayBaseMethod$Companion$hostService$2.INSTANCE);
        f202608i = LazyKt.lazy(IXPayBaseMethod$Companion$eventService$2.INSTANCE);
        f202609j = LazyKt.lazy(IXPayBaseMethod$Companion$commonEventParams$2.INSTANCE);
    }

    public final cd4.e f() {
        return (cd4.e) this.f202613d.getValue();
    }

    public IXPayBaseMethod() {
        this.f202610a = (ALogService) ve4.b.b(ALogService.class);
        this.f202612c = new ArrayList();
        this.f202613d = LazyKt.lazy(new IXPayBaseMethod$bulletHelper$2(this));
        this.f202614e = LazyKt.lazy(IXPayBaseMethod$cjHostService$2.INSTANCE);
        this.f202615f = "default";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        super.release();
        Iterator<T> r100 = this.f202612c.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        m r101 = (m) r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        r101.release();     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
    }

    public static com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.b g(IXPayBaseMethod r100, c r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        return new com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.b(r100, false, r101);
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        if (f202606g.getAndSet(true) == true) goto L8;
        CJHostService r100 = f202607h.getValue();
        if (r100 == null) goto L7;
        r100.getEnvController();
    L7:
        ContainerUtils r101 = ContainerUtils.f202693a;
        MapsKt.toMap((Map) ContainerUtils.f202694b.getValue());
    L8:
        ALogService r102 = this.f202610a;
        if (r102 == null) goto L142;
        r102.i("IXPayBaseMethod", "invoke " + getName());
    L142:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L28
        if (r110.hasKey("useProviderFactoryContext") == false) goto L16;
        boolean r104 = r110.getBoolean("useProviderFactoryContext");     // Catch: Throwable -> L28
    L138:
    L26:
        th = move-exception;
        Throwable th10 = th;
        boolean r105 = false;
    L30:
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L31:
        if (r104 == false) goto L37;
        cd4.e r107 = f();
        if (r107 == null) goto L36;
        Context r108 = r107.provideContext();
        if (r108 == null) goto L36;
    L38:
        IHostLogDepend r109 = null;
        if (r108 == null) goto L134;
    L83:
        if (r108 != null) goto L86;
        onFailure(r111, 0, "Context not provided in host", new LinkedHashMap());
        return;
    L86:
        this.f202611b = r112;
        Intrinsics.checkNotNullParameter(r110, "params");
        int r113 = com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.d.f202707a;
        Intrinsics.checkNotNullParameter(r110, "params");
        JSONObject r114 = new JSONObject(s.h(r110));     // Catch: Exception -> L89
    L140:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L119
        CJHostService r116 = (CJHostService) this.f202614e.getValue();     // Catch: Throwable -> L119
        if (r116 == null) goto L94;
        KtSafeMethodExtensionKt.safePut(r114, com.bytedance.android.ec.core.event.a.KEY_DID, r116.getDeviceId());     // Catch: Throwable -> L119
        KtSafeMethodExtensionKt.safePut(r114, "aid", StringsKt.toIntOrNull(r116.getHostAid()));     // Catch: Throwable -> L119
    L94:
        r56.c r117 = (r56.c) provideContext(r56.c.class);     // Catch: Throwable -> L119
        if (r117 == null) goto L98;
        IHostContextDepend r118 = r117.f536314b;     // Catch: Throwable -> L119
        if (r118 == null) goto L98;
    L102:
        if (r118 == null) goto L117;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_DID, r118.getDeviceId());     // Catch: Throwable -> L119
        r114.put("aid", r118.getAppId());     // Catch: Throwable -> L119
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L119
        r119.put("channel", r118.getChannel());     // Catch: Throwable -> L119
        r56.c r120 = (r56.c) provideContext(r56.c.class);     // Catch: Throwable -> L119
        if (r120 == null) goto L109;
        IHostLogDepend r121 = r120.f536313a;     // Catch: Throwable -> L119
        if (r121 == null) goto L109;
        r109 = r121;
    L112:
        if (r109 == null) goto L116;
        HashMap r122 = new HashMap();     // Catch: Throwable -> L119
        r109.putCommonParams(r122, true);     // Catch: Throwable -> L119
        if (r122.containsKey(WsConstants.KEY_INSTALL_ID) == false) goto L116;
        r119.put(WsConstants.KEY_INSTALL_ID, r122.get(WsConstants.KEY_INSTALL_ID));     // Catch: Throwable -> L119
    L116:
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L119
        r114.put("riskInfoParams", r119);     // Catch: Throwable -> L119
    L109:
        r56.c r124 = r56.c.f536312g;     // Catch: Throwable -> L119
        if (r124 == null) goto L112;
        r109 = r124.f536313a;     // Catch: Throwable -> L119
    L117:
        Result.m9449constructorimpl(r114.put("cj_jsb_native_invoke_timestamp", System.currentTimeMillis()));     // Catch: Throwable -> L119
    L144:
        e(r108, r114, new c(this, r111));     // Catch: Throwable -> L123
        return;
    L123:
        th = move-exception;
        onFailure(r111, 0, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("code", -1), TuplesKt.to("msg", "exception:" + th)}));
        ALogService r125 = this.f202610a;
        if (r125 == null) goto L127;
        r125.e("IXPayBaseMethod", Log.getStackTraceString(th));
    L127:
        CJJsbError.f202601a.getClass();
        of4.b r126 = (of4.b) CJJsbError.f202603c.getValue();
        String r127 = th.toString();
        r126.getClass();
        if (r127 != null) goto L130;
        r127 = "";
    L130:
        r126.f523100b = r127;
        return;
    L98:
        r56.c r128 = r56.c.f536312g;     // Catch: Throwable -> L119
        if (r128 == null) goto L101;
        r118 = r128.f536314b;     // Catch: Throwable -> L119
        goto L102
    L101:
        r118 = null;
    L119:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L89:
        r114 = new JSONObject();
        goto L140
    L134:
        Context r130 = (Context) provideContext(Context.class);     // Catch: Throwable -> L72
        if (r130 == null) goto L44;
        this.f202615f = "1";     // Catch: Throwable -> L72
    L45:
        if (r130 != null) goto L52;
        gd4.a r131 = (gd4.a) provideContext(gd4.a.class);     // Catch: Throwable -> L72
        if (r131 == null) goto L51;
        r130 = r131.getContext();     // Catch: Throwable -> L72
        if (r130 == null) goto L51;
        this.f202615f = "2";     // Catch: Throwable -> L72
    L51:
        r130 = null;
    L52:
        if (r130 != null) goto L61;
        cd4.e r132 = f();     // Catch: Throwable -> L72
        if (r132 == null) goto L60;
        gd4.a r133 = r132.f();     // Catch: Throwable -> L72
        if (r133 == null) goto L60;
        r130 = r133.getContext();     // Catch: Throwable -> L72
        if (r130 == null) goto L60;
        this.f202615f = "3";     // Catch: Throwable -> L72
    L60:
        r130 = null;
    L61:
        if (r130 != null) goto L68;
        CallContext r134 = (CallContext) provideContext(CallContext.class);     // Catch: Throwable -> L72
        if (r134 == null) goto L67;
        r130 = r134.getContext();     // Catch: Throwable -> L72
        if (r130 == null) goto L67;
        this.f202615f = "4";     // Catch: Throwable -> L72
    L67:
        r130 = null;
    L68:
        ALogService r135 = this.f202610a;     // Catch: Throwable -> L72
        if (r135 == null) goto L71;
        r135.e("IXPayBaseMethod", "cjpay fallbackProvideContext: " + this.f202615f + ", context: " + r130);     // Catch: Throwable -> L72
    L71:
        r108 = r130;
    L74:
        if (r108 != null) goto L83;
        if (r105 == false) goto L77;
        Object r136 = this;
    L78:
        if (r136 == null) goto L82;
        CJHostService r137 = (CJHostService) ve4.b.b(CJHostService.class);
        if (r137 == null) goto L82;
        r108 = r137.getHostApplication();
    L82:
        r108 = null;
        goto L83
    L77:
        r136 = null;
        goto L78
    L44:
        r130 = null;
    L72:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r108 = null;
    L36:
        r108 = (Context) provideContext(Context.class);
        goto L38
    L37:
        r108 = (Context) provideContext(Context.class);
        goto L38
    L18:
        if (r110.hasKey("fallbackApplicationContext") == false) goto L21;
        r105 = r110.getBoolean("fallbackApplicationContext");     // Catch: Throwable -> L26
    L136:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L24:
        th10 = th;
        goto L30
    L21:
        r105 = false;
        goto L136
    L16:
        r104 = false;
    L28:
        th = move-exception;
        th10 = th;
        r105 = false;
        r104 = false;
        goto L30
    }
}
