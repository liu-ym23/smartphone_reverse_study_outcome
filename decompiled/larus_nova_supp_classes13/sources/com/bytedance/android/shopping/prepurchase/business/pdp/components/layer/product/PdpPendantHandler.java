package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.content.res.Resources;
import com.bytedance.android.shopping.hybrid.bridges.ShowTaskBannerMethod;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpPendantHandler {
    public static final /* synthetic */ int f = 0;
    public String a;
    public final o b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e c;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j e;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
        public final /* synthetic */ PdpPendantHandler a;

        public b(PdpPendantHandler r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
        public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3, Lifecycle.Event r4) {
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4 != Lifecycle.Event.ON_DESTROY) goto L6;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.g.c(this.a.d.e(), "IESLiveKit_ecom_pendant_close_event", this.a.b);
        L6:
            if (r4 != Lifecycle.Event.ON_PAUSE) goto L9;
            this.a.c("onPause containerId=" + this.a.a);
            PdpPendantHandler.a(this.a, 1);
        L9:
            if (r4 != Lifecycle.Event.ON_RESUME) goto L12;
            this.a.c("onResume containerId=" + this.a.a);
            PdpPendantHandler.a(this.a, 0);
            return;
        }
    }

    static {
    }

    public final void b(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        JSONObject r0 = r11.optJSONObject("frame");
        if (r0 == null) goto L9;
        boolean r1 = Intrinsics.areEqual(r0.optString("gravity", "right"), "right");
        double r5 = r0.optDouble("width", 86.0d);
        double r2 = r0.optDouble("height", 86.0d);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r4 = this.d.getContainerAbility().i7();
        int r7 = zh.a.a;
        Integer r8 = Integer.valueOf(r4.d);
        Intrinsics.checkNotNullParameter(r8, "$this$asDip");
        float r9 = r8.intValue();
        Resources r10 = Resources.getSystem();
        int r12 = ((int) (r9 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density)) + 106;
        if (r1 == false) goto L7;
        double r13 = ((double) (com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r4.a)) + 0)) - r5;
    L8:
        r0.put("x", r13);
        r0.put("y", ((double) (com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r4.b)) - r12)) - r2);
        goto L9
    L7:
        r13 = 0.0d;
    L9:
        int r3 = ShowTaskBannerMethod.e;
        ShowTaskBannerMethod.a.a(this.d.getContainerAbility().mo2525getContext(), r11, new PdpPendantHandler$handle$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.a(this.d.e(), "IESLiveKit_ecom_pendant_close_event", this.b);
        this.c.getLifecycle().a(new b(this));
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.d.w7().d("Detail", "pdp_pendant " + r4);
    }

    public static final void a(PdpPendantHandler r3, int r4) {
        String r0 = r3.a;
        if (r0 == null) goto L6;
        LynxAbilityImpl r5 = r3.d.e().D0();
        JSONObject r1 = new JSONObject();
        r1.put("type", r4);
        r1.put("containerID", r0);
        Unit r6 = Unit.INSTANCE;
        r5.B("ecom.task.banner.timing", r1);
        return;
    }

    public PdpPendantHandler(ProductDetailInfoComponent r2, com.bytedance.android.shopping.prepurchase.arch.container.c r3, com.bytedance.android.shopping.prepurchase.arch.container.component.j r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "serviceRegistry");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.b = new o(this);
    }
}
