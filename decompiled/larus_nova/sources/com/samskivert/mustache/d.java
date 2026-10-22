package com.samskivert.mustache;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements e.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[][] f405728a;

    public d(String[][] r100) {
        this.f405728a = r100;
    }

    @Override // com.samskivert.mustache.e.h
    public final String a(String r100) {
        String[][] r101 = this.f405728a;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        String[] r104 = r101[r103];
        r100 = r100.replace(r104[0], r104[1]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }
}
