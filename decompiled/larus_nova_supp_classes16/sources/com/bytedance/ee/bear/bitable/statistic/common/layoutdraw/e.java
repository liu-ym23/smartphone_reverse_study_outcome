package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final long[] a;
    public final int[] b;
    public final int[] c;
    public final long[] d;
    public final int[] e;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = new long[]{0, 0};
        this.b = new int[]{0, 0};
        this.c = new int[]{0, 0};
        this.d = new long[]{0, 0};
        this.e = new int[]{0, 0};
    }

    public final void a(int r6, int r7) {
        long[] r0 = this.a;
        long r3 = r7;
        r0[r6] = r0[r6] + r3;
        int[] r1 = this.b;
        r1[r6] = r1[r6] + 1;
        int[] r2 = this.c;
        r2[r6] = Math.max(r2[r6], r7);
        if (r7 < 10) goto L6;
        long[] r8 = this.d;
        r8[r6] = r8[r6] + r3;
        int[] r9 = this.e;
        r9[r6] = r9[r6] + 1;
        return;
    }
}
