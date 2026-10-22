package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/StopBaiduNavigationMethod;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStopBaiduNavigationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStopBaiduNavigationIDL$StopNavigationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStopBaiduNavigationIDL$StopNavigationResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopBaiduNavigationMethod extends AbsStopBaiduNavigationIDL {
    public StopBaiduNavigationMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        AbsStopBaiduNavigationIDL.a r9 = (AbsStopBaiduNavigationIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (Intrinsics.areEqual(r9.isQuickRestart(), Boolean.TRUE) == false) goto L8;
        NavigationCallback r10 = NavigationCallback.l;
        if (r10 == null) goto L7;
        r10.c = true;
    L7:
        FLogger.a.i("navi_callback", "flow.stopNavigation isQuickRestart");
    L11:
        e.b("jsb");
        if (BaiduNaviServiceDelegate.b.a("jsb") == false) goto L28;
        String r11 = ev3.a.a;
        ev3.a.b(RealTimeNavEndReason.JSB, null, 2);
        NavigationCallback r12 = NavigationCallback.l;
        if (r12 != null) goto L16;
    L27:
        AbsStopBaiduNavigationIDL.b r13 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsStopBaiduNavigationIDL.b.class));
        AbsStopBaiduNavigationIDL.b r14 = r13;
        r14.setStatus(1);
        r14.setMessage(null);
        r8.b(r13, "");
        return;
    L16:
        if (r12.b == true) goto L18;
    L26:
        FLogger.a.i("navi_callback", "ignore actively stop tts due to quickRestart");
        goto L27
    L18:
        if (r12.c == true) goto L26;
        r12.e(AppHost.a.getApplication().getString(2131908060), true);
        FLogger.a.i("navi_callback", "actively stop tts triggered");
        if (r12.c == true) goto L23;
    L25:
        r12.b = false;
        goto L27
    L23:
        if (r12.b == false) goto L25;
    L28:
        AbsStopBaiduNavigationIDL.b r15 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsStopBaiduNavigationIDL.b.class));
        r15.setStatus(0);
        r15.setMessage(null);
        Unit r16 = Unit.INSTANCE;
        f3.h.a.a(r8, null, null, r15.toJson(), 7);
        return;
    L8:
        NavigationCallback r17 = NavigationCallback.l;
        if (r17 == null) goto L11;
        r17.c = false;
        goto L11
    }
}
