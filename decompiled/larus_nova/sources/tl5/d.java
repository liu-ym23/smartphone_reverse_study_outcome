package tl5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f546628a;

    @Override // com.bytedance.ee.bear.contract.n.c
    public final void a() {
        RnSyncManager r100 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(this, "iRnConnectStatus");
        RnSyncManager.f236516u.remove(this);
        JSONObject r101 = new JSONObject();
        r101.put("code", 0);
        this.f546628a.b(r101);
    }

    @Override // com.bytedance.ee.bear.contract.n.c
    public final void disconnect() {
        RnSyncManager r100 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(this, "iRnConnectStatus");
        RnSyncManager.f236516u.remove(this);
        JSONObject r101 = new JSONObject();
        r101.put("code", 1);
        this.f546628a.b(r101);
    }

    public d(m r100) {
        this.f546628a = r100;
    }
}
