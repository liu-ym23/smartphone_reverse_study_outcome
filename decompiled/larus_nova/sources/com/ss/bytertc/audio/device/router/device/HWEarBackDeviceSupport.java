package com.ss.bytertc.audio.device.router.device;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* JADX INFO: loaded from: classes40.dex */
public class HWEarBackDeviceSupport implements IAudioKitCallback {
    private static final String TAG = "HWEarBackDeviceSupport";
    private WebRtcAudioEarBack earBack;
    private HwAudioKaraokeFeatureKit mHwAudioKaraokeFeatureKit;
    private HwAudioKit mHwAudioKit;
    private boolean mIsAudiokitBindSuccess;
    private boolean mIsAudiokitKaraokeBindSuccess;
    private String mResultType;
    private boolean mSupportLowLatencyEarBack;

    private void initAudioKit() {
        if (this.mIsAudiokitBindSuccess == true) goto L5;
    L8:
        HwAudioKit r100 = new HwAudioKit(ContextUtils.getApplicationContext(), this);
        this.mHwAudioKit = r100;
        r100.initialize();
        return;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L8;
        onDeviceSupported(HWGetKaraokeSupport());
    }

    private void initKaraokeFeature() {
        HwAudioKit r100 = this.mHwAudioKit;
        if (r100 == null) goto L6;
        this.mHwAudioKaraokeFeatureKit = (HwAudioKaraokeFeatureKit) r100.createFeature(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
        return;
    }

    public void HWDestroy() {
        if (this.mIsAudiokitBindSuccess == true) goto L5;
        return;
    L5:
        if (this.mHwAudioKit == null) goto L12;
        printLog("HWDestroy");
        HwAudioKaraokeFeatureKit r100 = this.mHwAudioKaraokeFeatureKit;
        if (r100 == null) goto L9;
        r100.destroy();
        this.mIsAudiokitKaraokeBindSuccess = false;
    L9:
        this.mHwAudioKit.destroy();
        this.mIsAudiokitBindSuccess = false;
        return;
    }

    public void HWEarBack_init() {
        printLog("HWEarBack_init");
        initAudioKit();
    }

    public boolean HWGetKaraokeSupport() {
        HwAudioKaraokeFeatureKit r100 = this.mHwAudioKaraokeFeatureKit;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        return r100.isKaraokeFeatureSupport();
    }

    public int getLatency() {
        HwAudioKaraokeFeatureKit r100 = this.mHwAudioKaraokeFeatureKit;
        if (r100 != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        return r100.getKaraokeLatency();
    }

    public HWEarBackDeviceSupport(WebRtcAudioEarBack r100) {
        this.mResultType = "";
        this.mIsAudiokitBindSuccess = false;
        this.mIsAudiokitKaraokeBindSuccess = false;
        this.mSupportLowLatencyEarBack = true;
        this.earBack = r100;
    }

    private void printLog(String r100) {
        RXLogging.i(TAG, "HWEarBackDeviceSupport:" + r100);
    }

    public int HWEnableKaraoke(boolean r100) {
        if (this.mHwAudioKaraokeFeatureKit != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        printLog("HWEnableKaraoke enable=" + r100);
        return this.mHwAudioKaraokeFeatureKit.enableKaraokeFeature(r100);
    }

    public int HWSetEffectMode(int r100) {
        if (this.mHwAudioKaraokeFeatureKit != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        printLog("HWSetEffectMode value=" + r100);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, r100);
    }

    public int HWSetEqualizerMode(int r100) {
        if (this.mHwAudioKaraokeFeatureKit != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        printLog("HWSetEqualizerMode value=" + r100);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, r100);
    }

    public void onDeviceSupported(boolean r100) {
        WebRtcAudioEarBack r101 = this.earBack;
        if (r101 == null) goto L6;
        r101.onHardwareEarbackSupported(r100);
        return;
    }

    @Override // com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback
    public void onResult(int r100) {
        printLog(String.format("onResult result=%d", new Object[]{Integer.valueOf(r100)}));
        if (r100 != 0) goto L5;
        initKaraokeFeature();
        this.mIsAudiokitBindSuccess = true;
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mIsAudiokitBindSuccess = false;
        this.mIsAudiokitKaraokeBindSuccess = false;
        onDeviceSupported(false);
        return;
    L7:
        if (r100 != 4) goto L9;
    L22:
        this.mIsAudiokitBindSuccess = false;
        return;
    L9:
        if (r100 == 6) goto L22;
        if (r100 != 1003) goto L13;
    L21:
        this.mIsAudiokitKaraokeBindSuccess = false;
        return;
    L13:
        if (r100 != 1806) goto L15;
        onDeviceSupported(false);
        return;
    L15:
        if (r100 != 1000) goto L17;
        this.mIsAudiokitKaraokeBindSuccess = true;
        setVolume(90);
        onDeviceSupported(HWGetKaraokeSupport());
        return;
    L17:
        if (r100 == 1001) goto L21;
    }

    public int setVolume(int r100) {
        if (this.mHwAudioKaraokeFeatureKit != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsAudiokitKaraokeBindSuccess == false) goto L7;
        printLog("setVolume volome=" + r100);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_VOLUME_BASE, r100);
    }
}
