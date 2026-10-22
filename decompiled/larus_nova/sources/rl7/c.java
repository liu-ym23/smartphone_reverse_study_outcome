package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatTransToDouyinAuth", owner = "xiaojunpeng")
public final class c extends ok7.a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckycatTransToDouyinAuth";
    }

    public c() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_start_bind_douyin", null);
        ik7.a r102 = m.f538350d;
        if (r102 == null) goto L8;
        com.bytedance.ug.sdk.luckycat.api.depend.c r103 = ((dn7.a) r102).f469363a;
        if (r103 == null) goto L9;
        r103.b();
        return;
    L9:
        return;
    }
}
