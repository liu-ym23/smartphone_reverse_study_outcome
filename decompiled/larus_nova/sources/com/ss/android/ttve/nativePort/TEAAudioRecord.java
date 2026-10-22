package com.ss.android.ttve.nativePort;

import android.os.Handler;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.audio.VEAudioDevice;
import com.ss.android.vesdk.audio.i;

/* JADX INFO: loaded from: classes38.dex */
public class TEAAudioRecord implements com.ss.android.vesdk.audio.b {
    private static final String TAG = null;
    private long mAudioCallbackHandle;
    private VEAudioCaptureSettings mAudioCaptureSettings;
    private com.ss.android.vesdk.audio.d mCallback;
    private long mHandle;

    public void dataCallback(byte[] r100, int r101) {
    }

    @Override // com.ss.android.vesdk.audio.a
    public int init(VEAudioCaptureSettings r100) {
        return 0;
    }

    public void release() {
    }

    @Override // com.ss.android.vesdk.audio.a
    public void release(Object r100) {
    }

    @Override // com.ss.android.vesdk.audio.b
    public void setAudioCallback(com.ss.android.vesdk.audio.d r100) {
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
        return 0;
    }

    @Override // com.ss.android.vesdk.audio.a
    public int start(Object r100) {
        return 0;
    }

    public int stop() {
        return 0;
    }

    @Override // com.ss.android.vesdk.audio.a
    public int stop(Object r100) {
        return 0;
    }

    static {
        TAG = "TEAAudioRecord";
        TENativeLibsLoader.loadRecorder();
    }

    public TEAAudioRecord() {
        this.mAudioCallbackHandle = 0;
    }
}
