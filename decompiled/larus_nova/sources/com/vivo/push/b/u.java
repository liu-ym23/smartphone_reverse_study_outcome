package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class u extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f462263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f462264b;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    public final ArrayList<String> e() {
        return this.f462263a;
    }

    public final List<String> f() {
        return this.f462264b;
    }

    public u(int r100) {
        super(r100);
        this.f462263a = null;
        this.f462264b = null;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("content", this.f462263a);
        r100.a("error_msg", this.f462264b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462263a = r100.c("content");
        this.f462264b = r100.c("error_msg");
    }
}
