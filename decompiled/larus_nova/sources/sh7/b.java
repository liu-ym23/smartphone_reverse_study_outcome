package sh7;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f541975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f541976b = null;

    public b() {
    }

    static {
        f541976b = new b();
    }

    @Override // sh7.d
    public final void a(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L6;
        f541975a = ((Boolean) r100).booleanValue();
        return;
    }
}
