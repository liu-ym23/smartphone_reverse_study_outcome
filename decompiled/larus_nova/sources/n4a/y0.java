package n4a;

/* JADX INFO: loaded from: classes32.dex */
public final class y0 extends b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f517957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f517958d;

    public y0(x0 r100) {
        super(r100);
        this.f517957c = new StringBuilder();
        this.f517958d = true;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) {
        byte[] r101 = f5.j(this.f517957c.toString());
        this.f517164b = r101;
        this.f517958d = true;
        StringBuilder r102 = this.f517957c;
        r102.delete(0, r102.length());
        return r101;
    }

    @Override // n4a.b1
    public final void c(byte[] r100) {
        String r101 = f5.d(r100);
        if (this.f517958d == false) goto L5;
        this.f517958d = false;
    L6:
        StringBuilder r102 = this.f517957c;
        r102.append("{\"log\":\"");
        r102.append(r101);
        r102.append("\"}");
        return;
    L5:
        this.f517957c.append(",");
        goto L6
    }
}
