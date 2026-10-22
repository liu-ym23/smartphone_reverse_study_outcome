package com.ss.bytertc.audio.device.router.device;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.hihonor.android.magicx.media.audio.interfaces.HnAudioClient;
import com.hihonor.android.magicx.media.audio.interfaces.HnEarReturnClient;
import com.hihonor.android.magicx.media.audio.interfaces.IAudioServiceCallback;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class HnEarBackDeviceSupport implements IAudioServiceCallback {
    private static final String TAG = "HnEarBackDeviceSupport";
    private WebRtcAudioEarBack earBack;
    private HnAudioClient mHnAudioClient;
    private HnEarReturnClient mHnEarReturnClient;
    private boolean mIsAudiokitBindSuccess;
    private boolean mIsEarReturnBindSuccess;

    public int HnGetLatency() {
        return -1;
    }

    public void HnDestroy() {
        printLog("HnDestroy");
        HnAudioClient r100 = this.mHnAudioClient;
        if (r100 == null) goto L5;
        r100.destroy();
        this.mHnAudioClient = null;
    L5:
        HnEarReturnClient r101 = this.mHnEarReturnClient;
        if (r101 == null) goto L8;
        r101.destroy();
        this.mHnEarReturnClient = null;
    L8:
        this.mIsEarReturnBindSuccess = false;
    }

    public void HnInitHnEarReturnClient() {
        if (this.mHnAudioClient != null) goto L5;
        return;
    L5:
        printLog("HnInitHnEarReturnClient");
        List r100 = this.mHnAudioClient.getSupportedServices();
        if (r100 != null) goto L8;
    L16:
        printLog("service != HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN.getServiceType()");
        onDeviceSupported(false);
        return;
    L8:
        if (r100.size() <= 0) goto L16;
        Iterator r101 = r100.iterator();
    L11:
        if (r101.hasNext() == false) goto L16;
        if (((Integer) r101.next()).intValue() != HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN.getServiceType()) goto L11;
        this.mHnEarReturnClient = this.mHnAudioClient.createService(HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN);
    }

    public boolean HnIsEarReturnSupport() {
        if (this.mHnEarReturnClient != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsEarReturnBindSuccess == false) goto L7;
        printLog("HnIsEarReturnSupport: false");
        return this.mHnEarReturnClient.isServiceSupported();
    }

    public void HnInitAudioClient() {
        if (HnAudioClient.isDeviceSupported(ContextUtils.getApplicationContext()) == false) goto L5;
        printLog("HnInitAudioClient");
        HnAudioClient r100 = new HnAudioClient(ContextUtils.getApplicationContext(), this);
        this.mHnAudioClient = r100;
        r100.initialize();
        return;
    L5:
        onDeviceSupported(false);
    }

    public HnEarBackDeviceSupport(WebRtcAudioEarBack r100) {
        this.mHnAudioClient = null;
        this.mHnEarReturnClient = null;
        this.mIsAudiokitBindSuccess = false;
        this.mIsEarReturnBindSuccess = false;
        this.earBack = r100;
    }

    private void printLog(String r100) {
        RXLogging.i(TAG, "HnEarBackDeviceSupport:" + r100);
    }

    public int HnEnableEarReturn(boolean r100) {
        if (this.mHnEarReturnClient != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsEarReturnBindSuccess == false) goto L7;
        printLog("HnEnableEarReturn=" + r100);
        return this.mHnEarReturnClient.enableEarReturn(r100);
    }

    public int HnSetEffectMode(int r100) {
        if (this.mHnEarReturnClient != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsEarReturnBindSuccess == false) goto L7;
        printLog("HnSetEffectMode=" + r100);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, r100);
    }

    public int HnSetEqualizer(int r100) {
        if (this.mHnEarReturnClient != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsEarReturnBindSuccess == false) goto L7;
        printLog("HnSetEqualizer=" + r100);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, r100);
    }

    public int HnSetVocalVolume(int r100) {
        if (this.mHnEarReturnClient != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.mIsEarReturnBindSuccess == false) goto L7;
        printLog("HnSetVocalVolume=" + r100);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_VOCAL_VOLUME_BASE, r100);
    }

    public void onDeviceSupported(boolean r100) {
        if (this.earBack == null) goto L6;
        printLog("Hn onDeviceSupported: " + r100);
        this.earBack.onHardwareEarbackSupported(r100);
        return;
    }

    public void onResult(int r100) {
        printLog(String.format("onResult result=%d", new Object[]{Integer.valueOf(r100)}));
        if (r100 != 0) goto L5;
        HnInitHnEarReturnClient();
        this.mIsAudiokitBindSuccess = true;
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mIsEarReturnBindSuccess = false;
        this.mIsAudiokitBindSuccess = false;
        onDeviceSupported(false);
        return;
    L7:
        if (r100 != 4) goto L9;
    L25:
        this.mIsAudiokitBindSuccess = false;
        return;
    L9:
        if (r100 != 1003) goto L11;
    L24:
        this.mIsEarReturnBindSuccess = false;
        return;
    L11:
        if (r100 != 1806) goto L13;
        onDeviceSupported(false);
        return;
    L13:
        if (r100 == 6) goto L25;
        if (r100 != 7) goto L17;
        onDeviceSupported(false);
        return;
    L17:
        if (r100 != 1000) goto L19;
        this.mIsEarReturnBindSuccess = true;
        HnSetVocalVolume(90);
        onDeviceSupported(HnIsEarReturnSupport());
        return;
    L19:
        if (r100 == 1001) goto L24;
    }
}
