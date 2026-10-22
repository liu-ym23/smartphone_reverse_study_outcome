package xma;

import android.graphics.Insets;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f564553e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f564554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f564557d;

    static {
        f564553e = new b(0, 0, 0, 0);
    }

    public final Insets c() {
        return Insets.of(this.f564554a, this.f564555b, this.f564556c, this.f564557d);
    }

    public final int hashCode() {
        return (((((this.f564554a * 31) + this.f564555b) * 31) + this.f564556c) * 31) + this.f564557d;
    }

    public final String toString() {
        return "Insets{left=" + this.f564554a + ", top=" + this.f564555b + ", right=" + this.f564556c + ", bottom=" + this.f564557d + '}';
    }

    public static b b(Insets r100) {
        return a(r100.left, r100.top, r100.right, r100.bottom);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L23;
        b r101 = (b) r100;
        if (this.f564557d == r101.f564557d) goto L14;
        return false;
    L14:
        if (this.f564554a == r101.f564554a) goto L17;
        return false;
    L17:
        if (this.f564556c == r101.f564556c) goto L20;
        return false;
    L20:
        if (this.f564555b == r101.f564555b) goto L22;
        return false;
    L22:
        return true;
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f564554a = r100;
        this.f564555b = r101;
        this.f564556c = r102;
        this.f564557d = r103;
    }

    public static b a(int r100, int r101, int r102, int r103) {
        if (r100 != 0) goto L9;
        if (r101 != 0) goto L9;
        if (r102 != 0) goto L9;
        if (r103 != 0) goto L9;
        return f564553e;
    L9:
        return new b(r100, r101, r102, r103);
    }
}
