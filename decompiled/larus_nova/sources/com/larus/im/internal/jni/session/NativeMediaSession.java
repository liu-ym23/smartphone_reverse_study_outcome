package com.larus.im.internal.jni.session;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.larus.im.internal.jni.media.OmniNativeAudioPlayer;
import com.larus.im.internal.jni.media.OmniNativeAudioRecorder;
import com.larus.im.internal.jni.model.OmniAVAudioFrameData;
import com.larus.im.internal.jni.model.OmniAVEncodedVideoFrameData;
import com.larus.im.internal.jni.model.OmniAVUnsupportedReason;
import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import com.larus.im.internal.jni.session.observer.OmniAVAudioFrameProcessor;
import com.larus.im.internal.jni.session.observer.OmniAVVideoFrameProcessor;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086 J\u0011\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0086 J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0086 J\t\u0010\u0011\u001a\u00020\u000bH\u0086 J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086 J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0086 J\u0011\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0086 J\u0011\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0086 J\u0011\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\rH\u0086 J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086 J\u0019\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rH\u0082 J!\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\r2\u0006\u0010#\u001a\u00020 H\u0082 J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&J\t\u0010(\u001a\u00020\u000bH\u0086 J\u0011\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\tH\u0086 J\u0011\u0010+\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\tH\u0086 J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\bJ\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0086 J\u0013\u0010/\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u000100H\u0086 J\u000b\u00101\u001a\u0004\u0018\u000102H\u0086 J\u000b\u00103\u001a\u0004\u0018\u000104H\u0086 J\u0011\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u000207H\u0086 J\t\u00108\u001a\u00020\u000bH\u0086 J\u0011\u00109\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020:H\u0086 J\u0011\u0010;\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020<H\u0086 J\u001b\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00012\u0006\u0010?\u001a\u000207H\u0086 J\u0013\u0010@\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0086 J\u0013\u0010A\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0086 J\t\u0010B\u001a\u00020\u001bH\u0086 J\t\u0010C\u001a\u00020\u001bH\u0086 J\u0006\u0010D\u001a\u00020\u001bJ\t\u0010E\u001a\u00020\u001bH\u0086 J\t\u0010F\u001a\u00020\u001bH\u0086 J\u0019\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0086 J\t\u0010K\u001a\u00020\u001bH\u0086 J\u0011\u0010L\u001a\u00020\u000b2\u0006\u0010?\u001a\u000207H\u0086 J\t\u0010M\u001a\u000207H\u0086 J\u0011\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u000207H\u0086 J\u0011\u0010P\u001a\u00020\u000b2\u0006\u00106\u001a\u000207H\u0086 J\t\u0010Q\u001a\u00020\u000bH\u0086 J\u0011\u0010R\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086 J\t\u0010S\u001a\u00020\u000bH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/larus/im/internal/jni/session/NativeMediaSession;", "", "nativeSessionPtr", "", "<init>", "(J)V", "kmpObservers", "", "Lcom/larus/im/internal/jni/session/OmniMediaSessionObserver;", "Lcom/larus/im/internal/jni/session/OmniSessionObserver;", "setStartConfig", "", "configJson", "", "setRuntimeParams", "paramsJson", "reportAudioPerformance", "start", "stop", "switchModal", "modelJson", "uploadFile", "sendCommand", "commandJson", "updateRoomToken", "token", "sendBinaryData", "", "data", "", "sendFrame", "content", "Ljava/nio/ByteBuffer;", "extra", "sendFrameWithRef", "refContent", "sendAudioFrame", "frame", "Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "sendAudioFrameWithRef", "sessionState", "addSessionObserver", "observer", "removeSessionObserver", "registerExternalAudioProcessor", "processor", "Lcom/larus/im/internal/jni/session/observer/OmniAVAudioFrameProcessor;", "registerExternalVideoProcessor", "Lcom/larus/im/internal/jni/session/observer/OmniAVVideoFrameProcessor;", "getAudioPlayer", "Lcom/larus/im/internal/jni/media/OmniNativeAudioPlayer;", "getAudioRecorder", "Lcom/larus/im/internal/jni/media/OmniNativeAudioRecorder;", "publishVideo", "publish", "", "startVideoWithExternalCapture", "pushExternalVideoFrame", "Lcom/larus/im/internal/jni/model/OmniAVVideoFrameData;", "pushExternalEncodedVideoFrame", "Lcom/larus/im/internal/jni/model/OmniAVEncodedVideoFrameData;", "startVideoCapture", "platformView", "useBack", "bindLocalVideoView", "bindRemoteVideoView", "clearLocalVideoView", "stopVideoRecorder", "stopVideoCapture", "zoomIn", "zoomOut", ButtonColorBean.StateFocus, "x", "", "y", "resetScaleAndMove", "switchCamera", "isCameraTorchSupported", "switchTorchStatus", "enable", "publishScreenVideo", "startScreenExternalCapture", "startScreenShare", "stopScreenShare", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeMediaSession {
    private final Map<OmniMediaSessionObserver, OmniSessionObserver> kmpObservers;
    private final long nativeSessionPtr;

    private final native int sendFrame(ByteBuffer r100, String r101);

    private final native int sendFrameWithRef(ByteBuffer r100, String r101, ByteBuffer r102);

    public final native void addSessionObserver(OmniSessionObserver r100);

    public final native int bindLocalVideoView(Object r100);

    public final native int bindRemoteVideoView(Object r100);

    public final native void clearLocalVideoView();

    public final native void focus(float r100, float r101);

    public final native OmniNativeAudioPlayer getAudioPlayer();

    public final native OmniNativeAudioRecorder getAudioRecorder();

    public final native boolean isCameraTorchSupported();

    public final native int publishScreenVideo(boolean r100);

    public final native int publishVideo(boolean r100);

    public final native int pushExternalEncodedVideoFrame(OmniAVEncodedVideoFrameData r100);

    public final native int pushExternalVideoFrame(OmniAVVideoFrameData r100);

    public final native int registerExternalAudioProcessor(OmniAVAudioFrameProcessor r100);

    public final native int registerExternalVideoProcessor(OmniAVVideoFrameProcessor r100);

    public final native void removeSessionObserver(OmniSessionObserver r100);

    public final native int reportAudioPerformance(String r100);

    public final native void resetScaleAndMove();

    public final native void sendBinaryData(byte[] r100);

    public final native int sendCommand(String r100);

    public final native int sessionState();

    public final native int setRuntimeParams(String r100);

    public final native int setStartConfig(String r100);

    public final native int start();

    public final native int startScreenExternalCapture();

    public final native int startScreenShare(String r100);

    public final native int startVideoCapture(Object r100, boolean r101);

    public final native int startVideoWithExternalCapture();

    public final native int stop(String r100);

    public final native int stopScreenShare();

    public final native void stopVideoRecorder();

    public final native int switchCamera(boolean r100);

    public final native int switchModal(String r100);

    public final native int switchTorchStatus(boolean r100);

    public final native int updateRoomToken(String r100);

    public final native int uploadFile(String r100);

    public final native void zoomIn();

    public final native void zoomOut();

    public final void stopVideoCapture() {
        stopVideoRecorder();
    }

    private NativeMediaSession(long r100) {
        this.nativeSessionPtr = r100;
        this.kmpObservers = new LinkedHashMap();
    }

    public final int addSessionObserver(OmniMediaSessionObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Map<OmniMediaSessionObserver, OmniSessionObserver> r101 = this.kmpObservers;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.kmpObservers.containsKey(r100) == false) goto L9;
        monitor-exit(r101);
        return 0;
    L9:
        OmniSessionObserver r102 = new OmniSessionObserver(r100);     // Catch: Throwable -> L12
        addSessionObserver(r102);     // Catch: Throwable -> L12
        this.kmpObservers.put(r100, r102);     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        return 0;
    }

    public final int removeSessionObserver(OmniMediaSessionObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Map<OmniMediaSessionObserver, OmniSessionObserver> r101 = this.kmpObservers;
        monitor-enter(r101);
        OmniSessionObserver r102 = this.kmpObservers.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);
        if (r102 == null) goto L8;
        removeSessionObserver(r102);
        return 0;
    L8:
        return OmniAVUnsupportedReason.NativeUnavailable.getCode();
    L11:
        th = move-exception;
        throw th;
    }

    public final int sendAudioFrame(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        ByteBuffer r101 = ByteBuffer.wrap(r100.getData());
        String r102 = r100.getExtraJson();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return sendFrame(r101, r102);
    }

    public final int sendAudioFrameWithRef(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        byte[] r101 = r100.getRefData();
        if (r101 != null) goto L5;
        r101 = new byte[r100.getData().length];
    L5:
        ByteBuffer r102 = ByteBuffer.wrap(r100.getData());
        String r103 = r100.getExtraJson();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        return sendFrameWithRef(r102, r103, ByteBuffer.wrap(r101));
    }
}
