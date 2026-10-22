package v7b;

/* JADX INFO: loaded from: classes35.dex */
public final class l extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f553559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f553560k;

    @Override // v7b.s
    public final s h() {
        return new l(this.f553559j, this.f553560k);
    }

    @Override // v7b.s
    public final String o() {
        return "destination=" + this.f553559j + ", title=" + this.f553560k;
    }

    public l() {
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        r100.a(this);
    }

    public l(String r100, String r101) {
        this.f553559j = r100;
        this.f553560k = r101;
    }
}
