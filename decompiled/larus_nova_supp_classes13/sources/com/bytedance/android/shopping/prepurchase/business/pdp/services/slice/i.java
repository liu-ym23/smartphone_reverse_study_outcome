package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements j73.h {
    public final w a;

    public final PageFinder getPageFinder() {
        return this.a.getPageFinder();
    }

    public i(w r2) {
        Intrinsics.checkNotNullParameter(r2, "eventAbility");
        this.a = r2;
    }

    public final void H(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "label");
        Intrinsics.checkNotNullParameter(r4, "map");
        w.a.a(this.a, r3, r4, 4);
    }

    public final void n(String r9, Map<String, ? extends Object> r10, boolean r11, boolean r12, String r13, PageFinder r14) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        m r15 = this.a.m().d(r10);
        if (r15 == null) goto L13;
        if (r13 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        Intrinsics.checkNotNull(r13);
        m.a.a(r15, r13, false, null, r14, 6);
    L12:
        Boolean r16 = Boolean.valueOf(m.a.a(r15, r9, r12, null, r14, 4));
    L14:
        boolean r17 = r16.booleanValue();
        if (r11 == false) goto L19;
        if (r17 != true) goto L20;
        w.a.a(this.a, r9, null, 6);
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (r13.length() == 0) goto L9;
        r1 = false;
        goto L10
    L13:
        r16 = null;
        goto L14
    }
}
