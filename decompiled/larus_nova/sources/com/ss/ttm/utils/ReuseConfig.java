package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class ReuseConfig extends InitConfig {
    public ReuseConfig(ReuseConfig r100, int r101) {
        if (r100 != null) goto L4;
        long r102 = 0;
    L5:
        super(r102, r101);
        if (r100 == null) goto L10;
        if (r101 != 0) goto L11;
        r100.commit();
        return;
    L11:
        return;
    L10:
        return;
    L4:
        r102 = r100.nativeHandle();
        goto L5
    }
}
