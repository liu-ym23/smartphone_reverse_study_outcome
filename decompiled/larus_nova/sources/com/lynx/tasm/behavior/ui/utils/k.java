package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: classes32.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f383149e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f383150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f383151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f383152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f383153d;

    public k() {
        this(0.0f);
    }

    static {
        f383149e = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
    }

    public k(float r100) {
        this.f383150a = new float[]{1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f};
        this.f383151b = 0;
        this.f383152c = r100;
    }

    public final float a(int r100) {
        if (r100 != 4) goto L5;
    L8:
        float r101 = 1.0E21f;
    L9:
        int r102 = this.f383151b;
        if (r102 != 0) goto L12;
        return r101;
    L12:
        int[] r103 = f383149e;
        if ((r103[r100] & r102) == 0) goto L17;
        return this.f383150a[r100];
    L17:
        if (this.f383153d == true) goto L19;
    L33:
        return r101;
    L19:
        if (r100 != 1) goto L21;
    L24:
        char r104 = 7;
    L26:
        if ((r103[r104] & r102) == 0) goto L30;
        return this.f383150a[r104];
    L30:
        if ((r102 & r103[8]) == 0) goto L33;
        return this.f383150a[8];
    L21:
        if (r100 == 3) goto L24;
        r104 = 6;
        goto L26
    L5:
        if (r100 == 5) goto L8;
        r101 = this.f383152c;
        goto L9
    }

    public final boolean b(int r100, float r101) {
        boolean r102 = false;
        if (com.lynx.tasm.utils.b.a(this.f383150a[r100], r101) == true) goto L17;
        this.f383150a[r100] = r101;
        boolean r103 = y6a.l.a(r101);
        int[] r104 = f383149e;
        if (r103 == false) goto L7;
        int r105 = this.f383151b;
        this.f383151b = (~r104[r100]) & r105;
    L8:
        int r106 = this.f383151b;
        if ((r104[8] & r106) == 0) goto L11;
    L14:
        r102 = true;
    L15:
        this.f383153d = r102;
        return true;
    L11:
        if ((r104[7] & r106) != 0) goto L14;
        if ((r106 & r104[6]) == 0) goto L15;
    L7:
        int r107 = this.f383151b;
        this.f383151b = r104[r100] | r107;
        goto L8
    L17:
        return false;
    }
}
