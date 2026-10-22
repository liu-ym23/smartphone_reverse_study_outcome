package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.container.IBulletService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.preRender")
public final class XPayPreRenderMethod extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202626k;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/jsb/xbridge/bridge/XPayPreRenderMethod$ActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "ONLY_PRERENDER", "PRERENDER_AND_OPEN", "cj-host-service-impl-jsb_release"}, k = 1, mv = {1, 6, 0})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType ONLY_PRERENDER = null;
        public static final ActionType PRERENDER_AND_OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f202627a = null;
        private final String type;

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) f202627a.clone();
        }

        static {
            ActionType r100 = new ActionType("ONLY_PRERENDER", 0, "onlyPreRender");
            ONLY_PRERENDER = r100;
            ActionType r101 = new ActionType("PRERENDER_AND_OPEN", 1, "preRenderAndOpen");
            PRERENDER_AND_OPEN = r101;
            f202627a = new ActionType[]{r100, r101};
        }

        public final String getType() {
            return this.type;
        }

        public ActionType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public XPayPreRenderMethod() {
        this.f202626k = "ttcjpay.preRender";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202626k;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(final Context r210, JSONObject r211, IXPayBaseMethod.c r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        ve4.a.f554342a.getClass();
        PlugInContainerService r100 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        Object r101 = null;
        if (r100 == null) goto L7;
        ee4.c r102 = r100.getJSBHelper();
        if (r102 == null) goto L7;
        cd4.m r103 = r102.getXJSB(this.f202626k);
    L8:
        if (r103 == null) goto L11;
        r103.handle(r210, r211, IXPayBaseMethod.g(this, r212));
    L11:
        if (r211.optBoolean("is_anniex_flow", false) == false) goto L46;
        Activity r104 = CJPayBasicExtensionKt.toActivity(r210);
        String r105 = r211.optString("schema", "");
        String r106 = r211.optString("bid", "");
        if (r104 != null) goto L15;
    L29:
        if (r104 != null) goto L31;
        String r107 = "invalid activity ";
    L33:
        if (r105.length() != 0) goto L35;
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r107 = r107.concat("schema ");
    L39:
        if (r106.length() != 0) goto L41;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L44;
        r107 = r107 + "bid ";
    L44:
        r212.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "0"), TuplesKt.to("render_error_msg", r107)}), r107);
        return;
    L41:
        r109 = false;
        goto L42
    L35:
        r108 = false;
        goto L36
    L31:
        r107 = "invalid ";
        goto L33
    L15:
        if (r105.length() != 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == true) goto L29;
        if (r106.length() != 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L29;
        IBulletService r112 = (IBulletService) ve4.a.a(IBulletService.class);
        if (r112 == null) goto L28;
        r101 = r112.anniexDispatchFlow(r104.getApplication(), r106, UriProtector.parse(r105));
    L28:
        r212.success(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "1"), TuplesKt.to("session_id", String.valueOf(r101))}));
        return;
    L22:
        r111 = false;
        goto L23
    L17:
        r110 = false;
        goto L18
    L46:
        if (r103 != null) goto L67;
        Activity r113 = CJPayBasicExtensionKt.toActivity(r210);
        final String r114 = r211.optString("schema");
        long r115 = r211.optLong("cache_time", 10000);
        String r116 = r211.optString("action_type", "onlyPreRender");
        ActionType r117 = ActionType.ONLY_PRERENDER;
        if (Intrinsics.areEqual(r116, r117.getType()) == true) goto L53;
        ActionType r118 = ActionType.PRERENDER_AND_OPEN;
        if (Intrinsics.areEqual(r116, r118.getType()) == false) goto L53;
        r117 = r118;
    L53:
        ActionType r213 = r117;
        long r119 = r211.optLong("wait_render_time", 5000);
        final String r120 = r211.optString("openSchema", "");
        final AtomicBoolean r121 = new AtomicBoolean(false);
        Function0<Unit> r122 = new XPayPreRenderMethod$callNative$openFunction$1(r121, r120, r210, r114);
        if (r113 == null) goto L63;
        IBulletService r123 = (IBulletService) ve4.a.a(IBulletService.class);
        if (r123 == null) goto L58;
        ActionType r124 = r213;
        r123.preRender(r114, r113, r115, new j0(r124, r122, r212));
    L60:
        if (r124 != ActionType.PRERENDER_AND_OPEN) goto L62;
        new Handler(Looper.getMainLooper()).postDelayed(new k0(r122), r119);
        r212.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "0"), TuplesKt.to("render_error_msg", "preRender timeout")}), "preRender timeout");
    L62:
        r101 = Unit.INSTANCE;
        goto L63
    L58:
        r124 = r213;
    L63:
        if (r101 != null) goto L68;
        r122.invoke();
        r212.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "0"), TuplesKt.to("render_error_msg", "context is not activity")}), "context is not activity");
        return;
    L68:
        return;
    L67:
        return;
    L7:
        r103 = null;
        goto L8
    }
}
