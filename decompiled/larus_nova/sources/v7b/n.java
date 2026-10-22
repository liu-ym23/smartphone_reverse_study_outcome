package v7b;

/* JADX INFO: loaded from: classes35.dex */
public final class n extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f553561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f553562k;

    @Override // v7b.s
    public final s h() {
        return new n(this.f553561j, this.f553562k);
    }

    @Override // v7b.s
    public final String o() {
        return "destination=" + this.f553561j + ", title=" + this.f553562k;
    }

    public n() {
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        r100.a(this);
    }

    public n(String r100, String r101) {
        this.f553561j = r100;
        this.f553562k = r101;
    }
}
