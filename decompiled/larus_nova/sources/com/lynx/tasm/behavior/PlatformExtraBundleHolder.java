package com.lynx.tasm.behavior;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class PlatformExtraBundleHolder {
    private final Map<Integer, Object> mBundleHolder;

    public static PlatformExtraBundleHolder generateHolder() {
        return new PlatformExtraBundleHolder();
    }

    private PlatformExtraBundleHolder() {
        this.mBundleHolder = new HashMap();
    }

    public Object getBundle(int r100) {
        return this.mBundleHolder.get(Integer.valueOf(r100));
    }

    public void putBundle(int r100, Object r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.mBundleHolder.put(Integer.valueOf(r100), r101);
    }
}
