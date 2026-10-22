package com.ss.bytertc.audio.device.hwearback;

import com.ss.bytertc.audio.device.router.device.HnEarBackDeviceSupport;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* JADX INFO: loaded from: classes40.dex */
public class HnEarback implements IHardWareEarback {
    private HnEarBackDeviceSupport hnEarback;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean r100) {
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        return this.hnEarback.HnEnableEarReturn(false);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return this.hnEarback.HnGetLatency();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.hnEarback.HnInitAudioClient();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        return this.hnEarback.HnIsEarReturnSupport();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        return this.hnEarback.HnEnableEarReturn(true);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        close();
        this.hnEarback.HnDestroy();
        return 0;
    }

    public HnEarback(WebRtcAudioEarBack r100) {
        this.hnEarback = null;
        this.hnEarback = new HnEarBackDeviceSupport(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int r100) {
        return this.hnEarback.HnSetEffectMode(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int r100) {
        return this.hnEarback.HnSetEqualizer(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int r100) {
        return this.hnEarback.HnSetVocalVolume(r100);
    }
}
