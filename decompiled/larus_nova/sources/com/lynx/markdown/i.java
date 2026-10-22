package com.lynx.markdown;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public static long a(int r100, int r101) {
        long r102 = (0 | ((long) r100)) << 32;
        return ((long) r101) | r102;
    }

    public static long b(int r100, int r101, int r102) {
        long r103 = (((long) r100) & 2097151) << 42;
        return (((((long) r101) & 2097151) << 21) | r103) | (((long) r102) & 2097151);
    }
}
