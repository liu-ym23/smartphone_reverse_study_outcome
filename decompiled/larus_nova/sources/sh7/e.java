package sh7;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f541978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f541979b = null;

    public e() {
    }

    static {
        f541979b = new e();
        f541978a = true;
    }

    @Override // sh7.d
    public final void a(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L6;
        f541978a = ((Boolean) r100).booleanValue();
        return;
    }
}
