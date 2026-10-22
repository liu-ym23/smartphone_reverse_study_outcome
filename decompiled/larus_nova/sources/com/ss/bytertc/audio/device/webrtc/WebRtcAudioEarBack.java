package com.ss.bytertc.audio.device.webrtc;

import android.os.Build;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.HardwareEarbackPackageChecker;
import com.ss.bytertc.audio.device.hwearback.HnEarback;
import com.ss.bytertc.audio.device.hwearback.HwEarback;
import com.ss.bytertc.audio.device.hwearback.IHardWareEarback;
import com.ss.bytertc.audio.device.hwearback.VivoEarback;
import com.ss.bytertc.audio.device.hwearback.XMEarback;
import com.ss.bytertc.audio.device.hwearback.ovm.OVMEarback;

/* JADX INFO: loaded from: classes40.dex */
public class WebRtcAudioEarBack {
    private WebRtcAudioManager audioManager;
    private int curEffect;
    private int curEq;
    private int curVolume;
    IHardWareEarback hardWareEarback;

    public int ByteAudioEarBackGetLatency() {
        IHardWareEarback r100 = this.hardWareEarback;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getLatency();
    L12:
        return -1;
    L7:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor get latency is not support", th);
        return -1;
    }

    public boolean ByteAudioEarBackSupport() {
        IHardWareEarback r100 = this.hardWareEarback;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.isSupport();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor get earback is not support", th);
        return false;
    }

    public void ByteAudioEarBackInit() {
        if (this.hardWareEarback != null) goto L24;
        ManufacturerChecker.Type r100 = ManufacturerChecker.getManufacturerType(Build.BRAND);
        if (r100 != ManufacturerChecker.Type.HW) goto L7;
    L8:
        this.hardWareEarback = createHWEarback();
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L19;
        if (r100 != ManufacturerChecker.Type.OP) goto L14;
    L17:
        this.hardWareEarback = new OVMEarback(ContextUtils.getApplicationContext(), this);
        goto L24
    L14:
        if (r100 == ManufacturerChecker.Type.XM) goto L17;
        if (r100 == ManufacturerChecker.Type.RM) goto L17;
    L19:
        if (r100 != ManufacturerChecker.Type.VO) goto L22;
        this.hardWareEarback = new VivoEarback(this);
        goto L24
    L22:
        if (r100 != ManufacturerChecker.Type.XM) goto L24;
        this.hardWareEarback = new XMEarback(this);
        goto L24
    L7:
        if (r100 != ManufacturerChecker.Type.HR) goto L10;
    L24:
        IHardWareEarback r101 = this.hardWareEarback;
        if (r101 == null) goto L27;
        r101.init();
        return;
    L27:
        onHardwareEarbackSupported(false);
    }

    public void ByteAudioEarBackRelease() {
        IHardWareEarback r100 = this.hardWareEarback;
        if (r100 == null) goto L6;
        r100.release();
        onHardwareEarbackReleased(true);
        return;
    }

    private IHardWareEarback createHWEarback() {
        if (HardwareEarbackPackageChecker.isHnEarbackPackageSupported() == false) goto L7;
        return new HnEarback(this);
    L7:
        if (HardwareEarbackPackageChecker.isHwEarbackPackageSupported() == true) goto L9;
        return null;
    L9:
        return new HwEarback(this);
    }

    public WebRtcAudioEarBack(WebRtcAudioManager r100) {
        this.curVolume = -1;
        this.curEffect = -1;
        this.curEq = -1;
        this.audioManager = r100;
    }

    public void ByteAudioEarBackEffect(int r100) {
        this.curEffect = r100;     // Catch: Throwable -> L6
        IHardWareEarback r101 = this.hardWareEarback;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setEffect(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set effect is not support", th);
    }

    public int ByteAudioEarBackEnable(boolean r100) {
        IHardWareEarback r101 = this.hardWareEarback;     // Catch: Throwable -> L21
        if (r101 == null) goto L29;
        if (r100 == false) goto L30;
        int r102 = r101.open();     // Catch: Throwable -> L21
        int r103 = this.curVolume;     // Catch: Throwable -> L17
        if (r103 == (-1)) goto L10;
        ByteAudioEarBackSetVolume(r103);     // Catch: Throwable -> L17
    L10:
        int r104 = this.curEq;     // Catch: Throwable -> L17
        if (r104 == (-1)) goto L13;
        ByteAudioEarBackEqualizer(r104);     // Catch: Throwable -> L17
    L13:
        int r105 = this.curEffect;     // Catch: Throwable -> L17
        if (r105 == (-1)) goto L25;
        ByteAudioEarBackEffect(r105);     // Catch: Throwable -> L17
    L25:
        return r102;
    L17:
        Throwable th10 = th;
    L23:
        th10.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor enable earback is not support", th10);
        goto L25
    L30:
        return r101.close();
    L29:
        return -1;
    L21:
        th = move-exception;
        th10 = th;
        r102 = -1;
        goto L23
    }

    public void ByteAudioEarBackEqualizer(int r100) {
        this.curEq = r100;     // Catch: Throwable -> L6
        IHardWareEarback r101 = this.hardWareEarback;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setEqualizer(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set eq is not support", th);
    }

    public int ByteAudioEarBackSetVolume(int r100) {
        this.curVolume = r100;     // Catch: Throwable -> L7
        IHardWareEarback r101 = this.hardWareEarback;     // Catch: Throwable -> L7
        if (r101 == null) goto L12;
        return r101.setVolume(r100);
    L12:
        return -1;
    L7:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set volume is not support", th);
        return -1;
    }

    public void notifyEarbackRecordStateChanged(boolean r100) {
        IHardWareEarback r101 = this.hardWareEarback;
        if (r101 == null) goto L6;
        r101.notifyEarbackRecordStateChanged(r100);
        return;
    }

    public void onHardwareEarbackReleased(boolean r100) {
        WebRtcAudioManager r101 = this.audioManager;
        if (r101 == null) goto L6;
        r101.onHardwareEarbackReleased(r100);
        return;
    }

    public void onHardwareEarbackSupportParamsGet(String r100) {
        WebRtcAudioManager r101 = this.audioManager;
        if (r101 == null) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r101.onHardwareEarbackSupportParamsGet(r100);
        return;
    }

    public void onHardwareEarbackSupported(boolean r100) {
        WebRtcAudioManager r101 = this.audioManager;
        if (r101 == null) goto L6;
        r101.onHardwareEarbackSupported(r100);
        return;
    }
}
