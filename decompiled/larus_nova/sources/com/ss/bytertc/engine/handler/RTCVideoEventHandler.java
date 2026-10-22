package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalLocalStreamStats;
import com.ss.bytertc.engine.InternalRTCUser;
import com.ss.bytertc.engine.InternalRemoteStreamStats;
import com.ss.bytertc.engine.InternalRemoteStreamSwitch;
import com.ss.bytertc.engine.InternalSourceWantedData;
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
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoDenoiseModeChangedReason;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.VideoSuperResolutionModeChangedReason;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
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
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.LocalVideoStreamError;
import com.ss.bytertc.engine.type.LocalVideoStreamState;
import com.ss.bytertc.engine.type.NetworkDetectionLinkType;
import com.ss.bytertc.engine.type.NetworkDetectionStopReason;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.PublicStreamErrorCode;
import com.ss.bytertc.engine.type.RecordingErrorCode;
import com.ss.bytertc.engine.type.RecordingState;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.RemoteVideoState;
import com.ss.bytertc.engine.type.RemoteVideoStateChangeReason;
import com.ss.bytertc.engine.type.RenderError;
import com.ss.bytertc.engine.type.RtcUser;
import com.ss.bytertc.engine.type.SEIStreamUpdateEvent;
import com.ss.bytertc.engine.type.SourceWantedData;
import com.ss.bytertc.engine.type.VideoDeviceType;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class RTCVideoEventHandler {
    private static final String TAG = "RtcVideoEventHandler";
    private static final String WEBRTC_MEDIA_STAT_KEY = "rtc_media_statistics";
    private static final String WEBRTC_MONITOR_TAG = "live_webrtc_monitor_log";
    private static final String WEBRTC_STATISTICS_KEY = "rtc_statistics";
    private static final String WEBRTC_TRANSPORT_STAT_KEY = "rtc_transport_statistics";
    private long mJoinChannelTime;
    private WeakReference<RTCEngineImpl> mRTCVideoImpl;
    private String mRoom;
    private String mSession;
    private State mState;
    private String mUser;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State IDLE = null;
        public static final State IN_ROOM = null;

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("IN_ROOM", 1);
            IN_ROOM = r101;
            $VALUES = new State[]{r100, r101};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void onNetworkTimeSynchronized() {
        LogUtil.d(TAG, "onNetworkTimeSynchronized...");
        RTCEngineImpl r100 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r100 == null) goto L14;
        IRTCEngineEventHandler r101 = r100.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r101 == null) goto L15;
        r101.onNetworkTimeSynchronized();     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onNetworkTimeSynchronized callback catch exception.\n" + e.getMessage());
    }

    public RTCVideoEventHandler(RTCEngineImpl r100) {
        this.mState = State.IDLE;
        this.mJoinChannelTime = 0;
        this.mRTCVideoImpl = new WeakReference(r100);
    }

    public static ByteBuffer allocateDirectByteBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }

    public void onAudioAEDStateUpdate(AudioAEDType r100) {
        LogUtil.d(TAG, "onAudioAEDStateUpdate");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onAudioAEDStateUpdate(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioAEDStateUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onAudioDumpStateChanged(int r100) {
        LogUtil.d(TAG, "onAudioDumpStateChanged...status: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L27
        if (r101 == null) goto L32;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L27
        if (r102 == null) goto L33;
        AudioDumpStatus r103 = AudioDumpStatus.AUDIO_DUMP_START_FAILURE;     // Catch: Exception -> L27
        if (r100 != 0) goto L10;
    L25:
        r102.onAudioDumpStateChanged(r103);     // Catch: Exception -> L27
        return;
    L10:
        if (r100 != 1) goto L12;
        r103 = AudioDumpStatus.AUDIO_DUMP_START_SUCCESS;     // Catch: Exception -> L27
        goto L25
    L12:
        if (r100 != 2) goto L14;
        r103 = AudioDumpStatus.AUDIO_DUMP_STOP_FAILURE;     // Catch: Exception -> L27
        goto L25
    L14:
        if (r100 != 3) goto L16;
        r103 = AudioDumpStatus.AUDIO_DUMP_STOP_SUCCESS;     // Catch: Exception -> L27
        goto L25
    L16:
        if (r100 != 4) goto L18;
        r103 = AudioDumpStatus.AUDIO_DUMP_RUNNING_FAILURE;     // Catch: Exception -> L27
        goto L25
    L18:
        if (r100 != 5) goto L25;
        r103 = AudioDumpStatus.AUDIO_DUMP_RUNNING_SUCCESS;     // Catch: Exception -> L27
        goto L25
    L33:
        return;
    L32:
        return;
    L27:
        e = move-exception;
        LogUtil.e(TAG, "onAudioDumpStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onAudioPlaybackDeviceTestVolume(int r100) {
        LogUtil.d(TAG, "onAudioPlaybackDeviceTestVolume");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onAudioPlaybackDeviceTestVolume(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioPlaybackDeviceTestVolume callback catch exception.\n" + e.getMessage());
    }

    public void onAudioRouteChanged(AudioRoute r100) {
        LogUtil.d(TAG, "onAudioRouteChanged...device: " + r100.value());
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onAudioRouteChanged(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioRouteChanged callback catch exception.\n" + e.getMessage());
    }

    public void onAudioVADStateUpdate(AudioVADType r100) {
        LogUtil.d(TAG, "onAudioVADStateUpdate");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onAudioVADStateUpdate(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalAudioPropertiesReport callback catch exception.\n" + e.getMessage());
    }

    public void onCloudProxyConnected(int r100) {
        LogUtil.d(TAG, "onCloudProxyConnected, interval: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onCloudProxyConnected(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onCloudProxyConnected callback catch exception.\n" + e.getMessage());
    }

    public void onConnectionStateChanged(int r100) {
        LogUtil.d(TAG, "onConnectionStateChanged, state: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onConnectionStateChanged(r100, -1);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onConnectionStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onDeadLockError(DeadLockMsg r100) {
        LogUtil.d(TAG, "onDeadLockError...: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onDeadLockError(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onDeadLockError callback catch exception.\n" + e.getMessage());
    }

    public void onEchoTestResult(int r100) {
        LogUtil.d(TAG, "onEchoTestResult...error code: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L19
        if (r101 == null) goto L24;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L19
        if (r102 == null) goto L25;
        EchoTestResult r103 = EchoTestResult.ECHO_TEST_SUCCESS;     // Catch: Exception -> L19
        switch(r100) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L17;
        };     // Catch: Exception -> L19
    L10:
        r103 = EchoTestResult.ECHO_TEST_INTERNAL_ERROR;     // Catch: Exception -> L19
        goto L17
    L11:
        r103 = EchoTestResult.ECHO_TEST_VIDEO_RECEIVE_ERROR;     // Catch: Exception -> L19
        goto L17
    L12:
        r103 = EchoTestResult.ECHO_TEST_AUDIO_RECEIVE_ERROR;     // Catch: Exception -> L19
        goto L17
    L13:
        r103 = EchoTestResult.ECHO_TEST_VIDEO_DEVICE_ERROR;     // Catch: Exception -> L19
        goto L17
    L14:
        r103 = EchoTestResult.ECHO_TEST_AUDIO_DEVICE_ERROR;     // Catch: Exception -> L19
        goto L17
    L15:
        r103 = EchoTestResult.ECHO_TEST_INTERVAL_SHORT;     // Catch: Exception -> L19
        goto L17
    L16:
        r103 = EchoTestResult.ECHO_TEST_TIMEOUT;     // Catch: Exception -> L19
    L17:
        r102.onEchoTestResult(r103);     // Catch: Exception -> L19
        return;
    L25:
        return;
    L24:
        return;
    L19:
        e = move-exception;
        LogUtil.e(TAG, "onEchoTestResult callback catch exception.\n" + e.getMessage());
    }

    public void onError(int r100) {
        LogUtil.d(TAG, "onError...errorNum: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onError(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onError callback catch exception.\n" + e.getMessage());
    }

    public void onExperimentalCallback(String r100) {
        LogUtil.d(TAG, "onExperimentalCallback...param: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onExperimentalCallback(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onExperimentalCallback callback catch exception.\n" + e.getMessage());
    }

    public void onExternalScreenFrameUpdate(FrameUpdateInfo r100) {
        LogUtil.d(TAG, "onExternalScreenFrameUpdate, info: " + r100.toString());
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onExternalScreenFrameUpdate(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onExternalScreenFrameUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onFirstLocalAudioFrame(StreamIndex r100) {
        LogUtil.d(TAG, "onFirstLocalAudioFrame...streamIndex: " + r100.value());
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onFirstLocalAudioFrame(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstLocalAudioFrame callback catch exception.\n" + e.getMessage());
    }

    public void onFirstRemoteAudioFrame(RemoteStreamKey r100) {
        LogUtil.d(TAG, "onFirstRemoteAudioFrame...uid: " + r100.getUserId() + ", roomid: " + r100.getRoomId() + ", streamIndex: " + r100.getStreamIndex().value());
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onFirstRemoteAudioFrame(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstRemoteAudioFrame callback catch exception.\n" + e.getMessage());
    }

    public void onHardwareEchoDetectionResult(int r100) {
        LogUtil.d(TAG, "onHardwareEchoDetectionResult...result code: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L19
        if (r101 == null) goto L24;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L19
        if (r102 == null) goto L25;
        HardwareEchoDetectionResult r103 = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_NORMAL;     // Catch: Exception -> L19
        if (r100 != 0) goto L10;
        r103 = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_CANCELED;     // Catch: Exception -> L19
    L17:
        r102.onHardwareEchoDetectionResult(r103);     // Catch: Exception -> L19
        return;
    L10:
        if (r100 != 1) goto L12;
        r103 = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_UNKNOWN;     // Catch: Exception -> L19
        goto L17
    L12:
        if (r100 != 3) goto L17;
        r103 = HardwareEchoDetectionResult.HARDWARE_ECHO_RESULT_POOR;     // Catch: Exception -> L19
        goto L17
    L25:
        return;
    L24:
        return;
    L19:
        e = move-exception;
        LogUtil.e(TAG, "onHardwareEchoDetectionResult callback catch exception.\n" + e.getMessage());
    }

    public void onLicenseWillExpire(int r100) {
        LogUtil.d(TAG, "onLicenseWillExpire, days: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onLicenseWillExpire(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLicenseWillExpire callback catch exception.\n" + e.getMessage());
    }

    public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] r100) {
        LogUtil.d(TAG, "onLocalAudioPropertiesReport");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onLocalAudioPropertiesReport(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalAudioPropertiesReport callback catch exception.\n" + e.getMessage());
    }

    public void onLogout(int r100) {
        LogUtil.d(TAG, "onLogout: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onLogout(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLogout callback catch exception.\n" + e.getMessage());
    }

    public void onMultiLinkEnhancementStats(MultiLinkStats[] r100) {
        LogUtil.d(TAG, "onMultiLinkStats");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onMultiLinkEnhancementStats(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onMultiLinkStats callback catch exception.\n" + e.getMessage());
    }

    public void onNetworkProbeStopped(int r100) {
        LogUtil.d(TAG, "onNetworkProbeStopped: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onNetworkDetectionStopped(NetworkDetectionStopReason.values()[r100]);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onNetworkDetectionStopped callback catch exception.\n" + e.getMessage());
    }

    public void onNetworkTypeChanged(int r100) {
        LogUtil.d(TAG, "onNetworkTypeChanged, type: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onNetworkTypeChanged(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onNetworkTypeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteAudioPropertiesReportEx(RemoteAudioPropertiesInfo[] r100) {
        LogUtil.d(TAG, "onRemoteAudioPropertiesReport");
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onRemoteAudioPropertiesReportEx(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteAudioPropertiesReport callback catch exception.\n" + e.getMessage());
    }

    public void onServerParamsSetResult(int r100) {
        LogUtil.d(TAG, "onServerParamsSetResult: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onServerParamsSetResult(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onServerParamsSetResult callback catch exception.\n" + e.getMessage());
    }

    public void onSimulcastSubscribeFallback(InternalRemoteStreamSwitch r100) {
        LogUtil.d(TAG, "onSimulcastSubscribeFallback, uid: " + r100.uid + ", before_video_index: " + r100.beforeVideoIndex + ", after_video_index: " + r100.afterVideoIndex + ", before_enable: " + r100.beforeEnable + ", after_enable: " + r100.afterEnable + ", reason: " + r100.reason);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onSimulcastSubscribeFallback(new RemoteStreamSwitch(r100));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onNetworkTypeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onSysStats(SysStats r100) {
        LogUtil.d(TAG, "onSysStats... " + r100.toString());
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onSysStats(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onSysStats callback catch exception.\n" + e.getMessage());
    }

    public void onWarning(int r100) {
        LogUtil.d(TAG, "onWarning, warnNum: " + r100);
        RTCEngineImpl r101 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTCEngineEventHandler r102 = r101.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onWarning(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWarning callback catch exception.\n" + e.getMessage());
    }

    public void setJoinChannelTime(long r100) {
        this.mJoinChannelTime = r100;
    }

    public void onActiveSpeaker(String r100, String r101) {
        LogUtil.d(TAG, "onActiveSpeaker");
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onActiveSpeaker(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onActiveSpeaker callback catch exception.\n" + e.getMessage());
    }

    public void onAudioMixingPlayingProgress(int r100, long r101) {
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L8
        if (r102 == null) goto L13;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L8
        if (r103 == null) goto L14;
        r103.onAudioMixingPlayingProgress(r100, r101);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        LogUtil.e(TAG, "onAudioMixingPlayingProgress callback catch exception.\n" + e.getMessage());
    }

    public void onAudioRecordingStateUpdate(int r100, int r101) {
        LogUtil.d(TAG, "onAudioRecordingStateUpdate, state: " + r100 + ", errorCode: " + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onAudioRecordingStateUpdate(AudioRecordingState.fromId(r100), AudioRecordingErrorCode.fromId(r101));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioRecordingStateUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onEffectError(EffectErrorType r100, String r101) {
        LogUtil.d(TAG, "onEffectError error: " + r100 + ", msg: " + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onEffectError(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onEffectError callback catch exception.\n" + e.getMessage());
    }

    public void onExtensionAccessError(String r100, String r101) {
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onExtensionAccessError(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onExtensionAccessError callback catch exception.\n" + e.getMessage());
    }

    public void onFirstLocalVideoFrameCaptured(StreamIndex r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onFirstLocalVideoFrame...width: " + r101.getWidth() + ", height: " + r101.getHeight());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onFirstLocalVideoFrameCaptured(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstLocalVideoFrame callback catch exception.\n" + e.getMessage());
    }

    public void onFirstLocalVideoFrameRendered(StreamIndex r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onFirstLocalVideoFrameRendered...width: " + r101.getWidth() + ", height: " + r101.getHeight() + ", streamIndex: " + r100);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onFirstLocalVideoFrameRendered(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstLocalVideoFrameRendered callback catch exception.\n" + e.getMessage());
    }

    public void onFirstRemoteVideoFrameDecoded(RemoteStreamKey r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onFirstRemoteVideoFrameDecoded...uid: " + r100.getUserId() + ", StreamIndex:" + r100.getStreamIndex() + ", width: " + r101.getWidth() + ", height: " + r101.getHeight());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onFirstRemoteVideoFrameDecoded(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstRemoteVideoFrameDecoded callback catch exception.\n" + e.getMessage());
    }

    public void onFirstRemoteVideoFrameRendered(RemoteStreamKey r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onFirstRemoteVideoFrameRendered...uid: " + r100.getUserId() + ", StreamIndex:" + r100.getStreamIndex() + ", width: " + r101.getWidth() + ", height: " + r101.getHeight());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onFirstRemoteVideoFrameRendered(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onFirstRemoteVideoFrameRendered callback catch exception.\n" + e.getMessage());
    }

    public void onGetPeerOnlineStatus(String r100, int r101) {
        LogUtil.d(TAG, "onGetPeerOnlineStatus: " + r100 + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onGetPeerOnlineStatus(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onGetPeerOnlineStatus callback catch exception.\n" + e.getMessage());
    }

    public void onLocalAudioStateChanged(LocalAudioStreamState r100, LocalAudioStreamError r101) {
        LogUtil.d(TAG, "onLocalAudioStateChanged...");
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onLocalAudioStateChanged(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalAudioStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onLocalStreamStats(StreamIndex r100, InternalLocalStreamStats r101) {
        LogUtil.d(TAG, "onLocalStreamStats, streamIndex: " + r100);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandlerEx r103 = r102.getRtcEngineHandlerEx();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onLocalStreamStats(r100, new LocalStreamStats(r101));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onLocalStreamStats callback catch exception.\n" + e.getMessage());
    }

    public void onLocalVideoSizeChanged(StreamIndex r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onLocalVideoSizeChanged... streamIndex: " + r100 + ", frameInfo: " + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onLocalVideoSizeChanged(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalVideoSizeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onLogReport(String r100, String r101) {
    L17:
        e = move-exception;
        LogUtil.e(TAG, "onLogReport callback catch exception.\n" + e.getMessage());
        return;
    L4:
        if (WEBRTC_MONITOR_TAG.equals(r100) == true) goto L21;
        LogUtil.i(r100, r101);     // Catch: Exception -> L17
        return;
    L21:
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L12 Exception -> L17
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r103 == null) goto L23;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r104 == null) goto L24;
        r104.onLogReport(r100, r102);     // Catch: Exception -> L17
        return;
    L24:
        return;
    L23:
        return;
    L12:
        e = move-exception;
        LogUtil.d(TAG, "onLogReport...parse json catch exception: " + e.getMessage());     // Catch: Exception -> L17
    }

    public void onMultiLinkEnhancementStateChanged(MultiLinkEnhancementState r100, MultiLinkEnhancementMode r101) {
        LogUtil.d(TAG, "onMultiLinkEnhancementStateChanged");
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onMultiLinkEnhancementStateChanged(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onMultiLinkEnhancementStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] r100, int r101) {
        LogUtil.d(TAG, "onRemoteAudioPropertiesReport");
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onRemoteAudioPropertiesReport(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteAudioPropertiesReport callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteStreamStats(StreamKey r100, InternalRemoteStreamStats r101) {
        LogUtil.d(TAG, "onRemoteStreamStats, streamIndex: " + r100.getStreamIndex());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandlerEx r103 = r102.getRtcEngineHandlerEx();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onRemoteStreamStats(new StreamKey(r100.getRoomId(), r100.getUserId(), r100.getStreamIndex()), new RemoteStreamStats(r101));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRemoteStreamStats callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteVideoSizeChanged(RemoteStreamKey r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onRemoteVideoSizeChanged... RemoteStreamKey: " + r100 + ", frameInfo: " + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onRemoteVideoSizeChanged(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteVideoSizeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onSEIMessageReceived(RemoteStreamKey r100, ByteBuffer r101) {
        LogUtil.d(TAG, "onSEIMessageReceived" + r100.getRoomId() + r100.getUserId());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onSEIMessageReceived(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onSEIMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onSEIStreamUpdate(RemoteStreamKey r100, int r101) {
        LogUtil.d(TAG, "onSEIStreamUpdate" + r100.getRoomId() + r100.getUserId());
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onSEIStreamUpdate(r100, SEIStreamUpdateEvent.values()[r101]);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onSEIStreamUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onUserMessageSendResultOutsideRoom(long r100, int r101) {
        LogUtil.d(TAG, "onUserMessageSendResultOutsideRoom: " + r100 + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserMessageSendResultOutsideRoom(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserMessageSendResultOutsideRoom callback catch exception.\n" + e.getMessage());
    }

    public void onUserStartAudioCapture(String r100, String r101) {
        LogUtil.d(TAG, "onUserStartAudioCapture... uid: " + r101 + ", roomId: " + r100);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserStartAudioCapture(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserStartAudioCapture callback catch exception.\n" + e.getMessage());
    }

    public void onUserStartVideoCapture(String r100, String r101) {
        LogUtil.d(TAG, "onUserStartVideoCapture... uid: " + r101 + ", roomId: " + r100);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserStartVideoCapture(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserStartVideoCapture callback catch exception.\n" + e.getMessage());
    }

    public void onUserStopAudioCapture(String r100, String r101) {
        LogUtil.d(TAG, "onUserStopAudioCapture... uid: " + r101);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserStopAudioCapture(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserStopAudioCapture callback catch exception.\n" + e.getMessage());
    }

    public void onUserStopVideoCapture(String r100, String r101) {
        LogUtil.d(TAG, "onUserStopVideoCapture... uid: " + r101 + ", roomId: " + r100);
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserStopVideoCapture(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserStopVideoCapture callback catch exception.\n" + e.getMessage());
    }

    public void onVideoDenoiseModeChanged(VideoDenoiseMode r100, VideoDenoiseModeChangedReason r101) {
        LogUtil.d(TAG, "onVideoDenoiseModeChanged...");
        RTCEngineImpl r102 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTCEngineEventHandler r103 = r102.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onVideoDenoiseModeChanged(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onVideoDenoiseModeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onAudioDeviceWarning(String r100, AudioDeviceType r101, int r102) {
        LogUtil.d(TAG, "onAudioDeviceWarning, AudioDeviceType: " + r101 + ", device_warning " + r102);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onAudioDeviceWarning(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioDeviceWarning callback catch exception.\n" + e.getMessage());
    }

    public void onAudioFramePlayStateChanged(StreamKey r100, String r101, int r102) {
        LogUtil.d(TAG, "onAudioFramePlayStateChanged, user: " + r100.getUserId() + ", state: " + r102);
        FirstFramePlayState r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (r102 != 0) goto L5;
    L19:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r104 == null) goto L21;
        IRTCEngineEventHandlerEx r105 = r104.getRtcEngineHandlerEx();     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.onAudioFramePlayStateChanged(r100, r101, r103);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onAudioFramePlayStateChanged callback catch exception.\n");
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        goto L19
    L7:
        if (r102 != 2) goto L19;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        goto L19
    }

    public void onAudioFrameSendStateChanged(StreamKey r100, String r101, int r102) {
        LogUtil.d(TAG, "onAudioFrameSendStateChanged,  state: " + r102);
        FirstFrameSendState r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (r102 != 0) goto L5;
    L11:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();
        if (r104 == null) goto L17;
        IRTCEngineEventHandlerEx r105 = r104.getRtcEngineHandlerEx();
        if (r105 == null) goto L18;
        r105.onAudioFrameSendStateChanged(r100, r101, r103);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        goto L11
    L7:
        if (r102 != 2) goto L11;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        goto L11
    }

    public void onLocalProxyStateChanged(LocalProxyType r100, LocalProxyState r101, LocalProxyError r102) {
        LogUtil.d(TAG, "onLocalProxyStateChanged...: " + r100.value() + ", state: " + r101.value() + ", error: " + r102.value());
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onLocalProxyStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalProxyStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onLocalVideoStateChanged(StreamIndex r100, LocalVideoStreamState r101, LocalVideoStreamError r102) {
        LogUtil.d(TAG, "onLocalVideoStateChanged...");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onLocalVideoStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLocalVideoStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onLoginResult(String r100, int r101, int r102) {
        LogUtil.d(TAG, "OnLoginResult: " + r100 + r101 + r102);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onLoginResult(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onLoginResult callback catch exception.\n" + e.getMessage());
    }

    public void onMixedStreamEvent(MixedStreamTaskInfo r100, MixedStreamTaskEvent r101, MixedStreamTaskErrorCode r102) {
        LogUtil.d(TAG, "onMixedStreamEvent");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onMixedStreamEvent(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onMixedStreamEvent callback catch exception.\n" + e.getMessage());
    }

    public void onPushPublicStreamResult(String r100, String r101, PublicStreamErrorCode r102) {
        LogUtil.d(TAG, "onPushPublicStreamError error(" + r102.value() + ") streamId:" + r101);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onPushPublicStreamResult(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onPushPublicStreamError callback catch exception.\n" + e.getMessage());
    }

    public void onRecordingProgressUpdate(StreamIndex r100, RecordingProgress r101, RecordingInfo r102) {
        LogUtil.d(TAG, "onRecordingProgressUpdate, StreamIndex: " + r100 + ", progress.dur: " + r101.duration + ", progress.fileSize: " + r101.fileSize + ", info.filePath: " + r102.filePath);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRecordingProgressUpdate(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRecordingProgressUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteAudioStateChanged(RemoteStreamKey r100, RemoteAudioState r101, RemoteAudioStateChangeReason r102) {
        LogUtil.d(TAG, "onRemoteAudioStateChanged...");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRemoteAudioStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteAudioStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteRenderError(RemoteStreamKey r100, RenderError r101, String r102) {
        LogUtil.d(TAG, "onRemoteRenderError, key: " + r100.toString() + ", error: ; message: " + r102);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRemoteRenderError(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRemoteRenderError callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteVideoStateChanged(RemoteStreamKey r100, RemoteVideoState r101, RemoteVideoStateChangeReason r102) {
        LogUtil.d(TAG, "onRemoteVideoStateChanged...");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRemoteVideoStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteVideoStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onRemoteVideoSuperResolutionModeChanged(RemoteStreamKey r100, VideoSuperResolutionMode r101, VideoSuperResolutionModeChangedReason r102) {
        LogUtil.d(TAG, "onRemoteVideoSuperResolutionModeChanged...");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRemoteVideoSuperResolutionModeChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRemoteVideoSuperResolutionModeChanged callback catch exception.\n" + e.getMessage());
    }

    public void onScreenVideoFramePlayStateChanged(String r100, InternalRTCUser r101, int r102) {
        LogUtil.d(TAG, "onScreenVideoFramePlayStateChanged, user: " + r101 + ", state: " + r102);
        FirstFramePlayState r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (r102 != 0) goto L5;
    L19:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r104 == null) goto L21;
        IRTCEngineEventHandler r105 = r104.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.onScreenVideoFramePlayStateChanged(r100, new RtcUser(r101), r103);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onScreenVideoFramePlayStateChanged callback catch exception.\n");
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        goto L19
    L7:
        if (r102 != 2) goto L19;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        goto L19
    }

    public void onScreenVideoFrameSendStateChanged(String r100, InternalRTCUser r101, int r102) {
        LogUtil.d(TAG, "onScreenVideoFrameSendStateChanged, user: " + r101 + ", state: " + r102);
        FirstFrameSendState r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (r102 != 0) goto L5;
    L19:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r104 == null) goto L21;
        IRTCEngineEventHandler r105 = r104.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.onScreenVideoFrameSendStateChanged(r100, new RtcUser(r101), r103);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onScreenVideoFrameSendStateChanged callback catch exception.\n");
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        goto L19
    L7:
        if (r102 != 2) goto L19;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        goto L19
    }

    public void onServerMessageSendResult(long r100, int r101, ByteBuffer r102) {
        LogUtil.d(TAG, "onServerMessageSendResult: " + r100 + r101);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onServerMessageSendResult(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onServerMessageSendResult callback catch exception.\n" + e.getMessage());
    }

    public void onSingleStreamEvent(String r100, SingleStreamTaskEvent r101, SingleStreamTaskErrorCode r102) {
        LogUtil.d(TAG, "onSingleStreamEvent");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onSingleStreamEvent(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onSingleStreamEvent callback catch exception.\n" + e.getMessage());
    }

    public void onStreamSyncInfoReceived(RemoteStreamKey r100, ByteBuffer r101, int r102) {
        LogUtil.d(TAG, "onStreamSyncInfoReceived");
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onStreamSyncInfoReceived(r100, StreamSycnInfoConfig.SyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onStreamSyncInfoReceived callback catch exception.\n" + e.getMessage());
    }

    public void onUserBinaryMessageReceivedOutsideRoom(String r100, ByteBuffer r101, long r102) {
        LogUtil.d(TAG, "onUserBinaryMessageReceivedOutsideRoom: " + r100 + r101.capacity());
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onUserBinaryMessageReceivedOutsideRoom(r100, r101.duplicate());     // Catch: Exception -> L9
        r104.onUserBinaryMessageReceivedOutsideRoom(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserBinaryMessageReceivedOutsideRoom callback catch exception.\n" + e.getMessage());
    }

    public void onUserMessageReceivedOutsideRoom(String r100, String r101, long r102) {
        LogUtil.d(TAG, "onUserMessageReceivedOutsideRoom: " + r100 + r101);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onUserMessageReceivedOutsideRoom(r100, r101);     // Catch: Exception -> L9
        r104.onUserMessageReceivedOutsideRoom(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onUserMessageReceivedOutsideRoom callback catch exception.\n" + e.getMessage());
    }

    public void onVideoDeviceWarning(String r100, VideoDeviceType r101, int r102) {
        LogUtil.d(TAG, "onVideoDeviceWarning, VideoDeviceType: " + r101 + ", device_warning " + r102);
        RTCEngineImpl r103 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTCEngineEventHandler r104 = r103.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onVideoDeviceWarning(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onVideoDeviceWarning callback catch exception.\n" + e.getMessage());
    }

    public void onVideoFramePlayStateChanged(StreamKey r100, String r101, int r102) {
        LogUtil.d(TAG, "onVideoFramePlayStateChanged, user: " + r100.getUserId() + ", state: " + r102);
        FirstFramePlayState r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (r102 != 0) goto L5;
    L19:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r104 == null) goto L21;
        IRTCEngineEventHandlerEx r105 = r104.getRtcEngineHandlerEx();     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.onVideoFramePlayStateChanged(r100, r101, r103);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onVideoFramePlayStateChanged callback catch exception.\n");
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        goto L19
    L7:
        if (r102 != 2) goto L19;
        r103 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        goto L19
    }

    public void onVideoFrameSendStateChanged(StreamKey r100, String r101, int r102) {
        LogUtil.d(TAG, "onVideoFrameSendStateChanged, user: " + r100.getUserId() + ", state: " + r102);
        FirstFrameSendState r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (r102 != 0) goto L5;
    L19:
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r104 == null) goto L21;
        IRTCEngineEventHandlerEx r105 = r104.getRtcEngineHandlerEx();     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.onVideoFrameSendStateChanged(r100, r101, r103);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onVideoFrameSendStateChanged callback catch exception.\n");
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        goto L19
    L7:
        if (r102 != 2) goto L19;
        r103 = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        goto L19
    }

    public void onAudioDeviceStateChanged(String r100, AudioDeviceType r101, int r102, int r103) {
        LogUtil.d(TAG, "onAudioDeviceStateChanged, AudioDeviceType: " + r101 + ", device_state: " + r102);
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r104 == null) goto L14;
        IRTCEngineEventHandler r105 = r104.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r105 == null) goto L15;
        r105.onAudioDeviceStateChanged(r100, r101, r102, r103);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onAudioDeviceStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onAudioFramePlayStateChanged(String r100, InternalRTCUser r101, int r102, int r103) {
        LogUtil.d(TAG, "onAudioFramePlayStateChanged, user: " + r101 + ", state: " + r103);
        FirstFramePlayState r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (r103 != 0) goto L5;
    L19:
        RTCEngineImpl r105 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r105 == null) goto L21;
        IRTCEngineEventHandler r106 = r105.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r106 == null) goto L22;
        r106.onAudioFramePlayStateChanged(r100, new RtcUser(r101), r104);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onAudioFramePlayStateChanged callback catch exception.\n");
        return;
    L5:
        if (r103 != 1) goto L7;
        r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        goto L19
    L7:
        if (r103 != 2) goto L19;
        r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        goto L19
    }

    public void onAudioFrameSendStateChanged(String r100, InternalRTCUser r101, int r102, int r103) {
        LogUtil.d(TAG, "onAudioFrameSendStateChanged,  state: " + r103);
        FirstFrameSendState r104 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (r103 != 0) goto L5;
    L19:
        RTCEngineImpl r105 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r105 == null) goto L21;
        IRTCEngineEventHandler r106 = r105.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r106 == null) goto L22;
        r106.onAudioFrameSendStateChanged(r100, new RtcUser(r101), r104);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onAudioFrameSendStateChanged callback catch exception.\n");
        return;
    L5:
        if (r103 != 1) goto L7;
        r104 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        goto L19
    L7:
        if (r103 != 2) goto L19;
        r104 = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        goto L19
    }

    public void onPerformanceAlarms(int r100, String r101, int r102, InternalSourceWantedData r103) {
        LogUtil.d(TAG, "onPerformanceAlarms, level: " + r102 + ", data: " + r103);
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L24
        if (r104 == null) goto L29;
        if (r102 != 0) goto L7;
        PerformanceAlarmReason r105 = PerformanceAlarmReason.BANDWIDTH_FALLBACKED;     // Catch: Exception -> L24
    L17:
        IRTCEngineEventHandler r106 = r104.getRtcEngineHandler();     // Catch: Exception -> L24
        if (r106 == null) goto L30;
        if (r100 != 0) goto L21;
        PerformanceAlarmMode r107 = PerformanceAlarmMode.NORMAL;     // Catch: Exception -> L24
    L22:
        r106.onPerformanceAlarms(r107, r101, r105, new SourceWantedData(r103));     // Catch: Exception -> L24
        return;
    L21:
        r107 = PerformanceAlarmMode.SIMULCAST;     // Catch: Exception -> L24
        goto L22
    L30:
        return;
    L7:
        if (r102 != 1) goto L9;
        r105 = PerformanceAlarmReason.BANDWIDTH_RESUMED;     // Catch: Exception -> L24
        goto L17
    L9:
        if (r102 != 2) goto L11;
        r105 = PerformanceAlarmReason.PERFORMANCE_FALLBACKED;     // Catch: Exception -> L24
        goto L17
    L11:
        if (r102 == 3) goto L13;
        r105 = PerformanceAlarmReason.PERFORMANCE_RESUMED;     // Catch: Exception -> L24
        goto L17
    L13:
        r105 = PerformanceAlarmReason.PERFORMANCE_RESUMED;     // Catch: Exception -> L24
        goto L17
    L29:
        return;
    L24:
        e = move-exception;
        LogUtil.e(TAG, "onPerformanceAlarms callback catch exception.\n" + e.getMessage());
    }

    public void onRecordingStateUpdate(StreamIndex r100, int r101, int r102, RecordingInfo r103) {
        LogUtil.d(TAG, "onRecordingStateUpdate, StreamIndex: " + r100 + ", RecordingState: " + r101 + ", RecordingErrorCode: " + r102 + ", info.filePath: " + r103.filePath);
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r104 == null) goto L14;
        IRTCEngineEventHandler r105 = r104.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r105 == null) goto L15;
        r105.onRecordingStateUpdate(r100, RecordingState.fromId(r101), RecordingErrorCode.fromId(r102), r103);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onRecordingStateUpdate callback catch exception.\n" + e.getMessage());
    }

    public void onVideoDeviceStateChanged(String r100, VideoDeviceType r101, int r102, int r103) {
        LogUtil.d(TAG, "onVideoDeviceStateChanged, VideoDeviceType: " + r101 + ", device_state: " + r102);
        RTCEngineImpl r104 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r104 == null) goto L14;
        IRTCEngineEventHandler r105 = r104.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r105 == null) goto L15;
        r105.onVideoDeviceStateChanged(r100, r101, r102, r103);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onVideoDeviceStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onVideoFramePlayStateChanged(String r100, InternalRTCUser r101, int r102, int r103) {
        LogUtil.d(TAG, "onVideoFramePlayStateChanged, user: " + r101 + ", state: " + r103);
        FirstFramePlayState r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYING;
        if (r103 != 0) goto L5;
    L19:
        RTCEngineImpl r105 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r105 == null) goto L21;
        IRTCEngineEventHandler r106 = r105.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r106 == null) goto L22;
        r106.onVideoFramePlayStateChanged(r100, new RtcUser(r101), r104);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onVideoFramePlayStateChanged callback catch exception.\n");
        return;
    L5:
        if (r103 != 1) goto L7;
        r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_PLAYED;
        goto L19
    L7:
        if (r103 != 2) goto L19;
        r104 = FirstFramePlayState.FIRST_FRAME_PLAY_STATE_END;
        goto L19
    }

    public void onVideoFrameSendStateChanged(String r100, InternalRTCUser r101, int r102, int r103) {
        LogUtil.d(TAG, "onVideoFrameSendStateChanged, user: " + r101 + ", state: " + r103);
        FirstFrameSendState r104 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENDING;
        if (r103 != 0) goto L5;
    L19:
        RTCEngineImpl r105 = this.mRTCVideoImpl.get();     // Catch: Exception -> L17
        if (r105 == null) goto L21;
        IRTCEngineEventHandler r106 = r105.getRtcEngineHandler();     // Catch: Exception -> L17
        if (r106 == null) goto L22;
        r106.onVideoFrameSendStateChanged(r100, new RtcUser(r101), r104);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    L17:
        LogUtil.e(TAG, "onVideoFrameSendStateChanged callback catch exception.\n");
        return;
    L5:
        if (r103 != 1) goto L7;
        r104 = FirstFrameSendState.FIRST_FRAME_SEND_STATE_SENT;
        goto L19
    L7:
        if (r103 != 2) goto L19;
        r104 = FirstFrameSendState.FIRST_FRAME_SEND_STAT_END;
        goto L19
    }

    public void onNetworkProbeResult(int r110, int r111, int r112, double r113, int r114, int r115) {
        LogUtil.d(TAG, "onNetworkProbeResult: " + r110 + "," + r111 + "," + r112 + "," + r113 + "," + r114 + "," + r115);
        RTCEngineImpl r100 = this.mRTCVideoImpl.get();     // Catch: Exception -> L9
        if (r100 == null) goto L14;
        IRTCEngineEventHandler r101 = r100.getRtcEngineHandler();     // Catch: Exception -> L9
        if (r101 == null) goto L15;
        r101.onNetworkDetectionResult(NetworkDetectionLinkType.values()[r110], r111, r112, r113, r114, r115);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onNetworkDetectionResult callback catch exception.\n" + e.getMessage());
    }
}
