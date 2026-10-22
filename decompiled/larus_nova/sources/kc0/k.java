package kc0;

import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface k {
    pc0.e createRevRtcData();

    cy0.a enterLivePlay(ld.f r100);

    com.bytedance.android.live.revenuelink.connect.f getConnectService();

    int getEnterRoomLinkmicScene();

    List<RevImCacheUnit> getInteractFeedViewImCaches();

    String getLinkAnchorCount();

    i getLinkRegionServiceExternal();

    m getMultiAnchorService();

    g getPanelServiceExternal();

    h getPerfManager();

    q getPkService();

    s getRevLinkAudioDetectExternal();

    long getRevLinkControlLoadTs();

    e getRevLinkControlService();

    o getRevenueLinkDataHolder();

    com.bytedance.android.live.revenuelink.rtc.f getRtcService();

    boolean isSpatialAudioEnable(int r100);

    void leaveLivePlay(cy0.a r100);

    void markAddPkBackground(cy0.a r100, boolean r101);

    void notifyAudienceSelfJoin(boolean r100);

    void notifyAudienceSelfLeave();

    void notifyCleanModeChanged(int r100);

    void notifyIsCleanModeChanged(boolean r100);

    void notifyPauseStatus(int r100);

    void notifyPkAnchorSilenceStatus(boolean r100);

    void notifyPkAudienceUnload();

    void notifyPkRenderWidth(int r100);

    void notifyRenderSizeChanged(int r100, int r101);

    void notifyRtcData(String r100);

    void notifyStartAudioDiagnosis();

    void notifyStopLive(int r100);

    void notifyUserClose();

    void onAudienceJoinGuestLink(boolean r100);

    void onAudienceJoinSelfLink(boolean r100);

    void onMultiAnchorStateChange(int r100);

    void receiveChorusMessage(f0 r100);

    void setEnterRoomTime(long r100);

    void setSkipRoomStatsSync(boolean r100);

    void updateAudienceMemberCount(long r100);

    void updateEnterParams(cy0.a r100, long r101);

    void updateEnterRoomViewMock(boolean r100);

    void updateFeedParams(cy0.a r100, int r101, int r102, int r103, long r104);

    void updateFirstFrameSei(String r100);

    void updateInteractAnchorParam(String r100);

    void updateInteractLayoutShow(boolean r100);

    void updateInteractMarginTop(cy0.a r100, int r101);

    void updateKeyboardStatus(boolean r100);

    void updateLiveMode(LiveMode r100);

    void updateLoad0Ts(long r100);

    void updateLoad1Ts(long r100);

    void updateMicRoomAnchorStatus(int r100);

    void updatePkLeftMargin(cy0.a r100, int r101);

    void updatePkMovedMarginTop(cy0.a r100, int r101);

    void updatePortrait(boolean r100);

    void updatePushStreamInfo(double r100, double r101, double r102);

    void updateStableMode(boolean r100);

    void updateVideoHeight(cy0.a r100, int r101, int r102);
}
