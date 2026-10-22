package com.larus.vesdk.impl.utils;

import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements pq9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f375642a;

    public i(f r100) {
        this.f375642a = r100;
    }

    @Override // pq9.c
    public final void onResult(final boolean r100) {
        f r101 = this.f375642a;
        r101.f375626e = Boolean.valueOf(r100);
        if (this.f375642a.f375627f.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = this.f375642a.f375627f.size();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        final pq9.c r105 = this.f375642a.f375627f.get(r104);
        t0.e(new h(r105, r100));
        if ((r105 instanceof pq9.d) == false) goto L10;
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        CopyOnWriteArrayList<pq9.c> r106 = this.f375642a.f375627f;
        Set r107 = CollectionsKt.toSet(r102);
        TypeIntrinsics.asMutableCollection(r106).removeAll(r107);
    }
}
