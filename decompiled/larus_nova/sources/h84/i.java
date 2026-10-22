package h84;

import com.bytedance.bdinstall.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements e.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f484128a;

    @Override // h84.e.c
    public final String getCache() {
        return this.f484128a.a("udid");
    }

    public i(e r100) {
        this.f484128a = r100;
    }

    @Override // h84.e.c
    public final boolean a(String r100) {
        return c1.h(r100);
    }

    @Override // h84.e.c
    public final void c(String r100) {
        e r101 = this.f484128a;
        r101.c("udid", r100);
    }

    @Override // h84.e.c
    public final boolean b(String r100, String r101) {
        return c1.f(r100, r101);
    }

    @Override // h84.e.c
    public final String d(String r100, String r101, e r102) {
        return (String) r102.g(r100, r101, new i(r102));
    }
}
