package w4a;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f558281b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558282a;

    static {
        f558281b = new e("default");
    }

    public final int hashCode() {
        return this.f558282a.hashCode();
    }

    public final String toString() {
        return this.f558282a;
    }

    public e(String r100) {
        this.f558282a = r100.toLowerCase();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L10;
        return false;
    L10:
        return this.f558282a.equals(((e) r100).f558282a);
    }
}
