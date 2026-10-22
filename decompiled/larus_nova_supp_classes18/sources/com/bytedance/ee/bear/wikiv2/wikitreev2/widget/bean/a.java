package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Cloneable {
    public final String a;
    public final String b;
    public final String c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public final a a() {
        a r0 = new a();
        return (a) super.clone();
    L5:
        e = move-exception;
        tt5.a.e("Ns", "clone ns fail.", e, false);
        return r0;
    }

    public final String toString() {
        return "Ns{uid='" + yu5.c.j(this.a) + "', expand=" + this.d + ", level=" + this.e + '}';
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a() {
    }

    public a(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
