package com.bytedance.ee.bear.widget;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f239900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f239901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f239902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f239903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f239904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public uu5.d<String> f239905f;

    public interface a {
    }

    public final void c() {
        this.f239901b = false;
        this.f239902c = -1;
        this.f239903d = -1;
        uu5.d<String> r100 = this.f239905f;
        if (r100 == null) goto L6;
        r100.a();
        this.f239905f = null;
        return;
    }

    public final void a() {
        a r100 = this.f239900a;
        if (r100 == null) goto L6;
        ((h) r100).f239928a.D();
        return;
    }

    public b() {
        this.f239902c = -1;
        this.f239903d = -1;
    }

    public final void b(String r100) {
        if (this.f239905f != null) goto L5;
        this.f239905f = new uu5.d(300, new com.bytedance.ee.bear.widget.a(this));
    L5:
        uu5.d<String> r101 = this.f239905f;
        if (r101 == null) goto L9;
        r101.b(r100);
        return;
    }
}
