package sh7;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f541980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f541981b = null;

    public f() {
    }

    static {
        f541981b = new f();
    }

    @Override // sh7.d
    public final void a(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L6;
        f541980a = ((Boolean) r100).booleanValue();
        return;
    }
}
