package com.bytedance.applet.aibridge.navi;

import android.app.Dialog;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.t0;
import e3.d;
import f3.h;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rv3.f;
import rv3.g;
import yv3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/CloseNavigationPopupMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsCloseNavigationPopupIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navi/AbsCloseNavigationPopupIDL$CloseNavigationPopupParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navi/AbsCloseNavigationPopupIDL$CloseNavigationPopupResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseNavigationPopupMethod extends AbsCloseNavigationPopupIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public CloseNavigationPopupMethod() {
    }

    public final void handle(d r3, ParamModel r4, final h r5) {
        AbsCloseNavigationPopupIDL.a r6 = (AbsCloseNavigationPopupIDL.a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        final com.larus.lbs.trace.api.a r7 = new com.larus.lbs.trace.api.a(c.c(r6.getTraceContext()), "lbs_client_doubao_close_navi_dialog");
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/doubao.closeNavigationPopup] (no params)");
        final long r0 = OpenNavigationMapMethod.c.incrementAndGet();
        WeakReference<Dialog> r8 = com.bytedance.applet.aibridge.navi.picker.a.a;
        Function0 r9 = new f(r0);
        Function1 r1 = new g(r7, r5);
        Intrinsics.checkNotNullParameter(r9, "shouldClose");
        Intrinsics.checkNotNullParameter(r1, "onClosed");
        t0.e(new sv3.f(r9, r1));
    }
}
