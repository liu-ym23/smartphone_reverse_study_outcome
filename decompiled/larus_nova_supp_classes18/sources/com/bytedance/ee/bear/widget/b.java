package com.bytedance.ee.bear.widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public a a;
    public boolean b;
    public int c;
    public int d;
    public boolean e;
    public uu5.d<String> f;

    public interface a {
    }

    public final void c() {
        this.b = false;
        this.c = -1;
        this.d = -1;
        uu5.d<String> r0 = this.f;
        if (r0 == null) goto L6;
        r0.a();
        this.f = null;
        return;
    }

    public final void a() {
        a r0 = this.a;
        if (r0 == null) goto L6;
        ((h) r0).a.D();
        return;
    }

    public b() {
        this.c = -1;
        this.d = -1;
    }

    public final void b(String r5) {
        if (this.f != null) goto L5;
        this.f = new uu5.d(300, new com.bytedance.ee.bear.widget.a(this));
    L5:
        uu5.d<String> r0 = this.f;
        if (r0 == null) goto L9;
        r0.b(r5);
        return;
    }
}
