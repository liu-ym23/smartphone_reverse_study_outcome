package jtc;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f500393c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f500394d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f500396b;

    static {
        f[] r100 = new f[256];
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L5;
        r100[r101] = new f((byte) r101);
        r101 = r101 + 1;
        goto L3
    L5:
        f500393c = r100[0];
        f500394d = r100[1];
    }

    public final String toString() {
        return this.f500395a;
    }

    public f(byte r100) {
        char[] r101 = new char[2];
        io.opentelemetry.api.internal.j.a(r100, r101, 0);
        this.f500395a = new String(r101);
        this.f500396b = r100;
    }
}
