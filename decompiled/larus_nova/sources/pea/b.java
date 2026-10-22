package pea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f528740d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f528742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pea.a f528743c;

    public static final class a {
        public static b a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "pic");
            int r102 = c.f528744e;
            return new b(c.a.a(r100, r101, null), 5);
        }
    }

    static {
    }

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f528741a == r101.f528741a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528742b, r101.f528742b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528743c, r101.f528743c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528741a * 31;
        c r101 = this.f528742b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        pea.a r105 = this.f528743c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BigIslandImageTextInfo(type=" + this.f528741a + ", picInfo=" + this.f528742b + ", textInfo=" + this.f528743c + ')';
    }

    public final int getType() {
        return this.f528741a;
    }

    public b(c r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = 1;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = null;
    L9:
        this.f528741a = r102;
        this.f528742b = r100;
        this.f528743c = null;
        return;
    L5:
        r102 = 0;
        goto L7
    }
}
