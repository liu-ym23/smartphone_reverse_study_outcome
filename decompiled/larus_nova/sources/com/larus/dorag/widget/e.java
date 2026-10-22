package com.larus.dorag.widget;

import com.larus.network.util.ScreenStateManager;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements ScreenStateManager.b {
    public e() {
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOff() {
        f.f341000c = true;
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOn() {
        f.f341000c = false;
        String r100 = f.f340998a;
        f.a();
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onUserPresent() {
    }
}
