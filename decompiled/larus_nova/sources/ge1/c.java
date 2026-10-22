package ge1;

import com.bytedance.android.ec.slice.SliceInitService;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f481012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f481013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f481014c;

    public final String toString() {
        int r100 = this.f481014c;
        if (r100 > 0) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r101 = new StringBuilder(r100 * 28);
        r101.append('{');
        int r102 = 0;
    L8:
        if (r102 >= this.f481014c) goto L12;
        if (r102 <= 0) goto L11;
        r101.append(", ");
    L11:
        r101.append(this.f481012a[r102]);
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        r101.append(this.f481013b[r102]);
        r102 = r102 + 1;
        goto L8
    L12:
        r101.append('}');
        return r101.toString();
    }

    public c() {
        int r100 = 4;
    L3:
        int r101 = 80;
        if (r100 >= 32) goto L9;
        int r102 = (1 << r100) - 12;
        if (80 <= r102) goto L7;
        r100 = r100 + 1;
        goto L3
    L7:
        r101 = r102;
    L9:
        int r103 = r101 / 8;
        this.f481012a = new long[r103];
        this.f481013b = new long[r103];
        this.f481014c = 0;
    }

    public final Object clone() throws CloneNotSupportedException {
        c r100 = (c) super.clone();     // Catch: CloneNotSupportedException -> L5
        r100.f481012a = (long[]) this.f481012a.clone();     // Catch: CloneNotSupportedException -> L7
        r100.f481013b = (long[]) this.f481013b.clone();     // Catch: CloneNotSupportedException -> L7
        return r100;
    L13:
        return r100;
    L5:
        return null;
    }

    public void delete(long r100) {
        int r101 = b.a(this.f481012a, this.f481014c, r100);
        if (r101 < 0) goto L6;
        long[] r102 = this.f481012a;
        int r103 = r101 + 1;
        System.arraycopy(r102, r103, r102, r101, this.f481014c - r103);
        long[] r104 = this.f481013b;
        System.arraycopy(r104, r103, r104, r101, this.f481014c - r103);
        this.f481014c--;
        return;
    }
}
