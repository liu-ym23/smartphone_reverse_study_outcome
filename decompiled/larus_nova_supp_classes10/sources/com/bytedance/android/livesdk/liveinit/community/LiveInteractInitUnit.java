package com.bytedance.android.livesdk.liveinit.community;

import com.bytedance.android.live.MsgWindowProxyService;
import com.bytedance.android.live.NavigationProxyService;
import com.bytedance.android.live.messagewindow.framework.CardInnerService;
import com.bytedance.android.live.messagewindow.service.PlatformCardService;
import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.live.room.api.IAudienceRankService;
import com.bytedance.android.live.room.api.IDiscoveryService;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.ISoundCardService;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.draggablecomponent.IDraggableComponentService;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.room.api.panel.IPanelService;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.discovery.SoundCardService;
import com.bytedance.android.live.room.navi.NavigationService;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.impl.DynamicStrategyService;
import com.bytedance.android.livesdk.experience.service.IExperienceProjectModeService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.interactivity.FansClubMemberUser;
import com.bytedance.android.livesdk.interactivity.GiftImageGetter;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformService;
import com.bytedance.android.livesdk.interactivity.InteractivityService;
import com.bytedance.android.livesdk.interactivity.api.AnchorAsrService;
import com.bytedance.android.livesdk.interactivity.api.EnterAnimService;
import com.bytedance.android.livesdk.interactivity.api.EpisodeInteractiveService;
import com.bytedance.android.livesdk.interactivity.api.HighlightService;
import com.bytedance.android.livesdk.interactivity.api.IAnchorAsrService;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdk.interactivity.api.IDiggService;
import com.bytedance.android.livesdk.interactivity.api.IEnterAnimService;
import com.bytedance.android.livesdk.interactivity.api.IHighlightService;
import com.bytedance.android.livesdk.interactivity.api.IIMService;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityDegradeService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityPlatformService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityService;
import com.bytedance.android.livesdk.interactivity.api.IMService;
import com.bytedance.android.livesdk.interactivity.api.IMultiCameraService;
import com.bytedance.android.livesdk.interactivity.api.INotifyService;
import com.bytedance.android.livesdk.interactivity.api.IPSTopContainerService;
import com.bytedance.android.livesdk.interactivity.api.IPinService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenPluginService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.IQuickCommentService;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.IRoomIntroService;
import com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService;
import com.bytedance.android.livesdk.interactivity.api.ITextAudioService;
import com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService;
import com.bytedance.android.livesdk.interactivity.api.ImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.api.InteractivityDegradeService;
import com.bytedance.android.livesdk.interactivity.api.MultiCameraService;
import com.bytedance.android.livesdk.interactivity.api.NotifyService;
import com.bytedance.android.livesdk.interactivity.api.PSTopContainerService;
import com.bytedance.android.livesdk.interactivity.api.PinService;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenPluginService;
import com.bytedance.android.livesdk.interactivity.api.RoomIntroService;
import com.bytedance.android.livesdk.interactivity.api.RoomNoticeService;
import com.bytedance.android.livesdk.interactivity.api.TextAudioService;
import com.bytedance.android.livesdk.interactivity.api.VirtualInteractService;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import com.bytedance.android.livesdk.liveinit.a;
import com.bytedance.android.livesdk.toolbarservice.ToolbarServiceImpl;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/community/LiveInteractInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInteractInitUnit extends AbsLiveInitUnit {
    public static final LiveInteractInitUnit INSTANCE = null;

    static {
        INSTANCE = new LiveInteractInitUnit();
    }

    public void initialize() {
        k.l(IInteractivityService.class, new InteractivityService());
        k.l(IMultiCameraService.class, new MultiCameraService());
        k.l(IInteractivityPlatformService.class, new InteractivityPlatformService());
        k.l(IGiftImageGetter.class, new GiftImageGetter());
        k.l(IFansClubMemberUser.class, new FansClubMemberUser());
        k.l(IPublicScreenPluginService.class, new PublicScreenPluginService());
        k.l(IPSTopContainerService.class, new PSTopContainerService());
        k.l(ITextAudioService.class, new TextAudioService());
        k.l(IPinService.class, new PinService());
        k.l(INotifyService.class, new NotifyService());
        k.l(IAnchorAsrService.class, new AnchorAsrService());
        k.l(IImageRecognitionService.class, new ImageRecognitionService());
        k.l(IEnterAnimService.class, new EnterAnimService());
        k.l(IRoomIntroService.class, new RoomIntroService());
        k.l(IRoomNoticeService.class, new RoomNoticeService());
        k.l(IIMService.class, new IMService());
        k.l(IEpisodeInteractiveService.class, new EpisodeInteractiveService());
        k.l(IHighlightService.class, new HighlightService());
        k.l(IVirtualInteractService.class, new VirtualInteractService());
        k.l(IInteractivityDegradeService.class, new InteractivityDegradeService());
        int r0 = a.a;
        a.b(IQuickCommentService.class, AnonymousClass1.INSTANCE);
        k.m(IInteractivityInjectService.class, AnonymousClass2.INSTANCE);
        k.m(IBarrageService.class, AnonymousClass3.INSTANCE);
        k.m(IPublicScreenService.class, AnonymousClass4.INSTANCE);
        k.m(IRoomChannelService.class, AnonymousClass5.INSTANCE);
        k.m(ICommentService.class, AnonymousClass6.INSTANCE);
        k.m(IDiggService.class, AnonymousClass7.INSTANCE);
        k.m(IBaseDiggService.class, AnonymousClass8.INSTANCE);
        k.m(IDiscoveryService.class, AnonymousClass9.INSTANCE);
        k.m(IReportService.class, AnonymousClass10.INSTANCE);
        k.m(IMiddlewareReportService.class, AnonymousClass11.INSTANCE);
        k.m(ILiveShareService.class, AnonymousClass12.INSTANCE);
        k.m(ILiveMiddlewareShareService.class, AnonymousClass13.INSTANCE);
        k.m(IDraggableComponentService.class, AnonymousClass14.INSTANCE);
        k.m(IAudienceRankService.class, AnonymousClass15.INSTANCE);
        k.m(IVisibilityControlService.class, AnonymousClass16.INSTANCE);
        k.m(IVisibilityControlBrickService.class, AnonymousClass17.INSTANCE);
        k.m(IScreenRotateService.class, AnonymousClass18.INSTANCE);
        k.m(ILoginGuideService.class, AnonymousClass19.INSTANCE);
        k.m(IToolbarPlatformService.class, AnonymousClass20.INSTANCE);
        k.m(ILiveProfileProxyService.class, AnonymousClass21.INSTANCE);
        k.m(ILiveExperienceProxyService.class, AnonymousClass22.INSTANCE);
        k.m(IExperienceProjectModeService.class, AnonymousClass23.INSTANCE);
        k.m(IPanelService.class, AnonymousClass24.INSTANCE);
        k.l(ISoundCardService.class, new SoundCardService());
        k.l(IMsgWindowProxyService.class, new MsgWindowProxyService());
        k.l(INavigationProxyService.class, new NavigationProxyService());
        k.l(IDynamicStrategyService.class, new DynamicStrategyService());
        k.l(IToolbarService.class, new ToolbarServiceImpl());
        k.l(INavigationService.class, new NavigationService());
        k.m(IMsgWindowService.class, AnonymousClass25.INSTANCE);
        k.m(IMiddlewareMsgWindowService.class, AnonymousClass26.INSTANCE);
        k.l(ICardInnerService.class, new CardInnerService());
        k.l(IPlatformCardService.class, new PlatformCardService());
    }

    private LiveInteractInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveInteractInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
