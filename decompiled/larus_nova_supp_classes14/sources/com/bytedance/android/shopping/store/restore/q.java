package com.bytedance.android.shopping.store.restore;

import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public n a;
    public m b;
    public boolean c;
    public final LinkedHashMap<Integer, c> d;
    public final LinkedHashMap<Integer, k> e;
    public final LinkedHashMap<Integer, a> f;
    public final LinkedHashMap<Integer, b> g;
    public final d h;

    public q() {
        d r0 = (d) ShopPageRestoreStores.a.getValue();
        Intrinsics.checkNotNullParameter(r0, "fullStore");
        this.h = r0;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public static void b(String r1) {
        dm.a.a("ec_shop_restore").a(r1);
    }

    public final boolean a(int r4) {
        m r0 = this.b;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.d.h.containsKey(Integer.valueOf(r4)) == false) goto L9;
        if (r0.e.containsKey(Integer.valueOf(r4)) == false) goto L9;
        return true;
    }

    public final void c(ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        if (r.a() == true) goto L6;
        return;
    L6:
        if (r4.getHeaderArea().getValue() == null) goto L8;
        return;
    L8:
        m r0 = this.b;
        if (r0 == null) goto L18;
        s r1 = r0.d;
        if (r1 == null) goto L19;
        com.bytedance.android.shopping.store.home.entity.n r2 = r1.f;
        if (r2 != null) goto L16;
        return;
    L16:
        r4.applyCachedHeaderArea(r2);
        b("coordinator_restore_header key=" + r1.a + " brand=" + r2.d() + " framework=" + r2.a());
        return;
    L19:
        return;
    }
}
