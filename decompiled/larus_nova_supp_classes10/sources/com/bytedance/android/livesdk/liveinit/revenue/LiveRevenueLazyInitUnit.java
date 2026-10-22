package com.bytedance.android.livesdk.liveinit.revenue;

import com.bytedance.android.live.layer.livelink.LiveRevLinkLayerService;
import com.bytedance.android.live.revenue.RevenueInitializer;
import com.bytedance.android.live.revenue.e;
import com.bytedance.android.live.revlink.impl.RevLinkService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/revenue/LiveRevenueLazyInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "getUnitKey", "", "postDelayTime", "Lcom/bytedance/android/livesdk/init/InitThread;", "lazyInitThread", "", "initialize", "Lcom/bytedance/android/live/revenue/e;", "serviceInitializer", "Lcom/bytedance/android/live/revenue/e;", "<init>", "()V", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRevenueLazyInitUnit extends AbsLiveInitUnit {
    public static final LiveRevenueLazyInitUnit INSTANCE = null;
    private static final e serviceInitializer = null;

    static {
        INSTANCE = new LiveRevenueLazyInitUnit();
        serviceInitializer = new e();
    }

    public void initialize() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getRevenueInitPre() == true) goto L5;
        RevenueInitializer.INSTANCE.ensureInitialized();
    L5:
        serviceInitializer.a();
        new RevLinkService();
        new LiveRevLinkLayerService();
    }

    public InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getRevenueLazy());
    }

    public long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getRevenueDelayTime();
    }

    private LiveRevenueLazyInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveRevenueLazyInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }
}
