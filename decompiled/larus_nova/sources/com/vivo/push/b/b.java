package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f462222d;

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }

    public final void a(int r100) {
        this.f462221c = r100;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("sdk_clients", this.f462219a);
        r100.a("sdk_version", 356);
        r100.a("PUSH_REGID", this.f462220b);
        if (b() != 2007) goto L6;
        r100.a("PUSH_UNBIND_SOURCE_CODE", this.f462221c);
        return;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462219a = r100.a("sdk_clients");
        this.f462220b = r100.a("PUSH_REGID");
        if (b() != 2007) goto L6;
        this.f462221c = r100.b("PUSH_UNBIND_SOURCE_CODE", 1);
        return;
    }

    public b(boolean r100, String r101) {
        if (r100 == false) goto L4;
        int r102 = 2006;
    L5:
        super(r102, r101);
        this.f462221c = 1;
        this.f462222d = false;
        return;
    L4:
        r102 = 2007;
        goto L5
    }
}
