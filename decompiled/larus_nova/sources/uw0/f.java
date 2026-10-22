package uw0;

import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import kotlin.jvm.internal.Intrinsics;
import tw0.l;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f551920a;

    public f(l r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        this.f551920a = r100;
    }

    @Override // uw0.b
    public final k a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "orderOptions");
        String r101 = this.f551920a.getPreCalcInfo();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L11:
        j r103 = r100.f90118a;
        String r104 = this.f551920a.t7();
        String r105 = "";
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r103.put("giving_diamond_badge", r104);
        String r106 = this.f551920a.t4();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r103.put("giving_diamond_bar", r106);
        String r107 = this.f551920a.getPreCalcInfo();
        if (r107 == null) goto L21;
        r105 = r107;
    L21:
        r103.put("pre_calc_info", r105);
        return r100;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
