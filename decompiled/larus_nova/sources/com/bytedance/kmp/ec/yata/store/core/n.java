package com.bytedance.kmp.ec.yata.store.core;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements com.bytedance.kmp.ec.yata.store.redux.j<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.redux.j<Object>[] f251755a;

    public n(com.bytedance.kmp.ec.yata.store.redux.j<Object>[] r100) {
        this.f251755a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.j
    public final com.bytedance.kmp.ec.yata.store.redux.i<Object> a(com.bytedance.kmp.ec.yata.store.redux.i<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "storeCreator");
        com.bytedance.kmp.ec.yata.store.redux.j<Object>[] r101 = this.f251755a;
        int r102 = ArraysKt.getLastIndex(r101);
    L3:
        if (r102 < 0) goto L5;
        r100 = r101[r102].a(r100);
        r102 = r102 - 1;
        goto L3
    L5:
        return r100;
    }
}
