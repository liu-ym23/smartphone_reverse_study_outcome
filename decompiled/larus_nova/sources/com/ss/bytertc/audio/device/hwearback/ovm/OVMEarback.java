package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.BaseEarback;
import com.ss.bytertc.audio.device.hwearback.SlientPlayer;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class OVMEarback extends BaseEarback {
    private static final String TAG = "OVMEarback";
    private final OVMClient client;
    private boolean isAudioParamsSupported;
    private boolean isRecordingStarted;
    private final SlientPlayer slientPlayer;

    public static /* synthetic */ void a(OVMEarback r100, int r101) {
        r100.lambda$onInit$0(r101);
    }

    private synchronized void updatePlayerState() {
        monitor-enter(this);
        SlientPlayer r100 = this.slientPlayer;     // Catch: Throwable -> L20
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100.isPlaying() == false) goto L12;
        if (this.isRecordingStarted == false) goto L12;
    L13:
        boolean r101 = true;
    L15:
        if (r101 == false) goto L17;
        this.slientPlayer.play();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L17:
        this.slientPlayer.stop();     // Catch: Throwable -> L20
    L12:
        if (getState() == BaseEarback.EarbackState.RUNNING) goto L13;
        r101 = false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return -1;
    }

    private boolean checkAudioParams() {
        StringBuffer r100 = new StringBuffer("parse params: ");
        String r101 = this.client.getKaraokeSupportParameters();
        r100.append(this.client.getKaraokeSupportParameters());
        HardwareEarbackParams r102 = new DefaultHardwareParamsParser().parse(r101);
        if (r102 == null) goto L68;
        List<HardwareEarbackParams.Play> r103 = r102.playParamsList;
        if (r103 != null) goto L7;
    L37:
        r100.append(", playout params parsed null.");
        boolean r104 = false;
    L38:
        List<HardwareEarbackParams.Record> r105 = r102.recordParamsList;
        if (r105 != null) goto L41;
    L67:
        r100.append(", record params parsed null.");
        goto L68
    L41:
        if (r105.size() <= 0) goto L67;
        r100.append(", record params size: ");
        r100.append(r102.recordParamsList.size());
        Iterator<HardwareEarbackParams.Record> r106 = r102.recordParamsList.iterator();
        boolean r107 = false;
    L44:
        if (r106.hasNext() == false) goto L66;
        HardwareEarbackParams.Record r110 = r106.next();
        r100.append("{sampleRate: ");
        r100.append(r110.sampleRate);
        r100.append(", format: ");
        r100.append(r110.format);
        r100.append(", audioSource: ");
        r100.append(r110.source);
        r100.append(", flags: ");
        r100.append(r110.flags);
        r100.append(i.f25855d);
        if (r110.format == 2) goto L48;
    L55:
        boolean r111 = false;
    L57:
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM) goto L61;
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) goto L61;
    L65:
        r107 = r107 | r111;
    L61:
        if (r110.version <= 0) goto L63;
        boolean r112 = true;
    L64:
        r111 = r111 & r112;
        goto L65
    L63:
        r112 = false;
        goto L64
    L48:
        if (r110.sampleRate != 48000) goto L55;
        int r113 = r110.source;
        if (r113 == 1) goto L53;
        if (r113 != 0) goto L55;
    L53:
        if ((r110.flags & 1) != 1) goto L55;
        r111 = true;
        goto L57
    L66:
        boolean r108 = r104 & r107;
    L69:
        r100.append(", canOpenEarback: ");
        r100.append(r108);
        RXLogging.i(TAG, r100.toString());
        return r108;
    L7:
        if (r103.size() <= 0) goto L37;
        r100.append(", playout params size: ");
        r100.append(r102.playParamsList.size());
        Iterator<HardwareEarbackParams.Play> r109 = r102.playParamsList.iterator();
        boolean r114 = false;
    L10:
        if (r109.hasNext() == false) goto L36;
        HardwareEarbackParams.Play r115 = r109.next();
        r100.append("{streamType: ");
        r100.append(r115.streamType);
        r100.append(", sampleRate: ");
        r100.append(r115.sampleRate);
        r100.append(", format: ");
        r100.append(r115.format);
        r100.append(", flags: ");
        r100.append(r115.flags);
        r100.append(i.f25855d);
        if (r115.streamType == 3) goto L14;
    L19:
        boolean r116 = false;
    L21:
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM) goto L25;
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) goto L25;
    L29:
        r114 = r114 | r116;
        if (r114 == false) goto L10;
        RXLogging.i(TAG, "updating slientPlayer params: " + r115.sampleRate + ", " + r115.flags);
        this.slientPlayer.setSampleRate(r115.sampleRate);
        SlientPlayer r117 = this.slientPlayer;
        if ((r115.flags & 8) != 8) goto L34;
        boolean r118 = true;
    L35:
        r117.setRequireDeepBuffer(r118);
        goto L36
    L34:
        r118 = false;
    L25:
        if (r115.version <= 0) goto L27;
        boolean r119 = true;
    L28:
        r116 = r116 & r119;
        goto L29
    L27:
        r119 = false;
        goto L28
    L14:
        if (r115.format != 2) goto L19;
        int r120 = r115.sampleRate;
        if (r120 == 44100) goto L18;
        if (r120 != 48000) goto L19;
    L18:
        r116 = true;
    L36:
        r104 = true & r114;
    L68:
        r108 = false;
        goto L69
    }

    private String getReportParameters() {
        String r100 = this.client.getKaraokeSupportParameters();
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L5
        r101.put("version", this.client.getVersion());     // Catch: Throwable -> L5
        return r101.toString();
    L5:
        RXLogging.e(TAG, "parse report params error, not json format");
        return r100;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onClose() {
        this.client.setPlayFeedbackParam(0);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public void onInit() {
        this.client.setAuthCallback(new d(this));
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onIsSupportCall() {
        if (this.client.isSupportedAndAuth() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isAudioParamsSupported == false) goto L7;
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onOpen() {
        this.client.setPlayFeedbackParam(1);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public void onRelease() {
        this.client.setPlayFeedbackParam(0);
        this.client.setMixerSoundType(0);
        this.client.setEqualizerType(0);
        this.client.closeKTVDevice();
        this.client.release();
    }

    private /* synthetic */ void lambda$onInit$0(int r100) {
        RXLogging.i(TAG, "connection result: " + r100);
        if (r100 != 1001) goto L5;
        this.client.openKTVDevice();
        this.client.resetKTVParamsAndUpdate();
        this.webRtcAudioEarBack.onHardwareEarbackSupportParamsGet(getReportParameters());
        this.isAudioParamsSupported = checkAudioParams();
        onInitResult(true);
        return;
    L5:
        onInitResult(false);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean r100) {
        if (r100 == false) goto L4;
        this.isRecordingStarted = true;
        updatePlayerState();
        return;
    L4:
        this.isRecordingStarted = false;
        updatePlayerState();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int r100) {
        this.client.setMixerSoundType(r100);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int r100) {
        this.client.setEqualizerType(r100);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int r100) {
        if (ManufacturerChecker.getManufacturerType() != ManufacturerChecker.Type.OP) goto L5;
        int r101 = 12;
    L6:
        this.client.setMicVolParam(Math.max(Math.min((int) ((r100 / 100.0f) * r101), r101), 0));
        return 0;
    L5:
        r101 = 15;
        goto L6
    }

    public OVMEarback(Context r100, WebRtcAudioEarBack r101) {
        super(r100, r101);
        this.isRecordingStarted = true;
        this.isAudioParamsSupported = false;
        this.client = OVMClient.initialize(r100);
        this.slientPlayer = new SlientPlayer();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public synchronized void onStateChanged(BaseEarback.EarbackState r100, BaseEarback.EarbackState r101) {
        monitor-enter(this);
        super.onStateChanged(r100, r101);     // Catch: Throwable -> L6
        updatePlayerState();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
