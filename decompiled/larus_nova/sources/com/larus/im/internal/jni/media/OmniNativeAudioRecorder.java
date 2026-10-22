package com.larus.im.internal.jni.media;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0096 J\t\u0010\t\u001a\u00020\nH\u0096 J\t\u0010\u000b\u001a\u00020\nH\u0096 J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096 J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096 J\u0011\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096 J\t\u0010\u0013\u001a\u00020\nH\u0082 J\b\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniNativeAudioRecorder;", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderProtocol;", "Lcom/larus/im/internal/jni/media/OmniNativeAudioHandle;", "nativeHandle", "", "<init>", "(J)V", "getRecordAmplitude", "", "startRecorder", "", "stopRecorder", "setBluetoothForceToMedia", "enable", "", "addListener", "delegate", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderDelegate;", "removeListener", "nativeReleaseHandle", "destroyHandle", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniNativeAudioRecorder implements OmniAudioRecorderProtocol, OmniNativeAudioHandle {
    private volatile long nativeHandle;

    private final native void nativeReleaseHandle();

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native void addListener(OmniAudioRecorderDelegate r100);

    @Override // com.larus.im.internal.jni.media.OmniNativeAudioHandle
    public synchronized void destroyHandle() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.nativeHandle != 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        nativeReleaseHandle();     // Catch: Throwable -> L11
        this.nativeHandle = 0;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native float getRecordAmplitude();

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native void removeListener(OmniAudioRecorderDelegate r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native void setBluetoothForceToMedia(boolean r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native void startRecorder();

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public native void stopRecorder();

    public OmniNativeAudioRecorder(long r100) {
        this.nativeHandle = r100;
    }
}
