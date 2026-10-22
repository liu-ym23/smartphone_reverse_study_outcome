package com.ss.bytertc.engine;

import android.content.Intent;
import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.audio.IMediaPlayer;
import com.ss.bytertc.engine.audio.ISimilaritySingScoringManager;
import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.AlphaLayout;
import com.ss.bytertc.engine.data.AudioAlignmentMode;
import com.ss.bytertc.engine.data.AudioFormat;
import com.ss.bytertc.engine.data.AudioFrameCallbackMethod;
import com.ss.bytertc.engine.data.AudioProcessorMethod;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.AudioRecordingConfig;
import com.ss.bytertc.engine.data.AudioRenderType;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.CloudProxyInfo;
import com.ss.bytertc.engine.data.EarMonitorMode;
import com.ss.bytertc.engine.data.EchoTestConfig;
import com.ss.bytertc.engine.data.EffectBeautyMode;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.MirrorType;
import com.ss.bytertc.engine.data.RTCLogConfig;
import com.ss.bytertc.engine.data.RecordingConfig;
import com.ss.bytertc.engine.data.RemoteMirrorType;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.SEICountPerFrame;
import com.ss.bytertc.engine.data.ScreenMediaType;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoOrientation;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.data.VideoRotationMode;
import com.ss.bytertc.engine.data.VideoSimulcastMode;
import com.ss.bytertc.engine.data.VideoSourceType;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.ZoomConfigType;
import com.ss.bytertc.engine.data.ZoomDirectionType;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.handler.RTCEncryptHandler;
import com.ss.bytertc.engine.live.ChorusCacheSyncConfig;
import com.ss.bytertc.engine.live.ClientMixedStreamConfig;
import com.ss.bytertc.engine.live.IChorusCacheSyncObserver;
import com.ss.bytertc.engine.live.IClientMixedStreamObserver;
import com.ss.bytertc.engine.live.MixedStreamConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetType;
import com.ss.bytertc.engine.live.PushSingleStreamParam;
import com.ss.bytertc.engine.loader.RTCNativeLibraryLoader;
import com.ss.bytertc.engine.mediaio.ILocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.IRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.type.AnsMode;
import com.ss.bytertc.engine.type.AudioProfileType;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.LocalProxyConfiguration;
import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.ProblemFeedbackInfo;
import com.ss.bytertc.engine.type.ProblemFeedbackOption;
import com.ss.bytertc.engine.type.PublishFallbackOption;
import com.ss.bytertc.engine.type.RecordingType;
import com.ss.bytertc.engine.type.RemoteUserPriority;
import com.ss.bytertc.engine.type.SubscribeFallbackOptions;
import com.ss.bytertc.engine.type.TorchState;
import com.ss.bytertc.engine.type.VoiceChangerType;
import com.ss.bytertc.engine.type.VoiceEqualizationConfig;
import com.ss.bytertc.engine.type.VoiceReverbConfig;
import com.ss.bytertc.engine.type.VoiceReverbType;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import com.ss.bytertc.engine.utils.EngineConfigCheck;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.utils.RTCEglContextChecker;
import com.ss.bytertc.engine.video.ISnapshotResultCallback;
import com.ss.bytertc.engine.video.IVideoDeviceManager;
import com.ss.bytertc.engine.video.IVideoEffect;
import com.ss.bytertc.engine.video.IVideoProcessor;
import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.LocalVideoSinkConfig;
import com.ss.bytertc.engine.video.RTCWatermarkConfig;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;
import com.ss.bytertc.engine.video.VideoDecoderConfig;
import com.ss.bytertc.engine.video.VideoPreprocessorConfig;
import com.ss.bytertc.ktv.IKTVManager;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RTCEngine {
    private static final String TAG = "RtcVideo";
    protected static RTCEngineImpl mInstance;
    protected static RTCEngineImpl mInstanceEx;
    protected static RTCEglContextChecker mRtcEglContextChecker;
    protected static RTCNativeLibraryLoader mRtcNativeLibraryLoader;

    public abstract int clearVideoWatermark(StreamIndex r100);

    public abstract RTCRoom createRTCRoom(String r100);

    public abstract RTSRoom createRTSRoom(String r100);

    public abstract int disableAlphaChannelVideoEncode(StreamIndex r100);

    public abstract int disableAudioFrameCallback(AudioFrameCallbackMethod r100);

    public abstract int disableAudioProcessor(AudioProcessorMethod r100);

    public abstract int enableAlphaChannelVideoEncode(StreamIndex r100, AlphaLayout r101);

    public abstract int enableAudioAEDReport(int r100);

    public abstract void enableAudioDecoding(boolean r100);

    public abstract void enableAudioEncoding(boolean r100);

    public abstract int enableAudioFrameCallback(AudioFrameCallbackMethod r100, AudioFormat r101);

    public abstract int enableAudioProcessor(AudioProcessorMethod r100, AudioFormat r101);

    public abstract int enableAudioPropertiesReport(AudioPropertiesConfig r100);

    public abstract int enableAudioVADReport(int r100);

    public abstract int enableCameraAutoExposureFaceMode(boolean r100);

    public abstract int enableEffectBeauty(boolean r100);

    public abstract int enableExternalSoundCard(boolean r100);

    public abstract int enableLocalVoiceReverb(boolean r100);

    public abstract int enableNtpTimestampInRtp(boolean r100);

    public abstract int enablePlaybackDucking(boolean r100);

    public abstract int enableVocalInstrumentBalance(boolean r100);

    public abstract int feedback(List<ProblemFeedbackOption> r100, ProblemFeedbackInfo r101);

    public abstract IRTCAudioDeviceManager getAudioDeviceManager();

    public abstract IAudioEffectPlayer getAudioEffectPlayer();

    public abstract AudioRoute getAudioRoute();

    public abstract float getCameraZoomMaxRatio();

    public abstract IKTVManager getKTVManager();

    public abstract IMediaPlayer getMediaPlayer(int r100);

    public abstract long getNativeHandle();

    public abstract NetworkTimeInfo getNetworkTimeInfo();

    public abstract int getPeerOnlineStatus(String r100);

    public abstract ISimilaritySingScoringManager getSimilaritySingScoringManager();

    public abstract ISingScoringManager getSingScoringManager();

    public abstract IVideoDeviceManager getVideoDeviceManager();

    public abstract IVideoEffect getVideoEffectInterface();

    public abstract IWTNStream getWTNStream();

    public abstract boolean isCameraExposurePositionSupported();

    public abstract boolean isCameraFocusPositionSupported();

    public abstract boolean isCameraTorchSupported();

    public abstract boolean isCameraZoomSupported();

    public abstract int login(String r100, String r101);

    public abstract int logout();

    public abstract int muteAudioCapture(StreamIndex r100, boolean r101);

    public abstract int pullExternalAudioFrame(AudioFrame r100);

    public abstract int pushClientMixedStreamExternalVideoFrame(String r100, VideoFrameData r101);

    public abstract int pushExternalAudioFrame(AudioFrame r100);

    public abstract int pushExternalEncodedAudioFrame(EncodedAudioFrameData r100);

    public abstract int pushExternalEncodedVideoFrame(StreamIndex r100, int r101, RTCEncodedVideoFrame r102);

    public abstract int pushExternalVideoFrame(VideoFrameData r100);

    public abstract int pushScreenAudioFrame(AudioFrame r100);

    public abstract int pushScreenVideoFrame(VideoFrameData r100);

    public abstract int registerAudioFrameObserver(IAudioFrameObserver r100);

    public abstract int registerAudioProcessor(IAudioFrameProcessor r100);

    public abstract int registerLocalEncodedVideoFrameObserver(ILocalEncodedVideoFrameObserver r100);

    public abstract int registerLocalVideoProcessor(IVideoProcessor r100, VideoPreprocessorConfig r101);

    public abstract void registerRemoteEncodedAudioFrameObserver(IRemoteEncodedAudioFrameObserver r100);

    public abstract int registerRemoteEncodedVideoFrameObserver(IRemoteEncodedVideoFrameObserver r100);

    public abstract int requestRemoteVideoKeyFrame(RemoteStreamKey r100);

    public abstract int sendPublicStreamSEIMessage(StreamIndex r100, int r101, byte[] r102, int r103, SEICountPerFrame r104);

    public abstract int sendSEIMessage(StreamIndex r100, byte[] r101, int r102);

    public abstract int sendSEIMessage(StreamIndex r100, byte[] r101, int r102, SEICountPerFrame r103);

    public abstract long sendServerBinaryMessage(byte[] r100);

    public abstract long sendServerMessage(String r100);

    public abstract int sendStreamSyncInfo(byte[] r100, StreamSycnInfoConfig r101);

    public abstract long sendUserBinaryMessageOutsideRoom(String r100, byte[] r101, MessageConfig r102);

    public abstract long sendUserMessageOutsideRoom(String r100, String r101, MessageConfig r102);

    public abstract int setAnsMode(AnsMode r100);

    public abstract int setAudioAlignmentProperty(RemoteStreamKey r100, AudioAlignmentMode r101);

    public abstract int setAudioProfile(AudioProfileType r100);

    public abstract int setAudioRenderType(AudioRenderType r100);

    public abstract int setAudioRoute(AudioRoute r100);

    public abstract int setAudioScenario(AudioScenarioType r100);

    public abstract int setAudioSourceType(AudioSourceType r100);

    public abstract int setBeautyIntensity(EffectBeautyMode r100, float r101);

    public abstract int setBusinessId(String r100);

    public abstract int setCameraAdaptiveMinimumFrameRate(int r100);

    public abstract int setCameraExposureCompensation(float r100);

    public abstract int setCameraExposurePosition(float r100, float r101);

    public abstract int setCameraFocusPosition(float r100, float r101);

    public abstract int setCameraTorch(TorchState r100);

    public abstract int setCameraZoomRatio(float r100);

    public abstract int setCaptureVolume(StreamIndex r100, int r101);

    public abstract int setCellularEnhancement(MediaTypeEnhancementConfig r100);

    public abstract int setClientMixedStreamObserver(IClientMixedStreamObserver r100);

    public abstract int setCustomizeEncryptHandler(RTCEncryptHandler r100);

    public abstract int setDefaultAudioRoute(AudioRoute r100);

    public abstract int setDummyCaptureImagePath(String r100);

    public abstract int setEarMonitorMode(EarMonitorMode r100);

    public abstract int setEarMonitorMode(EarMonitorMode r100, int r101);

    public abstract int setEarMonitorVolume(int r100);

    public abstract int setEncryptInfo(int r100, String r101);

    public abstract int setExternalVideoEncoderEventHandler(IExternalVideoEncoderEventHandler r100);

    public abstract int setLocalProxy(List<LocalProxyConfiguration> r100);

    public abstract int setLocalSimulcastMode(VideoSimulcastMode r100);

    public abstract int setLocalSimulcastMode(VideoSimulcastMode r100, VideoEncoderConfig[] r101);

    public abstract int setLocalVideoCanvas(StreamIndex r100, VideoCanvas r101);

    public abstract int setLocalVideoMirrorType(MirrorType r100);

    public abstract int setLocalVideoSink(StreamIndex r100, IVideoSink r101, int r102);

    public abstract int setLocalVideoSink(StreamIndex r100, IVideoSink r101, LocalVideoSinkConfig r102);

    public abstract int setLocalVoiceEqualization(VoiceEqualizationConfig r100);

    public abstract int setLocalVoicePitch(int r100);

    public abstract int setLocalVoiceReverbParam(VoiceReverbConfig r100);

    public abstract int setPlaybackVolume(int r100);

    public abstract int setPublishFallbackOption(PublishFallbackOption r100);

    public abstract int setRemoteAudioPlaybackVolume(RemoteStreamKey r100, int r101);

    public abstract int setRemoteUserPriority(String r100, String r101, RemoteUserPriority r102);

    public abstract int setRemoteVideoCanvas(RemoteStreamKey r100, VideoCanvas r101);

    public abstract int setRemoteVideoMirrorType(RemoteStreamKey r100, RemoteMirrorType r101);

    public abstract int setRemoteVideoSink(RemoteStreamKey r100, IVideoSink r101, int r102);

    public abstract int setRemoteVideoSink(RemoteStreamKey r100, IVideoSink r101, RemoteVideoSinkConfig r102);

    public abstract int setRemoteVideoSuperResolution(RemoteStreamKey r100, VideoSuperResolutionMode r101);

    public abstract int setRtcVideoEventHandler(IRTCEngineEventHandler r100);

    public abstract int setRuntimeParameters(JSONObject r100);

    public abstract int setScreenAudioSourceType(AudioSourceType r100);

    public abstract int setScreenAudioStreamIndex(StreamIndex r100);

    public abstract int setScreenVideoEncoderConfig(VideoEncoderConfig r100);

    public abstract int setServerParams(String r100, String r101);

    public abstract int setSubscribeFallbackOption(SubscribeFallbackOptions r100);

    public abstract int setVideoCaptureConfig(com.ss.bytertc.engine.video.VideoCaptureConfig r100);

    public abstract int setVideoCaptureRotation(VideoRotation r100);

    public abstract int setVideoDecoderConfig(RemoteStreamKey r100, VideoDecoderConfig r101);

    public abstract int setVideoDenoiser(VideoDenoiseMode r100);

    public abstract int setVideoDigitalZoomConfig(ZoomConfigType r100, float r101);

    public abstract int setVideoDigitalZoomControl(ZoomDirectionType r100);

    public abstract int setVideoEncoderConfig(VideoEncoderConfig r100);

    public abstract int setVideoEncoderConfig(VideoEncoderConfig r100, JSONObject r101);

    public abstract int setVideoOrientation(VideoOrientation r100);

    public abstract int setVideoRotationMode(VideoRotationMode r100);

    public abstract int setVideoSourceType(StreamIndex r100, VideoSourceType r101);

    public abstract int setVideoWatermark(StreamIndex r100, String r101, RTCWatermarkConfig r102);

    public abstract int setVoiceChangerType(VoiceChangerType r100);

    public abstract int setVoiceReverbType(VoiceReverbType r100);

    public abstract int startAudioCapture();

    public abstract int startAudioRecording(AudioRecordingConfig r100);

    public abstract int startChorusCacheSync(ChorusCacheSyncConfig r100, IChorusCacheSyncObserver r101);

    public abstract int startClientMixedStream(String r100, MixedStreamConfig r101, ClientMixedStreamConfig r102);

    public abstract int startCloudProxy(List<CloudProxyInfo> r100);

    public abstract int startEchoTest(EchoTestConfig r100, int r101);

    public abstract int startFileRecording(StreamIndex r100, RecordingConfig r101, RecordingType r102);

    public abstract int startHardwareEchoDetection(String r100);

    public abstract int startNetworkDetection(boolean r100, int r101, boolean r102, int r103);

    public abstract int startPushMixedStream(String r100, MixedStreamPushTargetConfig r101, MixedStreamConfig r102);

    public abstract int startPushSingleStream(String r100, PushSingleStreamParam r101);

    public abstract int startScreenCapture(ScreenMediaType r100, Intent r101);

    public abstract int startVideoCapture();

    public abstract int startVideoDigitalZoomControl(ZoomDirectionType r100);

    public abstract int stopAudioCapture();

    public abstract int stopAudioRecording();

    public abstract int stopChorusCacheSync();

    public abstract int stopClientMixedStream(String r100);

    public abstract int stopCloudProxy();

    public abstract int stopEchoTest();

    public abstract int stopFileRecording(StreamIndex r100);

    public abstract int stopHardwareEchoDetection();

    public abstract int stopNetworkDetection();

    public abstract int stopPushMixedStream(String r100, MixedStreamPushTargetType r101);

    public abstract int stopPushSingleStream(String r100);

    public abstract int stopScreenCapture();

    public abstract int stopVideoCapture();

    public abstract int stopVideoDigitalZoomControl();

    public abstract int switchCamera(CameraId r100);

    public abstract long takeLocalSnapshot(StreamIndex r100, ISnapshotResultCallback r101);

    public abstract long takeRemoteSnapshot(RemoteStreamKey r100, ISnapshotResultCallback r101);

    public abstract int updateClientMixedStream(String r100, MixedStreamConfig r101, ClientMixedStreamConfig r102);

    public abstract int updateLocalVideoCanvas(StreamIndex r100, int r101, int r102);

    public abstract int updateLoginToken(String r100);

    public abstract int updatePushMixedStream(String r100, MixedStreamPushTargetConfig r101, MixedStreamConfig r102);

    public abstract int updateRemoteStreamVideoCanvas(RemoteStreamKey r100, int r101, int r102);

    public abstract int updateRemoteStreamVideoCanvas(RemoteStreamKey r100, RemoteVideoRenderConfig r101);

    public abstract int updateScreenCapture(ScreenMediaType r100);

    public static synchronized void destroyRTCEngine() {
        monitor-enter(RTCEngine.class);
        RTCEngineImpl r100 = mInstance;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.doDestroy(false);     // Catch: Throwable -> L9
        mInstance = null;     // Catch: Throwable -> L9
        mRtcNativeLibraryLoader = null;     // Catch: Throwable -> L9
        mRtcEglContextChecker = null;     // Catch: Throwable -> L9
        System.gc();     // Catch: Throwable -> L9
    L7:
        monitor-exit(RTCEngine.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static String getSDKVersion() {
        if (RTCEngineImpl.initializeNativeLibs() == true) goto L6;
        return "";
    L6:
        return RTCEngineImpl.getSdkVersion();
    }

    public RTCEngine() {
    }

    public static synchronized void destroyRTCEngineMulti(RTCEngine r100) {
        monitor-enter(RTCEngine.class);
        if (r100 != null) goto L16;
    L13:
        monitor-exit(RTCEngine.class);
        return;
    L16:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r100 != mInstance) goto L8;
        destroyRTCEngine();     // Catch: Throwable -> L10
    L15:
        goto L13
    L8:
        ((RTCEngineImpl) r100).doDestroy(true);     // Catch: Throwable -> L10
        System.gc();     // Catch: Throwable -> L10
        goto L15
    }

    public static int setLogConfig(RTCLogConfig r100) {
        if (RTCEngineImpl.initializeNativeLibs() == true) goto L6;
        return -1;
    L6:
        return RTCEngineImpl.setLogConfig(r100);
    }

    public static void setRtcNativeLibraryLoader(RTCNativeLibraryLoader r100) {
        LogUtil.i(TAG, "set rtc native library loader" + r100);
        mRtcNativeLibraryLoader = r100;
    }

    public static synchronized RTCEngine createRTCEngine(EngineConfig r110, IRTCEngineEventHandler r111) {
        monitor-enter(RTCEngine.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (EngineConfigCheck.checkValid(r110) == 0) goto L10;
        LogUtil.e(TAG, "createRTCEngine: engine config is invalid, error code is " + EngineConfigCheck.checkValid(r110));     // Catch: Throwable -> L25
        monitor-exit(RTCEngine.class);
        return null;
    L10:
        if (RTCEngineImpl.initializeNativeLibs(r110.nativeLoadPath) == false) goto L22;
        RTCEngineImpl r100 = mInstance;     // Catch: Throwable -> L25
        if (r100 == null) goto L29;
        monitor-exit(RTCEngine.class);
        return r100;
    L29:
        RTCEngineImpl r101 = new RTCEngineImpl(r110, r111, null, false, false);     // Catch: IllegalStateException -> L18 Throwable -> L25
        mInstance = r101;     // Catch: IllegalStateException -> L18 Throwable -> L25
        monitor-exit(RTCEngine.class);
        return r101;
    L18:
        e = move-exception;
        LogUtil.e(TAG, "createRTCEngine: throw exception " + e.getMessage());     // Catch: Throwable -> L25
        return null;
    L22:
        LogUtil.e(TAG, "createRTCEngine: fail to load native library");     // Catch: Throwable -> L25
        monitor-exit(RTCEngine.class);
        return null;
    }

    public static synchronized RTCEngine createRTCEngineMulti(EngineConfig r110, IRTCEngineEventHandler r111) {
        monitor-enter(RTCEngine.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (EngineConfigCheck.checkValid(r110) == 0) goto L10;
        LogUtil.e(TAG, "createRTCEngine: engine config is invalid, error code is " + EngineConfigCheck.checkValid(r110));     // Catch: Throwable -> L19
        monitor-exit(RTCEngine.class);
        return null;
    L10:
        if (RTCEngineImpl.initializeNativeLibs(r110.nativeLoadPath) == true) goto L23;
        LogUtil.e(TAG, "createRTCEngine: fail to load native library");     // Catch: Throwable -> L19
        monitor-exit(RTCEngine.class);
        return null;
    L23:
        RTCEngineImpl r100 = new RTCEngineImpl(r110, r111, null, false, true);     // Catch: IllegalStateException -> L14 Throwable -> L19
        monitor-exit(RTCEngine.class);
        return r100;
    L15:
        return null;
    }
}
