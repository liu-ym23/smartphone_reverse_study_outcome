package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.ForwardStreamInfo;
import com.ss.bytertc.engine.data.SimulcastStreamType;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.type.AudioSelectionPriority;
import com.ss.bytertc.engine.type.SubtitleConfig;
import com.ss.bytertc.engine.video.IPanoramicVideo;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RTCRoom extends RTSRoom {
    @Override // com.ss.bytertc.engine.RTSRoom
    public abstract void destroy();

    public abstract int enableSubscribeLocalStream(boolean r100);

    public abstract IPanoramicVideo getPanoramicVideo();

    public abstract IRangeAudio getRangeAudio();

    public abstract String getRoomId();

    public abstract ISpatialAudio getSpatialAudio();

    public abstract int joinRoom(String r100, UserInfo r101, boolean r102, RTCRoomConfig r103);

    public abstract int leaveRoom(String r100);

    public abstract int pauseAllSubscribedStreamAudio();

    public abstract int pauseAllSubscribedStreamVideo();

    public abstract int pauseForwardStreamToAllRooms();

    public abstract int publishScreenAudio(boolean r100);

    public abstract int publishScreenVideo(boolean r100);

    public abstract int publishStreamAudio(boolean r100);

    public abstract int publishStreamVideo(boolean r100);

    public abstract int resumeAllSubscribedStreamAudio();

    public abstract int resumeAllSubscribedStreamVideo();

    public abstract int resumeForwardStreamToAllRooms();

    public abstract long sendControlBinaryMessage(String r100, String r101, byte[] r102);

    public abstract int setAudioSelectionConfig(AudioSelectionPriority r100);

    public abstract int setMultiDeviceAVSync(String r100);

    public abstract int setRTCRoomEventHandler(IRTCRoomEventHandler r100);

    public abstract int setRemoteRoomAudioPlaybackVolume(int r100);

    public abstract int setRemoteSimulcastStreamType(String r100, SimulcastStreamType r101);

    public abstract long setRoomExtraInfo(String r100, String r101);

    public abstract int setUserVisibility(boolean r100);

    public abstract int startForwardStreamToRooms(List<ForwardStreamInfo> r100);

    public abstract int startForwardStreamToRooms(List<ForwardStreamInfo> r100, String r101);

    public abstract int startSubtitle(SubtitleConfig r100);

    public abstract int stopForwardStreamToRooms();

    public abstract int stopSubtitle();

    public abstract int subscribeAllStreamsAudio(boolean r100);

    public abstract int subscribeAllStreamsVideo(boolean r100);

    public abstract int subscribeScreenAudio(String r100, boolean r101);

    public abstract int subscribeScreenVideo(String r100, boolean r101);

    public abstract int subscribeStreamAudio(String r100, boolean r101);

    public abstract int subscribeStreamVideo(String r100, boolean r101);

    public abstract int updateForwardStreamToRooms(List<ForwardStreamInfo> r100);

    public abstract int updateForwardStreamToRooms(List<ForwardStreamInfo> r100, String r101);

    public RTCRoom() {
    }
}
