package vt3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f557196a;

    @Override // vt3.f
    public void c() {
        if (xu3.a.a() == false) goto L6;
        av3.b.d("APM-CPU", "stop detect when state is : " + b());
        return;
    }

    public a(d r100) {
        this.f557196a = r100;
    }

    @Override // vt3.f
    public void a(boolean r100) {
        if (xu3.a.a() == false) goto L6;
        av3.b.d("APM-CPU", "onLifeCycleChange when state is : " + b());
        return;
    }

    public final void e(String r100) {
        if (xu3.a.a() == false) goto L6;
        av3.b.d("APM-CPU", "[" + b() + "]: " + r100);
        return;
    }

    @Override // vt3.f
    public void d(ut3.c r100, boolean r101) {
        if (xu3.a.a() == false) goto L6;
        av3.b.d("APM-CPU", "enter : " + b());
        return;
    }
}
