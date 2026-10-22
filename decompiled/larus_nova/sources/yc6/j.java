package yc6;

import android.content.Context;
import com.bytedance.android.live.recharge.q0;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import oc6.z;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements z, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i12.c f567188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.i f567189b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // oc6.z
    public final void openRechargeDialog() {
        com.bytedance.android.live.recharge.i r100 = this.f567189b;
        Context r101 = com.bytedance.live.kmp.util.c.f255167a.getContext();
        String r102 = this.f567188a.f487945e;
        r100.openRechargeDialog(r101, new q0("click", 88));
    }

    public j(i12.c r100, com.bytedance.android.live.recharge.i r101) {
        Intrinsics.checkNotNullParameter(r100, "locationInfo");
        Intrinsics.checkNotNullParameter(r101, "walletService");
        this.f567188a = r100;
        this.f567189b = r101;
    }
}
