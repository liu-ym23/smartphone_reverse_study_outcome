package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class UnRegisterMsgCenterMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "unRegisterLiveLifeMsgCenter";
    }

    public UnRegisterMsgCenterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = y.d(r100, "eventName");
        HashMap<String, Object> r102 = y.c(r100, "extra");
        ConcurrentHashMap<Class<?>, Object> r103 = LifeServiceManager.f162660a;
        if (((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).unRegisterLiveLifeMsgCenter(r101, y.e(r102, new UnRegisterMsgCenterMethod$handleMethod$result$1(this)), UnRegisterMsgCenterMethod$handleMethod$result$2.INSTANCE) != 0) goto L6;
        return a.b(null);
    L6:
        return a.d(this, null, 3);
    }
}
