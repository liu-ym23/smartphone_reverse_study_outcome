package com.bytedance.ee.bear.bitable.load.workimpl;

import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends a {
    @Override // com.bytedance.ee.bear.bitable.load.AbsLoadWork
    public final void d() {
        m();
        this.f214441b.m();
    }

    public j(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        n(new BitableAppLoader(r100, r101), true);
        o(r100);
    }
}
