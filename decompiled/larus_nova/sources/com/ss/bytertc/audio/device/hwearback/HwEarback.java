package com.ss.bytertc.audio.device.hwearback;

import com.ss.bytertc.audio.device.router.device.HWEarBackDeviceSupport;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* JADX INFO: loaded from: classes40.dex */
public class HwEarback implements IHardWareEarback {
    private HWEarBackDeviceSupport hwEarback;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean r100) {
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        return this.hwEarback.HWEnableKaraoke(false);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return this.hwEarback.getLatency();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.hwEarback.HWEarBack_init();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        return this.hwEarback.HWGetKaraokeSupport();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        return this.hwEarback.HWEnableKaraoke(true);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        close();
        this.hwEarback.HWDestroy();
        return 0;
    }

    public HwEarback(WebRtcAudioEarBack r100) {
        this.hwEarback = null;
        this.hwEarback = new HWEarBackDeviceSupport(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int r100) {
        return this.hwEarback.HWSetEffectMode(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int r100) {
        return this.hwEarback.HWSetEqualizerMode(r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int r100) {
        return this.hwEarback.setVolume(r100);
    }
}
