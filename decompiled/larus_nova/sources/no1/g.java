package no1;

/* JADX INFO: loaded from: classes8.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f519892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f519893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f519894c;

    public abstract void a();

    public g() {
        this.f519893b = true;
    }

    static {
    }

    public final void b(boolean r100) {
        if (this.f519893b != r100) goto L5;
        return;
    L5:
        this.f519893b = r100;
        if (r100 == false) goto L18;
        Boolean r101 = this.f519894c;
        if (r101 == null) goto L19;
        boolean r102 = r101.booleanValue();
        if (this.f519892a != r102) goto L13;
    L16:
        this.f519894c = null;
        return;
    L13:
        if (this.f519893b == true) goto L15;
        this.f519894c = Boolean.valueOf(r102);
        goto L16
    L15:
        this.f519892a = r102;
        a();
        goto L16
    L19:
        return;
    }
}
