package com.larus.audio;

import com.larus.platform.api.m4;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements m4 {
    public v() {
    }

    @Override // com.larus.platform.api.m4
    public final void S1() {
        FLogger.f375446a.e("AudioConnectionStateManager", "onMinorModeOn");
        AudioConnectionStateManager r100 = AudioConnectionStateManager.f288277a;
        r100.getClass();
        AudioConnectionStateManager.e(false);
        AudioConnectionStateManager.a(r100);
    }

    @Override // com.larus.platform.api.m4
    public final void b1() {
        FLogger.f375446a.e("AudioConnectionStateManager", "onMinorModeOff");
        AudioConnectionStateManager r100 = AudioConnectionStateManager.f288277a;
        r100.getClass();
        AudioConnectionStateManager.e(false);
        AudioConnectionStateManager.a(r100);
    }
}
