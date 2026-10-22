package com.bytedance.ee.bear.more.itemv2.mainnav;

import com.bytedance.ee.bear.more.protocol3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements m {
    public final /* synthetic */ b a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r0 = this.a.c();
        if (r0 != null) goto L5;
    L10:
        return false;
    L5:
        if (r0.m() == true) goto L10;
        wb5.d r1 = this.a.c;
        if (r1 == null) goto L10;
        return r1.a;
    }

    public d(b r1) {
        this.a = r1;
    }
}
