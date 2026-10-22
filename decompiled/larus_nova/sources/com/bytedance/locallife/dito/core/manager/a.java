package com.bytedance.locallife.dito.core.manager;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.dito.data.DitoNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f257962a;

    public a() {
        e r100 = new e();
        Intrinsics.checkNotNullParameter(r100, "defaultMergeStrategy");
        this.f257962a = r100;
    }

    @Override // com.bytedance.locallife.dito.core.manager.c
    public final d a(DitoNode r100) {
        Intrinsics.checkNotNullParameter(r100, "newNode");
        return this.f257962a;
    }

    @Override // com.bytedance.locallife.dito.core.manager.c
    public final void b(DitoNode r100, DitoNode r101, d r102) {
        Intrinsics.checkNotNullParameter(r101, "newNode");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r102.a(r100, r101);
    }
}
