package zc1;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.bytedance.android.live.wallet.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends Object> f571230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.wallet.e.b f571231b;

    public b(com.bytedance.android.live.wallet.e.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f571231b = r100;
        this.f571230a = new HashMap();
    }

    @Override // com.bytedance.android.live.wallet.e.b
    public final void a(com.bytedance.android.live.wallet.e.c r100) {
        Integer r101 = Integer.valueOf(r100.f102670a);
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        int r102 = r100.f102670a;
        if (r102 == 4) goto L16;
        if (r102 == 5) goto L16;
    L17:
        this.f571231b.a(r100);
        return;
    L16:
        r100.f102670a = 3;
        goto L17
    L11:
        if (r101.intValue() != 5) goto L13;
        int r103 = fd1.b.f476458a;
        fd1.b.a("ttlive_wallet_pay_other_failed", 0, this.f571230a);
        goto L13
    L6:
        if (r101.intValue() != 2) goto L8;
        int r104 = fd1.b.f476458a;
        fd1.b.a("ttlive_wallet_pay_cancel", 0, this.f571230a);
        goto L13
    }

    @Override // com.bytedance.android.live.wallet.e.b
    public final void b(int r100) {
        if (r100 != 1) goto L5;
        int r101 = fd1.b.f476458a;
        fd1.b.a("ttlive_wallet_pay_query_order", 0, this.f571230a);
    L9:
        this.f571231b.b(r100);
        return;
    L5:
        if (r100 != 2) goto L9;
        int r102 = fd1.b.f476458a;
        fd1.b.a("ttlive_wallet_pay_show_cahiser", 0, this.f571230a);
        goto L9
    }
}
