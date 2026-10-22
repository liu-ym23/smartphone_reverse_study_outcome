package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements cq5.a.b {
    public final /* synthetic */ WikiHomeFragment2 a;

    public d(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    @Override // cq5.a.b
    public final void a(WikiSpaceFilter r4) {
        Intrinsics.checkNotNullParameter(r4, "filter");
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        r0.Z90().sortAndFilter(r4);
        if (r4.isEmptyFilter() == false) goto L5;
        gq5.d.f("mobile_reset", "none", Boolean.TRUE, 8);
        return;
    L5:
        gq5.d.e("mobile_confirm", "none", Boolean.TRUE, r4.getSpaceClassId());
    }
}
