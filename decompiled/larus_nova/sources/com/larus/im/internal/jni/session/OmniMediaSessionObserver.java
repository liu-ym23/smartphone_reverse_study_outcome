package com.larus.im.internal.jni.session;

import com.larus.im.internal.jni.model.OmniAVAudioFrameData;
import com.larus.im.internal.jni.model.OmniAVEncodedVideoFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/im/internal/jni/session/OmniMediaSessionObserver;", "", "onStatusChanged", "", "status", "", "reason", "", "onReceiveEvent", "eventJson", "onReceiveLocalEvent", "onReceiveAudioFrame", "frame", "Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "onRoomTokenWillExpire", "onReceiveBinaryData", "data", "", "messageId", "", "onReceiveRemoteEncodedVideoFrame", "Lcom/larus/im/internal/jni/model/OmniAVEncodedVideoFrameData;", "onExternalVideoKeyFrameRequested", "streamIndex", "onExternalVideoTargetBitrateUpdated", "targetBitrateBps", "onExternalVideoEncoderStarted", "onExternalVideoEncoderStopped", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniMediaSessionObserver {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onExternalVideoEncoderStarted(OmniMediaSessionObserver r100) {
        }

        public static void onExternalVideoEncoderStopped(OmniMediaSessionObserver r100) {
        }

        public static void onExternalVideoKeyFrameRequested(OmniMediaSessionObserver r100, int r101) {
        }

        public static void onExternalVideoTargetBitrateUpdated(OmniMediaSessionObserver r100, int r101, long r102) {
        }

        public static void onReceiveAudioFrame(OmniMediaSessionObserver r100, OmniAVAudioFrameData r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
        }

        public static void onReceiveBinaryData(OmniMediaSessionObserver r100, byte[] r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "data");
        }

        public static void onReceiveEvent(OmniMediaSessionObserver r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "eventJson");
        }

        public static void onReceiveLocalEvent(OmniMediaSessionObserver r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "eventJson");
        }

        public static void onReceiveRemoteEncodedVideoFrame(OmniMediaSessionObserver r100, OmniAVEncodedVideoFrameData r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
        }

        public static void onRoomTokenWillExpire(OmniMediaSessionObserver r100) {
        }

        public static void onStatusChanged(OmniMediaSessionObserver r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "reason");
        }
    }

    void onExternalVideoEncoderStarted();

    void onExternalVideoEncoderStopped();

    void onExternalVideoKeyFrameRequested(int r100);

    void onExternalVideoTargetBitrateUpdated(int r100, long r101);

    void onReceiveAudioFrame(OmniAVAudioFrameData r100);

    void onReceiveBinaryData(byte[] r100, long r101);

    void onReceiveEvent(String r100);

    void onReceiveLocalEvent(String r100);

    void onReceiveRemoteEncodedVideoFrame(OmniAVEncodedVideoFrameData r100);

    void onRoomTokenWillExpire();

    void onStatusChanged(int r100, String r101);
}
