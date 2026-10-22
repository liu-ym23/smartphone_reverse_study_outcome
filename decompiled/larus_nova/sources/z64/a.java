package z64;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f570452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f570453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f570454c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L23:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (this.f570452a != r101.f570452a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L22;
        if (this.f570453b != r101.f570453b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L22;
        if (this.f570454c != r101.f570454c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L22:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f570452a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f570453b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f570454c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "BadgerExtraParams(appStartTime=" + this.f570452a + ", accountInitTime=" + this.f570453b + ", lastLoginTime=" + this.f570454c + ")";
    }

    public a() {
        this(0, 0, 0);
    }

    public a(long r100, long r101, long r102) {
        this.f570452a = r100;
        this.f570453b = r101;
        this.f570454c = r102;
    }
}
