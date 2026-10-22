package rw0;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f539567a;

    public h(g r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDealLog");
        this.f539567a = r100;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        String r102 = r100.get("is_discount_package");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        return;
    L11:
        if (this.f539567a.f539566a.h() <= 0) goto L13;
        String r104 = "1";
    L14:
        r100.put("is_discount_package", r104);
        return;
    L13:
        r104 = "0";
        goto L14
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
