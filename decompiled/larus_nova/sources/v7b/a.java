package v7b;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a extends s {
    @Override // v7b.s
    public final s i() {
        return (a) this.f553568d;
    }

    public a() {
    }

    @Override // v7b.s
    public final void m(s r100) {
        if ((r100 instanceof a) == false) goto L7;
        this.f553568d = r100;
        return;
    L7:
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
