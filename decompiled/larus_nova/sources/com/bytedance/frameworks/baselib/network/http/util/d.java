package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f244781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244782b;

    public final String toString() {
        return new String(this.f244781a, 0, this.f244782b);
    }

    public d(int r100) {
        if (r100 < 0) goto L7;
        this.f244781a = new char[r100];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        int r101 = r100.length();
        int r102 = this.f244782b + r101;
        char[] r103 = this.f244781a;
        if (r102 <= r103.length) goto L7;
        char[] r104 = new char[Math.max(r103.length << 1, r102)];
        System.arraycopy(this.f244781a, 0, r104, 0, this.f244782b);
        this.f244781a = r104;
    L7:
        r100.getChars(0, r101, this.f244781a, this.f244782b);
        this.f244782b = r102;
    }
}
