package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.k0;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgePreloadMediaResourceMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL$PreloadMediaResourceParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL$PreloadMediaResourceResultModel;", "preloadUrl", "preloadViewModel", "Companion", "PreloadCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgePreloadMediaResourceMethod extends AbsAIBridgePreloadMediaResourceMethodIDL {

    public static final class a {
    }

    public static final class b implements k0 {
        public final f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> a;

        public b(f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.a = r2;
        }

        public final void a(yq9.c r4) {
            Intrinsics.checkNotNullParameter(r4, "info");
            int r0 = r4.a;
            if (r0 != 2) goto L5;
            f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r5 = this.a;
            Intrinsics.checkNotNullParameter(AbsAIBridgePreloadMediaResourceMethodIDL.b.class, "<this>");
            f3.h.a.b(r5, k3.c.a(AbsAIBridgePreloadMediaResourceMethodIDL.b.class));
            return;
        L5:
            if (r0 != 3) goto L7;
        L9:
            f3.h.a.a(this.a, "preload fails with infoKey: " + r4.a, null, null, 14);
            return;
        L7:
            if (r0 == 5) goto L9;
        }
    }

    static {
    }

    public AIBridgePreloadMediaResourceMethod() {
    }

    public final void handle(e3.d r9, ParamModel r10, f3.h r11) {
        AbsAIBridgePreloadMediaResourceMethodIDL.a r1 = (AbsAIBridgePreloadMediaResourceMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = r1.getResourceType();
        long r4 = 512000;
        if (Intrinsics.areEqual(r12, "url") == false) goto L12;
        Long r13 = r1.getPreloadSize();
        if (r13 == null) goto L7;
        r4 = r13.longValue();
    L7:
        Lazy r14 = q3.a;
        z3 r15 = q3.a();
        if (r15 != null) goto L10;
        f3.h.a.a(r11, "getVideoControllerService fails", null, null, 14);
        return;
    L10:
        int r0 = d88.a.a;
        r15.i(new yq9.d(d88.a.a(r1.getResource()), r4, r1.getResource()), new b(r11));
        return;
    L12:
        if (Intrinsics.areEqual(r12, "videoModel") == false) goto L24;
        Long r16 = r1.getPreloadSize();
        if (r16 == null) goto L16;
        long r5 = r16.longValue();
    L17:
        String r17 = r1.getResolution();
        if (r17 != null) goto L20;
        r17 = "medium";
    L20:
        String r6 = i.a.k(r17);
        Lazy r18 = q3.a;
        z3 r19 = q3.a();
        if (r19 != null) goto L23;
        f3.h.a.a(r11, "getVideoControllerService fails", null, null, 14);
        return;
    L23:
        r19.f(r1.getResource(), new k(r1, r11, r19, r6, r5));
        return;
    L16:
        r5 = 512000;
        goto L17
    L24:
        f3.h.a.a(r11, "wrong resourceType", null, null, 14);
    }
}
