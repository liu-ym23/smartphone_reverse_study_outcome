package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.SysStats;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.DeadLockMsg;
import com.ss.bytertc.engine.data.FrameUpdateInfo;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.data.LocalAudioStreamError;
import com.ss.bytertc.engine.data.LocalAudioStreamState;
import com.ss.bytertc.engine.data.MultiLinkEnhancementMode;
import com.ss.bytertc.engine.data.MultiLinkEnhancementState;
import com.ss.bytertc.engine.data.MultiLinkStats;
import com.ss.bytertc.engine.data.RecordingInfo;
import com.ss.bytertc.engine.data.RecordingProgress;
import com.ss.bytertc.engine.data.RemoteAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteAudioState;
import com.ss.bytertc.engine.data.RemoteAudioStateChangeReason;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoDenoiseModeChangedReason;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.VideoSuperResolutionModeChangedReason;
import com.ss.bytertc.engine.live.MixedStreamTaskErrorCode;
import com.ss.bytertc.engine.live.MixedStreamTaskEvent;
import com.ss.bytertc.engine.live.MixedStreamTaskInfo;
import com.ss.bytertc.engine.live.SingleStreamTaskErrorCode;
import com.ss.bytertc.engine.live.SingleStreamTaskEvent;
import com.ss.bytertc.engine.type.AudioAEDType;
import com.ss.bytertc.engine.type.AudioDeviceType;
import com.ss.bytertc.engine.type.AudioDumpStatus;
import com.ss.bytertc.engine.type.AudioRecordingErrorCode;
import com.ss.bytertc.engine.type.AudioRecordingState;
import com.ss.bytertc.engine.type.AudioVADType;
import com.ss.bytertc.engine.type.EchoTestResult;
import com.ss.bytertc.engine.type.EffectErrorType;
import com.ss.bytertc.engine.type.FirstFramePlayState;
import com.ss.bytertc.engine.type.FirstFrameSendState;
import com.ss.bytertc.engine.type.HardwareEchoDetectionResult;
import com.ss.bytertc.engine.type.LocalProxyError;
import com.ss.bytertc.engine.type.LocalProxyState;
import com.ss.bytertc.engine.type.LocalProxyType;
import com.ss.bytertc.engine.type.LocalVideoStreamError;
import com.ss.bytertc.engine.type.LocalVideoStreamState;
import com.ss.bytertc.engine.type.NetworkDetectionLinkType;
import com.ss.bytertc.engine.type.NetworkDetectionStopReason;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.PublicStreamErrorCode;
import com.ss.bytertc.engine.type.RecordingErrorCode;
import com.ss.bytertc.engine.type.RecordingState;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.RemoteVideoState;
import com.ss.bytertc.engine.type.RemoteVideoStateChangeReason;
import com.ss.bytertc.engine.type.RenderError;
import com.ss.bytertc.engine.type.RtcUser;
import com.ss.bytertc.engine.type.SEIStreamUpdateEvent;
import com.ss.bytertc.engine.type.SourceWantedData;
import com.ss.bytertc.engine.type.VideoDeviceType;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRTCEngineEventHandler {
    public IRTCEngineEventHandler() {
    }

    public void onActiveSpeaker(String r100, String r101) {
    }

    public void onAudioAEDStateUpdate(AudioAEDType r100) {
    }

    public void onAudioDeviceStateChanged(String r100, AudioDeviceType r101, int r102, int r103) {
    }

    public void onAudioDeviceWarning(String r100, AudioDeviceType r101, int r102) {
    }

    public void onAudioDumpStateChanged(AudioDumpStatus r100) {
    }

    public void onAudioFramePlayStateChanged(String r100, RtcUser r101, FirstFramePlayState r102) {
    }

    public void onAudioFrameSendStateChanged(String r100, RtcUser r101, FirstFrameSendState r102) {
    }

    public void onAudioMixingPlayingProgress(int r100, long r101) {
    }

    public void onAudioPlaybackDeviceTestVolume(int r100) {
    }

    public void onAudioRecordingStateUpdate(AudioRecordingState r100, AudioRecordingErrorCode r101) {
    }

    public void onAudioRouteChanged(AudioRoute r100) {
    }

    public void onAudioVADStateUpdate(AudioVADType r100) {
    }

    public void onCloudProxyConnected(int r100) {
    }

    public void onConnectionStateChanged(int r100, int r101) {
    }

    public void onDeadLockError(DeadLockMsg r100) {
    }

    public void onEchoTestResult(EchoTestResult r100) {
    }

    public void onEffectError(EffectErrorType r100, String r101) {
    }

    public void onError(int r100) {
    }

    public void onExperimentalCallback(String r100) {
    }

    public void onExtensionAccessError(String r100, String r101) {
    }

    public void onExternalScreenFrameUpdate(FrameUpdateInfo r100) {
    }

    public void onFirstLocalAudioFrame(StreamIndex r100) {
    }

    public void onFirstLocalVideoFrameCaptured(StreamIndex r100, VideoFrameInfo r101) {
    }

    public void onFirstLocalVideoFrameRendered(StreamIndex r100, VideoFrameInfo r101) {
    }

    public void onFirstRemoteAudioFrame(RemoteStreamKey r100) {
    }

    public void onFirstRemoteVideoFrameDecoded(RemoteStreamKey r100, VideoFrameInfo r101) {
    }

    public void onFirstRemoteVideoFrameRendered(RemoteStreamKey r100, VideoFrameInfo r101) {
    }

    public void onGetPeerOnlineStatus(String r100, int r101) {
    }

    public void onHardwareEchoDetectionResult(HardwareEchoDetectionResult r100) {
    }

    public void onLicenseWillExpire(int r100) {
    }

    public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] r100) {
    }

    public void onLocalAudioStateChanged(LocalAudioStreamState r100, LocalAudioStreamError r101) {
    }

    public void onLocalProxyStateChanged(LocalProxyType r100, LocalProxyState r101, LocalProxyError r102) {
    }

    public void onLocalVideoSizeChanged(StreamIndex r100, VideoFrameInfo r101) {
    }

    public void onLocalVideoStateChanged(StreamIndex r100, LocalVideoStreamState r101, LocalVideoStreamError r102) {
    }

    public void onLogReport(String r100, JSONObject r101) {
    }

    public void onLoggerMessage(LogUtil.LogLevel r100, String r101, Throwable r102) {
    }

    public void onLoginResult(String r100, int r101, int r102) {
    }

    public void onLogout(int r100) {
    }

    public void onMixedStreamEvent(MixedStreamTaskInfo r100, MixedStreamTaskEvent r101, MixedStreamTaskErrorCode r102) {
    }

    public void onMultiLinkEnhancementStateChanged(MultiLinkEnhancementState r100, MultiLinkEnhancementMode r101) {
    }

    public void onMultiLinkEnhancementStats(MultiLinkStats[] r100) {
    }

    public void onNetworkDetectionResult(NetworkDetectionLinkType r100, int r101, int r102, double r103, int r104, int r105) {
    }

    public void onNetworkDetectionStopped(NetworkDetectionStopReason r100) {
    }

    public void onNetworkTimeSynchronized() {
    }

    public void onNetworkTypeChanged(int r100) {
    }

    public void onPerformanceAlarms(PerformanceAlarmMode r100, String r101, PerformanceAlarmReason r102, SourceWantedData r103) {
    }

    public void onPushPublicStreamResult(String r100, String r101, PublicStreamErrorCode r102) {
    }

    public void onRecordingProgressUpdate(StreamIndex r100, RecordingProgress r101, RecordingInfo r102) {
    }

    public void onRecordingStateUpdate(StreamIndex r100, RecordingState r101, RecordingErrorCode r102, RecordingInfo r103) {
    }

    public void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] r100, int r101) {
    }

    public void onRemoteAudioPropertiesReportEx(RemoteAudioPropertiesInfo[] r100) {
    }

    public void onRemoteAudioStateChanged(RemoteStreamKey r100, RemoteAudioState r101, RemoteAudioStateChangeReason r102) {
    }

    public void onRemoteRenderError(RemoteStreamKey r100, RenderError r101, String r102) {
    }

    public void onRemoteVideoSizeChanged(RemoteStreamKey r100, VideoFrameInfo r101) {
    }

    public void onRemoteVideoStateChanged(RemoteStreamKey r100, RemoteVideoState r101, RemoteVideoStateChangeReason r102) {
    }

    public void onRemoteVideoSuperResolutionModeChanged(RemoteStreamKey r100, VideoSuperResolutionMode r101, VideoSuperResolutionModeChangedReason r102) {
    }

    public void onSEIMessageReceived(RemoteStreamKey r100, ByteBuffer r101) {
    }

    public void onSEIStreamUpdate(RemoteStreamKey r100, SEIStreamUpdateEvent r101) {
    }

    public void onScreenVideoFramePlayStateChanged(String r100, RtcUser r101, FirstFramePlayState r102) {
    }

    public void onScreenVideoFrameSendStateChanged(String r100, RtcUser r101, FirstFrameSendState r102) {
    }

    public void onServerMessageSendResult(long r100, int r101, ByteBuffer r102) {
    }

    public void onServerParamsSetResult(int r100) {
    }

    public void onSimulcastSubscribeFallback(RemoteStreamSwitch r100) {
    }

    public void onSingleStreamEvent(String r100, SingleStreamTaskEvent r101, SingleStreamTaskErrorCode r102) {
    }

    public void onStreamSyncInfoReceived(RemoteStreamKey r100, StreamSycnInfoConfig.SyncInfoStreamType r101, ByteBuffer r102) {
    }

    public void onSysStats(SysStats r100) {
    }

    public void onUserBinaryMessageReceivedOutsideRoom(long r100, String r101, ByteBuffer r102) {
    }

    public void onUserBinaryMessageReceivedOutsideRoom(String r100, ByteBuffer r101) {
    }

    public void onUserMessageReceivedOutsideRoom(long r100, String r101, String r102) {
    }

    public void onUserMessageReceivedOutsideRoom(String r100, String r101) {
    }

    public void onUserMessageSendResultOutsideRoom(long r100, int r101) {
    }

    public void onUserStartAudioCapture(String r100, String r101) {
    }

    public void onUserStartVideoCapture(String r100, String r101) {
    }

    public void onUserStopAudioCapture(String r100, String r101) {
    }

    public void onUserStopVideoCapture(String r100, String r101) {
    }

    public void onVideoDenoiseModeChanged(VideoDenoiseMode r100, VideoDenoiseModeChangedReason r101) {
    }

    public void onVideoDeviceStateChanged(String r100, VideoDeviceType r101, int r102, int r103) {
    }

    public void onVideoDeviceWarning(String r100, VideoDeviceType r101, int r102) {
    }

    public void onVideoFramePlayStateChanged(String r100, RtcUser r101, FirstFramePlayState r102) {
    }

    public void onVideoFrameSendStateChanged(String r100, RtcUser r101, FirstFrameSendState r102) {
    }

    public void onWarning(int r100) {
    }
}
