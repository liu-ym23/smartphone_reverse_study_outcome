package ev;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f474188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f474189c;

    public abstract void a();

    public c() {
        this.f474188b = true;
    }

    static {
    }

    public final void b(boolean r100) {
        if (this.f474188b != r100) goto L5;
        return;
    L5:
        this.f474188b = r100;
        if (r100 == false) goto L18;
        Boolean r101 = this.f474189c;
        if (r101 == null) goto L19;
        boolean r102 = r101.booleanValue();
        if (this.f474187a != r102) goto L13;
    L16:
        this.f474189c = null;
        return;
    L13:
        if (this.f474188b == true) goto L15;
        this.f474189c = Boolean.valueOf(r102);
        goto L16
    L15:
        this.f474187a = r102;
        a();
        goto L16
    L19:
        return;
    }
}
