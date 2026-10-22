package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f215646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f215647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f215648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f215649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f215650e;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f215646a = new long[]{0, 0};
        this.f215647b = new int[]{0, 0};
        this.f215648c = new int[]{0, 0};
        this.f215649d = new long[]{0, 0};
        this.f215650e = new int[]{0, 0};
    }

    public final void a(int r100, int r101) {
        long[] r102 = this.f215646a;
        long r103 = r101;
        r102[r100] = r102[r100] + r103;
        int[] r104 = this.f215647b;
        r104[r100] = r104[r100] + 1;
        int[] r105 = this.f215648c;
        r105[r100] = Math.max(r105[r100], r101);
        if (r101 < 10) goto L6;
        long[] r106 = this.f215649d;
        r106[r100] = r106[r100] + r103;
        int[] r107 = this.f215650e;
        r107[r100] = r107[r100] + 1;
        return;
    }
}
