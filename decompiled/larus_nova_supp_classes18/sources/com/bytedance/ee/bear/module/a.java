package com.bytedance.ee.bear.module;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.a0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.bear.doc.resupdate.f;
import com.bytedance.ee.bear.doc.resupdate.f0;
import com.bytedance.ee.bear.doc.resupdate.g;
import com.bytedance.ee.bear.doc.resupdate.h;
import com.bytedance.ee.bear.doc.resupdate.i;
import com.bytedance.ee.bear.doc.resupdate.w;
import eu5.b;
import fo5.d;
import javax.inject.Inject;
import javax.inject.Singleton;
import jx4.e;
import l35.c;
import uy4.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Singleton
public final class a implements g {
    public final i a;
    public final boolean b;

    public final boolean hasInit() {
        return this.a.hasInit();
    }

    public final void i() {
        this.a.i();
    }

    public final void k() {
        if (this.a.hasInit() == true) goto L6;
        this.a.init(b.a);
        return;
    }

    @Inject
    public a() {
        boolean r0 = ((h) org.koin.java.a.a(h.class)).isEnable("ccm.resupdate.disable_gecko_download");
        this.b = r0;
        StringBuilder r1 = new StringBuilder("useNewResUpdate: ");
        r1.append(!r0);
        tt5.a.h("ResourceImpl", r1.toString());
        if (r0 == false) goto L5;
        this.a = w.e.a;
        return;
    L5:
        this.a = s.a.a;
    }

    public final void a() {
        k();
        this.a.a();
    }

    public final void g() {
        k();
        this.a.g();
    }

    public final e0 getResource() {
        k();
        return this.a.getResource();
    }

    public final boolean j() {
        k();
        return this.a.j();
    }

    public final void b(c r2) {
        this.a.b(r2);
    }

    public final void c(Context r2) {
        this.a.c(r2);
    }

    public final void h(f0 r2) {
        if (this.b == false) goto L6;
        k();
        this.a.h(r2);
        return;
    L6:
        if (hasInit() == false) goto L8;
        this.a.h(r2);
        return;
    L8:
        init(b.a);
    }

    public final void init(Context r2) {
        this.a.init(r2);
    }

    public final void d(EChannel r2, a0 r3) {
        this.a.d(r2, r3);
    }

    public final void e(EChannel r2, a0 r3) {
        this.a.e(r2, r3);
    }

    public final void f(Context r3, String r4, f r5) {
        e r0 = new e(r3);
        if (TextUtils.isEmpty(r4) == true) goto L6;
        d.c().scheduleDirect(new jx4.c(r0, r4, r5));
        return;
    }
}
