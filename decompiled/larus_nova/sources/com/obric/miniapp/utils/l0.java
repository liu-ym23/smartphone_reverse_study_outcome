package com.obric.miniapp.utils;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;

/* JADX INFO: loaded from: classes33.dex */
public final class l0 implements IObricDeviceStateService.a {
    public l0() {
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onScreenOff() {
        FLogger.f375446a.d("DevicePowerManager", "onScreenOff");
        k0.d("screenOff");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onScreenOn() {
        FLogger.f375446a.d("DevicePowerManager", "onScreenOn");
        k0.d("screenOn");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onUserPresent() {
        FLogger.f375446a.d("DevicePowerManager", "onUserPresent");
        k0.d("userPresent");
    }
}
