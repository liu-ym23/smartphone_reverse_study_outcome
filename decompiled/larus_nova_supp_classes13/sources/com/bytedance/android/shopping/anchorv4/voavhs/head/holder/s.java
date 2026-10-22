package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.c {
    public final /* synthetic */ r c;
    public final /* synthetic */ h83.g d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.c, com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public final void b(int r4) {
        r r0 = this.c;
        h83.g r1 = this.d;
        r0.getClass();
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.i != true) goto L11;
        if (r1.j == null) goto L11;
        if (r1.l == true) goto L11;
    L12:
        if (r2 == false) goto L24;
        Context r5 = this.c.getContext();
        String r3 = null;
        if ((r5 instanceof Activity) == true) goto L16;
        r5 = null;
    L16:
        Activity r6 = (Activity) r5;
        if (r6 == null) goto L26;
        com.bytedance.android.ec.sdk.helper.p r7 = com.bytedance.android.ec.sdk.helper.p.a;
        h83.g r8 = this.d;
        if (r8 == null) goto L23;
        h83.a r9 = r8.j;
        if (r9 == null) goto L23;
        r3 = r9.b;
    L23:
        r7.d(r3, r6);
        return;
    L26:
        return;
    L24:
        super.b(r4);
        return;
    L11:
        r2 = false;
        goto L12
    }

    public s(r r1, h83.g r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3, Integer r4) {
        this.c = r1;
        this.d = r2;
        super(r3, r4);
    }
}
