package com.bytedance.android.shopping.prepurchase.arch.exposure;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements h {
    public static final c d = null;
    public final Map<l, c> a;
    public final h b;
    public final f c;

    public static final class a {
    }

    static {
        d = new c(0, 0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
    public final c a(l r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        c r0 = (c) ((LinkedHashMap) this.a).get(r6);
        c r1 = d;
        if (r0 != null) goto L9;
        r0 = this.b.a(r6);
        Map<l, c> r2 = this.a;
        if (r0 != null) goto L7;
        c r3 = r1;
    L8:
        r2.put(r6, r3);
        goto L9
    L7:
        r3 = r0;
    L9:
        f r4 = this.c;
        if (r4 == null) goto L13;
        r4.d("Exposure", "getExposureInfo view=" + r6 + " impression=" + r0);
    L13:
        if (Intrinsics.areEqual(r0, r1) == false) goto L16;
        return null;
    L16:
        return r0;
    }

    public j(h r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.b = r2;
        this.c = r3;
        this.a = new LinkedHashMap();
    }
}
