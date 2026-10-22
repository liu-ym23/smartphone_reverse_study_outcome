package com.obric.assistant.audio;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements IObricDeviceStateService.a {
    public j() {
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onUserPresent() {
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onScreenOff() {
        Lazy r100 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.f385621e = true;
        Lazy r101 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.c("screenOff");
        FLogger.f375446a.i("ObricAudioConnectionStatusMonitor", "onScreenOff");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService.a
    public final void onScreenOn() {
        Lazy r100 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.f385621e = false;
        Lazy r101 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.d("onScreenOn");
        FLogger.f375446a.i("ObricAudioConnectionStatusMonitor", "onScreenOn");
    }
}
