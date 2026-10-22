package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends com.larus.dora.impl.util.t0 {
    public n() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        super.onDoraLinkStateChanged(r100, r101, r102);
        if (r102 != 0) goto L8;
        g49.d.d("DoraBtStatusManager", "onDoraLinkStateChanged: device disconnected, reset bt state to 0");
        int r103 = o.f332220a.getAndSet(0);
        if (r103 == 0) goto L9;
        o.a(r103, 0);
        return;
    L9:
        return;
    }
}
