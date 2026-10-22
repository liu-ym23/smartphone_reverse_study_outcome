package com.bytedance.android.livesdk.liveinit.community;

import com.bytedance.android.live.i18n.I18nService;
import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.IHighlightAnnouncementService;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livesdk.browse.LiveBrowserService;
import com.bytedance.android.livesdk.explore.LiveExploreService;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowOuterService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.jsbridge.JsMethodsProvideServiceImpl;
import com.bytedance.android.livesdk.lifecycle.LifeCycleService;
import com.bytedance.android.livesdk.module.HighlightAnnouncementService;
import com.bytedance.android.livesdk.module.RoomService;
import com.bytedance.android.livesdk.module.UserService;
import com.bytedance.android.livesdk.performance.LiveCleanScreenManager;
import com.bytedance.android.livesdk.performance.LiveHotRoomManager;
import com.bytedance.android.livesdk.player.LiveCellularService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.android.livesdkapi.ILiveLongPressPanelService;
import com.bytedance.android.livesdkapi.ILiveMiscService;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.browse.ILiveBrowserService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.explore.ILiveExploreService;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.service.ICleanScreenManager;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.android.livesdkapi.service.IHotRoomManager;
import com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService;
import com.bytedance.android.livesdkapi.service.ILiveCellularService;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.android.livesdkapi.service.ILiveOptManager;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.service.IPerformanceEventKitService;
import com.bytedance.android.livesdkapi.service.IPreviewPerformanceManager;
import com.bytedance.android.livesdkapi.service.gamecp.IGamecpDependService;
import java.util.concurrent.Callable;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/community/LivesdkInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivesdkInitUnit extends AbsLiveInitUnit {
    public static final LivesdkInitUnit INSTANCE = null;

    public static final class a<V> implements Callable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        public final ILiveBrowserService call() {
            return new LiveBrowserService();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        INSTANCE = new LivesdkInitUnit();
    }

    public void initialize() {
        k.m(IExternalFunctionInjector.class, AnonymousClass1.INSTANCE);
        k.l(IUserService.class, new UserService());
        k.m(ILiveUxTracer.class, AnonymousClass2.INSTANCE);
        k.l(ILiveVideoFloatWindowService.class, new VideoFloatWindowOuterService());
        k.m(IInnerLiveFloatWindowService.class, AnonymousClass3.INSTANCE);
        k.m(ILiveMiscService.class, AnonymousClass4.INSTANCE);
        k.m(IAnnouncementService.class, AnonymousClass5.INSTANCE);
        k.m(ILiveAdService.class, AnonymousClass6.INSTANCE);
        k.m(ILiveLocalLifeService.class, AnonymousClass7.INSTANCE);
        k.m(ILiveMiniAppService.class, AnonymousClass8.INSTANCE);
        k.m(ILiveSDKService.class, AnonymousClass9.INSTANCE);
        k.m(I18nService.class, AnonymousClass10.INSTANCE);
        k.m(IPaidOuterService.class, AnonymousClass11.INSTANCE);
        k.m(ILottieService.class, AnonymousClass12.INSTANCE);
        k.m(IFloatWindowDegradeManager.class, AnonymousClass13.INSTANCE);
        k.m(IPreviewPerformanceManager.class, AnonymousClass14.INSTANCE);
        k.m(ILiveFeedbackService.class, AnonymousClass15.INSTANCE);
        k.m(ILiveLongPressPanelService.class, AnonymousClass16.INSTANCE);
        k.m(IGamecpDependService.class, AnonymousClass17.INSTANCE);
        k.m(ILiveNetworkPredict.class, AnonymousClass18.INSTANCE);
        k.m(IPerformanceEventKitService.class, AnonymousClass19.INSTANCE);
        k.m(ILiveOptManager.class, AnonymousClass20.INSTANCE);
        int r0 = com.bytedance.android.livesdk.liveinit.a.a;
        com.bytedance.android.livesdk.liveinit.a.b(IMicRoomService.class, AnonymousClass21.INSTANCE);
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getLazyInitTopService() == true) goto L5;
        com.bytedance.android.livesdk.liveinit.a.b(ILiveActionHandler.class, AnonymousClass22.INSTANCE);
    L5:
        RoomService r1 = new RoomService();
        k.l(IRoomService.class, r1);
        k.l(ILiveRoomService.class, r1);
        k.l(ILiveLifecycle.class, new LifeCycleService());
        k.l(ICleanScreenManager.class, new LiveCleanScreenManager());
        k.l(IHotRoomManager.class, new LiveHotRoomManager());
        k.l(IJsMethodsProvideService.class, new JsMethodsProvideServiceImpl());
        k.l(ILiveExploreService.class, new LiveExploreService());
        k.l(IHighlightAnnouncementService.class, new HighlightAnnouncementService());
        k.l(ILiveCellularService.class, new LiveCellularService());
        k.k(ILiveBrowserService.class, a.a);
    }

    private LivesdkInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LivesdkInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
