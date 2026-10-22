package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class NativeRTCRoomFunctions {
    public NativeRTCRoomFunctions() {
    }

    public static native int nativeClearAudioCache(long r100);

    public static native void nativeDestory(long r100);

    public static native void nativeDestroyRTSRoom(long r100);

    public static native int nativeEnableAudioCache(long r100, boolean r101);

    public static native int nativeEnableSubscribeLocalStream(long r100, boolean r101);

    public static native long nativeGetPanoramicVideo(long r100);

    public static native long nativeGetRangeAudio(long r100);

    public static native String nativeGetRoomId(long r100);

    public static native long nativeGetSpatialAudio(long r100);

    public static native int nativeJoinRTSRoom(long r100, String r101, UserInfo r102);

    public static native int nativeJoinRoomWithRoomConfig(long r100, String r101, UserInfo r102, boolean r103, RTCRoomConfig r104);

    public static native int nativeLeaveRTSRoom(long r100);

    public static native int nativeLeaveRoom(long r100, String r101);

    public static native int nativePauseAllSubscribedStreamAudio(long r100);

    public static native int nativePauseAllSubscribedStreamVideo(long r100);

    public static native int nativePauseForwardStreamToAllRooms(long r100);

    public static native int nativePublishScreenAudio(long r100, boolean r101);

    public static native int nativePublishScreenVideo(long r100, boolean r101);

    public static native int nativePublishStreamAudio(long r100, boolean r101);

    public static native int nativePublishStreamEx(long r100, int r101, int r102);

    public static native int nativePublishStreamVideo(long r100, boolean r101);

    public static native void nativeReleaseRTCRoomEventHandler(long r100);

    public static native void nativeReleaseRTCRoomEventHandlerAIGC(long r100);

    public static native void nativeReleaseRTCRoomEventHandlerEx(long r100);

    public static native void nativeReleaseRTCRoomEventHandlerRts(long r100);

    public static native int nativeResumeAllSubscribedStreamAudio(long r100);

    public static native int nativeResumeAllSubscribedStreamVideo(long r100);

    public static native int nativeResumeForwardStreamToAllRooms(long r100);

    public static native long nativeSendControlBinaryMessage(long r100, String r101, String r102, byte[] r103);

    public static native long nativeSendRTSRoomBinaryMessage(long r100, byte[] r101);

    public static native long nativeSendRTSRoomMessage(long r100, String r101);

    public static native long nativeSendRTSUserBinaryMessage(long r100, String r101, byte[] r102, int r103);

    public static native long nativeSendRTSUserMessage(long r100, String r101, String r102, int r103);

    public static native long nativeSendRoomBinaryMessage(long r100, byte[] r101);

    public static native long nativeSendRoomMessage(long r100, String r101);

    public static native long nativeSendUserBinaryMessage(long r100, String r101, byte[] r102, int r103);

    public static native long nativeSendUserMessage(long r100, String r101, String r102, int r103);

    public static native int nativeSetAudioSelectionConfig(long r100, int r101);

    public static native int nativeSetMultiDeviceAVSync(long r100, String r101);

    public static native long nativeSetRTCRoomEventHandler(long r100, RTCRoomEventHandler r101);

    public static native long nativeSetRTCRoomEventHandlerAIGC(long r100, RTCRoomEventHandlerAIGC r101);

    public static native long nativeSetRTCRoomEventHandlerEx(long r100, RTCRoomEventHandlerEx r101);

    public static native long nativeSetRTCRoomEventHandlerRts(long r100, RTCRoomEventHandlerRts r101);

    public static native int nativeSetRemoteRoomAudioPlaybackVolume(long r100, int r101);

    public static native int nativeSetRemoteSimulcastStreamType(long r100, String r101, int r102);

    public static native int nativeSetRemoteVideoConfigEx(long r100, String r101, int r102, int r103, int r104, int r105);

    public static native long nativeSetRoomExtraInfo(long r100, String r101, String r102);

    public static native int nativeSetUserVisibility(long r100, boolean r101);

    public static native int nativeStartForwardStreamToRooms(long r100, List<InternalForwardStreamInfo> r101);

    public static native int nativeStartForwardStreamToRoomsWithRoomGroupId(long r100, List<InternalForwardStreamInfo> r101, String r102);

    public static native int nativeStartSession(long r100, String r101, UserInfo r102, RTCRoomConfig r103, String r104, String r105, String r106, int r107, boolean r108, String r110);

    public static native int nativeStartSubtitle(long r100, int r101, String r102);

    public static native int nativeStopForwardStreamToRooms(long r100);

    public static native int nativeStopSession(long r100);

    public static native int nativeStopSubtitle(long r100);

    public static native int nativeSubscribeAllStreamsAudio(long r100, boolean r101);

    public static native int nativeSubscribeAllStreamsVideo(long r100, boolean r101);

    public static native int nativeSubscribeScreenAudio(long r100, String r101, boolean r102);

    public static native int nativeSubscribeScreenVideo(long r100, String r101, boolean r102);

    public static native int nativeSubscribeStreamAudio(long r100, String r101, boolean r102);

    public static native int nativeSubscribeStreamEx(long r100, String r101, int r102, int r103);

    public static native int nativeSubscribeStreamVideo(long r100, String r101, boolean r102);

    public static native int nativeUnpublishStreamEx(long r100, int r101, int r102);

    public static native int nativeUnsubscribeStreamEx(long r100, String r101, int r102, int r103);

    public static native int nativeUpdateForwardStreamToRooms(long r100, List<InternalForwardStreamInfo> r101);

    public static native int nativeUpdateForwardStreamToRoomsWithRoomGroupId(long r100, List<InternalForwardStreamInfo> r101, String r102);

    public static native int nativeUpdateRTSToken(long r100, String r101);

    public static native int nativeUpdateToken(long r100, String r101);
}
