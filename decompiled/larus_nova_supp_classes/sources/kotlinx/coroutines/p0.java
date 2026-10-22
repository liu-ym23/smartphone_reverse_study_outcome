package kotlinx.coroutines;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class p0 implements x0 {
    public final boolean a;

    @Override // kotlinx.coroutines.x0
    public final j1 getList() {
        return null;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Empty{");
        if (this.a == false) goto L5;
        String r1 = "Active";
    L6:
        r0.append(r1);
        r0.append('}');
        return r0.toString();
    L5:
        r1 = "New";
        goto L6
    }

    @Override // kotlinx.coroutines.x0
    public final boolean isActive() {
        return this.a;
    }

    public p0(boolean r1) {
        this.a = r1;
    }
}
