package com.bytedance.kmp.ec.yata.store.redux;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements f<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<Object>[] f251813a;

    public g(f<Object>[] r100) {
        this.f251813a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.f
    public final Object a(Object r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        f<Object>[] r102 = this.f251813a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100 = r102[r104].a(r100, r101);
        r104 = r104 + 1;
        goto L3
    L5:
        return r100;
    }
}
