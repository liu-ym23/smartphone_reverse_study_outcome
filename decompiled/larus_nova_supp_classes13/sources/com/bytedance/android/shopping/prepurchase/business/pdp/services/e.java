package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements f0 {
    public final List<Function1<String, String>> a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> b;

    public e(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.a = new ArrayList();
    }

    @Override // vg3.f0
    public final void A1(Function1<? super String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.a).add(r2);
    }

    @Override // vg3.f0
    public final boolean openSchema(String r9) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Iterator r0 = ((ArrayList) this.a).iterator();
        String r2 = r9;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = (String) ((Function1) r0.next()).invoke(r2);
        goto L4
    L6:
        FragmentActivity r1 = this.b.getContainerAbility().mo2525getContext();
        if (r1 != null) goto L11;
        return false;
    L11:
        if (ECLiveHybridUtil.i(r2) == false) goto L13;
        ECLiveHybridUtil.k(r1, r2, false, false, ((com.bytedance.android.shopping.prepurchase.business.pdp.e) this.b.f().b).b.a, "ecom_pdp", 92);
        return true;
    L13:
        p r10 = p.a;
        int r3 = y.a;
        r10.d(y.g(r2), r1);
        return true;
    }
}
