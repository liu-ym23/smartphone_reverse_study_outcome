package com.ss.android.lark.commonmark.internal;

import v7b.v;

/* JADX INFO: loaded from: classes35.dex */
public final class q extends y7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v7b.q f417265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f417266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f417267c;

    @Override // y7b.a, y7b.d
    public final boolean isContainer() {
        return true;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.f417265a;
    }

    @Override // y7b.a, y7b.d
    public final boolean g(v7b.a r100) {
        if (this.f417267c == false) goto L9;
        v7b.a r101 = (v7b.a) this.f417265a.f553568d;
        if ((r101 instanceof v7b.p) == false) goto L10;
        ((v7b.p) r101).getClass();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r100) {
        h r101 = (h) r100;
        boolean r102 = false;
        if (r101.f417213i == true) goto L5;
        int r103 = r101.f417212h;
        int r104 = this.f417266b;
        if (r103 >= r104) goto L17;
        return null;
    L17:
        return new b(-1, r101.f417208d + r104, false);
    L5:
        if (this.f417265a.f553569e != null) goto L7;
        return null;
    L7:
        v7b.a r105 = r101.h().a();
        if ((r105 instanceof v) == false) goto L10;
    L11:
        r102 = true;
    L12:
        this.f417267c = r102;
        return y7b.c.a(r101.f417210f);
    L10:
        if ((r105 instanceof v7b.q) == false) goto L12;
        goto L11
    }

    public q(int r100, int r101, Integer r102) {
        v7b.q r103 = new v7b.q();
        this.f417265a = r103;
        this.f417266b = r101;
        r103.f553566j = r102;
    }
}
