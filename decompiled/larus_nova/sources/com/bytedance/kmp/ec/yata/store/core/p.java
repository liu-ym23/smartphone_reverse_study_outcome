package com.bytedance.kmp.ec.yata.store.core;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p implements com.bytedance.kmp.ec.yata.store.redux.f<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.kmp.ec.yata.store.redux.f<l>> f251757a;

    public p(m r100) {
        Intrinsics.checkNotNullParameter(r100, "storeContext");
        this.f251757a = MapsKt.mapOf(TuplesKt.to("handle_dispatch_action", new h(r100)));
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.f
    public final l a(l r100, com.bytedance.kmp.ec.yata.store.redux.a r101) {
        l r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "oldState");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (this.f251757a.containsKey(r101.getType()) == false) goto L6;
        com.bytedance.kmp.ec.yata.store.redux.f<l> r103 = this.f251757a.get(r101.getType());
        Intrinsics.checkNotNull(r103);
        return r103.a(r102, r101);
    L6:
        return r102;
    }
}
