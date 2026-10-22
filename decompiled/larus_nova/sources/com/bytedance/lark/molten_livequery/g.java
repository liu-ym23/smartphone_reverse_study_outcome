package com.bytedance.lark.molten_livequery;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f253342c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253344b;

    public static final class a {
        public a() {
        }
    }

    static {
        f253342c = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f253343a == r101.f253343a) goto L12;
        return false;
    L12:
        if (this.f253344b == r101.f253344b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f253343a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f253344b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "LiveQueryIndexPath(index=" + this.f253343a + ", section=" + this.f253344b + ')';
    }

    public g(long r100, long r101) {
        this.f253343a = r100;
        this.f253344b = r101;
    }
}
