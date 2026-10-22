package com.larus.im.internal.jni.media;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0096 J\t\u0010\t\u001a\u00020\nH\u0096 J\t\u0010\u000b\u001a\u00020\nH\u0096 J\t\u0010\f\u001a\u00020\nH\u0096 J\t\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0096 J\u0011\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096 J\t\u0010\u0016\u001a\u00020\nH\u0096 J\u0011\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096 J\u0011\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096 J\t\u0010\u001b\u001a\u00020\nH\u0082 J\b\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniNativeAudioPlayer;", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerProtocol;", "Lcom/larus/im/internal/jni/media/OmniNativeAudioHandle;", "nativeHandle", "", "<init>", "(J)V", "getPlayAmplitude", "", "startPlayer", "", "stopPlayer", "pausePlayer", "resumePlayer", "mutePlayer", "enable", "", "duck", ITTVideoEngineEventSource.KEY_VOLUME, "playFrame", "frame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "clearPlayerBuffer", "addListener", "delegate", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerDelegate;", "removeListener", "nativeReleaseHandle", "destroyHandle", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniNativeAudioPlayer implements OmniAudioPlayerProtocol, OmniNativeAudioHandle {
    private volatile long nativeHandle;

    private final native void nativeReleaseHandle();

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void addListener(OmniAudioPlayerDelegate r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void clearPlayerBuffer();

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

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void duck(float r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native float getPlayAmplitude();

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void mutePlayer(boolean r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void pausePlayer();

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void playFrame(OmniAudioFrame r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void removeListener(OmniAudioPlayerDelegate r100);

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void resumePlayer();

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void startPlayer();

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public native void stopPlayer();

    public OmniNativeAudioPlayer(long r100) {
        this.nativeHandle = r100;
    }
}
