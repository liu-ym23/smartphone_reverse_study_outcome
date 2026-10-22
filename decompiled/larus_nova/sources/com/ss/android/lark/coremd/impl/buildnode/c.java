package com.ss.android.lark.coremd.impl.buildnode;

import java.util.Comparator;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f419837a = null;

    static {
        f419837a = new c();
    }

    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        b.C4948b r102 = (b.C4948b) r100;
        b.C4948b r103 = (b.C4948b) r101;
        int r104 = r102.f419834b;
        int r105 = r103.f419834b;
        int r106 = r102.f419835c;
        int r107 = r103.f419835c;
        if (r104 == r105) goto L6;
        return r104 - r105;
    L6:
        return r107 - r106;
    }
}
