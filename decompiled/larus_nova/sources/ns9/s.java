package ns9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f520406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520407c;

    /* JADX WARN: Multi-variable type inference failed */
    public s() {
        int r100 = 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, null, r101, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f520405a == r101.f520405a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520406b, r101.f520406b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520407c, r101.f520407c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520405a * 31;
        Long r101 = this.f520406b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f520407c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachPolicy(priority=" + this.f520405a + ", durationMs=" + this.f520406b + ", dismissal=" + this.f520407c + ')';
    }

    public s(int r100, Long r101, String r102) {
        this.f520405a = r100;
        this.f520406b = r101;
        this.f520407c = r102;
    }

    public /* synthetic */ s(int r100, Long r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
