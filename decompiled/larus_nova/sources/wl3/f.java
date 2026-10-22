package wl3;

/* JADX INFO: loaded from: classes14.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560192a;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return this.f560192a.hashCode();
    }

    public f(String r100) {
        this.f560192a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == true) goto L5;
        r100 = null;
    L5:
        f r101 = (f) r100;
        if (r101 == null) goto L12;
        String r102 = r101.f560192a;
        if (r102 == null) goto L12;
        if (r102.equals(this.f560192a) != true) goto L12;
        return true;
    L12:
        return false;
    }
}
