package com.bytedance.lark.molten_livequery;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f253345b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253346a;

    public static final class a {
        public a() {
        }
    }

    static {
        f253345b = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f253346a == ((h) r100).f253346a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f253346a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "LiveQuerySnapshot(version=" + this.f253346a + ')';
    }

    public h(long r100) {
        this.f253346a = r100;
    }
}
