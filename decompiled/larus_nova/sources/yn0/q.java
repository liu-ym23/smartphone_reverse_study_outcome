package yn0;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements l81.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f568513a = null;

    public q() {
    }

    static {
        f568513a = new q();
    }

    @Override // l81.q
    public final RechargeCurrentCacheData getCurrentRechargeCacheDataObject() {
        IRechargeServiceExternal r100 = (IRechargeServiceExternal) jc1.k.f(IRechargeServiceExternal.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentRechargeCacheDataObject();
    }
}
