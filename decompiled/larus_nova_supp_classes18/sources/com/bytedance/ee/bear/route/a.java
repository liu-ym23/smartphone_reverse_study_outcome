package com.bytedance.ee.bear.route;

import com.bytedance.ee.bear.domain.BearUrl;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements d {
    public a() {
    }

    public abstract String e(BearUrl r1, RouteBean r2);

    public final PostCard d(BearUrl r2, RouteBean r3) {
        PostCard r4 = ((h) org.koin.java.a.a(h.class)).yd(e(r2, r3), r3);
        if (r3 == null) goto L5;
        r4.n("extra_data_map", (Serializable) r3.k);
    L5:
        return r4;
    }
}
