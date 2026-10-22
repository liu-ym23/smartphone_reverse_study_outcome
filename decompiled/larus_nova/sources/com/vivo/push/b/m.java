package com.vivo.push.b;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f462242a;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    public m() {
        super(8);
    }

    public final ArrayList<String> e() {
        return this.f462242a;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("tags_list", this.f462242a);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462242a = r100.c("tags_list");
    }
}
