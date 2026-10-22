package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderCommonUseBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BridgetLynxComponent implements c {
    public static final /* synthetic */ int h = 0;
    public l a;
    public boolean b;
    public final Map<String, d> c;
    public final Map<String, String> d;
    public final Context e;
    public final ViewGroup f;
    public final eg3.a g;

    public static final class a {
    }

    static {
    }

    public final OrderCommonBusinessMonitor b() {
        eg3.a r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.T50();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c
    public final void preload() {
        if (this.a != null) goto L5;
    L6:
        final long r1 = System.currentTimeMillis();
        OrderCommonBusinessMonitor r3 = b();
        l r4 = null;
        if (r3 == null) goto L9;
        r3.a = System.currentTimeMillis();
        r3.c("load_lynx_bridge_start", null);
    L9:
        Context r6 = this.e;
        String r7 = ECSettingKeys.F().getLynxBridgeUrl();
        JSONObject r5 = new JSONObject();
        r5.put("module_param", new JSONObject());
        r5.put("mob_data", new JSONObject());
        Unit r8 = Unit.INSTANCE;
        Map<String, Object> r9 = com.bytedance.android.shopping.hybrid.a.b(r5);
        ViewGroup r10 = this.f;
        if (r10 != null) goto L12;
        r10 = new FrameLayout(this.e);
    L12:
        l r11 = ECLiveHybridUtil.b(r6, r7, r9, r10, new b(this), null, null, false, null, null, false, 4064);
        if (r11 == null) goto L15;
        r11.registerMethod("sendNativeBridgeCommandResult", new com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.a(this));
        r4 = r11;
    L15:
        this.a = r4;
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.c("BridgetLynxComponent", new AnonymousClass1(r1));
        return;
    L5:
        if (this.b == false) goto L6;
    }

    public BridgetLynxComponent(Context r1, eg3.a r2) {
        this.e = r1;
        this.f = null;
        this.g = r2;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c
    public final void a(final String r4, final JSONObject r5, OrderCommonUseBridgeFunction$onExecuteAsync$1.a r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "bridgeParams");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("BridgetLynxComponent", new BridgetLynxComponent$useBridge$1(r4, r5));
        if (this.a != null) goto L5;
        OrderCommonLog.c("BridgetLynxComponent", BridgetLynxComponent$useBridge$2.INSTANCE);
        preload();
    L5:
        String r1 = UUID.randomUUID().toString();
        if (r6 == null) goto L8;
        this.c.put(r1, r6);
    L8:
        this.d.put(r1, r4);
        OrderCommonBusinessMonitor r7 = b();
        if (r7 == null) goto L11;
        r7.n(r4);
    L11:
        l r8 = this.a;
        if (r8 == null) goto L15;
        JSONObject r2 = new JSONObject();
        r2.put("session_id", r1);
        r2.put("bridge_name", r4);
        r2.put("bridge_params", r5);
        Unit r9 = Unit.INSTANCE;
        r8.sendJsEvent("repeatNativeBridgeCommand", r2);
        return;
    }
}
