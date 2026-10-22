package com.bytedance.bdp.serviceapi.hostimpl.rtc2;

import ob4.a;
import ob4.b;

/* JADX INFO: loaded from: classes11.dex */
public interface IBdpRtcEventHandler2 {
    void onConnectionStatChanged(int r100, int r101);

    void onError(int r100);

    void onFirstRemoteAudioFrame(a r100);

    void onFirstRemoteVideoFrameDecoded(a r100);

    void onFirstRemoteVideoFrameRendered(a r100);

    void onJoinRoomResult(String r100, String r101, int r102, int r103, int r104);

    void onLeaveRoom();

    void onLocalVideoSizeChanged(a r100);

    void onNetworkTypeChanged(int r100);

    void onRemoteVideoSizeChanged(a r100);

    void onStreamSubscribed(int r100, String r101, b r102);

    void onTokenWillExpire();

    void onUserAudioCaptureStateChanged(String r100, boolean r101);

    void onUserJoin(String r100, int r101);

    void onUserLeave(String r100, int r101);

    void onUserPublishScreen(String r100, int r101);

    void onUserPublishStream(String r100, int r101);

    void onUserUnPublishScreen(String r100, int r101, int r102);

    void onUserUnPublishStream(String r100, int r101, int r102);

    void onUserVideoCaptureStateChanged(String r100, boolean r101);

    void onWarning(int r100);
}
