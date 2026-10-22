package gc7;

import com.bytedance.sdk.account.impl.m;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends hc7.a<d.c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kc7.c f480861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ic7.d f480862d;

    @Override // hc7.a
    public final d.c a() {
        kc7.c r100 = this.f480861c;
        if (r100 == null) goto L56;
        d.c r101 = new d.c(0, null);
        int r102 = r100.getType();
        kc7.c r103 = this.f480861c;
        String r104 = r103.f502415c;
        long r105 = r103.f502416d;
        jc7.b r106 = jc7.b.a.f498144a;
        a r107 = new a(this, r106, r102, r104, r105, r101);
        r106.getClass();
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10 Exception -> L24
    L14:
        r107.a();     // Catch: Throwable -> L10 Exception -> L24
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10 Exception -> L24
    L54:
    L32:
        e = move-exception;
        e.printStackTrace();
    L35:
        return r101;
    L27:
        if (r106.b() == false) goto L35;
        if (r106.f498143b.inTransaction() == false) goto L35;
        r106.f498143b.endTransaction();     // Catch: Exception -> L32
        goto L35
    L16:
        if (r106.b() == false) goto L54;
        if (r106.f498143b.inTransaction() == false) goto L54;
        r106.f498143b.setTransactionSuccessful();     // Catch: Throwable -> L10 Exception -> L21
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
    L42:
        e = move-exception;
        e.printStackTrace();
    L44:
        throw th;
    L37:
        if (r106.b() == false) goto L44;
        if (r106.f498143b.inTransaction() == false) goto L44;
        r106.f498143b.endTransaction();     // Catch: Exception -> L42
        goto L44
    L7:
        if (r106.b() == false) goto L14;
        r106.f498143b.beginTransaction();     // Catch: Throwable -> L10 Exception -> L12
    L56:
        return new d.c(-6, "登录数据为空");
    }

    @Override // hc7.a
    public final void c(d.c r100) {
        d.c r101 = r100;
        if (this.f480862d == null) goto L11;
        int r102 = r101.f480875a;
        if (r102 != 0) goto L8;
        tb7.a.a("BDAccountManager", "SaveService.saveLoginInfo success");
        return;
    L8:
        tb7.a.a("BDAccountManager", "SaveService.saveLoginInfo error: code=" + r102 + " msg=" + r101.f480876b);
        return;
    }

    public b(kc7.c r100, m r101) {
        this.f480861c = r100;
        this.f480862d = r101;
    }
}
