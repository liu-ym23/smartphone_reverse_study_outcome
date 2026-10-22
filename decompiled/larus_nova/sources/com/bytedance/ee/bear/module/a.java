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

/* JADX INFO: loaded from: classes18.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f234494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234495b;

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean hasInit() {
        return this.f234494a.hasInit();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void i() {
        this.f234494a.i();
    }

    public final void k() {
        if (this.f234494a.hasInit() == true) goto L6;
        this.f234494a.init(b.f474075a);
        return;
    }

    @Inject
    public a() {
        boolean r100 = ((h) org.koin.java.a.a(h.class)).isEnable("ccm.resupdate.disable_gecko_download");
        this.f234495b = r100;
        StringBuilder r101 = new StringBuilder("useNewResUpdate: ");
        r101.append(!r100);
        tt5.a.h("ResourceImpl", r101.toString());
        if (r100 == false) goto L5;
        this.f234494a = w.e.f218055a;
        return;
    L5:
        this.f234494a = s.a.f552125a;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void a() {
        k();
        this.f234494a.a();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void g() {
        k();
        this.f234494a.g();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final e0 getResource() {
        k();
        return this.f234494a.getResource();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean j() {
        k();
        return this.f234494a.j();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void b(c r100) {
        this.f234494a.b(r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void c(Context r100) {
        this.f234494a.c(r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void h(f0 r100) {
        if (this.f234495b == false) goto L6;
        k();
        this.f234494a.h(r100);
        return;
    L6:
        if (hasInit() == false) goto L8;
        this.f234494a.h(r100);
        return;
    L8:
        init(b.f474075a);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void init(Context r100) {
        this.f234494a.init(r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void d(EChannel r100, a0 r101) {
        this.f234494a.d(r100, r101);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void e(EChannel r100, a0 r101) {
        this.f234494a.e(r100, r101);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.g
    public final void f(Context r100, String r101, f r102) {
        e r103 = new e(r100);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        d.c().scheduleDirect(new jx4.c(r103, r101, r102));
        return;
    }
}
