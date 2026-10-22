package ru5;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f539264a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f539265a = null;

        static {
            f539265a = new i();
        }
    }

    @Override // ru5.d
    public final boolean isLandscape() {
        return false;
    }

    public final String toString() {
        return "PortraitState{reverse=" + this.f539264a + '}';
    }

    public i() {
    }

    @Override // ru5.d
    public final boolean a() {
        return this.f539264a;
    }

    @Override // ru5.b
    public final void b(b.a r100, int r101) {
        if (r101 != (-1)) goto L6;
        return;
    L6:
        if (Math.abs(90 - r101) >= 20) goto L9;
        c r102 = c.a.f539254a;
        r102.f539253a = true;
        ((j) r100).a(r102);
        return;
    L9:
        if (Math.abs(270 - r101) >= 20) goto L12;
        c r103 = c.a.f539254a;
        r103.f539253a = false;
        ((j) r100).a(r103);
        return;
    L12:
        if (this.f539264a == false) goto L19;
        if (Math.abs(360 - r101) >= 70) goto L16;
    L17:
        this.f539264a = false;
        ((j) r100).a(this);
        return;
    L16:
        if (Math.abs(r101) < 70) goto L17;
    L19:
        if (this.f539264a == false) goto L21;
        return;
    L21:
        if (Math.abs(180 - r101) >= 70) goto L28;
        this.f539264a = true;
        ((j) r100).a(this);
        return;
    }
}
