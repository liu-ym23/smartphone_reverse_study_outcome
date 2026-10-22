package com.bytedance.android.livesdk.liveinit.base;

import com.bytedance.android.MultiLinkInitializer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.gson.FeedItemTypeAdapter;
import com.bytedance.android.live.gson.RoomTypeAdapter;
import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.android.live.media.api.IMediaService;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.performance.PerfToolsService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.config.cc1;
import com.bytedance.android.livesdk.config.pa;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.live.extension.plugin.api.resourcemanager.ILiveWrappedResourceManagerService;
import com.bytedance.android.livesdk.utils.ScopeErrorHandler;
import com.bytedance.android.livesdkapi.ambientlight.ILiveAmbientLightService;
import com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.performance.IPowerPerfManager;
import com.bytedance.android.livesdkapi.service.IAcceleratedService;
import com.bytedance.android.livesdkapi.service.ISummerService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/base/LiveBaseInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBaseInitUnit extends AbsLiveInitUnit {
    public static final LiveBaseInitUnit INSTANCE = null;

    public static final class a implements fo0.b {
        public a() {
        }

        public final List<String> getBlackList() {
            List<String> r0 = (List) cc1.a.getValue();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
    }

    public static final class b implements fo0.b {
        public b() {
        }

        public final List<String> getBlackList() {
            List<String> r0 = (List) cc1.a.getValue();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
    }

    public static final class c implements LivePluginSPIManager.a {
        public c() {
        }

        public final void afterReady() {
            ILiveWrappedResourceManagerService.Companion.getClass();
            ILiveWrappedResourceManagerService r0 = (ILiveWrappedResourceManagerService) va1.b.a.a.a(ILiveWrappedResourceManagerService.class);
            if (r0 == null) goto L6;
            TTLiveSDK.hostService().appContext().getServerDeviceId();
            r0.setDeviceGenerator(new f6.a());
            return;
        }
    }

    static {
        INSTANCE = new LiveBaseInitUnit();
    }

    public void initialize() {
        ConcurrentHashMap r0 = k.a;
        GsonHelper.registerTypeAdapter(Room.class, new RoomTypeAdapter());
        GsonHelper.registerTypeAdapter(FeedItem.class, new FeedItemTypeAdapter());
        int r1 = com.bytedance.android.livesdk.liveinit.a.a;
        com.bytedance.android.livesdk.liveinit.a.b(INetworkService.class, AnonymousClass1.INSTANCE);
        ScopeErrorHandler.b.a();
        if (v.a() == false) goto L5;
        new PerfToolsService();
    L5:
        k.m(ILottieService.class, AnonymousClass2.INSTANCE);
        k.m(IMediaService.class, AnonymousClass3.INSTANCE);
        k.m(IQRCodeService.class, AnonymousClass4.INSTANCE);
        k.m(ISummerService.class, AnonymousClass5.INSTANCE);
        k.m(IAcceleratedService.class, AnonymousClass6.INSTANCE);
        k.m(ILiveBrightnessService.class, AnonymousClass7.INSTANCE);
        k.m(IPowerPerfManager.class, AnonymousClass8.INSTANCE);
        if (((Boolean) pa.a.getValue()).booleanValue() == false) goto L13;
        k.m(ILiveAmbientLightService.class, AnonymousClass9.INSTANCE);
    L13:
        fo0.b r2 = new a();     // Catch: Exception -> L10
    L11:
        fo0.a.a = r2;
        LivePluginSPIManager r3 = LivePluginSPIManager.e;
        c r4 = new c();
        r3.getClass();
        LivePluginSPIManager.d(r4);
        MultiLinkInitializer.INSTANCE.getClass();
        return;
    L10:
        r2 = new b();
        goto L11
    }

    private LiveBaseInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveBaseinitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
