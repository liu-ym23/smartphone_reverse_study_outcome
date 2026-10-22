package oa6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f522555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f522556c;

    public e() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f522554a, r101.f522554a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522555b, r101.f522555b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522556c, r101.f522556c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522554a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Throwable r104 = this.f522555b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f522556c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SlcExprErrorInfo(expr=" + this.f522554a + ", throwable=" + this.f522555b + ", code=" + this.f522556c + ')';
    }

    public e(String r100, Throwable r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f522554a = r100;
        this.f522555b = r101;
        this.f522556c = null;
    }
}
