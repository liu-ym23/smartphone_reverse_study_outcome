package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 extends com.larus.dora.impl.util.t0 {
    public k0() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        super.onDoraLinkStateChanged(r100, r101, r102);
        if (r100 == null) goto L11;
        String r103 = r100.f204389mac;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r102 != 2) goto L12;
        l0.f332216a.remove(r103);
        Map<String, String> r104 = l0.f332216a;
        l0.f332219d.set(false);
        return;
    L12:
        return;
    }
}
