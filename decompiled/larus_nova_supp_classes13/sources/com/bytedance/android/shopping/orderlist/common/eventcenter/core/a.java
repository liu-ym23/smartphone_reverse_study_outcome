package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import android.view.View;
import c53.d;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.controller.o;
import com.bytedance.android.shopping.orderlist.common.controller.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderSelfRegisterBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.kmp.ec.yata.store.node.c;
import eg3.b;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface a {
    void A0(Map<String, String> r1);

    void B0();

    OrderFreqControlManager C0();

    d D0();

    com.bytedance.android.shopping.orderlist.common.monitor.error.a E0();

    void F0();

    boolean G0();

    b H0();

    void I0(j0 r1);

    void J0(Function0<Unit> r1);

    void K0(float r1);

    void L0(String r1, w r2);

    void M0(JSONObject r1);

    void N0(String r1, String r2);

    void O0(JSONObject r1);

    Map<String, Map<String, Object>> P0();

    void Q0();

    void R0();

    ig3.a S0();

    View T0();

    void U0(String r1);

    SlcRenderContext f();

    String getCurrentSessionId();

    void t0();

    void u0(int r1);

    void v0(int r1, boolean r2);

    void w0();

    void x0(String r1, o r2);

    void y0(String r1, OrderSelfRegisterBridgeFunction$onExecuteAsync$1.a r2);

    void z0(c r1);
}
