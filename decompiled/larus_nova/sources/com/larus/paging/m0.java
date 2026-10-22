package com.larus.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0<Object> f363880a;

    public m0(n0<Object> r100) {
        this.f363880a = r100;
    }

    public final void b(LoadType r100) {
        u.c r101 = u.c.f363923c;
        Intrinsics.checkNotNullParameter(r100, "loadType");
        Intrinsics.checkNotNullParameter(r101, "loadState");
        x r102 = this.f363880a.f363893e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        v r103 = r102.f363941f;
        if (r103 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "loadType");
        int r104 = v.b.f363928a[r100.ordinal()];
        if (r104 != 1) goto L7;
        u r105 = r103.f363927c;
    L17:
        if (Intrinsics.areEqual(r105, r101) == false) goto L19;
        return;
    L19:
        x r106 = this.f363880a.f363893e;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "state");
        r106.f363936a = true;
        v r107 = r106.f363941f;
        v r108 = r107.b(r100);
        r106.f363941f = r108;
        Intrinsics.areEqual(r108, r107);
        r106.b();
        return;
    L7:
        if (r104 != 2) goto L9;
        r105 = r103.f363926b;
        goto L17
    L9:
        if (r104 != 3) goto L12;
        r105 = r103.f363925a;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    L15:
        r105 = null;
        goto L17
    }

    public final void a(int r100, int r101) {
        this.f363880a.f363889a.onInserted(r100, r101);
    }
}
