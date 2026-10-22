package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class OnceConfig extends InitConfig {
    @Override // com.ss.ttm.utils.InitConfig
    public void commit() {
    }

    public OnceConfig copy() {
        return new OnceConfig(this);
    }

    public OnceConfig(ReuseConfig r100) {
        if (r100 != null) goto L4;
        long r101 = 0;
    L5:
        super(r101, 0);
        return;
    L4:
        r101 = r100.nativeHandle();
        goto L5
    }

    private OnceConfig(OnceConfig r100) {
        super(r100.nativeHandle(), 1);
    }
}
