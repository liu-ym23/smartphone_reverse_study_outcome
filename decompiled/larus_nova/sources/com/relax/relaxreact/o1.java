package com.relax.relaxreact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VNodeType f405552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f405553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f405554c;

    public boolean b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        return false;
    }

    public boolean c(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return false;
    }

    public final VNodeType getType() {
        return this.f405552a;
    }

    public o1(VNodeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f405552a = r100;
        this.f405553b = null;
        this.f405554c = null;
    }

    public boolean a(o1 r100) {
        Intrinsics.checkNotNullParameter(r100, "vnode");
        if (this.f405552a.getValue() == r100.f405552a.getValue()) goto L5;
    L14:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f405553b, r100.f405553b) == false) goto L14;
        String r101 = this.f405554c;
        String r102 = r100.f405554c;
        if (r101 == null) goto L11;
        if (r102 == null) goto L11;
        boolean r103 = Intrinsics.areEqual(r101, r102);
    L12:
        if (r103 == false) goto L14;
        return true;
    L11:
        r103 = Intrinsics.areEqual(r101, r102);
        goto L12
    }
}
