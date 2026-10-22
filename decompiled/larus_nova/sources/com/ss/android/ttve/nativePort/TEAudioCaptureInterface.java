package com.ss.android.ttve.nativePort;

import android.os.Handler;
import com.ss.android.ttve.model.VEAudioDeviceType;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.audio.VEAudioDevice;
import com.ss.android.vesdk.audio.i;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioCaptureInterface implements com.ss.android.vesdk.audio.b {
    private com.ss.android.vesdk.audio.d mCallback;
    private long mHandle;

    public TEAudioCaptureInterface() {
    }

    private native long nativeCreate(boolean r100, boolean r101);

    private native int nativeDestroy(long r100);

    private native int nativeInit(long r100, int r101, int r102, int r103, int r104);

    private native int nativeStart(long r100);

    private native int nativeStop(long r100);

    public void release() {
        release(null);
    }

    public void setAudioDevice(VEAudioDevice r100) {
    }

    @Override // com.ss.android.vesdk.audio.b
    public void setHandler(Handler r100) {
    }

    @Override // com.ss.android.vesdk.audio.b
    public void setNativeAudioDataCallback(i r100) {
    }

    public int start() {
        return start(null);
    }

    public int stop() {
        return stop(null);
    }

    static {
        TENativeLibsLoader.loadRecorder();
    }

    @Override // com.ss.android.vesdk.audio.a
    public int init(VEAudioCaptureSettings r110) {
        if (TESystemUtils.getOutputAudioDeviceType() != VEAudioDeviceType.WIRED.ordinal()) goto L5;
        boolean r100 = true;
    L6:
        long r101 = nativeCreate(r110.isEnableSysKaraoke(), r100);
        this.mHandle = r101;
        int r102 = nativeInit(r101, r110.getSampleRate(), r110.getChannel(), r110.getBitSamples(), r110.getFramesPerBuffer());
        com.ss.android.vesdk.audio.d r103 = this.mCallback;
        if (r103 == null) goto L9;
        r103.a(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT, r102, r110);
    L9:
        return r102;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.audio.a
    public void release(Object r100) {
        nativeDestroy(this.mHandle);
        this.mHandle = 0;
    }

    @Override // com.ss.android.vesdk.audio.b
    public void setAudioCallback(com.ss.android.vesdk.audio.d r100) {
        this.mCallback = r100;
    }

    @Override // com.ss.android.vesdk.audio.a
    public int start(Object r100) {
        int r101 = nativeStart(this.mHandle);
        com.ss.android.vesdk.audio.d r102 = this.mCallback;
        if (r102 == null) goto L5;
        r102.a(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_START, r101, "");
    L5:
        return r101;
    }

    @Override // com.ss.android.vesdk.audio.a
    public int stop(Object r100) {
        return nativeStop(this.mHandle);
    }

    public void onNativeExtCallback(int r100, int r101) {
        com.ss.android.vesdk.audio.d r102 = this.mCallback;
        if (r102 == null) goto L9;
        int r103 = VEInfo.TE_ERROR_RECORD_AUDIO_CAPTURE;
        if (r100 != r103) goto L7;
        r102.onError(r103, r101, "");
        return;
    L7:
        r102.a(r100, r101, "");
        return;
    }
}
