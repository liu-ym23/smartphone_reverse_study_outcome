package ru5;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f539253a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f539254a = null;

        static {
            f539254a = new c();
        }
    }

    @Override // ru5.d
    public final boolean isLandscape() {
        return true;
    }

    public final String toString() {
        return "LandscapeState{reverse=" + this.f539253a + '}';
    }

    public c() {
    }

    @Override // ru5.d
    public final boolean a() {
        return this.f539253a;
    }

    @Override // ru5.b
    public final void b(b.a r100, int r101) {
        if (r101 != (-1)) goto L6;
        return;
    L6:
        if (Math.abs(360 - r101) >= 20) goto L8;
    L23:
        i r102 = i.a.f539265a;
        r102.f539264a = false;
        ((j) r100).a(r102);
        return;
    L8:
        if (Math.abs(r101) < 20) goto L23;
        if (Math.abs(180 - r101) >= 20) goto L14;
        i r103 = i.a.f539265a;
        r103.f539264a = true;
        ((j) r100).a(r103);
        return;
    L14:
        if (this.f539253a == false) goto L19;
        if (Math.abs(270 - r101) >= 70) goto L19;
        this.f539253a = false;
        ((j) r100).a(this);
        return;
    L19:
        if (this.f539253a == false) goto L21;
        return;
    L21:
        if (Math.abs(90 - r101) >= 70) goto L28;
        this.f539253a = true;
        ((j) r100).a(this);
        return;
    }
}
