package g15;

/* JADX INFO: loaded from: classes16.dex */
public final class t implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f479606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f479607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ut5.a f479608c;

    public final void a(Boolean r100) {
        StringBuilder r101 = new StringBuilder("minutes action/state validate result, optionId = ");
        r101.append(this.f479606a);
        r101.append(", allow = ");
        Boolean r102 = Boolean.TRUE;
        r101.append(r102.equals(r100));
        r101.append(", token = ");
        r101.append(du5.b.k(this.f479607b));
        tt5.a.h("DocumentExportAction", r101.toString());
        this.f479608c.onResult(Boolean.valueOf(r102.equals(r100)));
    }

    @Override // ut5.a
    public final /* bridge */ /* synthetic */ void onResult(Boolean r100) {
        a(r100);
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        tt5.a.e("DocumentExportAction", "minutes action/state validate callback error, optionId = " + this.f479606a + ", token = " + du5.b.k(this.f479607b) + ", code = " + r100, r101, false);
        this.f479608c.onError(r100, r101);
    }

    public t(String r100, String r101, com.bytedance.ee.bear.document.export.d r102) {
        this.f479606a = r100;
        this.f479607b = r101;
        this.f479608c = r102;
    }
}
