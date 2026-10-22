package com.bytedance.android.livesdk.liveinit.community;

import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.browse.LiveBrowserService;
import com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.provideservices.f0;
import com.bytedance.android.livesdk.r1;
import com.bytedance.android.livesdk.schema.LiveActionHandlerImpl;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.IPreLiveOuterService;
import com.bytedance.android.livesdkapi.browse.ILiveBrowserService;
import com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.concurrent.Callable;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/community/LivePreinitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreinitUnit extends AbsLiveInitUnit {
    public static final LivePreinitUnit INSTANCE = null;

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

    public static final class b<V> implements Callable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Callable
        public final IPreLiveOuterService call() {
            return new f0();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
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
        public final IBaseLiveActionHandler call() {
            return new LiveActionHandlerImpl();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        INSTANCE = new LivePreinitUnit();
    }

    public void initialize() {
        k.m(ILiveFeedOuterService.class, AnonymousClass1.INSTANCE);
        k.m(IAppointmentService.class, AnonymousClass2.INSTANCE);
        k.m(IHostFeed.class, AnonymousClass3.INSTANCE);
        k.k(ILiveBrowserService.class, a.a);
        k.k(IPreLiveOuterService.class, b.a);
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getLazyInitTopService() == false) goto L5;
        k.m(IBaseLiveActionHandler.class, AnonymousClass6.INSTANCE);
        k.m(ILiveActionHandler.class, AnonymousClass7.INSTANCE);
    L7:
        if (((Boolean) r1.a.getValue()).booleanValue() == false) goto L10;
        k.m(IPerformanceManager.class, AnonymousClass9.INSTANCE);
        return;
    L10:
        return;
    L5:
        k.k(IBaseLiveActionHandler.class, c.a);
        goto L7
    }

    private LivePreinitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LivePreinitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.PRE_INIT;
    }
}
