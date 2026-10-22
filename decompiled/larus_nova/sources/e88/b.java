package e88;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audioplayer.impl.music.a f471363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f471364b;

    public /* synthetic */ b(com.larus.audioplayer.impl.music.a r100, boolean r101) {
        this.f471363a = r100;
        this.f471364b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larus.audioplayer.impl.music.a r100 = this.f471363a;
        boolean r101 = this.f471364b;
        if (r100.f290269d == false) goto L5;
        return;
    L5:
        if (r100.f290270e == true) goto L10;
        r100.d(r101);
        return;
    }
}
