package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.router.device.VivoKTVHelper;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* JADX INFO: loaded from: classes40.dex */
public class VivoEarback implements IHardWareEarback {
    private static final String TAG = null;
    private boolean isKtvDeviceOpened;
    private SlientPlayer slientPlayer;
    private VivoKTVHelper vivoKtvHelper;
    private WebRtcAudioEarBack webRtcAudioEarBack;

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

    static {
        TAG = VivoEarback.class.getName();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        if (this.vivoKtvHelper != null) goto L5;
        return -1;
    L5:
        if (this.slientPlayer == null) goto L10;
        printLog("close");
        this.slientPlayer.stop();
        this.vivoKtvHelper.setPlayFeedbackParam(0);
        this.vivoKtvHelper.setCustomMode(0);
        return 0;
    L10:
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.vivoKtvHelper = new VivoKTVHelper(ContextUtils.getApplicationContext());
        SlientPlayer r100 = new SlientPlayer();
        this.slientPlayer = r100;
        r100.setRequireDeepBuffer(false);
        boolean r101 = isSupport();
        WebRtcAudioEarBack r102 = this.webRtcAudioEarBack;
        if (r102 == null) goto L5;
        r102.onHardwareEarbackSupported(r101);
    L5:
        printLog("inited, isSupportHardwareEarback=" + r101);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        VivoKTVHelper r100 = this.vivoKtvHelper;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isDeviceSupportKaraoke();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        VivoKTVHelper r100 = this.vivoKtvHelper;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (this.slientPlayer != null) goto L7;
        return -1;
    L7:
        if (this.isKtvDeviceOpened == false) goto L9;
    L11:
        printLog("open");
        this.slientPlayer.play();
        this.vivoKtvHelper.setPlayFeedbackParam(1);
        return 0;
    L9:
        if (r100.isDeviceSupportKaraoke() == false) goto L11;
        this.vivoKtvHelper.openKTVDevice();
        this.isKtvDeviceOpened = true;
        goto L11
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        printLog("release");
        if (this.vivoKtvHelper == null) goto L5;
        close();
        this.vivoKtvHelper.closeKTVDevice();
        this.isKtvDeviceOpened = false;
    L5:
        return 0;
    }

    public VivoEarback(WebRtcAudioEarBack r100) {
        this.isKtvDeviceOpened = false;
        this.webRtcAudioEarBack = r100;
    }

    private void printLog(String r100) {
        String r101 = TAG;
        RXLogging.i(r101, r101 + ":" + r100);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int r100) {
        if (this.vivoKtvHelper == null) goto L11;
        printLog("setEffect value=" + r100);
        if (r100 >= 0) goto L7;
    L10:
        RXLogging.w(TAG, String.format("ByteAudioEarBackEffect vivo valid is [%d,%d], value is %d, ignore it", new Object[]{0, Integer.valueOf(this.vivoKtvHelper.getEffectSize()), Integer.valueOf(r100)}));
        goto L11
    L7:
        if (r100 > this.vivoKtvHelper.getEffectSize()) goto L10;
        this.vivoKtvHelper.setCustomMode(r100);
        return 0;
    L11:
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int r100) {
        if (this.vivoKtvHelper == null) goto L6;
        printLog("setVolume volume=" + r100);
        this.vivoKtvHelper.setMicVolParam((int) ((((double) r100) * 15.0d) / 100.0d));
        return 0;
    L6:
        return -1;
    }
}
