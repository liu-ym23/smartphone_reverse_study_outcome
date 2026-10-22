package com.samskivert.mustache;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends e.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f405770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f405771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e.c f405772f;

    @Override // com.samskivert.mustache.e.c
    public final h.d[] c() {
        throw new MustacheParseException("Inverted section missing close tag '" + this.f405770d + "'", this.f405771e);
    }

    @Override // com.samskivert.mustache.e.c
    public final e.c a(String r100, int r101) {
        e.c.e(this.f405770d, r100, r101);
        List<h.d> r102 = this.f405772f.f405733c;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new e.l(this.f405731a, r100, super.c(), this.f405771e));
        return this.f405772f;
    }

    public g(e.f r100, String r101, int r102, e.c r103) {
        this.f405770d = r101;
        this.f405771e = r102;
        this.f405772f = r103;
        super(r100, false);
    }
}
