package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.audio.VEAudioCaptureListener;
import com.ss.android.vesdk.audio.VEAudioSample;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioDataInterface implements VEAudioCaptureListener {
    private long handle;
    private VEAudioCaptureSettings mAudioCaptureSettings;

    private native long nativeCreate();

    private native int nativeInit(long r100, int r101, int r102, int r103);

    private native void nativeRelease(long r100);

    private native int nativeSendArrayData(long r100, byte[] r101, int r102, long r103, long r104);

    private native int nativeSendBufferData(long r100, ByteBuffer r101, int r102, long r103, long r104);

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public void onError(int r100, int r101, String r102) {
    }

    public synchronized void release() {
        monitor-enter(this);
        long r100 = this.handle;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        nativeRelease(r100);     // Catch: Throwable -> L8
        this.handle = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public TEAudioDataInterface() {
        this.handle = nativeCreate();
    }

    static {
        TENativeLibsLoader.loadRecorder();
    }

    public long getHandle() {
        return this.handle;
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener
    public synchronized void onReceive(VEAudioSample r110) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.handle != 0) goto L7;
    L17:
        monitor-exit(this);
        return;
    L7:
        if (this.mAudioCaptureSettings == null) goto L17;
        if (VEConfigCenter.getInstance().getValue("ve_enable_aaudio_mic_record", false).booleanValue() == true) goto L17;
        if ((r110.getSampleBuffer() instanceof VEAudioSample.a) == false) goto L14;
        nativeSendArrayData(this.handle, ((VEAudioSample.a) r110.getSampleBuffer()).f455732a, r110.getByteSize(), r110.getTimeStamp(), (System.nanoTime() / 1000) - r110.getTimeStamp());     // Catch: Throwable -> L19
        goto L17
    L14:
        if ((r110.getSampleBuffer() instanceof VEAudioSample.b) == false) goto L16;
        nativeSendBufferData(this.handle, ((VEAudioSample.b) r110.getSampleBuffer()).f455733a, r110.getByteSize(), r110.getTimeStamp(), (System.nanoTime() / 1000) - r110.getTimeStamp());     // Catch: Throwable -> L19
        goto L17
    L16:
        VELogUtil.w("TEAudioDataInterface", "Can not send sample for type=" + this.mAudioCaptureSettings.getDataStore());     // Catch: Throwable -> L19
        goto L17
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public void onInfo(int r100, int r101, double r102, Object r110) {
        if (r100 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT) goto L8;
        VEAudioCaptureSettings r111 = (VEAudioCaptureSettings) r110;
        this.mAudioCaptureSettings = r111;
        long r103 = this.handle;
        if (r103 == 0) goto L9;
        nativeInit(r103, r111.getSampleRate(), this.mAudioCaptureSettings.getChannel(), this.mAudioCaptureSettings.getBitSamples());
        return;
    L9:
        return;
    }
}
