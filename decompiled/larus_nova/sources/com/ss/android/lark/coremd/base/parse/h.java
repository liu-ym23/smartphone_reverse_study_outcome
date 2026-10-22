package com.ss.android.lark.coremd.base.parse;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class h implements g {
    public h() {
    }

    public abstract List<g> e();

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Iterator<T> r101 = e().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g) r101.next()).a(r100);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Iterator<T> r101 = e().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g) r101.next()).b(r100);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Iterator<T> r101 = e().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g) r101.next()).c(r100);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Iterator<T> r101 = e().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g) r101.next()).d(r100);
        goto L4
    }
}
