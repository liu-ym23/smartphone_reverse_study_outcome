package com.bytedance.android.livesdk.liveinit.revenue;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.revenue.ILiveRevenueService;
import com.bytedance.android.live.revenue.IRevenueService;
import com.bytedance.android.live.revenue.RevenueInitializer;
import com.bytedance.android.live.revenue.RevenueServiceImpl;
import com.bytedance.android.live.revenue.service.recharge.RechargeServiceKt;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.urge.ExternalGiftService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.urge.IExternalGiftService;
import com.bytedance.android.scope.m;
import e33.l;
import jc1.k;
import kotlin.Metadata;
import u13.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/revenue/LiveRevenueInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRevenueInitUnit extends AbsLiveInitUnit {
    public static final LiveRevenueInitUnit INSTANCE = null;

    static {
        INSTANCE = new LiveRevenueInitUnit();
    }

    public void initialize() {
        k.m(IPkAudienceLinkOutService.class, AnonymousClass1.INSTANCE);
        new BrowserServiceImpl();
        new RechargeServiceKt();
        k.l(IExternalGiftService.class, ExternalGiftService.INSTANCE);
        l[] r0 = a.a;
        m r1 = m.e;
        a r2 = a.b;
        r1.getClass();
        m.e(r2);
        RevenueServiceImpl r3 = new RevenueServiceImpl();
        k.l(IRevenueService.class, r3);
        k.l(ILiveRevenueService.class, r3);
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getRevenueInitPre() == false) goto L6;
        RevenueInitializer.INSTANCE.ensureInitialized();
        return;
    }

    private LiveRevenueInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveRevenueInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
