package u01;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.layer.api.ILiveRevLinkLayerService;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.revenue.service.base.RevenueExposedWrapperBase;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.link.LiveDynamicLayoutInit;
import com.bytedance.android.livesdkapi.service.IFeedRevenueContext;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc0.r;
import kc0.s;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import nc0.p;

/* JADX INFO: loaded from: classes47.dex */
public class g extends RevenueExposedWrapperBase<ILinkService> implements ILinkServiceExternal {
    public g() {
        super(ILinkService.class);
        LiveDynamicLayoutInit.INSTANCE.initLiveDynamicLayout();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public Class<? extends Widget> getAnchorLinkWidget() {
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        return ((ILiveRevLinkLayerService) com.bytedance.android.live.revenue.core.util.h.d(ILiveRevLinkLayerService.class)).getAnchorLinkWidget();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public lc0.a getControlService() {
        return new nc0.f(getReal().getRevLinkControlService());
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public lc0.b getMultiAnchorService() {
        return new nc0.l(getReal().getMultiAnchorService());
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public lc0.c getMultiDataHolder() {
        return new nc0.m(getReal().getRevenueLinkDataHolder());
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public lc0.d getPkService() {
        return new p(getRealInstance().getPkService());
    }

    private final kc0.j getReal() {
        return getRealInstance();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public pc0.e createRevRtcData() {
        return getReal().createRevRtcData();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public int currentRoomLayoutType() {
        return getReal().getMultiAnchorService().currentRoomLayoutType();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public String getAnchorCount() {
        return getReal().getLinkAnchorCount();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "ticketWidgetClass")
    public Class<? extends Widget> getAnchorTicketWidgetClass() {
        return getTicketWidgetClass();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public s getAudioDetectService() {
        return getReal().getRevLinkAudioDetectExternal();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public com.bytedance.android.live.revenuelink.connect.f getConnectService() {
        return getReal().getConnectService();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "controlService")
    public lc0.a getControlServiceExternal() {
        return getControlService();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public int getEnterRoomLinkmicScene() {
        return getReal().getEnterRoomLinkmicScene();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public List<ImCacheUnit> getInteractFeedViewImCaches() {
        List<RevImCacheUnit> r100 = getReal().getInteractFeedViewImCaches();
        ArrayList r101 = new ArrayList();
        Iterator<RevImCacheUnit> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        RevImCacheUnit r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r101.add(new d(r103));
        goto L4
    L6:
        return r101;
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "linkAnchorCount")
    public String getLinkAnchorCount() {
        return getAnchorCount();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "multiAnchorService")
    public lc0.b getMultiAnchorServiceExternal() {
        return getMultiAnchorService();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "multiDataHolder")
    public lc0.c getMultiDataHolderExternal() {
        return getMultiDataHolder();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public kc0.g getPanelService() {
        return getReal().getPanelServiceExternal();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "panelService")
    public kc0.g getPanelServiceExternal() {
        return getPanelService();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public kc0.h getPerfManager() {
        return getReal().getPerfManager();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "perfManager")
    public kc0.h getPerfManagerExternal() {
        return getPerfManager();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "pkService")
    public lc0.d getPkServiceExternal() {
        return getPkService();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    @Deprecated(message = "profitWidgetClass")
    public Class<? extends Widget> getProfitInteractionWidgetClass() {
        return getProfitWidgetClass();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public Class<? extends Widget> getProfitWidgetClass() {
        return getReal().getProfitInteractionWidgetClass();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public kc0.i getRegionService() {
        return getReal().getLinkRegionServiceExternal();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public long getRevLinkControlLoadTs() {
        return getReal().getRevLinkControlLoadTs();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public gy.c getRtcService() {
        com.bytedance.android.live.revenuelink.rtc.f r100 = getReal().getRtcService();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new nc0.c(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public Class<? extends Widget> getTicketWidgetClass() {
        return getReal().getAnchorTicketWidgetClass();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyAudienceSelfLeave() {
        getReal().notifyAudienceSelfLeave();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyPkAudienceUnload() {
        getReal().notifyPkAudienceUnload();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyStartAudioDiagnosis() {
        getReal().notifyStartAudioDiagnosis();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyUserClose() {
        getReal().notifyUserClose();
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public cy0.a enterLivePlay(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        kc0.j r101 = getReal();
        Intrinsics.checkNotNullParameter(r100, "$this$asPlatform");
        ld.f r102 = (ld.f) r100.get("data_platform_ref", null);
        if (r102 != null) goto L7;
        r102 = new ld.f(r100);
        r100.put("data_platform_ref", r102);
    L7:
        return r101.enterLivePlay(r102);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public boolean isSpatialAudioEnable(int r100) {
        return getReal().isSpatialAudioEnable(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void leaveLivePlay(cy0.a r100) {
        getReal().leaveLivePlay(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void loadAnchorLinkContextWidget(WidgetManager r100) {
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((ILiveRevLinkLayerService) com.bytedance.android.live.revenue.core.util.h.d(ILiveRevLinkLayerService.class)).loadAnchorLinkContextWidget(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyAudienceSelfJoin(boolean r100) {
        getReal().notifyAudienceSelfJoin(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyCleanModeChanged(int r100) {
        getReal().notifyCleanModeChanged(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyIsCleanModeChanged(boolean r100) {
        getReal().notifyIsCleanModeChanged(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyPauseStatus(int r100) {
        getReal().notifyPauseStatus(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyPkAnchorSilenceStatus(boolean r100) {
        getReal().notifyPkAnchorSilenceStatus(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyPkRenderWidth(int r100) {
        getReal().notifyPkRenderWidth(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyRtcData(String r100) {
        getReal().notifyRtcData(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyStopLive(int r100) {
        getReal().notifyStopLive(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void onAudienceJoinGuestLink(boolean r100) {
        getReal().onAudienceJoinGuestLink(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void onAudienceJoinSelfLink(boolean r100) {
        getReal().onAudienceJoinSelfLink(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void onMultiAnchorStateChange(int r100) {
        getReal().onMultiAnchorStateChange(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void receiveChorusMessage(f0 r100) {
        getReal().receiveChorusMessage(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void setEnterRoomTime(long r100) {
        getReal().setEnterRoomTime(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void setSkipRoomStatsSync(boolean r100) {
        getReal().setSkipRoomStatsSync(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateAudienceMemberCount(long r100) {
        getReal().updateAudienceMemberCount(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateEnterRoomViewMock(boolean r100) {
        getReal().updateEnterRoomViewMock(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateFirstFrameSei(String r100) {
        getReal().updateFirstFrameSei(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateInteractAnchorParam(String r100) {
        getReal().updateInteractAnchorParam(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateInteractLayoutShow(boolean r100) {
        getReal().updateInteractLayoutShow(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateKeyboardStatus(boolean r100) {
        getReal().updateKeyboardStatus(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateLiveMode(LiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "liveMode");
        getReal().updateLiveMode(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateLoad0Ts(long r100) {
        getReal().updateLoad0Ts(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateLoad1Ts(long r100) {
        getReal().updateLoad1Ts(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateMicRoomAnchorStatus(int r100) {
        getReal().updateMicRoomAnchorStatus(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updatePortrait(boolean r100) {
        getReal().updatePortrait(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateStableMode(boolean r100) {
        getReal().updateStableMode(r100);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void markAddPkBackground(cy0.a r100, boolean r101) {
        getReal().markAddPkBackground(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void notifyRenderSizeChanged(int r100, int r101) {
        getReal().notifyRenderSizeChanged(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateEnterParams(cy0.a r100, long r101) {
        getReal().updateEnterParams(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateInteractMarginTop(cy0.a r100, int r101) {
        getReal().updateInteractMarginTop(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updatePkLeftMargin(cy0.a r100, int r101) {
        getReal().updatePkLeftMargin(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updatePkMovedMarginTop(cy0.a r100, int r101) {
        getReal().updatePkMovedMarginTop(r100, r101);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updatePushStreamInfo(double r100, double r110, double r111) {
        getReal().updatePushStreamInfo(r100, r110, r111);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateVideoHeight(cy0.a r100, int r101, int r102) {
        getReal().updateVideoHeight(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public r createRevMultiControlWidget(r.a r100, ViewGroup r101, Boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return getReal().createRevMultiControlWidget(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public IInteractFeedView getInteractFeedView(Context r100, SeiAppData r101, int r102, IFeedRevenueContext r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "seiAppData");
        kc0.j r104 = getReal();
        m r105 = new m(r101);
        if (r103 == null) goto L5;
        b r106 = new b(r103);
    L6:
        qc0.f r107 = r104.getInteractFeedView(r100, r105, r102, r106);
        if (r107 != null) goto L9;
        return null;
    L9:
        return new c(r107);
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.link.ILinkServiceExternal
    public void updateFeedParams(cy0.a r100, int r101, int r110, int r111, long r112) {
        getReal().updateFeedParams(r100, r101, r110, r111, r112);
    }
}
