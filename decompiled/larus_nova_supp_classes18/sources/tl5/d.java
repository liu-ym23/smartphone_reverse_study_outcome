package tl5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements n.c {
    public final /* synthetic */ m a;

    public final void a() {
        RnSyncManager r0 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(this, "iRnConnectStatus");
        RnSyncManager.u.remove(this);
        JSONObject r1 = new JSONObject();
        r1.put("code", 0);
        this.a.b(r1);
    }

    public final void disconnect() {
        RnSyncManager r0 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(this, "iRnConnectStatus");
        RnSyncManager.u.remove(this);
        JSONObject r1 = new JSONObject();
        r1.put("code", 1);
        this.a.b(r1);
    }

    public d(m r1) {
        this.a = r1;
    }
}
