package com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode;

import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final List<Float> a;
    public final int b;
    public final HeadViewHolderBuilder c;
    public HeadViewHolderBuilder d;

    public c(HeadViewHolderBuilder r4) {
        this.c = r4;
        this.d = null;
        this.a = new ArrayList();
        int r5 = r4.c();
        this.b = r5;
        ArrayList r0 = new ArrayList(r5);
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0.add(Float.valueOf(0.0f));
        r1 = r1 + 1;
        goto L3
    L5:
        this.a = r0;
    }

    public final void a(int r5, float r6) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= this.b) goto L17;
        int r0 = ((ArrayList) this.a).size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L18;
        List<Float> r2 = this.a;
        if (r1 != r5) goto L11;
        float r3 = r6;
    L12:
        ListProtector.set(r2, r5, Float.valueOf(r3));
        r1 = r1 + 1;
        goto L7
    L11:
        r3 = 0.0f;
        goto L12
    L18:
        return;
    }
}
