package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f241735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f241736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f241737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f241738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f241739h;

    public final a a() {
        a r100 = new a();
        return (a) super.clone();
    L5:
        e = move-exception;
        tt5.a.e("Ns", "clone ns fail.", e, false);
        return r100;
    }

    public final String toString() {
        return "Ns{uid='" + yu5.c.j(this.f241732a) + "', expand=" + this.f241735d + ", level=" + this.f241736e + '}';
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a() {
    }

    public a(String r100, String r101, String r102) {
        this.f241732a = r100;
        this.f241733b = r101;
        this.f241734c = r102;
    }
}
