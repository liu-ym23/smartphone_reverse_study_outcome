package com.ss.android.vesdk.audio;

import com.dtf.face.log.RecordConst;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEAudioEncodeSettings;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEAudioCaptureHolder extends Enum<VEAudioCaptureHolder> implements VEAudioCaptureListener {
    private static final /* synthetic */ VEAudioCaptureHolder[] $VALUES = null;
    public static final VEAudioCaptureHolder INSTANCE = null;
    private static final String TAG = "AudioCaptureHolder";
    VEAudioCaptureListener mAudioDataInterface;
    private boolean mFeedPcm;
    efc.a mPresenter;
    VEAudioEncodeSettings mVEAudioEncodeSettings;

    private static /* synthetic */ VEAudioCaptureHolder[] $values() {
        return new VEAudioCaptureHolder[]{INSTANCE};
    }

    public void startFeedPCM() {
        this.mFeedPcm = true;
    }

    public void stopFeedPCM() {
        this.mFeedPcm = false;
    }

    static {
        INSTANCE = new VEAudioCaptureHolder("INSTANCE", 0);
        $VALUES = $values();
    }

    public static VEAudioCaptureHolder[] values() {
        return (VEAudioCaptureHolder[]) $VALUES.clone();
    }

    public static VEAudioCaptureHolder valueOf(String r100) {
        return (VEAudioCaptureHolder) r27.a.a(VEAudioCaptureHolder.class, r100);
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener
    public void onReceive(VEAudioSample r100) {
        if (this.mPresenter != null) goto L7;
        VELogUtil.e(TAG, "onReceiver error: please set buffer consumer, before init AudioCapture");
        return;
    L7:
        if (this.mFeedPcm == true) goto L11;
        VELogUtil.i(TAG, "pcm feed stop");
        return;
    L11:
        if ((r100.getSampleBuffer() instanceof VEAudioSample.a) == false) goto L13;
        efc.a r101 = this.mPresenter;
        byte[] r102 = ((VEAudioSample.a) r100.getSampleBuffer()).f455732a;
        r100.getByteSize();
        r100.getTimeStamp();
        r101.getClass();
        return;
    L13:
        VEAudioCaptureListener r103 = this.mAudioDataInterface;
        if (r103 == null) goto L18;
        r103.onReceive(r100);
        return;
    }

    public void setAudioEncodeSettings(VEAudioEncodeSettings r100) {
        this.mVEAudioEncodeSettings = r100;
    }

    private VEAudioCaptureHolder(String r100, int r101) {
        super(r100, r101);
        this.mFeedPcm = true;
    }

    public void setAudioBufferConsumer(efc.a r100, VEAudioCaptureListener r101) {
        this.mPresenter = r100;
        this.mAudioDataInterface = r101;
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public void onError(int r100, int r101, String r102) {
        VELogUtil.i(TAG, RecordConst.LOG_ERR_TYPE + r100 + "ret:" + r101 + "msg:" + r102);
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public void onInfo(int r100, int r101, double r110, Object r111) {
        if (r100 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT) goto L23;
        VEAudioCaptureListener r102 = this.mAudioDataInterface;
        if (r102 == null) goto L8;
        r102.onInfo(r100, r101, r110, r111);
    L8:
        if (r101 != 0) goto L18;
        VEAudioCaptureSettings r112 = (VEAudioCaptureSettings) r111;
        if (this.mVEAudioEncodeSettings != null) goto L13;
        VELogUtil.e(TAG, "please set VEAudioEncodeSettings, before init AudioCapture");
        return;
    L13:
        efc.a r103 = this.mPresenter;
        if (r103 != null) goto L17;
        VELogUtil.e(TAG, "please set buffer consumer, before init AudioCapture");
        return;
    L17:
        r112.getSampleRate();
        r112.getChannel();
        this.mVEAudioEncodeSettings.getSampleRate();
        this.mVEAudioEncodeSettings.getChannelCount();
        this.mVEAudioEncodeSettings.getBps();
        r103.getClass();
        VELogUtil.i(TAG, "mVEAudioCapture inited: channelCount:" + r112.getChannel() + " sampleHz:" + r112.getSampleRate() + " encode sample rate:" + this.mVEAudioEncodeSettings.getSampleRate() + " encode channel count:" + this.mVEAudioEncodeSettings.getChannelCount());
    L20:
        if (r100 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_START) goto L24;
        this.mFeedPcm = true;
        return;
    L24:
        return;
    L18:
        VELogUtil.i(TAG, "initAudio error:" + r101);
        goto L20
    }
}
