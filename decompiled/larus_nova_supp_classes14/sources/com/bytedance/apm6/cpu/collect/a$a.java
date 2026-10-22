package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CpuCacheItem.CpuDataType.values().length];
        a = r0;
        r0[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
