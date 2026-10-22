package com.larus.dora.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements com.larus.dora.impl.network.l.b {
    public v() {
    }

    @Override // com.larus.dora.impl.network.l.b
    public final void onStatusChanged(int r100, int r101) {
        g49.d.d("DoraPreWakeUpTask", "WsStatusChanged: " + r100 + " -> " + r101);
    }
}
