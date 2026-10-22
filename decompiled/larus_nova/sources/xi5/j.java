package xi5;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f563965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f563966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f563967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f563968d;

    public j() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f563965a == r101.f563965a) goto L12;
        return false;
    L12:
        if (this.f563966b == r101.f563966b) goto L15;
        return false;
    L15:
        if (this.f563967c == r101.f563967c) goto L18;
        return false;
    L18:
        if (this.f563968d == r101.f563968d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f563965a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f563966b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f563967c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f563968d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "UserSetting(allowShowCollaboration=" + this.f563965a + ", avatarAdminSetting=" + this.f563966b + ", recordAdminSetting=" + this.f563967c + ", avatarSetting=" + this.f563968d + ')';
    }

    public j(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f563965a = r100;
        this.f563966b = r101;
        this.f563967c = r102;
        this.f563968d = r103;
    }
}
