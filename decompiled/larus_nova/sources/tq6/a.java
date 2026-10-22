package tq6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f547213c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f547214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547215b;

    /* JADX INFO: renamed from: tq6.a$a, reason: collision with other inner class name */
    public static final class C7761a {
        public static a a() {
            return new a(-1);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f547214a == r101.f547214a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547215b, r101.f547215b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f547214a * 31;
        String r101 = this.f547215b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DitoNodeOpResp(state=" + this.f547214a + ", message=" + this.f547215b + ')';
    }

    public a(int r100) {
        this.f547214a = r100;
        this.f547215b = null;
    }
}
