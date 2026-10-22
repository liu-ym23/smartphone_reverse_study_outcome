package rw0;

import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f539560a;

    public e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "packagesLog");
        this.f539560a = r100;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        r100.put("charge_packages", this.f539560a.f539561a);
        long r102 = this.f539560a.f539562b;
        if (r102 <= 0) goto L5;
        r100.put("recommend_package", String.valueOf(r102));
    L5:
        r100.put("discount_scores", String.valueOf(this.f539560a.f539564d));
        f r103 = this.f539560a;
        long r104 = r103.f539562b;
        if (r104 > 0) goto L8;
    L10:
        if (r104 > 0) goto L12;
    L23:
        String r105 = "default";
    L24:
        r100.put("recommend_package_source", r105);
        return;
    L12:
        if (r103.f539563c == false) goto L23;
        boolean r106 = LastCustomRechargeRecoder.f90450a;
        u r107 = r103.f539565e;
        if (r107 == null) goto L20;
        String r108 = r107.f89768f;
        if (r108 == null) goto L20;
        boolean r109 = true;
        if (r108.equals("上次使用") != true) goto L20;
    L21:
        if (r109 == false) goto L23;
        r105 = "last_recharge";
    L20:
        r109 = false;
        goto L21
    L8:
        if (r101.f90016e == false) goto L10;
        r105 = "balance";
        goto L24
    }
}
