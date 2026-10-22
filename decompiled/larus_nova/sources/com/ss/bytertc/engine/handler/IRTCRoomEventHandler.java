package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCStream;
import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.AVSyncState;
import com.ss.bytertc.engine.data.ForwardStreamEventInfo;
import com.ss.bytertc.engine.data.ForwardStreamStateInfo;
import com.ss.bytertc.engine.data.PublishState;
import com.ss.bytertc.engine.data.PublishStateChangeReason;
import com.ss.bytertc.engine.data.SubscribeState;
import com.ss.bytertc.engine.data.SubscribeStateChangeReason;
import com.ss.bytertc.engine.type.ControlMessageSendResult;
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.NetworkQualityStats;
import com.ss.bytertc.engine.type.RTCRoomStats;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RoomEvent;
import com.ss.bytertc.engine.type.RoomEventInfo;
import com.ss.bytertc.engine.type.RoomState;
import com.ss.bytertc.engine.type.RoomStateChangeReason;
import com.ss.bytertc.engine.type.SetRoomExtraInfoResult;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.ss.bytertc.engine.type.SubtitleErrorCode;
import com.ss.bytertc.engine.type.SubtitleMessage;
import com.ss.bytertc.engine.type.SubtitleState;
import com.ss.bytertc.engine.type.UserVisibilityChangeError;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRTCRoomEventHandler {
    public IRTCRoomEventHandler() {
    }

    public void onAVSyncEvent(String r100, String r101, AVSyncEvent r102) {
    }

    public void onAVSyncStateChange(AVSyncState r100) {
    }

    public void onAudioPublishStateChanged(String r100, String r101, PublishState r102, PublishStateChangeReason r103) {
    }

    public void onAudioStreamBanned(String r100, boolean r101) {
    }

    public void onAudioSubscribeStateChanged(String r100, String r101, SubscribeState r102, SubscribeStateChangeReason r103) {
    }

    public void onControlMessageSendResult(long r100, ControlMessageSendResult r101) {
    }

    public void onForwardStreamEvent(ForwardStreamEventInfo[] r100) {
    }

    public void onForwardStreamStateChanged(ForwardStreamStateInfo[] r100) {
    }

    public void onLeaveRoom(RTCRoomStats r100) {
    }

    public void onLocalStreamStats(LocalStreamStats r100) {
    }

    public void onNetworkQuality(NetworkQualityStats r100, NetworkQualityStats[] r101) {
    }

    public void onPublishPrivilegeTokenWillExpire() {
    }

    public void onRemoteStreamStats(RemoteStreamStats r100) {
    }

    public void onRoomBinaryMessageReceived(long r100, String r101, ByteBuffer r102) {
    }

    public void onRoomBinaryMessageReceived(String r100, ByteBuffer r101) {
    }

    public void onRoomEvent(String r100, String r101, RoomEvent r102, RoomEventInfo r103) {
    }

    public void onRoomExtraInfoUpdate(String r100, String r101, String r102, long r103) {
    }

    public void onRoomMessageReceived(long r100, String r101, String r102) {
    }

    public void onRoomMessageReceived(String r100, String r101) {
    }

    public void onRoomMessageSendResult(long r100, int r101) {
    }

    public void onRoomStateChanged(String r100, String r101, int r102, String r103) {
    }

    public void onRoomStateChangedWithReason(String r100, String r101, RoomState r102, RoomStateChangeReason r103) {
    }

    public void onRoomStats(RTCRoomStats r100) {
    }

    public void onRoomWarning(int r100) {
    }

    public void onScreenAudioPublishStateChanged(String r100, String r101, PublishState r102, PublishStateChangeReason r103) {
    }

    public void onScreenAudioSubscribeStateChanged(String r100, String r101, SubscribeState r102, SubscribeStateChangeReason r103) {
    }

    public void onScreenVideoPublishStateChanged(String r100, String r101, PublishState r102, PublishStateChangeReason r103) {
    }

    public void onScreenVideoSubscribeStateChanged(String r100, String r101, SubscribeState r102, SubscribeStateChangeReason r103) {
    }

    public void onSetRoomExtraInfoResult(long r100, SetRoomExtraInfoResult r101) {
    }

    public void onStreamAdd(RTCStream r100) {
    }

    public void onStreamPublishSuccess(String r100, boolean r101) {
    }

    public void onStreamRemove(RTCStream r100, StreamRemoveReason r101) {
    }

    public void onStreamStateChanged(String r100, String r101, int r102, String r103) {
    }

    public void onStreamSubscribed(int r100, String r101, SubscribeConfig r102) {
    }

    public void onSubscribePrivilegeTokenWillExpire() {
    }

    public void onSubtitleMessageReceived(SubtitleMessage[] r100) {
    }

    public void onSubtitleStateChanged(SubtitleState r100, SubtitleErrorCode r101, String r102) {
    }

    public void onTokenWillExpire() {
    }

    public void onUserBinaryMessageReceived(long r100, String r101, ByteBuffer r102) {
    }

    public void onUserBinaryMessageReceived(String r100, ByteBuffer r101) {
    }

    public void onUserJoined(UserInfo r100) {
    }

    public void onUserLeave(String r100, int r101, String r102) {
    }

    public void onUserMessageReceived(long r100, String r101, String r102) {
    }

    public void onUserMessageReceived(String r100, String r101) {
    }

    public void onUserMessageSendResult(long r100, int r101) {
    }

    public void onUserPublishScreen(String r100, MediaStreamType r101) {
    }

    public void onUserPublishScreenAudio(String r100, String r101, boolean r102) {
    }

    public void onUserPublishScreenVideo(String r100, String r101, boolean r102) {
    }

    public void onUserPublishStream(String r100, MediaStreamType r101) {
    }

    public void onUserPublishStreamAudio(String r100, String r101, boolean r102) {
    }

    public void onUserPublishStreamVideo(String r100, String r101, boolean r102) {
    }

    public void onUserUnpublishScreen(String r100, MediaStreamType r101, StreamRemoveReason r102) {
    }

    public void onUserUnpublishStream(String r100, MediaStreamType r101, StreamRemoveReason r102) {
    }

    public void onUserVisibilityChanged(boolean r100, UserVisibilityChangeError r101) {
    }

    public void onVideoPublishStateChanged(String r100, String r101, PublishState r102, PublishStateChangeReason r103) {
    }

    public void onVideoStreamBanned(String r100, boolean r101) {
    }

    public void onVideoSubscribeStateChanged(String r100, String r101, SubscribeState r102, SubscribeStateChangeReason r103) {
    }
}
