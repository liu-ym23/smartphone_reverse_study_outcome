package uw0;

import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import kotlin.jvm.internal.Intrinsics;
import tw0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f551917a;

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        this.f551917a = r100;
    }

    @Override // uw0.b
    public final k a(k r110) {
        Intrinsics.checkNotNullParameter(r110, "orderOptions");
        NoPasswordPayType.a r100 = NoPasswordPayType.Companion;
        int r101 = this.f551917a.getOrderType();
        r100.getClass();
        NoPasswordPayType[] r102 = NoPasswordPayType.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        NoPasswordPayType r105 = r102[r104];
        if (r105.getValue() != r101) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 != null) goto L14;
        NoPasswordPayType r107 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
    L16:
        return k.a(r110, null, null, null, r107, 7167);
    L14:
        r107 = r105;
        goto L16
    L7:
        r106 = false;
        goto L8
    L11:
        r105 = null;
        goto L12
    }
}
