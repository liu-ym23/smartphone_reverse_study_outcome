package com.bytedance.nita.schduler;

import com.bytedance.nita.api.NitaSchdulerType;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<NitaSchdulerType, d> f266015a = null;

    static {
        f266015a = new ConcurrentHashMap();
        NitaSchdulerType[] r100 = NitaSchdulerType.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        NitaSchdulerType r103 = r100[r102];
        ConcurrentHashMap<NitaSchdulerType, d> r104 = f266015a;
        int r105 = e.f266014a[r103.ordinal()];
        if (r105 != 1) goto L7;
        d r106 = new AtOnceSchduler();
    L11:
        r104.put(r103, r106);
        r102 = r102 + 1;
        goto L3
    L7:
        if (r105 == 2) goto L9;
        r106 = new AtOnceSchduler();
        goto L11
    L9:
        r106 = new a();
        goto L11
    }
}
