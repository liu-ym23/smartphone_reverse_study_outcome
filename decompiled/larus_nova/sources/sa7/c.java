package sa7;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends ua7.a<ua7.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f541183a;

    public c(e r100) {
        this.f541183a = r100;
    }

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        e r101 = this.f541183a;
        r101.f541189c.onResponse(new ua7.f((ua7.d) r100, "logout_all", r101.f541187a));
    }
}
