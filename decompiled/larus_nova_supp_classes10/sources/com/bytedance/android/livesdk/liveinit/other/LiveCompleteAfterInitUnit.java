package com.bytedance.android.livesdk.liveinit.other;

import bolts.Task;
import com.bytedance.android.live.base.LiveServiceProviderManager;
import com.bytedance.android.live.livelink.LiveLinkServiceKmp;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.init.ProtoDecoderInjectTask;
import com.bytedance.android.livesdk.init.SDKServiceInitTask;
import com.bytedance.android.livesdk.init.TaskManagerInitTask;
import com.bytedance.android.livesdk.provideservices.WidgetLiveServiceImpl;
import com.bytedance.android.livesdk.provideservices.d0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.link.LiveDynamicLayoutInit;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IWidgetLiveService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/other/LiveCompleteAfterInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCompleteAfterInitUnit extends AbsLiveInitUnit {
    public static final LiveCompleteAfterInitUnit INSTANCE = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            new ProtoDecoderInjectTask().run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
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
        public final void call() {
            Lazy r0 = LiveServiceProviderManager.a;
            LinkedHashMap r1 = new LinkedHashMap();
            r1.putAll((ConcurrentHashMap) LiveServiceProviderManager.a.getValue());
            Iterator r2 = r1.keySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            k.b((Class) r2.next());
            goto L4
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new LiveCompleteAfterInitUnit();
    }

    public void initialize() {
        new LiveLinkServiceKmp();
        int r0 = com.bytedance.android.live.misc.b.a;
        rb.a.call("modelx");
        k.l(ILiveService.class, new d0());
        INetworkService r1 = k.f(INetworkService.class);
        if (r1 == null) goto L5;
        r1.setEnsureProtoDecodersInjected(a.a);
    L5:
        k.l(IWidgetLiveService.class, new WidgetLiveServiceImpl());
        LiveDynamicLayoutInit.INSTANCE.initLiveDynamicLayout();
        Task.callInBackground(b.a);
        IHostService r2 = TTMiddlewareLiveSDK.sHostService;
        if (r2 == null) goto L10;
        new SDKServiceInitTask(r2).start();
        new TaskManagerInitTask().start();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.IHostService");
    }

    private LiveCompleteAfterInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveCompleteAfterInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_AFTER;
    }
}
