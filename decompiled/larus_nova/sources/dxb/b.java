package dxb;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f470452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f470453c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f470454d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470455a;

    public static final class a {
    }

    static {
        f470452b = new b("larkweb");
        f470453c = new b("chameleon");
        f470454d = new b("unknown");
    }

    public final String a() {
        String r100 = this.f470455a;
        if (r100 != null) goto L6;
        return "unknown";
    L6:
        return r100;
    }

    public b(String r100) {
        this.f470455a = r100;
    }
}
