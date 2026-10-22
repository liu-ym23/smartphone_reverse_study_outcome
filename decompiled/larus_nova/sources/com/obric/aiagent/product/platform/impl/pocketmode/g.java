package com.obric.aiagent.product.platform.impl.pocketmode;

import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends CommonPocketModeDetector {

    public static final class a {
    }

    static {
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean e() {
        ILogDepend.f384986a.d("GRPocketModeDetector", "isPocketModeManuallyDismissed() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void g() {
        ILogDepend.f384986a.d("GRPocketModeDetector", "showProximityNearAlert() called, do nothing");
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean h() {
        ILogDepend.f384986a.d("GRPocketModeDetector", "isPocketModeEnabled() return false");
        return false;
    }

    public g() {
    }
}
