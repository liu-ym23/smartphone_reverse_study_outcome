package kotlinx.coroutines;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f505001a;

    @Override // kotlinx.coroutines.x0
    public final j1 getList() {
        return null;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Empty{");
        if (this.f505001a == false) goto L5;
        String r101 = "Active";
    L6:
        r100.append(r101);
        r100.append('}');
        return r100.toString();
    L5:
        r101 = "New";
        goto L6
    }

    @Override // kotlinx.coroutines.x0
    public final boolean isActive() {
        return this.f505001a;
    }

    public p0(boolean r100) {
        this.f505001a = r100;
    }
}
