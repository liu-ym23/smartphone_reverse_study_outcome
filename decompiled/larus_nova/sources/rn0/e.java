package rn0;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements nn0.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f538660a;

    public e(b r100) {
        this.f538660a = r100;
    }

    @Override // nn0.b.a
    public final void onError(Throwable r100) {
        this.f538660a.f538652g.f509971e.a("LayoutConfigResManager", "tryPreloadGeckoRes: load failed, throwable: " + r100, true);
    }

    @Override // nn0.b.a
    public final void onSuccess(String r100) {
        this.f538660a.f538652g.f509971e.a("LayoutConfigResManager", "tryPreloadGeckoRes: load success, filePath: " + r100, true);
    }
}
