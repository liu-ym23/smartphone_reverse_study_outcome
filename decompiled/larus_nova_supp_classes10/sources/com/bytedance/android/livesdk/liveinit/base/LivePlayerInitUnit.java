package com.bytedance.android.livesdk.liveinit.base;

import android.content.Context;
import com.bytedance.android.live.livepullstream.PullStreamService;
import com.bytedance.android.live.platformplayer.service.LivePlatformPlayerService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.chatroom.resolution.smoothswitch.SmoothResolutionServiceImpl;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.headset.HeadsetServiceImpl;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.log.i;
import com.bytedance.android.livesdk.player.dropframe.DropFrameServiceImpl;
import com.bytedance.android.livesdk.player.newstrategy.PlayerStrategyService;
import com.bytedance.android.livesdk.player.roisr.RoiSrServiceImpl;
import com.bytedance.android.livesdk.player.stratege.LivePlayerStrategyService;
import com.bytedance.android.livesdkapi.IPlayerStrategyService;
import com.bytedance.android.livesdkapi.performance.IHotRoomLogCollectService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClientPool;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientPool;
import j40.x;
import java.util.concurrent.Callable;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y50.f;
import y50.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/base/LivePlayerInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initDropFrameService", "", "initHeadsetService", "context", "Landroid/content/Context;", "initHotRoomLogService", "initLiveMiddleLayer", "hostService", "Lcom/bytedance/android/livehostapi/IHostService;", "initLivePlayer", "initLivePlayerStrategyService", "initPlayerStrategyService", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initRoiSrService", "initSmoothResolutionService", "initialize", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerInitUnit extends AbsLiveInitUnit {
    public static final LivePlayerInitUnit INSTANCE = null;

    public static final class a implements sm0.a {
        public a() {
        }
    }

    public static final class b<V> implements Callable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public final ILivePlayerClientPool call() {
            return LivePlayerClientPool.INSTANCE;
        }
    }

    public static final class c<V> implements Callable {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.Callable
        public final rk1.a call() {
            return new com.bytedance.android.livesdk.chatroom.progressbar.service.a();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        INSTANCE = new LivePlayerInitUnit();
    }

    private final void initDropFrameService() {
        if (((Number) x.a.getValue()).intValue() <= 0) goto L6;
        new DropFrameServiceImpl().init();
        return;
    }

    private final void initLivePlayer() {
        new LivePlatformPlayerService();
        k.k(ILivePlayerClientPool.class, b.a);
        k.k(rk1.a.class, c.a);
    }

    private final void initSmoothResolutionService() {
        new SmoothResolutionServiceImpl().init();
    }

    public final void initPlayerStrategyService() {
        PlayerStrategyService r0 = (IPlayerStrategyService) k.f(IPlayerStrategyService.class);
        if (r0 != null) goto L5;
        r0 = new PlayerStrategyService();
    L5:
        r0.start();
    }

    public void initialize() {
        IMiddleHostService r0 = TTMiddlewareLiveSDK.sHostService;
        if (r0 == null) goto L11;
        initLiveMiddleLayer((IHostService) r0);
        initLivePlayer();
        new PullStreamService();
        initRoiSrService();
        initDropFrameService();
        initSmoothResolutionService();
        IHostService r1 = TTMiddlewareLiveSDK.sHostService;
        if (r1 == null) goto L9;
        initHeadsetService(r1.appContext().context());
        initLivePlayerStrategyService();
        initHotRoomLogService();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.IHostService");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.IHostService");
    }

    private final void initHotRoomLogService() {
        if (LiveInitSettingKeys.get_LIVE_HOT_ROOM_PERFORMANCE_SETTING().enable == false) goto L6;
        k.m(IHotRoomLogCollectService.class, AnonymousClass1.INSTANCE);
        return;
    }

    private final void initLivePlayerStrategyService() {
        if (LiveInitSettingKeys.get_LIVE_PLAYER_STRATEGY_SWITCH() == false) goto L6;
        new LivePlayerStrategyService().start();
        return;
    }

    private final void initRoiSrService() {
        if (LiveInitSettingKeys.get_LIVE_ROI_SR_ENABLE() == false) goto L6;
        new RoiSrServiceImpl().init();
        return;
    }

    private LivePlayerInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LivePlayerInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }

    private final void initHeadsetService(Context r2) {
        if (LiveInitSettingKeys.get_LIVE_HEADSET_SWITCH() <= 0) goto L6;
        HeadsetServiceImpl r0 = new HeadsetServiceImpl();
        r0.init(r2);
        r0.startListenHeadSetChange();
        return;
    }

    private final void initLiveMiddleLayer(IHostService r8) {
        com.bytedance.android.live.core.log.b r2 = new com.bytedance.android.live.core.log.b();
        a r1 = new a();
        i r3 = new i();
        zm2.b r5 = new zm2.b();
        f r6 = new f();
        om0.b r9 = new om0.b(r1, r2, r3, new n(), r5, r6);
        om0.b r0 = om0.c.a;
        Intrinsics.checkNotNullParameter(r9, "middleLayer");
        if (om0.c.b == true) goto L7;
        om0.c.a = r9;
        om0.c.b = true;
        return;
    }
}
