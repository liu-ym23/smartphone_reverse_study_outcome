package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.ss.bytertc.audio.device.router.device.KaraokeMediaHelper;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* JADX INFO: loaded from: classes40.dex */
public class XMEarback implements IHardWareEarback {
    private boolean isKtvDeviceOpened;
    private SlientPlayer slientPlayer;
    private WebRtcAudioEarBack webRtcAudioEarBack;
    private KaraokeMediaHelper xmKtvHelper;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean r100) {
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int r100) {
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        if (this.xmKtvHelper == null) goto L8;
        SlientPlayer r100 = this.slientPlayer;
        if (r100 == null) goto L10;
        r100.stop();
        this.xmKtvHelper.setPlayFeedbackParam(0);
        return 0;
    L10:
        return -1;
    L8:
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.xmKtvHelper = new KaraokeMediaHelper(ContextUtils.getApplicationContext());
        this.slientPlayer = new SlientPlayer();
        WebRtcAudioEarBack r100 = this.webRtcAudioEarBack;
        if (r100 == null) goto L7;
        r100.onHardwareEarbackSupported(isSupport());
        return 0;
    L7:
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        if (this.xmKtvHelper != null) goto L5;
        return -1;
    L5:
        if (this.slientPlayer != null) goto L7;
        return -1;
    L7:
        if (this.isKtvDeviceOpened == false) goto L9;
    L11:
        this.slientPlayer.play();
        this.xmKtvHelper.setPlayFeedbackParam(1);
        return 0;
    L9:
        if (isSupport() == false) goto L11;
        this.xmKtvHelper.openKTVDevice();
        this.isKtvDeviceOpened = true;
        goto L11
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        if (this.xmKtvHelper == null) goto L5;
        close();
        this.xmKtvHelper.closeKTVDevice();
        this.isKtvDeviceOpened = false;
    L5:
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        if (ContextUtils.getApplicationContext() != null) goto L5;
        return false;
    L5:
        KaraokeMediaHelper r100 = this.xmKtvHelper;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.isDeviceSupportKaraoke() == true) goto L10;
        return false;
    L10:
        if (this.xmKtvHelper.isAppSupportKaraoke(ContextUtils.getApplicationContext().getPackageName()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public XMEarback(WebRtcAudioEarBack r100) {
        this.isKtvDeviceOpened = false;
        this.webRtcAudioEarBack = r100;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int r100) {
        KaraokeMediaHelper r101 = this.xmKtvHelper;
        if (r101 == null) goto L6;
        r101.setFeedbackEffect(r100);
        return 0;
    L6:
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int r100) {
        KaraokeMediaHelper r101 = this.xmKtvHelper;
        if (r101 == null) goto L6;
        r101.setMicVolParam((int) ((((double) r100) * 15.0d) / 100.0d));
        return 0;
    L6:
        return -1;
    }
}
