package e96;

import android.app.Application;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements g37.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f471505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c96.c f471506b;

    public a(Application r100, c96.c r101) {
        this.f471505a = r100;
        this.f471506b = r101;
    }

    @Override // g37.c
    public final g37.d create() {
        g37.d.a r100 = new g37.d.a();
        r100.f479841a = this.f471505a;
        r100.f479845e = 3600000;
        r100.f479843c = new d(this.f471506b);
        return r100.a();
    }
}
