package io.opentelemetry.sdk.trace;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements jtc.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f492780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ltc.e f492781b;

    @Override // jtc.o
    public final jtc.j a(String r100) {
        if (r100 != null) goto L4;
    L5:
        r100 = "<unspecified span name>";
    L7:
        if (this.f492780a.f492802i == null) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        int r102 = jtc.e.f500392a;
        this.f492781b.c();
        int r103 = jtc.d.f500390a;
        return new jtc.d.a();
    L13:
        ltc.e r104 = this.f492781b;
        s r105 = this.f492780a;
        return new j(r100, r104, r105, r105.f492799f.get());
    L9:
        r101 = false;
        goto L10
    L4:
        if (r100.trim().isEmpty() == false) goto L7;
        goto L5
    }

    public k(s r100, ltc.e r101) {
        this.f492780a = r100;
        this.f492781b = r101;
    }
}
