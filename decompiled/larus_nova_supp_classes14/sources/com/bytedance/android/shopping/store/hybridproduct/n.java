package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements com.bytedance.android.ec.hybrid.list.ability.j0 {
    public n() {
    }

    public final void release() {
    }

    public final int Dv(ECHybridListItemVO r6) {
        Intrinsics.checkNotNullParameter(r6, "vo");
        IntRange r1 = m0.a;
        Intrinsics.checkNotNullParameter(r6, "vo");
        Integer r0 = r6.c;
        int r2 = 0;
        if (r0 == null) goto L38;
        int r3 = r0.intValue();
        int r4 = com.bytedance.android.ec.store.window.a.a;
        ECHybridListItemType.a r5 = ECHybridListItemType.Companion;
        r5.getClass();
        if (ECHybridListItemType.a.a(r3) == false) goto L39;
        Integer r7 = r6.c;
        if (r7 == null) goto L10;
        int r8 = r7.intValue();
    L11:
        Integer r9 = Integer.valueOf(r8);
        Integer r10 = r6.i();
        if (r10 == null) goto L14;
        int r11 = r10.intValue();
    L16:
        if (r11 < 2) goto L18;
        boolean r12 = true;
    L19:
        if (r9 == null) goto L24;
        int r13 = r9.intValue();
        r5.getClass();
        if (ECHybridListItemType.a.a(r13) == true) goto L24;
        int r14 = r9.intValue();
    L40:
        return r14;
    L24:
        if (r9 == null) goto L27;
        r2 = r9.intValue();
    L27:
        if (m0.a.contains(r2) == false) goto L29;
        m0.a r15 = m0.c;
    L30:
        if (r12 == false) goto L32;
        ConcurrentHashMap<Integer, Integer> r16 = r15.b;
    L33:
        Integer r17 = r16.get(Integer.valueOf(r2));
        if (r17 == null) goto L36;
        r14 = r17.intValue();
        goto L40
    L36:
        int r18 = r15.d.getAndIncrement();
        r16.put(Integer.valueOf(r2), Integer.valueOf(r18));
        r15.c.put(Integer.valueOf(r18), Integer.valueOf(r2));
        return r18;
    L32:
        r16 = r15.a;
        goto L33
    L29:
        r15 = m0.b;
        goto L30
    L18:
        r12 = false;
        goto L19
    L14:
        r11 = 0;
        goto L16
    L10:
        r8 = 0;
        goto L11
    L39:
        return r3;
    L38:
        return 0;
    }
}
