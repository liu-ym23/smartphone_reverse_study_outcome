package com.bytedance.android.tools.superkv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static long a(byte[] r7, int r8, int r9) {
        long r0 = 1;
        long r2 = 0;
        int r4 = r8;
    L4:
        if (r4 >= (r8 + r9)) goto L7;
        r0 = (r0 + ((long) r7[r4])) % 65521;
        r2 = (r2 + r0) % 65521;
        r4 = r4 + 1;
        goto L4
    L7:
        return (r2 << 16) + r0;
    }
}
