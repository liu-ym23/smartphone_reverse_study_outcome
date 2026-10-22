package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class p implements q.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f274726a;

    public p(b.d r100) {
        this.f274726a = r100;
    }

    @Override // com.google.common.base.q.b
    public final Iterator a(q r100, CharSequence r101) {
        return new o(this, r100, r101);
    }
}
