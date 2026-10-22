package com.bytedance.locallife.dito.performance;

import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.d0;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/performance/AbsPerformancePlugin;", "Lcom/bytedance/locallife/dito/core/d0;", "<init>", "()V", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPerformancePlugin implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DitoViewModel f258510a;

    public AbsPerformancePlugin() {
    }

    public abstract void g(DitoViewModel r100);

    public final DitoViewModel f() {
        DitoViewModel r100 = this.f258510a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("ditoViewMode");
        return null;
    }

    public final DitoDataCenter d() {
        return f().f258041g;
    }

    public final DitoFragment e() {
        return f().f258035a;
    }

    @Override // com.bytedance.locallife.dito.core.d0
    public String getName() {
        return getClass().getName();
    }

    @Override // com.bytedance.locallife.dito.core.d0
    public final void c(DitoViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoViewModel");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f258510a = r100;
        g(r100);
    }
}
