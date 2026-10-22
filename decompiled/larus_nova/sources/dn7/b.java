package dn7;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ik7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final an7.c f469364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bn7.a f469365b;

    public final int a() {
        bn7.a r100 = this.f469365b;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getAppId();
    }

    public b(an7.c r100) {
        this.f469364a = r100;
        an7.a r101 = r100.f4552a;
        if (r101 == null) goto L6;
        this.f469365b = r101.f4545b;
        return;
    }
}
