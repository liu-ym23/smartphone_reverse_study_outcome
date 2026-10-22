package com.bytedance.tools.kcp.modelx.runtime.internal;

/* JADX INFO: loaded from: classes22.dex */
public final class a<V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f270943j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object[] f270944k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f270945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f270946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f270947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f270948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f270949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final V[] f270950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f270951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public V f270952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f270953i;

    static {
        f270943j = new int[0];
        f270944k = new Object[0];
    }

    public a(int r100, float r101) {
        if (r100 != 0) goto L5;
        this.f270949e = f270943j;
        this.f270950f = (V[]) f270944k;
    L6:
        this.f270945a = r101;
        this.f270946b = (int) (r100 * r101);
        int r102 = r100 - 1;
        this.f270948d = r102;
        this.f270947c = Long.numberOfLeadingZeros(r102);
        return;
    L5:
        this.f270949e = new int[r100];
        this.f270950f = (V[]) new Object[r100];
        goto L6
    }
}
