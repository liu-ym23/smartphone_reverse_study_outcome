package am3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends d<a> {
    public final int f;
    public final int g;

    @Override // am3.d, am3.f
    public final void a() {
        this.e = this.f;
        a r0 = (a) this.c;
        r0.c = this.g;
    }

    @Override // am3.d, am3.f
    public final f b() {
        return new i(this);
    }

    public i(i r4) {
        T r1 = r4.c;
        a r0 = new a((a) r1, ((a) r1).c);
        int r2 = r4.e;
        super(r0, r2, r4.d);
        this.f = r2;
        this.g = ((a) r4.c).c;
    }

    public i(d<?> r3) {
        a r0 = new a(r3.c);
        int r1 = r3.e;
        super(r0, r1, r3.d);
        this.f = r1;
        this.g = 0;
    }
}
