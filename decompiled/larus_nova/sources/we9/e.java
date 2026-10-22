package we9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e implements xe9.c, xe9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f559420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f559422c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f559420a == r101.f559420a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559421b, r101.f559421b) == true) goto L15;
        return false;
    L15:
        if (this.f559422c == r101.f559422c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f559420a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f559421b.hashCode()) * 31;
        long r102 = this.f559422c;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OCRModel(hasText=" + this.f559420a + ", ocrText=" + this.f559421b + ", timestamp=" + this.f559422c + ')';
    }

    public e(boolean r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "ocrText");
        this.f559420a = r100;
        this.f559421b = r101;
        this.f559422c = r102;
    }
}
