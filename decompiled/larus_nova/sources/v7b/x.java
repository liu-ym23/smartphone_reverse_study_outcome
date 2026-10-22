package v7b;

import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f553578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553580c;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f553578a), Integer.valueOf(this.f553579b), Integer.valueOf(this.f553580c)});
    }

    public final String toString() {
        return "SourceSpan{line=" + this.f553578a + ", column=" + this.f553579b + ", length=" + this.f553580c + com.alipay.sdk.m.u.i.f25855d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (x.class != r100.getClass()) goto L19;
        x r101 = (x) r100;
        if (this.f553578a == r101.f553578a) goto L13;
    L17:
        return false;
    L13:
        if (this.f553579b != r101.f553579b) goto L17;
        if (this.f553580c != r101.f553580c) goto L17;
        return true;
    }

    public x(int r100, int r101, int r102) {
        this.f553578a = r100;
        this.f553579b = r101;
        this.f553580c = r102;
    }
}
