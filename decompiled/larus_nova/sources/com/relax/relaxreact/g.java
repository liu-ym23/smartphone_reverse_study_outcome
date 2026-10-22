package com.relax.relaxreact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f405505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f405506e;

    public final f d() {
        f r100 = this.f405505d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("component");
        return null;
    }

    @Override // com.relax.relaxreact.o1
    public final boolean a(o1 r100) {
        Intrinsics.checkNotNullParameter(r100, "vnode");
        if (super.a(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.b(d()) == false) goto L7;
        return true;
    }

    @Override // com.relax.relaxreact.o1
    public final boolean b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        if (d() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public g(f r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "component");
        super(VNodeType.Component);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405505d = r100;
        this.f405506e = r101;
    }
}
