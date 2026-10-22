package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class p extends f {
    public final e j;
    public final WindowV2ProductItemVO k;
    public final boolean l;
    public final boolean m;

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final String b() {
        WindowV2ProductItemVO r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public p(e r1, tq3.c r2, boolean r3, boolean r4, int r5) {
        super(r5);
        this.j = r1;
        this.k = r2;
        this.l = r3;
        this.m = r4;
        if (r2 == null) goto L8;
        fo.b r6 = ((WindowV2ProductItemVO) r2).C;
        if (r6 == null) goto L9;
        fo.a r7 = wn.a.f;
        int r8 = com.bytedance.android.window.shop.b.a;
        Integer r9 = (Integer) r6.b(r7, Integer.valueOf((-1073741825) & r5));
        return;
    L9:
        return;
    }
}
