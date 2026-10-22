package com.bytedance.locallife.dito.data;

import android.content.Context;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Context, m, BaseDitoView<?>> f258227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<DitoViewModel, m, BaseDitoModel<?>> f258228b;

    @Override // com.bytedance.locallife.dito.data.r
    public final Function2<DitoViewModel, m, BaseDitoModel<?>> a() {
        return this.f258228b;
    }

    @Override // com.bytedance.locallife.dito.data.r
    public final Function2<Context, m, BaseDitoView<?>> getCreateView() {
        return this.f258227a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function2<? super Context, ? super m, ? extends BaseDitoView<?>> r100, Function2<? super DitoViewModel, ? super m, ? extends BaseDitoModel<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "createView");
        Intrinsics.checkNotNullParameter(r101, "createModel");
        this.f258227a = r100;
        this.f258228b = r101;
    }
}
