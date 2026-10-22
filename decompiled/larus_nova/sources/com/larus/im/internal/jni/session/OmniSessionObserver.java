package com.larus.im.internal.jni.session;

import com.larus.im.depend.CallByNative;
import com.larus.im.internal.jni.model.OmniAVAudioFrameData;
import com.larus.im.internal.jni.model.OmniAVEncodedVideoFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@CallByNative
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0017J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0017J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\bH\u0017J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0017J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nH\u0017J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0006H\u0017J\b\u0010 \u001a\u00020\bH\u0017J\b\u0010!\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/im/internal/jni/session/OmniSessionObserver;", "Lcom/larus/im/internal/jni/session/OmniMediaSessionObserver;", "delegate", "<init>", "(Lcom/larus/im/internal/jni/session/OmniMediaSessionObserver;)V", "nativeHandle", "", "onStatusChanged", "", "status", "", "reason", "", "onReceiveEvent", "eventJson", "onReceiveLocalEvent", "onReceiveFrame", "audioFrame", "Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "onRoomTokenWillExpire", "onReceiveAudioFrame", "frame", "onReceiveBinaryData", "data", "", "messageId", "onReceiveRemoteEncodedVideoFrame", "Lcom/larus/im/internal/jni/model/OmniAVEncodedVideoFrameData;", "onExternalVideoKeyFrameRequested", "streamIndex", "onExternalVideoTargetBitrateUpdated", "targetBitrateBps", "onExternalVideoEncoderStarted", "onExternalVideoEncoderStopped", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniSessionObserver implements OmniMediaSessionObserver {
    private final OmniMediaSessionObserver delegate;
    private long nativeHandle;

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onExternalVideoEncoderStarted() {
        this.delegate.onExternalVideoEncoderStarted();
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onExternalVideoEncoderStopped() {
        this.delegate.onExternalVideoEncoderStopped();
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onRoomTokenWillExpire() {
        this.delegate.onRoomTokenWillExpire();
    }

    public OmniSessionObserver(OmniMediaSessionObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.delegate = r100;
        this.nativeHandle = -1;
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onExternalVideoKeyFrameRequested(int r100) {
        this.delegate.onExternalVideoKeyFrameRequested(r100);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    public void onReceiveAudioFrame(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.delegate.onReceiveAudioFrame(r100);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onReceiveEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventJson");
        this.delegate.onReceiveEvent(r100);
    }

    @CallByNative
    public final void onReceiveFrame(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "audioFrame");
        this.delegate.onReceiveAudioFrame(r100);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onReceiveLocalEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventJson");
        this.delegate.onReceiveLocalEvent(r100);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onReceiveRemoteEncodedVideoFrame(OmniAVEncodedVideoFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.delegate.onReceiveRemoteEncodedVideoFrame(r100);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onExternalVideoTargetBitrateUpdated(int r100, long r101) {
        this.delegate.onExternalVideoTargetBitrateUpdated(r100, r101);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onReceiveBinaryData(byte[] r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.delegate.onReceiveBinaryData(r100, r101);
    }

    @Override // com.larus.im.internal.jni.session.OmniMediaSessionObserver
    @CallByNative
    public void onStatusChanged(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.delegate.onStatusChanged(r100, r101);
    }
}
