package g15;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements ut5.a<Boolean> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ut5.a c;

    public final void a(Boolean r4) {
        StringBuilder r0 = new StringBuilder("minutes action/state validate result, optionId = ");
        r0.append(this.a);
        r0.append(", allow = ");
        Boolean r1 = Boolean.TRUE;
        r0.append(r1.equals(r4));
        r0.append(", token = ");
        r0.append(du5.b.k(this.b));
        tt5.a.h("DocumentExportAction", r0.toString());
        this.c.onResult(Boolean.valueOf(r1.equals(r4)));
    }

    public final /* bridge */ /* synthetic */ void onResult(Object r1) {
        a((Boolean) r1);
    }

    public final void onError(int r4, Throwable r5) {
        tt5.a.e("DocumentExportAction", "minutes action/state validate callback error, optionId = " + this.a + ", token = " + du5.b.k(this.b) + ", code = " + r4, r5, false);
        this.c.onError(r4, r5);
    }

    public t(String r1, String r2, com.bytedance.ee.bear.document.export.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
