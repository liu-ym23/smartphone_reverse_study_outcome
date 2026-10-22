package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends a<mq3.a, com.bytedance.android.window.shop.repository.tab.datasource.b> {
    public f() {
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r0 = com.bytedance.android.window.shop.c.b;
        super(com.bytedance.android.window.shop.c.f, new com.bytedance.android.window.shop.repository.tab.datasource.b());
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.impl.a
    public final void b(WindowTabDataListResponseDTODeprecated r5, List<com.bytedance.android.window.shop.repository.tab.entity.f> r6, com.bytedance.android.window.shop.repository.tab.datasource.c r7) {
        Intrinsics.checkNotNullParameter(r5, "dto");
        Intrinsics.checkNotNullParameter(r6, "voList");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ((com.bytedance.android.window.shop.repository.tab.datasource.b) this.e).b().getPageNum();
        Iterator<T> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        com.bytedance.android.window.shop.repository.tab.entity.f r1 = (com.bytedance.android.window.shop.repository.tab.entity.f) r0.next();
        if ((r1 instanceof m) == true) goto L8;
        com.bytedance.android.window.shop.repository.tab.entity.f r2 = null;
    L9:
        m r3 = (m) r2;
        if (r3 == null) goto L4;
        rq3.a r4 = r3.j;
        if (r4 == null) goto L4;
        fo.b r8 = ((WindowV2ProductItemVO) r4).C;
        if (r8 == null) goto L4;
        fo.a r9 = wn.a.C;
        Integer r10 = r1.b;
        if (r10 == null) goto L18;
        int r11 = r10.intValue();
    L19:
        r8.b(r9, Integer.valueOf(r11));
        goto L4
    L18:
        r11 = this.c;
        goto L19
    L8:
        r2 = r1;
        goto L9
    L20:
        super.b(r5, r6, r7);
    }
}
