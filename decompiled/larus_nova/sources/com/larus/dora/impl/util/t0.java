package com.larus.dora.impl.util;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.larus.apm.api.IApmTrace;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t0 implements IDoraLinkCallback {
    public t0() {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onBtStateChanged(int r100, int r101) {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onDeviceFound(DoraDevice r100) {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onScanFailed(int r100) {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        if (r102 != 0) goto L5;
        IApmTrace.f286937a.d("connect_state", "DORA_DISCONNECT");
        return;
    L5:
        if (r102 != 2) goto L11;
        IApmTrace.f286937a.d("connect_state", "DORA_CONNECT");
        return;
    }
}
