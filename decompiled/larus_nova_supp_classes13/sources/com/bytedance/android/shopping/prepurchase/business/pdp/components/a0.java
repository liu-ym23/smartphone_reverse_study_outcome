package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ PdpRootComponent a;

    public a0(PdpRootComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        PdpRootComponent r0 = this.a;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        r1.put("is_full", r5);
        r1.put("identifier", r0.g2().getSessionId());
        Unit r6 = Unit.INSTANCE;
        ECLiveHybridUtil.f("pdp_screen_status_change", r1);
    }
}
