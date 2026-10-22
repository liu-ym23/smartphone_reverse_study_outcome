package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.j0;
import com.larus.platform.api.l1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/StartNavigationMethod;", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL$StartNavigationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL$StartNavigationResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartNavigationMethod extends AbsStartNavigationMethodIDL {
    public static f3.h<Object> a;
    public static final a b = null;

    public static final class a implements j0 {
        public a() {
        }
    }

    public static final class b {
    }

    static {
        b = new a();
    }

    public StartNavigationMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, f3.h r13) {
        AbsStartNavigationMethodIDL.a r14 = (AbsStartNavigationMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r0 = null;
        if (r14.getTo().getLng() != null) goto L5;
    L37:
        f3.h.a.a(r13, "Invalid parameter. destination coordinate required", null, null, 14);
        return;
    L5:
        if (r14.getTo().getLat() == null) goto L37;
        String r15 = r14.getMethod();
        String r1 = "walking";
        if (Intrinsics.areEqual(r15, "walking") == false) goto L10;
    L9:
        String r7 = r1;
        NaviPoi r16 = r14.getFrom();
        if (r16 != null) goto L17;
        Pair r4 = null;
    L24:
        Double r17 = r14.getTo().getLat();
        double r2 = 0.0d;
        if (r17 == null) goto L27;
        double r8 = r17.doubleValue();
    L28:
        Double r18 = Double.valueOf(r8);
        Double r3 = r14.getTo().getLng();
        if (r3 == null) goto L31;
        r2 = r3.doubleValue();
    L31:
        Pair r6 = new Pair(r18, Double.valueOf(r2));
        a = r13;
        l1 r5 = com.larus.platform.service.b.a();
        if (r5 == null) goto L39;
        NaviPoi r19 = r14.getFrom();
        if (r19 == null) goto L36;
        r0 = r19.getName();
    L36:
        r5.d(r0, r4, r14.getTo().getName(), r6, r7, r14.getPolicy(), b);
        return;
    L39:
        return;
    L27:
        r8 = 0.0d;
        goto L28
    L17:
        if (r16.getLng() != null) goto L19;
    L21:
        Pair r9 = null;
    L22:
        r4 = r9;
        goto L24
    L19:
        if (r16.getLat() == null) goto L21;
        r9 = new Pair(r16.getLat(), r16.getLng());
        goto L22
    L10:
        r1 = "riding";
        if (Intrinsics.areEqual(r15, "riding") == true) goto L9;
        r1 = "driving";
        goto L9
    }
}
