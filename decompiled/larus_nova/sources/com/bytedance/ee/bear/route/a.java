package com.bytedance.ee.bear.route;

import com.bytedance.ee.bear.domain.BearUrl;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements d {
    public a() {
    }

    public abstract String e(BearUrl r100, RouteBean r101);

    public final PostCard d(BearUrl r100, RouteBean r101) {
        PostCard r102 = ((h) org.koin.java.a.a(h.class)).yd(e(r100, r101), r101);
        if (r101 == null) goto L5;
        r102.n("extra_data_map", (Serializable) r101.f236646k);
    L5:
        return r102;
    }
}
