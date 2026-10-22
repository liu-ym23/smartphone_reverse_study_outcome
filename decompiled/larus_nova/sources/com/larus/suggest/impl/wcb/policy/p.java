package com.larus.suggest.impl.wcb.policy;

import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f369990a = null;

    static {
        f369990a = new p();
    }

    public p() {
    }

    @Override // com.larus.suggest.impl.wcb.policy.b0
    public final a0 a(com.larus.suggest.impl.wcb.request.f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        com.larus.suggest.impl.wcb.request.c r102 = r100.f370118f;
        WcbRequestTrigger r103 = r102.f370100b;
        if (r103 != WcbRequestTrigger.REGENERATE) goto L7;
        return a0.c.f369959a;
    L7:
        if (r103 == WcbRequestTrigger.INITIAL) goto L9;
    L12:
        v r104 = r100.f370118f.f370099a.h().k(r100);
        if ((r104 instanceof v.a) == false) goto L16;
        return new a0.b(((v.a) r104).f370009a);
    L16:
        if (Intrinsics.areEqual(r104, v.b.f370010a) == false) goto L20;
        return a0.c.f369959a;
    L20:
        if ((r104 instanceof v.c) == false) goto L24;
        ((v.c) r104).getClass();
        Intrinsics.checkNotNullParameter(null, "reason");
        throw null;
    L24:
        throw new NoWhenBranchMatchedException();
    L9:
        if (r102.f370099a.getKey().f511242b != WcbMode.QUICK_EXPERT) goto L12;
        return a0.c.f369959a;
    }
}
