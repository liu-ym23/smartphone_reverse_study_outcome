package t94;

import com.bytedance.bdp.appbase.locate.map.BdpMapActivity;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends h94.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdpMapActivity f545084e;

    @Override // com.bytedance.bdp.serviceapi.defaults.permission.b
    public final void b() {
        BdpMapActivity r100 = this.f545084e;
        r100.f200817t.setScale(r100.f200816s);
        this.f545084e.z1();
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.permission.b
    public final void c() {
        BdpMapActivity r100 = this.f545084e;     // Catch: Exception -> L4
        r100.f200817t.setScale(r100.f200816s);     // Catch: Exception -> L4
        this.f545084e.z1();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        g94.b.b("BdpMapActivity", new Object[]{"", e});
    }

    public e(BdpMapActivity r100) {
        this.f545084e = r100;
    }
}
